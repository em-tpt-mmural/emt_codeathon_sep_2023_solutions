package src;

import java.util.Scanner;
class Sam{
    static void swap(int var1, int var2){
        var1=var1^var2;
        var2=var1^var2;
        var1=var1^var2;
        var1 = (int) (var1 * 0.1);
        var2 = (int) (var2 * 0.2);
        System.out.println("After swapping var1="+var1);
        System.out.println("After swapping var2="+var2);

    }
}
public class Codeathon05B_Murali {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter var1:");
        int var1 =sc.nextInt();
        System.out.println("Enter var2:");
        int var2 =sc.nextInt();
        Sam.swap(var1,var2);
    }
}
