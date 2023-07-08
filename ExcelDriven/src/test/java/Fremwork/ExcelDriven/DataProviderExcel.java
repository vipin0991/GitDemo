package Fremwork.ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider="driveTest")
	public void readExcelData(String greeting, String communication, String id) {
		System.out.println(greeting+communication+id);
	}
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("../ExcelDriven/TestData.xlsx");
		XSSFWorkbook wb =  new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(1);
		int rows = sheet.getPhysicalNumberOfRows();
		XSSFRow r=  sheet.getRow(0);
		int col = r.getLastCellNum();
		
		Object data[][] = new Object[rows-1][col];
		for(int i=0;i<rows-1;i++) {
			r = sheet.getRow(i+1);
			for(int j=0;j<col;j++) {
				XSSFCell c =  r.getCell(j);
				data[i][j] = formatter.formatCellValue(c);
			}
		}
		return data;
		
	}
}
