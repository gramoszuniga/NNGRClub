<%-- 
    Document   : NNGRBanner
    Created on : Jan 12, 2016, 13:04:08 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NNGR Computer Programming Club</title>
        <link href="styles/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <img src="images/logo.png" alt="logo" height="75" width="75"/>
            <h1>NNGR Computer Programming Club</h1>
            <h2>IT@Conestoga</h2>
        </header>
        <nav id="nav_bar">
            <ul>
                <li><a href="NNGRIndex.jsp">
                        Home</a></li>
                <li><a href="<c:url value='NNGRMemberAdmin?action=addMember' />">
                        Register</a></li>
                <li><a href="NNGRLoan">
                        eLoan</a></li>
                <li><a href="NNGRCart">
                        eCart</a></li>
                <li><a href="NNGRAdmin.jsp">
                        Admin</a></li>
            </ul>
        </nav>