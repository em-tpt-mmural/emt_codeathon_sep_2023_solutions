package src;
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





