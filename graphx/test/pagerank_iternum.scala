/**
  * Created by wfnuser on 16/4/21.
  */

import org.apache.spark.graphx._
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.rdd.RDD
import scala.reflect.ClassTag
import org.apache.spark.{SparkContext, SparkConf}

import collection.mutable.HashMap


object pagerank {

  def main(args: Array[String]) {
    //@transient
    val conf = new SparkConf().setMaster("local").setAppName("sssp")
    //@transient
    val sc = new SparkContext(conf)

    // Initialize a random graph with 10 vertices
    val graph: Graph[Long, Double] =
      GraphGenerators.logNormalGraph(sc, numVertices = 10).mapEdges( e => ((new scala.util.Random).nextInt(10000))/10000.0 ).mapEdges(e => e.attr.toDouble)
    graph.edges.foreach(println)
    //val sourceId: VertexId = 0 // The ultimate source

    val tmp = graph.outerJoinVertices(graph.outDegrees) {
      (vid, vdata, deg) => deg.getOrElse(0)
    }
    val edgetmp = tmp.mapTriplets( e => 1.0/e.srcAttr )

    // Initialize the graph such that all vertices except the root have distance infinity.
    val initialGraph = edgetmp.mapVertices( (id, attr) => 1.0 )

    //initialGraph.vertices.foreach(println)
    val resetProb = 0.15
    val initialMessage = 10.0
    val numIter = 30

    def vertexProgram(id: VertexId, attr: Double, msgSum: Double): Double =
      resetProb + (1.0 - resetProb) * msgSum
    def sendMessage(edge: EdgeTriplet[Double, Double]): Iterator[(VertexId, Double)] =
      Iterator((edge.dstId, edge.srcAttr * edge.attr))
    def messageCombiner(a: Double, b: Double): Double = a + b




    val pagerankGraph = Pregel(initialGraph, initialMessage, numIter)(
      vertexProgram, sendMessage, messageCombiner)

    println(pagerankGraph.vertices.collect.mkString("\n"))
  }

}