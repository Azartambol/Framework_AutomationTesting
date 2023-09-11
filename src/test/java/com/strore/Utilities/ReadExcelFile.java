package com.strore.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {
File f;
FileInputStream fis;
Workbook wb;
Sheet sh;
Row rw;
Cell cl;
	
	public String valueProvide(String filepath, int sheetno, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheetAt(sheetno);
		rw=sh.getRow(rowno);
		cl=rw.getCell(cellno);
		String value = cl.getStringCellValue();
		return value;
		
	}
	
	public int getNoOfRow(String filepath, int sheetno) throws EncryptedDocumentException, IOException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheetAt(sheetno);
		int rowno = sh.getLastRowNum();
		
		return rowno;
	}
	
	public int getNoOfcells(String filepath, int sheetno, int rowno) throws EncryptedDocumentException, IOException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheetAt(sheetno);
		rw=sh.getRow(rowno);
		int cellno = rw.getLastCellNum();
		
		return cellno ;
	}
}
