package cn.news.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class CreateExecl {
    //导出报表
    public static <T> void createExecl(List<T> list) throws IntrospectionException, InvocationTargetException, IllegalAccessException, IOException {
        //创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook.createSheet();
        //添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        //设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加表头内容
        HSSFCell headCell;
        Class<?> tClass = list.get(0).getClass();
        Field[] fields = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            ColumnName annotation = fields[i].getAnnotation(ColumnName.class);
            headCell = hssfRow.createCell(i);
            if (annotation != null) {
                headCell.setCellValue(annotation.getName());
            } else {
                headCell.setCellValue(fields[i].getName());
            }
            headCell.setCellStyle(cellStyle);
        }
        //集合长度size方法
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 1);
            T t = list.get(i);
            Class<?> aClass = t.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                //设置可以访问私有字段
                declaredFields[j].setAccessible(true);
                //获取get和set方法
                PropertyDescriptor descriptor = new PropertyDescriptor(declaredFields[j].getName(), aClass);
                Method getMethod = descriptor.getReadMethod();  //获得get方法
                Object object = getMethod.invoke(t);  //执行get方法返回一个object类型
                if (object != null) {
                    HSSFCell cell = hssfRow.createCell(j);
                    cell.setCellValue(object.toString());
                    cell.setCellStyle(cellStyle);
                }
            }
        }
        OutputStream outputStream = new FileOutputStream("E:/" + tClass.getSimpleName() + ".xls");
        workbook.write(outputStream);
        outputStream.close();
    }

    //导入报表
    public static <T> List<T> readExecl(String path, Class<T> cls) throws IOException, IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<T>();
        HSSFWorkbook workbook = null;
        //读取Excel文件
        InputStream inputStream = new FileInputStream(path);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        //循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            //循环行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                //实例化对象
                T t = cls.newInstance();
                //获取类中所有属性
                Field[] fid = cls.getDeclaredFields();
                //遍历属性
                for (int i = 0; i < fid.length; i++) {
                    HSSFCell cell = hssfRow.getCell(i);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    //设置可以访问私有字段
                    Field field = fid[i];
                    field.setAccessible(true);
                    //为属性设置内容
                    Object object = cell.getStringCellValue();
                    String name = field.getType().getName();
                    String value = cell.getStringCellValue();
                    if (name.equals("java.lang.Integer") || name.equals("int")) {
                        field.set(t, Integer.parseInt(value));
                    } else if (name.equals("java.lang.Double") || name.equals("double")) {
                        field.set(t, Double.parseDouble(value));
                    } else {
                        field.set(t, value);
                    }
                }
                list.add(t);   //添加到集合
            }
        }
        return list;
    }
    
    
    @Test
    public void poiTest01() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        Message book1 = new Message();
        book1.setVin("0001");
        book1.setMessagetime("2016-01-08");
        book1.setReceivetime("2016-05-06");
        book1.setMessagetype("车辆登入");
        book1.setMessagelength("123");
        book1.setMessage("{115v23v}");
        List<Message> list = new ArrayList<Message>();
        list.add(book1);
        CreateExecl.createExecl(list);
    }
    
    
}



