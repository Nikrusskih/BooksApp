package ru.Nik_Russkikh.BooksApp.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Nik_Russkikh.BooksApp.model.Book;
import ru.Nik_Russkikh.BooksApp.service.BookService;

@RestController
@RequestMapping("/books")
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Book book) {
        log.debug("[create] create={}",book);
        bookService.create(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getBookList() {
        final List<Book> books = bookService.getAllBooks();
        if (books != null && !books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Book> findBookByAuthor(@PathVariable("id") int id) {
        final Book book = bookService.findBookByAuthor(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/list/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        final boolean update = bookService.updateBook(book, id);
        if (update) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
        final boolean delete = bookService.deleteBook(id);
        if (delete) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
