package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.ezen.world.dto.Cart2VO;
import com.ezen.world.dto.QnaVO;
import com.ezen.world.util.Dbman;
import com.ezen.world.util.Paging;

public class Cart2Dao {
	private Cart2Dao() {}
	private static Cart2Dao itc = new Cart2Dao();
	public static Cart2Dao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void insertTicket(Cart2VO cvo) {
		con = Dbman.getConnection();
		String sql = "insert into cart2(cseq, id, kind, p1, p2, tatname1, tatname2, tatname3,"
				+ " price1, price2, visitdate)"
				+ " values(cart2_cseq.nextval, ?, ?, ?, ?, ?, ?, ?,?,? ,?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvo.getId());
			pstmt.setInt(2,cvo.getKind());
			pstmt.setInt(3, cvo.getP1());
			pstmt.setInt(4, cvo.getP2());
			pstmt.setString(5, cvo.getTatname1());
			pstmt.setString(6, cvo.getTatname2());
			pstmt.setString(7, cvo.getTatname3());
			pstmt.setInt(8, cvo.getPrice1());
			pstmt.setInt(9, cvo.getPrice2());
			pstmt.setDate (10,new java.sql.Date(cvo.getVisitdate().getTime()));
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
	}


	public ArrayList<Cart2VO> selectCart(String id) {
		ArrayList<Cart2VO> list = new ArrayList<Cart2VO>();
		String sql = "select * from cart2 where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				Cart2VO cvo = new Cart2VO();				
				cvo.setCseq(rs.getInt("cseq"));  		
				cvo.setId(rs.getString("id"));
				cvo.setKind(rs.getInt("kind"));
				cvo.setP1(rs.getInt("p1"));				
				cvo.setP2(rs.getInt("p2"));
				cvo.setTatname1(rs.getString("tatname1"));
				cvo.setTatname2(rs.getString("tatname2"));
				cvo.setTatname3(rs.getString("tatname3"));
				cvo.setIndate(rs.getTimestamp("indate"));
				cvo.setVisitdate(rs.getDate("visitdate"));
				cvo.setPrice1(rs.getInt("price1"));
				cvo.setPrice2(rs.getInt("price2"));	
				list.add(cvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}


	public void deleteCart(int cseq) {
		
		String sql ="Delete from cart2 where cseq=?";
		con= Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq  );
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}
	
	


	public int getAllCountCart2() {
		
			int count= 0;
			String sql = "select count(*) as cnt from Cart2";
			con = Dbman.getConnection();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if( rs.next() ) count = rs.getInt("cnt");
			} catch (SQLException e) { e.printStackTrace();
			} finally { Dbman.close(con, pstmt, rs);   }
			return count;
		}


public ArrayList<Cart2VO> selectCart2(Paging paging) {
	ArrayList<Cart2VO> list = new ArrayList<Cart2VO>();
	String sql = " select * from ( "
			+ " select * from ( "
			+ " select rownum as rn, q.* from ((select * from Cart2 order by cseq desc) q) "
			+ " ) where rn>=? "
			+ " ) where rn<=? ";
	con = Dbman.getConnection();
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  paging.getStartNum() );
		pstmt.setInt(2,  paging.getEndNum() );
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Cart2VO qvo = new Cart2VO();
	    	qvo.setCseq(rs.getInt("cseq"));
	    	qvo.setId(rs.getString("id"));
	    	qvo.setKind(rs.getInt("kind"));
	    	qvo.setP1(rs.getInt("p1"));
	    	qvo.setP2(rs.getInt("p2"));
	    	qvo.setTatname1(rs.getString("tatname1"));
	    	qvo.setTatname2(rs.getString("tatname2"));
	    	qvo.setTatname3(rs.getString("tatname3"));
	    	qvo.setIndate(rs.getTimestamp("indate"));
	    	qvo.setVisitdate(rs.getDate("visitdate"));
	    	qvo.setPrice1(rs.getInt("price1"));
	    	qvo.setPrice2(rs.getInt("price2"));
	    	qvo.setPrice3(rs.getInt("price3"));
	    	qvo.setPrice4(rs.getInt("price4"));
	    	list.add(qvo);
	    }
	} catch (SQLException e) {e.printStackTrace();
	} finally { Dbman.close(con, pstmt, rs);  }
	return list;
}


}

