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
public class Khachhang implements Serializable{
    private int id;
    private String ten;
    private int tuoi;
    private String dc;
    private String cmnd;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
    private String sdt;
    private String mota;
    private int stt;
    
    public Khachhang() {
        super();
    }

    public Khachhang( String ten, int tuoi, String dc, String cmnd, String sdt, String mota) {
        super();
        this.ten = ten;
        this.tuoi = tuoi;
        this.dc = dc;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDc() {
        return dc;
    }


    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    public Object[] toO(){
        return new Object[]{
            stt,ten,tuoi,dc,cmnd,sdt,mota
        };
    }
}
