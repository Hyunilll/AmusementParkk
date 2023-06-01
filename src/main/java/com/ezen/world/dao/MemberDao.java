package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.AddressVO;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.util.Dbman;



public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVo getMember(String id) {
		MemberVo mvo = null;
		String sql = "select * from Lmember where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mvo = new MemberVo();
				mvo.setId( rs.getString("id") );
				mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setZip_num(rs.getString("zip_num"));
		        mvo.setAddress1(rs.getString("address1"));
		        mvo.setAddress2(rs.getString("address2"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }		
		return mvo;
	
	}

	public ArrayList<AddressVO> selectAddress(String dong) {
		
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		con = Dbman.getConnection();
		String sql = "select * from address where dong like '%'||?||'%' ";
		// ? 가 null 이면 조건이 없는것과 같은 검색 결과를 얻습니다.
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
		    while( rs.next() ) {
		    	AddressVO avo = new AddressVO();
		    	avo.setZip_num(rs.getString("zip_num"));
		    	avo.setSido(rs.getString("sido"));
		    	avo.setGugun(rs.getString("gugun"));
		    	avo.setDong(rs.getString("dong"));
		    	avo.setZip_code(rs.getString("zip_code"));
		    	avo.setBunji(rs.getString("bunji"));
		    	list.add(avo);
		    }
		    
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return list;

	}

	
	
	public int insertMember(MemberVo mvo) {
		
		int result=0;
		con = Dbman.getConnection();
		String sql = "insert into Lmember(id, pwd, name, zip_num, address1, address2, email, phone)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());      
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getEmail());
			pstmt.setString(8, mvo.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	
		}
		
		return result;
	}

	public void updateMember(MemberVo mvo) {
		con = Dbman.getConnection();
		String sql = "Update Lmember set pwd=?, name=?, zip_num=?, address1=?, "
				+ "address2=?, email=?, phone=? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getZip_num());
			pstmt.setString(4, mvo.getAddress1());
			pstmt.setString(5, mvo.getAddress2());
			pstmt.setString(6, mvo.getEmail());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getId());      
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	
		}
		
	}

	public void deleteMember(String id) {
		con = Dbman.getConnection();
		String sql = "Update Lmember set useyn='N' where id = ?";
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	
		}
	}
	
	public MemberVo selectId(String name, String phone) {
		MemberVo mvo = null;
	      String sql = "SELECT ID FROM Lmember WHERE name = ? AND phone = ?";
	      con = Dbman.getConnection();
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, name);
	         pstmt.setString(2, phone);
	         rs = pstmt.executeQuery();
	          while( rs.next() ) {
	             mvo = new MemberVo();
	            mvo.setId( rs.getString("id") );
	          }
	      } catch (SQLException e) { e.printStackTrace();
	      } finally { Dbman.close(con, pstmt, rs);
	      }
	      return mvo;
	   }

	public MemberVo selectPwd(String id, String name, String phone) {

			MemberVo mvo = null;
		    String sql = "SELECT PWD FROM Lmember WHERE id = ? AND name = ? AND phone = ?";
		    con = Dbman.getConnection();
		    try {
		        pstmt = con.prepareStatement(sql);
		        pstmt.setString(1, id);
		        pstmt.setString(2, name);
		        pstmt.setString(3, phone);
		        rs = pstmt.executeQuery();
		        while( rs.next() ) {
		             mvo = new MemberVo();
		            mvo.setPwd( rs.getString("pwd") );
		          }
		      } catch (SQLException e) { e.printStackTrace();
		      } finally { Dbman.close(con, pstmt, rs);
		      }
		      return mvo;
		   }


	public void resetNewPwd(MemberVo mvo) {
		
		con = Dbman.getConnection();
		String sql = "Update Lmember set pwd=? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getId());      
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	
		}
	
		
	}


}
	   


