package com.example.mongo.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class Zonykbtab implements Serializable {
    private static long Zonktversionp = 326579988494003l;

    private Integer xuhao;
    private long binanhao;
    private String patname;
    private String yiliaozuzhang;
    private String zuzhenduanIcd10;
    private String zuzhenduanname;
    private String cizhenduanIcd10;
    private String cizhenduanname;
    private String zushousuIcd9;
    private String zushousuname;
    private String cishoushuIcd9;
    private String cishoushuname;
    private Date chuyuanname;
    private String chuyuankeshi;

    public static long getZonktversionp() {
        return Zonktversionp;
    }

    public static void setZonktversionp(long zonktversionp) {
        Zonktversionp = zonktversionp;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public long getBinanhao() {
        return binanhao;
    }

    public void setBinanhao(long binanhao) {
        this.binanhao = binanhao;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getYiliaozuzhang() {
        return yiliaozuzhang;
    }

    public void setYiliaozuzhang(String yiliaozuzhang) {
        this.yiliaozuzhang = yiliaozuzhang;
    }

    public String getZuzhenduanIcd10() {
        return zuzhenduanIcd10;
    }

    public void setZuzhenduanIcd10(String zuzhenduanIcd10) {
        this.zuzhenduanIcd10 = zuzhenduanIcd10;
    }

    public String getZuzhenduanname() {
        return zuzhenduanname;
    }

    public void setZuzhenduanname(String zuzhenduanname) {
        this.zuzhenduanname = zuzhenduanname;
    }

    public String getCizhenduanIcd10() {
        return cizhenduanIcd10;
    }

    public void setCizhenduanIcd10(String cizhenduanIcd10) {
        this.cizhenduanIcd10 = cizhenduanIcd10;
    }

    public String getCizhenduanname() {
        return cizhenduanname;
    }

    public void setCizhenduanname(String cizhenduanname) {
        this.cizhenduanname = cizhenduanname;
    }

    public String getZushousuIcd9() {
        return zushousuIcd9;
    }

    public void setZushousuIcd9(String zushousuIcd9) {
        this.zushousuIcd9 = zushousuIcd9;
    }

    public String getZushousuname() {
        return zushousuname;
    }

    public void setZushousuname(String zushousuname) {
        this.zushousuname = zushousuname;
    }

    public String getCishoushuIcd9() {
        return cishoushuIcd9;
    }

    public void setCishoushuIcd9(String cishoushuIcd9) {
        this.cishoushuIcd9 = cishoushuIcd9;
    }

    public String getCishoushuname() {
        return cishoushuname;
    }

    public void setCishoushuname(String cishoushuname) {
        this.cishoushuname = cishoushuname;
    }

    public Date getChuyuanname() {
        return chuyuanname;
    }

    public void setChuyuanname(Date chuyuanname) {
        this.chuyuanname = chuyuanname;
    }

    public String getChuyuankeshi() {
        return chuyuankeshi;
    }

    public void setChuyuankeshi(String chuyuankeshi) {
        this.chuyuankeshi = chuyuankeshi;
    }

    public Zonykbtab() {
    }

    public Zonykbtab(int xuhao, long binanhao, String patname, String yiliaozuzhang, String zuzhenduanIcd10, String zuzhenduanname, String cizhenduanIcd10, String cizhenduanname, String zushousuIcd9, String zushousuname, String cishoushuIcd9, String cishoushuname, Date chuyuanname, String chuyuankeshi) {
        this.xuhao = xuhao;
        this.binanhao = binanhao;
        this.patname = patname;
        this.yiliaozuzhang = yiliaozuzhang;
        this.zuzhenduanIcd10 = zuzhenduanIcd10;
        this.zuzhenduanname = zuzhenduanname;
        this.cizhenduanIcd10 = cizhenduanIcd10;
        this.cizhenduanname = cizhenduanname;
        this.zushousuIcd9 = zushousuIcd9;
        this.zushousuname = zushousuname;
        this.cishoushuIcd9 = cishoushuIcd9;
        this.cishoushuname = cishoushuname;
        this.chuyuanname = chuyuanname;
        this.chuyuankeshi = chuyuankeshi;
    }
}
