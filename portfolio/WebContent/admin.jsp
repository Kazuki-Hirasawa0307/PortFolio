<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css\admin.css">

<meta charset="UTF-8">
<title>管理者ページ</title>
</head>

<body>
	<div class="container">
		<section id="content">
			<h1>管理者ページ</h1>
			<h2>
				<a href="emplofix.jsp" class="aa">社員情報修正ページ</a>
			</h2>
			<br />
			<div>
				登録されている社員情報のIDとPassword以外が<br />こちらから変更可能です。
			</div>
			<hr />
			<h2>
				<a href="register.jsp" class="aa">社員新規追加ページ</a>
			</h2>
			<br />
			<div>
				社員の新規アカウントの作成ページです
				<hr />
			</div>
			<h2>
				<a href="emplofix.jsp" class="aa">社員の有給、欠勤入力フォーム</a>
			</h2>
			<br />
			<div>
				管理社員の内、有給・欠勤があった社員の<br />
				情報をこちらから入力してください。<br />
				前月分を次月の10日までに更新してください。
				<hr />
			</div>
			<h2>
				<a href="http://localhost:8080/portfolio/topj">勤怠システム</a>
			</h2>
			<br />
			<div>自身の勤怠管理ページへリンクします</div>

			<br /> <br /> <br /> <br />
		</section>
	</div>
</body>

</html>