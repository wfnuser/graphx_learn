/**
  * Created by wfnuser on 16/3/28.
  */

import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import scala.reflect.ClassTag
import org.apache.spark.{SparkContext, SparkConf}

import collection.mutable.HashMap


object graphxlearn {
  def main(args: Array[String]): Unit = {

    //@transient
    val conf = new SparkConf().setMaster("local").setAppName("tutorial")
    //@transient
    val sc = new SparkContext(conf)

  }
}
