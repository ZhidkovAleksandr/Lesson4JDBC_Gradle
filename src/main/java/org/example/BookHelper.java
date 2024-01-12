package org.example;

import Entity.Book;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper(){
        sessionFactory = HibUtil.getSessionFactory();
    }

    public List<Book> getAllBooks(){

        List<Book> books = new ArrayList<>();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> rootEntry = cq.from(Book.class);
        CriteriaQuery<Book> all = cq.select(rootEntry);

        TypedQuery<Book> allQuery = session.createQuery(all);
        return allQuery.getResultList();


    }

    public Book getById(int id){
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        return book;

    }

    public void addBook(Book book){

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
        System.out.println("Book "+ book.getId() + " has added");

    }

}
