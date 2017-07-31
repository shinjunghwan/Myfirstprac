package CRUDPro;

import java.util.*;
import java.sql.*;

public class MemberDAO {
	static final String sid = "TestDB";
	static final String id = "scott";
	static final String pass = "tiger";
	String url = "jdbc:oracle:thin:@localhost:1521:"+sid;
	
	public MemberDAO() {
		System.out.println("오라클 JDBC 드라이버 로딩중...");
		try {
			///////////////////////////////////////
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("오라클 JDBC 드라이버 로딩 성공...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "select * from member1";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert(String name, String age, String height, String weight, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "insert into member1(name,age,height,weight,sex) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(age));
			pstmt.setInt(3, Integer.parseInt(height));
			pstmt.setInt(4, Integer.parseInt(weight));
			pstmt.setString(5, sex);
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "delete from member1 where name =? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(String name, String age, String height, String weight, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "update member1 set age=?,height=?,weight=?,sex=? where name = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(5, name);
			pstmt.setInt(1, Integer.parseInt(age));
			pstmt.setInt(2, Integer.parseInt(height));
			pstmt.setInt(3, Integer.parseInt(weight));
			pstmt.setString(4, sex);
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public MemberDTO search(String name) throws RecordNotFoundException {
		if(!isExist(name)) throw new RecordNotFoundException("찾는 레코드가 없음");
		MemberDTO dto = new MemberDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "select * from member1 where name = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public boolean isExist(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "select * from member1 where name = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
