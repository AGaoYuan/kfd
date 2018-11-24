package cn.spring.day03printer.printer;

import cn.spring.day03printer.ink.Ink;
import cn.spring.day03printer.paper.Paper;

public class Printer {

    private Ink ink;
    private Paper paper;

    public void print(){
        System.out.println("您正在使用"+ink.ink()+"打印到"+paper.paper()+"上");
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
