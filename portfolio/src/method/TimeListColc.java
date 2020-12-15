package method;

import java.util.ArrayList;

import model.TimeListBean;

public class TimeListColc {

	public TimeListBean Colc(TimeListBean tb) {

		TimeListBean returnTl = new TimeListBean();

		int dayHour = 0; //1日の勤務時間
		int dayMinute = 0; //1日の勤務分
		int monthHour = 0; //月の合計勤務時間
		int monthMinute = 0; //月の合計勤務分
		int dayzHour = 0; //1日の残業時間
		int dayzMinute = 0; //1日の残業分
		int monthzMinute = 0; //月の合計残業時間
		int monthzHour = 0; //月の合計残業分
		int finishHour = 0; //1日の終了時間
		int night = 0; //深夜勤務時間
		int nightm = 0; //深夜勤務分
		int znight = 0; //深夜残業
		int znightm = 0; //深夜残業分
		int monthnight = 0; //月の深夜勤務時間
		int monthnightm = 0; //月の深夜勤務分
		int workday = 0; //月の出勤日数
		ArrayList<Integer> dayHours = new ArrayList<>(); //1日の勤務時間配列
		ArrayList<Integer> dayMinutes = new ArrayList<>(); //1日の勤務分配列
		ArrayList<Integer> nights = new ArrayList<>(); //1日の深夜勤務時間配列
		ArrayList<Integer> nightsm = new ArrayList<>(); //1日の深夜勤務分配列
		ArrayList<Integer> dayzHours = new ArrayList<>(); //1日の残業時間配列
		ArrayList<Integer> dayzMinutes = new ArrayList<>(); //1日の残業分配列
		ArrayList<Integer> finishHours = new ArrayList<>(); //1日の終業時間配列
		ArrayList<Integer> znights = new ArrayList<>(); //1日の深夜残業時間配列
		ArrayList<Integer> znightsm = new ArrayList<>(); //1日の深夜残業分配列
		ArrayList<Integer> starthour = tb.getStarthour(); //ビーンより今月の出勤時間取得
		ArrayList<Integer> startminute = tb.getStartminute(); //ビーンより今月の出勤分取得
		ArrayList<Integer> finishhour = tb.getFinishhour(); //ビーンより今月の退勤時間取得
		ArrayList<Integer> finishminute = tb.getFinishminute(); //ビーンより今月の退勤時間取得

		if (tb.getParam() == 4) {
			int days = tb.getDays();
			for (int i = 0; i < days; i++) { //当月の日数回繰り返し
				finishHour = finishhour.get(i); //退勤時間が出勤時間より小さければ24時間プラス

				dayHour = finishHour - starthour.get(i) - 1; //1日の勤務時間を算出し休憩時間の1時間分マイナス
				if (dayHour < 0) { //1日の勤務時間がマイナスになったら0にする
					dayHour = 0;
				}
				dayMinute = finishminute.get(i) - startminute.get(i); //1日の勤務分を算出
				if (dayMinute < 0) { //分がマイナスになった場合に1時間マイナスし60分プラス
					dayMinute += 60;
					dayHour -= 1;
					if (dayHour < 0) { //1日の勤務時間がマイナスの場合に0にする
						dayHour = 0;
						dayMinute = 0;
					}
				}
				dayzHour = dayHour - 8; //1日の勤務時間から8時間引いて残業時間の算出
				dayzMinute = dayMinute;
				if (dayHour < 8) { //残業時間がマイナスの場合に時間分を0にする
					dayzHour = 0;
					dayzMinute = 0;
				}
				if (finishHour > 21) { //深夜勤務時間算出
					night = finishHour - 22;

				}
				if (night != 0) {
					nightm = finishminute.get(i);
					if (night > 7) {
						night = 7;
						nightm = 0;
					}
				}
				if (night != 0 && dayzHour != 0) {
					if (night < dayzHour) {
						znight = night;
						znightm = nightm;
					} else {
						znight = dayzHour;
						znightm = dayzMinute;
					}
				}
				if (starthour.get(i) == 0 && startminute.get(i) == 0 && finishminute.get(i) == 0) {
					finishHour = 0; //休日は各時間を0にする
					dayHour = 0;
					dayzHour = 0;
					night = 0;
					workday -= 1;
				}
				monthnight += night;
				monthnightm += nightm;
				monthHour += dayHour; //月の合計勤務時間を算出
				monthMinute += dayMinute; //月の合計勤務分を算出
				for (int u = 0; u < days; u++) { //月の合計勤務分が60分を超えた毎に1時間プラス60分マイナス
					if (monthMinute > 59) {
						monthMinute -= 60;
						monthHour += 1;
					}
				}
				monthzHour += dayzHour; //月の合計残業時間を計算
				monthzMinute += dayzMinute; //月の合計残業分を計算
				for (int q = 0; q < days; q++) {
					if (monthzMinute > 59) {
						monthzMinute -= 60;
						monthzHour += 1;
					}
					if (monthnightm > 59) {
						monthnightm -= 60;
						monthnight += 1;
					}
				}
				dayHours.add(dayHour);
				dayMinutes.add(dayMinute);
				dayzHours.add(dayzHour);
				dayzMinutes.add(dayzMinute);
				finishHours.add(finishHour);
				nights.add(night);
				nightsm.add(nightm);
				znights.add(znight);
				znightsm.add(znightm);
				night = 0;
				nightm = 0;
				znight = 0;
				znightm = 0;
				workday += 1;

			}
			returnTl.setFinishHours(finishHours);
			returnTl.setDayHours(dayHours);
			returnTl.setDayMinutes(dayMinutes);
			returnTl.setDayzHours(dayzHours);
			returnTl.setDayzMinutes(dayzMinutes);
			returnTl.setMonthHour(monthHour);
			returnTl.setMonthMinute(monthMinute);
			returnTl.setMonthzMinute(monthzMinute);
			returnTl.setMonthzHour(monthzHour);
			returnTl.setMonthnight(monthnight);
			returnTl.setNights(nights);
			returnTl.setMonthnightm(monthnightm);
			returnTl.setNightsm(nightsm);
			returnTl.setZnights(znights);
			returnTl.setZnightsm(znightsm);
			returnTl.setWorkday(workday);
		}

		if (tb.getParam() == 5) {

			int days = method.dismonthday(tb.getDisplaymonth(), tb.getSyear());
			System.out.println(days + ":4");
			for (int i = 0; i < days; i++) { //当月の日数回繰り返し
				finishHour = finishhour.get(i); //退勤時間が出勤時間より小さければ24時間プラス

				dayHour = finishHour - starthour.get(i) - 1; //1日の勤務時間を算出し休憩時間の1時間分マイナス
				if (dayHour < 0) { //1日の勤務時間がマイナスになったら0にする
					dayHour = 0;
				}
				dayMinute = finishminute.get(i) - startminute.get(i); //1日の勤務分を算出
				if (dayMinute < 0) { //分がマイナスになった場合に1時間マイナスし60分プラス
					dayMinute += 60;
					dayHour -= 1;
					if (dayHour < 0) { //1日の勤務時間がマイナスの場合に0にする
						dayHour = 0;
						dayMinute = 0;
					}
				}
				dayzHour = dayHour - 8; //1日の勤務時間から8時間引いて残業時間の算出
				dayzMinute = dayMinute;
				if (dayHour < 8) { //残業時間がマイナスの場合に時間分を0にする
					dayzHour = 0;
					dayzMinute = 0;
				}
				if (finishHour > 21) { //深夜勤務時間算出
					night = finishHour - 22;

				}
				if (night != 0) {
					nightm = finishminute.get(i);
					if (night > 7) {
						night = 7;
						nightm = 0;
					}
				}
				if (night != 0 && dayzHour != 0) {
					if (night < dayzHour) {
						znight = night;
						znightm = nightm;
					} else {
						znight = dayzHour;
						znightm = dayzMinute;
					}
				}
				if (starthour.get(i) == 0 && startminute.get(i) == 0 && finishminute.get(i) == 0) {
					finishHour = 0; //休日は各時間を0にする
					dayHour = 0;
					dayzHour = 0;
					night = 0;
					workday -= 1;
				}
				monthnight += night;
				monthnightm += nightm;
				monthHour += dayHour; //月の合計勤務時間を算出
				monthMinute += dayMinute; //月の合計勤務分を算出
				for (int u = 0; u < days; u++) { //月の合計勤務分が60分を超えた毎に1時間プラス60分マイナス
					if (monthMinute > 59) {
						monthMinute -= 60;
						monthHour += 1;
					}
				}
				monthzHour += dayzHour; //月の合計残業時間を計算
				monthzMinute += dayzMinute; //月の合計残業分を計算
				for (int q = 0; q < days; q++) {
					if (monthzMinute > 59) {
						monthzMinute -= 60;
						monthzHour += 1;
					}
					if (monthnightm > 59) {
						monthnightm -= 60;
						monthnight += 1;
					}
				}
				dayHours.add(dayHour);
				dayMinutes.add(dayMinute);
				dayzHours.add(dayzHour);
				dayzMinutes.add(dayzMinute);
				finishHours.add(finishHour);
				nights.add(night);
				nightsm.add(nightm);
				znights.add(znight);
				znightsm.add(znightm);
				night = 0;
				nightm = 0;
				znight = 0;
				znightm = 0;
				workday += 1;

			}
			returnTl.setFinishHours(finishHours);
			returnTl.setDayHours(dayHours);
			returnTl.setDayMinutes(dayMinutes);
			returnTl.setDayzHours(dayzHours);
			returnTl.setDayzMinutes(dayzMinutes);
			returnTl.setMonthHour(monthHour);
			returnTl.setMonthMinute(monthMinute);
			returnTl.setMonthzMinute(monthzMinute);
			returnTl.setMonthzHour(monthzHour);
			returnTl.setMonthnight(monthnight);
			returnTl.setNights(nights);
			returnTl.setMonthnightm(monthnightm);
			returnTl.setNightsm(nightsm);
			returnTl.setZnights(znights);
			returnTl.setZnightsm(znightsm);
			returnTl.setWorkday(workday);
			returnTl.setDays(days);
			System.out.println(days + ":6");

		}

		return returnTl;

	}

}
