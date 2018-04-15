package com.mobvista.dataplatform

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
//    conf.setMaster("local[2]")
    conf.setAppName("Calculate_Pi_lei.du")
    //    val sc = new SparkContext(conf)
    val spark = new SparkContext("local[2]","Calculate Pi");
    val slices =100;
    val points =100000
    //    val rdd = sc.makeRDD(1 to points)
    val count=spark.parallelize(1 to points, slices).map { k =>
    {
      import scala.math.random
      val x = random
      val y = random
      if (x * x + y * y < 1) 1 else 0
    }
    }.reduce(_ + _)

    println("Pi is roughly:" +count*4.0/points)
    //pi/4  =count/n
    //pi=4*(count/n)
    }

}
