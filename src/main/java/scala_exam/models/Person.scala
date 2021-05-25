package scala_exam.models

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import scala_exam.utils.Helpers._

import java.io.BufferedWriter
@JsonCreator
case class   Person@JsonCreator()(@JsonProperty("age")var age:Int,
                                  @JsonProperty("name")var name: String,
                                  @JsonProperty("gender")var gender: String,
                                  @JsonProperty("company")var company: String,
                                  @JsonProperty("email")var email: String,
                                  @JsonProperty("phone")var phone: String,
                                  @JsonProperty("address")var address: String) extends Serializable with User {

  override implicit def filterByRequest(request: Request): Boolean = {
    request match {
      case Request (minAge,maxAge, gender, prefix, _, _) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase() && this.name.startsWith(prefix)
      case Request (_,maxAge, gender, prefix, _, _) => this.age <= maxAge && this.gender.toLowerCase() == gender.toLowerCase() && this.name.startsWith(prefix)
      case Request (_, _, gender, prefix, _, _) => this.gender.toLowerCase() == gender.toLowerCase() && this.name.startsWith(prefix)
      case Request (_, _, _, prefix, _, _) => this.name.startsWith(prefix)
      case Request (minAge, _, gender, prefix, _, _) => this.age >= minAge && this.gender.toLowerCase() == gender.toLowerCase() && this.name.startsWith(prefix)
      case Request (minAge, _, _, prefix, _, _) => this.age >= minAge && this.name.startsWith(prefix)
      case Request (minAge, _, _, _, _, _) => this.age >= minAge
      case Request (minAge, maxAge, _, prefix, _, _) => this.age.isBetween(minAge,maxAge) &&  this.name.startsWith(prefix)
      case Request (minAge, maxAge, _, _, _, _) => this.age.isBetween(minAge,maxAge)
      case Request (minAge, maxAge, gender, _, _, _) => this.age.isBetween(minAge,maxAge) && this.gender.toLowerCase() == gender.toLowerCase()
      case Request (_, _, _, _, _, _) => true
    }
  }

  override def writeToFile(writer: BufferedWriter): Unit = {

  }
}