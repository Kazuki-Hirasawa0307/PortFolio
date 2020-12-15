package accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TimeListBean;

public class AccountRegisterDAO {
	// データベース接続に使用する情報
	String jdbcId = "root";
	String jdbcPass = "root";
	String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";

	public AccountRegisterDAO(TimeListBean ab) {

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
			int param = ab.getParam();
			if (param == 4) {
				String sql = "INSERT INTO account (loginID, pass, name, role, base, position, qualify, family, "
						+ "transport,mail,home,hyouzyun,birthday,Resident) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, ab.getLoginId());
				ps.setString(2, ab.getPass());
				ps.setString(3, ab.getName());
				ps.setInt(4, ab.getRole());
				ps.setInt(5, ab.getBase());
				ps.setInt(6, ab.getPosition());
				ps.setInt(7, ab.getQualify());
				ps.setInt(8, ab.getFamily());
				ps.setInt(9, ab.getTransport());
				ps.setString(10, ab.getMail());
				ps.setInt(11, ab.getHome());
				ps.setInt(12, ab.getHyouzyun());
				ps.setInt(13, ab.getBirthday());
				ps.setInt(14, ab.getResident());




				int r = ps.executeUpdate();

				if (r != 0) {
					System.out.println("新規社員情報登録成功！");
				} else {
					System.out.println("新規社員情報登録失敗");
				}
			}else if(param == 5) {
				String sql = "CREATE TABLE "+ ab.getLoginId() +"timelist(year INT, month INT, day INT,  starthour INT, startminute INT, finishhour INT, finishminute INT, week VARCHAR(10))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
					System.out.println("新規社員時間テーブル作成完了");
			}else if(param == 7) {
				String sql = "CREATE TABLE "+ ab.getLoginId() +"account(year INT, month INT,  salary INT, workday INT,  worktime INT, overtime INT,dayoffworktime INT, dayoffworkday INT,"
						+ "nigthworktime INT, lateday INT, latetime INT, paidvacation INT, absence INT)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
					System.out.println("新規社員情報テーブル作成完了");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}