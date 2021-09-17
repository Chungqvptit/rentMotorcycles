/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.DAO.con;
import Model.Taisanthechap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TsdbDAO extends DAO{

    public TsdbDAO() {
        super();
    }
        public int Timtsdm(String key){
        int kq=0;
        String sql = "SELECT * FROM tbltaisanthechap WHERE ten LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet ks = ps.executeQuery();
 
            while(ks.next()){
                Taisanthechap taisanthechap = new Taisanthechap();
                taisanthechap.setId(ks.getInt("id"));
                kq=taisanthechap.getId();
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return kq;
        
    }
    
}
