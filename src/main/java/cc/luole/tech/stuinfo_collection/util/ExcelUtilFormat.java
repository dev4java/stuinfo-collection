package cc.luole.tech.stuinfo_collection.util;

/* ExcelUtil格式封装
* @author bfhong
*/
public class ExcelUtilFormat {
   private String th;/**标题*/
   private int width;/**列宽*/
   private String field;/**字段映射*/

   public ExcelUtilFormat(String th, int with, String field) {
       this.th = th;
       this.width = with;
       this.field = field;
   }

   public String getTh() {
       return th;
   }

   public int getWidth() {
       return width;
   }

   public String getField() {
       return field;
   }
}
