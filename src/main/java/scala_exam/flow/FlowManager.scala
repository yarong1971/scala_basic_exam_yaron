package scala_exam.flow

import scala_exam.handlers.{ApplicationHandler, ExcelHandler, JsonHandler}
import scala_exam.helpers.ClientListHelper.ClientListExtension
import scala_exam.helpers.PersonListHelper.PersonListExtension
import scala_exam.helpers.UserListHelper.UserListExtension
import scala_exam.models.User

import scala.collection.mutable.ListBuffer

object FlowManager {

  def start(): Unit = {
    val clients = ExcelHandler.read(ApplicationHandler.clientsPath)
    val persons = JsonHandler.getPersons(ApplicationHandler.personsPath)
    val request = JsonHandler.getRequest(ApplicationHandler.requestPath).head

    var usersList = new ListBuffer[User]()

    usersList = clients.validate().toUsers
    usersList.addAll(persons.validate().toUsers)
    usersList.toList.filterByRequest(request).print(request)
  }
}
