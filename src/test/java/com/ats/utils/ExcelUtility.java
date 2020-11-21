package com.ats.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
		for (int i = 1; i < rows; i++) {
			// get colums
			for (int j = 0; j < colums; j++) {

				data[i - 1][j] = columsName(i, j);

			}
		}

		return data;
	}

}
