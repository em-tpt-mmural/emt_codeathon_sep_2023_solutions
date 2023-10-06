package src;//Question
//        SKP's Java Problem Solving Series : Refresh Java Lambdas (FP)
//        [Question/Problem Statement is the Property of Techgig]
//
//        Java Advanced - Lambda Expressions [www.techgig.com]
//        Write the Following Methods that Return a Lambda Expression Performing a Specified Action: PerformOperation isOdd(): The Lambda Expression must return  if a Number is Odd or  If it is Even. PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite. PerformOperation isPalindrome(): The Lambda Expression must return  if a number is a Palindrome or if it is not.
//
//        Input Format
//        Input is as Show in the Format Below (Deduce Unknowns!)
//
//        Input
//        3
//        1 3
//        2 7
//        3 7777
//
//        Constraints
//        NA
//
//        Output Format
//        Output is as Show in the Format Below (Deduce Unknowns!)
//
//        Output
//        ODD
//        PRIME
//        PALINDROME
//        ______________
//
//
//        [Explanation of the Solution]
//        This is a Good Question to Refresh Java 8 Lambdas. In my Solution, I Implemented the Functional Interfaces within my main() Method and assigned it to Local Reference Variables.

//import java.util.Scanner;
//
//public class Codeathon04_Murali {
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = Integer.parseInt(sc.nextLine().trim());
//            while (n-- > 0) {
//                String[] input = sc.nextLine().split(" ");
//                int operationType = Integer.parseInt(input[0]);
//                int number = Integer.parseInt(input[1]);
//
//                if (operationType == 1) {
//                    if (odd(number)) {
//                        System.out.println("odd");
//                    } else {
//                        System.out.println("even");
//                    }
//                } else if (operationType == 2) {
//                    if (prime(number)) {
//                        System.out.println("prime");
//                    } else {
//                        System.out.println("not prime");
//                    }
//                } else if (operationType == 3) {
//                    if (palindrome(number)) {
//                        System.out.println("palindrome");
//                    } else {
//                        System.out.println("not palindrome");
//                    }
//                }
//            }
//            sc.close();
//        }
//        public static boolean odd(int number) {
//            return number % 2 != 0;
//        }
//        public static boolean prime(int number) {
//            if (number <= 1) {
//                return false;
//            }
//            for (int i = 2; i * i <= number; i++) {
//                if (number % i == 0) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        public static boolean palindrome(int number) {
//            String str= String.valueOf(number);
//            String rev = new StringBuilder(str).reverse().toString();
//            return str.equals(rev);
//        }
//    }
import java.util.Scanner;
interface  Lamda{
    public boolean one(int a);
}
public class Codeathon04_Murali {
    public static void main(String[] args)  {
        Lamda isOdd=n->{
            if(n%2==0)
            {
                return false;
            }
            else
            {
                return true;
            }

        };
        Lamda isPrime=num->{
            if (num <= 1) {
                return false;
            } else if (num <= 3) {
                return true;
            } else if (num % 2 == 0 || num % 3 == 0) {
                return false;
            }

            int i = 5;
            while (i * i <= num) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    return false;
                }
                i += 6;
            }

            return true;


        };
        Lamda isPalindrome=n->{
            int num=n;int rev=0;int r=0;
            while(n!=0)
            {
                r=n%10;
                rev=rev*10+r;
                n=n/10;
            }
            if(rev==num)
            {
                return true;
            }
            else{
                return false;
            }

        };
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int n=sc.nextInt();
        System.out.println("enter the case number");
        int cases=sc.nextInt();
        switch (cases)
        {
            case 1:
                if (isOdd.one(n)) {
                    System.out.println("Odd");
                } else {
                    System.out.println("Even");
                }
                break;
            case 2:
                if(isPrime.one(n))
                    System.out.println("Prime");
                else
                    System.out.println("Not Prime");
            default:
                if(isPalindrome.one(n))
                    System.out.println("Palindrome");
                else
                    System.out.println("Not Palindrome");

        }

    }
}

