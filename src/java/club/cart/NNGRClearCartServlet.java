/*  
    Document   : NNGRClearCartServlet
    Created on : Mar 18, 2016, 10:39:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRClearCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ECart cart = (ECart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ECart();
        }
        ArrayList<Book> loanItems = (ArrayList<Book>) 
                this.getServletContext().getAttribute("loanItems");
        ArrayList<Book> cartItems = cart.getItems();
        for (Book cartItem : cartItems) {
            ELoan.addToQOH(loanItems, cartItem.getCode(),
                    cartItem.getQuantity());
        }
        cart = null;
        request.getSession().setAttribute("cart", cart);
        this.getServletContext().getRequestDispatcher("/NNGRECart.jsp").
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
