/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Xe implements Serializable{ 
    private int id;
    private String ten;
    private String bienso;
    private String trangthai;
    private float gia;
    private String mota;
    public Xe(){
        super();
    }
    private int stt;
    public Xe( String ten,String bienso, String trangthai, float gia, String mota) {
        super();
        this.ten=ten;
        this.bienso = bienso;
        this.trangthai = trangthai;
        this.gia = gia;
        this.mota = mota;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
     public Object[] toO(){
        return new Object[]{
            stt,ten,bienso,trangthai,gia,mota
        };
    }
    
}
