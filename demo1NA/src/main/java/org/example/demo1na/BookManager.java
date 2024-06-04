package org.example.demo1na;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == updatedBook.getId()) {
                book.setName(updatedBook.getName());
                book.setPrice(updatedBook.getPrice());
                book.setDescription(updatedBook.getDescription());
                book.setAuthor(updatedBook.getAuthor());
                break;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
