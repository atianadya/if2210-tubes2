package monopoli;


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
public class Tempat extends Tiles{
    private String nama;
    private String deskripsi;
    private int ID;
    private int hargaBeli, hargaMortgage,hargaSewa;
    private String pemilik;
    private int jumlahWifi, harga1Wifi;
    private boolean mortgage;
    
    // konstruktor Tempat

    /**
     * Konstruktor Tempat tanpa parameter
     */
        public Tempat(){
        super();
        jumlahWifi = 0;
        mortgage = false;
    }
    
    // set nama dari Tempat

    /**
     * setter nama Tempat
     * @param a akan diset menjadi nama Tempat
     */
        public void setNama(String a){
        nama = a;
    }
    
    // get nama dari Tempat

    /**
     * getter nama Tempat
     * @return nama Tempat
     */
        public String getNama(){
        return nama;
    }
    
    // set deskripsi Tempat

    /**
     * setter deskripsi Tempat
     * @param a akan diset menjadi deskripsi Tempat
     */
        public void setDeskripsi(String a){
        deskripsi = a;
    }
    
    // get deskripsi Tempat

    /**
     * getter deskripsi Tempat
     * @return deskripsi Tempat
     */
        public String getDesc(){
        return deskripsi;
    }
    
    // set ID Tempat

    /**
     * setter ID Tempat
     * @param i akan diset menjadi ID Tempat
     */
        @Override
    public void setID(int i){
        ID = i;
    }
    
    // get ID Tempat

    /**
     * getter ID Tempat
     * @return ID Tempat
     */
        @Override
    public int getID(){
        return ID;
    }
    
    // set harga beli Tempat

    /**
     * setter hargaBeli Tempat
     * @param a akan diset menjadi hargaBeli Tempat
     */
        public void setHargaBeli(int a){
        hargaBeli = a;
    }
    
    // get harga beli Tempat

    /**
     * getter hargaBeli Tempat
     * @return hargaBeli Tempat
     */
        public int getHargaBeli(){
        return hargaBeli;
    }
    
    // set harga sewa Tempat

    /**
     * setter hargaSewa Tempat
     * @param a akan diset menjadi hargaSewa Tempat
     */
        public void setHargaSewa(int a){
        hargaSewa = a;
    }
    
    // get harga sewa Tempat

    /**
     * getter hargaSewa Tempat
     * @return hargaSewa Tempat
     */
        public int getHargaSewa(){
        return hargaSewa;
    }
    
    // set harga mortgage Tempat

    /**
     * setter hargaMortgage Tempat
     * @param a akan diset menjadi hargaMortgage Tempat
     */
        public void setHargaMortgage(int a){
        hargaMortgage = a;
    }
    
    // get harga mortgage Tempat

    /**
     * getter hargaMortgage Tempat
     * @return hargaMortgage Tempat
     */
        public int getHargaMortgage(){
        return hargaMortgage;
    }
    
    // set pemilik dari Tempat

    /**
     * setter pemilik Tempat
     * @param x akan diset menjadi pemilik Tempat
     */
        public void setPemilik(String x){
        pemilik = x;
    }
    
    // get pemilik dari Tempat

    /**
     * getter pemilik Tempat
     * @return pemilik Tempat
     */
        public String getPemilik(){
        return pemilik;
    }
    
    // set harga wifi

    /**
     * setter harga1Wifi Tempat
     * @param a akan diset menjadi harga1Wifi Tempat
     */
        public void setHargaWifi(int a){
        harga1Wifi = a;
    }
    
    // get harga 1 wifi

    /**
     * getter harga1Wifi Tempat
     * @return harga1Wifi Tempat
     */
        public int getHargaWifi(){
        return harga1Wifi;
    }
    
    // menambah Wifi

    /**
     * menambahkan jumlah wifi
     */
        public void tambahkanWifi(){
        jumlahWifi++;
    }
    
    // mengurangi Wifi

    /**
     * mengurangi jumlah wifi
     */
        public void kurangiWifi(){
        if (jumlahWifi > 0) {
            jumlahWifi--;
        }
    }
    
    // get jumlah Wifi

    /**
     * getter jumlahWifi Tempat
     * @return jumlahWifi
     */
        public int getJumlahWifi(){
        return jumlahWifi;
    }

    /**
     * setter jumlahWifi Tempat
     * @param a akan diset menjadi jumlahWifi Tempat
     */
    public void setJumlahWifi(int a){
        jumlahWifi = a;
    }
    public void setMortgage(boolean status){
        mortgage = status;
    }

    /**
     * memeriksa apakah Tempat di-mortgage atau tidak
     * @return true = tempat di mortgage, atau false = tempat tidak di mortgage
     */
    public boolean isMortgaged(){
        return mortgage;
    }

    /**
     * Mencetak Tiles Tempat ke layar
     */
    public void printTiles(){
        System.out.println(ansi().cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|"));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
        System.out.print(ansi().bold());
        if(pemilik.equalsIgnoreCase("unknown")){
            System.out.println(ansi().cursor(getX()+1,getY()+3).a(" "));
        }
        else{System.out.println(ansi().cursor(getX()+1,getY()+3).a("B"));}
        if(mortgage){
            System.out.println(ansi().cursor(getX()+1,getY()+4).a("M"));
        }
        else{System.out.println(ansi().cursor(getX()+1,getY()+4).a(" "));}
        if(jumlahWifi!=0){
            System.out.println(ansi().cursor(getX()+1,getY()+5).a(jumlahWifi));
        }
        else{System.out.println(ansi().cursor(getX()+1,getY()+5).a(" "));}
        System.out.print(ansi().boldOff());
    }

    /**
     * Mencetak info Tempat
     */
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Nama = "+nama);
        System.out.println("Harga Beli = "+hargaBeli);
        System.out.println("Harga Sewa Awal = "+hargaSewa);
        System.out.println("Harga Mortgage = "+hargaMortgage);
        System.out.println("Pemilik = "+pemilik);
        if(mortgage==true){System.out.println("Tempat digadaikan");}
        System.out.println("Harga Wifi = "+harga1Wifi);
        System.out.println("Jumlah Wifi = "+jumlahWifi);
    }
    
}
