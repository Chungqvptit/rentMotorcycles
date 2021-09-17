/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Hoadon;
import Model.Hopdong;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class HoadonDAOTest {
    
    public HoadonDAOTest() {
    }

    @Test
    public void testThemhoadon1() {
        HoadonDAO hdd=new HoadonDAO();
        Hoadon hoadon=new Hoadon();
        Hopdong hd=new Hopdong();
        hd.setId(1);
        hoadon.setKieu("Tiền mặt");
        hoadon.setMota(" ");
        hoadon.setSotien(200000);
        Connection con = DAO.con;  
        try {
            con.setAutoCommit(false);
            Assert.assertTrue(hdd.themhoadon(hd, hoadon));
            
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
