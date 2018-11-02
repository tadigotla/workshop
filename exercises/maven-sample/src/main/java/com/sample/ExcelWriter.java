package com.sample;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.io.*;
import java.util.*;
//import org.apache.poi.ss.usermodel.CellTypes;

public class ExcelWriter {
    public static void main(String[] args){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("Employee1", "42");
        data.put("Employee2", "22");
        data.put("Employee3", "25");
        data.put("Employee4", "31");
        data.put("Employee5", "49");

        try{
            FileOutputStream fi = new FileOutputStream("/projects/workshop/exercises/maven-sample/employees.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook();
            System.out.println("Writing to Excel File " );
            XSSFSheet sheet = wb.createSheet("Sheet One");
            int i = 0;
            for(Map.Entry<String, String> entry: data.entrySet()){
                XSSFRow row = sheet.createRow(i);
                XSSFCell cell = row.createCell(0);
                cell.setCellValue(entry.getKey());
                cell = row.createCell(1);
                cell.setCellValue(entry.getValue());
                i++;
            }

            wb.write(fi);
            fi.close();

        }catch(Exception ie){
            ie.printStackTrace(System.out);
        }
    }
}