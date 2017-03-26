<%-- 
    Document   : NNGRDisplayMember
    Created on : Jan 30, 2016, 4:35:05 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>Thanks for joining our club!</h1>
    <p>Here is the information you entered:</p>
    <label>Full Name: </label>
    <span>${param.fullName}</span>
    <br>

    <label>Email: </label>
    <span>${param.email}</span>
    <br>

    <label>Phone: </label>
    <span>${param.phone}</span>
    <br>

    <label>IT Program: </label>
    <span>${param.itProgram}</span>
    <br>

    <label>Year Level: </label>
    <span>${param.yearLevel}</span>
    <br>

    <p>To register another member, click on the Back button in your browser 
        or the Return button shown below.</p>

    <form action="NNGRRegister.jsp" method="Post">
        <input type="submit" name="return" value="Return">
    </form>
</section>
<jsp:include page="NNGRFooter.jsp"/>