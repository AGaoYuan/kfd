package cn.happy.testreflect;

import java.util.Date;

public class Student {  //学生实体类

    private  String userName="小黑";  //用户名
    public   String password;  //密码
    protected Date birthday=new Date(); //生日
    char  sex; //性别

    public Student(){  //无参构造
        System.out.println("构造方法");
    }

    public Student(String userName, String password, Date birthday, char sex) { //带参构造
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
    }
    private Student(String userName, String password) { //带参构造
        this.userName = userName;
        this.password = password;
    }


    {  //普通代码块1
        System.out.println("普通代码块1");
    }
    {  //普通代码块2
        System.out.println("普通代码块2");
    }


    static {  //静态代码块
        System.out.println("静态代码块");
    }

    public  static  void  staticMethod(){
        System.out.println("静态方法");
    }

    /**
     * 私有的方法
     */
    private  double getSum(double num){
        return  num+100;
    }




    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}