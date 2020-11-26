package com.ats.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility extends CommonMethods{

	private static Workbook book;
	private static Sheet sheet;

	/**
	 * This method open Excel sheet
	 * 
	 * @param filepath
	 */
	private static void openExcel(String filepath) {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	/**
	 * this method returns number of rows
	 * 
	 * @return
	 */

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	/**
	 * This method returns number of colums
	 * 
	 * @param rowIndex
	 * @return
	 */
	private static int columsCount() {
		return sheet.getRow(0).getLastCellNum();

	}

	private static String columsName(int rowIndex, int columnIndex) {
		return sheet.getRow(rowIndex).getCell(columnIndex).toString();
	}

	// return a 2d object array of data

	public static Object[][] excelIntoArray(String filePath, String adduserfromexcelsheet) {

		openExcel(filePath);
		loadSheet(adduserfromexcelsheet);

		//int rows = rowCount();
		//int colums = columsCount();

		Object[][] data = new Object[rowCount() - 1][columsCount()];

	    //i=row j=column
		// get rows
		for (int i = 1; i < rowCount(); i++) {
			// get colums
			for (int j = 0; j < columsCount(); j++) {

				data[i - 1][j] = columsName(i, j);
			}
		}
		return data;
	}
	
	public static List<Map<String,String>> dataFromExcelFile(String filePath, String sheetName){
		
		
		openExcel(filePath);
		loadSheet(sheetName);
		
		List<Map<String,String>> excelList=new ArrayList<>();
		  Map<String,String> excelMap;
		
		  //i=row j=column
		for (int i = 1; i < rowCount(); i++) {
			excelMap= new LinkedHashMap<>();//order
			
			for (int j = 0; j < columsCount(); j++) {
				excelMap.put(columsName(0, j), columsName(i, j));
			}
			
			excelList.add(excelMap);
			
		}
		
		
		
		return excelList;
	}
}
