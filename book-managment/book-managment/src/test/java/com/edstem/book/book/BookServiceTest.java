package com.edstem.book.book;

import com.edstem.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class BookServiceTest {
    @Test
    private BookRepository bookRepository;

    private BookService bookService;

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }




}