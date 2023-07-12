package com.bookmanagment.assessment.bookmanagment.book.jpa;

import com.bookmanagment.assessment.bookmanagment.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface BookRepository extends JpaRepository<Book, Integer> {

    }

