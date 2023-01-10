package com.protein.bookapp.controller;

import com.protein.bookapp.service.BookService;
import com.protein.bookapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookservice")
public class BookController {

    @Autowired
    private BookService bookService;

    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
}
