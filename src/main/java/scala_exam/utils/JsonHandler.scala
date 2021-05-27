package scala_exam.utils

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import scala_exam.models._

import java.io.File
import java.util.List
import scala.jdk.CollectionConverters.CollectionHasAsScala

object JsonHandler {


  val mapper: ObjectMapper= new ObjectMapper
  mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

  def getRequest(filename: String): scala.List[Request] ={
      mapper.readValue(new File(filename), new TypeReference[List[Request]]() {}).asScala.toList
  }

  def getPersons(path:String):scala.List[Person]= {
    mapper.readValue(new File(path), new TypeReference[List[Person]]() {}).asScala.toList
  }
}
