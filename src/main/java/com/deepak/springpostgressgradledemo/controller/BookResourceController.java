package com.deepak.springpostgressgradledemo.controller;

import com.deepak.springpostgressgradledemo.model.Book;
import com.deepak.springpostgressgradledemo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookResourceController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Getting all books");
        final var books = bookService.getBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("Creating a book");


        //TODO Validate Input request
        //If Invalid request, return 400

        final Book bookResponse = bookService.createBook(book);


        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);

    }

}
