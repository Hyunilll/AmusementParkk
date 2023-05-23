package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.AttractionVO;
import com.ezen.world.util.Dbman;


public class AttractionDao {
	private AttractionDao() {}
	private static AttractionDao itc = new AttractionDao();
	public static AttractionDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public ArrayList<AttractionVO> getattraction() {
		ArrayList<AttractionVO> list = new ArrayList<AttractionVO>();
		con = Dbman.getConnection();
		String sql = "select * from attraction";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				AttractionVO avo = new AttractionVO();
				avo.setAseq( rs.getInt("aseq") );
				avo.setPnum( rs.getInt("pnum") );
				avo.setAtname( rs.getString("atname") );
				avo.setAcontent( rs.getString("acontent"));
				avo.setAct1(rs.getString("act1"));
				avo.setAct2(rs.getString("act2"));
				avo.setImage(rs.getString("image"));
				avo.setLimitkey(rs.getString("limitkey"));
				avo.setLimitage(rs.getString("limitage"));
				avo.setBestat(rs.getString("bestat"));
				avo.setAresult(rs.getString("aresult"));
				list.add(avo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }
		return list;
	}


	public ArrayList<AttractionVO> getBestattraction() {
		ArrayList<AttractionVO> list = new ArrayList<AttractionVO>();
		String sql = "select * from best_at_view";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				AttractionVO avo = new AttractionVO();
				avo.setAseq( rs.getInt("aseq") );
				avo.setAtname( rs.getString("atname") );
				avo.setImage( rs.getString("image") );
				list.add(avo);
			}
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }	
		
		return list;
	
	}


	public ArrayList<AttractionVO> getrestattraction() {
		ArrayList<AttractionVO> list = new ArrayList<AttractionVO>();
		String sql = "select * from rest_at_view";
		con = Dbman.getConnection();
		try {	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				AttractionVO avo = new AttractionVO();
				avo.setAseq( rs.getInt("aseq") );
				avo.setAtname( rs.getString("atname") );
				avo.setImage( rs.getString("image") );
				list.add(avo);
			}
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }	
		
		return list;
	
	}


	public AttractionVO getProduct(int aseq) {
		AttractionVO avo = null;
		String sql = "select * from attraction where aseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, aseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avo = new AttractionVO();
				avo.setAseq(rs.getInt("aseq"));
				avo.setPnum(rs.getInt("pnum"));
				avo.setAtname(rs.getString("atname"));
				avo.setAcontent(rs.getString("acontent"));
				avo.setAct1(rs.getString("act1"));
				avo.setAct2(rs.getString("act2"));
				avo.setImage(rs.getString("image"));
				avo.setLimitkey(rs.getString("limitkey"));
				avo.setLimitage(rs.getString("limitage"));
				avo.setBestat(rs.getString("bestat"));
				avo.setAresult(rs.getString("aresult"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		return avo;
	}

}
