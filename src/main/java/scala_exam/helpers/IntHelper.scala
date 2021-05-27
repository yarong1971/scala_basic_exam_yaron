package scala_exam.helpers

object IntHelper {
  implicit class IntExtension(number: Int) {
    def isNaturalNumber(): Boolean = number > 0

    def isBetween(min: Int, max: Int): Boolean = number >= min && number <= max
  }
}
