package com.edstem.book.validation.isbn;

import com.edstem.book.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsbnValidator implements ConstraintValidator<ValidIsbn, Long> {

    private final BookRepository bookRepository;

    public IsbnValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isValid(Long isbn, ConstraintValidatorContext constraintValidatorContext) {
        String isbnString = String.valueOf(isbn);
        return !bookRepository.existsByIsbn(isbn);
    }
}
