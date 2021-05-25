package scala_exam

import scala_exam.models.User
import scala_exam.utils.{ExcelHandler, JsonHandler}
import scala_exam.utils.Helpers.{ClientHelper, ClientListHelper, PersonListHelper, PersonHelper}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val jsonHandler = JsonHandler
    val excelHandler = ExcelHandler

    val clients = excelHandler.read("data/client.xlsx")
    val request =  jsonHandler.getRequest("data/request.json")
    val persons = jsonHandler.getPersons("data/persons.json")
    var usersList = new ListBuffer[User]()

    val validClients = clients.getValidatedClients()
    val validPersons = persons.getValidatedPersons()

    usersList = clients.toUsersList
    usersList.addAll(persons.toUsersList())

    val filteredUsersList = usersList.filter(user => user.filterByRequest(request(0))).toList

    println("Users list filtered by request (" + filteredUsersList.size + " users):")
    filteredUsersList.foreach(user => println(user))
  }
}
