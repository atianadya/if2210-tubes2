package monopoliswing;


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
public class TempatNonWifi extends Tiles{
    private String nama;
    private String deskripsi;
    private int ID;
    private int hargaBeli, hargaMortgage,hargaSewa;
    private String pemilik;
    private boolean mortgage;
    
    // konstruktor Tempat
    public TempatNonWifi(){
        super();
        mortgage = false;
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
    
    // set nama dari Tempat
    public void setNama(String a){
        nama = a;
    }
    
    // get nama dari Tempat
    public String getNama(){
        return nama;
    }
    
    // set deskripsi Tempat
    public void setDeskripsi(String a){
        deskripsi = a;
    }
    
    // get deskripsi Tempat
    public String getDesc(){
        return deskripsi;
    }
    
    // set ID Tempat
    public void setID(int i){
        ID = i;
    }
    
    // get ID Tempat
    public int getID(){
        return ID;
    }
    
    // set harga beli Tempat
    public void setHargaBeli(int a){
        hargaBeli = a;
    }
    
    // get harga beli Tempat
    public int getHargaBeli(){
        return hargaBeli;
    }
    
    // set harga sewa Tempat
    public void setHargaSewa(int a){
        hargaSewa = a;
    }
    
    // get harga sewa Tempat
    public int getHargaSewa(){
        return hargaSewa;
    }
 
    // set harga mortgage Tempat
    public void setHargaMortgage(int a){
        hargaMortgage = a;
    }
    
    // get harga mortgage Tempat
    public int getHargaMortgage(){
        return hargaMortgage;
    }
    
    // set pemilik dari Tempat
    public void setPemilik(String x){
        pemilik = x;
    }
    
    // get pemilik dari Tempat
    public String getPemilik(){
        return pemilik;
    }
    public void setMortgage(boolean status){
        mortgage = status;
    }
    public boolean isMortgaged(){
        return mortgage;
    }
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.YELLOW).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
        System.out.print(ansi().bold());
        if(pemilik.equalsIgnoreCase("unknown")){
            System.out.println(ansi().cursor(getX()+1,getY()+3).a(" "));
        }
        else{
            System.out.println(ansi().cursor(getX()+1,getY()+3).a("B"));
        }
        if(mortgage){
            System.out.println(ansi().cursor(getX()+1,getY()+4).a("M"));
        }
        else{System.out.println(ansi().cursor(getX()+1,getY()+4).a(" "));}
        System.out.print(ansi().boldOff());
    }
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Nama = "+nama);
        System.out.println("Harga Beli = "+hargaBeli);
        System.out.println("Harga Sewa Awal= "+hargaSewa);
        System.out.println("Harga Mortgage = "+hargaMortgage);
        System.out.println("Pemilik = "+pemilik);
        if(mortgage==true){System.out.println("Tempat digadaikan");}
    }
}
