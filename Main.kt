fun main() {
    //1.2
    print("Введите число: ")
    val number = readln()!!.toInt()

    var count = 0
    var num = number

    while (num != 0) {
        val digit = num % 10
        if (digit % 2 != 0) {
            count++
        }
        num /= 10
    }

    println("Количество нечетных цифр в числе $number: $count")

    //1.12
    println("Таблица умножения от 1 до 9:")
    println()

    for (i in 1..9) {
        for (j in 1..9) {
            print("${i * j}\t")
        }
        println()
    }
}