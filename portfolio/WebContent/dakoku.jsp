<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String name = (String) request.getAttribute("name");
String id = (String) request.getAttribute("id");
int role = (Integer) request.getAttribute("role");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>勤怠管理 打刻</title>
<link rel="stylesheet" href="css\dakoku.css">
</head>
<body>
	<header>
		<img src="img\dakoku.jpg" class="topPic">
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
				<a href=""> <img src="img\21023010-広報-wordcloud-のイラスト.jpg" alt="" class="kaoPic"></a>
			</div>
			<div class="hyousyou">
				<p>社内表彰</p>
				<a href=""> <img src="img\20170703_07_01.jpg" alt="" class="kaoPic"></a>
			</div>
		</aside>
		<main>
			<h1 class="title">打刻・退勤</h1>
			<hr>
			<div class="aaa">現在のステータス</div>
			<%
				String status = (String) request.getAttribute("status");
			%>
			<%
				if (status == "kinmu") {
			%>
			<h2 class="status">At work</h2>
			<%
				} else if (status == "taikin") {
			%>
			<h2 class="status">Off work</h2>
			<%
				} else if (status == "finish") {
			%>
			<h2 class="status">本日もお疲れさまでした！</h2>
			<%
				} else {
			%>
			<h2 class="status">Error</h2>
			<%
				}
			%>
			<div class="pp">現在時刻</div>
			<div class="bodyB">
				<div class="headerB">
					<div id="iTime" class="time">
						<img src="img\figure-0.png" width="80" height="120">
						<img src="img\figure-1.png" width="80" height="120">
						<img src="img\figure-colon.png" width="10" height="120">
						<img src="img\figure-2.png" width="80" height="120">
						<img src="img\figure-3.png" width="80" height="120">
						<img src="img\figure-colon.png" width="10" height="120">
						<img src="img\figure-4.png" width="80" height="120">
						<img src="img\figure-5.png" width="80" height="120">
					</div>
				</div>
				<div class="mainB">
					<div class="left">
						<%
							if (status.equals("taikin")) {
						%>
						<div class="right" id="start">
							<form action="dakoku" method="GET" name='ab' id='ab'>
								<a href="#" class="btn1">
									<div id="start " class="aas"
										onclick='document.getElementById("ab").submit()'>&emsp;&emsp;&emsp;&nbsp;
										出勤</div>
								</a>
							</form>
						</div>
						<%
							} else {
						%>
						<div class="right" id="startt">
							<form action="statusCheak" method="GET" name='ab' id='ab'>
								<a href="#" class="btn1">
									<div id="startt" class="aas"
										onclick='document.getElementById("ab").submit()'>
										&emsp;&emsp;&emsp;&nbsp; 出勤</div>
								</a>
							</form>
						</div>
						<%
							}
						%>

						<%
							if (status.equals("kinmu")) {
						%>
						<div class="right" id="stop">
							<form action="dakoku" method="POST" name='abc' id='abc'>
								<a href="#" class="btn2">
									<div id="stop" class="aas"
										onclick='document.getElementById("abc").submit()'>&emsp;&emsp;&emsp;&nbsp;
										退社</div>
								</a>
							</form>
						</div>
						<%
							} else {
						%>
						<div class="right" id="stopp">
							<form action="statusCheak" method="GET" name='abc' id='abc'>
								<a href="#" class="btn2">
									<div id="stopp" class="aas"
										onclick='document.getElementById("abc").submit()'>&emsp;&emsp;&emsp;&nbsp;
										退社</div>
								</a>
							</form>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
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
	<script src="js\dakoku.js"></script>
	<script src="js\script.js"></script>
</body>

</html>