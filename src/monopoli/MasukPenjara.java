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
public class MasukPenjara extends Tiles {
    private String deskripsi;
    private int ID;
    
    private static MasukPenjara penjara = new MasukPenjara();
    
    /**
     * Singleton dari MasukPenjara
     * @return kelas MasukPenjara
     */
    public static MasukPenjara getSingleton(){
        return penjara;
    }
    
    // konstruktor Tempat
    private MasukPenjara(){
        super();
    }
    
    // set deskripsi

    /**
     * setter deskripsi MasukPenjara
     * @param a akan diset untuk deskripsi MasukPenjara
     */
        public void setDesc(String a){
        deskripsi = a;
    }
    
    // get deskripsi

    /**
     * getter deskripsi MasukPenjara
     * @return deskripsi MasukPenjara
     */
        public String getDesc(){
        return deskripsi;
    }
    
    // set ID

    /**
     * setter ID MasukPenjara
     * @param a akan diset menjadi ID MasukPenjara
     */
        public void setID(int a){
        ID = a;
    }
    
    // get ID

    /**
     * getter ID MasukPenjara
     * @return ID MasukPenjara
     */
        public int getID(){
        return ID;
    }

    /**
     * Mencetak Tiles MasukPenjara ke layar
     */
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.CYAN).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }

    /**
     * Mencetak informasi tentang MasukPenjara
     */
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
    }
}
