package src;
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

