package scala_exam.models

import scala_exam.helpers.IntHelper.IntExtension
import scala.language.implicitConversions

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
    (request.minAge > 0, request.maxAge > 0, request.gender != "", request.prefixName != "", request.maritalStatus != "", request.numberOfChildren > 0) match {
      case (true, true, true, true, true, true) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, true, true, true, true, true) => age <= request.maxAge && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, true, false, true, true, true) => age <= request.maxAge && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, true, false, false, true, true) => age <= request.maxAge && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, true, false, false, false, true) => age <= request.maxAge && numberOfChildren > request.numberOfChildren
      case (false, true, false, false, false, false) => age <= request.maxAge
      case (false,true,true,false,true,true) => age <= request.maxAge && gender.toLowerCase() == request.gender.toLowerCase() && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case(false,true,true,true,true,false) => age <= request.maxAge && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase()
      case (false, false, true, true, true, true) => gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, false, true, false, true, true) => gender.toLowerCase() == request.gender.toLowerCase() && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, false, true, false, false, true) => gender.toLowerCase() == request.gender.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, false, true, false, false, false) => gender.toLowerCase() == request.gender.toLowerCase()
      case (false, false, false, true, true, true) => firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, false, false, true, false, true) => firstName.startsWith(request.prefixName) && numberOfChildren > request.numberOfChildren
      case (false, false, false, true, false, false) => firstName.startsWith(request.prefixName)
      case (false, false, false, false, true, true) => maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (false, false, false, false, true, false) => maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase()
      case (false, false, false, false, false, true) => numberOfChildren > request.numberOfChildren
      case (false, false, false, false, false, false) => false
      case (true, false, true, true, true, true) => age >= request.minAge && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, false, false, true, true, true) => age >= request.minAge && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, false, false, false, true, true) => age >= request.minAge && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, false, false, false, false, true) => age >= request.minAge && numberOfChildren > request.numberOfChildren
      case (true, false, false, false, false, false) => age >= request.minAge
      case (true, true, false, true, true, true) => age.isBetween(request.minAge,request.maxAge) && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, true, false, false, true, true) => age.isBetween(request.minAge,request.maxAge) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, true, false, false, false, true) => age.isBetween(request.minAge,request.maxAge) && numberOfChildren > request.numberOfChildren
      case (true, true, false, false, false, false) => age.isBetween(request.minAge,request.maxAge)
      case (true, true, true, false, true, true) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, true, true, false, false, true) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && numberOfChildren > request.numberOfChildren
      case (true, true, true, false, false, false) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase()
      case (true, true, true, true, false, true) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && numberOfChildren > request.numberOfChildren
      case (true, true, true, true, false, false) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName)
      case (true, true, true, true, true, false) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && firstName.startsWith(request.prefixName) && maritalStatus.toLowerCase() == request.maritalStatus.toLowerCase()
      }
  }
}