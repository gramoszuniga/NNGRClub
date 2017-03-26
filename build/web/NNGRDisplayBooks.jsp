<%-- 
    Document   : NNGRDisplayBooks
    Created on : Feb 16, 2016, 6:45:08 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>List of Books</h1>
    <table>
        <tr>
            <th>
                Code
            </th>
            <th>
                Description
            </th>
            <th>
                Quantity
            </th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>
                    ${book.code}
                </td>
                <td>
                    ${book.description}
                </td>
                <td>
                    ${book.quantity}
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="NNGRAddBook.jsp" method="POST">
        <input type="submit" name="addBook"
               value="Add Book">
    </form>
</section>
<jsp:include page="NNGRFooter.jsp"/>