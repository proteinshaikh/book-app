package com.protein.bookapp.dao;

import com.protein.bookapp.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBooks();

    Book getBook(int id);

    Book createBook(Book book);

    Book updateBook(int id, Book book);

    boolean deleteBook(int id);
}
