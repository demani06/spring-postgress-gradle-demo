package com.deepak.springpostgressgradledemo.service;

import com.deepak.springpostgressgradledemo.model.Book;
import com.deepak.springpostgressgradledemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }
}
