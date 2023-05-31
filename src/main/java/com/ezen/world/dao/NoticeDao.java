package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.NoticeVO;
import com.ezen.world.util.Dbman;
import com.ezen.world.util.Paging;

public class NoticeDao {
	private NoticeDao() {}
	private static NoticeDao itc = new NoticeDao();
	public static NoticeDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<NoticeVO> selectNotice(Paging paging) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		con = Dbman.getConnection();

		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, n.* from ((select * from notice order by nseq desc) n) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum() );
			pstmt.setInt(2,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
		    	NoticeVO nvo = new NoticeVO();
		    	nvo.setNseq(rs.getInt("nseq"));
		    	nvo.setTitle(rs.getString("title"));
		    	nvo.setNcontent(rs.getString("ncontent"));
		    	nvo.setId(rs.getString("id"));
		    	nvo.setIndate(rs.getTimestamp("indate"));
		    			    	
		    	list.add(nvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}
		

	public int getAllCount() {
		int count= 0;
		String sql = "select count(*) as cnt from notice";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }
		return count;
	}


	public NoticeVO getnotice(int nseq) {
		NoticeVO nvo = new NoticeVO();
		String sql = "select * from notice where nseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  nseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
		    	nvo.setNseq(rs.getInt("nseq"));
		    	nvo.setTitle(rs.getString("title"));
		    	nvo.setNcontent(rs.getString("ncontent"));
		    	nvo.setId(rs.getString("id"));
		    	nvo.setIndate(rs.getTimestamp("indate"));		    	
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return nvo;
	}

}

