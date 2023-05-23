package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.QnaVO;
import com.ezen.world.util.Dbman;
import com.ezen.world.util.Paging;

public class QnaDao {
	private  QnaDao() {}
	private static  QnaDao itc = new QnaDao();
	public static  QnaDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
	public int getAllCount() {
		int count= 0;
		String sql = "select count(*) as cnt from lqna";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }
		return count;
	}



	public ArrayList<QnaVO> selectQna(Paging paging) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, q.* from ((select * from lqna order by lqseq desc) q) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum() );
			pstmt.setInt(2,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
		    	QnaVO qvo = new QnaVO();
		    	qvo.setLqseq(rs.getInt("lqseq"));
		    	qvo.setTitle(rs.getString("title"));
		    	qvo.setContent(rs.getString("content"));
		    	qvo.setIndate(rs.getTimestamp("indate"));
		    	qvo.setReply(rs.getString("reply"));
		    	qvo.setRep(rs.getString("rep"));
		    	qvo.setId(rs.getString("id"));
		    	list.add(qvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}





	public void insertQna(QnaVO qvo) {
		String sql = "insert into lqna (lqseq, title, content) "
				+ " values(lqna_lqseq.nextval , ? , ?  )";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getTitle());
		    pstmt.setString(2, qvo.getContent());
		    pstmt.setString(3, qvo.getId());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);  }
		
	}



	public QnaVO getQna(int lqseq) {
		QnaVO qvo = new QnaVO();
		String sql = "select * from lqna where lqseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  lqseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qvo.setLqseq(lqseq);
				qvo.setTitle(rs.getString("title"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return qvo;
	}

	
}




	
	
	
	

