package org.thillai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Thillai {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Britto\\eclipse-workspace\\Thillai\\Excel\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				CellType cellType = c.getCellType();
				String val = String.valueOf(cellType);
				if (val.equals("STRING")) {
					String value = c.getStringCellValue();
					System.out.println(value);
				} else if (val.equals("NUMERIC")){
					if (DateUtil.isCellDateFormatted(c)) {
						Date dateCellValue = c.getDateCellValue();
						SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
						String value = sf.format(dateCellValue);
						System.out.println(value);
					}
					else {
						double d = c.getNumericCellValue();
						long l = (long)d;
						System.out.println(l);
					}	
				}
			}
		}
	}
}
