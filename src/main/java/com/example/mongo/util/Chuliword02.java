package com.example.mongo.util;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


/**
 * POI 读取 word 2003 和 word 2007 中文字内容的  //  "E:\\aaa\\pyrepo\\13.doc"
 *
 */

public class Chuliword02 {



    public static void main(String[] args) throws Exception {
        File[] files = new File("E:\\aaa\\资料\\病历\\yanbinli03").listFiles();
        for (File f : files) {
            String fname = f.getAbsolutePath();
            String xu = f.getName();
            int csia = xu.indexOf("$");
            int xyy = xu.indexOf(".");
            String spo = xu.substring(csia+1, xyy);
            System.out.println(spo);
            getonefbyname(fname, spo);
        }
    }

        public static void getonefbyname(String fname,String spo)throws Exception{
        //word 2003： 图片不会被读取
        InputStream is = new FileInputStream(new File("E:\\aaa\\资料\\病历\\yanbinli03\\" + spo + ".doc"));
        WordExtractor ex = new WordExtractor(is);
        String text2003 = ex.getText();
        System.out.print(text2003);

        //word 2007： 图片不会被读取

//        OPCPackage opcPackage = POIXMLDocument.openPackage("E:\\aaa\\pyrepo\\13.doc");
//
//        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//        String text2007 = extractor.getText();
//        System.out.println(text2007);
    }

}