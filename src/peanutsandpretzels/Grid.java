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
//
//        for (int x = 0; x < pea.size(); x++) {
//
//            p = pea.get(0);
//            pz = pretz.get(0);
//
//            pTemp = p - 0;
//            pzTemp = pz - (x);
//
//            if (pTemp < 0 || pzTemp < 0) {
//                //System.out.println(grid[0][x]);
////                 grid[0][x] = true;
//            } else if (grid[pTemp][pzTemp] == true) {
//                //System.out.println("matched a sad case statement");
//                grid[0][x] = true;
//
//            }
//
//        }
//        for (boolean[] x : grid) {
//            System.out.println(Arrays.toString(x));
//        }

        //********End of creating the first line - now to complete the remainder of the table.
//                p = pea.get(count);
//                pz = pretz.get(count);
//                System.out.print(p);
//                System.out.println("**** " + pz);
//                System.out.print("0");
//                System.out.println("%%%% " + i);
//                pTemp =  p - 0;
//                pzTemp = pz - i;
//                System.out.print(pTemp);
//                System.out.println(" " + pzTemp);
//                count++;
//            
//        }
        //System.out.println(grid.length);
        for (int i = 0; i <= grid.length-1; i++) {
            for (int x = 0; x <= grid.length-1; x++) {
               
                for(int j = 0; j <  pea.size(); j++){
                //System.out.println(x);
                p = pea.get(j);
                pz = pretz.get(j);
                
                //System.out.println("i " + i + " x " + x );
                //System.out.println("p " + p + " pz " + pz );
                pTemp = p - i;
                pzTemp = pz - (x);
//               System.out.println("p " + p + " pz " + pz );
//               System.out.println("pTemp " + pTemp + " pzTemp " + pzTemp );
//                    System.out.println("^^^^^^^^^^^^");
                if (pTemp < 0 || pzTemp < 0) {
                    //System.out.println(grid[0][x]);
//                 grid[0][x] = true;
                } else if (pTemp < grid.length && pzTemp < grid.length && grid[pTemp][pzTemp] == true) {
//                    System.out.println(" i " + i + " x " + x +" j "+ j);
//                    System.out.println("p " + p + " pz " + pz );
//                    System.out.println("$$$#$#$#$#" );
                    grid[i][x] = true;

                }else if (pTemp == 0 && pzTemp == 0 ){
//            
                     grid[i][x] = true;
                    
                }

            }

          }
        }
        for (boolean[] x : grid) {
            System.out.println(Arrays.toString(x));
        }

    }

}
