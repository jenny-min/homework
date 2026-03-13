package session07;

public class Exercise02 {
    //Phương thức main
    public static void main(String[] args) {
        //tạo đối tượng Book
        Book myBook = new Book();

        //Thiết lập thuộc tính
        myBook.setTitle("Java Programming");
        myBook.setAuthor("John Doe");

        //Thiết lập giá hợp lệ
        myBook.setPrice((int)29.99);

        //Hiển thị thông tin danh sách
        System.out.println("Tiêu đề: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá: " + myBook.getPrice((int) 29.99));

        //Thử thay đổi giá thành công
        myBook.setPrice((int) 35.00);
        System.out.println("Giá mới: " + myBook.getPrice((int) 29.99));

        //Thử thay đổi giá không hợp lệ
        myBook.setPrice((int) -5.0);
    }

    //Lớp Book
    public static class Book {
        //Thuộc tính
        private String title;
        private String author;
        private int price;

        //Phương thức getter và setter
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice(int i) {
            return price;
        }

        //Kiểm tra giá tiền, không được âm
        public void setPrice(int price) {
            if (price < 0) {
                System.out.printf("Giá không được âm");
            } else {
                this.price = price;
            }
        }
    }
}
