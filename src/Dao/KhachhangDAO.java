/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Khachhang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class KhachhangDAO extends DAO{

    public KhachhangDAO() {
        super();
    }
    public ArrayList<Khachhang> Timkhach(String key){
        // ham tim khach hang theo ten
        ArrayList<Khachhang> kq=new ArrayList<Khachhang>();
        String sql = "SELECT * FROM tblkhachhang WHERE ten LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
 
            while(rs.next()){
                Khachhang khachhang = new Khachhang();
                khachhang.setId(rs.getInt("id"));
                khachhang.setTen(rs.getString("ten"));
                khachhang.setTuoi(rs.getInt("tuoi"));
                khachhang.setDc(rs.getString("diachi"));
                khachhang.setCmnd(rs.getString("cmnd"));
                khachhang.setSdt(rs.getString("sdt"));
                khachhang.setMota(rs.getString("mota"));
                kq.add(khachhang);
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return kq;
        
    }
     public boolean ThemKhach(Khachhang khachhang){
        //ham them khach hang moi
        boolean kq=true;
        String sql = "INSERT INTO tblkhachhang(ten, tuoi, diachi, cmnd, sdt,mota) VALUES(?,?,?,?,?,?)";
        String checksql ="SELECT * FROM tblkhachhang WHERE ten=? AND cmnd=?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(checksql);
             ps.setString(1, khachhang.getTen());
             ps.setString(2, khachhang.getCmnd());
             ResultSet xs = ps.executeQuery();
            if(xs.next()){// kiem tra xem khach da ton tai hay chua khi thuc hien junit test
                kq = false;
                        try {
                            con.rollback();
                            con.setAutoCommit(true);
                        }catch(Exception ex) {
                            kq = false;
                            ex.printStackTrace();
                        }
                        return kq;
            }
            ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, khachhang.getTen());
            ps.setInt(2, khachhang.getTuoi());
            ps.setString(3, khachhang.getDc());
            ps.setString(4, khachhang.getCmnd());
            ps.setString(5, khachhang.getSdt());
            ps.setString(6, khachhang.getMota());
            ps.executeUpdate();
            //get id of the new inserted khachhang
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                khachhang.setId(generatedKeys.getInt(1));
            }
            con.commit();// khi test thì cmt lại
            kq=true;
        }catch(Exception e){
            kq=false;
            e.printStackTrace();
            return kq;
        }
        return kq;
    }

}
