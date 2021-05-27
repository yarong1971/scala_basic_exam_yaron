package scala_exam.utils

import java.io.FileNotFoundException
import java.util.Properties
import scala.io.Source


object ApplicationHandler {

  val url = getClass.getResource("/application.properties")
  val properties: Properties = new Properties()

  if(url != null) {
    val source = Source.fromURL(url)
    properties.load(source.bufferedReader())
  } else {
    throw new FileNotFoundException("Properties file cannot be loaded")
  }

  val clientsPath = properties.getProperty("clients_path")
  val personsPath = properties.getProperty("persons_path")
  val requestPath = properties.getProperty("request_path")
}
