package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountDAO.AccountDAO;
import method.SalaryTotal;
import model.TimeListBean;
import salaryDAO.SalarySelectDAO;

@WebServlet("/Salary")
public class Salary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) { 												//セッションが切れていれば再度ログイン
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
			TimeListBean tb = new TimeListBean(); 							//ビーン取得
			String id = (String) session.getAttribute("id"); 				//セッションからloginIDを取得
			String pass = (String) session.getAttribute("pass");			//セッションからpassを取得
			tb.setPass(pass);												//ビーンにpassセット
			tb.setLoginId(id);												//ビーンにIDセット

//ーーーーーーーーーーー給与明細各項目の呼び出し・計算処理ーーーーーーーーーーーーーーーーー

			int param = 2;	tb.setParam(param);								//パラム2をビーンへセット
			AccountDAO ad = new AccountDAO();								//アカウント情報DAOインスタンス化
			TimeListBean returnAb = ad.findAccount(tb);						//アカウント情報をreturnAbへセット
			SalarySelectDAO ssd = new SalarySelectDAO();					//先月の出退勤情報DAOをインスタンス化
			param = 4;	tb.setParam(param);
			@SuppressWarnings("unused")
			TimeListBean returnMonth = ssd.salary(tb);						//出退勤情報をreturnSalaryへセット
			tb.setSalarymonth((Integer)session.getAttribute("salarymonth"));
			tb.setSalaryyear((Integer)session.getAttribute("salaryyear"));
			param = 2;	tb.setParam(param);
			TimeListBean returnSalary = ssd.salary(tb);					//出退勤情報をreturnSalaryへセット
			SalaryTotal st = new SalaryTotal();								//SalaryTotalクラスインスタンス化
			TimeListBean returnTotal = st.Total(returnSalary, returnAb,tb);//Totalコンストラクタでjspで表示する数値を計算



//－－－－－－－－－－－－－各変数をjspへ転送－－－－－－－－－－－－－－－－－－－－－

			int role = (Integer)session.getAttribute("role");

	    	request.setAttribute("role", role);									//管理権限情報
	    	request.setAttribute("id", id);										//社員番号
			request.setAttribute("resident", returnAb.getResident());			//住民税
			request.setAttribute("year", returnSalary.getYear());				//先月の該当年
			request.setAttribute("month", returnSalary.getMonth());				//先月
			request.setAttribute("name", returnAb.getName());					//氏名
			request.setAttribute("base", returnAb.getBase());					//基本給
			request.setAttribute("family", returnAb.getFamily());				//家族手当
			request.setAttribute("position", returnAb.getPosition());			//役職手当
			request.setAttribute("qualify", returnAb.getQualify());				//資格手当
			request.setAttribute("transport", returnAb.getTransport());			//交通費
			request.setAttribute("home", returnAb.getHome());					//住宅手当
			request.setAttribute("nenkin", returnTotal.getNenkin());			//厚生年金
			request.setAttribute("kenkou", returnTotal.getKenkou());			//健康保険料
			request.setAttribute("kaigo", returnTotal.getKaigo());				//介護保険料
			request.setAttribute("koyou", returnTotal.getKoyou());				//雇用保険料
			request.setAttribute("syotoku", returnTotal.getSyotoku());			//所得税
			request.setAttribute("tax", returnTotal.getTax());					//課税対象額
			request.setAttribute("dayofftime", returnTotal.getDayofftime());	//休日出勤時間
			request.setAttribute("dayoffhp", returnTotal.getDayoffhp());		//休日出勤手当
			request.setAttribute("shinyatotal", returnTotal.getShinyatotal());	//深夜クン無手当
			request.setAttribute("zsalarys", returnTotal.getZsalarys());		//残業手当
			request.setAttribute("monthz", returnTotal.getMonthz());			//残業時間
			request.setAttribute("monthh", returnTotal.getMonthh()); 			//勤務時間
			request.setAttribute("tisou", returnTotal.getTisou());				//遅刻・早退時間
			request.setAttribute("tisoum", returnTotal.getTisoum());			//遅刻・早退控除
			request.setAttribute("monthn", returnTotal.getMonthn());			//深夜勤務時間
			request.setAttribute("total", returnTotal.getTotal());				//総支給額
			request.setAttribute("tisoutime", returnSalary.getLateday());		//遅刻回数
			request.setAttribute("workday", returnSalary.getWorkday());			//出勤日数
			request.setAttribute("dayofft", returnSalary.getDayoffworkday());	//休日出勤日数
			request.setAttribute("absencemoney", returnTotal.getAbsencemoney());//欠勤控除日数
			request.setAttribute("absence", returnSalary.getAbsence());			//欠勤日数
			request.setAttribute("paidvacation", returnSalary.getPaidvacation());//有給日数
			request.setAttribute("dmonth", tb.getDmonth());


			}catch(Exception e) {
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
				session.invalidate();
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("Salary.jsp");
			dispatcher.forward(request, response);
		}
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) { 												//セッションが切れていれば再度ログイン
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
			TimeListBean tb = new TimeListBean(); 							//ビーン取得
			String id = (String) session.getAttribute("id"); 				//セッションからloginIDを取得
			String pass = (String) session.getAttribute("pass");			//セッションからpassを取得
			tb.setPass(pass);												//ビーンにpassセット
			tb.setLoginId(id);												//ビーンにIDセット

			int displaymonth = 0;
			displaymonth = Integer.parseInt
					(request.getParameter("displaymonth"));					//表示する給与明細月取得
			tb.setDisplaymonth(displaymonth);								//上記をビーンへセット

//ーーーーーーーーーーー給与明細各項目の呼び出し・計算処理ーーーーーーーーーーーーーーーーー

			int param = 2;	tb.setParam(param);									//パラム2をビーンへセット
			AccountDAO ad = new AccountDAO();									//アカウント情報DAOインスタンス化
			TimeListBean returnAb = ad.findAccount(tb);							//アカウント情報をreturnAbへセット
			SalarySelectDAO ssd = new SalarySelectDAO();						//先月の出退勤情報DAOをインスタンス化
			param = 4;	tb.setParam(param);										//パラム4をビーンへセット
			@SuppressWarnings("unused")
			TimeListBean returnMonth = ssd.salary(tb);							//就職してから何か月分の給与があるか検索
			param = 3;	tb.setParam(param);										//パラム3をセット
			TimeListBean returnSalary = ssd.salary(tb);						//出退勤情報をreturnSalaryへセット
			SalaryTotal st = new SalaryTotal();									//SalaryTotalクラスインスタンス化
			TimeListBean returnTotal = st.Total(returnSalary, returnAb,tb);	//Totalコンストラクタでjspで表示する数値を計算

//－－－－－－－－－－－－－各変数をjspへ転送－－－－－－－－－－－－－－－－－－－－－

			int role = (Integer)session.getAttribute("role");

	    	request.setAttribute("role", role);									//管理権限情報
	    	request.setAttribute("id", id);										//社員番号
			request.setAttribute("resident", returnAb.getResident());			//住民税
			request.setAttribute("year", returnSalary.getYear());				//先月の該当年
			request.setAttribute("month", returnSalary.getMonth());				//先月
			request.setAttribute("name", returnAb.getName());					//氏名
			request.setAttribute("base", returnAb.getBase());					//基本給
			request.setAttribute("family", returnAb.getFamily());				//家族手当
			request.setAttribute("position", returnAb.getPosition());			//役職手当
			request.setAttribute("qualify", returnAb.getQualify());				//資格手当
			request.setAttribute("transport", returnAb.getTransport());			//交通費
			request.setAttribute("home", returnAb.getHome());					//住宅手当
			request.setAttribute("nenkin", returnTotal.getNenkin());			//厚生年金
			request.setAttribute("kenkou", returnTotal.getKenkou());			//健康保険料
			request.setAttribute("kaigo", returnTotal.getKaigo());				//介護保険料
			request.setAttribute("koyou", returnTotal.getKoyou());				//雇用保険料
			request.setAttribute("syotoku", returnTotal.getSyotoku());			//所得税
			request.setAttribute("tax", returnTotal.getTax());					//課税対象額
			request.setAttribute("dayofftime", returnTotal.getDayofftime());	//休日出勤時間
			request.setAttribute("dayoffhp", returnTotal.getDayoffhp());		//休日出勤手当
			request.setAttribute("shinyatotal", returnTotal.getShinyatotal());	//深夜クン無手当
			request.setAttribute("zsalarys", returnTotal.getZsalarys());		//残業手当
			request.setAttribute("monthz", returnTotal.getMonthz());			//残業時間
			request.setAttribute("monthh", returnTotal.getMonthh()); 			//勤務時間
			request.setAttribute("tisou", returnTotal.getTisou());				//遅刻・早退時間
			request.setAttribute("tisoum", returnTotal.getTisoum());			//遅刻・早退控除
			request.setAttribute("monthn", returnTotal.getMonthn());			//深夜勤務時間
			request.setAttribute("total", returnTotal.getTotal());				//総支給額
			request.setAttribute("tisoutime", returnSalary.getLateday());		//遅刻回数
			request.setAttribute("workday", returnSalary.getWorkday());			//出勤日数
			request.setAttribute("dayofft", returnSalary.getDayoffworkday());	//休日出勤日数
			request.setAttribute("absencemoney", returnTotal.getAbsencemoney());//欠勤控除日数
			request.setAttribute("absence", returnSalary.getAbsence());			//欠勤日数
			request.setAttribute("paidvacation", returnSalary.getPaidvacation());//有給日数
			request.setAttribute("dmonth", tb.getDmonth());						//支給給与月一覧



			}catch(Exception e) {
				System.out.println(e);
				String message = "不正な操作です。再度ログインしてください。";
				session.invalidate();
		        request.setAttribute("message", message);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("Salary.jsp");
			dispatcher.forward(request, response);
		}
	}


}
