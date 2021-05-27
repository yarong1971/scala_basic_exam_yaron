package scala_exam.models

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import scala_exam.helpers.IntHelper.IntExtension
import scala.language.implicitConversions
@JsonCreator
case class   Person@JsonCreator()(@JsonProperty("age")var age:Int,
                                  @JsonProperty("name")var name: String,
                                  @JsonProperty("gender")var gender: String,
                                  @JsonProperty("company")var company: String,
                                  @JsonProperty("email")var email: String,
                                  @JsonProperty("phone")var phone: String,
                                  @JsonProperty("address")var address: String) extends Serializable with User {

  override implicit def filterByRequest(request: Request): Boolean = {
    (request.minAge > 0, request.maxAge > 0, request.gender != "", request.prefixName != "") match {
    case (true, true, true, true) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase() && name.startsWith(request.prefixName)
    case (false, true, true, true) => age <= request.maxAge && gender.toLowerCase() == request.gender.toLowerCase() && name.startsWith(request.prefixName)
    case(false,true,true,false) => age <= request.maxAge && gender.toLowerCase() == request.gender.toLowerCase()
    case (false, true, false, true) => age <= request.maxAge && name.startsWith(request.prefixName)
    case (false, true, false, false) => age <= request.maxAge
    case (false, false, true, true) => gender.toLowerCase() == request.gender.toLowerCase() && name.startsWith(request.prefixName)
    case (false, false, true, false) => gender.toLowerCase() == request.gender.toLowerCase()
    case (false, false, false, true) => name.startsWith(request.prefixName)
    case (false, false, false, false) => false
    case (true, false, true, true) => age >= request.minAge && gender.toLowerCase() == request.gender.toLowerCase() && name.startsWith(request.prefixName)
    case (true, false, true, false) => age >= request.minAge && gender.toLowerCase() == request.gender.toLowerCase()
    case (true, false, false, true) => age >= request.minAge && name.startsWith(request.prefixName)
    case (true, false, false, false) => age >= request.minAge
    case (true, true, false, true) => age.isBetween(request.minAge,request.maxAge) && name.startsWith(request.prefixName)
    case (true, true, false, false) => age.isBetween(request.minAge,request.maxAge)
    case (true, true, true, false) => age.isBetween(request.minAge,request.maxAge) && gender.toLowerCase() == request.gender.toLowerCase()
    }
  }
}