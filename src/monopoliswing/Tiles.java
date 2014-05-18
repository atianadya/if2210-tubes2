package monopoliswing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author Riska
 */
public class Tiles {
    private int x,y;
    private int ID;
    public Tiles(){
        x=0;
        y=0;
        ID=-1;
    }
    public Tiles(int new_x,int new_y){
        x = new_x;
        y = new_y;
        ID=-1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setKoordinat(int a,int b){
        x=a;
        y=b;
    }
    public void setID(int new_ID){
    }
    public int getID(){
        return ID;
    }
    public void printTiles(){}
    public void printInfo(){}  
}
