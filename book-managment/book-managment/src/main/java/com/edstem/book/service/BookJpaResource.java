package com.edstem.book.service;

import com.edstem.book.exception.UserNotFoundException;
import com.edstem.book.repository.BookRepository;
import com.edstem.book.model.Book;
import com.edstem.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class BookJpaResource {
    private BookRepository repository;

    public BookJpaResource(BookService service, BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> retrieveAllBook() {
        return repository.findAll();
    }

    public Optional<Book> retrieveBook(@PathVariable int id) {
        Optional<Book> book = repository.findById(id);

        if (book.isEmpty())
            throw new UserNotFoundException("id:" + id);
        return book;
    }

    public void deleteBook(@PathVariable int id) {
        repository.deleteById(id);
    }

    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }
}
