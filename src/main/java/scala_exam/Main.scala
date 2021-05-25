package scala_exam

import scala_exam.models.User
import scala_exam.utils.{ExcelHandler, JsonHandler}
import scala_exam.utils.Helpers.{ClientHelper, ClientListHelper, PersonHelper, PersonListHelper, UserListHelper}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val jsonHandler = JsonHandler
    val excelHandler = ExcelHandler

    val clients = excelHandler.read("data/client.xlsx")
    val request =  jsonHandler.getRequest("data/request.json")(0)
    val persons = jsonHandler.getPersons("data/persons.json")
    var usersList = new ListBuffer[User]()

    val validClients = clients.validate()
    val validPersons = persons.validate()

    usersList = clients.toUsers
    usersList.addAll(persons.toUsers())
    usersList.toList.filterByRequest(request).print(request)
  }
}
