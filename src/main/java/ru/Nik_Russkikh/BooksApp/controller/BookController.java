package ru.Nik_Russkikh.BooksApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.Nik_Russkikh.BooksApp.model.Book;
import ru.Nik_Russkikh.BooksApp.service.BookService;

@CrossOrigin(origins = "http://Localhost:8080")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Book> getAllBooks(@RequestParam(required = false) String title) {
        if (title != null) {
            return bookService.findBookByTitle(title);
        }
        return bookService.findAllBooks();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> findBookById(@PathVariable("id") int id) {
        return bookService.findBookById(id);
    }

//    @GetMapping("/list/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public Flux<Book> findBookByName(@PathVariable("name") String name) {
//        return bookService.findBookByName(name);
//    }

    @GetMapping("/list/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Book> findBookByTitle(@PathVariable("title") String title) {
        return bookService.findBookByTitle(title);
    }

    @PutMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/list/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBook(@PathVariable("id") int id) {
        return bookService.deleteById(id);
    }

    @DeleteMapping("/list")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllBooks() {
        return bookService.deleteAllBooks();
    }
}

