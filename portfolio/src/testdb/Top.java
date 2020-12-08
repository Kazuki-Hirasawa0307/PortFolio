package testdb;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MonthUpdateDAO;
import dao.SalaryAccounCheckDAO;
import dao.SalaryTimeListDAO;
import model.TimeListBean;


@WebServlet("/topj")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//ーーーーーーーーーーdogetはメニューより勤務時間一覧を押すことで処理ーーーーーーーーーー
//ーーーーーーーーーーーーー年月日・曜日の取得、セットーーーーーーーーーーーーーーーーーーー
    	TimeListBean tb = new TimeListBean(); 								//ビーン取得
		HttpSession session = request.getSession(false);					//session取得
		if(session == null) {												//セッションが切れていれば再度ログイン
	    	RequestDispatcher dispatcher =
	    			request.getRequestDispatcher("error.jsp");
	    	dispatcher.forward(request, response);
		}else {
			try {
	    	String id = (String)session.getAttribute("id");						//loginIDを取得
	    	String pass = (String)session.getAttribute("pass");
	    	tb.setLoginId(id);													//ビーンにIDセット
	    	tb.setPass(pass);
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

			SalaryAccounCheckDAO sac = new SalaryAccounCheckDAO();				//先月の給与を調べるDAOインスタンス
			int checkmonth = sac.SalaryCheck(tb);								//給与DBの最終更新月を検索
			if(checkmonth != salarymonth) {										//最終更新月が先月以外であれば下記処理
				param = 0;	tb.setParam(param);									//パラム0をビーンにセット
				@SuppressWarnings("unused")
				SalaryTimeListDAO startTimeList = new SalaryTimeListDAO(tb); 	//DAOで先月の出勤時間一覧をビーンにセット
				param = 1;	tb.setParam(param);									//パラム1をビーンにセット
				@SuppressWarnings("unused")
				SalaryTimeListDAO finishTimeList = new SalaryTimeListDAO(tb);	//DAOで先月の退勤時間一覧をビーンにセット
				@SuppressWarnings("unused")
				SalaryColc now = new SalaryColc(tb);							//先月の出退勤時間から明細各項目計算
				param = 4; tb.setParam(param);
				@SuppressWarnings("unused")
				MonthUpdateDAO workMonthUpdate = new MonthUpdateDAO(tb);		//SalaryColcの値をDBへインサート
			}
	    	int role = (Integer)session.getAttribute("role");					//管理者権限を取得しjspへ転送
	    	request.setAttribute("role", role);

			}catch(Exception e) {												//本処理でエラーで出たら再度ログインへ
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
				session.invalidate();
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}
	    	RequestDispatcher dispatcher =  request.getRequestDispatcher("top.jsp");
	    	dispatcher.forward(request, response);								//jspへ遷移
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher =  request.getRequestDispatcher("top.jsp");
        dispatcher.forward(request, response);
	}

}
