package classes;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String content;
    private Date date;
    private Manager author; 

    public News(int id, String title, String content, Date date, Manager author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    // getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Manager getAuthor() {
        return author;
    }
    public void setAuthor(Manager author) {
        this.author = author;
    }
}
