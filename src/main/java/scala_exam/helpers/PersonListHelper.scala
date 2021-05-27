package scala_exam.helpers

import scala_exam.helpers.PersonHelper.PersonExtension
import scala_exam.models.{Person, User}

import scala.collection.mutable.ListBuffer

object PersonListHelper {
  implicit class PersonListExtension(personList: List[Person]) {
    def validate(): List[Person] = {
      personList.filter(person => person.hasValidPhoneAndEmail)
        .filter((person => person.hasValidAge))
    }

    def toUsers: ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      personList.map(person => usersList += person)
      usersList
    }
  }
}
