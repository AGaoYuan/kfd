package cn.happy.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestFile {

    public static void main(String[] args) throws IOException {
        System.out.println("1.创建文件");
        System.out.println("2.创建文件夹");
        System.out.println("3.修改文件名称");
        System.out.println("4.删除文件");
        System.out.println("5.显示文件夹下的所有文件");
        showFisrtMeun();
    }

    //定义记录日志对象
    private static Logger logger = LoggerFactory.getLogger(TestFile.class);

    //定义扫描器
    static Scanner in = new Scanner(System.in);

    private static void showFisrtMeun() throws IOException {
        System.out.println("请输入：");
        int count = in.nextInt();
        switch (count){
            case 1:
                System.out.println("请输入文件名称：");
                String fileName = in.next();
                CreateFile(fileName);
                break;
            case 2:
                System.out.println("请输入文件夹名称：");
                String DirName = in.next();
                CreateDirectory(DirName);
                break;
            case 3:
                System.out.println("请输入原文件名称：");
                String oldName = in.next();
                System.out.println("请输入新文件名称：");
                String newName = in.next();
                changeFile(oldName,newName);
                break;
            case 4:
                System.out.println("请输入文件名称：");
                String deleteName = in.next();
                deleteFile(deleteName);
                break;
            case 5:
                System.out.println("请输入路径名称：");
                String FindFile = in.next();
                showListFile(FindFile);
                break;
        }

    }

    /**
     * 在E盘的根目录下创建文件夹
     * @param dirName
     */
    private static void CreateDirectory(String dirName) throws IOException {
        //创建File对象
        File file = new File("E:/"+dirName);
        if (!file.exists()){
            file.mkdirs();
            logger.debug("创建文件夹成功！");
        }else{
            logger.debug("文件夹已存在！");
        }
        showFisrtMeun();
    }

    /**
     * 查看该路径下的所有文件和文件夹
     * @param FindFile
     * @throws IOException
     */
    private static void showListFile(String FindFile) throws IOException {
        //创建File对象
        File file = new File(FindFile);
        //返回全部文件数组
        File[] files = file.listFiles();
        //统计文件个数
        int FileCount = 0;
        //统计文件夹个数
        int DirectoryCount = 0;
        for (File item:files) {
            //判断是否为文件类型
            if (item.isFile()){
                logger.debug("文件为："+item.getName());
                FileCount++;
            //判断是否为文件夹类型
            }
            if (item.isDirectory()){
                logger.debug("文件夹为："+item.getName());
                DirectoryCount++;
            }
        }
        logger.debug("文件个数为："+FileCount);
        logger.debug("文件夹个数为："+DirectoryCount);
        //返回当前路径
        logger.debug("当前的绝对路径为："+file.getAbsolutePath());
        showFisrtMeun();
    }

    /**
     * 修改该文件的名称
     * @param oldName
     * @param newName
     */
    private static void changeFile(String oldName, String newName) {
        //创建File对象
        File file = new File("E:/"+oldName);
        //创建File对象
        File newfile = new File("E:/"+newName);
        file.renameTo(newfile);

    }

    /**
     * 删除该文件
     * @param deleteName
     * @throws IOException
     */
    private static void deleteFile(String deleteName) throws IOException {
        //创建File对象
        File file = new File("E:/"+deleteName);
        if (file.exists()){
            boolean flag = file.delete();
            if (flag){
                logger.debug("文件删除成功！");
            }
        }else{
            logger.debug("需要删除的文件不存在！");
        }
        showFisrtMeun();
    }

    /**
     * 创建文件
     * @param fileName
     * @throws IOException
     */
    private static void CreateFile(String fileName) throws IOException {
        //创建File对象
        File file = new File("E:/"+fileName);
        boolean flag = file.exists();
        if (flag){
            logger.debug("文件已存在！");
        }else{
            file.createNewFile();
            logger.debug("文件创建成功！");
        }
        showFisrtMeun();
    }


}
