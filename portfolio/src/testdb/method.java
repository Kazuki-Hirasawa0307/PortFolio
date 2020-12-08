package testdb;

import model.TimeListBean;

public class method {


	public static int[] SocialInsurance(int total) {		//標準報酬月額から社会保険類取得メソッド
		int[] hoken = new int[4];
		int koyou = total * 11 / 1000;
		hoken[3] = koyou;
		if (total < 63001) {
			hoken[0] = 8052;
			hoken[1] = 3018;
			hoken[2] = 3538;
			return hoken;
		} else if (total < 73001) {
			hoken[0] = 8052;
			hoken[1] = 3539;
			hoken[2] = 4148;
			return hoken;
		} else if (total < 83001) {
			hoken[0] = 8052;
			hoken[1] = 4059;
			hoken[2] = 4758;
			return hoken;
		} else if (total < 93001) {
			hoken[0] = 8052;
			hoken[1] = 4580;
			hoken[2] = 5368;
			return hoken;
		} else if (total < 101001) {
			hoken[0] = 8967;
			hoken[1] = 5100;
			hoken[2] = 5978;
			return hoken;
		} else if (total < 107001) {
			hoken[0] = 9516;
			hoken[1] = 5413;
			hoken[2] = 6344;
			return hoken;
		} else if (total < 114001) {
			hoken[0] = 10065;
			hoken[1] = 5725;
			hoken[2] = 6710;
			return hoken;
		} else if (total < 122001) {
			hoken[0] = 10797;
			hoken[1] = 6141;
			hoken[2] = 7198;
			return hoken;
		} else if (total < 130001) {
			hoken[0] = 11529;
			hoken[1] = 6558;
			hoken[2] = 7686;
			return hoken;
		} else if (total < 138001) {
			hoken[0] = 12261;
			hoken[1] = 6974;
			hoken[2] = 8174;
			return hoken;
		} else if (total < 146001) {
			hoken[0] = 12993;
			hoken[1] = 7391;
			hoken[2] = 8662;
			return hoken;
		} else if (total < 155001) {
			hoken[0] = 13725;
			hoken[1] = 7807;
			hoken[2] = 9150;
			return hoken;
		} else if (total < 165001) {
			hoken[0] = 14640;
			hoken[1] = 8328;
			hoken[2] = 9760;
			return hoken;
		} else if (total < 175001) {
			hoken[0] = 15555;
			hoken[1] = 8848;
			hoken[2] = 10370;
			return hoken;
		} else if (total < 185001) {
			hoken[0] = 16470;
			hoken[1] = 9369;
			hoken[2] = 10980;
			return hoken;
		} else if (total < 195001) {
			hoken[0] = 17385;
			hoken[1] = 9889;
			hoken[2] = 11590;
			return hoken;
		} else if (total < 210001) {
			hoken[0] = 18300;
			hoken[1] = 10410;
			hoken[2] = 12200;
			return hoken;
		} else if (total < 230001) {
			hoken[0] = 20130;
			hoken[1] = 11451;
			hoken[2] = 13420;
			return hoken;
		} else if (total < 250001) {
			hoken[0] = 21960;
			hoken[1] = 12492;
			hoken[2] = 14640;
			return hoken;
		} else if (total < 270001) {
			hoken[0] = 23790;
			hoken[1] = 13533;
			hoken[2] = 15860;
			return hoken;
		} else if (total < 290001) {
			hoken[0] = 25620;
			hoken[1] = 14574;
			hoken[2] = 17080;
			return hoken;
		} else if (total < 310001) {
			hoken[0] = 27450;
			hoken[1] = 15615;
			hoken[2] = 18300;
			return hoken;
		} else if (total < 330001) {
			hoken[0] = 29280;
			hoken[1] = 16656;
			hoken[2] = 19520;
			return hoken;
		} else if (total < 350001) {
			hoken[0] = 31110;
			hoken[1] = 17697;
			hoken[2] = 20740;
			return hoken;
		} else if (total < 370001) {
			hoken[0] = 32940;
			hoken[1] = 18738;
			hoken[2] = 21960;
			return hoken;
		} else if (total < 395001) {
			hoken[0] = 34770;
			hoken[1] = 19779;
			hoken[2] = 23180;
			return hoken;
		} else if (total < 425001) {
			hoken[0] = 37515;
			hoken[1] = 21340;
			hoken[2] = 25010;
			return hoken;
		} else if (total < 455001) {
			hoken[0] = 40260;
			hoken[1] = 22902;
			hoken[2] = 26840;
			return hoken;
		} else if (total < 485001) {
			hoken[0] = 43005;
			hoken[1] = 24463;
			hoken[2] = 28670;
			return hoken;
		} else if (total < 515001) {
			hoken[0] = 45750;
			hoken[1] = 26025;
			hoken[2] = 30500;
			return hoken;
		} else if (total < 545001) {
			hoken[0] = 48495;
			hoken[1] = 27586;
			hoken[2] = 32330;
			return hoken;
		} else if (total < 575001) {
			hoken[0] = 51240;
			hoken[1] = 29148;
			hoken[2] = 34160;
			return hoken;
		} else if (total < 605001) {
			hoken[0] = 53985;
			hoken[1] = 30709;
			hoken[2] = 35990;
			return hoken;
		} else if (total < 635001) {
			hoken[0] = 56730;
			hoken[1] = 32271;
			hoken[2] = 37820;
			return hoken;
		} else if (total < 665001) {
			hoken[0] = 59475;
			hoken[1] = 33832;
			hoken[2] = 39650;
			return hoken;
		} else if (total < 695001) {
			hoken[0] = 59475;
			hoken[1] = 35394;
			hoken[2] = 41480;
			return hoken;
		} else if (total < 730001) {
			hoken[0] = 59475;
			hoken[1] = 36955;
			hoken[2] = 43310;
			return hoken;
		} else if (total < 770001) {
			hoken[0] = 59475;
			hoken[1] = 39037;
			hoken[2] = 45750;
			return hoken;
		} else if (total < 810001) {
			hoken[0] = 59475;
			hoken[1] = 41119;
			hoken[2] = 48190;
			return hoken;
		} else if (total < 855001) {
			hoken[0] = 59475;
			hoken[1] = 43201;
			hoken[2] = 50630;
			return hoken;
		} else if (total < 905001) {
			hoken[0] = 59475;
			hoken[1] = 45804;
			hoken[2] = 53680;
			return hoken;
		} else if (total < 955001) {
			hoken[0] = 59475;
			hoken[1] = 48406;
			hoken[2] = 59780;
			return hoken;
		} else if (total < 1005001) {
			hoken[0] = 59475;
			hoken[1] = 51009;
			hoken[2] = 59780;
			return hoken;
		} else if (total < 1055001) {
			hoken[0] = 59475;
			hoken[1] = 53611;
			hoken[2] = 62830;
			return hoken;
		} else if (total < 1115001) {
			hoken[0] = 59475;
			hoken[1] = 56734;
			hoken[2] = 66490;
			return hoken;
		} else if (total < 1175001) {
			hoken[0] = 59475;
			hoken[1] = 59857;
			hoken[2] = 70150;
			return hoken;
		} else if (total < 1235001) {
			hoken[0] = 59475;
			hoken[1] = 62980;
			hoken[2] = 73810;
			return hoken;
		} else if (total < 1295001) {
			hoken[0] = 59475;
			hoken[1] = 66103;
			hoken[2] = 77470;
			return hoken;
		} else if (total < 1355001) {
			hoken[0] = 59475;
			hoken[1] = 69226;
			hoken[2] = 81130;
			return hoken;
		} else {
			hoken[0] = 59475;
			hoken[1] = 72349;
			hoken[2] = 84790;
			return hoken;
		}
	}

	public static int syotokuj(int tax) {					//課税対象額から所得税取得メソッド
		int taxs = tax * 12;
		int syotoku = 0;

		if (taxs < 1950001) {
			syotoku = taxs * 5 / 100 / 12;
			return syotoku;
		} else if (taxs < 3300001) {
			syotoku = (taxs / 10 - 97500) / 12;
			return syotoku;
		} else if (taxs < 6950001) {
			syotoku = (taxs * 2 / 10 - 427500) / 12;
			return syotoku;
		} else if (taxs < 9000001) {
			syotoku = (taxs * 23 / 100 - 636000) / 12;
			return syotoku;
		} else if (taxs < 18000001) {
			syotoku = (taxs * 33 / 100 - 1536000) / 12;
			return syotoku;
		} else if (taxs < 40000001) {
			syotoku = (taxs * 4 / 10 - 2796000) / 12;
			return syotoku;
		} else {
			syotoku = (taxs * 45 / 100 - 4796000) / 12;
			return syotoku;
		}
	}

	public static void monthday(TimeListBean tb) {			//現在月の日数取得メソッド
		int smonth = tb.getSmonth();
		int syear = tb.getSyear();
		int days = 0;
		 if (syear % 4 == 0) {
	            if ((syear % 100) == 0) {
	                if ((syear % 400) == 0) {
	                	if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
		              		days = 31;
	                	}else if(smonth==2) {
	                		days = 29;
	                	}else {
	                		days = 30;
	                	}
	                }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	            		days = 31;
	            	}else if(smonth == 2) {
	            		days = 28;
	            	}else {
	            		days = 30;
	            	}
	            }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	        		days = 31;
	        	}else if(smonth==2) {
	        		days = 29;
	        	}else {
	        		days = 30;
	        	}
	        }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	    		days = 31;
	    	}else if(smonth==2) {
	    		days = 29;
	    	}else {
	    		days = 30;
	    	}
	        tb.setDays(days);
	}

	public static int Salarymonthday(int smonth, int syear) {	//先月月取得メソッド
		int days = 0;
		 if (syear % 4 == 0) {
	            if ((syear % 100) == 0) {
	                if ((syear % 400) == 0) {
	                	if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
		              		days = 31;
	                	}else if(smonth==2) {
	                		days = 29;
	                	}else {
	                		days = 30;
	                	}
	                }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	            		days = 31;
	            	}else if(smonth == 2) {
	            		days = 28;
	            	}else {
	            		days = 30;
	            	}
	            }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	        		days = 31;
	        	}else if(smonth==2) {
	        		days = 29;
	        	}else {
	        		days = 30;
	        	}
	        }else if(smonth == 1 || smonth == 3 || smonth == 5 || smonth == 7 || smonth == 8 || smonth == 10 || smonth == 12) {
	    		days = 31;
	    	}else if(smonth==2) {
	    		days = 29;
	    	}else {
	    		days = 30;
	    	}
	        return days;
	}
}
