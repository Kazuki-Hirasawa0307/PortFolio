<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
	// Get_RequestScope
@SuppressWarnings("unchecked")
ArrayList<Integer> startday = (ArrayList<Integer>) request.getAttribute("startday");
@SuppressWarnings("unchecked")
ArrayList<Integer> starthour = (ArrayList<Integer>) request.getAttribute("starthour");
@SuppressWarnings("unchecked")
ArrayList<Integer> startminute = (ArrayList<Integer>) request.getAttribute("startminute");
@SuppressWarnings("unchecked")
ArrayList<Integer> finishday = (ArrayList<Integer>) request.getAttribute("finishday");
@SuppressWarnings("unchecked")
ArrayList<Integer> finishHours = (ArrayList<Integer>) request.getAttribute("finishHours");
@SuppressWarnings("unchecked")
ArrayList<Integer> finishminute = (ArrayList<Integer>) request.getAttribute("finishminute");
@SuppressWarnings("unchecked")
ArrayList<Integer> dayHours = (ArrayList<Integer>) request.getAttribute("dayHours");
@SuppressWarnings("unchecked")
ArrayList<Integer> dayMinutes = (ArrayList<Integer>) request.getAttribute("dayMinutes");
@SuppressWarnings("unchecked")
ArrayList<Integer> dayzHours = (ArrayList<Integer>) request.getAttribute("dayzHours");
@SuppressWarnings("unchecked")
ArrayList<Integer> dayzMinutes = (ArrayList<Integer>) request.getAttribute("dayzMinutes");
@SuppressWarnings("unchecked")
ArrayList<Integer> nights = (ArrayList<Integer>) request.getAttribute("nights");
@SuppressWarnings("unchecked")
ArrayList<Integer> nightsm = (ArrayList<Integer>) request.getAttribute("nightsm");
@SuppressWarnings("unchecked")
ArrayList<String> weeks = (ArrayList<String>) request.getAttribute("weeks");
Integer monthHour = (Integer) request.getAttribute("monthHour");
Integer monthMinute = (Integer) request.getAttribute("monthMinute");
Integer monthzHour = (Integer) request.getAttribute("monthzHour");
Integer monthzMinute = (Integer) request.getAttribute("monthzMinute");
Integer smonth = (Integer) request.getAttribute("smonth");
Integer sday = (Integer) request.getAttribute("sday");
Integer monthnight = (Integer) request.getAttribute("monthnight");
Integer monthnightm = (Integer) request.getAttribute("monthnightm");
Integer workday = (Integer) request.getAttribute("workday");
String nenkin = (String) request.getAttribute("nenkin");
int role = (Integer) request.getAttribute("role");
String name = (String) request.getAttribute("name");
String id = (String) request.getAttribute("id");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>出退勤一覧</title>
<link rel="stylesheet" href="css\timelist.css">

</head>

<body>
	<header>
		<img src="img\timesheets.jpg" class="topPic">
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
			<h1>出退勤一覧</h1>
			<hr>

			<body bgcolor="#ffffff">

				<%--  ーーーーーーーーーーー｜勤務時間表｜－－－ーー－－－－－－－ --%>
				<TABLE border="1">
					<tr>
						<th><%=smonth%>月</th>
						<th>曜日</th>
						<th colspan="2">出勤時間(定時9時)</th>
						<th colspan="2">退勤時間(定時18時)</th>
						<th colspan="2">勤務時間(定時8時間)</th>
						<th colspan="2">残業時間</th>
						<th colspan="2">深夜勤務時間</th>
					</tr>

					<%
						for (int i = 0; i < sday; i++) {
						String week = weeks.get(i);
					%>
					<%
						if (week.equals("土")) {
					%>
					<tr>
						<th align="center"><font color="blue"> <%=i + 1%>日
						</font></th>
						<th align="center"><font color="blue"> <%=week%></font></th>
						<%
							} else if (week.equals("日")) {
						%>

					<tr>
						<th align="center"><font color="red"><%=i + 1%>日</font></th>
						<th align="center"><font color="red"> <%=week%></font></th>
						<%
							} else {
						%>

					<tr>
						<th align="center"><%=i + 1%>日</th>
						<th align="center"><%=week%></th>
						<%
							}
						%>
						<td style="border-right-style: hidden;" align="right"><%=starthour.get(i)%>
							時</td>
						<td style="border-left-style: hidden;"><%=startminute.get(i)%>
							分</td>
						<td style="border-right-style: hidden;" align="right"><%=finishHours.get(i)%>
							時</td>
						<td style="border-left-style: hidden;"><%=finishminute.get(i)%>
							分</td>
						<td style="border-right-style: hidden;" align="right"><%=dayHours.get(i)%>
							時間</td>
						<td style="border-left-style: hidden;"><%=dayMinutes.get(i)%>
							分</td>
						<td style="border-right-style: hidden;" align="right"><%=dayzHours.get(i)%>
							時間</td>
						<td style="border-left-style: hidden;"><%=dayzMinutes.get(i)%>
							分</td>
						<td style="border-right-style: hidden;" align="right"><%=nights.get(i)%>
							時間</td>
						<td style="border-left-style: hidden;"><%=nightsm.get(i)%>
							分</td>
					</tr>
					<%
						}
					%>
					<tr>
						<th>合計</th>
						<td></td>
						<td colspan="4" align="center">出勤日数 ： <%=workday%> 日
						</td>
						<td style="border-right-style: hidden;" align="right"><%=monthHour%>時間</td>
						<td style="border-left-style: hidden;"><%=monthMinute%>分</td>
						<td style="border-right-style: hidden;" align="right"><%=monthzHour%>時間</td>
						<td style="border-left-style: hidden;"><%=monthzMinute%>分</td>
						<td style="border-right-style: hidden;" align="right"><%=monthnight%>時間</td>
						<td style="border-left-style: hidden;"><%=monthnightm%>分</td>

					</tr>
				</TABLE>


				<%--  ーーーーーーーーー｜ハンバーガーメニュー｜－－－－－－－－－－ --%>
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
	<%--  ーーーーーーーーーーー｜フッター｜ーーー－－－－－－－－－－ --%>

	<footer>
		<div class="foot">
				<h3>ログイン情報</h3>
				<div class="login">
					<p>社員名 : <%=name %></p>&emsp;&emsp;
					<p>社員番号 : <%=id %></p>
				</div>
				<hr style="width:100%; border-top: 1px dashed #8c8b8b;"/>
			<div class="footmenu">
				各種操作は右上メニューボタンより操作してください<br /> エラーが発生した場合には○○まで問い合わせください。<br />
				システム部 TEL 011-000-0000
			</div>
		</div>
	</footer>

	<%--  ーーーーーーーーーーーーーーーーー－－－－ーーーー－－－－－－ --%>


	<script src="js\script.js"></script>
</body>

</html>