package com.javatesting;

import java.util.*;

public class ReachingPoints {

    public static void main(String[] args) {
        ReachingPoints reachingPoints = new ReachingPoints();
        //boolean output = reachingPoints.reachingPoints(35,13, 455955547, 420098884);
        boolean output = reachingPoints.reachingPoints(1,1,3,5);
        System.out.println(output);
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return reachingPointsDynamics(sx,sy,tx,ty, new HashMap<>());
    }

    public boolean reachingPointsDynamics(int sx, int sy, int tx, int ty, Map<String, Boolean> outcomeMap) {
        String currentCoordinate = sx+","+sy;
        if(outcomeMap.containsKey(currentCoordinate)){
            return outcomeMap.get(currentCoordinate);
        }
        if(sx == tx && sy == ty){
            outcomeMap.put(currentCoordinate, true);
            return true;
        }
        if(sx>tx || sy>ty){
            outcomeMap.put(currentCoordinate, false);
            return false;
        }
        return reachingPointsDynamics(sx,sy+sx,tx,ty, outcomeMap) || reachingPointsDynamics(sx+sy,sy,tx,ty, outcomeMap);
    }



}

