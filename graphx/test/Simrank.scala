import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import scala.reflect.ClassTag
import org.apache.spark.{SparkContext, SparkConf}

import collection.mutable.HashMap

/**
  * Created by wfnuser on 16/3/2.
  */
object Simrank {
  def main(args: Array[String]): Unit = {
    //@transient
    val conf = new SparkConf().setMaster("local").setAppName("simrank")
    //@transient
    val sc = new SparkContext(conf)

    val vertexArray = Array(
      (1L, ("Alice", 28)),
      (2L, ("Bob", 27)),
      (3L, ("Charlie", 65)),
      (4L, ("David", 42)),
      (5L, ("Ed", 55)),
      (6L, ("Fran", 50))
    )
    val edgeArray = Array(
      Edge(2L, 1L, 7),
      Edge(2L, 4L, 2),
      Edge(3L, 2L, 4),
      Edge(3L, 6L, 3),
      Edge(4L, 1L, 1),
      Edge(5L, 2L, 2),
      Edge(5L, 3L, 8),
      Edge(5L, 6L, 3)
    )

    val vertexRDD = sc.parallelize(vertexArray)
    val edgeRDD = sc.parallelize(edgeArray)
    val graph = Graph(vertexRDD, edgeRDD)




  }

}