package com.bookmanagment.assessment.bookmanagment.book;

import com.bookmanagment.assessment.bookmanagment.book.jpa.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class BookJpaResource {
    private BookService service;
    private BookRepository repository;
    public BookJpaResource(BookService service, BookRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @GetMapping("/jpa/books")
    public List<Book> retrieveAllBook() {
        return repository.findAll();
    }
    @GetMapping("/jpa/books/{id}")
    public Optional<Book> retrieveBook(@PathVariable int id) {
        Optional<Book> book = repository.findById(id);

        if(book.isEmpty())
            throw new UserNotFoundException("id:" + id);
        return book;
    }
    @DeleteMapping("/jpa/books/{id}")
    public void deleteBook(@PathVariable int id) {
        repository.deleteById(id);
    }
    @PostMapping("/jpa/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = repository.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
