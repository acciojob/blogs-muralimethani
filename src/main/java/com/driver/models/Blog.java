package com.driver.models;


import javax.persistence.*;
import javax.swing.text.StringContent;
import java.util.Date;
import java.util.List;

@Entity
@Table

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    public Blog() {
    }
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
    public Date getPubDate() {

        return pubDate;
    }
    public void setPubDate(Date pubDate) {

        this.pubDate = pubDate;
    }
    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @ManyToOne
    @JoinColumn
    private User user;
    public User getUser() {

        return user;
    }
    public void setUser(User user) {

        this.user = user;
    }
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;
    public List<Image> getImageList() {

        return imageList;
    }
    public void setImageList(List<Image> imageList) {

        this.imageList = imageList;
    }
}