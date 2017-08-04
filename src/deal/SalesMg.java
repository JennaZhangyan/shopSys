package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.GSales;
import sqlFile.DBClose;
import sqlFile.DBConn;

public class SalesMg {
	Connection conn;
	PreparedStatement prestmt;
	public ResultSet rs;
	
	public ArrayList<GSales> showAll(){
		ArrayList<GSales> gsList=new ArrayList<GSales>();
		conn=DBConn.getConn();
		String sql="select gname,gprice,gnum,snum from goods join gsales using gid";
		try {
			prestmt=conn.prepareStatement(sql);
			rs=prestmt.executeQuery();
			while(rs.next()) {
				String gname=rs.getString(1);
				double gprice=rs.getDouble(2);
				int gnum=rs.getInt(3);
				int snum=rs.getInt(4);
				
				GSales gSales=new GSales(gname,gprice,gnum,snum);
				gsList.add(gSales);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			DBClose.queryClose(rs, prestmt, conn);
		}
		return gsList;
	}
}
