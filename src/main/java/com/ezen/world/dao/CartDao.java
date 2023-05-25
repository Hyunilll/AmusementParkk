package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.CartVO;
import com.ezen.world.util.Dbman;

public class CartDao {
	private CartDao() {}
	private static CartDao itc = new CartDao();
	public static CartDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<CartVO> selectCart(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				CartVO cvo = new CartVO();				
				cvo.setLcseq(rs.getInt("lcseq"));  		
				cvo.setId(rs.getString("id")); 
				cvo.setPtseq(rs.getInt("ptseq"));				
				cvo.setAquantity(rs.getInt("aquantity"));
				cvo.setCquantity(rs.getInt("cquantity"));
				cvo.setAprice(rs.getInt("aprice"));
				cvo.setCprice(rs.getInt("cprice"));
				cvo.setIndate(rs.getTimestamp("indate"));
				cvo.setVisitdate(rs.getTimestamp("visitdate"));
				list.add(cvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}
	
	
	
}
