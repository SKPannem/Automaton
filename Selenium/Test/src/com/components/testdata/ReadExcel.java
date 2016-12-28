package com.components.testdata;

import java.awt.List;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



public class ReadExcel {
	public HashMap< String, ArrayList > properties = new HashMap< String, ArrayList >();
	public HashMap< String, String > fileDetails = new HashMap< String, String >();
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a object of ReadWriteExcelProperties
		ReadExcel readExcelData = new ReadExcel();
 
        // Call readExcelFile() method by passing it location of xls
        // This method will load keys and values from xls to HashMap
		//readExcelData.readExcelFile("D:/TestData/Login.xls");
		readExcelData.loadExcelByKey();
       
	}*/

	public Object loadExcelByKey(String className,String filePath,String key){
		int icnt;
		Object obj=new Object();
		try{
			ArrayList alstSetValues = new ArrayList();
			if (!fileDetails.containsKey(filePath)){
				readExcelFile(filePath);
				fileDetails.put(filePath, filePath);
			}
			alstSetValues = properties.get(key);
			System.out.println(alstSetValues);
			//loadExcelByKey(className,alstSetValues);
			
			Class<?> c = Class.forName("com.components.testdata." + className);
			obj =c.newInstance();
			System.out.println("size:"+alstSetValues.size());
			for(icnt=0;icnt<alstSetValues.size();icnt=icnt+1){
				Field[] fields = c.getDeclaredFields();
				fields[icnt].setAccessible(true);
				fields[icnt].set(obj, alstSetValues.get(icnt));
				System.out.println("Field-->"+fields[icnt].getName()+ "Value-->"+alstSetValues.get(icnt));
						
			}
		
		}catch (Exception x) {
			x.getStackTrace();
		}
		return obj;
	}
	public void readExcelFile(String fileName)     { 
		
        HSSFCell cell1 =null;
        HSSFCell cell2 =null;
        int iCnt;        
        Boolean bStartRow = false;
        String key = "";
        try{                      

            // Create a FileInputStream by passing the location of excel
            FileInputStream input = new FileInputStream(fileName);         
 
            // Create a POIFSFileSystem by passing it FileInputStream 
            POIFSFileSystem fileSystem = new POIFSFileSystem(input);         
 
            // Create a Workbook using HSSFWorkbook object
            HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
 
            // get the sheet at location 0 by calling 
            // getSheetAt() method of the Workbook
            HSSFSheet sheet = workBook.getSheetAt(0);   
 
            // Create a Iterator object by calling 
            // sheet's method as rowIterator() which 
            // will return back us with Iterator, which will 
            // loop through each row.
            Iterator rowIterator = sheet.rowIterator();   
            ArrayList alstValues = new ArrayList();
            // Iterating row by row
            while(rowIterator.hasNext()){   
            	
            	iCnt = 0;
            	
                // Creating a reference to row by calling 
                // next method of the iterator
                HSSFRow row = (HSSFRow) rowIterator.next(); 
                
                // Creating a iterator which will contain each
                // cell info related to that particular row
                Iterator cellIterator = row.cellIterator(); 

                // Iterating over each cell
                while(cellIterator.hasNext()){ 
                    
                    if (iCnt == 0) {
                    	 // Creating a cell by calling next method of the iterator 
                        cell1 = (HSSFCell) cellIterator.next();
	                    // extracting key from the xls
	                    key = cell1.getRichStringCellValue().toString();
	                    bStartRow = true;
	                    iCnt = 1;
                    }
                    
                    // if not than create yet another cell from the
                    // cell iterator by calling its next method
                    cell2 = (HSSFCell) cellIterator.next();
 
                    // extracting values from the cell2 
                    String value = cell2.getRichStringCellValue().toString();
 
                    // storing each properties into the HashMap
                    //if (properties.get(key)==null){
                    if (bStartRow){
                    	properties.put(key, new ArrayList());
                    	bStartRow = false;
                    }
	                properties.get(key).add(value);          
  
                }     
                
            }     
        }
 
        catch (Exception e){
 
            System.out.println("No Such Element Exception Occured ..... ");
 
            e.printStackTrace();
 
        }      

    }
	
}
