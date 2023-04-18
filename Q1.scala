import scala.collection.mutable.ArrayBuffer
object Solution{


  def roundOff(value: Double): String = {
    val str= value.toString()

       // we take out the right and left of the decimal point number

    val left = str.substring(0,str.indexOf(".")+2)
    val right = if(str.indexOf(".")+2 < str.length) str.substring(str.indexOf(".")+2) else "0"

        // if right to decimal has n digit compare it with 5*10^(n-1)
        // for 13.45 we comapare 5 with 4.9
        // fir 113.455 we comapare 55 with 49

    if(right.toDouble < 4.9*math.pow(10,right.length-1)){
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
        //for correct precison

        result.append((lb,ub.toString))
    }
    result.toArray

  }
  def main(args: Array[String]): Unit = {
    val arr:Array[Double]=Array(12.05,12.03,10.33,11.45,13.50)
    val ans: Array[(String,String)]=convertToRange(arr)
    for (i <- ans){
      println(i._1 + " " +i._2)
    }
  }
}

//x.000 - x.049
//x.050 - x.099



// 10.593
// left =10.5
// right= 93
// since right > 49 append 50
// 10.550 - 10.599

// 12.052
// left = 12.0
// right=52
// since 52>49 append 50
// 12.050 + 12.099

// 12.136
// left =12.1
// right = 36
// since 36<49 append 00
// 12.100 - 12.149

// 0.534
// left =. 0.5
// right = 34 
// since 34 < 49 append 00
// 0.500 - 0.549

// 12.1
// left = 12.1
// right = 0
// since right < 4.9 --> append 00 
// 12.100 - 12.149

// 12.01
// left = 12.0
// right = 1
// since 1 < 4.9 --> append 00 
// 12.000 - 12.049

