package utilititiesClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseClass.setupClass;

public class excelUtility extends setupClass {
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cells;
	public File file;
	String path = null;
	int totalrows=1;
	int totalcols=0;

	public excelUtility(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}

	/*
	 * public void setexcelfile(String path) throws IOException { try { fis = new
	 * FileInputStream(path);
	 * 
	 * workbook = new XSSFWorkbook(fis); sheet=workbook.getSheet("LoginData");
	 * 
	 * } catch(Exception e) { e.printStackTrace(); } }
	 */
	public int get_totalrows(String sheetname) throws IOException {
		
		 file=new File(path);
		fis = new FileInputStream(file);
		if(file.exists()) {
			System.out.println("File readed successfully");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
		 totalrows = sheet.getLastRowNum()-1;
			
			System.out.println("row-> " + totalrows);
			workbook.close();
			fis.close();
	
		}else {
			System.out.println("FIle not found");
		}
		return totalrows;	
		
	}

	public int get_totalcells(String sheetname, int rownum) throws IOException {
		File file=new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(rownum);
		totalcols = row.getLastCellNum();
		System.out.println("cols-> "+totalcols);
		workbook.close();
		fis.close();
		return totalcols;
	}

	public String get_cellvalue(String sheetname, int rownum, int colnum) throws IOException {
		File file=new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(rownum);
		cells = row.getCell(colnum);
		//System.out.println(cells.toString());

		
		  DataFormatter formatter = new DataFormatter(); String data; try { data =
		  formatter.formatCellValue(cells); } catch (Exception e) { data = ""; }
		 
		workbook.close();
		fis.close();
		System.out.println(data.toString());
		return data.toString();
		
	}

}
