package scala_exam.helpers

import scala_exam.helpers.IntHelper.IntExtension
import scala_exam.helpers.StringHelper.StringExtension
import scala_exam.models.{Client, Person}

object PersonHelper {
  implicit class PersonExtension(person: Person) {
    def hasValidPhoneAndEmail: Boolean = person.phone.isValidPhoneNumber && person.email.isValidEmail

    def hasValidAge: Boolean = person.age.isNaturalNumber()

    def toClient: Client = {
      var client: Client = new Client(person.name.split(" ")(0),
        person.name.split(" ")(1),
        person.gender,
        person.age,
        person.email,
        person.phone,
        "",
        "",
        0,
        "",
        0)
      client
    }
  }
}
