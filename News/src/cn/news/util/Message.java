package cn.news.util;

public class Message {
	
	@ColumnName(getName = "vin")
    private String vin;
    @ColumnName(getName = "报文时间")
    private String messagetime;
    @ColumnName(getName = "接收时间")
    private String Receivetime;
    @ColumnName(getName = "报文类型")
    private String messagetype;
    @ColumnName(getName = "报文长度")
    private String messagelength;
    @ColumnName(getName = "原始报文")
    private String message;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessagelength() {
        return messagelength;
    }

    public void setMessagelength(String messagelength) {
        this.messagelength = messagelength;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceivetime() {
        return Receivetime;
    }

    public void setReceivetime(String receivetime) {
        Receivetime = receivetime;
    }
    
}
