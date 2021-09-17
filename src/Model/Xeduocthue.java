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
public class Xeduocthue implements Serializable{
    private int id;
    private String ngaythue;
    private String ngaytra;
    private float gia;
    private String mota;
    public int stt;
    private int idxe;
    private int idhopdong;
    
    public Xeduocthue() {
        super();
    }

    public Xeduocthue( String ngaythue, String ngaytra, float gia, String mota,int idxe,int idhopdong) {
        
        super();
        this.idhopdong=idhopdong;
        this.idxe=idxe;
        this.ngaythue = ngaythue;
        this.ngaytra = ngaytra;
        this.gia = gia;
        this.mota = mota;
    }

    public int getIdxe() {
        return idxe;
    }

    public void setIdxe(int idxe) {
        this.idxe = idxe;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
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
            stt,mota,gia,ngaythue,ngaytra
        };
    }
}
