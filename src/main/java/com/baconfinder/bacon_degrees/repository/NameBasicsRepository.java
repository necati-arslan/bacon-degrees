package com.baconfinder.bacon_degrees.repository;
import com.baconfinder.bacon_degrees.model.NameBasics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameBasicsRepository extends JpaRepository<NameBasics, String> {
    List<NameBasics> findByPrimaryNameContainingIgnoreCase(String primaryName);
    List<NameBasics> findByPrimaryNameStartingWithIgnoreCase(String prefix);

}
