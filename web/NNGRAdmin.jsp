<%-- 
    Document   : NNGRAdmin
    Created on : Feb 16, 2016, 5:04:34 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>Admin: Data Maintenance</h1>
    <a href="NNGRDisplayBooks">Maintain Books</a><br>
    <a href="<c:url value='NNGRMemberAdmin?action=displayMembers' />">
        Display Members</a>
</section>
<jsp:include page="NNGRFooter.jsp"/>