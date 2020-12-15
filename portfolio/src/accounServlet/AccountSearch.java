package accounServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountDAO.AccountDAO;
import model.TimeListBean;

/**
 * Servlet implementation class AccountDAO2
 */
@WebServlet("/AccountSearch")
public class AccountSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");

		// login.jspから受け取ったログインIDとpassをビーンズにセット
		TimeListBean ab = new TimeListBean();
		int param = 1;
		ab.setParam(param);
		ab.setLoginId(loginId);
		ab.setName(name);

		// アカウントの有無を検索
		// 検索したアカウント情報を取得
		AccountDAO ad = new AccountDAO();
		TimeListBean returnAb = ad.findAccount(ab);

		if (returnAb != null) {
			String pas = returnAb.getPass();
			String nam = returnAb.getName();
			String id = returnAb.getLoginId();
			int role = returnAb.getRole();
			int base = returnAb.getBase();
			int family = returnAb.getFamily();
			int position = returnAb.getPosition();
			int qualify = returnAb.getQualify();
			int transport = returnAb.getTransport();
			String mail = returnAb.getMail();
			int home = returnAb.getHome();
			int birthday = returnAb.getBirthday();
			int hyouzyun = returnAb.getHyouzyun();
			int resident = returnAb.getResident();
			String birth = String.valueOf(birthday);
			String year = birth.substring(0, 4);
			String month = birth.substring(4, 6);
			int size = birth.length();
			int cut = 2;
			String day = birth.substring(size - cut);
			String bday = year + "年" + month + "月" + day + "日";
			request.setAttribute("name", nam);
			request.setAttribute("pass", pas);
			request.setAttribute("loginId", id);
			request.setAttribute("role", role);
			request.setAttribute("base", base);
			request.setAttribute("family", family);
			request.setAttribute("position", position);
			request.setAttribute("qualify", qualify);
			request.setAttribute("transport", transport);
			request.setAttribute("home", home);
			request.setAttribute("birthday", bday);
			request.setAttribute("mail", mail);
			request.setAttribute("hyouzyun", hyouzyun);
			request.setAttribute("resident", resident);

			RequestDispatcher rd = request.getRequestDispatcher("admin-empFix.jsp");
			rd.forward(request, response);

		} else {
			String message = "名前又はIDが誤っています。";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/admin-empInput.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		TimeListBean ab = new TimeListBean();
		ab.setLoginId(loginId);
		ab.setPass(pass);
		int param = 2;
		ab.setParam(param);
		AccountDAO ad = new AccountDAO();
		TimeListBean returnAb = ad.findAccount(ab);
		if (returnAb != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id", loginId);
			session.setAttribute("pass", pass);
			session.setAttribute("role", returnAb.getRole());
			session.setAttribute("name", returnAb.getName());
			int role = returnAb.getRole();

			if (role == 2) {
				session.setAttribute("account", returnAb);

				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} else if (role == 1) {
				session.setAttribute("account", returnAb);
				response.sendRedirect("http://localhost:8080/portfolio/topj");
			}

		} else {
			String message = "IDもしくはPasswordが誤っています。";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}