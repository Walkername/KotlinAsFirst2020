package lesson11.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class ComplexTest {

    private fun assertApproxEquals(expected: Complex, actual: Complex, eps: Double) {
        assertEquals(expected.re, actual.re, eps)
        assertEquals(expected.im, actual.im, eps)
    }

    @Test
    @Tag("2")
    fun plus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("38-3i"), Complex("26+2i") + Complex("12-5i"), 1e-10)
        assertApproxEquals(Complex("6-4i"), Complex("2+1i") + Complex("4-5i"), 1e-10)
        assertApproxEquals(Complex("6.5-4"), Complex("2.5+1i") + Complex("4-5i"), 1e-10)
    }

    @Test
    @Tag("2")
    operator fun unaryMinus() {
        assertApproxEquals(Complex(-2.0, 1.0), -Complex(2.0, -1.0), 1e-10)
        assertApproxEquals(Complex(6.8, 4.4), -Complex(-6.8, -4.4), 1e-10)
        assertApproxEquals(Complex(-2034.8, -8.9), -Complex(2034.8, 8.9), 1e-10)
    }

    @Test
    @Tag("2")
    fun minus() {
        assertApproxEquals(Complex("-1+9i"), Complex("6+5i") - Complex("7-4i"), 1e-10)
        assertApproxEquals(Complex("-2+11i"), Complex("1+7i") - Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("7-3i"), Complex("11-2i") - Complex("4+1i"), 1e-10)
    }

    @Test
    @Tag("4")
    fun times() {
        assertApproxEquals(Complex("11+2i"), Complex("1+2i") * Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("252-384i"), Complex("34+4i") * Complex("6-12i"), 1e-10)
        assertApproxEquals(Complex("23+1i"), Complex("1+2i") * Complex("5-9i"), 1e-10)
        assertApproxEquals(Complex("-13-19i"), Complex("1-2i") * Complex("5-9i"), 1e-10)
        assertApproxEquals(Complex("-17.99-29.89i"), Complex("1.5-2.9i") * Complex("5.6-9.1i"), 1e-10)
    }

    @Test
    @Tag("4")
    fun div() {
        assertApproxEquals(Complex("2.6+0.8i"), Complex("11-8i") / Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("0.1-1.3i"), Complex("4-18i") / Complex("14+2i"), 1e-10)
        assertApproxEquals(Complex("1.25-0.75i"), Complex("9-2i") / Complex("6+2i"), 1e-10)
        assertApproxEquals(Complex("-0.16-0.28i"), Complex("2-3i") / Complex("5+10i"), 1e-10)
        assertApproxEquals(Complex("0.1-0.55i"), Complex("3-4i") / Complex("8+4i"), 1e-10)
    }

    @Test
    @Tag("2")
    fun equals() {
        assertApproxEquals(Complex(1.0, 2.0), Complex("1+2i"), 1e-12)
        assertApproxEquals(Complex(1.0, 0.0), Complex(1.0), 1e-12)
        assertApproxEquals(Complex(7.0, 4.0), Complex("7+4i"), 1e-12)
        assertApproxEquals(Complex(1.5, 5.1), Complex("1.5+5.1i"), 1e-12)
    }
}