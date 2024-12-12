package ru.Nik_Russkikh.BooksApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import ru.Nik_Russkikh.BooksApp.model.Author;
import ru.Nik_Russkikh.BooksApp.model.Book;
import ru.Nik_Russkikh.BooksApp.service.AuthorService;

@Tag(name = "AppBooks", description = "Book management APIs")
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    AuthorService authorService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Author> createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Author> getAllAuthors(@RequestParam(required = false) String author) {
        if (author != null) {
            return authorService.findByAuthor(author);
        }
        return authorService.findAllAuthors();
    }

    @GetMapping("/list/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Author> findBookById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping("/list/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Author> findByAuthor(@PathVariable("author") String author) {
        return authorService.findByAuthor(author);
    }

    @PutMapping("/list/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

}
