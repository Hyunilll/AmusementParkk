package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.util.Dbman;
import com.ezen.world.util.Paging;



public class AdminDao {
	
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public AdminVo getAdminMember(String id) {
		
		AdminVo avo =null;
		String sql = "select * from Lworker where id = ?";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				avo = new AdminVo();
				avo.setId( rs.getString("id") );
				avo.setPwd( rs.getString("pwd") );
				avo.setName( rs.getString("name") );
				avo.setPhone( rs.getString("phone") );
			}			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return avo;
	}


	public int getAllcount(String tablename, String fieldname, String key) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from "+tablename+
				"  where "+ fieldname +" like '%'||?||'%' ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return count;
	}


	public ArrayList<MemberVo> admiMemberList(Paging paging, String key) {
		ArrayList<MemberVo>list= new ArrayList<MemberVo>();
		con = Dbman.getConnection();
		String sql = " select * from ("
				+ " select * from ("
				+ " select rownum as rn, m.* from "
				+ " ((select * from Lmember where name like '%'||?||'%' order by indate desc) m)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3,  paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVo mvo =new MemberVo();
				mvo.setId( rs.getString("id") );
				mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setZip_num(rs.getString("zip_num"));
		        mvo.setAddress1(rs.getString("address1"));
		        mvo.setAddress2(rs.getString("address2"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setIndate(rs.getTimestamp("indate"));		
				list.add(mvo);
			}
							
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
	 
		
		return list;
	}
	
}
