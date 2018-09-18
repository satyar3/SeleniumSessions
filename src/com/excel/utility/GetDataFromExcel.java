package com.excel.utility;

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

public class GetDataFromExcel
{
	private XSSFWorkbook workbook;

	/*
	 *
	 * Identify Testcases column by scanning the entire 1st row 
	 * once column is identified then scan entire testcase column to identify desired testcase row
	 * after you grab purchase testcase row = pull all the data of that row and feed into test
	 *
	 */
	
	public ArrayList<String> getData(String testcaseName, String workshetname) throws IOException
	{
		// fileInputStream argument
		ArrayList<String> dataList = new ArrayList<String>();
		
		FileInputStream fs = new FileInputStream("C://Users//rahul//Documents//demodata.xlsx");
		workbook = new XSSFWorkbook(fs);

		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++)
		{
			//Iterate through the sheet to get the desired sheet
			if (workbook.getSheetName(i).equalsIgnoreCase(workshetname))
			{
				XSSFSheet desiredWorkSheet = workbook.getSheetAt(i);

				// Identify Testcases column by scanning the entire 1st row
				Iterator<Row> rows = desiredWorkSheet.iterator();	// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cellsInFirstRow = firstrow.cellIterator();	// row is collection of cells
				
				int count = 0;
				int testCaseColNum = 0;
				while (cellsInFirstRow.hasNext())
				{
					Cell value = cellsInFirstRow.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						testCaseColNum = count;
					}

					count++;
				}

				// once column is identified then scan entire testcase column to identify desired testcase row
				while (rows.hasNext())
				{
					Row eachrow = rows.next();

					if (eachrow.getCell(testCaseColNum).getStringCellValue().equalsIgnoreCase(testcaseName))
					{						
						// after you grab testcase row = pull all the data of that row and feed into test
						Iterator<Cell> cells = eachrow.cellIterator();
						while (cells.hasNext())
						{
							Cell c = cells.next();
							if (c.getCellTypeEnum() == CellType.STRING)
							{
								dataList.add(c.getStringCellValue());
							}
							else
							{
								dataList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return dataList;
	}
}