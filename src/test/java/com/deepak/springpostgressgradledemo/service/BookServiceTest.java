package com.deepak.springpostgressgradledemo.service;

import com.deepak.springpostgressgradledemo.model.Book;
import com.deepak.springpostgressgradledemo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.List;

import static com.deepak.springpostgressgradledemo.utils.BooksDataUtils.getBookList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class, OutputCaptureExtension.class})
class BookServiceTest {

    @Mock
    BookRepository bookRepositoryMock;

    BookService bookService;

    @Captor
    ArgumentCaptor<Book> bookArgumentCaptor;

    @BeforeEach
    public void setUp(){
        bookService = new BookService(bookRepositoryMock);
    }


    @Test
    @DisplayName("Get books test")
    void getBooks(CapturedOutput output) {

        List<Book> books = getBookList();

        when(bookRepositoryMock.findAll()).thenReturn(books);

        final List<Book> bookList = bookService.getBooks();

        assertThat(bookList.size()).isEqualTo(2);

        //Verify interactions
       verify(bookRepositoryMock, times(1)).findAll();

    }

    @Test
    @DisplayName("Create book test")
    void createBook() {

        final Book bookToBeCreated = new Book();
        bookToBeCreated.setId(2);
        bookToBeCreated.setGenre("Non Fiction");
        bookToBeCreated.setTitle("The 5 AM Club");
        bookToBeCreated.setPublished(true);

        when(bookRepositoryMock.saveAndFlush(any())).thenReturn(bookToBeCreated);

        var bookOutput = bookService.createBook(bookToBeCreated);

        assertThat(bookOutput.getId()).isEqualTo(2);

        //Verify interactions
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(bookRepositoryMock, times(1)).saveAndFlush(bookArgumentCaptor.capture());

        final Book value = bookArgumentCaptor.getValue();

        assertThat(value.getGenre()).isEqualTo("Non Fiction");


    }
}