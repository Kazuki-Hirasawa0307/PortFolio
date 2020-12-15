package accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TimeListBean;

public class AccountDAO {
	// データベース接続に使用する情報
	String url = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";
	String id = "root";
	String pass = "root";
	private Connection con;

	public TimeListBean findAccount(TimeListBean tb) {
		con = null;

		TimeListBean returnAb = new TimeListBean();

		try {
			con = DriverManager.getConnection(url, id, pass);
			ResultSet rs = null;
			int param = tb.getParam();
			if (param == 1) {
				String sql = "SELECT * FROM account WHERE name = ? AND loginID = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tb.getName());
				ps.setString(2, tb.getLoginId());
				rs = ps.executeQuery();

				if (rs.next()) {
					// 見つかったアカウント情報を戻り値にセット
					returnAb.setLoginId(rs.getString("loginId"));
					returnAb.setPass(rs.getString("pass"));
					returnAb.setName(rs.getString("name"));
					returnAb.setRole(rs.getInt("role"));
					returnAb.setBase(rs.getInt("base"));
					returnAb.setFamily(rs.getInt("family"));
					returnAb.setPosition(rs.getInt("position"));
					returnAb.setQualify(rs.getInt("qualify"));
					returnAb.setTransport(rs.getInt("transport"));
					returnAb.setHome(rs.getInt("home"));
					returnAb.setHyouzyun(rs.getInt("hyouzyun"));
					returnAb.setMail(rs.getString("mail"));
					returnAb.setBirthday(rs.getInt("birthday"));
					returnAb.setResident(rs.getInt("resident"));

				} else {
					// アカウントがなければnullを返す
					return null;
				}

			} else if (param == 2) {
				String sql = "SELECT * FROM account WHERE loginID = ? AND pass = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tb.getLoginId());
				ps.setString(2, tb.getPass());
				rs = ps.executeQuery();

				if (rs.next()) {
					// 見つかったアカウント情報を戻り値にセット
					returnAb.setLoginId(rs.getString("loginId"));
					returnAb.setPass(rs.getString("pass"));
					returnAb.setName(rs.getString("name"));
					returnAb.setRole(rs.getInt("role"));
					returnAb.setBase(rs.getInt("base"));
					returnAb.setFamily(rs.getInt("family"));
					returnAb.setPosition(rs.getInt("position"));
					returnAb.setQualify(rs.getInt("qualify"));
					returnAb.setTransport(rs.getInt("transport"));
					returnAb.setHome(rs.getInt("home"));
					returnAb.setHyouzyun(rs.getInt("hyouzyun"));
					returnAb.setMail(rs.getString("mail"));
					returnAb.setBirthday(rs.getInt("birthday"));
					returnAb.setResident(rs.getInt("resident"));


				} else {
					// アカウントがなければnullを返す
					return null;
				}

			} else if (param == 3) {
				String sql = "SELECT * FROM account WHERE loginID = ? AND pass = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tb.getLoginId());
				ps.setString(2, tb.getPass());
				rs = ps.executeQuery();
				System.out.println("DAO");

				while (rs.next()) {
					// 見つかったアカウント情報を戻り値にセット
					tb.setLoginId(rs.getString("loginId"));
					tb.setPass(rs.getString("pass"));
					tb.setName(rs.getString("name"));
					tb.setRole(rs.getInt("role"));
					tb.setBase(rs.getInt("base"));
					tb.setFamily(rs.getInt("family"));
					tb.setPosition(rs.getInt("position"));
					tb.setQualify(rs.getInt("qualify"));
					tb.setTransport(rs.getInt("transport"));
					tb.setHome(rs.getInt("home"));
					tb.setHyouzyun(rs.getInt("hyouzyun"));
					tb.setMail(rs.getString("mail"));
					tb.setBirthday(rs.getInt("birthday"));
					tb.setResident(rs.getInt("resident"));

				}


			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return returnAb;
	}
}