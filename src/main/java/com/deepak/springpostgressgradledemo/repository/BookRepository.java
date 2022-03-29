package com.deepak.springpostgressgradledemo.repository;

import com.deepak.springpostgressgradledemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
