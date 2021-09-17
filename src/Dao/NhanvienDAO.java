/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Nhanvien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class NhanvienDAO extends DAO{

    public NhanvienDAO() {
        super();
    }
    public boolean checkLogin(Nhanvien nv) {//ham kiểm tra đăng nhập
        boolean result = false;
        String sql = "SELECT vitri,Ten,id FROM tblnhanvien WHERE taikhoan = ? AND matkhau = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTk());
            ps.setString(2, nv.getMk());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                nv.setId(rs.getInt("id"));
                nv.setTen(rs.getString("Ten"));
                nv.setVitri(rs.getString("vitri"));
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
}
