package com.javatesting;

import java.util.Arrays;

public class ValidateSuduko {
    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        ValidateSuduko validateSuduko = new ValidateSuduko();
        //System.out.println(validateSuduko.isValidSudoku(board));

        String input = "bdac";
        char[] innn = input.toCharArray();
        System.out.println(Arrays.toString(innn));
        //char[] ttt = Arrays.sort(input);
        //System.out.println(Arrays.toString(Arrays.sort(innn)));
    }



    public boolean isValidSudoku(char[][] board) {

        if(validateColumns(board) && validateRows(board) && validateSquare(board)){
            return true;
        }
        return false;
    }


    public boolean validateSquare(char[][] board){
        for(int x=0;x<9;x=x+3){
            for(int y=0;y<9;y=y+3){
                int rowList[] = new int[9];
                for(int i=0+x;i<3+x;i++){
                    for(int j=0+y;j<3+y;j++){
                        if(board[i][j]!='.'){
                            int current = Character.getNumericValue(board[i][j]);
                            if(rowList[current-1]==1){
                                return false;
                            }
                            rowList[current-1]=1;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean validateColumns(char[][] board){

        for(int i=0;i<9;i++){
            int rowList[] = new int[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int current = Character.getNumericValue(board[i][j]);
                    if(rowList[current-1]==1){
                        return false;
                    }
                    rowList[current-1]=1;
                }

            }

        }

        return true;
    }

    public boolean validateRows(char[][] board){

        for(int i=0;i<9;i++){
            int rowList[] = new int[9];
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    int current = Character.getNumericValue(board[j][i]);
                    if(rowList[current-1]==1){
                        return false;
                    }
                    rowList[current-1]=1;
                }

            }

        }

        return true;
    }
}
