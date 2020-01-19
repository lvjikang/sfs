package com.example.mongo.util;

import com.example.mongo.entity.PatBinli;
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Chuliword {

    private static List<PatBinli> patBinlis = new ArrayList<>();

    public static List<PatBinli> getPatBinlis() {
        return patBinlis;
    }

    public static void setPatBinlis(List<PatBinli> patBinlis) {
        Chuliword.patBinlis = patBinlis;
    }

    public static void main(String[] args) {
        File file = new File("E:\\aaa\\资料\\病历\\yanbinli01\\294_2.doc");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor extractor = new WordExtractor(fis);
            String restr = extractor.getText();

            int a1 = restr.indexOf("出  院  记  录");
            int a2 = restr.indexOf("入院日期:");
            int a3 = restr.indexOf("出院日期:");
            int a4 = restr.indexOf("入院诊断:");
            int a5 = restr.indexOf("出院诊断:");
            int a6 = restr.indexOf("住院天数:");
            int a7 = restr.indexOf("入院情况:");
            int a8 = restr.indexOf("住院经过:");
            int a9 = restr.indexOf("出院情况:");
            int a10 = restr.indexOf("出院医嘱:");
            int a11= restr.indexOf("健康教育:");
            int a12= restr.indexOf("随访计划:");
            int a13= restr.indexOf("医师签名：");
            int a14 = restr.indexOf("时间：");

            System.out.println("入院日期:"+restr.substring(a2+5,a3));
            System.out.println("出院日期:"+restr.substring(a3+5,a4));
            System.out.println("入院诊断:"+restr.substring(a4+5,a5));
            System.out.println("出院诊断:"+restr.substring(a5+5,a6));
            System.out.println("住院天数:"+restr.substring(a6+5,a7));
            System.out.println("入院情况:"+restr.substring(a7+5,a8));
            System.out.println("住院经过:"+restr.substring(a8+5,a9));
            System.out.println("出院情况:"+restr.substring(a9+5,a10));
            System.out.println("出院医嘱:"+restr.substring(a10+5,a11));
            System.out.println("健康教育:"+restr.substring(a11+5,a12));
            System.out.println("随访计划:"+restr.substring(a12+5,a13));
            System.out.println("医师签名:"+restr.substring(a13+5,a14));
            System.out.println("时间:"+restr.substring(a14+5));



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<PatBinli> doc2String(String docprefix) {

        for (int i = 1; i < 6; i++) {
            String filename = docprefix + "b" + i + ".doc";
            PatBinli p = new PatBinli();
            File file = new File(filename);
            try {
                FileInputStream fis = new FileInputStream(file);
                WordExtractor extractor = new WordExtractor(fis);
                String restr = extractor.getText();
                String[] fen01 = restr.split("#");
                String[] fen02 = fen01[0].split(":");
                String patname = fen02[1];
                String binlinei = fen01[1];
                p.setId(i);
                p.setPatname(patname);
                p.setBinli(binlinei);
                patBinlis.add(p);


                fis.close();
            } catch (Exception e) {
                System.out.println("异常");
            }
        }
        return patBinlis;
    }



}
