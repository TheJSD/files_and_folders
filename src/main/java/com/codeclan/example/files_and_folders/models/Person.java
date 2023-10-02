package com.codeclan.example.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {
    @Column
    private String name;
    @OneToMany(mappedBy = "person")
    @JsonIgnoreProperties({"person"})
    private List<Folder> folders;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Person(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }
    public Person(){}

    public String getName() {
        return name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
