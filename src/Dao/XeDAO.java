/*
 * To change this license header, choose License HeadeXS in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Xe;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class XeDAO extends DAO{

    public XeDAO() {
        super();
    }
    	public ArrayList<Xe> TimXe(Date ngaythue,Date ngaytra){
		ArrayList<Xe> result = new ArrayList<Xe>();
                String sql = "SELECT * FROM tblxe WHERE id NOT IN (SELECT idxe FROM tblxeduocthue WHERE ngaytra > ? AND ngaythue < ?)";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, sdf.format(ngaythue));
                    ps.setString(2, sdf.format(ngaytra));
                    ResultSet XS = ps.executeQuery();
			while(XS.next()){
				Xe xe = new Xe();
				xe.setId(XS.getInt("id"));
				xe.setTen(XS.getString("ten"));
                                xe.setBienso(XS.getString("bienso"));
				xe.setTrangthai(XS.getString("trangthai"));
				xe.setGia(XS.getFloat("gia"));
				xe.setMota(XS.getString("mota"));
				result.add(xe);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
}
