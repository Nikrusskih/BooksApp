package ru.Nik_Russkikh.BooksApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    Integer id;
    String author;
    String title;


}
