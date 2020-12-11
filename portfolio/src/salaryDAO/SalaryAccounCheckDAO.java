package salaryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TimeListBean;

public class SalaryAccounCheckDAO {

	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "root";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

	public int SalaryCheck(TimeListBean tb) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = null;
		int checkmonth = 0;
		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
			sql = "SELECT * FROM " + tb.getLoginId() + "account WHERE month IS NOT NULL";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				checkmonth = rs.getInt("month");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return checkmonth;
	}
}