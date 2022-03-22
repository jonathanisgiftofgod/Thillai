package org.thillai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {

	public static String readValue(String sheet, int row, int column) {
		String value = null;
		File  f = new File("C:\\Users\\Britto\\eclipse-workspace\\Thillai\\Excel\\Book1.xlsx");
		FileInputStream fi;
		try {
			fi = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fi);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(column);
			value = c.getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public static void writeExcel(int row, int column, String cellValue) throws IOException {
		File f = new File("C:\\Users\\Britto\\eclipse-workspace\\Thillai\\Excel\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Sheet3");
		Row r = s.createRow(row);
		Cell c = r.createCell(column);
		c.setCellValue(cellValue);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
	}
}
