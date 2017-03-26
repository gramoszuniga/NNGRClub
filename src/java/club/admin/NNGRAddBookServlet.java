/*  
    Document   : NNGRAddBookServlet
    Created on : Feb 26, 2016, 6:39:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRAddBookServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NNGRAddBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NNGRAddBookServlet at "
                    + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String url;

        if (request.getParameter("cancel") != null) {
            url = "/NNGRDisplayBooks";
        } else {
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Book book = new Book(code, description, quantity);

            String message = "";
            if (code == null || code.trim().equals("")) {
                message += "Book code is required.<br>";
            }
            if (description == null || description.trim().length() < 2) {
                message += "Description must have at least 2 characters.<br>";
            }
            if (quantity < 1) {
                message += "Quantity must be a positive number.<br>";
            }

            if (!message.equals("")) {
                request.setAttribute("message", message);
                request.setAttribute("book", book);
                url = "/NNGRAddBook.jsp";
            } else {
                String realPath = context.getRealPath("/WEB-INF/books.txt");
                BookIO.insert(book, realPath);
                url = "/NNGRDisplayBooks";
            }
        }

        context.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
