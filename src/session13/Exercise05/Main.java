package session13.Exercise05;

import session13.Exercise05.business.dao.IMovieDao;
import session13.Exercise05.business.dao.MovieDaoImpl;
import session13.Exercise05.business.model.Movie;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IMovieDao movieDao = new MovieDaoImpl();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n*****Menu quản lý phim*****");
            System.out.println("1. Thêm phim");
            System.out.println("2. Hiển thị phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: //Thêm phim
                        System.out.println("Nhập tiêu đề: ");
                        String title = scanner.nextLine();
                        System.out.println("Nhập tên nhà sản xuất: ");
                        String director = scanner.nextLine();
                        System.out.println("Nhập năm sản xuất: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        if (title.isEmpty() || director.isEmpty()) {
                            System.err.println("Không được để trống tên phim và nhà sản xuất");
                            break;
                        }

                        // Tạo đối tượng Movie (id truyền là null vì DB tự tăng)
                        Movie newMovie = new Movie(null, title, director, year);
                        //Gọi phương thức đã định nghĩa trong interface
                        movieDao.addMovie(newMovie);
                        break;

                    case 2: //Hiển thị
                        System.out.println("Danh sách phim: ");
                        List<Movie> list = movieDao.listMovies();
                        if (list.isEmpty()) {
                            System.out.println("Danh sách phim trống");
                        } else {
                            list.forEach(System.out::println);
                        }
                        break;
                    case 3:// Sửa phim
                        System.out.println("Nhập ID phim cần sửa: ");
                        int idUpdate = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập tên phim mới: ");
                        String newTitle = scanner.nextLine();
                        System.out.println("Nhập nhà sản xuất mới: ");
                        String newDirector = scanner.nextLine();
                        System.out.println("Nhập năm sản xuất mới: ");
                        int newYear = Integer.parseInt(scanner.nextLine());

                        Movie updateMovie = new Movie(idUpdate, newTitle, newDirector, newYear);
                        movieDao.updateMovie(updateMovie);
                        System.out.println("Cập nhật phim thành công!");
                        break;
                    case 4://Xóa phim
                        System.out.println("Nhập ID phim cần xóa: ");
                        int idDelete = Integer.parseInt(scanner.nextLine());
                        movieDao.deleteMovie(idDelete);
                        System.out.println("Xóa phim thành công!");
                        break;
                    case 5: //Thoát
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1-5!");
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập liệu! Vui lòng nhập lại");
            }
        } while (true);
    }
}
