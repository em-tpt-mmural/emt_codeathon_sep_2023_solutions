package src;//question
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
public class Codeathon02_Murali {


        public static List<String> getActiveCustomers(List<String> trades) {
            Map<String, Integer> Counts = new HashMap<>();
            int totalTrades = trades.size();

            for (String customer : trades) {
                Counts.put(customer, Counts.getOrDefault(customer, 0) + 1);
            }
            List<String> activeCustomers = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : Counts.entrySet()) {
                String customer = entry.getKey();
                int totalCount = entry.getValue();

                if ((double) totalCount / totalTrades >= 0.05) {
                    activeCustomers.add(customer);
                }
            }
            Collections.sort(activeCustomers);
            return activeCustomers;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of trades : ");
            int n = sc.nextInt();
            List<String> customers = new ArrayList<>();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter All customer names " + (i + 1) + ": ");
                String customer = sc.nextLine();
                customers.add(customer);
            }

            List<String> activeCustomers = getActiveCustomers(customers);
            System.out.println("Most Active Customers:");
            for (String customer : activeCustomers) {
                System.out.println(customer);
            }
        }
}





