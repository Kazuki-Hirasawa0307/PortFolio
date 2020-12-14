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

import method.method;
import model.TimeListBean;
import timeDAO.StatusCheckDAO;


@WebServlet("/statusCheak")
public class StatusCheak extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//ーーーーーーーーーーーーーーメニューより打刻を開くとdogetが呼ばれるーーーーーーーーーーーー

		TimeListBean tb = new TimeListBean();								//ビーン取得
		HttpSession session = request.getSession(false);					//セッション取得
		if(session == null) {												//セッションが切れていれば再度ログイン
			String message = "セッション切れです。再度ログインしてください。";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
	    	String id = (String)session.getAttribute("id"); tb.setLoginId(id);	//セッションからidを取得しビーンにセット
	    	LocalDateTime nowDateTime = LocalDateTime.now();				//データ（時間）取得
	 	    int syear = nowDateTime.getYear(); tb.setSyear(syear);			//ビーンに現在年セット
	 	    int smonth = nowDateTime.getMonthValue(); tb.setSmonth(smonth);//ビーンに現在月セット
	 	    int sday = nowDateTime.getDayOfMonth(); tb.setSday(sday);		//ビーンに現在日セット
	 	    int beforeyear = (Integer)session.getAttribute("salarymonth");
	 	    int beforemonth = (Integer)session.getAttribute("salaryyear");
	 	    tb.setDays(method.Salarymonthday(beforemonth, beforeyear));
	 	    int param = 8; tb.setParam(param);								//パラム6をビーンへセット
			@SuppressWarnings("unused")
			StatusCheckDAO bstartStatus = new StatusCheckDAO(tb);			//DAO内のパラム6(今日の出勤状態取得)部分処理
			param = 9; tb.setParam(param);									//パラム7をビーンへセット
			@SuppressWarnings("unused")
			StatusCheckDAO bfinishStatus = new StatusCheckDAO(tb);			//DAO内のパラム7(今日の退勤状態取得)部分処理
	    	String bsstatus = tb.getBeforesstatus();							//ビーンから出勤状態取得
	    	String bfstatus = tb.getBeforefstatus();							//ビーンから退勤状態取得
	    	param = 6; tb.setParam(param);								//パラム6をビーンへセット
			@SuppressWarnings("unused")
			StatusCheckDAO startStatus = new StatusCheckDAO(tb);			//DAO内のパラム6(今日の出勤状態取得)部分処理
			param = 7; tb.setParam(param);									//パラム7をビーンへセット
			@SuppressWarnings("unused")
			StatusCheckDAO finishStatus = new StatusCheckDAO(tb);			//DAO内のパラム7(今日の退勤状態取得)部分処理
	    	String sstatus = tb.getStartstatus();							//ビーンから出勤状態取得
	    	String fstatus = tb.getFinishstatus();							//ビーンから退勤状態取得
	    	String status = null;

	        int bstatus = 0;

	        if(bsstatus == "worked" && bfstatus == "nowork" && sstatus == "nowork") {
	        	status ="kinmu";
	        	bstatus = 1;

	        }else {
		    	if(sstatus == "error" || fstatus == "error" ){					//出退勤状態をstatusへ代入
		    		status = "error";
		    	}else {
		    		if(sstatus == "nowork") {
		    			if(fstatus == "nowork") {
		    				status = "taikin";
		    			}else {
		    				status = "error";
		    			}
		    		}else {
		    			if(fstatus == "worked") {
		    				status = "finish";
		    			}else {
		    				status = "kinmu";
		    			}
		    		}
		    	}
		    	bstatus = 2;
	        }

	        session.setAttribute("bstatus", bstatus);
	        request.setAttribute("status", status);							//現在の出退勤状態をjspへ転送
	    	request.setAttribute("role", (Integer)session.getAttribute("role"));
	    	request.setAttribute("name", (String)session.getAttribute("name"));
	    	request.setAttribute("id", (String)session.getAttribute("id"));

			}catch(Exception e) {
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
				session.invalidate();
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}


	        RequestDispatcher dispatcher =  								//dakoku.jspへ遷移
	        		request.getRequestDispatcher("dakoku.jsp");
	        dispatcher.forward(request, response);
		}
	}
//ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher =  request.getRequestDispatcher("dakoku.jsp");
        dispatcher.forward(request, response);
	}

}
