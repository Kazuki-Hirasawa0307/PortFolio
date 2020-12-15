package method;

import model.TimeListBean;

public class SalaryTotal {

	public  TimeListBean Total(TimeListBean returnSalary,TimeListBean tb) {
		TimeListBean returnTotal = new TimeListBean();

		int zsalary = returnSalary.getBase() / 170 * 125 / 100;					//残業時給・法定外休日時給
		int basesalary = returnSalary.getBase() / 170;								//時給
		int shinyabase = returnSalary.getBase() / 170 * 25 / 100;					//深夜割増給
		int houteisalary = returnSalary.getBase() / 170 * 135 / 100;				//法定休日時給

		int overtime = returnSalary.getOvertime();								//残業時間(*10000)取得
		int overh = overtime / 10000;											//残業時間取得
		int overm = (overtime - overh * 10000) / 167;							//残業分取得
		int overmoney = (overh * zsalary) + (overm * zsalary / 60);			//残業手当計算
		String overwork = (overh + " : " + overm);								//残業時間を文字列化

		int houteitime = returnSalary.getHouteitime();							//法定休日出勤時間(*10000)取得
		int houteih = houteitime / 10000;										//法定出勤時間取得
		int houteim = (houteitime - houteih * 10000) / 167;					//法定休日出勤分取得
		int houteimoney = (houteih * houteisalary) +
				(houteim * houteisalary / 60);									//法定休日出勤手当計算

		int hougaitime = returnSalary.getHougaitime();							//法定外出勤時間(*10000)取得
		int hougaih = hougaitime / 10000;										//法定外出勤時間取得
		int hougaim = (hougaitime - hougaih * 10000) / 167;					//法定外出勤分取得
		int hougaimoney = (hougaih * zsalary) + (hougaim * zsalary / 60);		//法定外出勤手当計算
		int dayoffh = houteih + hougaih;										//法定外・法定合わせた休日出勤時間
		int dayoffm = houteim + hougaim;										//法定外・法定合わせた休日出勤分
		int dayoffmoney = houteimoney + hougaimoney;							//合計の休日出勤手当
		String dayoffwork = (dayoffh + " : " + dayoffm);						//休日出勤時間文字列化


		int latetime = returnSalary.getLatetime();								//遅刻・早退時間(*10000)取得
		int lateh = latetime / 10000;											//遅刻・早退時間取得
		int latem = (latetime - lateh * 10000) / 167;							//遅刻・早退分取得
		int latemoney = (lateh * basesalary) + (latem * basesalary / 60);		//遅刻・早退控除計算
		String latework = (lateh + " : " + latem);								//遅刻・早退時間文字列化

		int shinyatime = returnSalary.getShinya();								//深夜勤務時間(*10000)取得
		int shinyah = shinyatime / 10000;										//深夜勤務時間取得
		int shinyam = (shinyatime - shinyah * 10000) / 167;					//深夜勤務分取得
		int shinyamoney = (shinyah + (shinyam / 60)) * shinyabase;				//深夜手当計算
		String shinyawork = (shinyah + " : " + shinyam);						//深夜勤務時間文字列化

		int worktime = returnSalary.getWorktime();								//勤務時間(*10000)取得
		int workh = worktime / 10000;											//勤務時間取得
		int workm = (worktime - workh * 10000) / 167;							//勤務分取得
		String workwork = (workh + " : " + workm);								//勤務時間文字列化
		int absencemoney = returnSalary.getAbsence() * basesalary * 8;			//欠勤控除計算

		int total = overmoney + houteimoney + hougaimoney + shinyamoney + returnSalary
				.getBase() +returnSalary.getPosition() + returnSalary.getTransport() + returnSalary.
				getFamily()+returnSalary.getHome() + returnSalary.getQualify();			//総支給計算

//		System.out.println(shinyamoney);


		int[] hoken = method.SocialInsurance(returnSalary.getHyouzyun());		//SocialInsuranceメソッドで社会保険額を計算しhoken配列に格納
		int nenkin = hoken[0];												//厚生年金額取得
		int kenkou = hoken[1];												//健康保険額取得
		int kaigo = hoken[2] - kenkou;										//介護保険額計算
		String now1 = String.valueOf(returnSalary.getYear()) + String.valueOf
				(returnSalary.getMonth()) + String.valueOf(tb.getSday());
		int now2 = Integer.parseInt(now1);
		int old = now2 - returnSalary.getBirthday();
		if(old < 400000) {
			kaigo = 0;
		}
		int koyou = hoken[3];												//雇用保険額取得
		int tax = total - nenkin - kenkou - kaigo - koyou
				- latemoney - returnSalary.getTransport() - absencemoney;						//課税対象額計算
		int syotoku = method.syotokuj(tax);								//syotokujメソッドから所得税取得

//ーーーーーー以下returnTotalへ格納し、Top.javaへ戻すーーーーーーーーーーー
		returnTotal.setNenkin(nenkin);				//年金
		returnTotal.setKenkou(kenkou);				//健康保険
		returnTotal.setKaigo(kaigo);				//介護保険料
		returnTotal.setKoyou(koyou);				//雇用保険
		returnTotal.setTax(tax);					//課税対象
		returnTotal.setSyotoku(syotoku);			//所得税
		returnTotal.setTotal(total);				//総支給
		returnTotal.setDayofftime(dayoffwork);		//休日出勤時間
		returnTotal.setDayoffhp(dayoffmoney);		//休日出勤手当
		returnTotal.setTisou(latework);				//遅刻・早退時間
		returnTotal.setTisoum(latemoney);			//遅刻・早退控除
		returnTotal.setShinyatotal(shinyamoney);	//深夜手当
		returnTotal.setZsalarys(overmoney);			//残業手当
		returnTotal.setMonthz(overwork);			//残業時間
		returnTotal.setMonthh(workwork);			//勤務時間
		returnTotal.setMonthn(shinyawork);			//深夜勤務時間
		returnTotal.setAbsencemoney(absencemoney);	//欠勤控除額


		return returnTotal;
	}
}
