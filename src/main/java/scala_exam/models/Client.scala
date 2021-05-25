package scala_exam.models

import scala_exam.utils.Helpers._

import java.io.BufferedWriter

case class Client(var firstName: String = "",
                  var lastName: String = "",
                  var gender: String = "",
                  var age: Int = 0,
                  var email: String = "",
                  var phone: String = "",
                  education:String,
                  occupation: String,
                  salary: Int,
                  maritalStatus: String,
                  numberOfChildren: Int = 0) extends User{

  override implicit def filterByRequest(request: Request): Boolean = {
      request match {
        case Request (minAge,maxAge, gender, prefix, maritalStatus, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (_,maxAge, gender, prefix, maritalStatus, numberOfChildren) => this.age <= maxAge && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (_, _, gender, prefix, maritalStatus, numberOfChildren) => this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (_, _, _, prefix, maritalStatus, numberOfChildren) => firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (_, _, _, _, maritalStatus, numberOfChildren) => this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (_, _, _, _, _, numberOfChildren) => this.numberOfChildren > numberOfChildren
        case Request (minAge, _, gender, prefix, maritalStatus, numberOfChildren) => this.age >= minAge && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, _, _, prefix, maritalStatus, numberOfChildren) => this.age >= minAge && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, _, _, _, maritalStatus, numberOfChildren) => this.age >= minAge && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, _, _, _, _, numberOfChildren) => this.age >= minAge && this.numberOfChildren > numberOfChildren
        case Request (minAge, _, _, _, _, _) => this.age >= minAge
        case Request (minAge, maxAge, _, prefix, maritalStatus, numberOfChildren) => this.age.isBetween(minAge,maxAge) &&  firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, _, _, maritalStatus, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, _, _, _, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, _, _, _, _) => this.age.isBetween(minAge,maxAge)
        case Request (minAge, maxAge, gender, _, maritalStatus, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, gender, _, _, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, gender, _, _, _) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase()
        case Request (minAge, maxAge, gender, prefix, _, numberOfChildren) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.numberOfChildren > numberOfChildren
        case Request (minAge, maxAge, gender, prefix, _, _) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix)
        case Request (minAge, maxAge, gender, prefix,maritalStatus, _) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && firstName.startsWith(prefix) && this.maritalStatus.toLowerCase() == maritalStatus.toLowerCase()
        case Request (_, _, _, _, _, _) => true
      }
  }
}