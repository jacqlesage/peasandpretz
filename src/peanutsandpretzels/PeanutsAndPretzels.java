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
        String movesList[];
        ArrayList<Integer> listPeanuts = new ArrayList<Integer>();
        ArrayList<Integer> listPretzel = new ArrayList<Integer>();
        boolean grid[][];
        int totalMovesList[][];

        try {
            FileInputStream is = new FileInputStream(new File("C:\\Users\\James\\Documents\\NetBeansProjects\\PeanutsAndPretzels\\src\\peanutsandpretzels\\input.txt"));
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

                movesList = s.split(" ");

                addMovesList(movesList, listPeanuts, listPretzel, totalPea, totalPretz);

//                listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0])));
////                System.out.println("***" + movesList[0]);
//                listPretzel.add(Integer.parseInt(String.valueOf(movesList[1])));
////                System.out.println("###" + movesList[1]);
                count++;
            }

        }

        if (!in.hasNextLine()) {
            line1 = true;
            count = 0;

        }
        //add basic moves to moves list for processing
        listPeanuts.add(0);
        listPretzel.add(1);
        listPeanuts.add(1);
        listPretzel.add(0);

        grid = new boolean[Integer.valueOf(totalPea) + 1][Integer.valueOf(totalPretz) + 1];

        System.out.println("peanustsLIst = " + listPeanuts.toString());
        System.out.println("pretzelList = " + listPretzel.toString());

        Grid g = new Grid(grid);
        System.out.println(grid + "@#@#!");
        g.buildGrid(grid, listPeanuts, listPretzel);

    }

    private static void addMovesList(String[] movesList, ArrayList<Integer> listPeanuts, ArrayList<Integer> listPretzel, int totalPea, int totalPretz) {
        
        int temp;
        
        if (Character.isDigit(movesList[0].charAt(0)) && Character.isDigit(movesList[1].charAt(0))) {
            listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0])));
//                System.out.println("***" + movesList[0]);
            listPretzel.add(Integer.parseInt(String.valueOf(movesList[1])));
//                System.out.println("###" + movesList[1]);
        } else if (Character.isDigit(movesList[0].charAt(0)) && !Character.isDigit(movesList[1].charAt(0))){
            
                if(movesList[1].charAt(0)=='<'){
                    
                    temp = Integer.parseInt(movesList[1].substring(1));
                    
                    for(int i =0; i < temp; i++){
                            listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0])));
                            //System.out.println(listPeanuts.get(0));
                            listPretzel.add(i);   
                            //System.out.println(listPretzel.get(i));
                    }
                    
                }else{
                
                    temp = Integer.parseInt(movesList[1].substring(1));
//                    System.out.print(temp + "JJJJJJ");
                    for(int i =temp; i <= totalPretz; i++){
                            listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0])));
                            System.out.print(listPeanuts.get(0));
                            listPretzel.add(i);   
                            System.out.println(" " + listPretzel.get(i));                 
                    }
                
                }
            
            
        }else if(!Character.isDigit(movesList[0].charAt(0)) && Character.isDigit(movesList[0].charAt(1))){
            
            
            
        }else if(!Character.isDigit(movesList[0].charAt(0)) && !Character.isDigit(movesList[0].charAt(1))){
            
            
           
        }
    }

}
