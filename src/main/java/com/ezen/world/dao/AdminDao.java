package com.ezen.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.AttractionVO;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.dto.NoticeVO;
import com.ezen.world.dto.QnaVO;
import com.ezen.world.util.Dbman;
import com.ezen.world.util.Paging;



public class AdminDao {
	
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
// 관리자 정보 조회
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

// 멤버 조회
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

// 공지 추가	
	public void insertNotice(NoticeVO nvo) {
		con = Dbman.getConnection();
		String sql = "insert into notice(nseq, title, ncontent , id)"
				+ " values(notice_nseq.nextval, ?, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2,nvo.getNcontent());
			pstmt.setString(3, nvo.getId());
			pstmt.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
	}

// 공지 수정
	public void updateNotice(NoticeVO nvo) {
		con = Dbman.getConnection();
		String sql = "update notice set title=?, ncontent=?, id=?  where nseq=?";
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2,nvo.getNcontent());
			pstmt.setString(3, nvo.getId());
			pstmt.setInt(4, nvo.getNseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
	}

// 공지 삭제
	public void DeleteNotice(int nseq) {
		con = Dbman.getConnection();
		String sql = "Delete from notice where nseq=?";
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
	}


// 놀이기구 추가
	public void insertAttraction(AttractionVO atvo) {
		con = Dbman.getConnection();
		String sql = "insert into attraction(aseq, atname, acontent , act1, act2, image,"
				+ " pnum, limitkey, limitage, bestat, aresult )"
				+ " values(attraction_aseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, atvo.getAtname());
			pstmt.setString(2, atvo.getAcontent());
			pstmt.setString(3, atvo.getAct1());
			pstmt.setString(4, atvo.getAct2());
			pstmt.setString(5, atvo.getImage());
			pstmt.setInt(6, atvo.getPnum());
			pstmt.setString(7, atvo.getLimitkey());
			pstmt.setString(8, atvo.getLimitage());
			pstmt.setString(9, atvo.getBestat());
			pstmt.setString(10, atvo.getAresult());
			pstmt.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
	}


	public void updateAttraction(AttractionVO atvo) {
		con = Dbman.getConnection();
		String sql = "update attraction set atname=?, acontent=?, act1=?, act2=?, image=? ,pnum=?,"
				+ " limitkey=?, limitage=?, bestat=?, aresult=? where aseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, atvo.getAtname());
			pstmt.setString(2, atvo.getAcontent());
			pstmt.setString(3, atvo.getAct1());
			pstmt.setString(4, atvo.getAct2());
			pstmt.setString(5, atvo.getImage());
			pstmt.setInt(6, atvo.getPnum());
			pstmt.setString(7, atvo.getLimitkey());
			pstmt.setString(8, atvo.getLimitage());
			pstmt.setString(9, atvo.getBestat());
			pstmt.setString(10, atvo.getAresult());
			pstmt.setInt(11, atvo.getAseq());
			pstmt.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
	}


	public void DeleteAttraction(int aseq) {
		con = Dbman.getConnection();
		String sql = "Delete from attraction where aseq=?";
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, aseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
	}
	

	public int getAllCountQna(String key) {
		int count=0;
		String sql = "select count(*) as cnt from lqna "
				+ " where title like '%'||?||'%'  or content like  '%'||?||'%' ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setString(2,  key);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
			
		}catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return count;
	}


	public ArrayList<QnaVO> adminQnaList(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		con = Dbman.getConnection();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, lq.* from "
				+ " ((select * from lqna "
				+ "	where title like '%'||?||'%' or content like '%'||?||'%' order by lqseq desc) lq) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);								
			pstmt.setString(2,  key);
			pstmt.setInt(3,  paging.getStartNum()) ;		
			pstmt.setInt(4,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setLqseq(rs.getInt("lqseq"));				
				qvo.setTitle(rs.getString("title"));
				qvo.setContent(rs.getString("content"));		
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));		
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);   }
		return list;
	}


	public void updateQna(QnaVO qvo) {
		String sql = "update lqna set reply=?, rep='Y' where lqseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getReply() );
			pstmt.setInt(2,  qvo.getLqseq() );
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace(); 
		} finally { Dbman.close(con, pstmt, rs);  }
	
		
	}




	public ArrayList<NoticeVO> adminNoticeList(Paging paging, String key) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		con = Dbman.getConnection();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, lq.* from "
				+ " ((select * from notice "
				+ "	where title like '%'||?||'%' order by nseq desc) lq) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setInt(2,  paging.getStartNum()) ;		
			pstmt.setInt(3,  paging.getEndNum() );								
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
		} catch (SQLException e) { e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);   }
		return list;

	}


	public int getAllCountNotice(String key) {
		int count=0;
		String sql = "select count(*) as cnt from nseq "
				+ " where title like '%' ||?||'%' ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
			
		}catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return count;

	}


	public NoticeVO getNotice(int nseq) {
	    NoticeVO nvo = new NoticeVO();
	    String sql = "select * from notice where nseq = ?";
	    con = Dbman.getConnection();
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, nseq);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            nvo.setNseq(rs.getInt("nseq"));
	            nvo.setTitle(rs.getString("title"));
	            nvo.setNcontent(rs.getString("ncontent"));
	            nvo.setId(rs.getString("id"));
	            nvo.setIndate(rs.getTimestamp("indate"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Dbman.close(con, pstmt, rs);
	    }
	    return nvo;
	}
}
