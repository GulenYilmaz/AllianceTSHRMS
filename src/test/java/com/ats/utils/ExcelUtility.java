package com.ats.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

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
	private static int columsCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();

	}

	private static String columsName(int rowIndex, int columnIndex) {
		return sheet.getRow(rowIndex).getCell(columnIndex).toString();
	}

	// return a 2d object array of data

	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int colums = columsCount(0);

		Object[][] data = new Object[rows - 1][colums];

		// get rows
		for (int row = 1; row < rows; row++) {
			// get colums
			for (int column = 0; column < colums; column++) {

				data[row - 1][column] = columsName(row, column);

			}
		}

		return data;
	}
	
	public static List<Map<String,String>> dataFromExcelFile(String filePath, String sheetName){
		
		
		openExcel(filePath);
		loadSheet(sheetName);
		
		List<Map<String,String>> excelList=new ArrayList<>();
		  Map<String,String> excelMap;
		
		for (int row = 1; row < rowCount(); row++) {
			excelMap= new LinkedHashMap<>();//order
			
			for (int column = 0; column < columsCount(row); column++) {
				excelMap.put(columsName(0, column), columsName(row, column));
			}
			
			excelList.add(excelMap);
			
		}
		
		
		
		return excelList;
	}
	
	

}
