package com.baconfinder.bacon_degrees.service;

import com.baconfinder.bacon_degrees.dto.PathResponse;
import com.baconfinder.bacon_degrees.model.TitlePrincipals;
import com.baconfinder.bacon_degrees.repository.TitlePrincipalsRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.*;

@Service
public class PathFinderService {
    private final TitlePrincipalsRepository principalsRepository;

    public PathFinderService(TitlePrincipalsRepository principalsRepository) {
        this.principalsRepository = principalsRepository;
    }

    public PathResponse findShortestPath(String fromNconst, String toNconst) {

        if (fromNconst.equals(toNconst)) {
            return new PathResponse(true, List.of(fromNconst), "Bron en bestemming zijn hetzelfde.");
        }

        Queue<List<String>> queue = new LinkedList<>();   //[[]]
        Set<String> visited = new HashSet<>();  //{}

        queue.add(List.of(fromNconst + "|START"));
        visited.add(fromNconst);

        while (!queue.isEmpty()) {                        // [[kevin]],2- [[kevin,x],[kevin,y]]
            List<String> path = queue.poll();              //path =[kevin ,x]
            String lastStep = path.get(path.size() - 1);
            String[] lastParts = lastStep.split("\\|");
            String currentActor = lastParts[0];                 // x

            List<TitlePrincipals> moviesVanCurrentActor = principalsRepository.findByNconst(currentActor);
            Set<String> movieIds = new HashSet<>();
            for (TitlePrincipals movieVanCurrentActor : moviesVanCurrentActor) {
                movieIds.add(movieVanCurrentActor.getTconst());       // {T1,T2,T3}
            }

            for (String movieId : movieIds) {

                List<TitlePrincipals> cast = principalsRepository.findByTconst(movieId);

                for (TitlePrincipals coactorRole : cast) {
                    String coActor = coactorRole.getNconst();   //nxx

                    if (visited.contains(coActor)) continue;

                    List<String> newPath = new ArrayList<>(path);  // path =[kevin ,x]
                    newPath.add(coActor + "|" + movieId);           //newpath =[kevin ,x,xx]

                    if (coActor.equals(toNconst)) {
                        return new PathResponse(true, formatPath(newPath), "Verbinding gevonden.");
                    }

                    if (newPath.size() <= 6) {
                        queue.add(newPath);            // [[kevin,y]][kevin,x,xx]
                        visited.add(coActor);           //{kevin,x,y}
                    }
                }
            }
        }

        return new PathResponse(false, List.of(), "Er is binnen 6 stappen geen verbinding gevonden.");
    }

    private List<String> formatPath(List<String> pathWithMovie) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < pathWithMovie.size(); i++) {
            String[] prev = pathWithMovie.get(i - 1).split("\\|");
            String[] curr = pathWithMovie.get(i).split("\\|");
            String line = prev[0] + " (" + curr[1] + ") -> " + curr[0];
            result.add(line);
        }
        return result;
    }



}
