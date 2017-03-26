/*  
    Document   : NNGRDisplayBooksServlet
    Created on : Feb 16, 2016, 5:45:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRDisplayBooksServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/WEB-INF/books.txt");
        ArrayList<Book> books = BookIO.getBooks(realPath);
        request.setAttribute("bookList", books);
        context.getRequestDispatcher("/NNGRDisplayBooks.jsp").forward(request,
                response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
