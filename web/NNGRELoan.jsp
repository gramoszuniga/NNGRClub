<%-- 
    Document   : NNGRELoan
    Created on : Mar 17, 2016, 6:40:06 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="NNGRBanner.jsp" />
<section>
    <table>
        <th>
            Code
        </th>
        <th>
            Description
        </th>
        <th>
            QOH
        </th>
        <th>
            Action
        </th>
        <c:forEach var="loan" items="${applicationScope.loanItems}">
            <tr>
                <td>
                    ${loan.code}
                </td>
                <td>
                    ${loan.description}
                </td>
                <td>
                    ${loan.quantity}
                </td>
                <td>
                    <c:if test="${loan.quantity==0}">
                        <p>N/A</p>
                    </c:if>
                    <c:if test="${loan.quantity>0}">
                        <a href="<c:url value=
                           '/NNGRCart?action=reserve&code=${loan.code}'/>">
                        Reserve</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="NNGRFooter.jsp" />