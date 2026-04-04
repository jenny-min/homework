package session13.Exercise05.business.dao;

import session13.Exercise05.business.model.Movie;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements IMovieDao{
    @Override
    public List<Movie> listMovies() {
        //Tạo list chứa đối tượng trả về
        List<Movie> movies = new ArrayList<>();
        //B1: Mở kết nối
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng Callable
        try {
            CallableStatement call = conn.prepareCall("{call list_movies()}");

            //B3: Thực thi truy vấn
            ResultSet rs = call.executeQuery();
            //B4: Xử lí dữ liệu trả về
            while (rs.next()) {
                Movie m = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("year")
                );
                //Nếu phát hiện có đối tượng movie, sẽ biến đổi và thêm vào đối tượng trong java
                movies.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return movies;
    }

    @Override
    public void addMovie(Movie movie) {
        //B1: Mở kết nối
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng Callable
        try {
            CallableStatement call = conn.prepareCall("{call add_movie(?,?,?)}");

            //Truyền đối số
            call.setString(1, movie.getTitle());
            call.setString(2, movie.getDirector());
            call.setInt(3, movie.getYear());

            //B3: Thực thi truy vấn
            call.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateMovie(Movie movie) {
        //B1: Mở kết nối
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng Callable
        try {
            CallableStatement call = conn.prepareCall("{call update_movie(?,?,?,?)}");

            //Truyền đối số
            call.setInt(1, movie.getId());
            call.setString(2, movie.getTitle());
            call.setString(3, movie.getDirector());
            call.setInt(4, movie.getYear());

            //B3: Thực thi truy vấn
            call.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteMovie(int id) {
        //B1: Mở kết nối
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng Callable
        try {
            CallableStatement call = conn.prepareCall("{call delete_movie(?)}");

            call.setInt(1, id);

            //B3: Thực thi truy vấn
            call.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
