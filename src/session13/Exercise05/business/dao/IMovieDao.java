package session13.Exercise05.business.dao;

import session13.Exercise05.business.model.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> listMovies();
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int id);
}
