package com.protein.bookapp.service;

import com.protein.bookapp.entity.Book;

import java.util.List;

public interface BooksService {

    List<Book> getBooks();
    Book createBook(Book book);
    Book updateBook(int id, Book book);
    Book getBook(int id);
    boolean deleteBook(int id);
}
