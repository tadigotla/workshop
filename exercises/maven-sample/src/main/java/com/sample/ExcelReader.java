package com.sample;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.io.*;

public class ExcelReader {

    public static void main(String[] args) {
        try {
            String[] listOfData = null;
            String[] listOfOne = null;

            InputStream ExcelFileToRead = new FileInputStream("/projects/workshop/rich_text_stress.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet wbsheet = wb.getSheetAt(0);
            XSSFRow newRow = null;
            XSSFCell nxtcell = null;
            Iterator rows = wbsheet.rowIterator();
            while (rows.hasNext()) {
                newRow = (XSSFRow) rows.next();
                Iterator cells = newRow.cellIterator();
                while (cells.hasNext()) {
                    nxtcell = (XSSFCell) cells.next();
                    System.out.println(nxtcell);
                }
            }

        } catch (Exception ie) {
            ie.printStackTrace(System.out);
        }

    }
}