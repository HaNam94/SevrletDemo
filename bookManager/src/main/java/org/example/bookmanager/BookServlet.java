package org.example.bookmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "bookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("book", bookManager.getBooks());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String author = req.getParameter("author");
            bookManager.addBook(new Book(0, name, price, description, author));
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String author = req.getParameter("author");
            bookManager.updateBook(new Book(id, name, price, description, author));
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            bookManager.deleteBook(id);
        }
        resp.sendRedirect("book");
    }
}
