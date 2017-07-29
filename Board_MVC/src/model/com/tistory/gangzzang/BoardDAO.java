// BoardDAO.java

package model.com.tistory.gangzzang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {}
	
	public int insertBoard(BoardDTO dto) {
		int re = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO board(no,id,pwd,title,content,regdate,hit,parent,sort,tab) "
				+ "VALUES((SELECT NVL(MAX(no),0)+1 FROM board),?,?,?,?,SYSDATE,0,(SELECT NVL(MAX(no),0)+1 FROM board),0,0)";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		} // try - catch - finally
		return re;
	} // insertBoard() : 게시글쓰기
	
	public ArrayList<BoardDTO> listBoard(int begin, int end) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT rn,no,id,pwd,title,content,regdate,hit,parent,sort,tab FROM "
					+ "(SELECT Rownum as rn,no,id,pwd,title,content,regdate,hit,parent,sort,tab FROM "
					+ "(SELECT no,id,pwd,title,content,regdate,hit,parent,sort,tab FROM board ORDER BY parent DESC, sort ASC)) WHERE rn >=? AND rn <=?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setHit(rs.getInt("hit"));
				dto.setParent(rs.getInt("parent"));
				dto.setSort(rs.getInt("sort"));
				dto.setTab(rs.getInt("tab"));
				list.add(dto);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps, rs);
		} // try - catch - finally
		return list;
	} // listBoard() : 게시글 목록
	
	public int getTotal() {
		int cnt = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM board";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			UtillDB.closeDB(con, ps, rs);
		} // try - catch - finally
		return cnt;
	} // getTotal() : 총 게시글의 수
	
	public BoardDTO getBoard(String no) {
		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT no,id,pwd,title,content,regdate,hit,parent,sort,tab FROM board WHERE no=?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setHit(rs.getInt("hit"));
				dto.setParent(rs.getInt("parent"));
				dto.setSort(rs.getInt("sort"));
				dto.setTab(rs.getInt("tab"));
			} // if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps, rs);
		} // try - catch - finally
		return dto;
	} // getBoard() : 하나의 게시글 가져오기
	
	public void updateHit(String no) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE board SET hit=hit+1 WHERE no=?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		} // try - catch - finally
	} // updateHit() : 조회수 증가

	public int updateBoard(BoardDTO dto) {
		int re = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE board SET title=?, content=?, regdate=SYSDATE WHERE no=? AND pwd=?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setInt(3, dto.getNo());
			ps.setString(4, dto.getPwd());
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		} // try - catch - finally
		return re;
	} // updateBoard() : 게시글 수정
	
	public int deleteBoard(String no, String pwd) {
		int re = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM board WHERE no=? AND pwd=?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.setString(2, pwd);
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		}
		return re;
	} // deleteBoard() : 게시글 삭제
	
	public void updateReplySort(BoardDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="UPDATE board SET sort=sort+1 WHERE parent=? AND sort>?";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getParent());
			ps.setInt(2, dto.getSort());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		} // try - catch - finally
	} // updateReplySort() : 답글 정렬
	
	public int insertReply(BoardDTO dto) {
		int re = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO board(no,id,pwd,title,content,regdate,hit,parent,sort,tab) "
						+ "VALUES((SELECT NVL(MAX(no),0)+1 FROM board),?,?,?,?,SYSDATE,0,?,?,?)";
		try {
			con = UtillDB.getCon(con);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			ps.setInt(5, dto.getParent());
			ps.setInt(6, dto.getSort());
			ps.setInt(7, dto.getTab());
			System.out.println("re " + re);
			re = ps.executeUpdate();
			System.out.println("re " + re);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtillDB.closeDB(con, ps);
		} // try - catch - finally
		return re;
	} // insertReply() : 답글 쓰기
	
} // BoardDAO