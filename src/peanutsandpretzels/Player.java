/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peanutsandpretzels;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author James
 */
public class Player {
    
   public int playerNumber;
   public boolean grid[][];
    
    public Player (int playerNumber, boolean grid[][]){
    
        this.playerNumber = playerNumber;
        this.grid = grid;
    
    
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }


  
    
    
   
    
    
//    public static boolean movesEffectOutcome(int totalPeanuts, int totalPretzels, ArrayList<Integer> pea, ArrayList<Integer> pretz ){
//        //if all the numbers in the pea/pretz list added togehter do not go over the amount of peanuts/pretz left then at this
//        //stage best to take one from the one with most in it ? return boolean?
//        int peaTotal =0;
//        int pretzTotal =0;
//        int count =0;
//        Iterator i = pea.iterator();
//        Iterator j = pretz.iterator();
//        boolean movesEffect = false;
//
//        
//        while(i.hasNext() && count != pea.size()){
//            peaTotal += pea.get(count);
//            System.out.println(peaTotal);
//            count++;
//        }
//        
//        count =0;
//        
//        while(j.hasNext() && count != pretz.size()){
//            pretzTotal += pretz.get(count);
//            System.out.println(pretzTotal);
//            count++;
//        }
//        
//        if(peaTotal <= totalPeanuts || pretzTotal <= totalPretzels){
//            movesEffect = true;            
//        }
////        System.out.println("moveseffect " + movesEffect);
//        return movesEffect;
//    }
//    
//    public static boolean canWin(int goalPea, int goalPretz, Player player){
//        //search moves list to see if any moves can provide a win
//        boolean canWin = false;
//        
//        ArrayList<Integer> peaList = new ArrayList();
//        ArrayList<Integer> pretzList = new ArrayList();
//        peaList = player.getPea();
//  
//        pretzList = player.getPretz();
//        int temp =0;
//        
//        while(temp <= peaList.size()-1){
//           
//            if(peaList.get(temp).equals(goalPea) && pretzList.get(temp).equals(goalPretz) ){
//                System.out.println(peaList.get(temp));
//                System.out.println(pretzList.get(temp));
//                canWin = true;    
//            }
//            temp++;
//        }
//        
//        
//        
//        //search moves list to find if taking any of the moves will leave the other player with an option to win - in other 
//        //words check to make sure the move I take does not let him make a winning move.
//       
//        return canWin;
//    }
//    
//    public static void calculatePositions(int goalPea, int goalPretz, Player player){
//        ArrayList<Integer> peaList = new ArrayList();
//        ArrayList<Integer> pretzList = new ArrayList();
//        peaList = player.getPea();
//        pretzList = player.getPretz();
//        int temp =0;
//        Iterator i = peaList.iterator();
//        Iterator j = pretzList.iterator();
//        
//        while(i.hasNext()){
//            //if()
//        
//        }
//        
//    }

    
    
}
