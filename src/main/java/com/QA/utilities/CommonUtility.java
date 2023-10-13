package com.QA.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class CommonUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fi;

	

	public static String [][] getExcelData() {
		String data[][]=null;
		try {

			fi = new FileInputStream("src//test//resources//ExcelDataFiles//Playwrightexceldata.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheets = wb.getSheet("Sheet1");

			int totalrows = sheets.getLastRowNum() + 1;
			int totalColumns = sheets.getRow(0).getLastCellNum();
			data = new String[totalrows-1][totalColumns];

			for (int a = 1; a < totalrows; a++) {
				for (int b = 0; b < totalColumns; b++) {
					data[a-1][b] = sheets.getRow(a).getCell(b).getStringCellValue();
				}
			}
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	
	public static void main(String[] args) {
		String array[][]=CommonUtility.getExcelData();

		for(int a=0;a<array.length;a++) {
			for(int b=0;b<array[a].length;b++) {
				System.out.print(array[a][b]+" ");
			}
			System.out.println();
		}
	}
   
	

	
	
   
}
