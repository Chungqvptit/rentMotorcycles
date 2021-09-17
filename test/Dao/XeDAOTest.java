/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Xe;
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
public class XeDAOTest {
    
    public XeDAOTest() {
    }

    XeDAO xd=new XeDAO();
    SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
    @Test
    public void testTimXe1(){//tim duoc xe
            String s1="17-May-2021 11:11:11";
            String s2="19-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
            ArrayList<Xe> dsXe=xd.TimXe(d1, d2);
            Assert.assertNotNull(dsXe);
            Assert.assertEquals(5, dsXe.size());
         
    }
    @Test
    public void testTimXe2(){//khong tim thay xe nao
            String s1="20-May-2021 11:11:11";
            String s2="23-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
            ArrayList<Xe> dsXe=xd.TimXe(d1, d2);
            Assert.assertNotNull(dsXe);
            Assert.assertEquals(0, dsXe.size());

    }
    @Test
    public void testTimXe3(){//tim suoc xe
            String s1="24-May-2021 11:11:11";
            String s2="25-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
            ArrayList<Xe> dsXe=xd.TimXe(d1, d2);
            Assert.assertNotNull(dsXe);
            Assert.assertEquals(1, dsXe.size());
            for(int i=0; i<dsXe.size(); i++){
        Assert.assertFalse(dsXe.get(i).getId() == 1);
        Assert.assertFalse(dsXe.get(i).getId() == 2);
        Assert.assertFalse(dsXe.get(i).getId() == 3);
        Assert.assertFalse(dsXe.get(i).getId() == 5);
        
    }
        
    }
    @Test
     public void testTimXe4(){//tim duoc xe
            String s1="26-May-2021 11:11:11";
            String s2="27-May-2021 11:11:11";
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = f.parse(s1);
            d2 = f.parse(s2);
             }
             catch (Exception e) {
            e.printStackTrace();
            }
            ArrayList<Xe> dsXe=xd.TimXe(d1, d2);
            Assert.assertNotNull(dsXe);
            Assert.assertEquals(3, dsXe.size());
            for(int i=0; i<dsXe.size(); i++){
        Assert.assertFalse(dsXe.get(i).getId() == 3);
        Assert.assertFalse(dsXe.get(i).getId() == 5);
    }
    }
}
