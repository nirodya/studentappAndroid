package javainstitute.edu.lk.studentapp.model;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class Mark {
    private String mark;
    private String date;
    private String stu_name;
    private String subject;

    public Mark(String mark, String date, String stu_name,String subject) {
        this.mark = mark;
        this.date = date;
        this.stu_name = stu_name;
        this.subject=subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
}
