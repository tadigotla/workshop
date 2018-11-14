package com.sample;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.io.*;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelReader {

    public static Map<String, Object> readExcel(File file){
        Map result = new HashMap<String, Object>();
        try {
            String[] listOfData = null;
            String[] listOfOne = null;

            InputStream ExcelFileToRead = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet wbsheet = wb.getSheetAt(0);
            XSSFRow newRow = null;
            XSSFCell nxtcell = null;
            Iterator rows = wbsheet.rowIterator();
            int rowNum = 0;
            while (rows.hasNext()) {

                List row = new ArrayList();
                newRow = (XSSFRow) rows.next();
                Iterator cells = newRow.cellIterator();
                while (cells.hasNext()) {
                    nxtcell = (XSSFCell) cells.next();
                    row.add(nxtcell);
                    //System.out.println(nxtcell);
                }
                result.put(String.valueOf(rowNum), row);
                rowNum++;
            }
        } catch (Exception ie) {
            ie.printStackTrace(System.out);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> result = readExcel(new File("/projects/workshop/rich_text_stress.xlsx"));
        System.out.println("The data read is "+ result);
    }
}