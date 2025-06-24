import kotlin.random.Random

fun main(){
    //2.12
    print("Введите размер массива: ")
    val n = readln()!!.toInt()
    print("Введите число K: ")
    val k = readln()!!.toInt()

    val array = IntArray(n) { Random.nextInt(1, 100) }
    println("Сгенерированный массив: ${array.joinToString()}")

    val less = array.count { it < k }
    val equal = array.count { it == k }
    val greater = array.count { it > k }

    println("Меньше $k: $less")
    println("Равно $k: $equal")
    println("Больше $k: $greater")

    //2.22
    print("Введите размер массивов: ")
    val n2 = readln()!!.toInt()

    val arrayA = IntArray(n2) { Random.nextInt(1, 10) }
    val arrayB = IntArray(n2) { Random.nextInt(1, 10) }

    println("Массив A: ${arrayA.joinToString()}")
    println("Массив B: ${arrayB.joinToString()}")

    val commonElements = arrayA.intersect(arrayB.asIterable()).size
    println("Количество совпадающих элементов: $commonElements")
}