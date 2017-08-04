package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Goods;
import sqlFile.DBClose;
import sqlFile.DBConn;

public class GoodsMt {
	Connection conn;
	PreparedStatement prestmt;
	public ResultSet rs;

	public boolean add(Goods good) {
		conn = DBConn.getConn();
		boolean flag = false;
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES (?,?,?)";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, good.getgName());
			prestmt.setDouble(2, good.getgPrice());
			prestmt.setInt(3, good.getgNum());
			int row = prestmt.executeUpdate();
			if (row > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.addClose(prestmt, conn);
		}
		return flag;

	}

	public boolean update(int chose, Goods good) {
		conn = DBConn.getConn();
		boolean flag = false;

		try {
			switch (chose) {
			case 1:
				String sqlName = "UPDATE GOODS SET GNAME=? WHERE GID=?";
				prestmt = conn.prepareStatement(sqlName);
				prestmt.setString(1, good.getgName());
				prestmt.setInt(2, good.getgID());
				break;
			case 2:
				String sqlPrice = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
				prestmt = conn.prepareStatement(sqlPrice);
				prestmt.setDouble(1, good.getgPrice());
				prestmt.setInt(2, good.getgID());
				break;
			case 3:
				String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";
				prestmt = conn.prepareStatement(sqlNum);
				prestmt.setInt(1, good.getgNum());
				prestmt.setInt(2, good.getgID());
				break;
			default:
				break;
			}
			int row = prestmt.executeUpdate();
			if (row > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.addClose(prestmt, conn);
		}
		return flag;

	}

	public boolean delet(Goods good) {
		conn=DBConn.getConn();
		boolean flag=false;
		String sql="DELET FROM GOODS WHRER GNAME=?";
		try {
			prestmt=conn.prepareStatement(sql);
			prestmt.setString(1, good.getgName());
			int r=prestmt.executeUpdate();
			if (r>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
/*在query中rs已经关闭了，所以在外部是不能调用的*/
	public ArrayList<Goods> queryAll() {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DBConn.getConn();
		String sql = "SELECT * FROM GOODS";
		try {
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while(rs.next()) {
				int gid=rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3); 		
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid,gname,gprice,gnum);	//创建Goods对象，并赋值.
				goodsList.add(goods);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.queryClose(rs, prestmt, conn);
		}
		return goodsList;
	}

	public ArrayList<Goods> query(String name) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DBConn.getConn();
		String sql = "SELECT * FROM GOODS WHERE GNAME=%?%";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, name);

			rs = prestmt.executeQuery();
			while(rs.next()) {
				int gid=rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3); 		
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid,gname,gprice,gnum);	//创建Goods对象，并赋值.
				goodsList.add(goods);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.queryClose(rs, prestmt, conn);
		}
		return goodsList;
	}
	public ArrayList<Goods> query(int key) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DBConn.getConn();
		String sql=null;
		switch (key) {
		case 1:
			sql = "SELECT * FROM GOODS ORDER BY GNUM ASC";
			break;
		case 2:
			sql = "SELECT * FROM GOODS ORDER BY GPRICE ASC";
			break;
		default:
			break;
		}
		
		try {
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while(rs.next()) {
				int gid=rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3); 		
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid,gname,gprice,gnum);	//创建Goods对象，并赋值.
				goodsList.add(goods);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBClose.queryClose(rs, prestmt, conn);
		}
		return goodsList;
	}
}
