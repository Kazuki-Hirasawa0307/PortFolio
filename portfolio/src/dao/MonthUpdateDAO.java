package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TimeListBean;

public class MonthUpdateDAO {

	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "root";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

	public MonthUpdateDAO(TimeListBean tb) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = null;
		int DBmonth = 0;
		String week = tb.getWeek();
		int nowmonth = tb.getSmonth();
		int param = tb.getParam();
		int days = tb.getDays();

		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
			if (param == 2) {
				sql = "SELECT * FROM " + tb.getLoginId() + "starttime WHERE month IS NOT NULL";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					DBmonth = rs.getInt("month");
				}
				if (DBmonth != nowmonth) {
					sql = "INSERT INTO " + tb.getLoginId() + "starttime (year, month, day, week) VALUES (?, ?, ?, ?)";
					ps = conn.prepareStatement(sql);
					for (int i = 0; i < days; i++) {
						ps.setInt(1, tb.getSyear());
						ps.setInt(2, tb.getSmonth());
						ps.setInt(3, (i + 1));
						if (week == "MONDAY") {
							week = "月";
							ps.setString(4, week);
							week = "TUESDAY";
						} else if (week == "TUESDAY") {
							week = "火";
							ps.setString(4, week);
							week = "WEDNESDAY";
						} else if (week == "WEDNESDAY") {
							week = "水";
							ps.setString(4, week);
							week = "THURSDAY";
						} else if (week == "THURSDAY") {
							week = "木";
							ps.setString(4, week);
							week = "FRIDAY";
						} else if (week == "FRIDAY") {
							week = "金";
							ps.setString(4, week);
							week = "SATURDAY";
						} else if (week == "SATURDAY") {
							week = "土";
							ps.setString(4, week);
							week = "SUNDAY";
						} else if (week == "SUNDAY") {
							week = "日";
							ps.setString(4, week);
							week = "MONDAY";
						}
						ps.executeUpdate();
					}
				}
			} else if (param == 3) {
				sql = "SELECT * FROM " + tb.getLoginId() + "finishtime WHERE month IS NOT NULL";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					DBmonth = rs.getInt("month");
				}
				if (DBmonth != nowmonth) {
					sql = "INSERT INTO " + tb.getLoginId() + "finishtime (year, month, day, week) VALUES (?, ?, ?, ?)";
					ps = conn.prepareStatement(sql);
					for (int i = 0; i < days; i++) {
						ps.setInt(1, tb.getSyear());
						ps.setInt(2, tb.getSmonth());
						ps.setInt(3, (i + 1));
						if (week == "MONDAY") {
							week = "月";
							ps.setString(4, week);
							week = "TUESDAY";
						} else if (week == "TUESDAY") {
							week = "火";
							ps.setString(4, week);
							week = "WEDNESDAY";
						} else if (week == "WEDNESDAY") {
							week = "水";
							ps.setString(4, week);
							week = "THURSDAY";
						} else if (week == "THURSDAY") {
							week = "木";
							ps.setString(4, week);
							week = "FRIDAY";
						} else if (week == "FRIDAY") {
							week = "金";
							ps.setString(4, week);
							week = "SATURDAY";
						} else if (week == "SATURDAY") {
							week = "土";
							ps.setString(4, week);
							week = "SUNDAY";
						} else if (week == "SUNDAY") {
							week = "日";
							ps.setString(4, week);
							week = "MONDAY";
						}
						ps.executeUpdate();
					}
				}
			} else if (param == 4) {
				System.out.println("ng");
				sql = "INSERT INTO " + tb.getLoginId() + "account(year, month, workday, worktime, overtime, "
						+ "houteitime, hougaitime, dayoffworkday, lateday, latetime, shinya) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tb.getSalaryyear());
				ps.setInt(2, tb.getSalarymonth());
				ps.setInt(3, tb.getWorkday());
				ps.setInt(4, tb.getWorktime());
				ps.setInt(5, tb.getOvertime());
				ps.setInt(6, tb.getHouteitime());
				ps.setInt(7, tb.getHougaitime());
				ps.setInt(8, tb.getDayoffworkday());
				ps.setInt(9, tb.getLateday());
				ps.setInt(10, tb.getLatetime());
				ps.setInt(11, tb.getNightworktime());
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
