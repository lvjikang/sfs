package com.example.mongo.util.yuchuli_01

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.{SVMModel, SVMWithSGD}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils

class spark_svm02 {


  def derive(sad:Int): Double = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("testTansformition")
    val sc = new SparkContext(sparkConf)
    val data = MLUtils.loadLibSVMFile(sc, "file:///E:/aaa/web_gl/bisechuli/test_1.txt")
    val sameModel = SVMModel.load(sc, "file:///E:/aaa/web_gl/bisechuli/model/predict_cataract_Model")
//    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
//    val training = splits(0).cache()
//    val test = splits(1)
//    val numIterations = 100
//    val model = SVMWithSGD.train(training, numIterations)
//    model.clearThreshold()
//    val scoreAndLabels = test.map { point =>
//      val score = model.predict(point.features)
//      (score, point.label)
//    }

        val scoreAndLabels = data.map { point =>
          val score = sameModel.predict(point.features)
          (point.label,score)
        }

//    val metrics = new BinaryClassificationMetrics(scoreAndLabels)
//    val auROC = metrics.areaUnderROC()
//    println(s"Area under ROC = $auROC")
//    model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_qingguangyan_Model")


    return scoreAndLabels.first()._1;

    // /usr/develop/spark/spark-2.1/bin/
    // file:///usr/develop/spark/testfile/pra_te1/model/predict_qingguangyan_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_3.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_3.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_qingguangyan_Model")


    // file:///usr/develop/spark/testfile/pra_te1/model/predict_quguangbuzheng_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_4.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_4.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_quguangbuzheng_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_quguangbuzheng_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yankuangzhongliu_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_5.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_5.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yankuangzhongliu_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yankuangzhongliu_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmobinbian_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_6.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_6.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmobinbian_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmobinbian_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinye_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_7.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_7.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinye_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinye_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_guiyouyan_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_8.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_8.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_guiyouyan_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_guiyouyan_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomokuaiyang_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_9.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_9.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomokuaiyang_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomokuaiyang_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmotuoli_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_10.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_10.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmotuoli_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shiwangmotuoli_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanqianmo_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_11.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_11.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanqianmo_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanqianmo_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinweisuo_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_12.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_12.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinweisuo_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_shishenjinweisuo_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanliekong_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_13.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_13.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanliekong_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanliekong_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanneiye_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_14.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_14.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanneiye_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanneiye_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanshuizhong_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_15.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_15.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanshuizhong_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_huangbanshuizhong_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_jinmaizhuse_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_16.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_16.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_jinmaizhuse_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_jinmaizhuse_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_fushi_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_17.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_17.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_fushi_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_fushi_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_ruoshi_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_18.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_18.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_ruoshi_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_ruoshi_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_lianxianxiaxiaozhonghezhen_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_19.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_19.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_lianxianxiaxiaozhonghezhen_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_lianxianxiaxiaozhonghezhen_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_jiaomojianshaoshan_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_20.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_20.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_jiaomojianshaoshan_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_jiaomojianshaoshan_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_leinanyan_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_21.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_21.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_leinanyan_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_leinanyan_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomoyinyangbuliang_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_22.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_22.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomoyinyangbuliang_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanjiaomoyinyangbuliang_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuzhengchang_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_23.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_23.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuzhengchang_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuzhengchang_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuduncuoshan_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_24.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_24.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuduncuoshan_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuduncuoshan_Model")

    // file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuweisuo_Model
    // file:///usr/develop/spark/testfile/pra_te1/b_25.txt
    // val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_25.txt")
    // val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuweisuo_Model")
    // model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_yanqiuweisuo_Model")

    //  ssh://git@192.168.150.61:2022/lvjikang/my_MongoTr.git


  }

}
