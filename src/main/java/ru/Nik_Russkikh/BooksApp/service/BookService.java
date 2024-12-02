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

    public Mono<Book> findBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Flux<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Flux<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Mono<Book> updateBook(Integer id, Book book) {
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

    public Mono<Void> deleteById(Integer id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Void> deleteAllBooks() {
        return bookRepository.deleteAll();
    }

//    public Mono<Book> updateBooks(Integer id, Book book){
//        return bookRepository.findById(id)
//                .flatMap(s->{
//                    book.setId(s.getId());
//                    return bookRepository.save(book);
//                });
//    }

//    public Flux<Book> findBookByName(String name) {
//        return (name!=null) ? bookRepository.findByName(name) : bookRepository.findAll();
//    }
    //    public Mono<Void> delete(Book book) {
//        return template.delete(book).then();
//    }

}
