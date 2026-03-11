package session05;

public class exercise05 {
    public static void main(String[] args) {

        int n = 10000;

        testString(n);
        testStringBuilder(n);
        testStringBuffer(n);

        printComment();
    }

    // Test với String
    public static void testString(int n) {
        long start = System.currentTimeMillis();

        String str = "Hello";
        for (int i = 0; i < n; i++) {
            str = str + " World";
        }

        long end = System.currentTimeMillis();

        System.out.println("Thời gian thực hiện với String: " + (end - start) + " ms");
    }

    // Test với StringBuilder
    public static void testStringBuilder(int n) {
        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < n; i++) {
            sb.append(" World");
        }

        long end = System.currentTimeMillis();

        System.out.println("Thời gian thực hiện với StringBuilder: " + (end - start) + " ms");
    }

    // Test với StringBuffer
    public static void testStringBuffer(int n) {
        long start = System.currentTimeMillis();

        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < n; i++) {
            sbf.append(" World");
        }

        long end = System.currentTimeMillis();

        System.out.println("Thời gian thực hiện với StringBuffer: " + (end - start) + " ms");
    }

    // Nhận xét
    public static void printComment() {
        System.out.println("\nNhận xét:");
        System.out.println("- String: Không hiệu quả khi nối chuỗi nhiều lần vì mỗi lần nối sẽ tạo ra đối tượng mới.");
        System.out.println("- StringBuilder: Nhanh và hiệu quả, thích hợp khi thao tác chuỗi nhiều trong chương trình một luồng.");
        System.out.println("- StringBuffer: Tương tự StringBuilder nhưng an toàn trong môi trường đa luồng do có cơ chế đồng bộ hóa.");
    }
}
