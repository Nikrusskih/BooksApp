package ru.Nik_Russkikh.BooksApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.Nik_Russkikh.BooksApp.model.Book;

@Service
//@RequiredArgsConstructor
public class DefaultBookService implements BookService {

//    private final BookRepository bookRepository;

    private final Map<Integer, Book> BOOK_REPOSITORY_MAP = new HashMap<>();
    private final AtomicInteger BOOK_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(@NonNull Book book) {
        final Integer bookId = BOOK_ID_HOLDER.incrementAndGet();
        book.setId(bookId);
        BOOK_REPOSITORY_MAP.put(bookId, book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(BOOK_REPOSITORY_MAP.values());
    }

    @Override
    public List<Book> getAllAuthors() {
        return new ArrayList<>();
    }

    @Override
    public Book findBookByAuthor(@NonNull int id) {
        return BOOK_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean updateBook(Book book, int id) {
        if (BOOK_REPOSITORY_MAP.containsKey(id)) {
            book.setId(id);
            BOOK_REPOSITORY_MAP.put(id, book);
        }
        return false;
    }

    @Override
    public boolean deleteBook(@NonNull int id) {
        return BOOK_REPOSITORY_MAP.remove(id) != null;
    }
}
