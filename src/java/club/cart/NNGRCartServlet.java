/*  
    Document   : NNGRCartServlet
    Created on : Mar 18, 2016, 8:39:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        ArrayList<Book> loanItems = (ArrayList<Book>) context.
                getAttribute("loanItems");
        HttpSession session = request.getSession();
        ECart cart = (ECart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ECart();
        }
        String action = request.getParameter("action");
        String code = request.getParameter("code");
        if (action != null && action.equals("reserve")) {
            Book book = ELoan.findItem(loanItems, code);
            if (ELoan.getQOH(loanItems, code) > 0) {
                cart.addItem(book);
		ELoan.subtractFromQOH(loanItems, code, 1);
            }            
        }
        session.setAttribute("cart", cart);
        context.getRequestDispatcher("/NNGRECart.jsp").forward(request,
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
