package servlet;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import method.SalaryColc;
import method.method;
import model.TimeListBean;
import salaryDAO.SalaryAccounCheckDAO;
import salaryDAO.SalaryDayOffDAO;
import salaryDAO.SalaryTimeListDAO;
import timeDAO.MonthUpdateDAO;


@WebServlet("/topj")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//ーーーーーーーーーーdogetはメニューより勤務時間一覧を押すことで処理ーーーーーーーーーー
//ーーーーーーーーーーーーー年月日・曜日の取得、セットーーーーーーーーーーーーーーーーーーー
    	TimeListBean tb = new TimeListBean(); 								//ビーン取得
		HttpSession session = request.getSession(false);					//session取得
		if(session == null) {												//セッションが切れていれば再度ログイン
			String message = "セッション切れです。再度ログインしてください。";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
		    	String id = (String)session.getAttribute("id");						//loginIDを取得
		    	String pass = (String)session.getAttribute("pass");
		    	String name = (String)session.getAttribute("name");

		    	tb.setLoginId(id);													//ビーンにIDセット
		    	tb.setPass(pass);
		    	tb.setName(name);
		        LocalDateTime nowDateTime = LocalDateTime.now();					//データ（時間）取得
		 	    int syear = nowDateTime.getYear(); tb.setSyear(syear);				//ビーンに現在年セット
		 	    int smonth = nowDateTime.getMonthValue(); tb.setSmonth(smonth);	//ビーンに現在月セット
		 	    int sday = nowDateTime.getDayOfMonth(); tb.setSday(sday);			//ビーンに現在日セット
		 	    DayOfWeek aweek = nowDateTime.getDayOfWeek();						//現在曜日取得
		 	    String week = String.valueOf(aweek);								//曜日をString型に変換
		 	    for(int i = sday ; i > 1; i--) {									//現在の曜日から当月1日の曜日を取得
		 	    	if(week == "MONDAY") {			week = "SUNDAY";
		 	 	    }else if(week == "TUESDAY") {	week = "MONDAY";
		 	 	    }else if(week == "WEDNESDAY") {	week = "TUESDAY";
		 	 	    }else if(week == "THURSDAY") {	week = "WEDNESDAY";
		 	 	    }else if(week == "FRIDAY") {	week = "THURSDAY";
		 	 	    }else if(week == "SATURDAY") {	week = "FRIDAY";
		 	 	    }else if(week == "SUNDAY") {	week = "SATURDAY";
		 	 	    }
		 	    }

		 	    tb.setWeek(week);													//ビーンに当月1日の曜日をセット
		 	    method.monthday(tb);												//当月の日数を取得、ビーンへセット
				session.setAttribute("days",tb.getDays()); 										//セッションへ今日の日セット
				session.setAttribute("smonth",smonth);										//セッションへ今日の月セット
				session.setAttribute("syear",syear); 										//セッションへ今日の年セット


		//ーーーーーーーーーーーーDBに現在月情報が無い場合にはDB更新ーーーーーーーーーーーーー
		    	int param = 2; tb.setParam(param);									//パラム2をセット
		    	@SuppressWarnings("unused")
				MonthUpdateDAO startMonthUpdate = new MonthUpdateDAO(tb);			//出勤時間一覧DBの当月分更新
		    	param = 3; tb.setParam(param);										//パラム3をセット
		    	@SuppressWarnings("unused")
				MonthUpdateDAO finishMonthUpdate = new MonthUpdateDAO(tb);		//退勤時間一覧DBの当月分更新

				int salaryyear = syear;
				int salarymonth = smonth - 1;										//先月
				if(salarymonth < 1) {												//先月が12月なら該当年を今年から1年引く
					salarymonth = 12;
					salaryyear -= 1;
				}
				tb.setSalaryyear(salaryyear);										//先月の該当年をビーンへセット
				tb.setSalarymonth(salarymonth);										//先月をビーンへセット
				session.setAttribute("salaryyear", salaryyear);										//先月の該当年をビーンへセット
				session.setAttribute("salarymonth", salarymonth);
				SalaryAccounCheckDAO sac = new SalaryAccounCheckDAO();				//先月の給与を調べるDAOインスタンス
				int checkmonth = sac.SalaryCheck(tb);								//給与DBの最終更新月を検索

				if(checkmonth != salarymonth) {										//最終更新月が先月以外で
					if(sday > 5) {													//現在日が6日以降であればあれば下記処理
						SalaryDayOffDAO sdo = new SalaryDayOffDAO();
						TimeListBean returnDayoff = sdo.SalaryDayOff(tb);
						ArrayList<String> names = returnDayoff.getDayoffnames();
						ArrayList<Integer> status = returnDayoff.getDaystatuses();

						int paidvacation = 0;
						int absence = 0;
						if(names.size() != 0) {
						for(int i = 0; i < names.size(); i++){
							if(status.get(i) == 1){
								paidvacation += 1;
							}else {
								absence += 1;
							}
						}
						}
						tb.setPaidvacation(paidvacation);
						tb.setAbsence(absence);
						param = 0;	tb.setParam(param);									//パラム0をビーンにセット
						@SuppressWarnings("unused")
						SalaryTimeListDAO startTimeList = new SalaryTimeListDAO(tb); 	//DAOで先月の出勤時間一覧をビーンにセット
						param = 1;	tb.setParam(param);									//パラム1をビーンにセット
						@SuppressWarnings("unused")
						SalaryTimeListDAO finishTimeList = new SalaryTimeListDAO(tb);	//DAOで先月の退勤時間一覧をビーンにセット
						if(tb.getSalarystartmonth() == salarymonth) {
							@SuppressWarnings("unused")
							SalaryColc now = new SalaryColc(tb);							//先月の出退勤時間から明細各項目計算
							param = 4; tb.setParam(param);
							@SuppressWarnings("unused")
							MonthUpdateDAO workMonthUpdate = new MonthUpdateDAO(tb);		//SalaryColcの値をDBへインサート
						}
					}
				}
			}catch(Exception e) {												//本処理でエラーで出たら再度ログインへ
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}
			request.setAttribute("role", (Integer)session.getAttribute("role"));
	    	request.setAttribute("name", (String)session.getAttribute("name"));
	    	request.setAttribute("id", (String)session.getAttribute("id"));
	    	RequestDispatcher dispatcher =  request.getRequestDispatcher("top.jsp");
	    	dispatcher.forward(request, response);								//jspへ遷移
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher =  request.getRequestDispatcher("top.jsp");
        dispatcher.forward(request, response);
	}

}
