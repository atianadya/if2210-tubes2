package monopoli;


import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario
 */
public class Kosan extends Tiles {
    private String deskripsi;
    private int ID;
    
    private static Kosan kosan = new Kosan();
    
    public static Kosan getSingleton(){
        return kosan;
    }
    
    // konstruktor Tempat
    private Kosan(){
        super();
    }
    
    /**
     * set deskripsi
     * @param a String yang akan diset ke deskripsi
     */
        public void setDesc(String a){
        deskripsi = a;
    }
    
    /**
     * getter deskripsi
     * @return deskripsi
     */
        public String getDesc(){
        return deskripsi;
    }

    /**
     * set ID
     * @param a integer yang akan diset ke ID
     */
        @Override
    public void setID(int a){
        ID = a;
    }
   
    /**
     * get ID
     * @return ID
     */
        @Override
    public int getID(){
        return ID;
    }

    /**
     * mencetak Tiles kosan ke layar
     */
    @Override
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.CYAN).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }

    /**
     * mencetak ID dan deskripsi Tile kosan
     */
    @Override
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
    }
}
