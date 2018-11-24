package cn.happy.testXMLDOM4J;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/12 9:48
 * @Description:
 */
public class TestXMLDOM4J {

        static Document document;
        static Element root;
        static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("========针对XML文件的增删改查=======");
        System.out.println("========1.查询=======");
        System.out.println("========2.增加=======");
        System.out.println("========3.修改=======");
        System.out.println("========4.删除=======");
        System.out.println("========请选择=======");

        String path = "D:\\IDear\\workspace\\Y2169\\01Mybatis\\src\\main\\resources\\school.xml";
        getDocument(path);
        int choose = in.nextInt();
        switch(choose){
            case 1:
                findAll();
                break;
            case 2:
                create(path);
                break;
            case 3:
                update(path);
                break;
            case 4:
                delete(path);
                break;
        }

    }

    /**
     * 删除XML文件中的节点
     * @param path
     * @throws Exception
     */
    private static void delete(String path) throws Exception {
        Iterator<Element> classes = root.elementIterator();
        while(classes.hasNext()){
            Element item = classes.next();
            if (item.attributeValue("name").equals("3年级")){
                classes.remove();
            }
        }
        if(saveXML(path)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

    }

    /**
     * 修改XMl文件
     * @param path
     * @throws Exception
     */
    private static void update(String path) throws Exception {
        Iterator<Element> classes = root.elementIterator();
        while(classes.hasNext()){
            Element item = classes.next();
            if (item.attributeValue("name").equals("3年级")){
                item.setAttributeValue("name","4年级");
            }
        }
        if(saveXML(path)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

    }

    /**
     * 创建一个XML文件节点
     * @param path
     * @throws Exception
     */
    private static void create(String path) throws Exception {
        Element aClass = root.addElement("class");
        aClass.addAttribute("name","3年级");
        aClass.addAttribute("address","3楼");
        Element student = aClass.addElement("student");
        student.addAttribute("name","小红");
        student.addAttribute("age","15");

        if(saveXML(path)){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }

    }

    /**
     * 增删改写入到XML文件
     * @param path
     * @return
     * @throws Exception
     */
    private static boolean saveXML(String path) throws Exception {

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream(path),format);
        writer.write(document);

        return true;
    }

    /**
     * 查询XML文件
     */
    private static void findAll() {
        Iterator<Element> clazz = root.elementIterator();
        while(clazz.hasNext()){
            Element school = clazz.next();
            System.out.println("年级名称"+school.attribute("name"));
            System.out.println("年级位置"+school.attribute("address"));
            Iterator<Element> students = school.elementIterator();
            while(students.hasNext()){
                Element student = students.next();
                System.out.println("学生名称"+student.attribute("name"));
                System.out.println("学生年龄"+student.attribute("age"));
                if (!student.getTextTrim().equals("")){
                    System.out.println("学生描述"+student.getTextTrim());
                }
            }
            
        }
    }

    /**
     * 获取文档对象
     * @param path
     * @throws Exception
     */
    private static void getDocument(String path) throws Exception {
        //获取解析器
        SAXReader reader = new SAXReader();
        //获取文档树
        document= reader.read(path);
        //获取根节点
        root = document.getRootElement();

    }



}
