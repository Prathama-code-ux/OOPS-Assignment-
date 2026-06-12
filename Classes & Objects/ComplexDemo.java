public class ComplexDemo {
    static class ComplexNumber {
        double real;
        double imaginary;

        ComplexNumber() {
            this.real = 0;
            this.imaginary = 0;
        }

        ComplexNumber(double real) {
            this.real = real;
            this.imaginary = 0;
        }

        ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        ComplexNumber add(ComplexNumber other) {
            return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
        }

        ComplexNumber multiply(ComplexNumber other) {
            double r = this.real * other.real - this.imaginary * other.imaginary;
            double i = this.real * other.imaginary + this.imaginary * other.real;
            return new ComplexNumber(r, i);
        }

        void print() {
            if (imaginary >= 0) {
                System.out.println(real + " + " + imaginary + "i");
            } else {
                System.out.println(real + " - " + (-imaginary) + "i");
            }
        }
    }

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(3, 2);
        ComplexNumber c2 = new ComplexNumber(4, -2);

        ComplexNumber sum = c1.add(c2);
        ComplexNumber product = c1.multiply(c2);

        System.out.print("Sum: ");
        sum.print();
        System.out.print("Product: ");
        product.print();
    }
}
