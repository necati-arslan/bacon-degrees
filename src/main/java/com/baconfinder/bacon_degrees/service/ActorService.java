package com.baconfinder.bacon_degrees.service;

import com.baconfinder.bacon_degrees.model.NameBasics;
import com.baconfinder.bacon_degrees.repository.NameBasicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final NameBasicsRepository nameBasicsRepository;

    @Autowired
    public ActorService(NameBasicsRepository nameBasicsRepository) {
        this.nameBasicsRepository = nameBasicsRepository;
    }
    public List<NameBasics> searchActorsByNamePrefix(String prefix) {
        System.out.println(prefix);
        return nameBasicsRepository.findByPrimaryNameStartingWithIgnoreCase(prefix);

    }

    public NameBasics getActorById(String nconst) {
        return nameBasicsRepository.findById(nconst).orElse(null);
    }

}
