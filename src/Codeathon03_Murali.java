package src;////Question
////        SKP's Java Problem Solving Series : Monkeys in the Garden
////        [Question/Problem Statement is the Property of Techgig]
////        Monkeys in the Garden [www.techgig.com]
////
////        In a garden, trees are arranged in a circular fashion with an equal distance between two adjacent trees. The height of trees may vary. Two monkeys live in that garden and they were very close to each other. One day they quarreled due to some misunderstanding. None of them were ready to leave the garden. But each one of them wants that if the other wants to meet him, it should take maximum possible time to reach him, given that they both live in the same garden.
////
////        The conditions are that a monkey cannot directly jump from one tree to another. There are 30 trees in the garden. If the height of a tree is H, a monkey can live at any height from 0 to H. Lets say he lives at the height of K then it would take him K unit of time to climb down to the ground level. Similarly, if a monkey wants to climb up to K height it would again take K unit of time. The time to travel between two adjacent trees is 1 unit. A monkey can only travel in a circular fashion in the garden because there is a pond at the center of the garden.
////
////        So the question is where should two monkeys live such that the traveling time between them is maximum while choosing the shortest path between them in any direction clockwise or anti-clockwise. You have to answer only the maximum traveling time.
////
////        Input Format
////        The First Line consists of Total Number of Trees (N). Each of the Following N Lines contains the Height of Trees in a Clockwise Fashion.
////
////        Constraints
////        1 <= Total Trees <= 30
////        1 <= Height Of Trees(H) <= 10000
////
////        Output Format
////        You must Print an Integer which will be the Maximum Possible Travel Time.
////
////        ________________
////
////
////        [Explanation of the Solution]
////        Surprisingly, this Problem is under the Object Oriented Programming (OOP) Section of the Problems! Initially, I was on the Lookout for a 'Mathematically Superior' Solution. But Couldn't Reach Anywhere - In the End, I have a Simple Solution at O(n²). Iterate through Each 'Combination of Trees' and then Find the Clockwise and Anti-Clockwise Distance - At Each Iteration, the Minimum of the Two is Added to the Length of Each Tree. If this Value is Greater than the Maximum Path Length (Previous Iterations) - Replace the Maximum Path Length.
//import java.util.Scanner;
//
//public class Codeathon03_Murali {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numberOfTrees = sc.nextInt();
//        int[] treeHeightArray = new int[numberOfTrees];
//
//        for (int i = 0; i < numberOfTrees; i++) {
//            treeHeightArray[i] = sc.nextInt();
//        }
//
//        System.out.println(maximumTravelTime(treeHeightArray));
//    }
//
//    public static int maximumTravelTime(int[] treeHeightArray) {
//        int maxTime = 0;
//        maxTime = time(maxTime, treeHeightArray, treeHeightArray.length);
//        return maxTime;
//    }
//
//    public static int time(int maxTime, int[] heightList, int originalArrayLength) {
//        int length = heightList.length;
//        if (length == 1) {
//            return findMaximum(maxTime, heightList[0]);
//        }
//        int tempMax = 0;
//        int startIndex = 0;
//        int[] tempArray = new int[length - 1];
//        for (int index = 1; index < length; ++index) {
//            tempMax = heightList[startIndex] + heightList[index] + findMinimum(index, originalArrayLength - index);
//            maxTime = findMaximum(tempMax, maxTime);
//            tempArray[index - 1] = heightList[index];
//        }
//        return time(maxTime, tempArray, originalArrayLength);
//    }
//
//    public static int findMinimum(int n1, int n2) {
//        return n1 < n2 ? n1 : n2;
//    }
//
//    public static int findMaximum(int n1, int n2) {
//        return n1 > n2 ? n1 : n2;
//    }
//}


import java.util.Scanner;

public class Codeathon03_Murali {
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Trees : ");
        int n= sc.nextInt();
        int tree[]=new int[n];
        for(int i=0;i<n;i++)
        {
            tree[i]= sc.nextInt();
        }
        int maxArray=0;
        maxArray=maximumValueOfArray(tree);

        int clockwise[]=new int[n];
        int anticlockwise[]=new int[n];
        int index=findIndex(tree,maxArray);

        int maxCWise=0;
        int maxACwise=0;
        int cw=0;
        int aw=0;
        int clockWise[]=new int[n];

        for(int i=0;i<n;i++)//clockwise
        {

            int fix=index;
            int inde=findIndex(tree,tree[i]);
            if(fix!=inde) {
                if (fix < inde) {
                    cw = inde - fix;
                    clockWise[i]=cw+tree[i]+maxArray;

                }
                else {
                    cw=n-fix+inde;
                    clockWise[i]=cw+tree[i]+maxArray;
                }
            }

        }
        maxCWise=maximumValueOfArray(clockWise);


        for(int i=0;i<n;i++)//Anticlockwise
        {

            int fix=index;
            int inde=findIndex(tree,tree[i]);
            if(fix!=inde) {
                if (fix < inde) {
                    aw =fix+n-inde;
                    anticlockwise[i]=aw+tree[i]+maxArray;

                }
                else {
                    aw=fix-inde;
                    anticlockwise[i]=aw+tree[i]+maxArray;
                }
            }

        }
        maxACwise=maximumValueOfArray(anticlockwise);

        int maximumTravelPath=Math.max(maxCWise,maxACwise);
        System.out.println(maximumTravelPath);

    }
    private static int findIndex(int [] arr,int j)
    {
        for(int i=0;i<arr.length;i++)
        {
            // comparing element to the target element
            if(arr[i]==j)
            {
                return i;

            }
        }
        return -1;

    }
    private static int maximumValueOfArray(int[] a)
    {int maxArray=0;
        for(int i=0;i<a.length;i++)
        {
            maxArray=Math.max(maxArray,a[i]);
        }
        return maxArray;
    }
}









