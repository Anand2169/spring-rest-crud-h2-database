package com.bigil.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigil.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable> {

}
