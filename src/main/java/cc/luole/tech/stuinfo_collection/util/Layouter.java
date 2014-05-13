package cc.luole.tech.stuinfo_collection.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;




public class Layouter {

	/** 
     * 创建报表 
     */  
    public static void buildReport(HSSFSheet worksheet, int startRowIndex,  
            int startColIndex,String question) {  
        // 设置列的宽度  
        worksheet.setColumnWidth(0, 5000);  
        worksheet.setColumnWidth(1, 5000);  
        worksheet.setColumnWidth(2, 5000);  
        worksheet.setColumnWidth(3, 5000);  
        worksheet.setColumnWidth(4, 5000);  
        worksheet.setColumnWidth(5, 10000);
        worksheet.setColumnWidth(6, 5000);  
        worksheet.setColumnWidth(7, 5000);  
        worksheet.setColumnWidth(8, 5000);  
        worksheet.setColumnWidth(9, 5000);  
        worksheet.setColumnWidth(10, 5000);  
        worksheet.setColumnWidth(11, 5000);
        worksheet.setColumnWidth(12, 5000);
        worksheet.setColumnWidth(13, 5000);
        worksheet.setColumnWidth(14, 5000);
  
       // buildTitle(worksheet, startRowIndex, startColIndex);  
  
        buildHeaders(worksheet, startRowIndex, startColIndex,question);  
  
    }  
  
    /** 
     * 创建报表标题和日期 
     */  
    private static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex) {  
        // 设置报表标题字体  
        Font fontTitle = worksheet.getWorkbook().createFont();  
        fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        fontTitle.setFontHeight((short) 280);  
  
        // 标题单元格样式  
        HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();  
        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);  
        cellStyleTitle.setWrapText(true);  
        cellStyleTitle.setFont((HSSFFont) fontTitle);  
  
        // 报表标题  
        HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);  
        rowTitle.setHeight((short) 500);  
        HSSFCell cellTitle = rowTitle.createCell(startColIndex);  
        cellTitle.setCellValue("student Report!");  
        cellTitle.setCellStyle(cellStyleTitle);  
  
        // 合并区域内的报告标题  
        worksheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));  
  
        // date header  
        HSSFRow dateTitle = worksheet.createRow((short) startRowIndex + 1);  
        HSSFCell cellDate = dateTitle.createCell(startColIndex);  
        cellDate.setCellValue("这个报表创建于: " + DateUtils.getNowTime());  
    }  
  
    /** 
     * 创建表头 
     */  
    private static void buildHeaders(HSSFSheet worksheet, int startRowIndex,  
            int startColIndex,String question) {  
        // Header字体  
       Font font = worksheet.getWorkbook().createFont();
    	
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  
  
        // 单元格样式  
        HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();  
       // headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);  
       // headerCellStyle.setFillPattern(CellStyle.FINE_DOTS);  
        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);  
        headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        headerCellStyle.setWrapText(true);  
        headerCellStyle.setFont((HSSFFont) font);  
        headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);  
  
        // 创建字段标题  
        HSSFRow rowHeader = worksheet.createRow((short) startRowIndex);  //+2 带报头 
        rowHeader.setHeight((short) 500);  
  
        HSSFCell cell1 = rowHeader.createCell(startColIndex + 0);  
        cell1.setCellValue("姓名");  
        cell1.setCellStyle(headerCellStyle);  
  
        HSSFCell cell2 = rowHeader.createCell(startColIndex + 1);  
        cell2.setCellValue("性别");  
        cell2.setCellStyle(headerCellStyle);  
  
        HSSFCell cell3 = rowHeader.createCell(startColIndex + 2);  
        cell3.setCellValue("出生日期");  
        cell3.setCellStyle(headerCellStyle);  
  
        HSSFCell cell4 = rowHeader.createCell(startColIndex + 3);  
        cell4.setCellValue("户籍");  
        cell4.setCellStyle(headerCellStyle);  
  
        HSSFCell cell5 = rowHeader.createCell(startColIndex + 4);  
        cell5.setCellValue("家庭地址");  
        cell5.setCellStyle(headerCellStyle);  
  
        HSSFCell cell6 = rowHeader.createCell(startColIndex + 5);  
        cell6.setCellValue(question);  
        cell6.setCellStyle(headerCellStyle); 

        HSSFCell cell7 = rowHeader.createCell(startColIndex + 6);  
        cell7.setCellValue("母亲");  
        cell7.setCellStyle(headerCellStyle);  
  
        HSSFCell cell8 = rowHeader.createCell(startColIndex + 7);  
        cell8.setCellValue("工作单位");  
        cell8.setCellStyle(headerCellStyle);  
  
        HSSFCell cell9 = rowHeader.createCell(startColIndex + 8);  
        cell9.setCellValue("工作职务");  
        cell9.setCellStyle(headerCellStyle);  
  
        HSSFCell cell10 = rowHeader.createCell(startColIndex + 9);  
        cell10.setCellValue("手机号");  
        cell10.setCellStyle(headerCellStyle);  
  
        HSSFCell cell11 = rowHeader.createCell(startColIndex + 10);  
        cell11.setCellValue("父亲");  
        cell11.setCellStyle(headerCellStyle);  
  
        HSSFCell cell12 = rowHeader.createCell(startColIndex + 11);  
        cell12.setCellValue("工作单位");  
        cell12.setCellStyle(headerCellStyle); 
        
        HSSFCell cell13 = rowHeader.createCell(startColIndex + 12);  
        cell13.setCellValue("工作职务");  
        cell13.setCellStyle(headerCellStyle); 
        
        HSSFCell cell14 = rowHeader.createCell(startColIndex + 13);  
        cell14.setCellValue("手机号");  
        cell14.setCellStyle(headerCellStyle); 
        
  
    }  
}
