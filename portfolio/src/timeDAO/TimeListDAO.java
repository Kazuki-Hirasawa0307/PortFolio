package timeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import model.TimeListBean;

public class TimeListDAO {

	public TimeListDAO(TimeListBean tlb) {
		final String jdbcId = "root";
		final String jdbcPass = "root";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";
		//	    TimeListBean tb = new TimeListBean();
		//	    int mon = tb.getMonth();
		//	    String month = String.valueOf(mon);

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int param = 0;
		int smo = 0;
		int sy = 0;
		String sql = null;

		try {
			//DBへ接続
			param = tlb.getParam();
			conn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
			ArrayList<Integer> day = new ArrayList<>();
			ArrayList<Integer> shour = new ArrayList<>();
			ArrayList<Integer> sminute = new ArrayList<>();
			ArrayList<Integer> fhour = new ArrayList<>();
			ArrayList<Integer> fminute = new ArrayList<>();
			ArrayList<String> weeks = new ArrayList<>();
			ArrayList<Integer> dmonth = new ArrayList<Integer>();
			ArrayList<Integer> dyear = new ArrayList<Integer>();


			if (param == 0) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "timelist WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getSmonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					shour.add(rs.getInt("starthour"));
					sminute.add(rs.getInt("startminute"));
					fhour.add(rs.getInt("finishhour"));
					fminute.add(rs.getInt("finishminute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));
				}
				tlb.setSmonth(smo);
				tlb.setSyear(sy);
				tlb.setStartday(day);
				tlb.setStarthour(shour);
				tlb.setStartminute(sminute);
				tlb.setFinishhour(fhour);
				tlb.setFinishminute(fminute);
				tlb.setWeeks(weeks);

			}
			if (param == 2) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "timelist WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getDisplaymonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					shour.add(rs.getInt("starthour"));
					sminute.add(rs.getInt("startminute"));
					fhour.add(rs.getInt("finishhour"));
					fminute.add(rs.getInt("finishminute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));
				}
				tlb.setSmonth(smo);
				tlb.setSyear(sy);
				tlb.setStartday(day);
				tlb.setStarthour(shour);
				tlb.setStartminute(sminute);
				tlb.setFinishhour(fhour);
				tlb.setFinishminute(fminute);
				tlb.setWeeks(weeks);
			}
			if (param == 4) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "timelist WHERE day = 1";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					dyear.add(rs.getInt("year"));
					dmonth.add(rs.getInt("month"));
				}
				Collections.reverse(dmonth);
				tlb.setDmonth(dmonth);
				tlb.setDyear(dyear);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
