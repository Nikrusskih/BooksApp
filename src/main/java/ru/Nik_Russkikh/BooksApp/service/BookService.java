package ru.Nik_Russkikh.BooksApp.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.Nik_Russkikh.BooksApp.model.Book;
import ru.Nik_Russkikh.BooksApp.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> save(Book book) {
        return bookRepository.save(book);
    }

    public Flux<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Flux<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Mono<Book> updateBook(Long id, Book book) {
        return bookRepository.findById(id)
                .map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalBook -> {
                    if (optionalBook.isPresent()) {
                        book.setId(id);
                        return bookRepository.save(book);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(Long id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Void> deleteAllBooks() {
        return bookRepository.deleteAll();
    }

}
