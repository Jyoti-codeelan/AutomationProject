package com.qa.codeElan.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ExcelUtils {

	// TODO - Change the path accordingly
	public static String DATASHEETPATH = "./src/main/java/com/qa/codeElan/TestData/CodeElan_TestDataSheet.xlsx";
	public static XSSFWorkbook workbook;
	public static DataFormatter formatter = new DataFormatter();
	
	public static final String LOGINDATA_SHEET = "Login_Sheet";
	public static final String TESTDATA_SHEET = "TestData_Sheet";
	public  final String CONFIG_DATA_SHEET = "ConfigData_Sheet";

	public  void loadExcel() {
		File file = new File(DATASHEETPATH);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  Map<String, String> getData(String sheetName) {
		Map<String, String> dataMap;
		if (workbook == null) {
			loadExcel();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		dataMap = new HashMap<String, String>();

		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();

		for (int i = firstRow + 1; i <= lastRow; i++) {
			Cell firstCell = sheet.getRow(i).getCell(0);
			Cell secondCell = sheet.getRow(i).getCell(1);
			dataMap.put(formatter.formatCellValue(firstCell).trim(), formatter.formatCellValue(secondCell).trim());
		}
		return dataMap;
	}
	

	public  Map<String, List<String>> getLoginData() {
		Map<String, List<String>> loginDataMap;
		if (workbook == null) {
			loadExcel();
		}
		XSSFSheet sheet = workbook.getSheet(LOGINDATA_SHEET);
		loginDataMap = new HashMap<String, List<String>>();
		List<String> liData = new ArrayList<String>();
		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();

		for (int i = firstRow + 1; i <= lastRow; i++) {
			Cell firstCell = sheet.getRow(i).getCell(0);
			Cell secondCell = sheet.getRow(i).getCell(1);
			Cell thirdCell = sheet.getRow(i).getCell(2);
			liData.add(formatter.formatCellValue(secondCell).trim());
			liData.add(formatter.formatCellValue(thirdCell).trim());
			loginDataMap.put(formatter.formatCellValue(firstCell).trim(), liData);
		}
		return loginDataMap;
	}

	public static void main(String[] args) {
//		ExcelUtils obj = new ExcelUtils();
//		Map<String, List<String>> loginData = obj.getLoginData();
//		Map<String, String> configData = obj.getData(CONFIG_DATA_SHEET);
//		Map<String, String> testData = obj.getData(TESTDATA_SHEET);
//
//		System.out.println(loginData.get("Level1").get(0));
//		System.out.println(loginData.get("Ideator").get(1));
//		System.out.println(loginData.get("Level4").get(0));
//		System.out.println(configData.get("Browser"));
		
	}

}
