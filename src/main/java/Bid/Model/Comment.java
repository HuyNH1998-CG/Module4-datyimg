package Bid.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String name;
    private String comment;
    private Date date;
    private int likes;

    public Comment() {
    }

    public Comment(int id, int rate, String name, String comment) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        this.comment = comment;
    }

    public Comment(int rate, String name, String comment, Date date) {
        this.rate = rate;
        this.name = name;
        this.comment = comment;
        this.date = date;
    }

    public Comment(int id, int rate, String name, String comment, Date date, int like) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.likes = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLike() {
        return likes;
    }

    public void setLike(int like) {
        this.likes = like;
    }
}
