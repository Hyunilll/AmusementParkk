package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.Cart2VO;
import com.ezen.world.util.Dbman;

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
				cvo.setTatname1(rs.getString("tatname2"));
				cvo.setTatname1(rs.getString("tatname3"));
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
		
	}
	

