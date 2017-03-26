<%-- 
    Document   : NNGRConfirmMemberDelete
    Created on : Apr 03, 2016, 5:23:46 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>Do you want to delete this member?</h1>
    <label>Full Name: </label>
    <span>${member.fullName}</span>
    <br>

    <label>Email: </label>
    <span>${member.emailAddress}</span>
    <br>

    <label>Phone: </label>
    <span>${member.phoneNumber}</span>
    <br>

    <label>IT Program: </label>
    <span>${member.programName}</span>
    <br>

    <label>Year Level: </label>
    <span>${member.yearLevel}</span>
    <br>
    <table>
        <tr>
            <td>
                <form action="<c:url value=
"NNGRMemberAdmin?action=deleteMember&email=${member.emailAddress}" />" 
                      method="post">
                    <input type="submit" name="yes" value="Yes" />
                </form>
            </td>
            <td>
                <form action="<c:url value='NNGRMemberAdmin' />" 
                      method="get">
                    <input type="hidden" name="action" 
                           value="displayMembers" />
                    <input type="submit" name="no" value="No" />
                </form>
            </td>
        </tr>
    </table>
</section>
<jsp:include page="NNGRFooter.jsp"/>