/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Hopdong;
import Model.Taisanduocthechap;
import Model.Xe;
import Model.Xeduocthue;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class HopdongDAOTest {
    SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
    public HopdongDAOTest() {
    }
    public void testThemhopdong1() {//xe duoc thue  ranh
        ArrayList<Xeduocthue> xdt=new ArrayList<>();
        ArrayList<Taisanduocthechap> tsdtc=new ArrayList<>();
        Hopdong hd=new Hopdong();
        String s1="23-May-2021 11:11:11";
            String s2="30-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
        Xeduocthue x=new Xeduocthue();
        x.setIdxe(1);
        x.setNgaythue(s1);
        x.setNgaytra(s2);
        x.setMota(" ");
        x.setGia(200000);
        xdt.add(x);
        Taisanduocthechap t=new Taisanduocthechap();
        t.setIdtstc(1);
        t.setMota(" ");
        t.setSl(2);
        hd.setMota(" ");
        hd.setIdkhachhang(5);
        hd.setIdnhanvien(4);
        HopdongDAO hddao=new HopdongDAO();
        XeDAO xd=new XeDAO();
        Connection con = DAO.con;  
        try {
            con.setAutoCommit(false);
            Assert.assertTrue(hddao.themhopdong(hd, xdt, tsdtc));
            ArrayList<Xe> listxe=new ArrayList<>();
            listxe=xd.TimXe(d1, d2);
            for(Xe i:listxe){
                Assert.assertFalse(i.getId() == 1);
            }
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
    public void testThemhopdong2() {//xe duoc thue khong ranh
        ArrayList<Xeduocthue> xdt=new ArrayList<>();
        ArrayList<Taisanduocthechap> tsdtc=new ArrayList<>();
        Hopdong hd=new Hopdong();
        String s1="20-May-2021 11:11:11";
            String s2="21-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
        Xeduocthue x=new Xeduocthue();
        x.setIdxe(1);
        x.setNgaythue(s1);
        x.setNgaytra(s2);
        x.setMota(" ");
        x.setGia(200000);
        xdt.add(x);
        Taisanduocthechap t=new Taisanduocthechap();
        t.setIdtstc(1);
        t.setMota(" ");
        t.setSl(2);
        hd.setMota(" ");
        hd.setIdkhachhang(5);
        hd.setIdnhanvien(4);
        HopdongDAO hddao=new HopdongDAO();
        Connection con = DAO.con;  
        try {
            con.setAutoCommit(false);
            Assert.assertFalse(hddao.themhopdong(hd, xdt, tsdtc));
            
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
