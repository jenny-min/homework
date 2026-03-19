package session07;

public class Exercise07 {
    public static void main(String[] args) {
        Fraction frac1 = new Fraction(3,4);
        Fraction frac2 = new Fraction(4,5);
        System.out.println("Phân số 1: " + frac1);
        System.out.println("Phân số 2: " + frac2);

        System.out.println("Kết quả phép cộng: " + frac1.add(frac2));
        System.out.println("Kết quả phép trừ: " + frac1.subtract(frac2));
        System.out.println("Kết quả phép nhân: " + frac1.multiply(frac2));
        System.out.println("Kết quả phép chia: " + frac1.divide(frac2));
    }

    //Class Fraction
    public static class Fraction {
        //Thuộc tính
        private int numerator;
        private int denominator;

        //Constructor
        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                //Constructs an IllegalArgumentException with the specified detail message.
                //ném ra ngoại lệ
                throw new IllegalArgumentException("Mẫu số không được bằng 0");
            }

            this.numerator = numerator;
            this.denominator = denominator;
            simplify();//Tự động rút gọn
        }

        //Getter và setter
        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            if (denominator == 0) {
                //Constructs an IllegalArgumentException with the specified detail message
                //ném ra ngoại lệ
                throw new IllegalArgumentException("Mẫu số không được bằng 0");
            }
            this.denominator = denominator;
        }

        //gcd - Ước chung lớn nhất
        public int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        //rút gọn phân số
        public void  simplify() {
            int gcd = gcd(numerator,denominator);
            numerator /= gcd;
            denominator /= gcd;
                //Nếu mẫu số âm -> đổi dấu, đảm bảo mẫu luôn dương
            if (denominator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
        }

        //Cộng
        public Fraction add(Fraction other) {
            int num = this.numerator*other.denominator + other.numerator*this.denominator;
            int den = this.denominator*other.denominator;
            return new Fraction(num, den);
        }

        //Trừ
        public Fraction subtract(Fraction other) {
            int num = this.numerator*other.denominator - other.numerator*this.denominator;
            int den = this.denominator* other.denominator;
            return new Fraction(num, den);
        }

        //Nhân
        public Fraction multiply(Fraction other) {
            int num = this.numerator* other.numerator;
            int den = this.denominator* other.denominator;
            return new Fraction(num, den);
        }

        //Chia
        public Fraction divide(Fraction other) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Không thể chia phân số cho 0");
            }
            int num = this.numerator*other.denominator;
            int den = this.denominator*other.numerator;
            return new Fraction(num, den);
        }

        //Hiển thị
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}
