package ru.Nik_Russkikh.BooksApp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.Nik_Russkikh.BooksApp.model.Author;
import ru.Nik_Russkikh.BooksApp.model.Book;
import ru.Nik_Russkikh.BooksApp.repository.AuthorRepository;

public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Mono<Author> save(Author author) {
        return authorRepository.save(author);
    }

    public Flux<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Mono<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Flux<Author> findByAuthor(String author) {
        return authorRepository.findByAuthor(author);
    }

    public Mono<Author> updateAuthor(Long id, Author author) {
        return authorRepository.findById(id)
                .map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalAuthor -> {
                    if (optionalAuthor.isPresent()) {
                        author.setId(id);
                        return authorRepository.save(author);
                    }
                    return Mono.empty();
                });
    }

}
