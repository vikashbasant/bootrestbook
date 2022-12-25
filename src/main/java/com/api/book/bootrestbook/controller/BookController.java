package com.api.book.bootrestbook.controller;


import java.util.List;

import com.api.book.bootrestbook.model.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // get all books handler
    @GetMapping(value="/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    // get single book handler
    @GetMapping(value="/books/{id}")
    public Book getMethodName(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // create a new book handler
    @PostMapping("/save")
    public Book addBook(@RequestBody Book book) {
        Book addedBook = this.bookService.addBook(book);
        System.out.println(addedBook);
        return addedBook;
    }


    // delete book handler
    @DeleteMapping("/delete/{id}")
    public Book deleteBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return book;
    }

    // update book handler
    @PutMapping("/update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        bookService.updateBook(book, id);
        return book;
    }
}
