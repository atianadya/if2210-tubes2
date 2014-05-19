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
public class TempatNonWifi extends Tiles{
    private String nama;
    private String deskripsi;
    private int ID;
    private int hargaBeli, hargaMortgage,hargaSewa;
    private String pemilik;
    private boolean mortgage;
    
    /**
     * konstruktor TempatNonWifi tanpa parameter
     */
        public TempatNonWifi(){
        super();
        mortgage = false;
    }
   
    /**
     * set nama dari Tempat
     * @param a String yang akan diset ke nama
     */
        public void setNama(String a){
        nama = a;
    }
    
    /**
     * get nama dari Tempat
     * @return nama
     */
        public String getNama(){
        return nama;
    }

    /**
     * set deskripsi Tempat
     * @param a String yang akan diset ke deskripsi
     */
        public void setDeskripsi(String a){
        deskripsi = a;
    }
 
    /**
     * getter deskripsi Tempat
     * @return deskripsi
     */
        public String getDesc(){
        return deskripsi;
    }

    /**
     * set ID Tempat
     * @param i integer yang akan diset ke ID
     */
        @Override
    public void setID(int i){
        ID = i;
    }
   
    /**
     * get ID Tempat
     * @return ID
     */
        @Override
    public int getID(){
        return ID;
    }
   
    /**
     * setter harga beli Tempat
     * @param a integer yang akan diset ke hargaBeli
     */
        public void setHargaBeli(int a){
        hargaBeli = a;
    }
   
    /**
     * getter harga beli Tempat
     * @return hargaBeli
     */
        public int getHargaBeli(){
        return hargaBeli;
    }
   
    /**
     * setter harga sewa Tempat
     * @param a integer yang akan diset ke hargaSewa
     */
        public void setHargaSewa(int a){
        hargaSewa = a;
    }
    
    /**
     * get hargaSewa Tempat
     * @return hargaSewa
     */
        public int getHargaSewa(){
        return hargaSewa;
    }

    /**
     * set hargaMortgage Tempat 
     * @param a integer yang akan diset ke hargaMortgage
     */
        public void setHargaMortgage(int a){
        hargaMortgage = a;
    }
    
    /**
     * get harga mortgage Tempat
     * @return hargaMortgage
     */
        public int getHargaMortgage(){
        return hargaMortgage;
    }
    
    /**
     * set pemilik dari Tempat
     * @param x String yang akan diset ke pemilik
     */
        public void setPemilik(String x){
        pemilik = x;
    }
    
    /**
     * get pemilik dari Tempat
     * @return pemilik
     */
        public String getPemilik(){
        return pemilik;
    }

    /**
     * set mortgage dari Tempat
     * @param status boolean yang akan diset ke mortgage
     */
    public void setMortgage(boolean status){
        mortgage = status;
    }

    /**
     * mengecek apakah tempat sedang digadaikan (mortgaged)
     * @return mortgage. 
     */
    public boolean isMortgaged(){
        return mortgage;
    }

    /**
     * mencetak Tile TempatNonWifi ke layar
     */
    @Override
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

    /**
     * mencetak semua informasi TempatNonWifi
     */
    @Override
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
