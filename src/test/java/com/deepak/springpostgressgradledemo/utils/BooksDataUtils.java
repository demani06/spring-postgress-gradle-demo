package com.deepak.springpostgressgradledemo.utils;

import com.deepak.springpostgressgradledemo.model.Book;

import java.util.List;

public class BooksDataUtils {

    public static List<Book> getBookList() {
        Book book1 = new Book();
        book1.setGenre("Fiction");
        book1.setPublished(false);
        book1.setTitle("Davinci Code");
        book1.setId(3);

        Book book2 = new Book();
        book2.setGenre("Non Fiction");
        book2.setPublished(false);
        book2.setTitle("The life of Yogi");
        book2.setId(332);

        return List.of(book1,book2);
    }
}
