package ru.Nik_Russkikh.BooksApp.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.Nik_Russkikh.BooksApp.model.Author;

public interface AuthorRepository extends R2dbcRepository<Author, Long> {

    Flux<Author> findByAuthor(String author);

}
