package com.example.mongo.util;


import java.io.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.*;


/**
 * @author LingeringNight
 * @description 读取 RTF 文件内容
 */
public class Chulirtftoword {

    public static void main(String[] args) throws Exception {
        String buffer = "";
        File file = new File("E:\\aaa\\资料\\病历\\病历6_2\\病历6\\251.doc");
        int len = (int) file.length();
        System.out.println("len "+len);
        FileInputStream in = new FileInputStream(file);
        byte[] p = new byte[1024];

        in.read(p,0,1024);
        buffer = new String(p);
        System.out.println(buffer);

    }


}

