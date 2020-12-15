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
			ArrayList<Integer> shour = new ArrayList<>();
			ArrayList<Integer> sminute = new ArrayList<>();
			ArrayList<Integer> fhour = new ArrayList<>();
			ArrayList<Integer> fminute = new ArrayList<>();
			ArrayList<String> weeks = new ArrayList<>();
			if (param == 0) {
				sql = "SELECT * FROM " + tlb.getLoginId() + "timelist WHERE year = ? AND month = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSalaryyear());
				ps.setInt(2, tlb.getSalarymonth());
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
				tlb.setSalarystartmonth(smo);
				tlb.setSalarystartyear(sy);
				tlb.setSalarystartday(day);
				tlb.setSalarystarthour(shour);
				tlb.setSalarystartminute(sminute);
				tlb.setSalaryweeks(weeks);
				tlb.setSalaryfinishhour(fhour);
				tlb.setSalaryfinishminute(fminute);
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
