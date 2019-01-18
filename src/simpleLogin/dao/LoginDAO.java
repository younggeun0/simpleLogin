package simpleLogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import simpleLogin.vo.LoginVO;

public class LoginDAO {
	
	private static LoginDAO l_dao;
	
	private LoginDAO() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static LoginDAO getInstance() {
		if(l_dao == null) {
			l_dao = new LoginDAO();
		}
		return l_dao;
	}
	
	public Connection getConn() throws SQLException {
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public boolean login(LoginVO lv) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			
			String selectUser = 
			 "SELECT id FROM simple_login WHERE id=? AND password=?";
			
			pstmt = con.prepareStatement(selectUser);
			pstmt.setString(1, lv.getId());
			pstmt.setString(2, lv.getPass());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				flag = true;
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
}
