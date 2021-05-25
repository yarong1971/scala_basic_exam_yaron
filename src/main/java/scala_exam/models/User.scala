package scala_exam.models

import java.io.BufferedWriter

trait User {
  def filterByRequest(request: Request) : Boolean
  def writeToFile(writer: BufferedWriter) : Unit
}

