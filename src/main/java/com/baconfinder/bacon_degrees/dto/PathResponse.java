package com.baconfinder.bacon_degrees.dto;

import java.util.List;

public class PathResponse {

    private boolean found;
    private List<String> path;
    private String message;

    public PathResponse(boolean found, List<String> path, String message) {
        this.found = found;
        this.path = path;
        this.message = message;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
