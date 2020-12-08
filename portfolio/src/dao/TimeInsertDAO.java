package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TimeListBean;

public class TimeInsertDAO {
	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "root";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

	public TimeInsertDAO(TimeListBean tb) {

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
			String sql = null;
			PreparedStatement ps = null;
			int param = tb.getParam();

			if (param == 4) {
				int year = tb.getSyear();
				int month = tb.getSmonth();
				int day = tb.getSday();
				sql = "UPDATE " + tb.getLoginId()+ "starttime SET hour = ?, minute = ? ,second = ? WHERE year = ? AND month = ? AND day = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, tb.getShour());
				ps.setInt(2, tb.getSminute());
				ps.setInt(3, tb.getSsecond());
				ps.setInt(4, year);
				ps.setInt(5, month);
				ps.setInt(6, day);
			} else if (param == 5) {
				int year = tb.getFyear();
				int month = tb.getFmonth();
				int day = tb.getFday();
				sql = "UPDATE " + tb.getLoginId()+ "finishtime SET hour = ?, minute = ? ,second = ? WHERE year = ? AND month = ? AND day = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, tb.getFhour());
				ps.setInt(2, tb.getFminute());
				ps.setInt(3, tb.getFsecond());
				ps.setInt(4, year);
				ps.setInt(5, month);
				ps.setInt(6, day);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
