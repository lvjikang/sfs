package com.example.mongo.serviceImpl;

import com.example.mongo.dao.Binli02Repository;
import com.example.mongo.dao.RyqkandzdRepository;
import com.example.mongo.entity.Binli02;
import com.example.mongo.entity.Ryqkandzd;
import com.example.mongo.service.Binli02Service;
import com.example.mongo.util.Chuliword04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Binli02ServiceImpl implements Binli02Service {

    @Autowired
    private Binli02Repository binli02Repository;
    @Autowired
    private Chuliword04 chuliword04;
    @Autowired
    private RyqkandzdRepository ryqkandzdRepository;

    @Override
    public void save01() {
        List<Binli02> list = chuliword04.qidongsu03();
        for (Binli02 b : list) {
            binli02Repository.save(b);
        }

        List<Binli02> list2 = chuliword04.qidongsu04();
        for (Binli02 b : list2) {
            binli02Repository.save(b);
        }
    }

    @Override
    public List<String> formatruyuanzhenduan() {
        List<Binli02> allist = binli02Repository.findAll();
        List<String> rtlist = new ArrayList<>();


        for (Binli02 bl : allist) {
            List<String> needaddlist = new ArrayList<>();
            String ryqinkn = bl.getRuyuanqinkuang().trim();
            String ryzhend = bl.getRuyuanzhenduan().trim();

            String a = ryqinkn.replace(",", ".");
            String b = a.replace("，", ".");
            String c = b.replace("。", ".");
            String d = c.replace("“", "");
            String e = d.replace("”", "");
            e = e.replace(":", ".");
            e = e.replace("：", ".");

            String[] frg = e.split("\\.");
            String chuli01 = "";
            for (String p : frg) {
                p = p.trim();
                if (p.indexOf("无") == 0 || p.indexOf("否认") == 0 || p.indexOf("未曾") == 0) {
                } else {
                    chuli01 = chuli01 + p + ".";
                }

            }

            if (chuli01.indexOf("有明显诱因") > 0) {
                needaddlist.add("ryqk012");
            }
            if (chuli01.indexOf("视物模糊") > 0) {
                needaddlist.add("ryqk022");
            }
            if (chuli01.indexOf("渐进性加重") > 0) {
                needaddlist.add("ryqk032");
            }
            if (chuli01.indexOf("糖尿病") > 0) {
                needaddlist.add("ryqk042");
            }
            if (chuli01.indexOf("白内障") > 0) {
                needaddlist.add("ryqk052");
            }
            if (chuli01.indexOf("眼胀") > 0) {
                needaddlist.add("ryqk062");
            }
            if (chuli01.indexOf("人工晶体") > 0) {
                needaddlist.add("ryqk072");
            }
            if (chuli01.indexOf("高血压") > 0) {
                needaddlist.add("ryqk082");
            }
            if (chuli01.indexOf("甲状腺") > 0) {
                needaddlist.add("ryqk092");
            }
            if (chuli01.indexOf("胃纳不佳") > 0) {
                needaddlist.add("ryqk102");
            }
            if (chuli01.indexOf("眠不安") > 0) {
                needaddlist.add("ryqk112");
            }
            if (chuli01.indexOf("阑尾炎") > 0) {
                needaddlist.add("ryqk122");
            }
            if (chuli01.indexOf("重影") > 0) {
                needaddlist.add("ryqk132");
            }
            if (chuli01.indexOf("眼痒") > 0) {
                needaddlist.add("ryqk142");
            }
            if (chuli01.indexOf("大小便有殊") > 0) {
                needaddlist.add("ryqk152");
            }
            int swm = chuli01.indexOf("视网膜");

            if (swm >= 0 &&chuli01.substring(swm).indexOf("充血") < 2 && chuli01.substring(swm).indexOf("充血") >= 0 ) {
                needaddlist.add("ryqk161");
            }
            if (swm >= 0 &&chuli01.substring(swm).indexOf("脱离") < 3 && chuli01.substring(swm).indexOf("脱离") >=0) {
                needaddlist.add("ryqk162");
            }
            if (chuli01.indexOf("心脏病") > 0) {
                needaddlist.add("ryqk172");
            }
            if (chuli01.indexOf("前列腺") > 0) {
                needaddlist.add("ryqk182");
            }
            if (chuli01.indexOf("眼黄斑前膜") > 0) {
                needaddlist.add("ryqk192");
            }
            if (chuli01.indexOf("流泪") > 0) {
                needaddlist.add("ryqk202");
            }
            if (chuli01.indexOf("肝炎") > 0) {
                needaddlist.add("ryqk212");
            }
            if (chuli01.indexOf("肺结核") > 0) {
                needaddlist.add("ryqk222");
            }
            if (chuli01.indexOf("屈光不正") > 0) {
                needaddlist.add("ryqk232");
            }
            if (chuli01.indexOf("畏光") > 0) {
                needaddlist.add("ryqk242");
            }
            if (chuli01.indexOf("眼干") > 0) {
                needaddlist.add("ryqk252");
            }
            if (chuli01.indexOf("眼外眼阴性") > 0) {
                needaddlist.add("ryqk262");
            }
            if (chuli01.indexOf("球结膜充血") > 0) {
                needaddlist.add("ryqk272");
            }
            if (chuli01.indexOf("球膜雾状水肿") > 0) {
                needaddlist.add("ryqk282");
            }
            int qfq = chuli01.indexOf("前房");

            if (qfq >0 &&chuli01.substring(qfq).indexOf("深") < 3 && chuli01.substring(qfq).indexOf("深") >= 0) {
                needaddlist.add("ryqk292");
            }
            if (chuli01.indexOf("房角关") > 0 ||chuli01.indexOf("房角闭") > 0) {
                needaddlist.add("ryqk302");
            }
            if (chuli01.indexOf("虹膜纹理混浊") > 0 || chuli01.indexOf("虹膜纹理欠清") > 0) {
                needaddlist.add("ryqk312");
            }
            if (chuli01.indexOf("瞳孔椭圆") > 0) {
                needaddlist.add("ryqk322");
            }
            if (chuli01.indexOf("对光反应迟钝") > 0 ||chuli01.indexOf("对光反应延迟")>0) {
                needaddlist.add("ryqk332");
            }
            if (chuli01.indexOf("晶体轻混") > 0 ||chuli01.indexOf("晶体混浊")>0) {
                needaddlist.add("ryqk342");
            }
            if (chuli01.indexOf("玻璃体轻混") > 0 ||chuli01.indexOf("玻璃体混浊")>0) {
                needaddlist.add("ryqk352");
            }
            if (chuli01.indexOf("眼底网膜不") > 0) {
                needaddlist.add("ryqk362");
            }
            if (chuli01.indexOf("角膜轻混") > 0 ||chuli01.indexOf("角膜混浊")>0) {
                needaddlist.add("ryqk372");
            }
            if (chuli01.indexOf("眼黄斑变性") > 0) {
                needaddlist.add("ryqk382");
            }
            if (chuli01.indexOf("翼状胬肉") > 0) {
                needaddlist.add("ryqk392");
            }
            if (chuli01.indexOf("眼视神经萎缩") > 0) {
                needaddlist.add("ryqk402");
            }
            if (chuli01.indexOf("睑裂") > 0) {
                needaddlist.add("ryqk412");
            }

            if(ryzhend.indexOf("眼下睑内翻倒睫")>=0){
                needaddlist.add("ryzdn01");
            }
            if(ryzhend.indexOf("屈光不正")>=0){
                needaddlist.add("ryzdn02");
            }
            if(ryzhend.indexOf("麻痹性内斜视")>=0){
                needaddlist.add("ryzdn03");
            }
            if(ryzhend.indexOf("玻璃体积血")>=0){
                needaddlist.add("ryzdn04");
            }
            if(ryzhend.indexOf("视网膜病变")>=0){
                needaddlist.add("ryzdn05");
            }
            if(ryzhend.indexOf("人工晶体眼")>=0){
                needaddlist.add("ryzdn06");
            }
            if(ryzhend.indexOf("糖尿病")>=0){
                needaddlist.add("ryzdn07");
            }
            if(ryzhend.indexOf("高血压")>=0){
                needaddlist.add("ryzdn08");
            }
            if(ryzhend.indexOf("眼黄斑变性")>=0){
                needaddlist.add("ryzdn09");
            }
            if(ryzhend.indexOf("青光眼")>=0){
                needaddlist.add("ryzdn10");
            }

            if(ryzhend.indexOf("瞳孔散大")>=0){
                needaddlist.add("ryzdn11");
            }
            if(ryzhend.indexOf("眼视神经萎缩")>=0){
                needaddlist.add("ryzdn12");
            }
            if(ryzhend.indexOf("先天性睑裂")>=0){
                needaddlist.add("ryzdn13");
            }
            if(ryzhend.indexOf("眼球萎缩")>=0){
                needaddlist.add("ryzdn14");
            }


            if(ryzhend.indexOf("屈光参差")>=0){
                needaddlist.add("ryzdn15");
            }
            if(ryzhend.indexOf("甲状腺相关性眼病")>=0){
                needaddlist.add("ryzdn16");
            }
            if(ryzhend.indexOf("眼眶肿瘤")>=0){
                needaddlist.add("ryzdn17");
            }
            if(ryzhend.indexOf("翼状胬肉")>=0){
                needaddlist.add("ryzdn18");
            }

            if(ryzhend.indexOf("白内障")>=0){
                needaddlist.add("ryzdn19");
            }

            ryqkandzdRepository.save(new Ryqkandzd(needaddlist));

            rtlist.add(chuli01);
        }

        return rtlist;

    }
}
