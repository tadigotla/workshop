package com.sample

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell

import org.apache.poi.ss.usermodel.*
import java.util.Iterator
import java.io.*

import java.util.Map
import java.util.ArrayList
import java.util.HashMap
import java.util.List

public class ExcelClient {

    public static Map readExcel(File file){
        Map result = new HashMap()
        try {
            def listOfData = []
            def listOfOne = []

            def ExcelFileToRead = new FileInputStream(file)
            def wb = new XSSFWorkbook(ExcelFileToRead)
            def wbsheet = wb.getSheetAt(0)
            def rows = wbsheet.rowIterator()

            rows.eachWithIndex{ onerow,index ->
                def row = []
                onerow.cellIterator().each {onecell ->
                    println onecell
                    row.add(onecell)
                }
                result.put(index, row)
            }
        } catch (Exception ie) {
            ie.printStackTrace(System.out);
        }
        return result;
    }

    public static void main(String[] args){
        println "Hello World";
        Map result = readExcel(new File("/projects/workshop/rich_text_stress.xlsx"));
    }

}