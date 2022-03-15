fun main() {
    println(agoToText())
}


const val second = 600
const val minutes = second / 60
const val hours = second / 60 / 60
const val days = second / 60 / 60 / 24

fun agoToText(): String {
    return when {
        second in 0..60 -> "Только что"
        second in 61..(60 * 60) -> when {
            ((minutes - 1) % 10 == 0) && minutes != 11 -> "$minutes минуту назад"
            ((minutes - 2) % 10 == 0) || ((minutes - 3) % 10 == 0) || ((minutes - 4) % 10 == 0) -> "$minutes минуты назад"
            else -> "$minutes минут назад"
        }
        second in (60 * 60)..(24 * 60 * 60) -> when {
            ((hours - 1) % 10 == 0) && hours != 11 -> "$hours час назад"
            ((hours - 2) % 10 == 0) || ((hours - 3) % 10 == 0) || ((hours - 4) % 10 == 0) -> "$hours часа назад"
            else -> "$hours часов назад"

        }
        second in (24 * 60 * 60)..(2 * 24 * 60 * 60) -> "сегодня"
        second in (2 * 24 * 60 * 60)..(3 * 24 * 60 * 60) -> "вчера"

        else -> "давно"

    }

}
