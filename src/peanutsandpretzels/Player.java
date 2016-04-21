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
    public ArrayList<Integer> pea;
    public ArrayList<Integer> pretz;
    int[] peanutsList;
    int[] pretzList;
    
    public Player (int playerNumber, ArrayList<Integer> pea, ArrayList<Integer> pretz){
    
        this.playerNumber = playerNumber;
        this.pea = pea;
        this.pretz = pretz;
    
    }
    
    
    public static boolean noMovesEffectOutcome(int totalPeanuts, int totalPretzels, ArrayList<Integer> pea, ArrayList<Integer> pretz ){
        //if all the numbers in the pea/pretz list added togehter do not go over the amount of peanuts/pretz left then at this
        //stage best to take one from the one with most in it ? return boolean?
        int peaTotal =0;
        int pretzTotal =0;
        int count =0;
        Iterator i = pea.iterator();
        Iterator j = pretz.iterator();
        boolean movesEffect = false;

        
        while(i.hasNext() && count != pea.size()){
            peaTotal += pea.get(count);
            System.out.println(peaTotal);
            count++;
        }
        
        count =0;
        
        while(j.hasNext() && count != pretz.size()){
            pretzTotal += pretz.get(count);
            System.out.println(pretzTotal);
            count++;
        }
        
        if(peaTotal >= totalPeanuts || pretzTotal >= totalPretzels){
            movesEffect = true;            
        }
//        System.out.println("moveseffect " + movesEffect);
        return movesEffect;
    }
    
    
    
}
