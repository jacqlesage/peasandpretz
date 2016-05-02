/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peanutsandpretzels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author James
 */
public class PeanutsAndPretzels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "";

        String[] totalPAndP;
        int totalPea = 0;
        int totalPretz = 0;
        boolean line1 = true;
        int temp = 0;
        int count = 0;
        String[] movesList = new String[10];
        char[] peanutsMoveList = new char[10];
        char[] pretzelsMoveList = new char[10];
        ArrayList<Integer> listPeanuts = new ArrayList<Integer>();
        ArrayList<Integer> listPretzel = new ArrayList<Integer>();
        boolean grid[][];
        int totalMovesList[][];

        try {
            FileInputStream is = new FileInputStream(new File("C:\\Users\\James\\Documents\\NetBeansProjects\\PeanutsAndPretzels\\src\\peanutsAndpretzels\\input.txt"));
            System.setIn(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);

        //get the line coming in
        while (in.hasNextLine()) {

            s = in.nextLine();

            if (line1) {

                totalPAndP = s.split(" ");
                totalPea = Integer.parseInt(String.valueOf(totalPAndP[0]));
                totalPretz = Integer.parseInt(String.valueOf(totalPAndP[1]));
//                System.out.println(totalPea + " " + totalPretz);
                line1 = false;

            } else {

                movesList[count] = s;
                peanutsMoveList[count] = movesList[count].charAt(temp);
                pretzelsMoveList[count] = movesList[count].charAt(temp + 2);

                listPeanuts.add(Integer.parseInt(String.valueOf(peanutsMoveList[count])));
                listPretzel.add(Integer.parseInt(String.valueOf(pretzelsMoveList[count])));

                count++;
            }

        }

        if (!in.hasNextLine()) {
            line1 = true;
            count = 0;

        }

        listPeanuts.add(0);
        listPretzel.add(1);
        listPeanuts.add(1);
        listPretzel.add(0);

        grid = new boolean[listPeanuts.size()+1][listPeanuts.size()+1];
        //totalMovesList = new int [listPeanuts.size() + 2][listPeanuts.size() + 2];
        //System.out.println(grid.length);

        
        for(int x : listPeanuts){
            System.out.println("peanustsLIst = " + listPeanuts.toString());
            System.out.println("pretzelList = " + listPretzel.toString());
        
        }
        //boolean movesEffect = Player.movesEffectOutcome(totalPea, totalPretz, listPeanuts, listPretzel);
        //System.out.println(movesEffect);
        Player p = new Player(1, listPeanuts, listPretzel, totalPea, totalPretz);
        
        Grid g = new Grid(grid);
        System.out.println(grid.length + "@#@#!");
        g.buildGrid(grid, listPeanuts, listPretzel);
        //boolean x = Player.canWin(totalPea, totalPretz, p);
        //System.out.println(x);
//    
//        switch (count) {
//
//            case 'N':
//
//                break;
//
//        }

    }

    public static boolean bottomUp(int goalPea, int goalPretz, ArrayList<Integer> pea, ArrayList<Integer> pretz) {

        boolean[] sadOrHappy;

        return true;
    }
}
