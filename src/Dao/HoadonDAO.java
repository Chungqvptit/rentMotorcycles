/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.DAO.con;
import Model.Hoadon;
import Model.Hopdong;
import Model.Taisanduocthechap;
import Model.Xeduocthue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HoadonDAO extends DAO{

    public HoadonDAO() {
        super();
    }
        public boolean themhoadon(Hopdong hd,Hoadon hoadon){//Them hoa don
        String sqlThemhoadon="INSERT INTO tblhoadon(ngaythanhtoan,sotienthanhtoan,kieuthanhtoan,mota,idhopdong) VALUE(?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date1=new java.util.Date();
        boolean kq=true;
        try{
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement(sqlThemhoadon,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,sdf.format(date1));
            ps.setFloat(2, hoadon.getSotien());
            ps.setString(3, hoadon.getKieu());
            ps.setString(4, " ");
            ps.setInt(5, hd.getId());
            ps.executeUpdate();
            ResultSet Key=ps.getGeneratedKeys();
            if(Key.next()){
                hoadon.setId(Key.getInt(1));
            }
            con.commit();// cmt lại kgi chạy test
        } catch (SQLException ex) {
            try {
                kq=false;
                con.rollback();
                Logger.getLogger(HopdongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(HopdongDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return kq;
    }
    
}


