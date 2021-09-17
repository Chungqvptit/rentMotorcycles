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
public class Taisanduocthechap implements Serializable{
    private int id;
    private int sl;
    private String mota;
    private int idhopdong;
    private int idtstc;
    public Taisanduocthechap() {
        super();
    }

    public Taisanduocthechap( int sl, String mota, int idhopdong, int idtstc) {
         super();
        this.sl = sl;
        this.mota = mota;
        this.idhopdong = idhopdong;
        this.idtstc = idtstc;
    }

    public int getIdhopdong() {
        return idhopdong;
    }

    public void setIdhopdong(int idhopdong) {
        this.idhopdong = idhopdong;
    }

    public int getIdtstc() {
        return idtstc;
    }

    public void setIdtstc(int idtstc) {
        this.idtstc = idtstc;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
