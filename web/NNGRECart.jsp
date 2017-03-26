<%-- 
    Document   : NNGRECart
    Created on : Mar 18, 2016, 9:18:48 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="NNGRBanner.jsp" />
<section>
    <table>
        <tr >
            <th colspan="3" style="text-align: center">
                Your Loan Cart
            </th>
        </tr>
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
        <c:set var="total" value="${0}"/>
        <c:forEach var="item" items="${sessionScope.cart.items}">
            <tr>
                <td>
                    ${item.code}
                </td>
                <td>
                    ${item.description}
                </td>
                <td style="text-align: right">
                    ${item.quantity}
                </td>
            </tr>
            <c:set var="total" value="${total+item.quantity}"/>
        </c:forEach>
        <tr>
            <td></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: right">
                Total:
            </td>
            <td style="text-align: right">
                ${total}
            </td>
        </tr>
        <tr>
            <td></td>
        </tr>
    </table>
    <p><a href="NNGRClearCart">Clear the cart</a></p>
    <p><a href="NNGRLoan">Return to eLoan</a></p>    
</section>
<jsp:include page="NNGRFooter.jsp" />