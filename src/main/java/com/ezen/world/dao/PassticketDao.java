package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.AttractionVO;
import com.ezen.world.dto.PassticketVO;
import com.ezen.world.util.Dbman;

public class PassticketDao {
	private PassticketDao() {}
	private static PassticketDao itc = new PassticketDao();
	public static PassticketDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<PassticketVO> getticket() {
		ArrayList<PassticketVO> list = new ArrayList<PassticketVO>();
		con = Dbman.getConnection();
		String sql = "select * from passticket";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PassticketVO ptvo = new PassticketVO();
				ptvo.setPtseq( rs.getInt("ptseq") );
				ptvo.setAprice( rs.getInt("aprice") );
				ptvo.setTprice( rs.getInt("tprice") );
				ptvo.setCprice( rs.getInt("cprice") );
				ptvo.setAquantity( rs.getInt("aquantity") );
				ptvo.setTquantity( rs.getInt("tquantity") );
				ptvo.setCquantity( rs.getInt("cquantity") );
				ptvo.setIndate( rs.getTimestamp("indate") );
				ptvo.setVisitdate( rs.getTimestamp("visitdate") );
				list.add(ptvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	
	
}
