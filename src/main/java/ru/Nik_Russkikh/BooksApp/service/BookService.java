package ru.Nik_Russkikh.BooksApp.service;

import java.util.List;
import ru.Nik_Russkikh.BooksApp.model.Book;

public interface BookService {

    void create(Book book);

    List<Book> getAllBooks();

    List<Book> getAllAuthors();

    Book findBookByAuthor(int id);

    boolean updateBook(Book book, int id);

    boolean deleteBook(int id);
}
