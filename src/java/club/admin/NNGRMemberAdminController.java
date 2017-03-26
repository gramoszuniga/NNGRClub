/*  
    Document   : NNGRMemberAdminController
    Created on : Apr 03, 2016, 3:13:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRMemberAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String url = "";

        if (action == null) {
            action = "displayMembers";
        }

        if (action.equals("displayMembers")) {
            request.setAttribute("members", MemberDB.selectMembers());
            url = "/NNGRDisplayMembers.jsp";
        } else if (action.equals("addMember")) {
            url = "/NNGRMember.jsp";
        } else if (action.equals("displayMember")) {
            request.setAttribute("member", MemberDB.selectMember(
                    request.getParameter("email")));
            url = "/NNGRMember.jsp";
        } else if (action.equals("confirmDeleteMember")) {
            request.setAttribute("member", MemberDB.selectMember(
                    request.getParameter("email")));
            url = "/NNGRConfirmMemberDelete.jsp";
        }

        this.getServletContext().getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String url = "/NNGRDisplayMembers.jsp";

        if (action == null) {
            action = "displayMembers";
        }

        if (action.equals("displayMember")) {
            if (MemberDB.emailExists(request.getParameter("email"))) {
                Member member = MemberDB.selectMember(request.
                        getParameter("email"));
                member.setFullName(request.getParameter("fullName"));
                member.setPhoneNumber(request.getParameter("phone"));
                member.setProgramName(request.getParameter("itProgram"));
                member.setYearLevel(Integer.parseInt(request.
                        getParameter("yearLevel")));

                if (member.isValid()) {
                    MemberDB.update(member);
                } else {
                    request.setAttribute("errorMessage",
                            "Member information is not valid. "
                            + "You must enter a valid name an email.");
                    request.setAttribute("member", member);
                    url = "/NNGRMember.jsp";
                }
            } else {
                Member member = new Member();
                member.setEmailAddress(request.getParameter("email"));
                member.setFullName(request.getParameter("fullName"));
                member.setPhoneNumber(request.getParameter("phone"));
                member.setProgramName(request.getParameter("itProgram"));
                member.setYearLevel(Integer.parseInt(request.
                        getParameter("yearLevel")));

                if (member.isValid()) {
                    MemberDB.insert(member);
                } else {
                    request.setAttribute("errorMessage",
                            "Member information is not valid. "
                            + "You must enter a valid name an email.");
                    request.setAttribute("member", member);
                    url = "/NNGRMember.jsp";
                }
            }
        } else if (action.equals("deleteMember")) {
            MemberDB.delete(MemberDB.selectMember(request.
                    getParameter("email")));
        }

        request.setAttribute("members", MemberDB.selectMembers());
        this.getServletContext().getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    public String getServletInfo() {

        return "Short description";

    }

}
