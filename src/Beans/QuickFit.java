/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Wolf
 */
public class QuickFit {
    public int number;
    public int count;
    public ArrayList<Processo> list = new ArrayList<Processo>();
    Random random = new Random();
    int nextInt = random.nextInt(256*256*256);
    public String color = String.format("#%06x", nextInt);
    
    public QuickFit(int number){
        this.number = number;
    }
    
    public QuickFit(int number,ArrayList<Processo> list) {
        this.number = number;
        this.list = list;
    }
    
    public QuickFit(int number, int count){
        this.number = number;
        this.count = count;
    }
    
}
