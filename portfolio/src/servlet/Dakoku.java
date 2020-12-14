package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TimeListBean;
import timeDAO.TimeInsertDAO;

/**
 * Servlet implementation class tttt
 */
@WebServlet("/dakoku")
public class Dakoku extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LocalDateTime nowDateTime = LocalDateTime.now();
	    response.setContentType("text/html; charset=Shift_JIS");

//--------ーー-----dogetはdakoku.jspの打刻ボタンを押すことで処理ーーーーーーーーー
//-----------ー------------打刻時刻取得し、DBへ転送ーーーーーーーーーーーーーーーーー
	    TimeListBean tb = new TimeListBean();
		HttpSession session = request.getSession(false);
		if(session == null) {													//セッションが切れていれば再度ログイン
			String message = "セッション切れです。再度ログインしてください。";
			request.setAttribute("message", message);
	    	RequestDispatcher dispatcher =
	    			request.getRequestDispatcher("login.jsp");
	    	dispatcher.forward(request, response);
		}else {
	    	String id = (String)session.getAttribute("id"); tb.setLoginId(id);	//セッションからID取得
		    int syear = nowDateTime.getYear(); tb.setSyear(syear);				//現在年取得、セット
		    int smonth = nowDateTime.getMonthValue(); tb.setSmonth(smonth);	//現在月取得、セット
		    int sday = nowDateTime.getDayOfMonth(); tb.setSday(sday);			//現在日取得、セット
	      	int shour = nowDateTime.getHour(); 	tb.setShour(shour);				//現在時取得、セット
	      	int sminute = nowDateTime.getMinute();	tb.setSminute(sminute);		//現在分取得、セット
	     	int ssecond = nowDateTime.getSecond();	tb.setSsecond(ssecond);		//現在秒取得、セット
	      	int param = 4; tb.setParam(param);									//パラム4セット
	    	@SuppressWarnings("unused")
			TimeInsertDAO startTimeInsert = new TimeInsertDAO(tb);			//上記時間を出勤時間DBへインサート

	    	response.sendRedirect("http://localhost:8080/portfolio/statusCheak");	//ステータスチェックサーブレットへ処理遷移
		}
	}



//ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//ーーーーーーーーーdopostはdakoku.jspで退勤ボタンを押したときに処理ーーーーーーーー
//ーーーーーーーーーーー退勤時間を取得し、DBへ記録ーーーーーーーーーーーーーーー
		TimeListBean tb = new TimeListBean();							//ビーンインスタンス化
		HttpSession session = request.getSession(false);				//セッション取得
		if(session == null) {											//セッションが切れていれば再度ログイン
			String message = "セッション切れです。再度ログインしてください。";
			request.setAttribute("message", message);
	    	RequestDispatcher dispatcher =
	    			request.getRequestDispatcher("login.jsp");
	    	dispatcher.forward(request, response);
		}else {
			int status = (Integer)session.getAttribute("bstatus");
	    	String id = (String)session.getAttribute("id"); tb.setLoginId(id);	//セッションからID取得
		    LocalDateTime nowDateTime = LocalDateTime.now();					//時刻取得インスタンス化
		    int fyear = nowDateTime.getYear(); tb.setFyear(fyear);				//現在年取得、セット
		    int fmonth = nowDateTime.getMonthValue(); tb.setFmonth(fmonth);	//現在月取得、セット
		    int fday = nowDateTime.getDayOfMonth(); tb.setFday(fday);			//現在日取得、セット
	      	int fhour = nowDateTime.getHour(); tb.setFhour(fhour);				//現在時取得、セット
	      	int fminute = nowDateTime.getMinute(); tb.setFminute(fminute);		//現在分取得、セット
	     	int fsecond = nowDateTime.getSecond(); tb.setFsecond(fsecond);		//現在状取得、セット
	      	int param = 5; tb.setParam(param);									//パラム5セット
	      	if(status == 1) {
	      		fday -= 1;	tb.setFday(fday);
	      		fhour += 24;	tb.setFhour(fhour);
	      		if(fday == 0) {
	      			fday = tb.getDays();
	      			fmonth -= 1;	tb.setFmonth(fmonth);
	      			if(fmonth == 0) {
	      				fmonth = 12;	tb.setFmonth(fmonth);
	      				fyear -= 1;		tb.setFyear(fyear);
	      			}
	      		}
	      	}
	    	@SuppressWarnings("unused")
			TimeInsertDAO finishTimeInsert = new TimeInsertDAO(tb);			//上記時間を退勤時間DBへセット

	    	response.sendRedirect("http://localhost:8080/portfolio/statusCheak");	//ステータスチェックサーブレットへ処理遷移
		}
	}
}
