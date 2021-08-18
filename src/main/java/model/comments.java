package model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "cmt")
public class comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int rate;
    private String name;
    private String content;
    private Date date;
    private int likes;

    public comments() {
    }

    public comments(int rate, String name, String content, Date date, int likes) {
        this.rate = rate;
        this.name = name;
        this.content = content;
        this.date = date;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String comment) {
        this.content = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
