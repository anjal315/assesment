package com.bookmanagment.assessment.bookmanagment.book;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    @Test
    private BookRepository bookRepository;

    private BookService bookService;

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }




}