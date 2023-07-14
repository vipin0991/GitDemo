package com.SDESeleniumFramework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlSheet);
		//row = ws.getRow(0);
		int rowNum = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowNum;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);

		String data;
		DataFormatter formatter = new DataFormatter();
		data = formatter.formatCellValue(cell);
		
		wb.close();
		fis.close();
		return data;
	}
	
}
