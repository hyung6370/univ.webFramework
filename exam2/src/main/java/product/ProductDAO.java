package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/spring4fs";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
//			conn = DriverManager.getConnection(jdbc_url, "spring4", "spring4");
			conn = DriverManager.getConnection(jdbc_url, "DB_ID", "DB_PW");
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
	
	public ArrayList<ProductVO> listProducts() {
		connect();
		
		ArrayList<ProductVO> list = new ArrayList<>();
		String sql = "select id, title, writer, regdate, readcnt from news";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setId(rs.getInt("id"));
				product.setWriter(rs.getString("writer"));
				product.setTitle(rs.getString("title"));
				product.setRegdate(rs.getString("regdate"));
				product.setReadcnt(rs.getInt("readcnt"));
				list.add(product);
			} 
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return list;
	}
	
	public ProductVO getProductById(int id) {
		connect();
		
		ProductVO product = null;
		String sql = "select id, title, writer, body from news where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setId(rs.getInt("id"));
				product.setTitle(rs.getString("title"));
				product.setWriter(rs.getString("writer"));
				product.setBody(rs.getString("body"));
		}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnect();
		}
		return product;
	}
	
	public int updateReadCnt(int id) {
		String sql = "update news set readcnt = readcnt + 1 where id = ?";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnect();
		}
		return -1;
	}
	
	public int insert(ProductVO product) {
		String sql = "insert into news(writer, title, body, regdate) values(?, ?, ?, now())";
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getWriter());
			pstmt.setString(2, product.getTitle());
			pstmt.setString(3, product.getBody());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		return result;
	}
	
	
	public int update(ProductVO product) {
		String sql = "update news set writer=?, title=?, body=?, regdate=now() where id=?";
		int result = -1;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getWriter());
			pstmt.setString(2, product.getTitle());
			pstmt.setString(3, product.getBody());
			pstmt.setInt(4, product.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		return result;
	}
}


