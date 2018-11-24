package cn.happy.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmy on 2018/8/13.
 */
//鐢熸垚瀹炰綋鐨勫伐鍏风被
public class GenEntity {
	//瀹炰綋绫讳繚瀛樼殑鍖呭悕
    private String package_url="cn.happy.entity";//鍖呯殑璺緞
    //绫昏緭鍑鸿矾寰�
    

   // private String tablename = "grade";//琛ㄥ悕
    private String[] colnames; // 鍒楀悕鏁扮粍
    private String[] colTypes; //鍒楀悕绫诲瀷鏁扮粍
    private String[] colDescs; //鍒楀悕鎻忚堪鏁扮粍
    private int[] colSizes; //鍒楀悕澶у皬鏁扮粍
    private boolean f_util = true; // 鏄惁闇�瑕佸鍏ュ寘java.util.*
    private boolean f_sql = false; // 鏄惁闇�瑕佸鍏ュ寘java.sql.*

    //鏁版嵁搴撹繛鎺�
    private static final String URL ="jdbc:mysql:///smbms?useUnicode=true&characterEncoding=utf-8";
    private static final String NAME = "root";
               private static final String PASS = "root";
               private static final String DRIVER ="com.mysql.jdbc.Driver";

               //01.鏍规嵁杩炴帴瀵硅薄鑾峰彇鍒拌〃鍚嶇殑闆嗗悎锛屼繚瀛樺埌涓�涓狶ist<String>闆嗗悎涓�
               public List<String> getTableNameByCon(Connection con) {
                   List<String> list=new ArrayList<String>();//鍑嗗涓�涓┖鐨勯泦鍚堝鍣�
                   try {
                       //鎷垮埌涓�涓暟鎹簱鐨勫厓鏁版嵁淇℃伅  
                       DatabaseMetaData meta = con.getMetaData();
                       //鑾峰彇鎸囧畾鏁版嵁搴撳璞′腑鎵�鏈夌殑琛ㄧ殑鍚嶇О锛屼綋鐜板舰鎬佹槸璇诲彇鍣ㄧ殑褰㈠紡
    	   ResultSet rs = meta.getTables(null, null, null,  
    	     new String[] { "TABLE" });  
    	   while (rs.next()) {
    		 //鍘昏幏鍙杢ablename  娌¤凯浠ｅ埌涓�椤癸紝閮芥槸涓�涓〃鍚�
    		 String tname=rs.getString(3);
    	     System.out.println("琛ㄥ悕锛�" +tname );  
    	     list.add(tname);
    	     System.out.println("琛ㄦ墍灞炵敤鎴峰悕锛�" + rs.getString(2));  
    	     System.out.println("------------------------------");  
    	   }  
    	   //con.close();  
    	   } catch (Exception e) {  
    	   /*try {  
    	    // con.close();  
    	   } catch (SQLException e1) {  
    	     e1.printStackTrace();  
    	   }  */
    	   e.printStackTrace();  
    	   }  
    	   return list;
    	}  
    
    
    /*
     * 鏋勯�犲嚱鏁�
     */
    public GenEntity(){
        //鍒涘缓杩炴帴
        Connection con = null;
        //鏌ヨ鐢熸垚瀹炰綋绫荤殑琛�
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            //杩炴帴瀵硅薄鐨勮幏鍙�
            con = DriverManager.getConnection(URL,NAME,PASS);
            //鍘荤鎺㈠簳灞備竴浜涘唴瀹� 绫诲瀷鍏冩暟鎹瘑涓嶅彲鍒�
            DatabaseMetaData dbmd=con.getMetaData();
            
            List<String> list = getTableNameByCon(con);
            for (String tablename : list) {
            	//鐩存帴鍙栬〃瀛楁
                ResultSet rs = dbmd.getColumns(null, "%", tablename, "%");
                System.out.println("琛ㄥ悕锛�"+tablename+"\t\n琛ㄥ瓧娈典俊鎭細");
                rs.last();
                int size = rs.getRow();
                rs.beforeFirst();
                colnames = new String[size];
                colTypes = new String[size];
                colSizes = new int[size];
                colDescs = new String[size];
                int i=0;
                while(rs.next()){
                    System.out.println(rs.getString("COLUMN_NAME")+"----"+rs.getString("REMARKS")+"----"+rs.getString("TYPE_NAME"));
                    colnames[i] = rs.getString("COLUMN_NAME");
                    colTypes[i] = rs.getString("TYPE_NAME");
                    colDescs[i] = rs.getString("REMARKS");
                    colSizes[i] = rs.getInt("COLUMN_SIZE");
                    if(colTypes[i].equalsIgnoreCase("datetime")){
                        f_util = true;
                    }
                    if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
                        f_sql = true;
                    }
                    i++;
                }
                String content = parse(colnames,colTypes,colSizes,tablename);

                try {
                    File directory = new File("");
                     String outputPath ="D:\\IDear\\workspace\\Y2169\\01Mybatis\\src\\main\\java\\cn\\happy\\entity";
                    outputPath+="\\"+initcap(tablename) + ".java";
                    FileWriter fw = new FileWriter(outputPath);
                    System.out.println("杈撳嚭璺緞锛�"+outputPath);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(content);
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
			}
            
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            /*try {
              //  con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }

    /**
     * 鍔熻兘锛氱敓鎴愬疄浣撶被涓讳綋浠ｇ爜
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes,String tablename) {
        StringBuffer sb = new StringBuffer();

        //鍒ゆ柇鏄惁瀵煎叆宸ュ叿鍖�
        sb.append("package "+package_url+";\r\n");
        if(f_util){
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append("import java.sql.*;\r\n");
        }
        sb.append("\r\n");
        //娉ㄩ噴閮ㄥ垎
        sb.append("   /**\r\n");
        sb.append("    * "+tablename+" entity\r\n");
        sb.append("    * @author Happy\r\n");
        sb.append("    * @date"+ DateFormatUtils.format(new java.util.Date(), "yyyy-MM-dd hh:mm")+" \r\n");
        sb.append("    */ \r\n");
        //瀹炰綋閮ㄥ垎
        sb.append("\r\npublic class " + initcap(tablename) + "{\r\n");
        processAllAttrs(sb);//灞炴��
        processAllMethod(sb);//get set鏂规硶
        sb.append("}\r\n");

        return sb.toString();
    }

    /**
     * 鍔熻兘锛氱敓鎴愭墍鏈夊睘鎬�
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            sb.append("\t /**"+colDescs[i]+"**/\r\n");
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i],colSizes[i]) + " " + colnames[i] + ";\r\n");
        }

    }

    /**
     * 鍔熻兘锛氱敓鎴愭墍鏈夋柟娉�
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            sb.append("\r\n\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i],colSizes[i]) + " " +
                    colnames[i] + "){\r\n");
            sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\r\n\tpublic " + sqlType2JavaType(colTypes[i],colSizes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }

    }

    /**
     * 鍔熻兘锛氬皢杈撳叆瀛楃涓茬殑棣栧瓧姣嶅強涓嬪垝绾垮悗鐨勫瓧姣嶆敼鎴愬ぇ鍐�
     * @param str
     * @return
     */
    private String initcap(String str) {

        String[] arr= str.split("_");
        String tempStr ="";
        if(arr.length>0){
            for(String st:arr){
                char[] c = st.toCharArray();
                if(c[0] >= 'a' && c[0] <= 'z'){
                    c[0] = (char)(c[0] - 32);
                }
                tempStr += new String(c);
            }
        }

        return tempStr;
    }

    /**
     * 鍔熻兘锛氬皢杈撳叆瀛楃涓茬殑涓嬪垝绾垮悗鐨勫瓧姣嶆敼鎴愬ぇ鍐�
     * @param str
     * @return
     */
    private String initcapCol(String str) {
        String[] arr= str.split("_");
        String tempStr ="";
        if(arr.length>1){
            int i=0;
            for(String st:arr){
                if(i>0){
                    char[] c = st.toCharArray();
                    if(c[0] >= 'a' && c[0] <= 'z'){
                        c[0] = (char)(c[0] - 32);
                    }
                    tempStr += new String(c);
                }else{
                    tempStr += st;
                }
                i++;
            }
        }else{
            tempStr = str;
        }
        return tempStr;
    }

    /**
     * 鍔熻兘锛氳幏寰楀垪鐨勬暟鎹被鍨�
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType,int typeSize) {

        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("int")){
            if(typeSize>=10){
                return "Integer";
            }else{
                return "Integer";
            }
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney") || sqlType.equalsIgnoreCase("double")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("timestamp") || sqlType.equalsIgnoreCase("date")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "BigInteger";
        }

        return null;
    }

    /**
     * 鍑哄彛
     * TODO
     * @param args
     */
    public static void main(String[] args) {

        new GenEntity();
    }

    //鏍￠獙绫诲瀷

}
