<%-- 
    Document   : NNGRMember
    Created on : Apr 03, 2016, 5:04:34 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h2>New Member Registration Form</h2>
    <form action="<c:url value='NNGRMemberAdmin?action=displayMember'/>" 
          method="Post">
        <c:if test="${errorMessage != null}">
            <p style="color: red">
                <i>${errorMessage}</i>
            </p>
        </c:if>
        <label>Full Name: </label>
        <input type="text" name="fullName" value="${member.fullName}"
               style="width:200px"> 
        <br>

        <label>Email: </label>
        <input type="email" name="email" value="${member.emailAddress}" 
               style="width:300px"> 
        <br>

        <label>Phone: </label>
        <input type="text" name="phone" value="${member.phoneNumber}" 
               style="width:100px">
        <br>

        <label>IT Program: </label>
        <select name="itProgram">
            <option value="CAD" ${member.programName == "CAD" 
                                  ? "selected" : ""}>CAD</option>
            <option value="CP" ${member.programName == "CP" 
                                 ? "selected" : ""}>CP</option>
            <option value="CPA" ${member.programName == "CPA" 
                                  ? "selected" : ""}>CPA</option>
            <option value="ITID" ${member.programName == "ITID" 
                                   ? "selected" : ""}>ITID</option>
            <option value="ITSS" ${member.programName == "ITSS" 
                                   ? "selected" : ""}>ITSS</option>
            <option value="MSD" ${member.programName == "MSD" 
                                  ? "selected" : ""}>MSD</option>
            <option value="Others" ${member.programName == "Others" 
                                     ? "selected" : ""}>Others</option>
        </select>
        <br>

        <label>Year Level: </label>
        <select name="yearLevel" >
            <option value="1" ${member.yearLevel == "1" 
                                ? "selected" : ""}>1</option>
            <option value="2" ${member.yearLevel == "2" 
                                ? "selected" : ""}>2</option>
            <option value="3" ${member.yearLevel == "3" 
                                ? "selected" : ""}>3</option>
            <option value="4" ${member.yearLevel == "4" 
                                ? "selected" : ""}>4</option>
        </select>
        <br>

        <input type="submit" name="updateMember" 
               value="Update Member">
    </form>
</section>
<jsp:include page="NNGRFooter.jsp"/>