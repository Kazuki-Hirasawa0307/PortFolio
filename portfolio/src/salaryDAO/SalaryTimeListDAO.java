package salaryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TimeListBean;

public class SalaryTimeListDAO {

	public SalaryTimeListDAO(TimeListBean tlb) {
		final String jdbcId = "root";
		final String jdbcPass = "root";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

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
				ps.setInt(1, tlb.getSalaryyear());
				ps.setInt(2, tlb.getSalarymonth());
				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					hour.add(rs.getInt("hour"));
					minute.add(rs.getInt("minute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));

				}
				tlb.setSalarystartmonth(smo);
				tlb.setSalarystartyear(sy);
				tlb.setSalarystartday(day);
				tlb.setSalarystarthour(hour);
				tlb.setSalarystartminute(minute);
				tlb.setSalaryweeks(weeks);

			} else if (param == 1) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "finishtime WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSalaryyear());
				ps.setInt(2, tlb.getSalarymonth());

				rs = ps.executeQuery();
				while (rs.next()) {
					day.add(rs.getInt("day"));
					hour.add(rs.getInt("hour"));
					minute.add(rs.getInt("minute"));
					smo = rs.getInt("month");
					sy = rs.getInt("year");
					weeks.add(rs.getString("week"));
				}
				tlb.setSalaryfinishmonth(smo);
				tlb.setSalaryfinishyear(sy);
				tlb.setSalaryfinishday(day);
				tlb.setSalaryfinishhour(hour);
				tlb.setSalaryfinishminute(minute);
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
