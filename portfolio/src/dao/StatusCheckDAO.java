package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.TimeListBean;

public class StatusCheckDAO {

	public StatusCheckDAO(TimeListBean tlb) {
		final String jdbcId = "root";
		final String jdbcPass = "root";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";
		String status = null;

		int today = tlb.getSday();
		int day = 0;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int param = tlb.getParam();
		try {
			//DBへ接続
			conn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
			st = conn.createStatement();
			if (param == 6) {
				String sql = "SELECT * FROM " + tlb.getLoginId()
						+ "starttime WHERE year = ? AND month = ? AND day = ? AND hour IS NOT NULL";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getSmonth());
				ps.setInt(3, tlb.getSday());
				rs = ps.executeQuery();
				while (rs.next()) {
					day = rs.getInt("day");
				}
				if (day == 0) {
					status = "nowork";
				} else if (day == today) {
					status = "worked";
				} else {
					status = "error";
				}
		        System.out.println(day + "s");


				tlb.setStartstatus(status);
			} else if (param == 7) {
				String sql = "SELECT * FROM " + tlb.getLoginId()
						+ "finishtime WHERE year = ? AND month = ? AND day = ? AND hour IS NOT NULL";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, tlb.getSyear());
				ps.setInt(2, tlb.getSmonth());
				ps.setInt(3, tlb.getSday());
				rs = ps.executeQuery();
				while (rs.next()) {
					day = rs.getInt("day");
				}
				if (day == 0) {
					status = "nowork";
				} else if (day == today) {
					status = "worked";
				} else {
					status = "error";
				}
				tlb.setFinishstatus(status);
		        System.out.println(day + "f");

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