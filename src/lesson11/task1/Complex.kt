@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this(
        if (s[0] == '-') (s[0] + s.removeRange(0..0).split(Regex("[-+i]"))[0]).toDouble()
        else s.split(Regex("[-+i]"))[0].toDouble(),
        if (s[0] == '-') (s.removeRange(0..0).filter { it == '+' || it == '-' }
                + s.removeRange(0..0).split(Regex("[-+i]"))[1]).toDouble()
        else (s.filter { it == '-' || it == '+' } + s.split(Regex("[-+i]"))[1]).toDouble()
    )

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-re, -im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex = Complex(re * other.re - im * other.im, re * other.im + im * other.re)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex = Complex(
        (re * other.re + im * other.im) / (other.im * other.im + other.re * other.re),
        (im * other.re - re * other.im) / (other.im * other.im + other.re * other.re)
    )

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = other is Complex && re == other.re && im == other.im

    /**
     * Преобразование в строку
     */
    override fun toString(): String = if (im < 0) "$re${im}i" else "$re+${im}i"

    /**
     * hashCode
     */
    override fun hashCode(): Int {
        var hCode = re.hashCode()
        hCode = hCode * 31 + im.hashCode()
        return hCode
    }
}