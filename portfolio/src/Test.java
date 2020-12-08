import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		        String userName = "root";
		        String password = "hirasawa";

		        Connection con = null;
		        PreparedStatement stmt = null;
		        ResultSet rs = null;

		    String sql = "SELECT * FROM Products";

		        try {
		con = DriverManager.getConnection(url,userName, password);
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();

		while (rs.next()) {
		    String id = rs.getString("id");
		    String name =
		rs.getString("name");
		    int price = rs.getInt("price");

		System.out.println(id + "\t" + name + "\t" + price);
		            }
		        } catch (SQLException e) {
		System.out.println("データベースアクセスエラーです");
		    } finally {
		    try {
		    if (con != null) {
		 con.close();
		                }
		} catch (SQLException e) {
		    System.out.println("データベースアクセスエラーです");
            }
        }
    }

}