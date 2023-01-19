package com.backFalahApp.BackFalahApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @Column(name="name",nullable=false)
    private String categoryName;


    public Category() {

    }

    public Category(int id,String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }



}
