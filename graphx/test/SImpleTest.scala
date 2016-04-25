import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by wfnuser on 16/3/1.
  */
object SImpleTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("community detection")
    val sc = new SparkContext(conf)

    val a = sc.parallelize(Array(1,2,3,4,5,6))

    val b = Array(11233,44,5,6,8)


    println("hello world!");
  }

}
