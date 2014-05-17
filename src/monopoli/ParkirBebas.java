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
public class ParkirBebas extends Tiles {
    private String deskripsi;
    private int ID;
    private int PajakTotal;
    private static ParkirBebas parkir = new ParkirBebas();
    
    public static ParkirBebas getSingleton(){
        return parkir;
    }
    
    // konstruktor Tempat
    private ParkirBebas(){
        super();
        PajakTotal=0;
    }
    
    // set lokasi dari tempat
    public void setLokasi(int a, int b){
        setKoordinat(a,b);
    }
    
    // getter kordinat X
    public int getKoorX(){
        return getX();
    }
    
    // getter koordinat Y
    public int getKoorY(){
        return getY();
    }
    
    // set deskripsi
    public void setDesc(String a){
        deskripsi = a;
    }
    
    // get deskripsi
    public String getDesc(){
        return deskripsi;
    }
    
    // set ID
    public void setID(int a){
        ID = a;
    }
    
    // get ID
    public int getID(){
        return ID;
    }
    public void tambahPajak(int PajakBaru){
        PajakTotal+=PajakBaru;
    }
    public int ambilPajak(){
        int pajak = PajakTotal;
        PajakTotal = 0;
        return pajak;
    }
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.BLUE).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi = "+deskripsi);
        System.out.println("Total Pajak = "+PajakTotal);
    }
}
