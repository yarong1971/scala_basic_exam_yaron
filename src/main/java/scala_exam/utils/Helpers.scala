package scala_exam.utils

import scala_exam.models.{Client, Person, Request, User}

import scala.collection.mutable.ListBuffer

object Helpers {
  implicit class StringHelper(string: String) {
    def isValidPhoneNumber(): Boolean = {
      val phoneRegex = """^(\d{3}[-])(\d{4}[-])\d{2}$|^(\+\d{1,3}( )?)?((\(\d{3}\))|\d{3})[- .]?\d{3}[- .]?\d{4}$"""
      string.matches(phoneRegex)
    }

    def isValidEmail(): Boolean = {
      val emailRegex = """^[a-zA-Z0-9\.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"""
      string.matches(emailRegex)
    }
  }

  implicit class IntHelper(number: Int) {
    def isNaturalNumber(): Boolean = number > 0
    def isBetween(min: Int, max: Int): Boolean = number >= min && number <= max
  }

  implicit class ClientHelper(client: Client) {
    def hasValidPhoneAndEmail: Boolean = client.phone.isValidPhoneNumber() && client.email.isValidEmail()
    def hasValidAge: Boolean = client.age.isNaturalNumber()
    def toPerson() : Person = {
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

  implicit class PersonHelper(person: Person) {
    def hasValidPhoneAndEmail: Boolean = person.phone.isValidPhoneNumber() && person.email.isValidEmail()
    def hasValidAge: Boolean = person.age.isNaturalNumber()
    def toClient() : Client = {
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

  implicit class ClientListHelper (clientList: List[Client]) {
    def validate(): List[Client] = {
      clientList.filter(client => client.hasValidPhoneAndEmail)
        .filter((client => client.hasValidAge))
    }

    def toUsers(): ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      clientList.map(client => usersList += client)
      usersList
    }
  }

  implicit class PersonListHelper (personList: List[Person]) {
    def validate(): List[Person] = {
      personList.filter(person => person.hasValidPhoneAndEmail)
        .filter((person => person.hasValidAge))
    }

    def toUsers(): ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      personList.map(person => usersList += person)
      usersList
    }
  }

  implicit class UserListHelper (userList: List[User]) {
    def filterList(request: Request): List[User] = {
      userList.filter(user => user.filterByRequest(request))
    }

    def print(request: Request): Unit = {
      println("filter details: age between " + request.minAge + " to " + request.maxAge +
                              "\n\t\t\t\tgender is '" + request.gender + "'" +
                              "\n\t\t\t\tname starts with '" + request.prefixName + "'" +
                              "\n\t\t\t\tmarital status is '" + request.maritalStatus + "' (person only)" +
                              "\n\t\t\t\tnumber of children is more than " + request.numberOfChildren + " (person only)" +
                              "\n--------------------------------------------------------------------------------------")
      println("Users list filtered by request (" + userList.size + " users):")
      println("--------------------------------------------------------------------------------------")
      userList.zipWithIndex.foreach{case (user, index) => println("[%2d] %s".format((index + 1),user))}
    }
  }
}
