// UtillDB.java

package model.com.tistory.gangzzang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UtillDB {
	
	public static Connection getCon(Connection con) {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			con = dataSource.getConnection();
		} catch (NamingException e) {
			System.out.println("NamingException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} // try - catch
		return con;
	} // getCon() : Connection 媛앹껜瑜� DBCP �뿰寃� �썑�뿉 由ы꽩
	
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) { try { rs.close(); } catch (Exception e) { } }
		if (ps != null) { try { ps.close(); } catch (Exception e) { } }
		if (con != null) { try { con.close(); } catch (Exception e) { } }
	} // closeDB() : SELECT DB �뿰寃� 醫낅즺
	
	public static void closeDB(Connection con, PreparedStatement ps) {
		if (ps != null) { try { ps.close(); } catch (Exception e) { } }
		if (con != null) { try { con.close(); } catch (Exception e) { } }
	} // closeDB() : SELECT �쇅 DB �뿰寃� 醫낅즺
	
} // UtillDB