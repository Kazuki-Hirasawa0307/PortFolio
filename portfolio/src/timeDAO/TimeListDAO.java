package timeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			ArrayList<Integer> hour = new ArrayList<>();
			ArrayList<Integer> minute = new ArrayList<>();
			ArrayList<String> weeks = new ArrayList<>();
			if (param == 0) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "starttime WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getSmonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					hour.add(rs.getInt("hour"));
					minute.add(rs.getInt("minute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));
				}
				tlb.setSmonth(smo);
				tlb.setSyear(sy);
				tlb.setStartday(day);
				tlb.setStarthour(hour);
				tlb.setStartminute(minute);
				tlb.setWeeks(weeks);
			} else if (param == 1) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "finishtime WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getSmonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					hour.add(rs.getInt("hour"));
					minute.add(rs.getInt("minute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));
				}
				tlb.setFmonth(smo);
				tlb.setFyear(sy);
				tlb.setFinishday(day);
				tlb.setFinishhour(hour);
				tlb.setFinishminute(minute);
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
