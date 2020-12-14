<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css\stylefix.css">
<meta charset="UTF-8">
<title>新規登録</title>
</head>

<body>

	<div class="container">
		<section id="content">
			<form action="AccountRegister" method="post">
				<h1>社員情報新規登録ページ</h1>
				<h3 style="color: red">注意事項</h3>
				<h5>全ての項目を入力してください。</h5>
				<h5>名前は姓と名の間に全角の空白を入れてください。</h5>
				<h5>IDとPasswordは半角英数字で入力してください。</h5>
				<h5>
					標準報酬月額は確定してない場合は0と記入し、保険者より<br />「標準報酬決定通知書」が届き次第更新してください。
				</h5>
				<h5>住民税額が不明な場合は0と記入し、納付書が手元に届き次第更新してください。</h5>


				<table>
					<tbody>
						<tr>
							<th class=aa>項目</th>
							<th class=aa>新規登録項目</th>
						</tr>
						<tr>
							<th>名前</th>
							<td><input type="text" name="name" required></td>
						</tr>
						<tr>
							<th style="height: 74px;">LoginID</th>
							<td><input type="text" name="loginId" required
								onInput="checkForm(this)"></td>
						</tr>
						<tr>
							<th style="height: 74px;">Password</th>
							<td><input type="text" name="pass" required
								onInput="checkForm(this)"></td>
						</tr>
						<tr>
							<th style="height: 74px;">メールアドレス</th>
							<td><input type="text" name="mail" required></td>
						</tr>
						<tr>
							<th style="height: 74px;">生年月日(数字のみの8桁で入力)</th>
							<td><input type="number" name="birthday" required></td>
						</tr>
						<tr>
							<th style="height: 74px;">登録ステータス</th>
							<td><input type="radio" name="role" value="2">管理者で登録する
								<input type="radio" name="role" value="1" checked>ユーザーで登録する
							</td>
						</tr>
						<tr>
							<th>基本給</th>
							<td><input type="number" name="base" required> 円</td>
						</tr>
						<tr>
							<th>役職手当</th>
							<td><input type="number" name="position" required> 円</td>
						</tr>
						<tr>
							<th>資格手当</th>
							<td><input type="number" name="qualify" required> 円</td>
						</tr>
						<tr>
							<th>住宅手当</th>
							<td><input type="number" name="home" required> 円</td>
						</tr>
						<tr>
							<th>家族手当</th>
							<td><input type="number" name="family" required> 円</td>
						</tr>
						<tr>
							<th>交通費</th>
							<td><input type="number" name="transport" required>円</td>
						</tr>
						<tr>
							<th>標準報酬月額</th>
							<td><input type="number" name="hyouzyun" required> 円</td>
						</tr>
						<tr>
							<th>月額住民税</th>
							<td><input type="number" name="resident" required> 円</td>
						</tr>
					</tbody>
				</table>


				<h5>送信前に入力内容を確認してください。</h5>
				<input type="submit" value="送信" onclick="func1()"><br>
			</form>
			<a href="admin.jsp" class="aa">管理者ページへ</a> <br />
			<br />
			<br />
		</section>
	</div>

	<script type="text/javascript">

    const func1 = () => {
      alert('社員情報を登録しました。');
    };


    function checkForm($this)
    {
        var str=$this.value;
        while(str.match(/[^A-Z^a-z\d\-]/))
        {
            str=str.replace(/[^A-Z^a-z\d\-]/,"");
        }
        $this.value=str;
    }

    </script>


</body>

</html>