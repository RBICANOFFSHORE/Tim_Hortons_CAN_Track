package com.testcases.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fr = new File("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\demodata\\demodata.xlsx");
		FileInputStream fis = new FileInputStream(fr);
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      int sheets = workbook.getNumberOfSheets();
	      for(int i=0;i<sheets;i++){
	          if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
	          {
	              XSSFSheet sheet = workbook.getSheetAt(i);
	          Iterator<Row> rows =  sheet.iterator();
	          Row firstrow=rows.next();
	          Iterator<Cell> ce = firstrow.cellIterator();
	          int k =0;
	          int coloumn =0;
	          while(ce.hasNext())
	          {
	              Cell value= ce.next();
	              if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
	              {
	                  coloumn=k;

	              }k++;

	          }
	          while(rows.hasNext())
	          {
	              Row r = rows.next();
	              if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Price"))
	              {
	                  Iterator<Cell> cv = r.cellIterator();
	                  while(cv.hasNext())
	                  {
	                      cv.next().getStringCellValue();
	                  }
	              }
	          }
	          }
	      }

	}

}
