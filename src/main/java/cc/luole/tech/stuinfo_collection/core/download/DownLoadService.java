package cc.luole.tech.stuinfo_collection.core.download;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.luole.tech.stuinfo_collection.core.model.DownloadStu;
import cc.luole.tech.stuinfo_collection.core.service.DownloadStuService;
import cc.luole.tech.stuinfo_collection.util.FillComputerManager;
import cc.luole.tech.stuinfo_collection.util.Layouter;
import cc.luole.tech.stuinfo_collection.util.Writer;


@Service("downLoadService")  
@Transactional  
public class DownLoadService {

	@Autowired
	private DownloadStuService dao;  
   
  
    public void exportXLS(HttpServletResponse response) {  
  
        // 1.创建一个 workbook  
        HSSFWorkbook workbook = new HSSFWorkbook();  
  
        // 2.创建一个 worksheet  
        HSSFSheet worksheet = workbook.createSheet("student");  
  
        // 3.定义起始行和列  
        int startRowIndex = 0;  
        int startColIndex = 0;  
        
        String question=null;
        List<DownloadStu> list =this.getDatasource();
        if(list!=null && list.size()>0){
        	question=list.get(0).getdStuquestion();
        }
      
        // 4.创建title,data,headers  
        Layouter.buildReport(worksheet, startRowIndex, startColIndex,question);  
      
				
        // 5.填充数据  
        FillComputerManager.fillReport(worksheet, startRowIndex, startColIndex,list);  
  
        // 6.设置reponse参数  
        String fileName = "student.xls";  
        response.setHeader("Content-Disposition", "inline; filename="  
                + fileName);  
        // 确保发送的当前文本格式  
        response.setContentType("application/vnd.ms-excel");  
  
        // 7. 输出流  
        Writer.write(response, worksheet);  
  
    }  
  
    /** 
     * 读取报表 
     */  
/*    public List<Computer> readReport(InputStream inp) {  
  
        List<Computer> computerList = new ArrayList<Computer>();  
  
        try {  
            String cellStr = null;  
  
            Workbook wb = WorkbookFactory.create(inp);  
  
            Sheet sheet = wb.getSheetAt(0);// 取得第一个sheets  
  
            //从第四行开始读取数据  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
  
                Computer computer = new Computer();  
                Computer addComputer = new Computer();  
  
                Row row = sheet.getRow(i); // 获取行(row)对象  
                System.out.println(row);
                if (row == null) {  
                    // row为空的话,不处理  
                    continue;  
                }  
  
                for (int j = 0; j < row.getLastCellNum(); j++) {  
  
                    Cell cell = row.getCell(j); // 获得单元格(cell)对象  
  
                    // 转换接收的单元格  
                    cellStr = ConvertCellStr(cell, cellStr);  
  
                    // 将单元格的数据添加至一个对象  
                    addComputer = addingComputer(j, computer, cellStr);  
  
                }  
                // 将添加数据后的对象填充至list中  
                computerList.add(addComputer);  
            }  
  
        } catch (InvalidFormatException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (inp != null) {  
                try {  
                    inp.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            } else {  
                
            }  
        }  
        return computerList;  
  
    }  */
  
    /** 
     * 从数据库获得所有的Computer信息. 
     */  
    private List<DownloadStu> getDatasource() {  
        return dao.getListDownloadStu();  
    }  
  
    /** 
     * 读取报表的数据后批量插入 
     */  
    /*public int[] insertComputer(List<Computer> list) {  
        return dao.insertComputer(list);  
  
    } */ 
  
    /** 
     * 获得单元格的数据添加至computer 
     *  
     * @param j 
     *            列数 
     * @param computer 
     *            添加对象 
     * @param cellStr 
     *            单元格数据 
     * @return 
     */  
  /*  private Computer addingComputer(int j, Computer computer, String cellStr) {  
        switch (j) {  
        case 0:  
           // computer.setId(0);  
            break;  
        case 1:  
            computer.setBrand(cellStr);  
            break;  
        case 2:  
            computer.setCpu(cellStr);  
            break;  
        case 3:  
            computer.setGpu(cellStr);  
            break;  
        case 4:  
            computer.setMemory(cellStr);  
            break;  
        case 5:  
            computer.setPrice(new Double(cellStr).doubleValue());  
            break;  
        }  
  
        return computer;  
    }  */
  
    /** 
     * 把单元格内的类型转换至String类型 
     */  
    private String ConvertCellStr(Cell cell, String cellStr) {  
  
        switch (cell.getCellType()) {  
  
        case Cell.CELL_TYPE_STRING:  
            // 读取String  
            cellStr = cell.getStringCellValue().toString();  
            break;  
  
        case Cell.CELL_TYPE_BOOLEAN:  
            // 得到Boolean对象的方法  
            cellStr = String.valueOf(cell.getBooleanCellValue());  
            break;  
  
        case Cell.CELL_TYPE_NUMERIC:  
  
            // 先看是否是日期格式  
            if (DateUtil.isCellDateFormatted(cell)) {  
  
                // 读取日期格式  
                cellStr = cell.getDateCellValue().toString();  
  
            } else {  
  
                // 读取数字  
                cellStr = String.valueOf(cell.getNumericCellValue());  
            }  
            break;  
  
        case Cell.CELL_TYPE_FORMULA:  
            // 读取公式  
            cellStr = cell.getCellFormula().toString();  
            break;  
        }  
        return cellStr;  
    }  
}

