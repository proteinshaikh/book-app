package com.protein.bookapp.service;

import com.protein.bookapp.dao.BookDAOImpl;
import com.protein.bookapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements BooksService {


    @Autowired
    private BookDAOImpl dao;

    @Override
    public List<Book> getBooks() {
        return dao.getBooks();
    }

    @Override
    public Book createBook(Book book) {
        return dao.createBook(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        return dao.updateBook(id, book);
    }

    @Override
    public Book getBook(int id) {
        return dao.getBook(id);
    }

    @Override
    public boolean deleteBook(int id) {
        return dao.deleteBook(id);
    }
}
