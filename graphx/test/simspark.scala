/**
  * Created by wfnuser on 16/3/14.
  */
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.mutable

object simspark {
  def main(args: Array[String]): Unit = {
    //@transient
    val conf = new SparkConf().setMaster("local").setAppName("simrank")
    //@transient
    val sc = new SparkContext(conf)

//    val graph = sc.textFile("/Users/wfnuser/Documents/STUDY/SJTU_LAB/iiot/spark/datasets/cite2.txt").map { line =>
//      val fields = line.split("\t")
//      (fields(0).toLong,fields(1).toLong)
//    }
//
//    val verts = graph.flatMap(x => Array(x._1,x._2)).distinct()
//    val vertsarr = verts.collect()
//
//    val map = new mutable.HashMap[(Long,Long),Long]()
//    val testmap = new mutable.HashMap[Long,Long]()
//
//    for( i <- 0 to vertsarr.length - 1){
//        for(j <- i+1 to vertsarr.length - 1){
//          map.put((vertsarr(i),vertsarr(j)),0)
//        }
//    }
//
//    var simgraph = sc.parallelize(map.toSeq)
//    val basegraph = simgraph
//    simgraph.foreach(x => println(x._1))
//
//    val neibs = graph.groupByKey()
//    val neibmap = new mutable.HashMap[Long,Array[Long]]()
//    neibs.foreach(
//      x =>  println(x._1)
//        neibmap.put(x._1,x._2.toArray)
//    )
    //neibmap.foreach(println)
    //neibmap
    //print(neibmap(9907233))


//    for( num <- 0 to 10) {
//      simgraph = simgraph.flatMap(x => {
//        val srcset = neibmap(x._1._1)
//        val dstset = neibmap(x._1._2)
//        val newset = srcset.union(dstset).distinct
//        val my_length = (newset.length + srcset.length + dstset.length).toInt
//        val result = new Array[(Long,Long)](5)
//        /*
//        for (i <- 0 to (newset.length - 1)) {
//          for (j <- i + 1 to (newset.length - 1)) {
//            result ++ Array(((newset(i), newset(j)), (x._2,1)))
//          }
//        }
//        for (i <- 0 to (srcset.length - 1)) {
//          for (j <- i + 1 to (srcset.length - 1)) {
//            result ++ Array(((srcset(i), srcset(j)), (1,1)))
//          }
//        }
//        for (i <- 0 to (dstset.length - 1)) {
//          for (j <- i + 1 to (dstset.length - 1)) {
//            result ++ Array(((dstset(i), dstset(j)), (1,1)))
//          }
//        }
//        */
//        result
//      }).take(2).foreach(println)
      //reduceByKey( (x, y) => (x._1 + y._1, x._2 + y._2)).mapValues{ case (sum, count) => (1.0 * sum)/count }

      //simgraph.
//    }
  }

}
