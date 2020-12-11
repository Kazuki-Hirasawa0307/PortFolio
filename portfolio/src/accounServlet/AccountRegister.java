package accounServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountDAO.AccountRegisterDAO;
import model.TimeListBean;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String loginId = request.getParameter("loginId");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");
        int base = Integer.parseInt(request.getParameter("base"));
        int position = Integer.parseInt(request.getParameter("position"));
        int qualify = Integer.parseInt(request.getParameter("qualify"));
        int family = Integer.parseInt(request.getParameter("family"));
        int transport = Integer.parseInt(request.getParameter("transport"));
        int role = Integer.parseInt(request.getParameter("role"));
        int birthday = Integer.parseInt(request.getParameter("birthday"));
        int hyouzyun = Integer.parseInt(request.getParameter("hyouzyun"));
        int home = Integer.parseInt(request.getParameter("home"));
        int resident = Integer.parseInt(request.getParameter("resident"));




        // register.jspから受け取った値をビーンズにセット
        TimeListBean ab = new TimeListBean();
        ab.setName(name);
        ab.setLoginId(loginId);
        ab.setPass(pass);
        ab.setRole(role);
        ab.setBase(base);
        ab.setPosition(position);
        ab.setQualify(qualify);
        ab.setFamily(family);
        ab.setTransport(transport);
        ab.setHome(home);
        ab.setHyouzyun(hyouzyun);
        ab.setBirthday(birthday);
        ab.setMail(mail);
        ab.setResident(resident);



        // アカウントをDBに登録
        int param = 4;
        ab.setParam(param);
        @SuppressWarnings("unused")
		AccountRegisterDAO ard = new AccountRegisterDAO(ab);
        param = 5;
        ab.setParam(param);
        @SuppressWarnings("unused")
		AccountRegisterDAO ard1 = new AccountRegisterDAO(ab);
        param = 6;
        ab.setParam(param);
        @SuppressWarnings("unused")
		AccountRegisterDAO ard2 = new AccountRegisterDAO(ab);
        param = 7;
        ab.setParam(param);
        @SuppressWarnings("unused")
		AccountRegisterDAO ard3 = new AccountRegisterDAO(ab);

        // セッションにアカウント情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("account", ab);

        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);

    }

}