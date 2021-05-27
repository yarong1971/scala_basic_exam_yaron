package scala_exam.helpers

import scala_exam.helpers.IntHelper.IntExtension
import scala_exam.helpers.StringHelper.StringExtension
import scala_exam.models.{Client, Person}

object ClientHelper {
  implicit class ClientExtension(client: Client) {
    def hasValidPhoneAndEmail: Boolean = client.phone.isValidPhoneNumber && client.email.isValidEmail

    def hasValidAge: Boolean = client.age.isNaturalNumber()

    def toPerson: Person = {
      var person: Person = new Person(client.age,
        client.firstName.concat(" ").concat(client.lastName),
        client.gender,
        "",
        client.email,
        client.phone,
        "")
      person
    }
  }
}
