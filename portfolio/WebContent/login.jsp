

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css\login.css">

<meta charset="UTF-8">
<title>トップ画面</title>
</head>

<body>
	<div class="container">
		<section id="content">
			<form method="post" action="AccountSearch">
				<h1>Login Form</h1>
				<h6>半角英数字で入力してください。</h6>
				<%
					String message = (String) request.getAttribute("message");
				if (message != null) {
				%>
				<h3 style="color: red"><%=message%></h3>
				<%
					}
				%>
				<div>
					<input type="text" placeholder="Login ID" required="" id="username"
						name="loginId" onInput="checkForm(this)" />
				</div>
				<div>
					<input type="password" placeholder="Password" required=""
						id="password" name="pass" onInput="checkForm(this)" />
				</div>
				<div>
					<input type="submit" value="Login" />
				</div>
			</form>
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