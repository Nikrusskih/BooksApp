package ru.Nik_Russkikh.BooksApp.repository;


import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.Nik_Russkikh.BooksApp.model.Book;

public interface BookRepository extends R2dbcRepository<Book, Long> {

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByTitle(String title);
}
