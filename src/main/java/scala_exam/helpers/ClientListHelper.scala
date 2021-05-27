package scala_exam.helpers

import scala_exam.helpers.ClientHelper.ClientExtension
import scala_exam.models.{Client, User}

import scala.collection.mutable.ListBuffer

object ClientListHelper {
  implicit class ClientListExtension(clientList: List[Client]) {
    def validate(): List[Client] = {
      clientList.filter(client => client.hasValidPhoneAndEmail)
        .filter((client => client.hasValidAge))
    }

    def toUsers: ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      clientList.map(client => usersList += client)
      usersList
    }
  }
}
