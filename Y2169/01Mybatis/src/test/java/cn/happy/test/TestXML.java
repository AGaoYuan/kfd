package cn.happy.test;

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
 * @Date: 2018/10/19 10:13
 * @Description:
 */
public class TestXML {
    //定义文档树
    static Document document;
    //定义根节点
    static Element root;
    //定义扫描仪
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========针对XML文件的增删改查=======");
        System.out.println("========1.查询=======");
        System.out.println("========2.增加=======");
        System.out.println("========3.修改=======");
        System.out.println("========4.删除=======");
        System.out.println("========请选择=======");

        //XMl文件路径
        String path = "D:\\IDear\\workspace\\Y2169\\01Mybatis\\src\\main\\resources\\school.xml";
        try {
            //获取文档树和根节点
            getDocument(path);
            int choose = in.nextInt();
            switch (choose) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除该节点，不可自身删除，只能使用父节点删除
     *
     * @param path
     * @throws Exception
     */
    private static void delete(String path) throws Exception {
        Iterator<Element> classes = root.elementIterator();
        while (classes.hasNext()) {
            Element item = classes.next();
            if (item.attributeValue("name").equals("三年级")) {
                classes.remove();
            }
        }
        if (saveXML(path)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * 查询到该节点进行修改，setAttributeValue()
     *
     * @param path
     * @throws Exception
     */
    private static void update(String path) throws Exception {
        Iterator<Element> clazz = root.elementIterator();
        while (clazz.hasNext()) {
            Element school = clazz.next();
            if (school.attributeValue("name").equals("三年级")) {
                school.setAttributeValue("name", "四年级");
            }
        }
        if (saveXML(path)) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    /**
     * 创建一个节点和子节点
     *
     * @param path
     * @throws Exception
     */
    private static void create(String path) throws Exception {
        //一级节点
        Element aClass = root.addElement("class");
        aClass.addAttribute("name", "三年级");
        aClass.addAttribute("address", "三楼");
        //一级节点的子节点
        Element student = aClass.addElement("student");
        student.addAttribute("name", "小红");
        student.addAttribute("age", "18");

        //判断是否添加成功
        if (saveXML(path)) {
            System.out.println("新增成功！");
        } else {
            System.out.println("新增失败！");
        }
    }

    /**
     * 通过IO的方式修改XML文件
     *
     * @param path
     * @return Boolean
     * @throws Exception
     */
    private static boolean saveXML(String path) throws Exception {
        //定义规范XML文件格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        //定义输出流
        XMLWriter writer = new XMLWriter(new FileOutputStream(path), format);
        //写入到XML文件中
        writer.write(document);

        return true;
    }

    /**
     * 查询XML文件中的所有节点
     */
    private static void findAll() {
        Iterator<Element> clazz = root.elementIterator();
        //循环一级节点
        while (clazz.hasNext()) {
            Element school = clazz.next();
            System.out.println("年级名称为：" + school.attributeValue("name"));
            System.out.println("年级位置为：" + school.attributeValue("address"));
            Iterator<Element> students = school.elementIterator();
            //循环一级节点下的子节点
            while (students.hasNext()) {
                Element stu = students.next();
                System.out.println("学生姓名为：" + stu.attributeValue("name"));
                System.out.println("学生年龄为：" + stu.attributeValue("age"));
                if (!stu.getTextTrim().equals("")) {
                    System.out.println("学生描述为：" + stu.getTextTrim());
                }
            }
        }
    }

    /**
     * 获取解析器
     *
     * @param path
     * @throws Exception
     */
    private static void getDocument(String path) throws Exception {
        //获取解析器
        SAXReader reader = new SAXReader();
        //获取文档树
        document = reader.read(path);
        //获取根节点
        root = document.getRootElement();
    }


}
