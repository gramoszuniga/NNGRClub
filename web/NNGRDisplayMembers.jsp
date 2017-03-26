<%-- 
    Document   : NNGRDisplayMembers
    Created on : Apr 03, 2016, 4:34:21 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="NNGRBanner.jsp"/>
<section>
    <h1>List of Members</h1>
    <table>
        <tr>
            <th>
                Email
            </th>
            <th>
                Program
            </th>
            <th>
                Year
            </th>
        </tr>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>
                    ${member.emailAddress}
                </td>
                <td>
                    ${member.programName}
                </td>
                <td>
                    ${member.yearLevel}
                </td>
                <td>
                    <a href="<c:url value=
'NNGRMemberAdmin?action=displayMember&email=${member.emailAddress}' />">
                    Update</a>
                </td>
                <td>
                    <a href="<c:url value=
'NNGRMemberAdmin?action=confirmDeleteMember&email=${member.emailAddress}' 
                    />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="<c:url value='NNGRMemberAdmin' />" method="get">
        <input type="hidden" name="action" value="addMember">
        <input type="submit" name="addMember"
               value="Add Member">
    </form>
</section>
<jsp:include page="NNGRFooter.jsp"/>