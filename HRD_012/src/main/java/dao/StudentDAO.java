package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBManager;
import dto.MemberDTO;


public class StudentDAO {
	// 싱글턴 패턴
	private StudentDAO() {}
	private static StudentDAO dao = new StudentDAO();
	public static StudentDAO getInstance() {
		return dao;
	}
	
	// 현재 마지막 회원번호 알아오는 쿼리 - select
	public int currentNumber() {
		int number = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select student_seq.nextval from dual";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				number = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,stmt,rs);
		}
		return number;	
	}

	// 입력받은 회원 정보 저장 -insert
	public void insertMember(MemberDTO mDto) {
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "INSERT INTO student_tbl_02 VALUES(?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, mDto.getStudno());
			psmt.setString(2, mDto.getStudname());
			psmt.setInt(3, mDto.getKorean());
			psmt.setInt(4, mDto.getEnglish());
			psmt.setInt(5, mDto.getMath());
			psmt.setInt(6, mDto.getHistory());
			
			
			
			psmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	// 모든 회원 정보 읽어오기 => SELECT
	public List<MemberDTO> selectAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM student_tbl_02 ORDER BY studno ASC";
		
		List<MemberDTO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO mDto = new MemberDTO();
				mDto.setStudno(rs.getInt("studno"));
				mDto.setStudname(rs.getString("studname"));
				mDto.setKorean(rs.getInt("korean"));
				mDto.setEnglish(rs.getInt("english"));
				mDto.setMath(rs.getInt("math"));
				mDto.setHistory(rs.getInt("history"));
				
				
				list.add(mDto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	// studno를 통해 한명의 회원 정보를 조회하는 메서드 : SELECT
	public MemberDTO selectTargetMember(int studno) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM student_tbl_02 WHERE studno=?";
		
		MemberDTO mDto = new MemberDTO();
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, studno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mDto.setStudno(rs.getInt("studno"));
				mDto.setStudname(rs.getString("studname"));
				mDto.setKorean(rs.getInt("korean"));
				mDto.setEnglish(rs.getInt("english"));
				mDto.setMath(rs.getInt("math"));
				mDto.setHistory(rs.getInt("history"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return mDto;
	}
	
	
//	회원 정보 수정 => update
	public void updateMember(MemberDTO mDto) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE student_tbl_02 "
				+ " SET studname=?, korean=?, english=?, math=?, history=? "
				+ " WHERE studno=? ";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mDto.getStudname());
			psmt.setInt(2, mDto.getKorean());
			psmt.setInt(3, mDto.getEnglish());
			psmt.setInt(4, mDto.getMath());
			psmt.setInt(5, mDto.getHistory());
			psmt.setInt(6, mDto.getStudno());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	
	
	
}











