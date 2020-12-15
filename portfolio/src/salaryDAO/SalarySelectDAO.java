package salaryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import model.TimeListBean;

//DBより給与計算に必要な値を取得するDAO
public class SalarySelectDAO {
	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "root";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

	public TimeListBean salary(TimeListBean tb) {
		TimeListBean returnSalary = new TimeListBean();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = null;
		int year = 0;
		int month = 0;
		int workday = 0;
		int overtime = 0;
		int worktime = 0;
		int houteitime = 0;
		int hougaitime = 0;
		int dayoffworkday = 0;
		int shinya = 0;
		int lateday = 0;
		int latetime = 0;
		int paidvacation = 0;
		int absence = 0;
		int base = 0;
		int position = 0;
		int qualify = 0;
		int family = 0;
		int transport = 0;
		int home = 0;
		int hyouzyun = 0;
		int resident = 0;
		ArrayList<Integer> dmonth = new ArrayList<Integer>();
		ArrayList<Integer> dyear = new ArrayList<Integer>();



		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
			if (tb.getParam() == 2) {
				sql = "SELECT * FROM " + tb.getLoginId() + "account WHERE month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tb.getSalarymonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					year = rs.getInt("year");
					month = rs.getInt("month");
					workday = rs.getInt("workday");
					worktime = rs.getInt("worktime");
					overtime = rs.getInt("overtime");
					houteitime = rs.getInt("houteitime");
					hougaitime = rs.getInt("hougaitime");
					dayoffworkday = rs.getInt("dayoffworkday");
					lateday = rs.getInt("lateday");
					latetime = rs.getInt("latetime");
					shinya = rs.getInt("shinya");
					paidvacation = rs.getInt("paidvacation");
					absence = rs.getInt("absence");
					base = rs.getInt("base");
					position = rs.getInt("position");
					qualify = rs.getInt("qualify");
					family = rs.getInt("family");
					transport = rs.getInt("transport");
					home = rs.getInt("home");
					hyouzyun = rs.getInt("hyozyun");
					resident = rs.getInt("resident");




				}

				returnSalary.setYear(year);
				returnSalary.setMonth(month);
				returnSalary.setWorkday(workday);
				returnSalary.setWorktime(worktime);
				returnSalary.setOvertime(overtime);
				returnSalary.setHouteitime(houteitime);
				returnSalary.setHougaitime(hougaitime);
				returnSalary.setDayoffworkday(dayoffworkday);
				returnSalary.setLateday(lateday);
				returnSalary.setLatetime(latetime);
				returnSalary.setShinya(shinya);
				returnSalary.setPaidvacation(paidvacation);
				returnSalary.setAbsence(absence);
				returnSalary.setBase(base);
				returnSalary.setFamily(family);
				returnSalary.setPosition(position);
				returnSalary.setQualify(qualify);
				returnSalary.setTransport(transport);
				returnSalary.setHome(home);
				returnSalary.setHyouzyun(hyouzyun);
				returnSalary.setResident(resident);
			}
			if (tb.getParam() == 3) {

				sql = "SELECT * FROM " + tb.getLoginId() + "account WHERE month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tb.getDisplaymonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					year = rs.getInt("year");
					month = rs.getInt("month");
					workday = rs.getInt("workday");
					worktime = rs.getInt("worktime");
					overtime = rs.getInt("overtime");
					houteitime = rs.getInt("houteitime");
					hougaitime = rs.getInt("hougaitime");
					dayoffworkday = rs.getInt("dayoffworkday");
					lateday = rs.getInt("lateday");
					latetime = rs.getInt("latetime");
					shinya = rs.getInt("shinya");
					paidvacation = rs.getInt("paidvacation");
					absence = rs.getInt("absence");
					base = rs.getInt("base");
					position = rs.getInt("position");
					qualify = rs.getInt("qualify");
					family = rs.getInt("family");
					transport = rs.getInt("transport");
					home = rs.getInt("home");
					hyouzyun = rs.getInt("hyozyun");
					resident = rs.getInt("resident");
				}

				returnSalary.setYear(year);
				returnSalary.setMonth(month);
				returnSalary.setWorkday(workday);
				returnSalary.setWorktime(worktime);
				returnSalary.setOvertime(overtime);
				returnSalary.setHouteitime(houteitime);
				returnSalary.setHougaitime(hougaitime);
				returnSalary.setDayoffworkday(dayoffworkday);
				returnSalary.setLateday(lateday);
				returnSalary.setLatetime(latetime);
				returnSalary.setShinya(shinya);
				returnSalary.setPaidvacation(paidvacation);
				returnSalary.setAbsence(absence);
				returnSalary.setBase(base);
				returnSalary.setFamily(family);
				returnSalary.setPosition(position);
				returnSalary.setQualify(qualify);
				returnSalary.setTransport(transport);
				returnSalary.setHome(home);
				returnSalary.setHyouzyun(hyouzyun);
				returnSalary.setResident(resident);
			}
			if (tb.getParam() == 4) {

				sql = "SELECT * FROM " + tb.getLoginId() + "account";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					dyear.add(rs.getInt("year"));
					dmonth.add(rs.getInt("month"));
				}
				Collections.reverse(dmonth);
				tb.setDyear(dyear);
				tb.setDmonth(dmonth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnSalary;
	}
}