package com.baconfinder.bacon_degrees.model;

import jakarta.persistence.*;

@Entity
@Table(name = "title_basics")
public class TitleBasics {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "titleType")
    private String titleType;

    @Column(name = "primaryTitle")
    private String primaryTitle;

    @Column(name = "originalTitle")
    private String originalTitle;

    @Column(name = "isAdult")
    private Boolean isAdult;

    @Column(name = "startYear")
    private Integer startYear;

    @Column(name = "endYear")
    private Integer endYear;

    @Column(name = "runtimeMinutes")
    private Integer runtimeMinutes;

    @Column(name = "genres")
    private String genres;

    public String getTconst() {
        return tconst;
    }



    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
