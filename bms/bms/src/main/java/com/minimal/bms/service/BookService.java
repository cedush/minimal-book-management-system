package com.minimal.bms.service;


import com.minimal.bms.entity.Book;

import java.util.*;

public class BookService {

    static Hashtable<String, Book> bookTable = new Hashtable<>();

    public static Hashtable<String, Book> getBooks(){
        return bookTable;
    }

    public static void addBook(Book book) {
        bookTable.put(book.getIsbn(), book);
    }

    public static void deleteBook(String isbn) throws Exception {
        if (bookTable.containsKey(isbn)) {
            bookTable.remove(isbn);
        } else {
            throw new Exception("Book with ISBN " + isbn + " not found.");
        }
    }

    public static void updateBook(Book newBook) throws Exception {
        String isbnToUpdate = newBook.getIsbn();
        if (bookTable.containsKey(isbnToUpdate)) {
            bookTable.put(isbnToUpdate, newBook);
        } else {
            throw new Exception("Book with ISBN " + isbnToUpdate + " not found.");
        }
    }
}
