package com.baconfinder.bacon_degrees.service;

import com.baconfinder.bacon_degrees.model.TitleBasics;
import com.baconfinder.bacon_degrees.repository.TitleBasicsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TitleBasicsService {


        private final TitleBasicsRepository titleBasicsRepository;

        public TitleBasicsService(TitleBasicsRepository titleBasicsRepository) {
            this.titleBasicsRepository = titleBasicsRepository;
        }

        public Optional<TitleBasics> getMovieById(String tconst) {
            return titleBasicsRepository.findById(tconst);
        }

}
