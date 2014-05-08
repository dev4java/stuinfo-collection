package cc.luole.tech.stuinfo_collection.util;


import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.*;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 生成excel文档工具
 *
 * @author bfhong
 */
public class ExcelUtil {


    public static  ByteArrayOutputStream madeSingleSheetExcel(List data, Class entityType, List<ExcelUtilFormat> format, String sheetName) throws Exception {
        //创建小字体：Arial,大小为8号,非粗体，非斜体
        WritableFont thFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

        WritableCellFormat thFormat = new WritableCellFormat(thFont);
        thFormat.setAlignment(Alignment.CENTRE);//居中加粗

        WritableCellFormat bodyFormat = new WritableCellFormat();
        bodyFormat.setAlignment(Alignment.CENTRE);
        WritableCell label;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        WritableSheet sheet = workbook.createSheet(sheetName, 0);
        //设置单元格大小，并生成标题
        for (int i =0;i< format.size(); i ++) {
            ExcelUtilFormat f = format.get(i);
            sheet.setColumnView(i, f.getWidth());
            label = new Label(i, 0, f.getTh(), thFormat);
            sheet.addCell(label);

        }
        //逐行写入数据
        for (int i = 0; i < data.size(); i++) {
            Object o = data.get(i);
            //逐列写入数据
            for (int j =0;j< format.size(); j ++) {
                ExcelUtilFormat f = format.get(j);
                //通过反射和递归获取最终值
                String value=getFinalValue(entityType,o,0,f.getField().split("\\."));
                label = new Label(j, i+1, value, bodyFormat);
                sheet.addCell(label);
            }
        }
        workbook.write();
        workbook.close();
        return os;

    }
    private static String getFinalValue(Class entityType,Object o,int depth,String[] splitFields) throws Exception {
        Field f=entityType.getDeclaredField(splitFields[depth]);
        Class fieldClass=f.getType();
        if(!f.isAccessible()){
                f.setAccessible(true);
        }
        if (depth < splitFields.length-1){

            return getFinalValue(fieldClass,f.get(o),depth+1,splitFields);
        }else{
            String value;
             Object target= f.get(o);
            if(target instanceof Date){
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                value=format.format(target);
            }else{
                if(target ==null){
                    value="";
                }else{
                    value=target.toString();
                }
            }
            return value;
        }

    }

    
}

