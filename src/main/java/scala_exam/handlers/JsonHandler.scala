package scala_exam.handlers

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import scala_exam.models.{Person, Request}

import java.io.File
import java.util
import scala.jdk.CollectionConverters.CollectionHasAsScala

object JsonHandler {

  val mapper: ObjectMapper = new ObjectMapper

  def getRequest(filename: String): scala.List[Request] = {
    mapper.readValue(new File(filename), new TypeReference[util.List[Request]]() {}).asScala.toList
  }

  def getPersons(path: String): scala.List[Person] = {
    mapper.readValue(new File(path), new TypeReference[util.List[Person]]() {}).asScala.toList
  }
}
