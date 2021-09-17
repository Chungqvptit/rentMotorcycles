/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class TsdbDAOTest {
    
    public TsdbDAOTest() {
    }

    @Test
    public void testTimtsdm1() {// tim duoc tai san dam bao
        String key="điện thoại";
        TsdbDAO td=new TsdbDAO();
        int kq=td.Timtsdm(key);
        Assert.assertTrue(kq==1);
    }
    @Test
    public void testTimtsdm2() {// tim duoc tai san dam bao
        String key="máy tính";
        TsdbDAO td=new TsdbDAO();
        int kq=td.Timtsdm(key);
        Assert.assertTrue(kq==2);
    }
    @Test
    public void testTimtsdm3() {// khong tim duoc tai san dam bao
        String key="iphone";
        TsdbDAO td=new TsdbDAO();
        int kq=td.Timtsdm(key);
        Assert.assertTrue(kq==0);
    }
    @Test
    public void testTimtsdm4() {// khong tim duoc tai san dam bao
        String key="acer nitro 5";
        TsdbDAO td=new TsdbDAO();
        int kq=td.Timtsdm(key);
        Assert.assertTrue(kq==0);
    }
}
