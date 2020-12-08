window.onload = function(){
  myClock.timeImage();
  setInterval("myClock.timeImage()", 1000);
  }
  var myClock = {
  timeImage : function(){
  var dateObj = new Date();
  var h = "0"+dateObj.getHours();
  var m = "0"+dateObj.getMinutes();
  var s = "0"+dateObj.getSeconds();
  var year = dateObj.getFullYear();
  var month = dateObj.getMonth()+1;
  var week = dateObj.getDay();
  var day = dateObj.getDate();
  h = h.substring(h.length-2, h.length);
  m = m.substring(m.length-2, m.length);
  s = s.substring(s.length-2, s.length);
  var imageTag = document.getElementById("iTime").getElementsByTagName("img");
  imageTag[0].src = 'img\\figure-'+h.charAt(0)+".png";
  imageTag[1].src = 'img\\figure-'+h.charAt(1)+".png";
  imageTag[3].src = 'img\\figure-'+m.charAt(0)+".png";
  imageTag[4].src = 'img\\figure-'+m.charAt(1)+".png";
  imageTag[6].src = 'img\\figure-'+s.charAt(0)+".png";
  imageTag[7].src = 'img\\figure-'+s.charAt(1)+".png";
  var data = document.getElementById("data");
  }
}



  const timer = document.getElementById('timer');
  const start = document.getElementById('start');
  const stop = document.getElementById('stop');
  const reset = document.getElementById('reset');
  const startt = document.getElementById('startt');
  const stopp = document.getElementById('stopp');

if(start != null){
  start.addEventListener('click', () => {
    window.alert("打刻を開始しました");
  });
}else{
  startt.addEventListener('click', () => {
    window.alert("出勤中の為、無効な操作です");
  });
}

if(stop != null){
  stop.addEventListener('click', () => {
    window.alert("勤務時間が送信されました");
  });
}else{
    stopp.addEventListener('click', () => {
    window.alert("勤務外の為、無効な操作です");
  });
}



