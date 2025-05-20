package com.baconfinder.bacon_degrees.model;

import jakarta.persistence.*;

@Entity
@Table(name = "name_basics")
public class NameBasics {

    @Id
    @Column(name = "nconst")
    private String nconst;

    @Column(name = "primaryName")
    private String primaryName;

    @Column(name = "birthYear")
    private Integer birthYear;

    @Column(name = "deathYear")
    private Integer deathYear;

    @Column(name = "primaryProfession")
    private String primaryProfession;

    @Column(name = "knownForTitles")
    private String knownForTitles;

    public String getNconst() {
        return nconst;
    }


    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }
}
