package com.edstem.book.service;

import com.edstem.book.contract.BookDto;
import com.edstem.book.exception.BookNotFoundException;
import com.edstem.book.model.Book;
import com.edstem.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = this.bookRepository.findAll();
        return books.stream().map(book -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    public BookDto getBookById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> {
            log.error("Book with id: {} not found", id);
            return new BookNotFoundException(id);
        });
        return modelMapper.map(book, BookDto.class);
    }

    public BookDto addBook(BookDto book) {
        Book bookEntity = modelMapper.map(book, Book.class);
        Book savedBook = bookRepository.save(bookEntity);
        return modelMapper.map(savedBook, BookDto.class);
    }

    public BookDto updateBookById(int id, BookDto book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> {
            log.error("Book with id: {} not found", id);
            return new BookNotFoundException(id);
        });
        modelMapper.map(book, existingBook);
        Book updatedBook = bookRepository.save(existingBook);
        return modelMapper.map(updatedBook, BookDto.class);
    }

    public void deleteBookById(int id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

}
