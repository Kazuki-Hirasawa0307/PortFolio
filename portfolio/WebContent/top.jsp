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
<title>勤怠管理システム</title>
<link rel="stylesheet" href="css\top.css">
</head>


<body>
	<header>
		<img src="img\apap.jpg" class="topPic">
		<div class="mask" id="mask"></div>
		<a class="menuButton" id="menuButton">
			<div></div>
			<div></div>
			<div></div>
		</a>
	</header>

	<div class="aaa" id="aaa">

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
			<h1>トップページ</h1>
			<hr />

			<h3>
				本サイトより○○社の勤怠管理・休暇申請手続き・給与明細確認を行えます。<br /> 申請、勤怠管理は遅滞なく正確に行ってください。<br />
			</h3>

			<p>下記注意事項</p>
			<ul>
				<li>給与確認は毎月10日に更新されます。</li>
				<li>ログイン後30分で再度ログインが必要となります。</li>
				<li>各種操作は右上ボタンより行えます。</li>
			</ul>

			<div class="menumenu">
				<a href="http://localhost:8080/portfolio/topj"> <img
					src="img\working_d06.png" alt="" class="menupic"></a>
				<div class="menu2">
					<a href="http://localhost:8080/portfolio/topj">打刻システム</a>
					<p>
						出勤・退勤時に使用するページです。<br /> 一度出勤・退勤ボタンを押すと修正できませんのでご注意ください。
					</p>
				</div>
			</div>

			<div class="menumenu">
				<a href="http://localhost:8080/portfolio/topj"> <img
					src="img\clock2.jpg" alt="" class="menupic"></a>
				<div class="menu2">
					<a href="http://localhost:8080/portfolio/topj">出退勤時間一覧</a>
					<p>
						今月の出勤・退勤時間一覧を確認できます。<br /> 出勤・退勤ボタンの時間と連動しておりリアルタイムで反映されます。
					</p>
				</div>
			</div>

			<div class="menumenu">
				<a href="http://localhost:8080/portfolio/topj"> <img
					src="img\dayoff.jpg" alt="" class="menupic"></a>
				<div class="menu2">
					<a href="http://localhost:8080/portfolio/topj">休暇申請フォーム</a>
					<p>
						休暇の申請ができます<br /> 前後一カ月間の申請中・承認済の休暇も確認できます。<br />
						こちらから承認済になった休暇が明細へ自動的にカウントされます。
					</p>
				</div>
			</div>

			<div class="menumenu">
				<a href="http://localhost:8080/portfolio/topj"> <img
					src="img\salary.jpg" alt="" class="menupic"></a>
				<div class="menu2">
					<a href="http://localhost:8080/portfolio/topj">給与明細</a>
					<p>
						就職してから今までの明細を確認できます。<br /> 給与計算は1日～末日分が、次月の10日に更新されます。
					</p>
				</div>
			</div>

			<div class="menumenu">
				<a href="http://localhost:8080/portfolio/topj"> <img
					src="img\rogout.jpg" alt="" class="menupic"></a>
				<div class="menu2">
					<a href="http://localhost:8080/portfolio/topj">ログアウト</a>
					<p>
						こちらからログアウトできます。<br /> 操作が終了した場合には防犯のためログアウトしてください。
					</p>
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