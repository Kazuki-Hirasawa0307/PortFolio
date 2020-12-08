package testdb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TimeListDAO;
import model.TimeListBean;

@WebServlet("/timelist")
public class TimeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ーーーーーーーーーーdogetはメニューより勤務時間一覧を押すことで処理ーーーーーーーーーー

		//ーーーーーーーーーーーセッションより年月日取得、セットーーーーーーーーーーーーーーーーーーー
		TimeListBean tb = new TimeListBean(); //ビーン取得
		HttpSession session = request.getSession(false); //session取得
		if (session == null) { //セッションが切れていれば再度ログイン
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
			String id = (String) session.getAttribute("id"); //loginIDを取得
			tb.setLoginId(id); //ビーンにIDセット
			int days = (Integer) session.getAttribute("days"); //セッションから今日の日取得
			int smonth = (Integer) session.getAttribute("smonth"); //セッションから今日の月取得
			int syear = (Integer) session.getAttribute("syear"); //セッションから今日の年取得
			tb.setDays(days); //ビーンへ日セット
			tb.setSmonth(smonth); //ビーンへ月セット
			tb.setSyear(syear); //ビーンへ年セット

			//ーーーーーーーーーーーDAOで勤務時間一覧に出力する値をDBから取得ーーーーーーーーーーーーーーーー
			int param = 0;
			tb.setParam(param); //パラム0をビーンにセット
			@SuppressWarnings("unused")
			TimeListDAO startTimeList = new TimeListDAO(tb); //DAOのパラム0(DBの出勤時間一覧をビーンにセット)呼び出し
			param = 1;
			tb.setParam(param); //パラム1をビーンにセット
			@SuppressWarnings("unused")
			TimeListDAO finishTimeList = new TimeListDAO(tb); //DAOのパラム0(DBの退勤時間一覧をビーンにセット)呼び出し

			//ーーーーーーーーーーー勤務時間、残業時間計算ーーーーーーーーーーーーーーーーーーーーーーーー
			TimeListColc tl = new TimeListColc();
			TimeListBean returnTl = tl.Colc(tb);

			request.setAttribute("sday", days); //それぞれjspへ転送
			request.setAttribute("smonth", smonth);
			request.setAttribute("weeks", tb.getWeeks());
			request.setAttribute("startday", tb.getStartday());
			request.setAttribute("starthour", tb.getStarthour());
			request.setAttribute("startminute", tb.getStartminute());
			request.setAttribute("finishday", tb.getFinishday());
			request.setAttribute("finishminute", tb.getFinishminute());
			request.setAttribute("finishHours", returnTl.getFinishHours());
			request.setAttribute("dayHours", returnTl.getDayHours());
			request.setAttribute("dayMinutes", returnTl.getDayMinutes());
			request.setAttribute("dayzHours", returnTl.getDayzHours());
			request.setAttribute("dayzMinutes", returnTl.getDayzMinutes());
			request.setAttribute("monthHour", returnTl.getMonthHour());
			request.setAttribute("monthMinute", returnTl.getMonthMinute());
			request.setAttribute("monthzMinute", returnTl.getMonthzMinute());
			request.setAttribute("monthzHour", returnTl.getMonthzHour());
			request.setAttribute("monthnight", returnTl.getMonthnight());
			request.setAttribute("nights", returnTl.getNights());
			request.setAttribute("monthnightm", returnTl.getMonthnightm());
			request.setAttribute("nightsm", returnTl.getNightsm());
			request.setAttribute("workday", returnTl.getWorkday());

			//ーーーーーーーーーーjspへ遷移ーーーーーーーーーーーーーーーーーーーーー
			int role = (Integer)session.getAttribute("role");
	    	request.setAttribute("role", role);

			}catch(Exception e) {
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
				session.invalidate();
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("timelist.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("dakoku.jsp");
		dispatcher.forward(request, response);
	}

}
