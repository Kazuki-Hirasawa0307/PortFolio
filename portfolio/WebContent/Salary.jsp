<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
	String name = (String) request.getAttribute("name");
int base = (Integer) request.getAttribute("base");
int family = (Integer) request.getAttribute("family");
int position = (Integer) request.getAttribute("position");
int qualify = (Integer) request.getAttribute("qualify");
int transport = (Integer) request.getAttribute("transport");
int workday = (Integer) request.getAttribute("workday");
int total = (Integer) request.getAttribute("total");
int shinyatotal = (Integer) request.getAttribute("shinyatotal");
int zsalarys = (Integer) request.getAttribute("zsalarys");
String monthz = (String) request.getAttribute("monthz");
int tax = (Integer) request.getAttribute("tax");
String monthh = (String) request.getAttribute("monthh");
String monthn = (String) request.getAttribute("monthn");
int nenkin = (Integer) request.getAttribute("nenkin");
int kenkou = (Integer) request.getAttribute("kenkou");
int kaigo = (Integer) request.getAttribute("kaigo");
int koyou = (Integer) request.getAttribute("koyou");
int syotoku = (Integer) request.getAttribute("syotoku");
int home = (Integer) request.getAttribute("home");
int tisoutime = (Integer) request.getAttribute("tisoutime");
String tisou = (String) request.getAttribute("tisou");
int tisoum = (Integer) request.getAttribute("tisoum");
int dayofft = (Integer) request.getAttribute("dayofft");
int dayoffhp = (Integer) request.getAttribute("dayoffhp");
String dayofftime = (String) request.getAttribute("dayofftime");
int resident = (Integer) request.getAttribute("resident");
int role = (Integer) request.getAttribute("role");
int absence = (Integer) request.getAttribute("absence");
int absencemoney = (Integer) request.getAttribute("absencemoney");
int paidvacation = (Integer) request.getAttribute("paidvacation");
String id = (String) request.getAttribute("id");
int year = (Integer) request.getAttribute("year");
int month = (Integer) request.getAttribute("month");
@SuppressWarnings("unchecked")ArrayList<Integer> dmonth = (ArrayList<Integer>)request.getAttribute("dmonth");

int kouzyo = kenkou + kaigo + nenkin + koyou + syotoku + resident + tisoum + absencemoney;
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>勤怠管理 打刻</title>
<link rel="stylesheet" href="css\saraly.css">
</head>

<body>
	<header>
		<img src="img\payslip.jpg" class="topPic">
		<div class="mask" id="mask"></div>
		<a class="menuButton" id="menuButton">
			<div></div>
			<div></div>
			<div></div>
		</a>
	</header>
	<div>
		<aside>
			<h3>社内お知らせ</h3>
			<div class="kouhou">
				<p>広報</p>
				<a href=""> <img src="img\21023010-広報-wordcloud-のイラスト.jpg"
					alt="" class="kaoPic"></a>
			</div>

			<div class="hyousyou">
				<p>社内表彰</p>
				<a href=""> <img src="img\20170703_07_01.jpg" alt=""
					class="kaoPic"></a>
			</div>
		</aside>

		<main>
			<h1>給与明細</h1>
			<hr />
			<h3 style="text-align: center; margin-bottom: 3px; margin-top: 3px;">
				名前 :
				<%=name%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				社員ID :
				<%=id%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%=year%>
				年
				<%=month%>
				月分
			</h3>
			<hr />

			<!--  -->
			<form action="Salary" method="post">
				<select name="displaymonth">
					<%
					for(int i = 0; i < dmonth.size(); i++){
					%>
					<option value=<%=dmonth.get(i) %>><%=year%>年<%=dmonth.get(i) %>月分</option>
					<%
					}
					%>
				</select>
				<input type="submit" value="表示" />
			</form>

			<table border="1" class="sa">
				<tr>
					<th rowspan="4" style="width: 25px;">勤怠</th>
					<th>出勤日数</th>
					<th>有給日数</th>
					<th>欠勤日数</th>
					<th>出勤時間</th>
					<th>残業時間</th>
					<th></th>
				</tr>
				<tr>
					<th><%=workday%> 日</th>
					<th><%=paidvacation%> 日</th>
					<th><%=absence%> 日</th>
					<th><%=monthh%></th>
					<th><%=monthz%></th>
					<th></th>
				</tr>
				<tr>
					<th>休日出勤日数</th>
					<th>休日出勤時間</th>
					<th>深夜勤務</th>
					<th>遅早回数</th>
					<th>遅早時間</th>
					<th></th>
				</tr>
				<tr>
					<th><%=dayofft%> 日</th>
					<th><%=dayofftime%></th>
					<th><%=monthn%></th>
					<th><%=tisoutime%> 回</th>
					<th><%=tisou%></th>
					<th></th>
				</tr>
			</table>
			<br />
			<table border="1" class="sa">
				<tr>
					<th rowspan="4" style="width: 25px;">支給</th>
					<th>基本給</th>
					<th>役職手当</th>
					<th>住宅手当</th>
					<th>家族手当</th>
					<th>残業手当</th>
					<th>資格手当</th>
				</tr>
				<tr>
					<th><%=base%> 円</th>
					<th><%=position%> 円</th>
					<th><%=home%> 円</th>
					<th><%=family%> 円</th>
					<th><%=zsalarys%> 円</th>
					<th><%=qualify%> 円</th>
				</tr>
				<tr>
					<th>深夜手当</th>
					<th>通勤費(非)</th>
					<th>休日出勤手当</th>
					<th></th>
					<th>課税対象</th>
					<th>総支給</th>
				</tr>
				<tr>
					<th><%=shinyatotal%> 円</th>
					<th><%=transport%> 円</th>
					<th><%=dayoffhp%> 円</th>
					<th></th>
					<th><%=tax%> 円</th>
					<th><%=total%> 円</th>
				</tr>
			</table>
			<br />
			<table border="1" class="sa">
				<tr>
					<th rowspan="4" style="width: 25px;">控除</th>
					<th>健康保険</th>
					<th>介護保険</th>
					<th>厚生年金</th>
					<th>雇用保険</th>
					<th></th>
					<th>社会保険</th>
				</tr>
				<tr>
					<th><%=kenkou%> 円</th>
					<th><%=kaigo%> 円</th>
					<th><%=nenkin%> 円</th>
					<th><%=koyou%> 円</th>
					<th></th>
					<th><%=kenkou + kaigo + nenkin + koyou%> 円</th>
				</tr>
				<tr>
					<th>所得税</th>
					<th>住民税</th>
					<th>遅早控除</th>
					<th>欠勤控除</th>
					<th></th>
					<th>控除額</th>
				</tr>
				<tr>
					<th><%=syotoku%> 円</th>
					<th><%=resident%> 円</th>
					<th><%=tisoum%> 円</th>
					<th><%=absencemoney%> 円</th>
					<th></th>
					<th><%=kouzyo%> 円</th>
				</tr>
			</table>

			<br />
			<table border="1" class="sa">
				<tr>
					<th rowspan="2" style="width: 25px;">支給額</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>銀行振込額</th>
					<th>差引支給額</th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th><%=total - kouzyo%> 円</th>
					<th><%=total - kouzyo%> 円</th>
				</tr>
			</table>


		</main>
		<nav id="nav">
			<ul>
				<li><a href="http://localhost:8080/portfolio/topj">トップページ</a></li>
				<li><a href="http://localhost:8080/portfolio/statusCheak">打刻</a></li>
				<li><a href="http://localhost:8080/portfolio/timelist">勤務時間一覧</a></li>
				<li><a href="http://localhost:8080/portfolio/DayOff">休暇申請フォーム</a></li>
				<li><a href="http://localhost:8080/portfolio/Salary">給与計算</a></li>
				<li><a href="http://localhost:8080/portfolio/Logout">ログアウト</a></li>
				<%
					if (role == 2) {
				%>
				<li><a href="admin.jsp">管理者ページ</a></li>
				<%
					}
				%>
			</ul>
		</nav>
	</div>
	<footer>
		<div class="foot">
			<h3>ログイン情報</h3>
			<div class="login">
				<p>社員名 : <%=name%></p>&emsp;&emsp;
				<p>社員番号 : <%=id%></p>
			</div>
			<hr style="width: 100%; border-top: 1px dashed #8c8b8b;" />
			<div class="footmenu">
				各種操作は右上メニューボタンより操作してください<br /> エラーが発生した場合には○○まで問い合わせください。<br />
				システム部 TEL 011-000-0000
			</div>
		</div>
	</footer>
	<script src="js\script.js"></script>
</body>

</html>