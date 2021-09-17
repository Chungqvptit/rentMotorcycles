/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Hoadon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Hopdong;
import Model.Taisanduocthechap;
import Model.Xeduocthue;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HopdongDAO extends DAO{

    public HopdongDAO() {
        super();
    }
    public boolean themhopdong(Hopdong hd,ArrayList<Xeduocthue> arr,ArrayList<Taisanduocthechap> art){
        String sqlThemhopdong="INSERT INTO tblhopdong(ngaylaphopdong,mota,idkhachhang,idnhanvien) VALUE(?,?,?,?)"  ;
        String sqlThemxe="INSERT INTO tblxeduocthue(ngaythue,ngaytra,gia,mota,idxe,idhopdong) VALUE(?,?,?,?,?,?)";
        String sqlThemTSDB="INSERT INTO tbltaisanduocthechap(soluong,mota,idhopdong,idtaisanthechap) VALUE(?,?,?,?)";
        String sqlThemhoadon="INSERT INTO tblhoadon(ngaythanhtoan,sotienthanhtoan,kieuthanhtoan,mota,idhopdong) VALUE(?,?,?,?,?)";
        String sqlCheckxe="SELECT * FROM tblxeduocthue WHERE idxe = ? AND ngaytra > ? AND ngaythue < ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        java.util.Date date1=new java.util.Date();
        boolean kq=true;
        try{
            System.out.println("Chuẩn bị tới thêm hợp đồng");
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement(sqlThemhopdong,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,sdf.format(date1));
            ps.setString(2, hd.getMota());
            ps.setInt(3, hd.getIdkhachhang());
            ps.setInt(4, hd.getIdnhanvien());
            ps.executeUpdate();
            ResultSet Key=ps.getGeneratedKeys();
            if(Key.next()){
                hd.setId(Key.getInt(1));
            }
            System.out.println("CHuẩn bị thêm xe");
                Date date3 = null;
                Date date4 = null;
            for(Xeduocthue x: arr){//them xe trong danh sach xe duoc chon
                System.out.println("Xe duoc thue x có id xe là:"+x.getIdxe());
                int dem=0;
                //kiem tra trong danh sach co 2 xe duoc chon trung nhau hay khong
                for(Xeduocthue y:arr){
                    if(y.getIdxe()==x.getIdxe()){
                        dem++;
                    }
                }
                if(dem>1){
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
                // ket thuc kiem tra
            try {
            date3 = f.parse(x.getNgaythue());
            date4 = f.parse(x.getNgaytra());
                }
             catch (Exception e) {
            e.printStackTrace();
            }
            //kiem tra xe duoc chon da co trong danh sach xe duoc thue ung ung voi ngay thue ngay tra tuong ung hay chua
            ps = con.prepareStatement(sqlCheckxe);//tim cac xe co id va ngay thue ngay tra trung voi x
                    ps.setInt(1, x.getIdxe());
                    ps.setString(2, sdf.format(date3));
                    ps.setString(3,sdf.format(date4) );
                     
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()) {//neu tim thay xe da co trong xe duoc thue thi tra ve false
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
                    //ket thuc kiem tra
                    //them xe duoc thue
              ps=con.prepareStatement(sqlThemxe,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(date3));
                ps.setString(2, sdf.format(date4));
                ps.setFloat(3, x.getGia());
                ps.setString(4, x.getMota());
                ps.setInt(5, x.getIdxe());
                ps.setInt(6, hd.getId());
                ps.executeUpdate();
                Key=ps.getGeneratedKeys();
                if(Key.next()){
                    x.setId(Key.getInt(1));
                }
//                        
            }//ket thuc them xe
            //them tai san duoc dam bao
            System.out.println("Chuẩn bị thêm tài sản đảm bảo");
            for(Taisanduocthechap y:art){
                ps=con.prepareStatement(sqlThemTSDB,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,y.getSl());
                ps.setString(2,y.getMota());
                ps.setInt(3, hd.getId());
                ps.setInt(4, y.getIdtstc());
                ps.executeUpdate();
                Key=ps.getGeneratedKeys();
                if(Key.next()){
                    y.setId(Key.getInt(1));
                }
            }//ket thuc them tai san dam bao
            
            con.commit(); //khi test thi cmt lại
        } catch (SQLException ex) {
            try {
                kq=false;
                con.rollback();
                con.setAutoCommit(true);
                Logger.getLogger(HopdongDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(HopdongDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return kq;
    }
}
