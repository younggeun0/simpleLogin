package simpleLogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simpleLogin.vo.AddressVO;
import simpleLogin.vo.LoginVO;
import simpleLogin.vo.UserInfoVO;

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
	
	public boolean selectValidIdAndAnswer(String id, String questionType, String answer) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			String selectValidIdAndAnswer = 
					"select id from simple_login where id=? and question=? and answer=?";
			pstmt = con.prepareStatement(selectValidIdAndAnswer);
			pstmt.setString(1, id);
			pstmt.setString(2, questionType);
			pstmt.setString(3, answer);
			
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
	
	public boolean updatePass(String id, String newPass) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = getConn();
			
			StringBuilder updatePass = new StringBuilder();
			updatePass
			.append(" update simple_login ")
			.append(" set password = ? ")
			.append(" where id = ?");
			
			pstmt = con.prepareStatement(updatePass.toString());
			pstmt.setString(1, newPass);
			pstmt.setString(2, id);

			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				flag = true;
			}
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public boolean selectId(String id) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			String selectId = "select id from simple_login where id=?";
			pstmt = con.prepareStatement(selectId);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public boolean insertUser(UserInfoVO uivo) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = getConn();
			
			StringBuilder insertUser = new StringBuilder();
			insertUser
			.append(" INSERT INTO simple_login(id, password, tel, ")
			.append(" email, ssn, question, answer, address) ")
			.append(" VALUES(?,?,?,?,?,?,?,?)");
			
			pstmt = con.prepareStatement(insertUser.toString());
			pstmt.setString(1, uivo.getId());
			pstmt.setString(2, uivo.getPassword());
			pstmt.setString(3, uivo.getTel());
			pstmt.setString(4, uivo.getEmail());
			pstmt.setString(5, uivo.getSsn());
			pstmt.setString(6, uivo.getQuestion());
			pstmt.setString(7, uivo.getAnswer());
			pstmt.setString(8, uivo.getAddress());
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				flag = true;
			}
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
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
	
	public List<AddressVO> selectAddress(String dong) throws SQLException {
		List<AddressVO> list = new ArrayList<AddressVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			StringBuilder selectAddress = new StringBuilder();
			selectAddress
			.append("	select zipcode, sido, gugun, dong, NVL(bunji, ' ') bunji	")
			.append("	FROM zipcode	")
			.append("	WHERE dong LIKE ?||'%'	");
	
			pstmt = con.prepareStatement(selectAddress.toString());
			pstmt.setString(1, dong);
			
			rs = pstmt.executeQuery();
			
			AddressVO avo = null;
			while(rs.next()) {
				avo = new AddressVO(rs.getString("zipcode"),
						rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				list.add(avo);
			}
			System.out.println(avo);
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	
	/*public static void main(String[] args) throws SQLException {
		System.out.println(LoginDAO.getInstance().selectId("test"));
	}*/
	
	public List<UserInfoVO> selectAllUser() throws SQLException {
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			
			StringBuilder selectAllUser = new StringBuilder(); 
			selectAllUser
			.append("SELECT id, password, tel, email, ssn, address, question, answer ")
			.append("FROM simple_login");
			
			pstmt = con.prepareStatement(selectAllUser.toString());
			rs = pstmt.executeQuery();
			
			UserInfoVO uivo = null;
			while(rs.next()) {
				uivo = new UserInfoVO(rs.getString("id"), 
						rs.getString("password"), rs.getString("tel"),
						rs.getString("email"), rs.getString("ssn"),
						rs.getString("address"), rs.getString("question"),
						rs.getString("answer"));
				list.add(uivo);
			}
			
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
}
