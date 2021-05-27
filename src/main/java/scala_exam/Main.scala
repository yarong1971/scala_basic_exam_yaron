package scala_exam

import scala_exam.flow.FlowManager
import scala_exam.handlers.{ApplicationHandler, ExcelHandler, JsonHandler}
import scala_exam.models.User
//import scala_exam.utils.JsonHandler
//import scala_exam.helpers.Helpers.{ClientListHelper, PersonListHelper, UserListHelper}

import scala.collection.mutable.ListBuffer


object Main {
  def main(args: Array[String]): Unit = {
    FlowManager.start()
  }
}
