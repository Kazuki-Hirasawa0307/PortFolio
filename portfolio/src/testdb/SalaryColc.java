package testdb;

import java.util.ArrayList;

import model.TimeListBean;

public class SalaryColc {

	public SalaryColc(TimeListBean tb) {
		int month = tb.getSalarymonth();
		int year = tb.getSalaryyear();
		int day = method.Salarymonthday(month, year);
		int workday = 0;								//出勤日
		int monthHour = 0; 							//月の合計勤務時間
		int monthMinute = 0; 							//月の合計勤務分
		int monthzMinute = 0; 							//月の合計残業時間
		int monthzHour = 0; 							//月の合計残業分
		int monthnight = 0; 							//月の深夜勤務時間
		int monthnightm = 0; 							//月の深夜勤務分
		int tisoutime = 0;								//遅刻早退回数
		int tisouhour = 0;								//遅刻早退累計時間
		int tisouminute = 0;							//遅刻早退累計分
		int satdayh = 0;								//法定外休日出勤時間
		int satdaym = 0;								//法定外休日出勤分
		int sundayh = 0;								//法定休日出勤時間
		int sundaym = 0;								//法定休日出勤分
		int dayofft = 0;								//休日出勤回数
		int dayHour = 0;								//1日の出勤時間
		int dayMinute = 0;								//1日の出勤分
		int dayzHour = 0; 								//1日の残業時間
		int dayzMinute = 0; 							//1日の残業分
		int night = 0; 									//深夜勤務時間
		int nightm = 0; 								//深夜勤務分

		ArrayList<Integer> starthour = tb.getSalarystarthour(); 			//今月の出勤時間取得
		ArrayList<Integer> startminute = tb.getSalarystartminute(); 		//今月の出勤分取得
		ArrayList<Integer> finishhour = tb.getSalaryfinishhour(); 		//今月の退勤時間取得
		ArrayList<Integer> finishminute = tb.getSalaryfinishminute(); 	//今月の退勤分取得
		ArrayList<String> weeks = tb.getSalaryweeks();					//今月の曜日配列取得


		for (int i = 0; i < day; i++) { 							//当月の日数回繰り返し
			String week = weeks.get(i);
			int finishHour = finishhour.get(i);
			int startHour = starthour.get(i);
			int finishMinute = finishminute.get(i);
			int startMinute = startminute.get(i);

			if (finishHour < startHour) {							//退勤時間が出勤時間より小さければ24時間足す
				finishHour += 24;
			}

			dayHour = finishHour - startHour - 1; 					//1日の勤務時間を算出し休憩時間の1時間分マイナス
			if (dayHour < 0) { 										//1日の勤務時間がマイナスになったら(休日)0にする
				dayHour = 0;
			}

			dayMinute = finishMinute - startMinute; 				//1日の勤務分を算出
			if (dayMinute < 0) { 									//分がマイナスになった場合に1時間マイナスし60分プラス
				dayMinute += 60;
				dayHour -= 1;
				if (dayHour < 0) {									//1日の勤務時間がマイナスの場合に24時間プラス
					dayHour += 24;
				}
			}

			dayzHour = dayHour - 8; 								//1日の勤務時間から8時間引いて残業時間の算出
			dayzMinute = dayMinute;									//勤務分をそのまま残業分にする
			if (dayHour < 8) { 										//残業時間が無い場合に時間分を0にする
				dayzHour = 0;
				dayzMinute = 0;
			}

			if (finishHour > 21) { 									//深夜勤務時間算出(22時より深夜勤務)
				night = finishHour - 22;
			}

			if (night != 0) {										//深夜勤務が22-5時までなので最大7時間とする
				nightm = finishMinute;								//深夜勤務分は退勤分とする
				if (night > 7) {
					night = 7;
					nightm = 0;										//深夜時間が最大の7時間の場合に分を0にする
				}
			}

			if (startHour == 0 && startMinute == 0 && finishMinute == 0) {
				finishHour = 0; 									//休日は各時間を0にし、出勤日をｰ1する
				dayHour = 0;
				dayzHour = 0;
				night = 0;
				workday -= 1;
			}

			if (week.equals("土")) {								//法定外休日の計算
				if (finishHour != 0 && startHour != 0) {			//土曜でかつ出勤終了時間が0じゃない場合に休日出勤
					satdayh += finishHour - startHour;
					satdaym = finishMinute - startMinute;
					if (satdaym < 0) {
						satdaym += 60;
						satdayh -= 1;
					}
					dayofft += 1;
				}
			}

			if (week.equals("日")) {								//法定休日の計算
				if (finishHour != 0) {								//日曜でかつ出勤退勤時間が0じゃない場合に休日出勤
					sundayh += finishHour - startHour;
					sundaym = finishMinute - startMinute;
					if (sundaym < 0) {
						sundaym += 60;
						sundayh -= 1;
					}
					dayofft += 1;
				}
			}

			if (startHour > 8) {									//休日以外は9時以降に出勤した場合に遅刻
				if (!(week.equals("土"))) {
					if (!(week.equals("日"))) {
						tisoutime += 1;
						tisouhour += startHour - 9;
						tisouminute += startMinute;
					}
				}
			}

			if (finishHour < 18 && finishHour != 0) {				//休日以外で18時前に退勤の場合に早退
				if (!(week.equals("土"))) {
					if (!(week.equals("日"))) {
						tisoutime += 1;
						tisouhour += 17 - finishHour;
						tisouminute += 60 - finishMinute;
						System.out.println(week);
					}
				}
			}

			monthnight += night;									//深夜勤務時間を月の合計に足す
			monthnightm += nightm;									//深夜勤務分を月の合計に足す
			monthHour += dayHour; 									//勤務時間を月の合計に足す
			monthMinute += dayMinute; 								//勤務分を月の合計に足す
			monthzHour += dayzHour; 								//月の合計残業時間を計算
			monthzMinute += dayzMinute; 							//月の合計残業分を計算
			for (int u = 0; u < day; u++) { 						//月の合計分が60分を超えた毎に1時間足す60分引く
				if (monthMinute > 59) {
					monthMinute -= 60;
					monthHour += 1;
				}
				if (monthzMinute > 59) {
					monthzMinute -= 60;
					monthzHour += 1;
				}
				if (monthnightm > 59) {
					monthnightm -= 60;
					monthnight += 1;
				}
				if (tisouminute > 59) {
					tisouminute -= 60;
					tisouhour += 1;
				}
				if (sundaym > 59) {
					sundaym -= 60;
					sundayh += 1;
				}
				if (satdaym > 59) {
					satdaym -= 60;
					satdayh += 1;
				}
			}
			night = 0;
			nightm = 0;
			workday += 1;
		}


//ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー

			int workhour = monthHour * 10000;
			int workminute = monthMinute * 167 ;
			int worktime = workhour + workminute;
			int overhour = monthzHour * 10000;
			int overminute = monthzMinute * 167 ;
			int overtime = overhour + overminute;
			int dayoffworkday = dayofft;
			int nightworkhour = monthnight * 10000;
			int nightworkminute = monthnightm * 167 ;
			int nightworktime = nightworkhour + nightworkminute;
			int lateday = tisoutime;
			int latehour = tisouhour * 10000;
			int lateminute = tisouminute * 167 ;
			int latetime = latehour + lateminute;
			int houteih = sundayh * 10000;
			int houteim = sundaym * 167;
			int houteitime = houteih + houteim;
			int hougaih = satdayh * 10000;
			int hougaim = satdaym * 167;
			int hougaitime = hougaih + hougaim;

			//以下DBへインサートする値
			tb.setWorkday(workday);					//出勤日数
			tb.setWorktime(worktime);				//出勤時間
			tb.setOvertime(overtime);				//残業時間
			tb.setHouteitime(houteitime);			//法定休日時出勤時間
			tb.setHougaitime(hougaitime);			//法定外休日出勤時間
			tb.setDayoffworkday(dayoffworkday);		//休日出勤日数
			tb.setNightworktime(nightworktime);		//深夜勤務時間
			tb.setLateday(lateday);					//遅刻・早退回数
			tb.setLatetime(latetime);				//遅刻・早退時間

	}

}
