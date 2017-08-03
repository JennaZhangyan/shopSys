package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES(?,?,?)";
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

	public void delet(Goods good) {

	}

	public void showAll() {

	}

	public boolean query(String name) {
		conn = DBConn.getConn();
		boolean flag = false;
		String sql = "SELECT GNAME,GPRICE,GNUM FROM GOODS WHRER GNAME=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(0, name);

			rs = prestmt.executeQuery();
			if (rs != null) {
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
}
