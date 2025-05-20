package com.baconfinder.bacon_degrees.repository;


import com.baconfinder.bacon_degrees.model.TitlePrincipals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipals, Long> {
    List<TitlePrincipals> findByNconst(String nconst);
    List<TitlePrincipals> findByTconst(String tconst);
}
