package src;//Question
//        SKP's Java Problem Solving Series : Active Traders (HackerRank)
//        [Question/Problem Statement is the Property of HackerRank]
//
//        Algorithms/Data Structures - [Problem Solving]
//        An Institutional Broker wants to Review their Book of Customers to see which are Most Acctive. Given a List of Trades By "Customer Name, Determine which Customers Account for At Least 5% of the Total Number of Trades. Order the List Alphabetically Ascending By Name."
//
//
//        Example
//        n = 23
//        "customers = {"Bigcorp", "Bigcorp", "Acme", "Bigcorp", "Zork", "Zork", "Abe", "Bigcorp",  "Acme", "Bigcorp", "Bigcorp" , "Zork", "Bigcorp", "Zork", "Zork", "Bigcorp", "Acme", "Bigcorp", "Acme", "Bigcorp", "Acme",""Littlecorp" , "Nadircorp "}."
//
//        "Bigcorp had 10 Trades out of 23,which is 43.48% of the Total Trades."
//        "Both Acme and Zork had 5 trades,which is 21.74% of the Total Trades."
//        "The Littlecorp, Nadircorp and Abe had 1 Trade Each, which is 4.35%..."
//        "So the Answer is [""Acme"", "" Bigcorp  ,""Zork""] (In Alphabetical Order) Because only These Three Companies Placed atleast 5% of the Trades.
//
//
//        Function Description
//        Complete the Function mostActive in the Editor Below.
//
//        mostActive has the following parameter:
//        String customers[n] : An Array Customer Names
//        (Actual Question Says String Array, But Signature is List of Strings)
//
//        Returns String[] : An Alphabetically Ascending Array
//
//
//        Constraints
//        • 1 < n < 10^5
//        • 1 < Length of customers[] < 20
//        • The First Character of customers[i] is a Capital English letter.
//        • All Characters of customers[i] except for the First One are Lowercase.
//        • Guaranteed that At least One Customer makes atleast 5% of Trades.
//
//
//        Input Format
//        "The First Line contains an integer, n, The Number of Elements in customers."
//        "Each Line iof the n Subsequent Lines (where 0 s i< n) contains a string, customers[i]."
//
//
//        Sample Case 0 Input For Custom Testing
//        20
//        Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Alpha Omega Beta
//
//
//        Function mostActive
//        customers[] size n =  20
//        customers[] = [As Provided Above]
//
//
//        Sample Output
//        Alpha
//        Beta
//        Omega
//
//
//        Explanation
//        "Alpha made 10 Trades out of 20 (50% of the Total), Omega made 9 Trades (45% of the Total). and Beta made 1 Trade (5% of the Total).All of them have met the 5% Threshold, so all the Strings are Returned in an Alphabetically Ordered Array."

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
