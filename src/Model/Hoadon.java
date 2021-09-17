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
public class Hoadon implements Serializable{
    private int id;
    private String Ngaytt;
    private float sotien;
    private String Kieu;
    private String mota;
    private int idhopdong;
    public Hoadon() {
        super();
    }

    public Hoadon( String Ngaytt, float sotien, String Kieu, String mota,int idhopdong) {
        super();
        this.idhopdong=idhopdong;
        this.Ngaytt = Ngaytt;
        this.sotien = sotien;
        this.Kieu = Kieu;
        this.mota = mota;
    }

    public int getIdhopdong() {
        return idhopdong;
    }

    public void setIdhopdong(int idhopdong) {
        this.idhopdong = idhopdong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaytt() {
        return Ngaytt;
    }

    public void setNgaytt(String Ngaytt) {
        this.Ngaytt = Ngaytt;
    }

    public float getSotien() {
        return sotien;
    }

    public void setSotien(float sotien) {
        this.sotien = sotien;
    }

    public String getKieu() {
        return Kieu;
    }

    public void setKieu(String Kieu) {
        this.Kieu = Kieu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
