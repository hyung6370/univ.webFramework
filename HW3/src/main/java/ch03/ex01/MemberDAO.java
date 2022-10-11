package ch03.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/spring4fs";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "spring4", "spring4");
//			conn = DriverManager.getConnection(jdbc_url, "root", "hjk895623!!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MemberVO> listMembers() {
		connect();
		
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from member order by id";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
//				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return list;
	}

	public void addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		try {
			connect();
			
			String id = memberVO.getId();
			String email = memberVO.getEmail();
			String password = memberVO.getPassword();
			String name = memberVO.getName();
			String regdate = memberVO.getRegdate();
			
			String query = "INSERT INTO member(id, email, password, name, regdate)" + "VALUES(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.setString(5, regdate);
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}



