<%-- 
    Document   : NNGRError
    Created on : Feb 26, 2016, 10:17:21 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>Java Error</h1>
    <p>Sorry, Java has thrown an exception.</p>
    <p>To continue, click the Back button.</p>

    <h2>Details</h2>
    <p>Type: ${pageContext.exception["class"]}</p>
    <p>Message: ${pageContext.exception.message}</p>
</section>
<jsp:include page="NNGRFooter.jsp"/>