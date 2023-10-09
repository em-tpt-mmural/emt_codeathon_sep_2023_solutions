package src;
import  java.util.*;
public class Codeathon01_Murali {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> total = new ArrayList<>();
        System.out.println("how many names you will give enter the number");
        int str1 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < str1; i++) {
            String input = sc.nextLine();
            total.add(input);
        }
        System.out.println("output");
        for (String str : total) {
            String string = str.toLowerCase();
            int length = string.length();
            int check = 0;
            for (int i = 0; i < length; i++) {
                int first = string.charAt(i);
                for (int j = i + 1; j < length; j++) {
                    int second = string.charAt(j);
                    if (first > second) {
                        check = 1;
                    }
                }

            }
            if (check == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
       }
    }
