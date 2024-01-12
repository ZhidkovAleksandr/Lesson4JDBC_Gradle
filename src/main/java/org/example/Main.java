package org.example;

import Entity.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Berserk", "Kentaro Miura");
        Book book1 = new Book("Кобзар", "Тарас Шевченко");

        BookHelper bh = new BookHelper();

        bh.addBook(book);
        bh.addBook(book1);

        Book bq1 = bh.getById(1);

        System.out.println("getting from id: " + bq1);

        List<Book> bookList = bh.getAllBooks();

        for (Book b:bookList) {
            System.out.println(b);
        }

    }
}