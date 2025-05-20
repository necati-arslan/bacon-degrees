package com.baconfinder.bacon_degrees.model;

import jakarta.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tconst")
    private String tconst;

    @Column(name = "ordering")
    private Integer ordering;

    @Column(name = "nconst")
    private String nconst;

    @Column(name = "category")
    private String category;

    @Column(name = "job")
    private String job;

    @Column(name = "characters")
    private String characters;


    public String getTconst() {
        return tconst;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public String getNconst() {
        return nconst;
    }

    public String getCategory() {
        return category;
    }

    public String getJob() {
        return job;
    }

    public String getCharacters() {
        return characters;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "TitlePrincipals{" +
                "nconst='" + nconst + '\'' +
                ", tconst='" + tconst + '\'' +
                '}';
    }
}
