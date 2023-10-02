package com.codeclan.example.files_and_folders.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {
    @Column
    private String title;
    @OneToMany(mappedBy = "folder")
    @JsonIgnoreProperties({"folder"})
    private List<File> files;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonIgnoreProperties("person")
    private Person person;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Folder(String title, Person person) {
        this.title = title;
        this.files = new ArrayList<>();
        this.person = person;
    }
    public Folder(){}

    public String getTitle() {
        return title;
    }
    public List<File> getFiles() {
        return files;
    }
    public Person getPerson() {
        return person;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addFile(File file){
        this.files.add(file);
    }
}
