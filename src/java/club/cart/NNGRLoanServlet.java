/*  
    Document   : NNGRLoanServlet
    Created on : Mar 17, 2016, 7:39:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.cart;

import club.business.Book;
import club.business.ELoan;
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
public class NNGRLoanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        ArrayList<Book> loanItems = (ArrayList<Book>) context.
                getAttribute("loanItems");

        if (loanItems == null) {
            String path = context.getRealPath("/WEB-INF/books.txt");
            loanItems = ELoan.loadItems(path);
        }

        context.setAttribute("loanItems", loanItems);
        context.getRequestDispatcher("/NNGRELoan.jsp").
                forward(request, response);
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
