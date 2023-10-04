package com.minimal.bms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimal.bms.entity.Book;
import com.minimal.bms.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class EndpointController {

    // GET http://localhost:8080/books
    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooksEndpoint(){

        try {
            // Call getBooks method
            List<Book> books = new ArrayList<>(BookService.getBooks().values());
            // Return a success response
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    // PUT http://localhost:8080/books/{isbn}
    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<String> updateBookEndpoint(@PathVariable String isbn, @RequestBody String bookJson) {
        try {
            // Deserialize the incoming JSON to a Book object
            ObjectMapper objectMapper = new ObjectMapper();
            Book updatedBook = objectMapper.readValue(bookJson, Book.class);

            // Call updateBook method
            BookService.updateBook(updatedBook);

            // Return a success response
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        } catch (JsonProcessingException jpe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid JSON: " + jpe.getMessage(), jpe);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    // DELETE http://localhost:8080/books/{isbn}
    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity<String> deleteBookEndpoint(@PathVariable String isbn) {
        try {
            // Call deleteBook method
            BookService.deleteBook(isbn);

            // Return a success response
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }


    // POST http://localhost:8080/books/new
    @PostMapping(path = "/books/new")
    public ResponseEntity<String> addBookEndpoint(@RequestBody String bookJson) {
        try {
            // Deserialize the incoming JSON to a Book object
            ObjectMapper objectMapper = new ObjectMapper();
            Book newBook = objectMapper.readValue(bookJson, Book.class);

            // Call addBook method
            BookService.addBook(newBook);

            // Return a success response
            return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
        } catch (JsonProcessingException jpe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid JSON: " + jpe.getMessage(), jpe);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
