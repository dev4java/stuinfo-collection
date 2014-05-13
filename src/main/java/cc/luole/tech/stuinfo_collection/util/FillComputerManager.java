package cc.luole.tech.stuinfo_collection.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;

import cc.luole.tech.stuinfo_collection.core.model.DownloadStu;


public class FillComputerManager {

	public static void fillReport(HSSFSheet worksheet, int startRowIndex,  
            int startColIndex, List<DownloadStu> datasource) {  
  
        // Row offset  
        // startRowIndex += 2;//带报头  
	 	//startRowIndex ; 
        // Create cell style for the body  
        HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();        
        bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);  
        bodyCellStyle.setWrapText(false); //是否自动换行.  
  
        // Create body  
        //for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {  
          for (int i=0; i< datasource.size(); i++) {  
            // Create a new row  
            HSSFRow row = worksheet.createRow((short) i+1);  
  
            // Retrieve the id value  
            HSSFCell cell1 = row.createCell(startColIndex+0);  
            cell1.setCellValue(datasource.get(i).getdStuName());  
            cell1.setCellStyle(bodyCellStyle);  
  
            // Retrieve the brand value  
            HSSFCell cell2 = row.createCell(startColIndex+1);  
            cell2.setCellValue(datasource.get(i).getdStuSex());  
            cell2.setCellStyle(bodyCellStyle);  
  
            // Retrieve the model value  
            HSSFCell cell3 = row.createCell(startColIndex+2);  
            String sr=Util.toStringDate4SqlDate(datasource.get(i).getdStuBirthday());
            cell3.setCellValue(sr);  
            cell3.setCellStyle(bodyCellStyle);  
  
            // Retrieve the maximum power value  
            HSSFCell cell4 = row.createCell(startColIndex+3);  
            cell4.setCellValue(datasource.get(i).getdStuHujiAddress());  
            cell4.setCellStyle(bodyCellStyle);  
  
            // Retrieve the price value  
            HSSFCell cell5 = row.createCell(startColIndex+4);  
            cell5.setCellValue(datasource.get(i).getdStuAddress());  
            cell5.setCellStyle(bodyCellStyle);  
          
            // Retrieve the efficiency value  
            HSSFCell cell6 = row.createCell(startColIndex+5);  
            cell6.setCellValue(datasource.get(i).getdStuanswer());  
            cell6.setCellStyle(bodyCellStyle);  
            
           

            HSSFCell cell7 =  row.createCell(startColIndex + 6);  
            cell7.setCellValue(datasource.get(i).getdStumname());  
            cell7.setCellStyle(bodyCellStyle);  
      
            HSSFCell cell8 =  row.createCell(startColIndex + 7);  
            cell8.setCellValue(datasource.get(i).getdStumcompany());  
            cell8.setCellStyle(bodyCellStyle);  
      
            HSSFCell cell9 =  row.createCell(startColIndex + 8);  
            cell9.setCellValue(datasource.get(i).getdStumjobTitle());  
            cell9.setCellStyle(bodyCellStyle);  
      
            HSSFCell cell10 =  row.createCell(startColIndex + 9);  
            cell10.setCellValue(datasource.get(i).getdStumtelphone());  
            cell10.setCellStyle(bodyCellStyle);  
      
            HSSFCell cell11 =  row.createCell(startColIndex + 10);  
            cell11.setCellValue(datasource.get(i).getdStufname());  
            cell11.setCellStyle(bodyCellStyle);  
      
            HSSFCell cell12 =  row.createCell(startColIndex + 11);  
            cell12.setCellValue(datasource.get(i).getdStufcompany());  
            cell12.setCellStyle(bodyCellStyle); 
            
            HSSFCell cell13 =  row.createCell(startColIndex + 12);  
            cell13.setCellValue(datasource.get(i).getdStufjobTitle());  
            cell13.setCellStyle(bodyCellStyle); 
            
            HSSFCell cell14 =  row.createCell(startColIndex + 13);  
            cell14.setCellValue(datasource.get(i).getdStuftelphone());  
            cell14.setCellStyle(bodyCellStyle); 
        }  
    }  
}
