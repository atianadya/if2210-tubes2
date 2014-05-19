package monopoli;

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

    /**
     * Konstruktor Tiles tanpa parameter
     */
    public Tiles(){
        x=0;
        y=0;
        ID=-1;
    }

    /**
     * Konstruktor Tiles dengan parameter
     * @param new_x koordinat
     * @param new_y koordinat
     */
    public Tiles(int new_x,int new_y){
        x = new_x;
        y = new_y;
        ID=-1;
    }

    /**
     * getter koordinat X
     * @return koordinat X
     */
    public int getX(){
        return x;
    }

    /**
     * getter koordinat Y
     * @return koordinat Y
     */
    public int getY(){
        return y;
    }

    /**
     * setter koordinat
     * @param a koordinat
     * @param b koordinat
     */
    public void setKoordinat(int a,int b){
        x=a;
        y=b;
    }

    /**
     * setter ID
     * @param new_ID ID yang akan diset
     */
    public void setID(int new_ID){
    }

    /**
     * getter ID
     * @return ID Tiles
     */
    public int getID(){
        return ID;
    }

    /**
     * Mencetak Tiles ke layar
     */
    public void printTiles(){}

    /**
     * Mencetak info Tiles ke layar
     */
    public void printInfo(){}  
}
