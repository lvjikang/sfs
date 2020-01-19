package com.example.mongo.util.yuchuli_01;

import com.example.mongo.entity.Yangli01;
import org.apache.poi.hwpf.extractor.WordExtractor;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.*;


public class Guitxt {

    private List<String> cstrsets = new ArrayList<>();
    private static List<Yangli01> yanlisets = new ArrayList<>();
    private static List<String> original_text = new ArrayList<>();
    private static Set<String> Diagnosis_keys = new HashSet<>();
    private static Set<String> Prescription_names = new HashSet<>();
    private static List<String> Condition_keys = new ArrayList<>();

    private static List<String> cehe01 = new ArrayList<>();
    private static List<String> cehe02 = new ArrayList<>();
    private static List<String> cehe03 = new ArrayList<>();
    private static List<String> cehe04 = new ArrayList<>();
    private static List<String> cepe01 = new ArrayList<>();
    private static List<String> cepe02 = new ArrayList<>();
    private static List<String> cepe03 = new ArrayList<>();
    private static List<String> cepe04 = new ArrayList<>();
    private static List<Map<String, Integer>> phlo = new ArrayList<>();
    private static List<Map<String, Integer>> phlo02 = new ArrayList<>();
    private static List<Map<Integer, Integer>> phlo03 = new ArrayList<>();


    static {
        Diagnosis_keys.add("晶体脱位");
        Diagnosis_keys.add("青光眼");//02
        Diagnosis_keys.add("上睑下垂");
        Diagnosis_keys.add("下睑内翻");
        Diagnosis_keys.add("内斜视");
        Diagnosis_keys.add("屈光不正");//03
        Diagnosis_keys.add("眼眶肿瘤");//04
        Diagnosis_keys.add("玻璃体积血");
        Diagnosis_keys.add("玻璃体混浊");
        Diagnosis_keys.add("视网膜病变");//05
        Diagnosis_keys.add("白内障");//01
        Diagnosis_keys.add("糖尿病");
        Diagnosis_keys.add("高血压");
        Diagnosis_keys.add("高胆固醇血症");
        Diagnosis_keys.add("人工晶体眼");
        Diagnosis_keys.add("视神经炎");//06
        Diagnosis_keys.add("硅油眼");//07
        Diagnosis_keys.add("眼角膜溃疡");//08
        Diagnosis_keys.add("视网膜脱离");//09
        Diagnosis_keys.add("视网膜脱落");
        Diagnosis_keys.add("黄斑前膜");//10
        Diagnosis_keys.add("视神经萎缩");//11
        Diagnosis_keys.add("翼状胬肉");
        Diagnosis_keys.add("黄斑裂孔");//12
        Diagnosis_keys.add("外斜视");
        Diagnosis_keys.add("眼内炎");//13
        Diagnosis_keys.add("黄斑水肿");//14
        Diagnosis_keys.add("静脉阻塞");//15
        Diagnosis_keys.add("球内异物");
        Diagnosis_keys.add("眶内异物");
        Diagnosis_keys.add("复视");//16
        Diagnosis_keys.add("弱视");//17
        Diagnosis_keys.add("睑裂狭小综合征");//18
        Diagnosis_keys.add("眼角膜裂伤");
        Diagnosis_keys.add("眼角膜斑翳");
        Diagnosis_keys.add("角膜碱烧伤");//19
        Diagnosis_keys.add("脉络膜脱离");
        Diagnosis_keys.add("近视");
        Diagnosis_keys.add("泪囊炎");//20
        Diagnosis_keys.add("裂孔");
        Diagnosis_keys.add("黄斑变性");
        Diagnosis_keys.add("上睑肿物");
        Diagnosis_keys.add("眼角膜营养不良");//21
        Diagnosis_keys.add("慢性肾病");
        Diagnosis_keys.add("帕金森");
        Diagnosis_keys.add("眼球震颤");//22
        Diagnosis_keys.add("眼球钝挫伤");//23
        Diagnosis_keys.add("眼球萎缩");//24

        Prescription_names.add("氯化钠");
        Prescription_names.add("典必殊");
        Prescription_names.add("思考林");
        Prescription_names.add("尼目克司");
        Prescription_names.add("美卓乐");
        Prescription_names.add("托百士");
        Prescription_names.add("泰利必妥");
        Prescription_names.add("唯地息");
        Prescription_names.add("迪可罗");
        Prescription_names.add("可乐必妥");
        Prescription_names.add("美多丽");
        Prescription_names.add("百力特");
        Prescription_names.add("普南扑灵");
        Prescription_names.add("泮立苏");
        Prescription_names.add("弥可保");
        Prescription_names.add("补佳泰");
        Prescription_names.add("金纳多");
        Prescription_names.add("芪明颗粒");
        Prescription_names.add("普罗纳克");
        Prescription_names.add("复明胶囊");
        Prescription_names.add("速高捷");
        Prescription_names.add("迪非");
        Prescription_names.add("复方血栓通胶囊");
        Prescription_names.add("氟美童");
        Prescription_names.add("和血明目片");
        Prescription_names.add("露达舒");
        Prescription_names.add("泼尼林片");
        Prescription_names.add("美开朗");
        Prescription_names.add("苏为坦");
        Prescription_names.add("沐利汀");
        Prescription_names.add("玻璃酸钠滴眼液");
        Prescription_names.add("思然滴眼液");
        Prescription_names.add("丽科明");
        Prescription_names.add("雷尼替丁胶囊");
        Prescription_names.add("怡开");
        Prescription_names.add("络活素");
        Prescription_names.add("坎地沙坦酯片");
        Prescription_names.add("小牛去蛋白提取物眼用凝脂");

        Condition_keys.add("视力下降视物不清");//1
        Condition_keys.add("球结膜充血");//2
        Condition_keys.add("角膜透明(浑浊)度");//3
        Condition_keys.add("前房轻浅深度");//4
        Condition_keys.add("虹膜纹理清晰度");
        Condition_keys.add("瞳孔圆与大小度");//6
        Condition_keys.add("视盘颜色");
        Condition_keys.add("色素是否沉积");
        Condition_keys.add("糖尿病");
        Condition_keys.add("光感(对光反应)");//10
        Condition_keys.add("晶体透明度与在位情况");//11
        Condition_keys.add("玻璃体透明度与在位情况");//12
        Condition_keys.add("玻璃体腔气体填充");//13
        Condition_keys.add("玻璃体腔硅油填充");//14
        Condition_keys.add("网膜伏起度");
        Condition_keys.add("眼底红光反射");
        Condition_keys.add("睁眼程度");
        Condition_keys.add("眼外伤");//18
        Condition_keys.add("静脉出血");
        Condition_keys.add("视物重影");
        Condition_keys.add("老年环");
        Condition_keys.add("黄斑区色素紊乱度");
        Condition_keys.add("房角开闭");
        Condition_keys.add("眼斜视");
        Condition_keys.add("睫毛触及下方角膜");
        Condition_keys.add("角膜缺损");
        Condition_keys.add("视物歪头");
        Condition_keys.add("揉眼");
        Condition_keys.add("裂孔");
        Condition_keys.add("玻璃体积血");
        Condition_keys.add("水肿");//31
        Condition_keys.add("黄斑区增殖膜");
        Condition_keys.add("新生血管增殖");
        Condition_keys.add("色素外翻");
        Condition_keys.add("结节");
        Condition_keys.add("眼底窥不清");//36
        Condition_keys.add("激光斑");
        Condition_keys.add("眼红");
        Condition_keys.add("眼痛");//39
        Condition_keys.add("眼痒");
        Condition_keys.add("虹膜粘连");
        Condition_keys.add("流血");
        Condition_keys.add("流泪");//43
        Condition_keys.add("瞳孔阻塞");
        Condition_keys.add("黑影");//45
        Condition_keys.add("异物");
    }

    public static void main(String[] args) throws Exception {
        Chuli01();

        Condition_on_hosipital_extract();
        Condition_on_hosipital_integration();
        Discharge_on_Admission_extract();

        // readrelations();

        extract_message_24();
//        put_together02();
        //Findword01("右眼晶体全白混浊");
//        Discharge_af_Diagnosis_extract();
//        Discharge_instructions_extract();
        //test01();
        //put_together();
        //writefile();
        //writefile02();
//        Testj_scala2 scala2 = new Testj_scala2();
//        double a = scala2.drive(2);
//        System.out.println(a);

    }

    public static void Chuli01() throws Exception {
        File[] files1 = new File("E:\\aaa\\资料\\病历\\yanbinli01").listFiles();
        for (File f : files1) {
            String xu = f.getName();
            if ((!xu.contains("~WRL")) && (!xu.contains("~$"))) {
                int csia = xu.indexOf("$");
                int xyy = xu.indexOf(".");
                String spo = xu.substring(csia + 1, xyy);
                File file = new File("E:\\aaa\\资料\\病历\\yanbinli01\\" + spo + ".doc");
                FileInputStream fis = new FileInputStream(file);
                WordExtractor extractor = new WordExtractor(fis);
                String restr = extractor.getText().replaceAll("\\s*", "");
                original_text.add(restr);

                String restr2 = restr.replace("，", "#").replace(",", "#").replace("、", "#")
                        .replace("。", "#").replace(";", "#").replace("；", "#");

                int a1 = restr2.indexOf("入院诊断:");
                int a2 = restr2.indexOf("出院诊断:");
                int a3 = restr2.indexOf("住院天数");
                int a4 = restr2.indexOf("入院情况:");
                int a5 = restr2.indexOf("住院经过:");
                int a6 = restr2.indexOf("出院医嘱:");
                int a7 = restr2.indexOf("健康教育:");

                String s1 = restr2.substring(a1 + 5, a2);
                String s2 = restr2.substring(a2 + 5, a3);
                String s3 = restr2.substring(a4 + 5, a6);
                String s4 = restr2.substring(a6 + 5, a7);
                String[] as1 = s1.split("#");
                String[] as2 = s2.split("#");
                String[] as3 = s3.split("#");
                String[] as4 = s4.split("#");

//                System.out.println("入院诊断: " + s1);
//                System.out.println("入院情况: " + s3);
//                System.out.println("出院诊断: " + s2);
//                System.out.println("出院医嘱: " + s4);
//                System.out.println("-----------------------------------");
//                System.out.println();

                Yangli01 y = new Yangli01(as1, as3, as2, as4);
                yanlisets.add(y);

            }
        }

        System.out.println("病历总份数: " + original_text.size());
        System.out.println("yanlisets size : " + yanlisets.size());
    }

    public static void Findword01(String str) throws Exception {
        boolean flag = true;
        String re = "";

        Iterator<String> it = original_text.iterator();
        while (it.hasNext() && flag) {
            String s = it.next();
            if (s.indexOf(str) >= 1) {
                int a = s.indexOf(str);
                flag = false;
                re = s.substring(a);
            }
        }
        System.out.println(re);

    }

    public static void Discharge_af_Diagnosis_extract() throws Exception {

        for (Yangli01 y : yanlisets) {
            String a = "#";
            String[] Diagnosis = y.getDischarge_af_Diagnosis();
            for (String sc : Diagnosis) {
                Iterator<String> it = Diagnosis_keys.iterator();
                while (it.hasNext()) {
                    String spo = it.next();
                    if (sc.contains(spo)) {
                        a = a + spo + "#";
                    }
                }
            }
            cehe01.add(a);
        }

    }

    public static void Discharge_on_Admission_extract() throws Exception {

        for (Yangli01 y : yanlisets) {
            String a = "#";
            String[] Admissions = y.getDiagnosis_on_Admission();
            for (String sc : Admissions) {
                Iterator<String> it = Diagnosis_keys.iterator();
                while (it.hasNext()) {
                    String spo = it.next();
                    if (sc.contains(spo)) {
                        a = a + spo + "#";
                    }
                }
            }
            cepe01.add(a);
        }
    }

    //抽取关于白内障的特定特征
    public static void extract_message_01() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_2.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("白内障")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            if (map.containsKey(1)) {
                int p = map.get(1);
                wrt = wrt + " 1:" + p + "";
            } else {
                wrt = wrt + " 1:0";
            }

            if (map.containsKey(2)) {
                int p = map.get(2);
                wrt = wrt + " 2:" + p + "";
            } else {
                wrt = wrt + " 2:0";
            }

            if (map.containsKey(3)) {
                int p = map.get(3);
                wrt = wrt + " 3:" + p + "";
            } else {
                wrt = wrt + " 3:0";
            }

            if (map.containsKey(4)) {
                int p = map.get(4);
                wrt = wrt + " 4:" + p + "";
            } else {
                wrt = wrt + " 4:0";
            }

            if (map.containsKey(6)) {
                int p = map.get(6);
                wrt = wrt + " 6:" + p + "";
            } else {
                wrt = wrt + " 6:0";
            }

            if (map.containsKey(10)) {
                int p = map.get(10);
                wrt = wrt + " 10:" + p + "";
            } else {
                wrt = wrt + " 10:0";
            }

            if (map.containsKey(11)) {
                int p = map.get(11);
                wrt = wrt + " 11:" + p + "";
            } else {
                wrt = wrt + " 11:0";
            }

            if (map.containsKey(12)) {
                int p = map.get(12);
                wrt = wrt + " 12:" + p + "";
            } else {
                wrt = wrt + " 12:0";
            }

            if (map.containsKey(13)) {
                int p = map.get(13);
                wrt = wrt + " 13:" + p + "";
            } else {
                wrt = wrt + " 13:0";
            }

            if (map.containsKey(14)) {
                int p = map.get(14);
                wrt = wrt + " 14:" + p + "";
            } else {
                wrt = wrt + " 14:0";
            }

            if (map.containsKey(18)) {
                int p = map.get(18);
                wrt = wrt + " 18:" + p + "";
            } else {
                wrt = wrt + " 18:0";
            }

            if (map.containsKey(31)) {
                int p = map.get(31);
                wrt = wrt + " 31:" + p + "";
            } else {
                wrt = wrt + " 31:0";
            }

            if (map.containsKey(36)) {
                int p = map.get(36);
                wrt = wrt + " 36:" + p + "";
            } else {
                wrt = wrt + " 36:0";
            }

            if (map.containsKey(39)) {
                int p = map.get(39);
                wrt = wrt + " 39:" + p + "";
            } else {
                wrt = wrt + " 39:0";
            }

            if (map.containsKey(43)) {
                int p = map.get(43);
                wrt = wrt + " 43:" + p + "";
            } else {
                wrt = wrt + " 43:0";
            }

            if (map.containsKey(45)) {
                int p = map.get(45);
                wrt = wrt + " 45:" + p + "";
            } else {
                wrt = wrt + " 45:0";
            }

            System.out.println(wrt);
            bufferedWriter.write(wrt + "\n");

        }
        bufferedWriter.flush();

        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于青光眼的特定特征
    public static void extract_message_02() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_3.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("青光眼")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于屈光不正的特定特征
    public static void extract_message_03() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_4.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("屈光不正")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于眼眶肿瘤的特定特征
    public static void extract_message_04() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_5.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼眶肿瘤")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于视网膜病变的特定特征
    public static void extract_message_05() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_6.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("视网膜病变")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 视神经炎 的特定特征
    public static void extract_message_06() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_7.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("视神经炎")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 硅油眼 的特定特征
    public static void extract_message_07() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_8.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("硅油眼")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼角膜溃疡 的特定特征
    public static void extract_message_08() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_9.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼角膜溃疡")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 视网膜脱离 的特定特征
    public static void extract_message_09() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_10.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("视网膜脱离")||s1.contains("视网膜脱落")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 黄斑前膜 的特定特征
    public static void extract_message_10() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_11.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("黄斑前膜")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 视神经萎缩 的特定特征
    public static void extract_message_11() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_12.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("视神经萎缩")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 黄斑裂孔 的特定特征
    public static void extract_message_12() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_13.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("黄斑裂孔")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼内炎 的特定特征
    public static void extract_message_13() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_14.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼内炎")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 黄斑水肿 的特定特征
    public static void extract_message_14() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_15.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("黄斑水肿")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 静脉阻塞 的特定特征
    public static void extract_message_15() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_16.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("静脉阻塞")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 复视 的特定特征
    public static void extract_message_16() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_17.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("复视")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 弱视 的特定特征
    public static void extract_message_17() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_18.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("弱视")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 睑裂狭小综合征 的特定特征
    public static void extract_message_18() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_19.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("睑裂狭小综合征")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 角膜碱烧伤 的特定特征
    public static void extract_message_19() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_20.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("角膜碱烧伤")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 泪囊炎 的特定特征
    public static void extract_message_20() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_21.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("泪囊炎")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼角膜营养不良 的特定特征
    public static void extract_message_21() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_22.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼角膜营养不良")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼球震颤 的特定特征
    public static void extract_message_22() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_23.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼球震颤")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼球钝挫伤 的特定特征
    public static void extract_message_23() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_24.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼球钝挫伤")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //抽取关于 眼球萎缩 的特定特征
    public static void extract_message_24() throws Exception {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_25.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < cepe01.size(); i++) {
            String wrt = "";
            String s1 = cepe01.get(i);
            if (s1.contains("眼球萎缩")) {
                wrt = wrt + "1";
            } else {
                wrt = wrt + "0";
            }

            //提取对应特征的特征值
            Map<Integer, Integer> map = phlo03.get(i);
            for (int j = 1; j <= 46; j++) {
                if (map.containsKey(j)) {
                    int p = map.get(j);
                    wrt = wrt + " " + j + ":" + p + "";
                } else {
                    wrt = wrt + " " + j + ":0";
                }
            }
            bufferedWriter.write(wrt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    public static void Condition_on_hosipital_extract() throws Exception {
        for (Yangli01 y : yanlisets) {
            String[] conditions = y.getCondition_on_hosipital();
            Map<String, Integer> map = new HashMap<>();
            for (String sc : conditions) {
                //---------------------------------
                if (sc.contains("视物模糊") || sc.contains("视物不清") || sc.contains("视力下降")) {
                    map.put("视力下降视物不清", 1);
                }
                if (sc.contains("视物不见")) {
                    map.put("视力下降视物不清", 2);
                }
                //---------------------------------
                if (sc.contains("球结膜")) {
                    if (sc.contains("充血")) {
                        if (sc.contains("无")) {
                            map.put("球结膜充血", 0);
                        } else if (sc.contains("轻度") || sc.contains("稍") || sc.contains("略") || sc.contains("轻")) {
                            map.put("球结膜充血", 1);
                        } else {
                            map.put("球结膜充血", 2);
                        }
                    }
                }
                //--------------------------------
                if (sc.contains("角膜")) {
                    if (sc.contains("透明")) {
                        map.put("角膜透明(浑浊)度", 0);
                    } else if (sc.contains("混浊") || sc.contains("浑浊") || sc.contains("斑翳")) {
                        map.put("角膜透明(浑浊)度", 2);
                    } else if (sc.contains("轻") || sc.contains("轻混") || sc.contains("轻浑")) {
                        map.put("角膜透明(浑浊)度", 1);
                    } else {
                    }
                }
                //--------------------------------
                if (sc.contains("前房")) {
                    if (sc.contains("轻") || sc.contains("浅") || sc.contains("深度可") || sc.contains("可")) {
                        map.put("前房轻浅深度", 0);
                    } else if (sc.contains("消失")) {
                        map.put("前房轻浅深度", 2);
                    } else if (sc.contains("深")) {
                        map.put("前房轻浅深度", 1);
                    } else {
                        map.put("前房轻浅深度", 0);
                    }
                }
                //-------------------------------
                if (sc.contains("虹膜纹理")) {
                    if (sc.contains("不清") || sc.contains("浑浊") || sc.contains("混浊") || sc.contains("不")) {
                        map.put("虹膜纹理清晰度", 1);
                    } else {
                        map.put("虹膜纹理清晰度", 0);
                    }
                }
                //-----------------------------
                if (sc.contains("瞳孔")) {
                    if (sc.contains("不圆") || sc.contains("不")) {
                        map.put("瞳孔圆与大小度", 1);
                    } else if (sc.contains("大") || sc.contains("散大") || sc.contains("药物性散大")) {
                        map.put("瞳孔圆与大小度", 2);
                    } else {
                        map.put("瞳孔圆与大小度", 0);
                    }
                }
                //----------------------------
                if (sc.contains("视盘")) {
                    if (sc.contains("苍白") || sc.contains("颞侧灰白") || sc.contains("灰白")) {
                        map.put("视盘颜色", 1);
                    } else {
                        map.put("视盘颜色", 0);
                    }
                }
                //----------------------------
                if (sc.contains("色素")) {
                    if (sc.contains("沉积") || sc.contains("积")) {
                        map.put("色素是否沉积", 1);
                    } else {
                        map.put("色素是否沉积", 0);
                    }
                }
                //-------------------------
                if (sc.contains("糖尿病")) {
                    map.put("糖尿病", 1);
                }
                //-----------------------------
                if (sc.contains("对光反应") || sc.contains("光反应") || sc.contains("光感")) {
                    if (sc.contains("迟钝") || sc.contains("钝") || sc.contains("滞")) {
                        map.put("光感(对光反应)", 1);
                    } else if (sc.contains("无") || sc.contains("消失")) {
                        map.put("光感(对光反应)", 2);
                    } else {
                        map.put("光感(对光反应)", 0);
                    }
                }
                //------------------------------
                if (sc.contains("晶体")) {
                    if (sc.contains("透明") || sc.contains("清")) {
                        map.put("晶体透明度与在位情况", 0);
                    } else if (sc.contains("轻混") || sc.contains("轻浑")) {
                        map.put("晶体透明度与在位情况", 1);
                    } else if (sc.contains("浑浊") || sc.contains("混浊")) {
                        map.put("晶体透明度与在位情况", 2);
                    } else if (sc.contains("缺失") || sc.contains("脱位")) {
                        map.put("晶体透明度与在位情况", 3);
                    } else {
                    }
                }
                //---------------------------------
                if (sc.contains("玻璃体")) {
                    if (sc.contains("透明") || sc.contains("清")) {
                        map.put("玻璃体透明度与在位情况", 0);
                    } else if (sc.contains("轻混"
                    ) || sc.contains("轻浑")) {
                        map.put("玻璃体透明度与在位情况", 1);
                    } else if (sc.contains("浑浊") || sc.contains("混浊")) {
                        map.put("玻璃体透明度与在位情况", 2);
                    } else if (sc.contains("缺失") || sc.contains("脱位")) {
                        map.put("玻璃体透明度与在位情况", 3);
                    } else {
                    }
                }
                //------------------------------------
                if (sc.contains("玻璃体腔")) {
                    if (sc.contains("气体填充")) {
                        map.put("玻璃体腔气体填充", 1);
                    }
                }
                //-----------------------------------
                if (sc.contains("玻璃体腔")) {
                    if (sc.contains("硅油填充")) {
                        map.put("玻璃体腔硅油填充", 1);
                    }
                }
                //-----------------------------------
                if (sc.contains("网膜")) {
                    if (sc.contains("平伏")) {
                        map.put("网膜伏起度", 0);
                    } else if (sc.contains("隆起") || sc.contains("凸起") || sc.contains("突")) {
                        map.put("网膜伏起度", 1);
                    }
                }
                //-------------------------------------
                if (sc.contains("红光反射") || sc.contains("眼底红光反射")) {
                    if (sc.contains("迟钝") || sc.contains("钝") || sc.contains("滞")) {
                        map.put("眼底红光反射", 1);
                    } else if (sc.contains("无") || sc.contains("消失")) {
                        map.put("眼底红光反射", 2);
                    } else {
                        map.put("眼底红光反射", 0);
                    }
                }
                //-------------------------------------
                if (sc.contains("眼睁不大")) {
                    map.put("睁眼程度", 1);
                }
                //----------------------------
                if (sc.contains("眼外伤") || sc.contains("外伤")) {
                    map.put("眼外伤", 1);
                }
                //----------------------------
                if (sc.contains("静脉")) {
                    if (sc.contains("出血") || sc.contains("泛红")) {
                        map.put("静脉出血", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("视物重影") || sc.contains("重影")) {
                    map.put("视物重影", 1);
                }
                //--------------------------------
                if (sc.contains("老年环")) {
                    map.put("老年环", 1);
                }
                //--------------------------------
                if (sc.contains("黄斑区色素紊乱") || sc.contains("黄斑区色素乱")) {
                    map.put("黄斑区色素紊乱度", 1);
                }
                //--------------------------------
                if (sc.contains("房角")) {
                    if (sc.contains("开")) {
                        map.put("房角开闭", 1);
                    } else if (sc.contains("闭")) {
                        map.put("房角开闭", 0);
                    } else {
                    }
                }
                //--------------------------------
                if (sc.contains("斜着看") || sc.contains("斜") || sc.contains("外斜")) {
                    map.put("眼斜视", 1);
                }
                //--------------------------------
                if (sc.contains("睫毛触及下方角膜")) {
                    map.put("睫毛触及下方角膜", 1);
                }
                //--------------------------------
                if (sc.contains("角膜")) {
                    if (sc.contains("缺损")) {
                        map.put("角膜缺损", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("视物歪头") || sc.contains("歪头")) {
                    map.put("视物歪头", 1);
                }
                //--------------------------------
                if (sc.contains("揉眼")) {
                    map.put("揉眼", 1);
                }
                //--------------------------------
                if (sc.contains("裂孔")) {
                    map.put("裂孔", 1);
                }
                //--------------------------------
                if (sc.contains("玻璃体")) {
                    if (sc.contains("积血")) {
                        map.put("玻璃体积血", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("水肿")) {
                    map.put("水肿", 1);
                }
                //--------------------------------
                if (sc.contains("黄斑")) {
                    if (sc.contains("增殖膜")) {
                        map.put("黄斑区增殖膜", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("新生血管")) {
                    if (sc.contains("无")) {
                        map.put("新生血管增殖", 0);
                    } else {
                        map.put("新生血管增殖", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("色素外翻")) {
                    map.put("色素外翻", 1);
                }
                //--------------------------------
                if (sc.contains("结节")) {
                    map.put("结节", 1);
                }
                //--------------------------------
                if (sc.contains("眼底")) {
                    if (sc.contains("眼底不入") || sc.contains("窥不清")) {
                        map.put("眼底窥不清", 1);
                    }
                }
                //--------------------------------
                if (sc.contains("可见激光斑") || sc.contains("激光斑")) {
                    map.put("激光斑", 1);
                }
                //--------------------------------
                if (sc.contains("眼红")) {
                    map.put("眼红", 1);
                }
                //--------------------------------
                if (sc.contains("眼痛")) {
                    map.put("眼痛", 1);
                }
                //--------------------------------
                if (sc.contains("眼痒")) {
                    map.put("眼痒", 1);
                }
                //--------------------------------
                if (sc.contains("虹膜粘连")) {
                    map.put("虹膜粘连", 1);
                }
                //--------------------------------
                if (sc.contains("流血")) {
                    map.put("流血", 1);
                }
                //--------------------------------
                if (sc.contains("流泪")) {
                    map.put("流泪", 1);
                }
                //--------------------------------
                if (sc.contains("瞳孔阻塞") || sc.contains("瞳孔阻滞")) {
                    map.put("瞳孔阻塞", 1);
                }
                //--------------------------------
                if (sc.contains("黑影")) {
                    map.put("黑影", 1);
                }
                //--------------------------------
                if (sc.contains("异物")) {
                    map.put("异物", 1);
                }
            }
            phlo.add(map);
        }

        for (int i = 0; i < phlo.size(); i++) {
            Map<String, Integer> map = phlo.get(i);
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> st : set) {
                System.out.println(st.getKey() + " : " + st.getValue());
            }
            System.out.println("-------------------------------------");
            System.out.println();
        }
    }

    public static void Condition_on_hosipital_integration() throws Exception {
        System.out.println("phlo.size: " + phlo.size());
        for (int i = 0; i < phlo.size(); i++) {
            Map<String, Integer> nmapp = new HashMap<>();
            Map<Integer, Integer> omapr = new HashMap<>();
            Map<String, Integer> map = phlo.get(i);
            for (int j = 0; j < Condition_keys.size(); j++) {
                String key = Condition_keys.get(j);
                if (map.containsKey(key)) {
                    nmapp.put(key, map.get(key));
                    omapr.put((j + 1), map.get(key));
                } else {
                    nmapp.put(key, 0);
                    omapr.put((j + 1), 0);
                }
            }
            phlo02.add(nmapp);
            phlo03.add(omapr);
        }

        for (int i = 0; i < phlo02.size(); i++) {
            Map<String, Integer> map = phlo02.get(i);
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> st : set) {
                System.out.println(st.getKey() + " : " + st.getValue());
            }
            System.out.println("-------------------------------------");
            System.out.println();
        }

        System.out.println("*************************************************8");

        for (int i = 0; i < phlo03.size(); i++) {
            Map<Integer, Integer> map = phlo03.get(i);
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for (Map.Entry<Integer, Integer> st : set) {
                System.out.println(st.getKey() + " : " + st.getValue());
            }
            System.out.println("-------------------------------------");
            System.out.println();
        }

    }

    public static void Discharge_instructions_extract() throws Exception {

        for (Yangli01 y : yanlisets) {
            String a = "#";
            String[] Prescriptions = y.getDischarge_instructions();
            for (String sc : Prescriptions) {
                Iterator<String> it = Prescription_names.iterator();
                while (it.hasNext()) {
                    String spo = it.next();
                    if (sc.contains(spo)) {
                        a = a + spo + "#";
                    }
                }
            }
            cehe02.add(a);
        }

    }

    public static void test01() throws Exception {
        System.out.println("cehe01.size: " + cehe01.size());
        System.out.println("cehe02.size: " + cehe02.size());

        for (int i = 0; i < cehe01.size(); i++) {
            if (cehe02.get(i).length() <= 2 && cehe01.get(i).equals("#下睑内翻#")) {
                cehe02.set(i, "#迪可罗#");
            }
//
//            System.out.println(cehe01.get(i));
//            System.out.println(cehe02.get(i));
//            System.out.println(yanlisets.get(i));
//            System.out.println("-------------------------");
        }
    }

    public static void put_together() throws Exception {
        for (int i = 0; i < cehe01.size(); i++) {
            String s = cehe01.get(i) + cehe02.get(i);
            cehe03.add(s);
        }

        for (int i = 0; i < cehe03.size(); i++) {
            //System.out.println(cehe01.get(i)+" "+cehe02.get(i));
            System.out.println(cehe03.get(i));

            String[] s2 = cehe03.get(i).split("#");
            Set<String> sets = new HashSet<>();
            String dp = "";
            for (String s : s2) {
                sets.add(s);
            }
            Iterator<String> it = sets.iterator();
            while (it.hasNext()) {
                String p = it.next();
                if (!p.equals("")) {
                    dp = dp + p + " ";
                }
            }
            dp.trim();
            cehe04.add(dp);

        }
        for (int i = 0; i < cehe03.size(); i++) {
//            System.out.println(cehe03.get(i));
//            System.out.println(cehe04.get(i));
//            System.out.println("-------------------------");
        }

    }

    public static void put_together02() throws Exception {
        System.out.println("cepe01.size : " + cepe01.size());
        System.out.println("phlo.size : " + phlo.size());
        for (int i = 0; i < cepe01.size(); i++) {
            Map<String, Integer> map = phlo.get(i);
            String str = "";
            for (String sc : map.keySet()) {
                if (map.get(sc) >= 1) {
                    str = str + sc + "#";
                }
            }
            str = str + cepe01.get(i);
            cepe02.add(str);
        }

        for (int i = 0; i < cepe02.size(); i++) {
            if (!cepe02.get(i).contains("##")) {
                cepe02.remove(i);
            }
            System.out.println(cepe02.get(i));
            System.out.println("-------------------------");

            String[] s2 = cepe02.get(i).split("#");
            Set<String> sets = new HashSet<>();
            String dp = "";
            for (String str : s2) {
                sets.add(str);
            }
            Iterator<String> it = sets.iterator();
            while (it.hasNext()) {
                String sp = it.next();
                if (!sp.equals("")) {
                    dp = dp + sp + " ";
                }
            }
            dp.trim();
            cepe04.add(dp);

        }

        for (int i = 0; i < cepe04.size(); i++) {
            System.out.println(cepe04.get(i));
            System.out.println("------------------------");
        }

    }

    public static void readrelations() {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\b_1.txt");
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            System.out.println("无此文件");
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(fileInputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String str = null;

                while ((str = bufferedReader.readLine()) != null) {
                    String sp = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                    int a = 0;
                    for (String sr : Diagnosis_keys) {
                        if (sp.contains(sr)) {
                            a++;
                        }
                    }
                    if (a == 1 && sp.contains("白内障")) {
                        System.out.println(sp);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    public static void writefile() {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\a_1.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (int i = 0; i < cehe04.size(); i++) {
                String s = cehe04.get(i).trim() + "\n";
                bufferedWriter.write(s);
            }
            bufferedWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writefile02() {
        File file = new File("E:\\aaa\\web_gl\\bisechuli\\a_2.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (int i = 0; i < cepe04.size(); i++) {
                String s = cepe04.get(i).trim() + "\n";
                bufferedWriter.write(s);
            }
            bufferedWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
