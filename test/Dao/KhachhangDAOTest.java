/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert.*;
import Model.Khachhang;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
/**
 *
 * @author ADMIN
 */
public class KhachhangDAOTest {
    
    public KhachhangDAOTest() {
    }

    @Test
    public void testTimkhach1() {//khong tim thay khach nao
        KhachhangDAO kh = new KhachhangDAO();
        String key = "xxxxxxxxxx";
        ArrayList<Khachhang> listRoom = kh.Timkhach(key);
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(0, listRoom.size());
    }
    @Test
    public void testTimkhach2() {//tim thay khach
        KhachhangDAO kh = new KhachhangDAO();
        String key = "nguyen";
        ArrayList<Khachhang> listRoom = kh.Timkhach(key);
        Assert.assertNotNull(listRoom);
          Assert.assertEquals(4, listRoom.size());
        for(int i=0; i<listRoom.size(); i++){
            Assert.assertTrue(listRoom.get(i).getTen().toLowerCase().
                     contains(key.toLowerCase()));
        }
    }
    @Test
    public void testTimkhach3() { // tim thay khach
        KhachhangDAO kh = new KhachhangDAO();
        String key = "van";
        ArrayList<Khachhang> listRoom = kh.Timkhach(key);
        Assert.assertNotNull(listRoom);
          Assert.assertEquals(5, listRoom.size());
        for(int i=0; i<listRoom.size(); i++){
            Assert.assertTrue(listRoom.get(i).getTen().toLowerCase().
                     contains(key.toLowerCase()));
        }
    }
    @Test
    public void testThemkhach1(){ //Khach hang chua ton tai
            KhachhangDAO khd = new KhachhangDAO();
            Khachhang kh=new Khachhang();
            kh.setTen("do quy minh");
            kh.setCmnd("001200030015");
            kh.setSdt("0900000011");
            kh.setMota(" ");
            kh.setDc("haiphong");
            kh.setTuoi(21);
            Connection con = DAO.con;
        try {
            con.setAutoCommit(false);
            Assert.assertTrue(khd.ThemKhach(kh));
        } catch(Exception ex){
                ex.printStackTrace();
            }finally{
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
     }
        @Test
    public void testThemkhach2(){//Khach hang da ton tai
            KhachhangDAO khd = new KhachhangDAO();
            Khachhang kh=new Khachhang();
            kh.setTen("nguyen van an");
            kh.setCmnd("001200030001");
            kh.setSdt("0900000001");
            kh.setMota(" ");
            kh.setDc("hanoii");
            kh.setTuoi(21);
            Connection con = DAO.con;
        try {
            con.setAutoCommit(false);
            Assert.assertFalse(khd.ThemKhach(kh));
        } catch(Exception ex){
                ex.printStackTrace();
            }finally{
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
     }
}
