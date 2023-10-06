package src;

import java.util.Scanner;
class Rectangle {
    int width;
    int length;
    public void display() {
    }
}
class RectangleArea extends Rectangle {
    public void read_input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter width value");
        width = scanner.nextInt();
        System.out.println("enter length value");
        length = scanner.nextInt();
        scanner.close();
    }
    public void display() {
        super.display();
        int total = width * length;
        System.out.println("Area of Rectangle : " + total);
    }
}

public class Codeathon05A_Murali {
    public static void main(String[] args) {
        RectangleArea rec= new RectangleArea();
        rec.read_input();
        rec.display();
    }
}
