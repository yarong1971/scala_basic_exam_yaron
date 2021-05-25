package scala_exam.utils

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.{ObjectMapper, SerializationFeature}
import scala_exam.models._

import java.io.File
import java.util.List
import scala.jdk.CollectionConverters.CollectionHasAsScala

object JsonHandler {

  val mapper: ObjectMapper= new ObjectMapper

  def getRequest(filename: String): scala.List[Request] ={
    mapper.readValue(new File(filename), new TypeReference[List[Request]]() {}).asScala.toList
  }

  def getPersons(path:String):scala.List[Person]= {
    mapper.readValue(new File(path), new TypeReference[List[Person]]() {}).asScala.toList
  }
}
