<%-- 
    Document   : NNGRAddBook
    Created on : Feb 26, 2016, 6:07:53 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>Add a Book</h1>

    <c:if test="${message != null}">
        <p style="color: red">
            <i>${message}</i>
        </p>
    </c:if>

    <form action="NNGRAddBook" method="post">
        <table>
            <tr>
                <td>
                    <label>Code:</label>
                </td>
                <td>
                    <input type="text" name="code" 
                           value="${book.code}" style="width:200px"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Description:</label>
                </td>
                <td>
                    <input type="text" name="description" 
                           value="${book.description}" style="width:400px"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Quantity:</label>
                </td>
                <td>
                    <input type="text" name="quantity" 
                           value="${book.quantity}" style="width:100px"/>
                </td>
            </tr
            <tr>
                <td>

                </td>
                <td>
                    <input type="submit" name="save" width="100px"
                           value="Save" />
                    <input type="submit" name="cancel"
                           value="Cancel" />
                </td>            
            </tr>
        </table>
    </form>
</section>
<jsp:include page="NNGRFooter.jsp"/>