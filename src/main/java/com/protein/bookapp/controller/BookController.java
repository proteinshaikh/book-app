package com.protein.bookapp.controller;

import com.protein.bookapp.service.BookService;
import com.protein.bookapp.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("bookservice")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();
        log.debug("inside BookController.getBooks()");
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBook(id);
        log.debug("inside BookController.getBookById()");
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book b = bookService.createBook(book);
        log.debug("inside BookController.createBook()");
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        Book b = bookService.updateBook(id, book);
        log.debug("inside BookController.updateBook()");
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") int id) {
        boolean isDeleted = bookService.deleteBook(id);
        log.debug("inside BookController.updateBook()");
        if (isDeleted) {
            String responseDeleted = "Book has been deleted";
            return new ResponseEntity<String>(responseDeleted, HttpStatus.OK);
        } else {
            String responseNotDeleted = "Book has not been deleted";
            return new ResponseEntity<String>(responseNotDeleted, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
