package scala_exam

import scala_exam.models.User
import scala_exam.utils.{ExcelHandler, JsonHandler}
import scala_exam.utils.Helpers.{ClientHelper, ClientListHelper, PersonHelper, PersonListHelper, UserListHelper}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

    val clients = ExcelHandler.read("data/client.xlsx")
    val request = JsonHandler.getRequest("data/request.json")(0)
    val persons = JsonHandler.getPersons("data/persons.json")
    var usersList = new ListBuffer[User]()

    usersList = clients.validate().toUsers()
    usersList.addAll(persons.validate().toUsers())
    usersList.toList.filterByRequest(request).print(request)
  }
}
