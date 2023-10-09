package src;

import java.util.Scanner;

public class Codeathon03_Murali {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the no of trees");
        int clockwiseTravel=0;
        int anticlockwiseTravel=0;
        int lenght=0;
        int maxTravelTime=0;

        int n = sc.nextInt();
        int height[] = new int[n];
        int maximumTravelTime=0;
        System.out.println("enter trees height");
        for(int i=0;i<n;i++) {
            height[i] = sc.nextInt();
        }
        maximumTravelTime=height[0];
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                clockwiseTravel=Math.abs(((n-j)+i));
                anticlockwiseTravel=Math.abs((j-i));
                if(clockwiseTravel<=anticlockwiseTravel) {
                    lenght=clockwiseTravel;
                }
                else{
                    lenght=anticlockwiseTravel;
                }
                maxTravelTime=lenght+height[i]+height[j];
                if(maxTravelTime>maximumTravelTime)
                    maximumTravelTime=maxTravelTime;
            }
        }
        System.out.println(" travel time:"+maximumTravelTime);
    }
}



