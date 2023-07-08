package Fremwork.ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public ArrayList<String> readExcel(String testcasename) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("../ExcelDriven/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row first = row.next();

				Iterator<Cell> cell = first.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					if (cell.next().getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k; // To get desired column index value
					}
					k++;
				}

				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> cell1 = r.cellIterator();
						while (cell1.hasNext()) {
							Cell v1 = cell1.next();
							if(v1.getCellTypeEnum()==CellType.STRING) {
								a.add(v1.getStringCellValue());
							}
							else {
								//if value found is integer, we will convert to string and then use
								a.add(NumberToTextConverter.toText(v1.getNumericCellValue()));
								//a.add(Integer.toString(v1.getNumericCellValue());
							}
							
						}
					}
				}
			}

		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// Identify TestCases column by scanning the entire first row.
		// Once column is identified then scan entire test case column to identify
		// Purchase testcase row
		// After you grab purchase test row, pull all data of that row, and feed into
		// test
		ReadExcelData rd = new ReadExcelData();
		ArrayList ar = rd.readExcel("Add Profile");
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		System.out.println(ar.get(2));
		System.out.println(ar.get(3));
	}
}
