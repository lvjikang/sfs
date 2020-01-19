package com.example.mongo.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Binli01 implements Serializable {
    private static final long Binlixuserversion01 = 265997946161601l;
    private Integer xuhao;
    private String patname;
    private Date ruyuandate;
    private Date chuyuandate;
    private String ruyuanzhenduan;
    private String chuyuanzhenduan;
    private int zuyuantiansu;
    private String ruyuanqinkuang;
    private String zuyuanjinguo;
    private String chuyuanqinkuang;
    private String chuyuanyizu;
    private String jiankanjiaoyu;
    private String sufanjihua;
    private List<String> doctorname = new ArrayList<>();
    private List<String> doctorbianhao = new ArrayList<>();
    private Date time;
    private List<String> keysets = new ArrayList<>();

    public static long getBinlixuserversion01() {
        return Binlixuserversion01;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public Date getRuyuandate() {
        return ruyuandate;
    }

    public void setRuyuandate(Date ruyuandate) {
        this.ruyuandate = ruyuandate;
    }

    public Date getChuyuandate() {
        return chuyuandate;
    }

    public void setChuyuandate(Date chuyuandate) {
        this.chuyuandate = chuyuandate;
    }

    public String getRuyuanzhenduan() {
        return ruyuanzhenduan;
    }

    public void setRuyuanzhenduan(String ruyuanzhenduan) {
        this.ruyuanzhenduan = ruyuanzhenduan;
    }

    public String getChuyuanzhenduan() {
        return chuyuanzhenduan;
    }

    public void setChuyuanzhenduan(String chuyuanzhenduan) {
        this.chuyuanzhenduan = chuyuanzhenduan;
    }

    public int getZuyuantiansu() {
        return zuyuantiansu;
    }

    public void setZuyuantiansu(int zuyuantiansu) {
        this.zuyuantiansu = zuyuantiansu;
    }

    public String getRuyuanqinkuang() {
        return ruyuanqinkuang;
    }

    public void setRuyuanqinkuang(String ruyuanqinkuang) {
        this.ruyuanqinkuang = ruyuanqinkuang;
    }

    public String getZuyuanjinguo() {
        return zuyuanjinguo;
    }

    public void setZuyuanjinguo(String zuyuanjinguo) {
        this.zuyuanjinguo = zuyuanjinguo;
    }

    public String getChuyuanqinkuang() {
        return chuyuanqinkuang;
    }

    public void setChuyuanqinkuang(String chuyuanqinkuang) {
        this.chuyuanqinkuang = chuyuanqinkuang;
    }

    public String getChuyuanyizu() {
        return chuyuanyizu;
    }

    public void setChuyuanyizu(String chuyuanyizu) {
        this.chuyuanyizu = chuyuanyizu;
    }

    public String getJiankanjiaoyu() {
        return jiankanjiaoyu;
    }

    public void setJiankanjiaoyu(String jiankanjiaoyu) {
        this.jiankanjiaoyu = jiankanjiaoyu;
    }

    public String getSufanjihua() {
        return sufanjihua;
    }

    public void setSufanjihua(String sufanjihua) {
        this.sufanjihua = sufanjihua;
    }

    public List<String> getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(List<String> doctorname) {
        this.doctorname = doctorname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public List<String> getKeysets() {
        return keysets;
    }

    public void setKeysets(List<String> keysets) {
        this.keysets = keysets;
    }

    public List<String> getDoctorbianhao() {
        return doctorbianhao;
    }

    public void setDoctorbianhao(List<String> doctorbianhao) {
        this.doctorbianhao = doctorbianhao;
    }

    public Binli01() {
    }

    public Binli01(Date ruyuandate, Date chuyuandate, String ruyuanzhenduan, String chuyuanzhenduan, int zuyuantiansu, String ruyuanqinkuang, String zuyuanjinguo, String chuyuanqinkuang, String chuyuanyizu, String jiankanjiaoyu, String sufanjihua, List<String> doctorname, Date time) {
        this.ruyuandate = ruyuandate;
        this.chuyuandate = chuyuandate;
        this.ruyuanzhenduan = ruyuanzhenduan;
        this.chuyuanzhenduan = chuyuanzhenduan;
        this.zuyuantiansu = zuyuantiansu;
        this.ruyuanqinkuang = ruyuanqinkuang;
        this.zuyuanjinguo = zuyuanjinguo;
        this.chuyuanqinkuang = chuyuanqinkuang;
        this.chuyuanyizu = chuyuanyizu;
        this.jiankanjiaoyu = jiankanjiaoyu;
        this.sufanjihua = sufanjihua;
        this.doctorname = doctorname;
        this.time = time;
    }

    public Binli01(int xuhao, String patname, Date ruyuandate, Date chuyuandate, String ruyuanzhenduan, String chuyuanzhenduan, int zuyuantiansu, String ruyuanqinkuang, String zuyuanjinguo, String chuyuanqinkuang, String chuyuanyizu, String jiankanjiaoyu, String sufanjihua, List<String> doctorname, Date time, List<String> keysets) {
        this.xuhao = xuhao;
        this.patname = patname;
        this.ruyuandate = ruyuandate;
        this.chuyuandate = chuyuandate;
        this.ruyuanzhenduan = ruyuanzhenduan;
        this.chuyuanzhenduan = chuyuanzhenduan;
        this.zuyuantiansu = zuyuantiansu;
        this.ruyuanqinkuang = ruyuanqinkuang;
        this.zuyuanjinguo = zuyuanjinguo;
        this.chuyuanqinkuang = chuyuanqinkuang;
        this.chuyuanyizu = chuyuanyizu;
        this.jiankanjiaoyu = jiankanjiaoyu;
        this.sufanjihua = sufanjihua;
        this.doctorname = doctorname;
        this.time = time;
        this.keysets = keysets;
    }
}







