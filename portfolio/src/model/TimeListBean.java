package model;

import java.util.ArrayList;

public class TimeListBean {
	private ArrayList<Integer> startday;
	private ArrayList<Integer> starthour;
	private ArrayList<Integer> startminute;
	private ArrayList<Integer> finishday;
	private ArrayList<Integer> finishhour;
	private ArrayList<Integer> finishminute;
	private ArrayList<String> weeks;
	private int syear;
    private int smonth;
    private int sday;
    private int shour;
    private int sminute;
    private int ssecond;
    private int fyear;
    private int fmonth;
    private int fday;
    private int fhour;
    private int fminute;
    private int fsecond;
    private int month;
    private int days;
    private String startstatus;
    private String finishstatus;
    private String week;
    private int param;

    private String loginId;
    private String pass;
    private String name;
    private int role;
    private int base;
    private int position;
    private int qualify;
    private int family;
    private int transport;
    private int resident;

    private String nrole;
    private String nbase;
    private String nposition;
    private String nqualify;
    private String nfamily;
    private String ntransport;
    private String nname;
    private String npass;
    private String nloginId;
    private String mail;
    private int birthday;
    private int home;
    private int hyouzyun;
    private String nmail;
    private String nbirthday;
    private String nhome;
    private String nhyouzyun;
    private String nresident;

    private int workday;
    private int total;
    private int tisoum;
    private int shinyatotal;
    private int zsalarys;
    private String monthz;
    private String monthh;
    private String monthn;
    private int tisoutime;
    private String tisou;
    private String dayofftime;
    private int dayoffhp;
    private int dayofft;
    private int dayoffh;
    private int dayoffm;
    private int tisouhour;
    private int tisouminute;

    private ArrayList<Integer> finishHours;
    private ArrayList<Integer> dayHours;
	private ArrayList<Integer> dayMinutes;
	private ArrayList<Integer> dayzHours;
	private ArrayList<Integer> dayzMinutes;
	private int monthHour;
	private int monthMinute;
	private int monthzMinute;
	private int monthzHour;
	private int monthnight;
	private ArrayList<Integer> nights;
	private int monthnightm;
	private ArrayList<Integer> nightsm;
	private ArrayList<Integer> znights;
	private ArrayList<Integer> znightsm;
	private int monthznight;
	private int monthznightm;

	private int worktime;
	private int overtime;
	private int dayoffworkday;
	private int dayofftimes;
	private int nightworktime;
	private int lateday;
	private int latetime;
	private int houteitime;
	private int hougaitime;
	private int nightworkday;

	private int beforedays;
	private int year;
	private int shinya;
	private int paidvacation;
	private int absence;

	private int nenkin;
	private int kaigo;
	private int kenkou;
	private int koyou;
	private int syotoku;
	private int tax;
	private int absencemoney;

	private int salarystartmonth;
	private int salarystartyear;
	private ArrayList<Integer> salarystartday;
	private ArrayList<Integer> salarystarthour;
	private ArrayList<Integer> salarystartminute;
	private ArrayList<String> salaryweeks;
	private int salaryfinishmonth;
	private int salaryfinishyear;
	private ArrayList<Integer> salaryfinishday;
	private ArrayList<Integer> salaryfinishhour;
	private ArrayList<Integer> salaryfinishminute;
	private int salaryyear;
	private int salarymonth;

	private String dayoffname;
	private String dayoffid;
	private String joinname;
	private String joinid;
	private int dayoffyear;
	private int dayoffmonth;
	private int dayoffday;
	private int daystatus;

	private ArrayList<String> dayoffnames;
	private ArrayList<String> dayoffids;
	private ArrayList<Integer> daystatuses;
	private ArrayList<Integer> dayoffyears;
	private ArrayList<Integer> dayoffmonths;
	private ArrayList<Integer> dayoffdays;
	private ArrayList<String> joinnames;
	private ArrayList<String> joinids;
	private String message;

	private int displaymonth;
	ArrayList<Integer> dmonth;


	public ArrayList<Integer> getDmonth() {
		return dmonth;
	}
	public void setDmonth(ArrayList<Integer> dmonth) {
		this.dmonth = dmonth;
	}
	public int getDisplaymonth() {
		return displaymonth;
	}
	public void setDisplaymonth(int displaymonth) {
		this.displaymonth = displaymonth;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<String> getDayoffnames() {
		return dayoffnames;
	}
	public void setDayoffnames(ArrayList<String> dayoffnames) {
		this.dayoffnames = dayoffnames;
	}
	public ArrayList<String> getDayoffids() {
		return dayoffids;
	}
	public void setDayoffids(ArrayList<String> dayoffids) {
		this.dayoffids = dayoffids;
	}
	public ArrayList<Integer> getDaystatuses() {
		return daystatuses;
	}
	public void setDaystatuses(ArrayList<Integer> daystatuses) {
		this.daystatuses = daystatuses;
	}
	public ArrayList<Integer> getDayoffyears() {
		return dayoffyears;
	}
	public void setDayoffyears(ArrayList<Integer> dayoffyears) {
		this.dayoffyears = dayoffyears;
	}
	public ArrayList<Integer> getDayoffmonths() {
		return dayoffmonths;
	}
	public void setDayoffmonths(ArrayList<Integer> dayoffmonths) {
		this.dayoffmonths = dayoffmonths;
	}
	public ArrayList<Integer> getDayoffdays() {
		return dayoffdays;
	}
	public void setDayoffdays(ArrayList<Integer> dayoffdays) {
		this.dayoffdays = dayoffdays;
	}
	public ArrayList<String> getJoinnames() {
		return joinnames;
	}
	public void setJoinnames(ArrayList<String> joinnames) {
		this.joinnames = joinnames;
	}
	public ArrayList<String> getJoinids() {
		return joinids;
	}
	public void setJoinids(ArrayList<String> joinids) {
		this.joinids = joinids;
	}
	public String getDayoffname() {
		return dayoffname;
	}
	public void setDayoffname(String dayoffname) {
		this.dayoffname = dayoffname;
	}
	public String getDayoffid() {
		return dayoffid;
	}
	public void setDayoffid(String dayoffid) {
		this.dayoffid = dayoffid;
	}
	public String getJoinname() {
		return joinname;
	}
	public void setJoinname(String joinname) {
		this.joinname = joinname;
	}
	public String getJoinid() {
		return joinid;
	}
	public void setJoinid(String joinid) {
		this.joinid = joinid;
	}
	public int getDayoffyear() {
		return dayoffyear;
	}
	public void setDayoffyear(int dayoffyear) {
		this.dayoffyear = dayoffyear;
	}
	public int getDayoffmonth() {
		return dayoffmonth;
	}
	public void setDayoffmonth(int dayoffmonth) {
		this.dayoffmonth = dayoffmonth;
	}
	public int getDayoffday() {
		return dayoffday;
	}
	public void setDayoffday(int dayoffday) {
		this.dayoffday = dayoffday;
	}
	public int getDaystatus() {
		return daystatus;
	}
	public void setDaystatus(int daystatus) {
		this.daystatus = daystatus;
	}
	public int getSalaryyear() {
		return salaryyear;
	}
	public void setSalaryyear(int salaryyear) {
		this.salaryyear = salaryyear;
	}
	public int getSalarymonth() {
		return salarymonth;
	}
	public void setSalarymonth(int salarymonth) {
		this.salarymonth = salarymonth;
	}
	public int getSalarystartmonth() {
		return salarystartmonth;
	}
	public void setSalarystartmonth(int salarystartmonth) {
		this.salarystartmonth = salarystartmonth;
	}
	public int getSalarystartyear() {
		return salarystartyear;
	}
	public void setSalarystartyear(int salarystartyear) {
		this.salarystartyear = salarystartyear;
	}
	public ArrayList<Integer> getSalarystartday() {
		return salarystartday;
	}
	public void setSalarystartday(ArrayList<Integer> salarystartday) {
		this.salarystartday = salarystartday;
	}
	public ArrayList<Integer> getSalarystarthour() {
		return salarystarthour;
	}
	public void setSalarystarthour(ArrayList<Integer> salarystarthour) {
		this.salarystarthour = salarystarthour;
	}
	public ArrayList<Integer> getSalarystartminute() {
		return salarystartminute;
	}
	public void setSalarystartminute(ArrayList<Integer> salarystartminute) {
		this.salarystartminute = salarystartminute;
	}
	public ArrayList<String> getSalaryweeks() {
		return salaryweeks;
	}
	public void setSalaryweeks(ArrayList<String> salaryweeks) {
		this.salaryweeks = salaryweeks;
	}
	public int getSalaryfinishmonth() {
		return salaryfinishmonth;
	}
	public void setSalaryfinishmonth(int salaryfinishmonth) {
		this.salaryfinishmonth = salaryfinishmonth;
	}
	public int getSalaryfinishyear() {
		return salaryfinishyear;
	}
	public void setSalaryfinishyear(int salaryfinishyear) {
		this.salaryfinishyear = salaryfinishyear;
	}
	public ArrayList<Integer> getSalaryfinishday() {
		return salaryfinishday;
	}
	public void setSalaryfinishday(ArrayList<Integer> salaryfinishday) {
		this.salaryfinishday = salaryfinishday;
	}
	public ArrayList<Integer> getSalaryfinishhour() {
		return salaryfinishhour;
	}
	public void setSalaryfinishhour(ArrayList<Integer> salaryfinishhour) {
		this.salaryfinishhour = salaryfinishhour;
	}
	public ArrayList<Integer> getSalaryfinishminute() {
		return salaryfinishminute;
	}
	public void setSalaryfinishminute(ArrayList<Integer> salaryfinishminute) {
		this.salaryfinishminute = salaryfinishminute;
	}
	public int getAbsencemoney() {
		return absencemoney;
	}
	public void setAbsencemoney(int absencemoney) {
		this.absencemoney = absencemoney;
	}
	public int getNenkin() {
		return nenkin;
	}
	public void setNenkin(int nenkin) {
		this.nenkin = nenkin;
	}
	public int getKaigo() {
		return kaigo;
	}
	public void setKaigo(int kaigo) {
		this.kaigo = kaigo;
	}
	public int getKenkou() {
		return kenkou;
	}
	public void setKenkou(int kenkou) {
		this.kenkou = kenkou;
	}
	public int getKoyou() {
		return koyou;
	}
	public void setKoyou(int koyou) {
		this.koyou = koyou;
	}
	public int getSyotoku() {
		return syotoku;
	}
	public void setSyotoku(int syotoku) {
		this.syotoku = syotoku;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getShinya() {
		return shinya;
	}
	public void setShinya(int shinya) {
		this.shinya = shinya;
	}
	public int getPaidvacation() {
		return paidvacation;
	}
	public void setPaidvacation(int paidvacation) {
		this.paidvacation = paidvacation;
	}
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getBeforedays() {
		return beforedays;
	}
	public void setBeforedays(int beforedays) {
		this.beforedays = beforedays;
	}
	public int getHouteitime() {
		return houteitime;
	}
	public void setHouteitime(int houteitime) {
		this.houteitime = houteitime;
	}
	public int getHougaitime() {
		return hougaitime;
	}
	public void setHougaitime(int hougaitime) {
		this.hougaitime = hougaitime;
	}
	public int getNightworkday() {
		return nightworkday;
	}
	public void setNightworkday(int nightworkday) {
		this.nightworkday = nightworkday;
	}
	public int getLatetime() {
		return latetime;
	}
	public int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	public int getOvertime() {
		return overtime;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	public int getDayoffworkday() {
		return dayoffworkday;
	}
	public void setDayoffworkday(int dayoffworkday) {
		this.dayoffworkday = dayoffworkday;
	}
	public int getDayofftimes() {
		return dayofftimes;
	}
	public void setDayofftimes(int dayofftimes) {
		this.dayofftimes = dayofftimes;
	}
	public int getNightworktime() {
		return nightworktime;
	}
	public void setNightworktime(int nightworktime) {
		this.nightworktime = nightworktime;
	}
	public int getLateday() {
		return lateday;
	}
	public void setLateday(int lateday) {
		this.lateday = lateday;
	}
	public void setLatetime(int latetime) {
		this.latetime = latetime;
	}
	public int getTisouhour() {
		return tisouhour;
	}
	public void setTisouhour(int tisouhour) {
		this.tisouhour = tisouhour;
	}
	public int getTisouminute() {
		return tisouminute;
	}
	public void setTisouminute(int tisouminute) {
		this.tisouminute = tisouminute;
	}
	public int getDayoffh() {
		return dayoffh;
	}
	public void setDayoffh(int dayoffh) {
		this.dayoffh = dayoffh;
	}
	public int getDayoffm() {
		return dayoffm;
	}
	public void setDayoffm(int dayoffm) {
		this.dayoffm = dayoffm;
	}
	public String getNresident() {
		return nresident;
	}
	public void setNresident(String nresident) {
		this.nresident = nresident;
	}
	public int getResident() {
		return resident;
	}
	public void setResident(int resident) {
		this.resident = resident;
	}
	public ArrayList<Integer> getFinishHours() {
		return finishHours;
	}
	public void setFinishHours(ArrayList<Integer> finishHours) {
		this.finishHours = finishHours;
	}
	public ArrayList<Integer> getDayHours() {
		return dayHours;
	}
	public void setDayHours(ArrayList<Integer> dayHours) {
		this.dayHours = dayHours;
	}
	public ArrayList<Integer> getDayMinutes() {
		return dayMinutes;
	}
	public void setDayMinutes(ArrayList<Integer> dayMinutes) {
		this.dayMinutes = dayMinutes;
	}
	public ArrayList<Integer> getDayzHours() {
		return dayzHours;
	}
	public void setDayzHours(ArrayList<Integer> dayzHours) {
		this.dayzHours = dayzHours;
	}
	public ArrayList<Integer> getDayzMinutes() {
		return dayzMinutes;
	}
	public void setDayzMinutes(ArrayList<Integer> dayzMinutes) {
		this.dayzMinutes = dayzMinutes;
	}
	public int getMonthHour() {
		return monthHour;
	}
	public void setMonthHour(int monthHour) {
		this.monthHour = monthHour;
	}
	public int getMonthMinute() {
		return monthMinute;
	}
	public void setMonthMinute(int monthMinute) {
		this.monthMinute = monthMinute;
	}
	public int getMonthzMinute() {
		return monthzMinute;
	}
	public void setMonthzMinute(int monthzMinute) {
		this.monthzMinute = monthzMinute;
	}
	public int getMonthzHour() {
		return monthzHour;
	}
	public void setMonthzHour(int monthzHour) {
		this.monthzHour = monthzHour;
	}
	public int getMonthnight() {
		return monthnight;
	}
	public void setMonthnight(int monthnight) {
		this.monthnight = monthnight;
	}
	public ArrayList<Integer> getNights() {
		return nights;
	}
	public void setNights(ArrayList<Integer> nights) {
		this.nights = nights;
	}
	public int getMonthnightm() {
		return monthnightm;
	}
	public void setMonthnightm(int monthnightm) {
		this.monthnightm = monthnightm;
	}
	public ArrayList<Integer> getNightsm() {
		return nightsm;
	}
	public void setNightsm(ArrayList<Integer> nightsm) {
		this.nightsm = nightsm;
	}
	public ArrayList<Integer> getZnights() {
		return znights;
	}
	public void setZnights(ArrayList<Integer> znights) {
		this.znights = znights;
	}
	public ArrayList<Integer> getZnightsm() {
		return znightsm;
	}
	public void setZnightsm(ArrayList<Integer> znightsm) {
		this.znightsm = znightsm;
	}
	public int getMonthznight() {
		return monthznight;
	}
	public void setMonthznight(int monthznight) {
		this.monthznight = monthznight;
	}
	public int getMonthznightm() {
		return monthznightm;
	}
	public void setMonthznightm(int monthznightm) {
		this.monthznightm = monthznightm;
	}
	public int getWorkday() {
		return workday;
	}
	public void setWorkday(int workday) {
		this.workday = workday;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTisoum() {
		return tisoum;
	}
	public void setTisoum(int tisoum) {
		this.tisoum = tisoum;
	}
	public int getShinyatotal() {
		return shinyatotal;
	}
	public void setShinyatotal(int shinyatotal) {
		this.shinyatotal = shinyatotal;
	}
	public int getZsalarys() {
		return zsalarys;
	}
	public void setZsalarys(int zsalarys) {
		this.zsalarys = zsalarys;
	}
	public String getMonthz() {
		return monthz;
	}
	public void setMonthz(String monthz) {
		this.monthz = monthz;
	}
	public String getMonthh() {
		return monthh;
	}
	public void setMonthh(String monthh) {
		this.monthh = monthh;
	}
	public String getMonthn() {
		return monthn;
	}
	public void setMonthn(String monthn) {
		this.monthn = monthn;
	}
	public int getTisoutime() {
		return tisoutime;
	}
	public void setTisoutime(int tisoutime) {
		this.tisoutime = tisoutime;
	}
	public String getTisou() {
		return tisou;
	}
	public void setTisou(String tisou) {
		this.tisou = tisou;
	}
	public String getDayofftime() {
		return dayofftime;
	}
	public void setDayofftime(String dayofftime) {
		this.dayofftime = dayofftime;
	}
	public int getDayoffhp() {
		return dayoffhp;
	}
	public void setDayoffhp(int dayoffhp) {
		this.dayoffhp = dayoffhp;
	}
	public int getDayofft() {
		return dayofft;
	}
	public void setDayofft(int dayofft) {
		this.dayofft = dayofft;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getQualify() {
		return qualify;
	}
	public void setQualify(int qualify) {
		this.qualify = qualify;
	}
	public int getFamily() {
		return family;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	public int getTransport() {
		return transport;
	}
	public void setTransport(int transport) {
		this.transport = transport;
	}
	public String getNrole() {
		return nrole;
	}
	public void setNrole(String nrole) {
		this.nrole = nrole;
	}
	public String getNbase() {
		return nbase;
	}
	public void setNbase(String nbase) {
		this.nbase = nbase;
	}
	public String getNposition() {
		return nposition;
	}
	public void setNposition(String nposition) {
		this.nposition = nposition;
	}
	public String getNqualify() {
		return nqualify;
	}
	public void setNqualify(String nqualify) {
		this.nqualify = nqualify;
	}
	public String getNfamily() {
		return nfamily;
	}
	public void setNfamily(String nfamily) {
		this.nfamily = nfamily;
	}
	public String getNtransport() {
		return ntransport;
	}
	public void setNtransport(String ntransport) {
		this.ntransport = ntransport;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNpass() {
		return npass;
	}
	public void setNpass(String npass) {
		this.npass = npass;
	}
	public String getNloginId() {
		return nloginId;
	}
	public void setNloginId(String nloginId) {
		this.nloginId = nloginId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}
	public int getHyouzyun() {
		return hyouzyun;
	}
	public void setHyouzyun(int hyouzyun) {
		this.hyouzyun = hyouzyun;
	}
	public String getNmail() {
		return nmail;
	}
	public void setNmail(String nmail) {
		this.nmail = nmail;
	}
	public String getNbirthday() {
		return nbirthday;
	}
	public void setNbirthday(String nbirthday) {
		this.nbirthday = nbirthday;
	}
	public String getNhome() {
		return nhome;
	}
	public void setNhome(String nhome) {
		this.nhome = nhome;
	}
	public String getNhyouzyun() {
		return nhyouzyun;
	}
	public void setNhyouzyun(String nhyouzyun) {
		this.nhyouzyun = nhyouzyun;
	}
	public int getParam() {
		return param;
	}
	public void setParam(int param) {
		this.param = param;
	}

	public ArrayList<String> getWeeks() {
    	return weeks;
    }
    public void setWeeks(ArrayList<String> weeks) {
    	this.weeks = weeks;
    }
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}

	public String getStartstatus() {
		return startstatus;
	}
	public void setStartstatus(String startstatus) {
		this.startstatus = startstatus;
	}
	public String getFinishstatus() {
		return finishstatus;
	}
	public void setFinishstatus(String finishstatus) {
		this.finishstatus = finishstatus;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public ArrayList<Integer> getStartday() {
		return startday;
	}
	public void setStartday(ArrayList<Integer> startday) {
		this.startday = startday;
	}
	public ArrayList<Integer> getStarthour() {
		return starthour;
	}
	public void setStarthour(ArrayList<Integer> starthour) {
		this.starthour = starthour;
	}
	public ArrayList<Integer> getStartminute() {
		return startminute;
	}
	public void setStartminute(ArrayList<Integer> startminute) {
		this.startminute = startminute;
	}
	public ArrayList<Integer> getFinishday() {
		return finishday;
	}
	public void setFinishday(ArrayList<Integer> finishday) {
		this.finishday = finishday;
	}
	public ArrayList<Integer> getFinishhour() {
		return finishhour;
	}
	public void setFinishhour(ArrayList<Integer> finishhour) {
		this.finishhour = finishhour;
	}
	public ArrayList<Integer> getFinishminute() {
		return finishminute;
	}
	public void setFinishminute(ArrayList<Integer> finishminute) {
		this.finishminute = finishminute;
	}
	public int getSyear() {
		return syear;
	}
	public void setSyear(int syear) {
		this.syear = syear;
	}
	public int getSmonth() {
		return smonth;
	}
	public void setSmonth(int smonth) {
		this.smonth = smonth;
	}
	public int getSday() {
		return sday;
	}
	public void setSday(int sday) {
		this.sday = sday;
	}
	public int getShour() {
		return shour;
	}
	public void setShour(int shour) {
		this.shour = shour;
	}
	public int getSminute() {
		return sminute;
	}
	public void setSminute(int sminute) {
		this.sminute = sminute;
	}
	public int getSsecond() {
		return ssecond;
	}
	public void setSsecond(int ssecond) {
		this.ssecond = ssecond;
	}
	public int getFyear() {
		return fyear;
	}
	public void setFyear(int fyear) {
		this.fyear = fyear;
	}
	public int getFmonth() {
		return fmonth;
	}
	public void setFmonth(int fmonth) {
		this.fmonth = fmonth;
	}
	public int getFday() {
		return fday;
	}
	public void setFday(int fday) {
		this.fday = fday;
	}
	public int getFhour() {
		return fhour;
	}
	public void setFhour(int fhour) {
		this.fhour = fhour;
	}
	public int getFminute() {
		return fminute;
	}
	public void setFminute(int fminute) {
		this.fminute = fminute;
	}
	public int getFsecond() {
		return fsecond;
	}
	public void setFsecond(int fsecond) {
		this.fsecond = fsecond;
	}



}

