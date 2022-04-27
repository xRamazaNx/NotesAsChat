package ru.kiz.developer.abdulaev.notesaschat

import org.junit.Test
import kotlin.math.roundToInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val firstList: MutableList<Float> = mutableListOf(100F, 200F, 300F, 400F)
        val changedList = firstList.sizeDistribution(100F, 0)
        val secondList: List<Float> = listOf(200F, 177.76F, 266.64F, 355.52F)
        val sum: Int = changedList.sum().roundToInt()
        val sum1: Int = secondList.sum().roundToInt()
        assert(sum == sum1)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(-1F, 0)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(-50F, 1)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(1000F, 2)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(-1500F, 3)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(0F, 3)
        mutableListOf(100F, 200F, 300F, 400F).sizeDistribution(0F, 7)
    }

    private fun List<Float>.sizeDistribution(
        addValue: Float,
        indexOfValue: Int
    ): List<Float> = with(toMutableList()) {
        if (addValue == 0F || indexOfValue !in 0 until size)
            return this
        // Конечная сумма всех значений которая не должна измениться после расспределения
        val constantSum: Float = fold(0F) { sum, v -> sum + v }
        // финальное значение в индексе
        val finalValueOfChangedNumber = get(indexOfValue) + addValue
        set(indexOfValue, finalValueOfChangedNumber)
        // сумма с добавленным значением для расчетов
        val sumWithAddingV = constantSum - addValue
        // разница от конечеой суммы и конечным добавленным значением для расчетов
        val diffSumAfterAdd: Float = constantSum - finalValueOfChangedNumber

        val rList = mutableListOf<Float>()
        forEachIndexed { index, value ->
            val v = if (index != indexOfValue) {
                val cof: Float = value / sumWithAddingV
                diffSumAfterAdd * cof
            } else value
            rList.add(v)
        }
        val rListSum = rList.sum()
        if (rListSum != constantSum) {
            val element = rList.maxOf { it }
            val indexOf = rList.indexOf(element)
            rList[indexOf] += constantSum - rListSum
        }
        rList
    }
}