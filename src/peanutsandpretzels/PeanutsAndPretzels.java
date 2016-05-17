/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package peanutsandpretzels;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
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
        int count = 0;
        boolean line1 = true;
        String movesList[];
        ArrayList<Integer> listPeanuts = new ArrayList<Integer>();
        ArrayList<Integer> listPretzel = new ArrayList<Integer>();
        boolean grid[][];
        int totalMovesList[][];
//get input 
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

                line1 = false;

            } else if (!s.equals("")) {

                movesList = s.split(" ");

                addMovesList(movesList, listPeanuts, listPretzel, totalPea, totalPretz);


            } else if (s.equals("")) {

                listPeanuts.add(0);
                listPretzel.add(1);
                listPeanuts.add(1);
                listPretzel.add(0);

                grid = new boolean[Integer.valueOf(totalPea) + 1][Integer.valueOf(totalPretz) + 1];

                for (int i = 0; i < listPeanuts.size(); i++) {

                }


                Grid g = new Grid(grid, listPeanuts, listPretzel, totalPea, totalPretz);

                g.buildGrid();
                g.getOutput();


                line1 = true;
                totalPea = 0;
                totalPretz = 0;
                listPeanuts = new ArrayList<Integer>();
                listPretzel = new ArrayList<Integer>();
            }
            count++;
        }

        listPeanuts.add(0);
        listPretzel.add(1);
        listPeanuts.add(1);
        listPretzel.add(0);

        grid = new boolean[Integer.valueOf(totalPea) + 1][Integer.valueOf(totalPretz) + 1];

        for (int i = 0; i < listPeanuts.size(); i++) {

        }


        Grid g = new Grid(grid, listPeanuts, listPretzel, totalPea, totalPretz);

        g.buildGrid();
        g.getOutput();

        line1 = true;
        totalPea = 0;
        totalPretz = 0;
        listPeanuts = new ArrayList<Integer>();
        listPretzel = new ArrayList<Integer>();
        
        
    }
    
    
//end getting of input 
    /**
     * 
     * 
     * @param movesList 
     * @param listPeanuts - peanuts moves you are able to take
     * @param listPretzel- pretzels moves you are able to take
     * @param totalPea - amount of peanuts
     * @param totalPretz  - amount of pretzels 
     */
    private static void addMovesList(String[] movesList, ArrayList<Integer> listPeanuts, ArrayList<Integer> listPretzel, int totalPea, int totalPretz) {
        
        int temp;
        int temp2;
//checking of cases - see cases in comments 
        if (Character.isDigit(movesList[0].charAt(0)) && Character.isDigit(movesList[1].charAt(0))) {

            listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0])));

            listPretzel.add(Integer.parseInt(String.valueOf(movesList[1])));

        } else if (Character.isDigit(movesList[0].charAt(0)) && !Character.isDigit(movesList[1].charAt(0))) {
            // x <y
            if (movesList[1].charAt(0) == '<') {
//                System.out.println("case 2.1");
                temp = Integer.parseInt(movesList[1].substring(1));

                for (int i = 0; i < temp; i++) {
                    listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0]).substring(0)));

                    listPretzel.add(i);

                }
                // x >y
            } else {
//                System.out.println("case 2.2");
                temp = Integer.parseInt(movesList[1].substring(1));

                for (int i = temp + 1; i <= totalPretz; i++) {

                    listPeanuts.add(Integer.parseInt(String.valueOf(movesList[0]).substring(0)));

                    listPretzel.add(i);

                }
            }

        } else if (!Character.isDigit(movesList[0].charAt(0)) && Character.isDigit(movesList[1].charAt(0))) {
            // <x y
            if (movesList[0].charAt(0) == '<') {
//                System.out.println("case 3.1");
                temp = Integer.parseInt(movesList[0].substring(1));

                for (int i = 0; i < temp; i++) {
                    listPeanuts.add(i);

                    listPretzel.add(Integer.parseInt(String.valueOf(movesList[1]).substring(0)));
      
                }
                // >x y
            } else {
                temp = Integer.parseInt(movesList[0].substring(1));
//                System.out.println("case 3.2");

                for (int i = temp + 1; i <= totalPea; i++) {
                    listPretzel.add(i);

                    listPeanuts.add(Integer.parseInt(String.valueOf(movesList[1]).substring(0)));

                }
            }

        } else if (!Character.isDigit(movesList[0].charAt(0)) && !Character.isDigit(movesList[1].charAt(0))) {
            // <x <y
            if (movesList[0].charAt(0) == '<' && movesList[1].charAt(0) == '<') {
//                System.out.println("case 4.1");
                temp = Integer.parseInt(movesList[0].substring(1));
                temp2 = Integer.parseInt(movesList[1].substring(1));

                for (int i = 0; i < temp; i++) {
                    for (int j = 0; j < temp2; j++) {

                        if (i == 0 && j == 0) {
                            continue;
                        }
                        listPeanuts.add(i);
                        listPretzel.add(j);
                    }
                }
            }
            // >x >y
            if (movesList[0].charAt(0) == '>' && movesList[1].charAt(0) == '>') {
//                System.out.println("case 4.2");
                temp = Integer.parseInt(movesList[0].substring(1));
                temp2 = Integer.parseInt(movesList[1].substring(1));

                for (int i = temp + 1; i <= totalPea; i++) {
                    for (int j = temp2 + 1; j <= totalPretz; j++) {
                        listPeanuts.add(i);
                        listPretzel.add(j);
                    }
                }
            }
            // <x >y
            if (movesList[0].charAt(0) == '<' && movesList[1].charAt(0) == '>') {
//                System.out.println("case 4.3");
                temp = Integer.parseInt(movesList[0].substring(1));
                temp2 = Integer.parseInt(movesList[1].substring(1));

                for (int i = 0; i < temp; i++) {
                    for (int j = temp2 + 1; j <= totalPretz; j++) {
                        listPeanuts.add(i);
                        listPretzel.add(j);
                    }
                }
            }
            // >x <y
            if (movesList[0].charAt(0) == '>' && movesList[1].charAt(0) == '<') {
//                System.out.println("case 4.4");
                temp = Integer.parseInt(movesList[0].substring(1));
                temp2 = Integer.parseInt(movesList[1].substring(1));

                for (int i = temp + 1; i <= totalPea; i++) {
                    for (int j = 0; j < temp2; j++) {
                        listPeanuts.add(i);
                        listPretzel.add(j);
                    }
                }
            }
            
            
        }
    }
    
}
