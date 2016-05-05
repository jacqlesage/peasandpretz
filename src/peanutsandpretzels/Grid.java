/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peanutsandpretzels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author James
 */
public class Grid {

    boolean grid[][];

    public Grid(boolean grid[][]) {

        this.grid = grid;
    }

    public void buildGrid(boolean grid[][], ArrayList<Integer> pea, ArrayList<Integer> pretz) {

        int p, pTemp = 0;
        int pz, pzTemp = 0;
        int count = 0;

        //0 0 in the grid is a sad place/false: True = sad i.e 0,0
        grid[0][0] = false;

        //System.out.println(grid[0].length);
        //go through each row in the grid
        for (int i = 0; i <= grid.length - 1; i++) {
            //go through each column in the grid
            for (int x = 0; x <= grid[0].length- 1; x++) {
                //go through each move in the moves list
//                System.out.println("i " + i + "x " + x);
                for (int j = 0; j < pea.size(); j++) {
                    //System.out.println(x);
                    //get the value of each move int the moves list
                    p = pea.get(j);
                    pz = pretz.get(j);

                    //minus the moves numbers from the row and index numbers
                    pTemp = i - p;
                    pzTemp = (x) - 
                            pz;
                    //if p/pztemp < the grid size then do nothing with that calculation
                    if (pTemp < 0 || pzTemp < 0) {
//                          System.out.println("p = " + p + ", pz" + pz + " =false" + "& neg " + " pTemp = " + pTemp + ", pzTemp" + pzTemp);
                        //if p/pztemp is not outside the grid size - if the position at that grid space is true ie
                        //it is a move that will lead to a happy spot then mark it true
                    } else if (pTemp < grid.length-1 && pzTemp < grid[0].length && grid[pTemp][pzTemp] == false) {
//                        System.out.println("p = " + p + ", pz" + pz + " =true " + " pTemp = " + pTemp + ", pzTemp" + pzTemp);
                        grid[i][x] = true;

                    } else if (pTemp == 0 && pzTemp == 0) {
//                         System.out.println("p = " + p + ", pz" + pz + " =true " + " pTemp = " + pTemp + ", pzTemp" + pzTemp);
                        grid[i][x] = true;

                    } else {
//                        System.out.println("p = " + p + ", pz" + pz + " =false " + " pTemp = " + pTemp + ", pzTemp" + pzTemp);
                    }
                }

            }
        }
        for (boolean[] x : grid) {
            System.out.println(Arrays.toString(x));
        }

    }

}
