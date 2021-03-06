package scala_exam.handlers

import org.apache.commons.collections4.IteratorUtils
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}
import scala_exam.models.Client

import java.io.{File, FileInputStream}
import java.util.stream.StreamSupport
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._//CollectionHasAsScala

object ExcelHandler {

  def read(filename: String): List[Client] = {
    var clients: ListBuffer[Client] = new ListBuffer[Client]()
    val sheet: XSSFSheet = getExcelSheet(filename)

    StreamSupport.stream(sheet.spliterator(), false)
      .skip(1)
      .map(row => {
        var rowCells = IteratorUtils.toList(row.cellIterator()).asScala.map(cell => new DataFormatter().formatCellValue(cell))
        Client(rowCells.head,
          rowCells(1),
          rowCells(2),
          rowCells(3).toInt,
          rowCells(4),
          rowCells(5),
          rowCells(6),
          rowCells(7),
          rowCells(8).toInt,
          rowCells(9),
          rowCells(10).toInt)
      }).forEach(client => clients += client)
    clients.toList
  }

  private def getExcelSheet(filename: String): XSSFSheet = {
    val fis: FileInputStream = new FileInputStream(new File(filename))
    val workbook = new XSSFWorkbook(fis)
    workbook.getSheetAt(0)
  }
}
