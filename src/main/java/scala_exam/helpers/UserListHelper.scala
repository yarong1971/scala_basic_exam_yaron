package scala_exam.helpers

import scala_exam.models.{Request, User}

object UserListHelper {
  implicit class UserListExtension(userList: List[User]) {
    def filterByRequest(request: Request): List[User] = {
      userList.filter(user => user.filterByRequest(request))
    }

    def print(request: Request): Unit = {
      println("--------------------------------------------------------------------------------------")
      println("filter details:")
      if (request.minAge > 0) println("minimum age is " + request.minAge)
      if (request.maxAge > 0) println("maximum age is " + request.maxAge)
      if (request.gender != "") println("gender is '" + request.gender + "'")
      if (request.prefixName != "") println("name starts with '" + request.prefixName + "'")
      if (request.maritalStatus != "") println("marital status is '" + request.maritalStatus + "' (person only)")
      if (request.numberOfChildren > 0) println("number of children is more than " + request.numberOfChildren + " (person only)")
      println("--------------------------------------------------------------------------------------")
      println("Users list filtered by request (" + userList.size + " users):")
      println("--------------------------------------------------------------------------------------")
      userList.zipWithIndex.foreach { case (user, index) => println("[%4d] %s".format((index + 1), user)) }
    }
  }
}
