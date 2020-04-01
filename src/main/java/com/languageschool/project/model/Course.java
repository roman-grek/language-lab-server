package com.languageschool.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;
    protected String name;
    protected String level;
    protected String language;
    protected Integer price;

    public Integer getClassesCount() {
        return classesCount;
    }

    public void setClassesCount(Integer classesCount) {
        this.classesCount = classesCount;
    }

    protected Integer classesCount;

    protected static Long idGen = 1L;

    // avoid this "No default constructor for entity"
    public Course() {
    }

    public Course(String name, String level, String language, Integer price, Integer classesCount) {
        this.name = name;
        this.price = price;
        this.language = language;
        this.level = level;
        this.classesCount = classesCount;
    }

    public long getId() {
        if (id == null)
        {
            id = idGen;
            idGen++;
        }
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", level=" + level + '\'' +
                ", price=" + price + '\'' +
                ", classesCount=" + classesCount + '\'' +
                '}';
    }


}
