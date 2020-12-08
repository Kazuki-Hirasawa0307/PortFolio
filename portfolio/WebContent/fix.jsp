<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)request.getAttribute("name");
String pass = (String)request.getAttribute("pass");
String loginId = (String)request.getAttribute("loginId");
int role = (Integer)request.getAttribute("role");
int family = (Integer)request.getAttribute("family");
int position = (Integer)request.getAttribute("position");
int transport = (Integer)request.getAttribute("transport");
int qualify = (Integer)request.getAttribute("qualify");
int base = (Integer)request.getAttribute("base");
int home = (Integer)request.getAttribute("home");
String birthday = (String)request.getAttribute("birthday");
int hyouzyun = (Integer)request.getAttribute("hyouzyun");
String mail = (String)request.getAttribute("mail");
int resident = (Integer)request.getAttribute("resident");


String rofix1 = null;
String rofix2 = null;
if(role == 1){
	rofix1 = "管理者登録に変更";
	rofix2 = "ユーザー登録を維持";
}else{
	rofix1 = "管理者登録を維持";
	rofix2 = "ユーザー登録に変更";
}

%>

<!DOCTYPE html>
<html>

<head>





	<meta charset="UTF-8">
	<title>社員情報修正ページ</title>
	<link rel="stylesheet" href="css\stylefix.css">

</head>

<body>

	<div class="container">
		<section id="content">
			<h1>社員情報修正ページ</h1>
			<h3>修正する箇所のみ記載してください。</h3>
			<h5>※名前は姓と名の間に全角の空白を入れてください。</h5>
			<h5>生年月日は数字8桁で入力してください。</h5>
			<h5>標準報酬月額は保険者の「標準報酬決定通知書」に記載の金額を入力してください</h5>
			<h5>住民税は納付書金額に従い入力してください。</h5>


			<form action="AccountFix" method="post">
				<table>
					<tbody>
						<tr>
							<th class=aa>項目</th>
							<th class=aa>現在情報</th>
							<th class=aa>修正項目</th>
						</tr>
						<tr>
							<th>名前</th>
							<td><%=name %></td>
							<td><input type="text" name="name" style="border-width:0px"></td>
						</tr>
						<tr>
							<th style="height: 74px;">LoginID</th>
							<td><%=loginId %></td>
							<td>IDは本人のみ変更可能です。</td>
						</tr>
						<tr>
							<th style="height: 74px;">Password</th>
							<td>非公開</td>
							<td>パスワードは本人のみ変更可能です</td>
						</tr>
						<tr>
							<th style="height: 74px;">メールアドレス</th>
							<td><%=mail %></td>
							<td><input type="text" name="mail" style="border-width:0px"></td>
						</tr>
						<tr>
							<th>生年月日</th>
							<td><%=birthday %></td>
							<td><input type="number" name="birthday" style="border-width:0px"></td>
						</tr>
						<tr>
							<th style="height: 74px;">登録ステータス</th>
							<td>ユーザー登録</td>
							<td>
								<input type="radio" name="role" value="1"><%=rofix1%><br>
								<input type="radio" name="role" value="2"><%=rofix2 %>
							</td>

						</tr>
						<tr>
							<th>基本給</th>
							<td><%=base %> 円</td>
							<td><input type="number" name="base" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>役職手当</th>
							<td><%=position %> 円</td>
							<td><input type="number" name="position" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>資格手当</th>
							<td><%=qualify %> 円</td>
							<td><input type="number" name="qualify" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>家族手当</th>
							<td><%=family %> 円</td>
							<td><input type="number" name="family" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>住宅手当</th>
							<td><%=family %> 円</td>
							<td><input type="number" name="home" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>交通費</th>
							<td><%=transport %> 円</td>
							<td><input type="number" name="transport" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>標準報酬月額</th>
							<td><%=hyouzyun %> 円</td>
							<td><input type="number" name="hyouzyun" style="border-width:0px"> 円</td>
						</tr>
						<tr>
							<th>月額住民税</th>
							<td><%=resident %> 円</td>
							<td><input type="number" name="resident" style="border-width:0px"> 円</td>
						</tr>

					</tbody>
				</table>


				<input type=hidden name=id value=<%=loginId %>>
				<input type=hidden name=pass value=<%=pass %>>
				<h5>送信前に入力内容を確認してください。</h5>
				<input type="submit" value="送信" onclick="func1()"><br>
			</form>
		</section>
	</div>

	<script>
		const func1 = () => {
			alert('社員情報を更新しました。');
		};

	</script>



</body>

</html>