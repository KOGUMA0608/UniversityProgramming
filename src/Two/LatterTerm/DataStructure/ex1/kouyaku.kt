package ex1

class kouyaku() {
    val x = 30
    val y = 188
    var ans=0
    fun kouyaku(input1: Int, input2: Int) {
        val small = if (input1 > input2) {
            input2
        } else {
            input1
        }
        val large = if (input1 > input2) {
            input1
        } else {
            input2
        }
        for (i in 1 until small) {
            if (small % 2 == 0) {
                if (large % 2 == 0) {
                    ans=i
                }
            }
        }
        print(ans)
    }
}
