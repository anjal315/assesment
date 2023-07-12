package com.edstem.book.controller;

import com.edstem.book.exception.UserNotFoundException;
import com.edstem.book.model.Book;
import com.edstem.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<Book> retrieveAllBook() {
        return service.findAll();
    }

    @GetMapping("/books/{id}")
    public Book retrieveBook(@PathVariable int id) {
        Book book = service.findOne(id);

        if (book == null) {
            throw new UserNotFoundException("id:" + id);
        }
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        service.deleteById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = service.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
