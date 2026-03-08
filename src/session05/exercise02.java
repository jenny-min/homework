package session05;

public class exercise02 {
    public static void main(String[] args) {
        //Chuỗi ban đầu
        StringBuilder str = new StringBuilder("Hello, Java World!");

        //Hiển thị chuỗi ban đầu
        System.out.println("Chuỗi ban đầu: " + str);

        //Xóa các ký tự từ vị trí 5 đến 9 trong chuỗi.
        str.delete(5,10);
        System.out.println("Chuỗi sau khi xóa: " + str);

        //Thay thế đoạn "World" bằng "Universe".
        int replacedWord = str.indexOf("World");
        if (replacedWord != -1) {
            str.replace(replacedWord, replacedWord + 5, "Universe");
        }
        System.out.println("Chuỗi sau khi thay thế " + str);
    }
}
