package org.example.bookapp.models;

import org.example.bookapp.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private List<Book> books = new ArrayList<>();

    public BookModel(){
        Book b1 = new Book(1,"One Piece","Eiichiro Oda","Manga",25000);
        Book b2 = new Book(2,"The Lord of the Rings","J. R. R. Tolkien","Novels", 560000);
        Book b3 = new Book(3,"The Hobbit","J. R. R. Tolkien","Novels", 350000);
        Book b4 = new Book(4,"Dragon Balls", "Akira Torirama", "Manga",25000);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
    }
    public List<Book> getAllBook() {
        return this.books;
    }
    public void save(Book book) {
        this.books.add(book);
    }

    public void delete(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void update(int id, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == id) {
                books.set(i, updatedBook);
                return;
            }
        }
    }
}
