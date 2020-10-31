@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for (element in v) sum += sqr(element)
    return sqrt(sum)
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) return 0.0
    var sum = 0.0
    for (element in list) sum += element
    return sum / list.size
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val mlist = mean(list)
    for (i in list.indices) {
        list[i] -= mlist
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var sum = 0
    for (i in a.indices) sum += a[i] * b[i]
    return sum
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    if (p.isEmpty()) return 0
    if (x == 0) return p[0]
    var m = 0
    var y = 1
    for (element in p) {
        m += element * x / x * y
        y *= x
    }
    return m
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var k = 0
    for (i in 0 until list.size) {
        k += list[i]
        list[i] = k
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val p = mutableListOf<Int>()
    var m = n
    var x = 2
    while (m != 1) {
        if (m % x == 0) {
            p.add(x)
            m /= x
        } else x++
    }
    return p
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    val list = factorize(n)
    var p = "${list[0]}"
    for (i in 1 until list.size) {
        p += "*${list[i]}"
    }
    return p
}

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    if (n == 0) return listOf(n)
    val list = mutableListOf<Int>()
    var m = n
    while (m != 0) {
        list.add(0, m % base)
        m /= base
    }
    return list
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    val alphabet = mutableListOf<Char>()
    for (i in 'a'..'z') {
        alphabet.add(i)
    }
    val list = convert(n, base).toMutableList()
    var listcts = ""
    for (i in 0 until list.size) {
        listcts += if (list[i] > 9) {
            alphabet[list[i] - 10]
        } else
            list[i]
    }
    return listcts
}

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var digit = 0
    val bs = digits.size - 1
    var rank = base.toDouble().pow(bs).toInt()
    for (i in digits.indices) {
        digit += digits[i] * rank
        rank /= base
    }
    return digit
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    val numalp = mutableListOf<Char>()
    for (i in '0'..'9') {
        numalp.add(i)
    }
    for (i in 'a'..'z') {
        numalp.add(i)
    }
    val list = str.toMutableList()
    val lst = mutableListOf<Int>()
    for (i in list.indices) {
        for (s in numalp.indices) {
            if (list[i] == numalp[s]) lst.add(s)
        }
    }
    return decimal(lst, base)
}


/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val roman = listOf(
        "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX",
        "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D",
        "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM"
    )
    val romdig = mutableListOf<Int>()
    for (i in 1..9) romdig.add(i)
    for (i in 10..90 step 10) romdig.add(i)
    for (i in 100..900 step 100) romdig.add(i)
    for (i in 1000..3000 step 1000) romdig.add(i)
    val list = mutableListOf<Int>()
    var str = ""
    var k = 1
    var m = n
    while (m != 0) {
        if (m % 10 != 0) list.add(0, m % 10 * k)
        k *= 10
        m /= 10
    }
    for (i in list.indices) {
        for (s in romdig.indices) if (list[i] == romdig[s]) str += roman[s]
    }
    return str
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val digalp = mutableListOf(
        "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
        "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
        "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать",
        "девятнадцать", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
        "семьдесят", "восемьдесят", "девяносто", "сто", "двести", "триста", "четыреста",
        "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот", "одна тысяча",
        "две тысячи", "три тысячи", "четыре тысячи",
    )
    val digd = mutableListOf<Int>()
    for (i in 1..9) digd.add(i)
    for (i in 10..20) digd.add(i)
    for (i in 30..90 step 10) digd.add(i)
    for (i in 100..900 step 100) digd.add(i)
    for (i in 1000..4000 step 1000) digd.add(i)
    val list = mutableListOf<Int>()
    var str = ""
    var k = 1
    var m = n
    while (m != 0) {
        if (m % 10 != 0) list.add(0, m % 10 * k)
        k *= 10
        m /= 10
    }
    k = 0
    var l = 0
    for (i in list.indices) {
        if (i != 0 && (list[i] in 1000..9000 && list[i - 1] == 10000
                    || list[i] in 1..9 && list[i - 1] == 10)
        ) {
            list[i] += list[i - 1]
            if (list[i] in 10000..19000) k = 1
            if (list[i] in 10..19) l = 1
        }
    }
    if (k == 1) list.remove(10000)
    if (l == 1) list.remove(10)
    for (i in list.indices) {
        if (list[i] <= 4000) {
            for (s in digd.indices) {
                if (list[i] == digd[s]) str += digalp[s]
            }
        }
        if (list[i] >= 5000) {
            for (s in digd.indices) {
                if (list[i] / 1000 == digd[s] &&
                    (list.size == 1
                            || list.size != 1 && (i != 0 && i == list.size - 1
                            || i != list.size - 1 && digitNumber(list[i + 1]) < 4)
                            || list[0] >= 100000 && list[1] !in 10000..100000)
                ) str += "${digalp[s]} тысяч"
                else if (list[i] / 1000 == digd[s] && (i == 0
                            || i != list.size - 1 && digitNumber(list[i + 1]) > 3)
                ) str += digalp[s]
            }
        }
        str += " "

    }
    return str.trim()
}