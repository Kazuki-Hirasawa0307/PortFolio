package accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TimeListBean;

public class AccountFixDAO {
    // データベース接続に使用する情報
    final String jdbcId = "root";
    final String jdbcPass = "root";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/portfolio?serverTimezone=JST";
//    TimeListBean tb = new TimeListBean();
//    int mon = tb.getMonth();
//    String month = String.valueOf(mon);

public  AccountFixDAO(TimeListBean ab) {

    try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {


    	String name = ab.getNname();
    	String role = ab.getNrole();
    	String base = ab.getNbase();
    	String position = ab.getNposition();
    	String qualify = ab.getNqualify();
    	String family = ab.getNfamily();
    	String transport = ab.getNtransport();
    	String mail = ab.getNmail();
    	String birthday = ab.getNbirthday();
    	String home = ab.getNhome();
    	String hyouzyun = ab.getNhyouzyun();
    	String resident = ab.getNresident();


    	if(name != null) {
            String sql = "UPDATE account SET name = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, ab.getNname());
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
    	}
    	if(mail != null) {
            String sql = "UPDATE account SET mail = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, ab.getNmail());
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
    	}
    	if(role != null) {
    		int ro = Integer.parseInt(ab.getNrole());
    		String sql = "UPDATE account SET role = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, ro);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
    	}
    	if(base != null) {
    		int ba = Integer.parseInt(ab.getNbase());
    		String sql = "UPDATE account SET base = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, ba);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
    	}
    	if(position != null) {
    		int po = Integer.parseInt(ab.getNposition());
    		String sql = "UPDATE account SET position = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, po);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
    	}
    	if(qualify != null) {
    		int qu = Integer.parseInt(ab.getNqualify());
    		String sql = "UPDATE account SET qualify = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, qu);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
    	if(family != null) {
    		int fa = Integer.parseInt(ab.getNfamily());
    		String sql = "UPDATE account SET family = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, fa);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
    	if(transport != null) {
    		int tr = Integer.parseInt(ab.getNtransport());
    		String sql = "UPDATE account SET transport = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, tr);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
     	if(birthday != null) {
    		int tr = Integer.parseInt(ab.getNbirthday());
    		String sql = "UPDATE account SET birthday = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, tr);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
     	if(home != null) {
    		int tr = Integer.parseInt(ab.getNhome());
    		String sql = "UPDATE account SET home = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, tr);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
     	if(hyouzyun != null) {
    		int tr = Integer.parseInt(ab.getNhyouzyun());
    		String sql = "UPDATE account SET hyouyun = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, tr);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }
     	if(resident != null) {
    		int tr = Integer.parseInt(ab.getNresident());
    		String sql = "UPDATE account SET Resident = ? WHERE loginID = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, tr);
            ps.setString(2, ab.getLoginId());
            ps.setString(3, ab.getPass());
            ps.executeUpdate();
            }


    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}