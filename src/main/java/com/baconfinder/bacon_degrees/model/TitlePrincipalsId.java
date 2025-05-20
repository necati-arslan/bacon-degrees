package com.baconfinder.bacon_degrees.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TitlePrincipalsId implements Serializable {
    private String tconst;
    private String nconst;

    public TitlePrincipalsId() {}

    public TitlePrincipalsId(String tconst, String nconst) {
        this.tconst = tconst;
        this.nconst = nconst;
    }

    // getters, setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitlePrincipalsId)) return false;
        TitlePrincipalsId that = (TitlePrincipalsId) o;
        return Objects.equals(tconst, that.tconst) &&
                Objects.equals(nconst, that.nconst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tconst, nconst);
    }
}
