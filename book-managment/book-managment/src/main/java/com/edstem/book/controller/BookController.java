package com.edstem.book.controller;

import com.edstem.book.contract.BookResponse;
import com.edstem.book.model.Book;
import com.edstem.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> retrieveAllBook() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> getMovieById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
    @PostMapping("/books")
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book) {
        BookResponse movieResponse = bookService.addBook(book);
        return new ResponseEntity<>(movieResponse, HttpStatus.CREATED);
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<BookResponse> updateBookById(@PathVariable int id, @RequestBody Book book) {
        BookResponse updatedMovie = bookService.updateBookById(id, book);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book with ID " + id + " has been deleted.");
    }












//
//    @DeleteMapping("/books/{id}")
//    public void deleteBook(@PathVariable int id) {
//        repository.deleteById(id);
//    }
//
//    @PostMapping("/books")
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        Book savedBook = repository.save(book);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedBook.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
}
