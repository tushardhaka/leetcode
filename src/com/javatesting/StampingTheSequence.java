package com.javatesting;

import java.util.*;

public class StampingTheSequence {

    public static void main(String[] args) {
        StampingTheSequence stampingTheSequence = new StampingTheSequence();
        String stamp = "abca";
        String target = "aabcaca";
        //System.out.println(stampingTheSequence.putStampOverTarget(stamp, target, 0));
        //System.out.println(stampingTheSequence.movesToStamp(stamp, target));
        int[] output = stampingTheSequence.movesToStamp(stamp, target);
        System.out.println(Arrays.toString(output));

    }

    public int[] movesToStamp(String stamp, String target) {
        char[] schar = stamp.toCharArray();
        char[] tchar = target.toCharArray();
        int questionCount = 0;

        boolean[] visited = new boolean[target.length()];
        List<Integer> moves = new ArrayList<>();

        while(questionCount!=target.length()){

            boolean didChange = false;
            for(int i=0;i<=target.length()-stamp.length();i++){

                if(canBeReplaced(tchar, i, schar) && !visited[i]){
                    tchar = replaceWithQuestion(tchar, schar.length, i);
                    visited[i]= true;
                    didChange = true;
                    moves.add(i);
                    questionCount = getQuestionCount(tchar);
                    if(questionCount==target.length()){
                        break;
                    }
                }


            }

            if(!didChange){
                return  new int[0];
            }
        }

        int[] result = new int[moves.size()];
        int k=0;
        for(int i=moves.size()-1;i>=0;i--){
            result[k++]=moves.get(i);
        }

        return result;

    }

    public int getQuestionCount(char[] tchar){
        int counter=0;
        for(char c : tchar){
            if(c=='?')
                counter++;
        }
        return counter;
    }
    public boolean canBeReplaced(char[] target, int startPosition, char[] stamp){
        if(startPosition+stamp.length>target.length){
            return false;
        }
        int stampCounter =0;
        for(int i = startPosition;i<stamp.length+startPosition;i++) {
            if(target[i]=='?' || target[i] == stamp[stampCounter]){
                stampCounter++;
                continue;
            }
            return false;
        }
        return true;
    }

    public char[] replaceWithQuestion(char[] target,int stampLength, int startPosition){
        for(int i = startPosition;i<stampLength+startPosition;i++) {
            target[i] = '?';
        }
        return target;
    }

    public int[] movesToStamp(String stamp, String target,int test) {
        Map<String, List<Integer>> output = moveToStampDynamic(stamp, target, target.replaceAll("[a-z][A-Z]*","?"),
                -1, new HashMap<String, List<Integer>>());
        List<Integer> steps = output.get(target);

        return steps.stream().mapToInt(i->i).toArray();

    }

    public Map<String, List<Integer>> moveToStampDynamic(String stamp, String target, String tempTarget, int lastmove, Map<String, List<Integer>> sampleMap) {
        if(sampleMap.containsKey(tempTarget)){
            return sampleMap;
        }

        for(int i=0;i<target.length()-stamp.length();i++){
            if(i==lastmove){
                continue;
            }
            String outString = putStampOverTarget(stamp, tempTarget, i);
            System.out.println("i = "+i+" current string = "+outString);
            if(outString.equals(target)){
                sampleMap.put(tempTarget, new ArrayList<>(i));
                break;
            }
            else {
                sampleMap = moveToStampDynamic(stamp, target, outString,i,sampleMap);

            }

            return sampleMap;

        }

        return null;
    }

    public String putStampOverTarget(String stamp, String target, int startLocation){

        char[] output = new char[target.length()];
        int stampCounter=0;
        for(int i=0;i<target.length();i++){
            if(i>=startLocation && i<=startLocation+stamp.length()-1){
                output[i]=stamp.charAt(stampCounter);
                stampCounter++;
            }
            else {
                output[i]=target.charAt(i);
            }

        }
        return String.valueOf(output);
    }

}
