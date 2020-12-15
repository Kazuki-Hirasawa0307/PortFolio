package timeDAO;

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
						+ "timelist WHERE year = ? AND month = ? AND day = ? AND starthour IS NOT NULL";
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

				tlb.setStartstatus(status);

			} else if (param == 7) {
				String sql = "SELECT * FROM " + tlb.getLoginId()
						+ "timelist WHERE year = ? AND month = ? AND day = ? AND finishhour IS NOT NULL";
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

			}

			if (param == 8) {
				String sql = "SELECT * FROM " + tlb.getLoginId()
						+ "timelist WHERE year = ? AND month = ? AND day = ? AND starthour IS NOT NULL";
				ps = conn.prepareStatement(sql);
				int beforey = tlb.getSyear();
				int beforem = tlb.getSmonth();
				int befored = tlb.getSday() - 1;
				if(befored == 0) {
					befored = tlb.getDays();
					beforem -= 1;
					if(beforem == 0) {
						beforey -= 1;
					}
				}
				ps.setInt(1, beforey);
				ps.setInt(2, beforem);
				ps.setInt(3, befored);
				rs = ps.executeQuery();
				while (rs.next()) {
					day = rs.getInt("day");
				}
				if (day == 0) {
					status = "nowork";
				} else if (day == befored) {
					status = "worked";
				} else {
					status = "error";
				}

				tlb.setBeforesstatus(status);

			}
			if (param == 9) {
				String sql = "SELECT * FROM " + tlb.getLoginId()
						+ "timelist WHERE year = ? AND month = ? AND day = ? AND finishhour IS NOT NULL";
				ps = conn.prepareStatement(sql);
				int beforey = tlb.getSyear();
				int beforem = tlb.getSmonth();
				int befored = tlb.getSday() - 1;
				if(befored == 0) {
					befored = tlb.getDays();
					beforem -= 1;
					if(beforem == 0) {
						beforey -= 1;
					}
				}
				ps.setInt(1, beforey);
				ps.setInt(2, beforem);
				ps.setInt(3, befored);
				rs = ps.executeQuery();
				while (rs.next()) {
					day = rs.getInt("day");
				}
				if (day == 0) {
					status = "nowork";
				} else if (day == befored) {
					status = "worked";
				} else {
					status = "error";
				}

				tlb.setBeforefstatus(status);
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