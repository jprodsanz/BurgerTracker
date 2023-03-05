package com.pablo.mvc.burgertracker.models;
import javax.validation.constraints.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")

public class Burger {
    // Unique ID
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    // Name of the burger
        @NotBlank // use NotBlank instead of NotNull for strings to avoid val errors
        @Size(min = 3, max = 200, message="Burger name is required")
        private String burgerName ;
    // Name of the restaurant
        @NotBlank
        @Size(min = 3, max = 200, message="Restaurant name is required")
        private String restName ;
    // Rating
        @Min(1)
        @Max(5)
        private int rating;
    // Notes
        @NotBlank
        @Size(min = 3, max = 200, message ="Notes are required")
        private String notes;

    // This will not allow the createdAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date createdAt;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updatedAt;

    public Burger() {
    }

//     Moving forward, when using a form/form  having the constructor below won't be necessary
//    public Burger(String burgerName, String restName, int rating, String  notes) {
//        this.burgerName = burgerName;
//        this.restName = restName;
//        this.rating = rating;
//        this.notes = notes;
//    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBurgerName() {
        return burgerName;
    }
    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }
    public String getRestName() {
        return restName;
    }
    public void setRestName(String restName) {
        this.restName = restName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String  notes) {
        this.notes = notes;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

// Specifies a callback method for the corresponding lifecycle event...
// This annotation may be applied to methods of an entity class, a mapped superclass or
// a call back listener class
// this annotation helps so users cannot modify the created at and updated at

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}


