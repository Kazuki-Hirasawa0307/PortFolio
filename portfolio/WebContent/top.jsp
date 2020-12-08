<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int role = (Integer)request.getAttribute("role");
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>勤怠管理システム</title>
  <link rel="stylesheet" href="css\style.css">
  <link rel="stylesheet" href="css\styleseihai.css">
</head>

<body>
  <header>
    <img src="img\google-headquarters.jpg" class="topPic" >
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
      <div class="dadada">
        <p class="kouhou">今週の広報</p>
        <a href="">
          <img src="img\21023010-広報-wordcloud-のイラスト.jpg" alt="" class="kaoPic"></a>
      </div>
      <hr width="80%" align="left">

      <div class="dadadada">
        <p class="daihyo">今月の社内表彰</p>
        <a href="">
          <img src="img\20170703_07_01.jpg" alt="" class="kaoPic"></a>
      </div>
      <hr width="80%" align="left">
      <div class="dadada">
        <p class="daihyo">代表より皆様へ</p>
        <a href="">
          <img src="img\IMGP2187.JPG" alt="" class="kaoPic"></a>
      </div>
    </aside>
    <main>
      <h1>株式会社 ○○<br />
        　　　勤怠管理システム</h1>
      <hr />
      <h3>
        本サイトより○○社の勤怠管理・申請手続き・給与明細確認を行えます。<br />
        各申請、勤怠管理は遅滞なく正確に行ってください。<br />
        当サイトについて操作方法が不明な場合はメニュー内のヘルプを参照してください。<br />
      </h3>
      <p>下記注意事項</p>
      <ul>
        <li>給与確認は毎月15日に更新されます。</li>

      </ul>
    </main>
    <nav id="nav">
      <ul>
        <li><a href="http://localhost:8080/portfolio/topj">トップページ</a></li>
        <li><a href="http://localhost:8080/portfolio/statusCheak">打刻</a></li>
        <li><a href="http://localhost:8080/portfolio/timelist">勤務時間一覧</a></li>
        <li><a href="http://localhost:8080/portfolio/Salary">給与計算</a></li>
        <li><a href="http://localhost:8080/portfolio/Logout">ログアウト</a></li>
<%if(role == 2){%>
			<li><a href="admin.jsp">管理者ページ</a></li>
<%}%>

      </ul>
    </nav>
  </div>
  <footer>
    <hr />
    各種操作は右上メニューボタンより操作してください<br />
    エラーが発生した場合にはシステム部まで問い合わせください。<br />
    システム部 TEL 011-000-0000

  </footer>
  <script src="js\script.js"></script>
</body>

</html>