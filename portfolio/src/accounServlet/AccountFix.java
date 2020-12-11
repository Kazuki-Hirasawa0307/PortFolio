package accounServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountDAO.AccountFixDAO;
import model.TimeListBean;

@WebServlet("/AccountFix")
public class AccountFix extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

        String pass = request.getParameter("pass");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String base = request.getParameter("base");
        String position = request.getParameter("position");
        String qualify = request.getParameter("qualify");
        String family = request.getParameter("family");
        String transport = request.getParameter("transport");
        String mail = request.getParameter("mail");
        String birthday = request.getParameter("birthday");
        String hyouzyun = request.getParameter("hyouzyun");
        String home = request.getParameter("home");
        String resident = request.getParameter("resident");


        if(name == "") {name = null;}
        if(role == "") {role = null;}
        if(base == "") {base = null;}
        if(position == "") {position = null;}
        if(qualify == "") {qualify = null;}
        if(family == "") {family = null;}
        if(transport == "") {transport = null;}
        if(home == "") {home = null;}
        if(birthday == "") {birthday = null;}
        if(hyouzyun == "") {hyouzyun = null;}
        if(mail == "") {mail = null;}
        if(resident == "") {resident = null;}

        TimeListBean ab = new TimeListBean();
        ab.setNname(name);
        ab.setPass(pass);
        ab.setLoginId(id);
        ab.setNbase(base);
        ab.setNposition(position);
        ab.setNfamily(family);
        ab.setNqualify(qualify);
        ab.setNtransport(transport);
        ab.setNrole(role);
        ab.setNbirthday(birthday);
        ab.setNmail(mail);
        ab.setNhyouzyun(hyouzyun);
        ab.setNhome(home);
        ab.setNresident(resident);
        @SuppressWarnings("unused")
		AccountFixDAO afd = new AccountFixDAO(ab);


        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);
	}

}
