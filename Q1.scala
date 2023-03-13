import scala.collection.mutable.ArrayBuffer
object Solution{


  def roundOff(value: Double): String = {
    val str= value.toString()
    
//        we take out the right and left of the decimal point number
    
    val left = str.substring(0,str.indexOf(".")+2)
    val right = if(str.indexOf(".")+2 < str.length) str.substring(str.indexOf(".")+2) else "0"
    
//    println(left+" "+right)
//         if right to decimal has n digit compare it with 5*10^(n-1)
//         for 13.4 we comapare 4 with 4.9
//         fir 113.455 we comapare 455 with 490
//    println(right.toDouble , 5*math.pow(10,right.length-1))
    
    if(right.toInt < 4.9*math.pow(10,right.length-1).toInt){
      left + "00"
    }
    else{
      left + "50"
    }

  }
  def convertToRange(arr: Array[Double]):Array[(String,String)] = {
    val result: ArrayBuffer[(String,String)]= new ArrayBuffer[(String, String)]()
    for(i <- 0 to arr.length-1){
        val lb = roundOff(arr(i))
        val ub = (lb.toDouble*1000 + 49)/1000
        """ for correct precison"""
        result.append((lb,ub.toString))
    }
    result.toArray

  }
  def main(args: Array[String]): Unit = {
    val arr:Array[Double]=Array(13.0478839,4.6665,2332.344,454.099)
    val ans: Array[(String,String)]=convertToRange(arr)
    for (i <- ans){
      println(i._1 + " " +i._2)
    }
  }
}