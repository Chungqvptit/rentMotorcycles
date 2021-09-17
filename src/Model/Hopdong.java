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
public class Hopdong implements Serializable{
    private int id;
    private String ngaylap;
    private String mota;
    private int idkhachhang;
    private int idnhanvien;
    public Hopdong() {
        super();
    }

    public Hopdong( String ngaylap, String mota,int idkhachhang,int idnhanvien) {
        super();
        this.ngaylap = ngaylap;
        this.mota = mota;
        this.idkhachhang=idkhachhang;
        this.idnhanvien=idnhanvien;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
