package scala_exam

import scala_exam.models.User
import scala_exam.utils.{ApplicationHandler, ExcelHandler, JsonHandler}
import scala_exam.utils.Helpers.{ClientListHelper, PersonListHelper, UserListHelper}
import scala.collection.mutable.ListBuffer


object Main {
  def main(args: Array[String]): Unit = {

    val clients = ExcelHandler.read(ApplicationHandler.clientsPath)
    val persons = JsonHandler.getPersons(ApplicationHandler.personsPath)
    val request = JsonHandler.getRequest(ApplicationHandler.requestPath).head

    //request = request.ini
    var usersList = new ListBuffer[User]()

    usersList = clients.validate().toUsers()
    usersList.addAll(persons.validate().toUsers())
    usersList.toList.filterByRequest(request).print(request)
  }
}
