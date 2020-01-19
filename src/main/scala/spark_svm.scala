import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.{SVMModel, SVMWithSGD}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils

class spark_svm {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("testTansformition")
    val sc = new SparkContext(sparkConf)
    val data = MLUtils.loadLibSVMFile(sc, "file:///usr/develop/spark/testfile/pra_te1/b_3.txt")
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
    val training = splits(0).cache()
    val test = splits(1)
    val numIterations = 100
    val model = SVMWithSGD.train(training, numIterations)
    model.clearThreshold()
    val scoreAndLabels = test.map { point =>
      val score = model.predict(point.features)
      (score, point.label)
    }

    //    val scoreAndLabels = data.map { point =>
    //      val score = sameModel.predict(point.features)
    //      (score, point.features)
    //    }

    val metrics = new BinaryClassificationMetrics(scoreAndLabels)
    val auROC = metrics.areaUnderROC()
    println(s"Area under ROC = $auROC")
    model.save(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_glaucoma_Model")
    val sameModel = SVMModel.load(sc, "file:///usr/develop/spark/testfile/pra_te1/model/predict_glaucoma_Model")


  }

}
