package scala_exam.handlers

import java.io.FileNotFoundException
import java.net.URL
import java.util.Properties
import scala.io.Source

object ApplicationHandler {

  val url: URL = getClass.getResource("/application.properties")
  val properties: Properties = new Properties()

  if (url != null) {
    val source = Source.fromURL(url)
    properties.load(source.bufferedReader())
  } else {
    throw new FileNotFoundException("Properties file cannot be loaded")
  }

  val clientsPath: String = properties.getProperty("clients_path")
  val personsPath: String = properties.getProperty("persons_path")
  val requestPath: String = properties.getProperty("request_path")
}
