package com.protein.bookapp.dao;


import com.protein.bookapp.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Book> getBooks() {
        String hql = "From Book as atcl order by atcl.id";
        return (List<Book>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Book getBook(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Book createBook(Book book) {
        entityManager.persist(book);
        Book b = getLastInsertedBook();
        return b;
    }

    private Book getLastInsertedBook() {
        String hql = "From Book order by id DESC";
        Query query = entityManager.createQuery(hql);
        query.setMaxResults(1);
        Book book = (Book) query.getSingleResult();
        return book;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book bk = getBook(id);
        bk.setAuthor(book.getAuthor());
        bk.setName(book.getName());
        bk.setPrice(book.getPrice());
        entityManager.flush();

        Book updatedBook = getBook(id);
        return updatedBook;

    }

    @Override
    public boolean deleteBook(int id) {
        Book bk = getBook(id);
        entityManager.remove(bk);
        boolean status = entityManager.contains(bk);
        if (status) {
            return false;
        } else return true;
    }
}
