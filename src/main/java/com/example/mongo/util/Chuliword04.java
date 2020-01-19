package com.example.mongo.util;

import com.example.mongo.dao.ZonykbtabRepository;
import com.example.mongo.entity.Binli01;
import com.example.mongo.entity.Binli02;
import com.example.mongo.entity.PatBinli;
import com.example.mongo.entity.Zonykbtab;
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//import org.python.core.PyFunction;
//import org.python.core.PyInteger;
//import org.python.core.PyObject;
//import org.python.util.PythonInterpreter;

@Component
public class Chuliword04 {

    @Autowired
    private ZonykbtabRepository zonykbtabRepository;

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
    private static SimpleDateFormat sdf14 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    private static String bzregex = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])\\s*(0?[1-9]|1\\d|2[0-3])(\\:(0?[1-9]|[1-5]\\d)){2}$";
    private static String regex0 = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12]\\d|3[01])$";
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
    private static String regex14 = "^[1-9]\\d{3}\\/(0?[1-9]|1[0-2])\\/(0?[1-9]|[12]\\d|3[01])\\s*(0?[1-9]|1\\d|2[0-3])(\\:(0?[1-9]|[1-5]\\d)){2}$";


    public static void main(String[] args) throws Exception {

        File file = new File("E:\\aaa\\资料\\病历\\yanbinli04\\" + 958 + ".doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText();
            System.out.println(restr);

            int a1 = restr.indexOf("姓  名");
            int a2 = restr.indexOf("职  业");
            int a3 = restr.indexOf("Name");
            int a4 = restr.indexOf("性  别");
            int a5 = restr.indexOf("联系地址");
            int e5 = restr.indexOf("Gender");

            int a6 = restr.indexOf("出生日期");
            int a7 = restr.indexOf("联系电话");
            int a8 = restr.indexOf("Birthday");
            int a9 = restr.indexOf("婚  姻");

            int a10 = restr.indexOf("入院时间");
            int a11 = restr.indexOf("Marital");
            int a12 = restr.indexOf("出 生 地");
            int a13 = restr.indexOf("出院时间");
            int a14 = restr.indexOf("Birth Place");
            int a15 = restr.indexOf("民  族");
            int e15 = restr.indexOf("病史陈述者");
            int a16 = restr.indexOf("Race");
            int a17 = restr.indexOf("主    诉");
            int a18 = restr.indexOf("Chief");

            int a19 = restr.indexOf("入院情况");
            int e19 = restr.indexOf("入院小结");

            int a20 = restr.indexOf("入院诊断");
//            int a21 = restr.indexOf("术前小结");
            int a22 = restr.indexOf("诊疗经过");
            int a23 = restr.indexOf("出院情况");

            int a24 = restr.indexOf("出院诊断");
            int a25 = restr.indexOf("出院医嘱");
//            int a26 = restr.indexOf("健康宣教");
//            int a27 = restr.indexOf("随访计划");
            int a28 = restr.indexOf("医师签名");
//            int a29 = restr.lastIndexOf("(");
//            int a30 = restr.lastIndexOf(")");

            String er1 = restr.substring(e19 + 5, a20).trim();
            String b1 = restr.substring(a1 + 5, a2).trim();
            String b2 = restr.substring(a2 + 5, a3).trim();
            String b3 = restr.substring(a4 + 5, a5).trim();
            String b4 = restr.substring(a5 + 5, e5).trim();
            String b5 = restr.substring(a6 + 5, a7).trim();
            String b6 = restr.substring(a7 + 5, a8).trim();
            String b7 = restr.substring(a9 + 5, a10).trim();
            String b8 = restr.substring(a10 + 5, a11).trim();
            String b9 = restr.substring(a12 + 6, a13).trim();
            String b10 = restr.substring(a13 + 5, a14).trim();
            String b11 = restr.substring(a15 + 5, e15).trim();
            String bb11 = restr.substring(e15 + 6, a16).trim();
            String b12 = restr.substring(a17 + 7, a18).trim();
            String bq = restr.substring(a18 + 5, a19).trim();
            String b13 = restr.substring(a19 + 5, a20).trim();
            String b14 = "";
            String b15 = restr.substring(a20 + 5, a22).trim();
            String b16 = restr.substring(a22 + 5, a23).trim();
            String b17 = restr.substring(a23 + 5, a24).trim();
            String b18 = restr.substring(a24 + 5, a25).trim();
//            String b19 = restr.substring(a25 + 5, a26).trim();
//            String b20 = restr.substring(a26 + 5, a27).trim();
            String b19 = "";
            String b20 = "";
            String b21 = restr.substring(a25 + 5, a28).trim();
//            String b22 = restr.substring(a28 + 5, a29).trim();
//            String b23 = restr.substring(a29 + 1, a30).trim();

            String tidop = restr.substring(a28 + 5).trim();
            List<String> dnames = new ArrayList<>();
            List<String> dbianhaos = new ArrayList<>();

            if (tidop.indexOf("/") > 0) {
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

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            System.out.println(b6);
            System.out.println(b7);
            System.out.println(b8);
            System.out.println(b9);
            System.out.println(b10);
            System.out.println(b11);
            System.out.println(bb11);
            System.out.println(b12);
            System.out.println(b13);
            System.out.println(b14);
            System.out.println(b15);
            System.out.println(b16);
            System.out.println(b17);
            System.out.println(b18);
            System.out.println(b19);
            System.out.println(b20);
            System.out.println(b21);
//            System.out.println(b22);
//            System.out.println(b23);

            Date birthday = sdf1.parse(b5);
            Date ruzutime = jiexidatafromstr(b8);
            Date cuytime = null;

            System.out.println(birthday);
            System.out.println(ruzutime);

            Binli02 binli02 = new Binli02(958, "", b2, b3, b4, birthday, b6, b7, ruzutime, b9, cuytime, b11, bb11, b12, b13, b14, b15, b16, b17, b18, b21, b19, b20, dnames, dbianhaos);

            binli02.setRuyuanxiaojie(er1);
            System.out.println(birthday);
            System.out.println(ruzutime);
            System.out.println(cuytime);
            System.out.println("--" + binli02);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void main(String[] args){
//        PythonInterpreter interpreter = new PythonInterpreter();
////        interpreter.exec("a=[5,2,3,9,4,0]; ");
////        interpreter.exec("print(sorted(a));");  //此处python语句是3.x版本的语法
////        interpreter.exec("print sorted(a);");   //此处是python语句是2.x版本的语法
//       //interpreter.execfile("E:\\Python_Workspace\\DataAnalysisCode02\\nivdnis.py");
//
//        try {
//            Process pr = Runtime.getRuntime().exec("python "+"E:\\Python_Workspace\\DataAnalysisCode02\\fp_tree_guanlifa.py");
//            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//
//                System.out.println(new String(line.getBytes("gbk"),"utf-8"));
//            }
//            in.close();
//            pr.waitFor();
//            System.out.println("end");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public List<Binli02> qidongsu03() {
        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli03").listFiles();
        List<Binli02> list = new ArrayList<>();
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
                Binli02 binli02 = getonefbyname03(zonykbtab.getPatname(), spo, zonykbtab.getChuyuanname(), Integer.parseInt(cspo));
                list.add(binli02);
            }
        }
        return list;
    }

    private static Binli02 getonefbyname03(String name, String sxuhao, Date chuyuantime, int xuhao) {
        File file = new File("E:\\aaa\\资料\\病历\\yanbinli03\\" + sxuhao + ".doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText();
            System.out.println(restr);

            int a1 = restr.indexOf("姓  名");
            int a2 = restr.indexOf("职  业");
            int a3 = restr.indexOf("Name");
            int a4 = restr.indexOf("性  别");
            int a5 = restr.indexOf("联系地址");
            int e5 = restr.indexOf("Gender");

            int a6 = restr.indexOf("出生日期");
            int a7 = restr.indexOf("联系电话");
            int a8 = restr.indexOf("Birthday");
            int a9 = restr.indexOf("婚  姻");

            int a10 = restr.indexOf("入院时间");
            int a11 = restr.indexOf("Marital");
            int a12 = restr.indexOf("出 生 地");
            int a13 = restr.indexOf("出院时间");
            int a14 = restr.indexOf("Birth Place");
            int a15 = restr.indexOf("民  族");
            int e15 = restr.indexOf("病史陈述者");
            int a16 = restr.indexOf("Race");
            int a17 = restr.indexOf("主    诉");
            int a18 = restr.indexOf("Chief");

            int a19 = restr.indexOf("入院情况");
            int a20 = restr.indexOf("入院诊断");
            int a21 = restr.indexOf("术前小结");
            int a22 = restr.indexOf("诊疗经过");
            int a23 = restr.indexOf("出院情况");

            int a24 = restr.indexOf("出院诊断");
            int a25 = restr.indexOf("出院医嘱");
            int a26 = restr.indexOf("健康宣教");
            int a27 = restr.indexOf("随访计划");
            int a28 = restr.indexOf("医师签名");
//            int a29 = restr.lastIndexOf("(");
//            int a30 = restr.lastIndexOf(")");

            String b1 = restr.substring(a1 + 5, a2).trim();
            String b2 = restr.substring(a2 + 5, a3).trim();
            String b3 = restr.substring(a4 + 5, a5).trim();
            String b4 = restr.substring(a5 + 5, e5).trim();
            String b5 = restr.substring(a6 + 5, a7).trim();
            String b6 = restr.substring(a7 + 5, a8).trim();
            String b7 = restr.substring(a9 + 5, a10).trim();
            String b8 = restr.substring(a10 + 5, a11).trim();
            String b9 = restr.substring(a12 + 6, a13).trim();
            String b10 = restr.substring(a13 + 5, a14).trim();
            String b11 = restr.substring(a15 + 5, e15).trim();
            String bb11 = restr.substring(e15 + 6, a16).trim();
            String b12 = restr.substring(a17 + 7, a18).trim();
            String bq = restr.substring(a18 + 5, a19).trim();
            String b13 = restr.substring(a19 + 5, a20).trim();
            String b14 = restr.substring(a20 + 5, a21).trim();
            String b15 = restr.substring(a21 + 5, a22).trim();
            String b16 = restr.substring(a22 + 5, a23).trim();
            String b17 = restr.substring(a23 + 5, a24).trim();
            String b18 = restr.substring(a24 + 5, a25).trim();
            String b19 = restr.substring(a25 + 5, a26).trim();
            String b20 = restr.substring(a26 + 5, a27).trim();
            String b21 = restr.substring(a27 + 5, a28).trim();
//            String b22 = restr.substring(a28 + 5, a29).trim();
//            String b23 = restr.substring(a29 + 1, a30).trim();

            String tidop = restr.substring(a28 + 5).trim();
            List<String> dnames = new ArrayList<>();
            List<String> dbianhaos = new ArrayList<>();

            if (tidop.indexOf("/") > 0) {
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

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            System.out.println(b6);
            System.out.println(b7);
            System.out.println(b8);
            System.out.println(b9);
            System.out.println(b10);
            System.out.println(b11);
            System.out.println(bb11);
            System.out.println(b12);
            System.out.println(b13);
            System.out.println(b14);
            System.out.println(b15);
            System.out.println(b16);
            System.out.println(b17);
            System.out.println(b18);
            System.out.println(b19);
            System.out.println(b20);
            System.out.println(b21);
//            System.out.println(b22);
//            System.out.println(b23);

            Date birthday = sdf1.parse(b5);
            Date ruzutime = jiexidatafromstr(b8);
            Date cuytime = chuyuantime;

            Binli02 binli02 = new Binli02(xuhao, name, b2, b3, b4, birthday, b6, b7, ruzutime, b9, cuytime, b11, bb11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, dnames, dbianhaos);

            System.out.println(birthday);
            System.out.println(ruzutime);
            System.out.println(cuytime);
            return binli02;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Binli02> qidongsu04() {
        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli04").listFiles();
        List<Binli02> list = new ArrayList<>();
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
                Binli02 binli02 = getonefbyname04(zonykbtab.getPatname(), spo, zonykbtab.getChuyuanname(), Integer.parseInt(cspo));
                list.add(binli02);
            }
        }
        return list;
    }

    private static Binli02 getonefbyname04(String name, String sxuhao, Date chuyuantime, int xuhao) {
        File file = new File("E:\\aaa\\资料\\病历\\yanbinli04\\" + sxuhao + ".doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText();
            System.out.println(restr);

            int a1 = restr.indexOf("姓  名");
            int a2 = restr.indexOf("职  业");
            int a3 = restr.indexOf("Name");
            int a4 = restr.indexOf("性  别");
            int a5 = restr.indexOf("联系地址");
            int e5 = restr.indexOf("Gender");

            int a6 = restr.indexOf("出生日期");
            int a7 = restr.indexOf("联系电话");
            int a8 = restr.indexOf("Birthday");
            int a9 = restr.indexOf("婚  姻");

            int a10 = restr.indexOf("入院时间");
            int a11 = restr.indexOf("Marital");
            int a12 = restr.indexOf("出 生 地");
            int a13 = restr.indexOf("出院时间");
            int a14 = restr.indexOf("Birth Place");
            int a15 = restr.indexOf("民  族");
            int e15 = restr.indexOf("病史陈述者");
            int a16 = restr.indexOf("Race");
            int a17 = restr.indexOf("主    诉");
            int a18 = restr.indexOf("Chief");

            int a19 = restr.indexOf("入院情况");
            int e19 = restr.indexOf("入院小结");

            int a20 = restr.indexOf("入院诊断");
//            int a21 = restr.indexOf("术前小结");
            int a22 = restr.indexOf("诊疗经过");
            int a23 = restr.indexOf("出院情况");

            int a24 = restr.indexOf("出院诊断");
            int a25 = restr.indexOf("出院医嘱");
//            int a26 = restr.indexOf("健康宣教");
//            int a27 = restr.indexOf("随访计划");
            int a28 = restr.indexOf("医师签名");
//            int a29 = restr.lastIndexOf("(");
//            int a30 = restr.lastIndexOf(")");

            String er1 = restr.substring(e19 + 5, a20).trim();
            String b1 = restr.substring(a1 + 5, a2).trim();
            String b2 = restr.substring(a2 + 5, a3).trim();
            String b3 = restr.substring(a4 + 5, a5).trim();
            String b4 = restr.substring(a5 + 5, e5).trim();
            String b5 = restr.substring(a6 + 5, a7).trim();
            String b6 = restr.substring(a7 + 5, a8).trim();
            String b7 = restr.substring(a9 + 5, a10).trim();
            String b8 = restr.substring(a10 + 5, a11).trim();
            String b9 = restr.substring(a12 + 6, a13).trim();
            String b10 = restr.substring(a13 + 5, a14).trim();
            String b11 = restr.substring(a15 + 5, e15).trim();
            String bb11 = restr.substring(e15 + 6, a16).trim();
            String b12 = restr.substring(a17 + 7, a18).trim();
            String bq = restr.substring(a18 + 5, a19).trim();
            String b13 = restr.substring(a19 + 5, a20).trim();
            String b14 = "";
            String b15 = restr.substring(a20 + 5, a22).trim();
            String b16 = restr.substring(a22 + 5, a23).trim();
            String b17 = restr.substring(a23 + 5, a24).trim();
            String b18 = restr.substring(a24 + 5, a25).trim();
//            String b19 = restr.substring(a25 + 5, a26).trim();
//            String b20 = restr.substring(a26 + 5, a27).trim();
            String b19 = "";
            String b20 = "";
            String b21 = restr.substring(a25 + 5, a28).trim();
//            String b22 = restr.substring(a28 + 5, a29).trim();
//            String b23 = restr.substring(a29 + 1, a30).trim();

            String tidop = restr.substring(a28 + 5).trim();
            List<String> dnames = new ArrayList<>();
            List<String> dbianhaos = new ArrayList<>();

            if (tidop.indexOf("/") > 0) {
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

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            System.out.println(b6);
            System.out.println(b7);
            System.out.println(b8);
            System.out.println(b9);
            System.out.println(b10);
            System.out.println(b11);
            System.out.println(bb11);
            System.out.println(b12);
            System.out.println(b13);
            System.out.println(b14);
            System.out.println(b15);
            System.out.println(b16);
            System.out.println(b17);
            System.out.println(b18);
            System.out.println(b19);
            System.out.println(b20);
            System.out.println(b21);
//            System.out.println(b22);
//            System.out.println(b23);

            Date birthday = sdf1.parse(b5);
            Date ruzutime = jiexidatafromstr(b8);
            Date cuytime = chuyuantime;

            System.out.println(birthday);
            System.out.println(ruzutime);

            Binli02 binli02 = new Binli02(xuhao, name, b2, b3, b4, birthday, b6, b7, ruzutime, b9, cuytime, b11, bb11, b12, b13, b14, b15, b16, b17, b18, b21, b19, b20, dnames, dbianhaos);

            binli02.setRuyuanxiaojie(er1);
            System.out.println(birthday);
            System.out.println(ruzutime);
            System.out.println(cuytime);
            return binli02;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private static Date jiexidatafromstr(String str) throws Exception {
        Date date;
        if (str.matches(regex1)) {
            date = sdf2.parse(str);
        } else if (str.matches(regex0)) {
            date = sdf1.parse(str);
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
        } else if (str.matches(regex14)) {
            date = sdf14.parse(str);
        } else {
            date = null;
        }

        return date;
    }


}
