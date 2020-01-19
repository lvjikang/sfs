package com.example.mongo.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Binli02 implements Serializable {
    private static long Binli02Versionserol = 130257894455123l;
    private Integer xuhao;
    private String patname;
    private String zhiye;
    private String xinbie;
    private String lianxidizhi;
    private Date birthday;
    private String lianxiphone;
    private String hunyin;
    private Date ruzutime;
    private String birthplace;
    private Date cuytime;
    private String mingzu;
    private String binshichensuzhe;
    private String zhusu;
    private String ruyuanqinkuang;
    private String ruyuanzhenduan;
    private String ruyuanxiaojie;
    private String suqianxiaojie;
    private String zhenliaojinguo;
    private String chuyuanqingkuang;
    private String chuyuanzhenduan;
    private String chuyuanyizhu;
    private String jiankanjiaoxu;
    private String suifanjihua;
    private List<String> doctorname = new ArrayList<>();
    private List<String> doctorbianhao = new ArrayList<>();
    private List<String> keysets = new ArrayList<>();

    public static long getBinli02Versionserol() {
        return Binli02Versionserol;
    }

    public static void setBinli02Versionserol(long binli02Versionserol) {
        Binli02Versionserol = binli02Versionserol;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }

    public String getRuyuanxiaojie() {
        return ruyuanxiaojie;
    }

    public void setRuyuanxiaojie(String ruyuanxiaojie) {
        this.ruyuanxiaojie = ruyuanxiaojie;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getZhiye() {
        return zhiye;
    }

    public void setZhiye(String zhiye) {
        this.zhiye = zhiye;
    }

    public String getXinbie() {
        return xinbie;
    }

    public void setXinbie(String xinbie) {
        this.xinbie = xinbie;
    }

    public String getLianxidizhi() {
        return lianxidizhi;
    }

    public void setLianxidizhi(String lianxidizhi) {
        this.lianxidizhi = lianxidizhi;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLianxiphone() {
        return lianxiphone;
    }

    public void setLianxiphone(String lianxiphone) {
        this.lianxiphone = lianxiphone;
    }

    public String getHunyin() {
        return hunyin;
    }

    public void setHunyin(String hunyin) {
        this.hunyin = hunyin;
    }

    public Date getRuzutime() {
        return ruzutime;
    }

    public void setRuzutime(Date ruzutime) {
        this.ruzutime = ruzutime;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Date getCuytime() {
        return cuytime;
    }

    public void setCuytime(Date cuytime) {
        this.cuytime = cuytime;
    }

    public String getMingzu() {
        return mingzu;
    }

    public void setMingzu(String mingzu) {
        this.mingzu = mingzu;
    }

    public String getBinshichensuzhe() {
        return binshichensuzhe;
    }

    public void setBinshichensuzhe(String binshichensuzhe) {
        this.binshichensuzhe = binshichensuzhe;
    }

    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        this.zhusu = zhusu;
    }

    public String getRuyuanqinkuang() {
        return ruyuanqinkuang;
    }

    public void setRuyuanqinkuang(String ruyuanqinkuang) {
        this.ruyuanqinkuang = ruyuanqinkuang;
    }

    public String getRuyuanzhenduan() {
        return ruyuanzhenduan;
    }

    public void setRuyuanzhenduan(String ruyuanzhenduan) {
        this.ruyuanzhenduan = ruyuanzhenduan;
    }

    public String getSuqianxiaojie() {
        return suqianxiaojie;
    }

    public void setSuqianxiaojie(String suqianxiaojie) {
        this.suqianxiaojie = suqianxiaojie;
    }

    public String getZhenliaojinguo() {
        return zhenliaojinguo;
    }

    public void setZhenliaojinguo(String zhenliaojinguo) {
        this.zhenliaojinguo = zhenliaojinguo;
    }

    public String getChuyuanqingkuang() {
        return chuyuanqingkuang;
    }

    public void setChuyuanqingkuang(String chuyuanqingkuang) {
        this.chuyuanqingkuang = chuyuanqingkuang;
    }

    public String getChuyuanzhenduan() {
        return chuyuanzhenduan;
    }

    public void setChuyuanzhenduan(String chuyuanzhenduan) {
        this.chuyuanzhenduan = chuyuanzhenduan;
    }

    public String getChuyuanyizhu() {
        return chuyuanyizhu;
    }

    public void setChuyuanyizhu(String chuyuanyizhu) {
        this.chuyuanyizhu = chuyuanyizhu;
    }

    public String getJiankanjiaoxu() {
        return jiankanjiaoxu;
    }

    public void setJiankanjiaoxu(String jiankanjiaoxu) {
        this.jiankanjiaoxu = jiankanjiaoxu;
    }

    public String getSuifanjihua() {
        return suifanjihua;
    }

    public void setSuifanjihua(String suifanjihua) {
        this.suifanjihua = suifanjihua;
    }

    public List<String> getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(List<String> doctorname) {
        this.doctorname = doctorname;
    }

    public List<String> getDoctorbianhao() {
        return doctorbianhao;
    }

    public void setDoctorbianhao(List<String> doctorbianhao) {
        this.doctorbianhao = doctorbianhao;
    }

    public List<String> getKeysets() {
        return keysets;
    }

    public void setKeysets(List<String> keysets) {
        this.keysets = keysets;
    }

    public Binli02() {
    }

    public Binli02(int xuhao, String patname, String zhiye, String xinbie, String lianxidizhi, Date birthday, String lianxiphone, String hunyin, Date ruzutime, String birthplace, Date cuytime, String mingzu, String binshichensuzhe, String zhusu, String ruyuanqinkuang, String ruyuanzhenduan, String suqianxiaojie, String zhenliaojinguo, String chuyuanqingkuang, String chuyuanzhenduan, String chuyuanyizhu, String jiankanjiaoxu, String suifanjihua, List<String> doctorname, List<String> doctorbianhao) {
        this.xuhao = xuhao;
        this.patname = patname;
        this.zhiye = zhiye;
        this.xinbie = xinbie;
        this.lianxidizhi = lianxidizhi;
        this.birthday = birthday;
        this.lianxiphone = lianxiphone;
        this.hunyin = hunyin;
        this.ruzutime = ruzutime;
        this.birthplace = birthplace;
        this.cuytime = cuytime;
        this.mingzu = mingzu;
        this.binshichensuzhe = binshichensuzhe;
        this.zhusu = zhusu;
        this.ruyuanqinkuang = ruyuanqinkuang;
        this.ruyuanzhenduan = ruyuanzhenduan;
        this.suqianxiaojie = suqianxiaojie;
        this.zhenliaojinguo = zhenliaojinguo;
        this.chuyuanqingkuang = chuyuanqingkuang;
        this.chuyuanzhenduan = chuyuanzhenduan;
        this.chuyuanyizhu = chuyuanyizhu;
        this.jiankanjiaoxu = jiankanjiaoxu;
        this.suifanjihua = suifanjihua;
        this.doctorname = doctorname;
        this.doctorbianhao = doctorbianhao;
    }

    @Override
    public String toString() {
        return "Binli02{" +
                "xuhao=" + xuhao +
                ", patname='" + patname + '\'' +
                ", zhiye='" + zhiye + '\'' +
                ", xinbie='" + xinbie + '\'' +
                ", lianxidizhi='" + lianxidizhi + '\'' +
                ", birthday=" + birthday +
                ", lianxiphone='" + lianxiphone + '\'' +
                ", hunyin='" + hunyin + '\'' +
                ", ruzutime=" + ruzutime +
                ", birthplace='" + birthplace + '\'' +
                ", cuytime=" + cuytime +
                ", mingzu='" + mingzu + '\'' +
                ", binshichensuzhe='" + binshichensuzhe + '\'' +
                ", zhusu='" + zhusu + '\'' +
                ", ruyuanqinkuang='" + ruyuanqinkuang + '\'' +
                ", ruyuanzhenduan='" + ruyuanzhenduan + '\'' +
                ", ruyuanxiaojie='" + ruyuanxiaojie + '\'' +
                ", suqianxiaojie='" + suqianxiaojie + '\'' +
                ", zhenliaojinguo='" + zhenliaojinguo + '\'' +
                ", chuyuanqingkuang='" + chuyuanqingkuang + '\'' +
                ", chuyuanzhenduan='" + chuyuanzhenduan + '\'' +
                ", chuyuanyizhu='" + chuyuanyizhu + '\'' +
                ", jiankanjiaoxu='" + jiankanjiaoxu + '\'' +
                ", suifanjihua='" + suifanjihua + '\'' +
                ", doctorname=" + doctorname +
                ", doctorbianhao=" + doctorbianhao +
                ", keysets=" + keysets +
                '}';
    }
}
