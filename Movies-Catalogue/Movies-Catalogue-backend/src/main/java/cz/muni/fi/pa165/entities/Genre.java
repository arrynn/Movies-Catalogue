/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.entities;

import org.hibernate.validator.constraints.Length;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Maros
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @Length(max = 600)
    private String description;
    @ManyToMany
    private List<Movie> movies;

    public Genre(){
        this.movies = new ArrayList<>();
    }

    public Genre(String name) {
        this.setName(name);
        this.movies = new ArrayList<>();
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) { this.movies = movies; }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
    
    @Override
    public String toString() {
        return "Genre {" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        int prime = 47;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Genre))
            return false;
        final Genre other = (Genre) obj;

        return Objects.equals(name, other.getName());
    }
}
