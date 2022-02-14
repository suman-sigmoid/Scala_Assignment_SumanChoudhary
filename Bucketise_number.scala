import scala.math.BigDecimal.double2bigDecimal
object Bucketise_number {
  def binary_search(n : Double , arr:Array[BigDecimal]): Int={
    if(n >= 100.05) return -1
    if(100.00<= n && n <= 100.049) return arr.length-1
    else {
      var low = 0
      var high = arr.length - 1
      while (low <= high) {

        var middle = low + (high - low) / 2
        //        println(s"$low , $high , $middle")
        if (n >= arr(middle) && n < arr(middle + 1)) {
          return middle
        } else if (arr(middle) > n)
          high = middle - 1
        else
          low = middle + 1
      }
    }
    -1}
  def main(args: Array[String]): Unit = {
    var flag = true
    val arr = (0d to 100d by 0.05d).toArray
    //    arr.foreach(i => print(s"$i ,"))
    while(flag){
      val result = scala.io.StdIn.readLine("type -1 to exit or Write a Number : ").toDouble
      if(result == -1) flag = false
      var x = binary_search(result,arr)
      if(x>0){
        println(s"Bucket for $result is : ${arr(x)} - ${arr(x)+0.049}")
      }else println(s"There is no Bucket for $result")
    }}}
