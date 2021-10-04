package com.javatesting.cluster;

public class FindClusters {

    public static void main(String[] args) {
        int [][] inputArray = {{0,0,0,0,0},{0,2,3,0,1},{0,8,5,0,7},{7,0,0,0,4}};

        int [][] visitedArray = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};

        System.out.println(findClusters(inputArray, visitedArray));

    }

    private static int findClusters(int [][] inputArray, int [][] visitedArray){


        int clusterCount = 0;
        for(int i=0;i<4; i++){
            for(int j=0;j<5; j++){
                //System.out.println(i+" "+j);
                if(visitedArray[i][j]==0){

                    if(inputArray[i][j]==0){
                        visitedArray[i][j]=1;
                        continue;
                    }
                    else{
                        System.out.println(i+" "+j);
                        clusterCount++;
                        traverseNeighbour(inputArray, visitedArray, i, j);

                    }

                }
            }
        }

        return clusterCount;
    }

    private static void traverseNeighbour(int [][] inputArray, int [][] visitedArray, int X, int Y){
        // check immediate neighbours
        if(Y<0 || Y>4){
            return;
        }
        if(X<0 || X>3){
            return;
        }
        if(visitedArray[X][Y]==1){
            return;
        }
        visitedArray[X][Y]=1;

        if(inputArray[X][Y]==0){
            return;
        }


        traverseNeighbour(inputArray, visitedArray, X-1, Y);
        traverseNeighbour(inputArray, visitedArray, X-1, Y+1);
        traverseNeighbour(inputArray, visitedArray, X, Y+1);
        traverseNeighbour(inputArray, visitedArray, X+1, Y+1);
        traverseNeighbour(inputArray, visitedArray, X+1, Y);
        traverseNeighbour(inputArray, visitedArray, X+1, Y-1);
        traverseNeighbour(inputArray, visitedArray, X, Y-1);
        traverseNeighbour(inputArray, visitedArray, X-1, Y-1);
    }
}
