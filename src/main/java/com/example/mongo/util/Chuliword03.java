package com.example.mongo.util;

import com.example.mongo.dao.ZonykbtabRepository;
import com.example.mongo.entity.Binli01;
import com.example.mongo.entity.PatBinli;
import com.example.mongo.entity.Zonykbtab;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Component
public class Chuliword03 {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd，HH:mm");
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd，HH：mm");
    private static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd,HH:mm");
    private static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd,HH：mm");
    private static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy-MM-dd HH：mm");

    private static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy—MM—dd，HH:mm");
    private static SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy—MM—dd，HH：mm");
    private static SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy—MM—dd,HH:mm");
    private static SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy—MM—dd,HH：mm");
    private static SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy—MM—dd HH:mm");
    private static SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy—MM—dd HH：mm");


    private static String bzregex = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])\\s*(0?[1-9]|1\\d|2[0-3])(\\:(0?[1-9]|[1-5]\\d)){2}$";
    private static String regex1 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])，(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex2 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])，(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";
    private static String regex3 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01]),(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex4 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01]),(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";
    private static String regex5 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])\\s(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex6 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])\\s(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";

    private static String regex8 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01])，(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex9 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01])，(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";
    private static String regex10 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01]),(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex11 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01]),(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";
    private static String regex12 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01])\\s(0?[1-9]|1\\d|2[0-3])(:(0?[1-9]|[1-5]\\d))$";
    private static String regex13 = "^[1-9]\\d{3}\\—(0?[1-9]|1[0-2])\\—(0?[1-9]|[12]\\d|3[01])\\s(0?[1-9]|1\\d|2[0-3])(：(0?[1-9]|[1-5]\\d))$";

    @Autowired
    private ZonykbtabRepository zonykbtabRepository;

//    public static void main(String[] args) {
//        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli03").listFiles();
//
//        for (File f : files) {
//            String xu = f.getName();
//            if (!xu.contains("~WRL")) {
//                System.out.println(xu);
//            }
//        }
//    }

    public List<Binli01> qidongsu01() throws Exception {
        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli01").listFiles();
        List<Binli01> list = new ArrayList<>();
        for (File f : files) {
            String xu = f.getName();
            if ((!xu.contains("~WRL")) && (!xu.contains("~$"))) {
                int csia = xu.indexOf("$");
                int xyy = xu.indexOf(".");
                String spo = xu.substring(csia + 1, xyy);
                String cspo = new String(spo);
                System.out.println(cspo);
                if (cspo.contains("_")) {
                    cspo = cspo.substring(0, cspo.indexOf("_"));
                }

                System.out.println(spo);
                Zonykbtab zonykbtab = zonykbtabRepository.getByXuhao(Integer.parseInt(cspo));
                Binli01 binli01 = getonefbyname01(zonykbtab.getPatname(), spo, zonykbtab.getChuyuanname(), Integer.parseInt(cspo));
                list.add(binli01);
            }
        }
        return list;
    }

    public List<Binli01> qidongsu02() throws Exception {
        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli02").listFiles();
        List<Binli01> list = new ArrayList<>();
        for (File f : files) {
            String xu = f.getName();
            if ((!xu.contains("~WRL")) && (!xu.contains("~$"))) {
                int csia = xu.indexOf("$");
                int xyy = xu.indexOf(".");
                String spo = xu.substring(csia + 1, xyy);
                String cspo = new String(spo);
                if (cspo.contains("_")) {
                    cspo = cspo.substring(0, cspo.indexOf("_"));
                }

                System.out.println(spo);
                Zonykbtab zonykbtab = zonykbtabRepository.getByXuhao(Integer.parseInt(cspo));
                Binli01 binli01 = getonefbyname02(zonykbtab.getPatname(), spo, zonykbtab.getChuyuanname(), Integer.parseInt(cspo));
                list.add(binli01);
            }
        }
        return list;
    }


    private static Binli01 getonefbyname01(String name, String sxuhao, Date chuyuantime, int xuhao) throws Exception {

        File file = new File("E:\\aaa\\资料\\病历\\yanbinli01\\" + sxuhao + ".doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText().replaceAll("\\s*", "");

            int a1 = restr.indexOf("出  院  记  录");
            int a2 = restr.indexOf("入院日期");
            int a3 = restr.indexOf("出院日期");
            int a4 = restr.indexOf("入院诊断");
            int a5 = restr.indexOf("出院诊断");
            int a6 = restr.indexOf("住院天数");
            int a7 = restr.indexOf("入院情况");
            int a8 = restr.indexOf("住院经过");
            int a9 = restr.indexOf("出院情况");
            int a10 = restr.indexOf("出院医嘱");
            int a11 = restr.indexOf("健康教育");
            int a12 = restr.indexOf("随访计划");
            int a13 = restr.indexOf("医师签名");
//            int e13 = restr.lastIndexOf("(");
//            int e14 = restr.lastIndexOf(")");
            int a14 = restr.indexOf("时间：");

            System.out.println("入院日期:" + restr.substring(a2 + 5, a3));
            String b1 = restr.substring(a2 + 5, a3).trim();
            Date ruzudate = null;
            ruzudate = jiexidatafromstr(b1);

            System.out.println("出院日期:" + restr.substring(a3 + 5, a4));
            String b2 = restr.substring(a3 + 5, a4).trim();
            Date cuyudate = null;
            cuyudate = chuyuantime;
            System.out.println("入院诊断:" + restr.substring(a4 + 5, a5));
            String b3 = restr.substring(a4 + 5, a5).trim();
            System.out.println("出院诊断:" + restr.substring(a5 + 5, a6));
            String b4 = restr.substring(a5 + 5, a6).trim();
            System.out.println("住院天数:" + restr.substring(a6 + 5, a7 - 1));
            String b5 = restr.substring(a6 + 5, a7 - 1).trim();
            int ruzutiansu = Integer.parseInt(b5);
            System.out.println("入院情况:" + restr.substring(a7 + 5, a8));
            String b6 = restr.substring(a7 + 5, a8).trim();
            System.out.println("住院经过:" + restr.substring(a8 + 5, a9));
            String b7 = restr.substring(a8 + 5, a9).trim();
            System.out.println("出院情况:" + restr.substring(a9 + 5, a10));
            String b8 = restr.substring(a9 + 5, a10).trim();
            System.out.println("出院医嘱:" + restr.substring(a10 + 5, a11));
            String b9 = restr.substring(a10 + 5, a11).trim();
            System.out.println("健康教育:" + restr.substring(a11 + 5, a12));
            String b10 = restr.substring(a11 + 5, a12).trim();
            System.out.println("随访计划:" + restr.substring(a12 + 5, a13));
            String b11 = restr.substring(a12 + 5, a13).trim();
//            System.out.println("医师签名:" + restr.substring(a13 + 5, e13));
            //提取医生签名与编号组
            String tidop = restr.substring(a13 + 5, a14).trim();
            List<String> dnames = new ArrayList<>();
            List<String> dbianhaos = new ArrayList<>();

            if (tidop.contains("/")) {
                //有好几个医生
                String[] lents = tidop.split("/");
                for (int i = 0; i < lents.length; i++) {
                    int qnx, hnx;
                    if (lents[i].contains("(")) {
                        qnx = lents[i].indexOf("(");
                    } else if (lents[i].contains("（")) {
                        qnx = lents[i].indexOf("（");
                    } else {
                        qnx = 0;
                    }
                    if (lents[i].contains(")")) {
                        hnx = lents[i].indexOf(")");
                    } else if (lents[i].contains("）")) {
                        hnx = lents[i].indexOf("）");
                    } else {
                        hnx = 0;
                    }

                    dnames.add(lents[i].substring(0, qnx));
                    dbianhaos.add(lents[i].substring(qnx + 1, hnx));
                }
            } else {
                int qnx, hnx;
                if (tidop.contains("(")) {
                    qnx = tidop.indexOf("(");
                } else if (tidop.contains("（")) {
                    qnx = tidop.indexOf("（");
                } else {
                    qnx = 0;
                }
                if (tidop.contains(")")) {
                    hnx = tidop.indexOf(")");
                } else if (tidop.contains("）")) {
                    hnx = tidop.indexOf("）");
                } else {
                    hnx = 0;
                }
                dnames.add(tidop.substring(0, qnx));
                dbianhaos.add(tidop.substring(qnx + 1, hnx));
            }
            String b13 = restr.substring(a14 + 3).trim();
            Date time = null;
            time = jiexidatafromstr(b13);


            Binli01 binli01 = new Binli01(ruzudate, cuyudate, b3, b4, ruzutiansu, b6, b7, b8, b9, b10, b11, dnames, time);
            binli01.setDoctorbianhao(dbianhaos);
            binli01.setXuhao(xuhao);
            binli01.setPatname(name);
            return binli01;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private static Binli01 getonefbyname02(String name, String sxuhao, Date chuyuantime, int xuhao) throws Exception {

        File file = new File("E:\\aaa\\资料\\病历\\yanbinli02\\" + sxuhao + ".doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText().replaceAll("\\s*", "");

            int a1 = restr.indexOf("出  院  记  录");
            int a2 = restr.indexOf("入院日期");
            int a3 = restr.indexOf("出院日期");
            int a4 = restr.indexOf("入院诊断");
            int a5 = restr.indexOf("出院诊断");
            int a6 = restr.indexOf("住院天数");
            int a7 = restr.indexOf("入院情况");
            int a8 = restr.indexOf("住院经过");
            int a9 = restr.indexOf("出院情况");
            int a10 = restr.indexOf("出院医嘱");
            int a11 = restr.indexOf("健康教育");
            int a12 = restr.indexOf("随访计划");
            int a13 = restr.indexOf("医师签名");
//            int e13 = restr.lastIndexOf("(");
//            int e14 = restr.lastIndexOf(")");
            int a14 = restr.indexOf("时间：");

            System.out.println("入院日期:" + restr.substring(a2 + 5, a3));
            String b1 = restr.substring(a2 + 5, a3).trim();
            Date ruzudate = null;
            ruzudate = jiexidatafromstr(b1);

            System.out.println("出院日期:" + restr.substring(a3 + 5, a4));
            String b2 = restr.substring(a3 + 5, a4).trim();
            Date cuyudate = null;
            cuyudate = chuyuantime;
            System.out.println("入院诊断:" + restr.substring(a4 + 5, a5));
            String b3 = restr.substring(a4 + 5, a5).trim();
            System.out.println("出院诊断:" + restr.substring(a5 + 5, a6));
            String b4 = restr.substring(a5 + 5, a6).trim();
            System.out.println("住院天数:" + restr.substring(a6 + 5, a7 - 1));
            String b5 = restr.substring(a6 + 5, a7 - 1).trim();
            int ruzutiansu = Integer.parseInt(b5);
            System.out.println("入院情况:" + restr.substring(a7 + 5, a8));
            String b6 = restr.substring(a7 + 5, a8).trim();
            System.out.println("住院经过:" + restr.substring(a8 + 5, a9));
            String b7 = restr.substring(a8 + 5, a9).trim();
            System.out.println("出院情况:" + restr.substring(a9 + 5, a10));
            String b8 = restr.substring(a9 + 5, a10).trim();
            System.out.println("出院医嘱:" + restr.substring(a10 + 5, a11));
            String b9 = restr.substring(a10 + 5, a11).trim();
            System.out.println("健康教育:" + restr.substring(a11 + 5, a12));
            String b10 = restr.substring(a11 + 5, a12).trim();
            System.out.println("随访计划:" + restr.substring(a12 + 5, a13));
            String b11 = restr.substring(a12 + 5, a13).trim();
//            System.out.println("医师签名:" + restr.substring(a13 + 5, e13));
            //提取医生签名与编号组
            String tidop = restr.substring(a13 + 5, a14).trim();
            List<String> dnames = new ArrayList<>();
            List<String> dbianhaos = new ArrayList<>();

            if (tidop.contains("/")) {
                //有好几个医生
                String[] lents = tidop.split("/");
                for (int i = 0; i < lents.length; i++) {
                    int qnx, hnx;
                    if (lents[i].contains("(")) {
                        qnx = lents[i].indexOf("(");
                    } else if (lents[i].contains("（")) {
                        qnx = lents[i].indexOf("（");
                    } else {
                        qnx = 0;
                    }
                    if (lents[i].contains(")")) {
                        hnx = lents[i].indexOf(")");
                    } else if (lents[i].contains("）")) {
                        hnx = lents[i].indexOf("）");
                    } else {
                        hnx = 0;
                    }

                    dnames.add(lents[i].substring(0, qnx));
                    dbianhaos.add(lents[i].substring(qnx + 1, hnx));
                }
            } else {
                int qnx, hnx;
                if (tidop.contains("(")) {
                    qnx = tidop.indexOf("(");
                } else if (tidop.contains("（")) {
                    qnx = tidop.indexOf("（");
                } else {
                    qnx = 0;
                }
                if (tidop.contains(")")) {
                    hnx = tidop.indexOf(")");
                } else if (tidop.contains("）")) {
                    hnx = tidop.indexOf("）");
                } else {
                    hnx = 0;
                }
                dnames.add(tidop.substring(0, qnx));
                dbianhaos.add(tidop.substring(qnx + 1, hnx));
            }
            String b13 = restr.substring(a14 + 3).trim();
            Date time = null;
            time = jiexidatafromstr(b13);


            Binli01 binli01 = new Binli01(ruzudate, cuyudate, b3, b4, ruzutiansu, b6, b7, b8, b9, b10, b11, dnames, time);
            binli01.setDoctorbianhao(dbianhaos);
            binli01.setXuhao(xuhao);
            binli01.setPatname(name);
            return binli01;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private static Date jiexidatafromstr(String str) throws Exception {
        Date date;
        if (str.matches(regex1)) {
            date = sdf2.parse(str);
        } else if (str.matches(regex2)) {
            date = sdf3.parse(str);
        } else if (str.matches(regex3)) {
            date = sdf4.parse(str);
        } else if (str.matches(regex4)) {
            date = sdf5.parse(str);
        } else if (str.matches(regex5)) {
            date = sdf6.parse(str);
        } else if (str.matches(regex6)) {
            date = sdf7.parse(str);
        } else if (str.matches(regex8)) {
            date = sdf8.parse(str);
        } else if (str.matches(regex9)) {
            date = sdf9.parse(str);
        } else if (str.matches(regex10)) {
            date = sdf10.parse(str);
        } else if (str.matches(regex11)) {
            date = sdf11.parse(str);
        } else if (str.matches(regex12)) {
            date = sdf12.parse(str);
        } else if (str.matches(regex13)) {
            date = sdf13.parse(str);
        } else {
            date = null;
        }

        return date;
    }

}
