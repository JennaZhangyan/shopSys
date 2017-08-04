package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.GSales;
import entity.Goods;
import entity.SalesMan;
import sqlFile.DBClose;
import sqlFile.DBConn;

public class Cash {
	Connection conn;
	PreparedStatement prestmt;
	public ResultSet rs;
	
	public ArrayList<SalesMan> queryAll(){
		ArrayList<SalesMan> salesList = new ArrayList<SalesMan>();
		conn = DBConn.getConn();
		String sql = "SELECT * FROM SALESMAN";
		try {
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while(rs.next()) {
				int sid=rs.getInt(1);
				String sname = rs.getString(2);
				String spassword = rs.getString(3); 		
				
				SalesMan salers=new SalesMan(sid, sname, spassword);
				salesList.add(salers);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.queryClose(rs, prestmt, conn);
		}
		return salesList;
	}

	public boolean addGSales(GSales gsale) {
		// TODO Auto-generated method stub
		boolean flag=false;
		conn = DBConn.getConn();
		String sql = "insert into gsales(gid,sid,snum,sdate) values(?,?,?,?)";
		try {
			prestmt=conn.prepareStatement(sql);
			prestmt.setInt(1, gsale.getgID());
			prestmt.setInt(2, gsale.getsID());;
			prestmt.setInt(3, gsale.getsNum());
			prestmt.setTimestamp(4, gsale.getsDate());
			
			int row=prestmt.executeUpdate();
			if (row>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			DBClose.addClose(prestmt, conn);
		}
		return flag;
	}
	
//	public ArrayList<SalesMan> query(String s){
//		ArrayList<SalesMan> salesList = new ArrayList<SalesMan>();
//		conn = DBConn.getConn();
//		String sql = "SELECT * FROM SALESMAN WHERE GNAME LIKE %?%";
//		try {
//			prestmt = conn.prepareStatement(sql);
//			prestmt.setString(1, s);
//
//			rs = prestmt.executeQuery();
//			while(rs.next()) {
//				int sid=rs.getInt(1);
//				String sname = rs.getString(2);
//				String spassword = rs.getString(3); 		
//				
//				SalesMan salers=new SalesMan(sid, sname, spassword);
//				salesList.add(salers);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			DBClose.queryClose(rs, prestmt, conn);
//		}
//		return salesList;
//	}
}
