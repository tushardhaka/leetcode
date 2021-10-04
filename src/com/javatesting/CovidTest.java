package com.javatesting;

import java.util.Scanner;

public class CovidTest {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        String virusComposition = scanner.next();
        int numberOfPeople = scanner.nextInt();
        String [] bloodComposition = new String[numberOfPeople];
        for(int i =0;i<bloodComposition.length; i++){
            bloodComposition[i]=scanner.next();
        }
        String [] report = doCovidTest(virusComposition, numberOfPeople, bloodComposition);

        for(int i =0;i<report.length; i++){
            System.out.println(report[i]);
        }
    }

    public static String [] doCovidTest(String virusComposition, int numberOfPeople, String [] bloodComposition){

        String [] report = new String[numberOfPeople];

        for(int i=0;i<numberOfPeople;i++){
            String personBloodComp = bloodComposition[i];
            int virusComposutionTraversed = 0;
            int personComposutionTraversed = 0;
            for(int j=0;j<personBloodComp.length();j++){
                for(int k=virusComposutionTraversed;k<virusComposition.length();k++){
                    virusComposutionTraversed++;
                    if(personBloodComp.charAt(j) == virusComposition.charAt(k)){
                        personComposutionTraversed++;
                        break;
                    }
                }
                if(virusComposutionTraversed == virusComposition.length()){
                    break;
                }
            }
            if(personComposutionTraversed==personBloodComp.length()){
                report[i]="POSITIVE";
            }else {
                report[i]="NEGATIVE";
            }
        }



        return report;
    }

}
