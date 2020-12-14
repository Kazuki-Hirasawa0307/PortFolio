<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css\login.css">

<meta charset="UTF-8">
<title>社員情報修正ページ</title>
</head>

<body>
	<div class="container">
		<section id="content">
			<form method="get" action="AccountSearch">
				<h2>
					情報を修正する社員の名前と<br />LoginIDを入力してください
				</h2>
				<%
					String message = (String) request.getAttribute("message");
				if (message != null) {
				%>
				<h3 style="color: red"><%=message%></h3>
				<%
					}
				%>
				<h5>※名前は姓と名の間に全角の空白を入れてください。</h5>
				<div>
					<input type="text" placeholder="フルネーム" required id="username"
						name="name" />
				</div>
				<div>
					<input type="text" placeholder="Login ID" required id="username"
						name="loginId" onInput="checkForm(this)" />
				</div>
				<div>
					<input type="submit" value="送信" />
				</div>
			</form>
		<a href="admin.jsp" class="aa">管理者ページへ</a> <br />
		<br />
		<br />
		</section>
	</div>
</body>

<script type="text/javascript">
	function checkForm($this) {
		var str = $this.value;
		while (str.match(/[^A-Z^a-z\d\-]/)) {
			str = str.replace(/[^A-Z^a-z\d\-]/, "");
		}
		$this.value = str;
	}
</script>

</html>