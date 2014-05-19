/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoli;
import java.util.ArrayList;

/**
 *
 * @author Fahmi
 */
public class Player {
    private int ID;
    private String nama;
    private char Symbol;
    private int uang;
    private ArrayList<Tiles> aset;
    private boolean status; // true = pemain dapat main, false = pemain tidak bisa main
    private Tiles posisi;
    private boolean kartuskors; // true = punya kartu bebas skors, false = tidak punya kartu bebas skors
    private boolean diskors;
    // konstruktor

    /**
     * Konstruktor Player dengan parameter ID, nama, Symbol, dan posisi
     * @param ID ID untuk Player
     * @param nama nama Player
     * @param Symbol Symbol untuk membedakan Player satu dengan Player yang lain
     * @param posisi posisi Player pada Tiles
     */
        public Player(int ID, String nama, char Symbol,Tiles posisi){
        this.ID = ID;
        this.nama = nama;
        this.Symbol = Symbol;
	uang = 15000;
	aset = new ArrayList<>();
	status = true;
	this.posisi = posisi;
	kartuskors = false;
        diskors = false;
    }

    /**
     * Konstruktor Player dengan parameter nama, uang, status, dan kartuskors
     * @param nama nama Player
     * @param uang jumlah uang yang dimiliki Player
     * @param status status bermain Player, apakah dapat mengocok dadu atau tidak
     * @param kartuskors menandakan apakah Player memiliki kartuskors atau tidak
     */
    public Player(String nama, int uang, boolean status, boolean kartuskors){
	this.nama = nama;
	this.uang = uang;
	this.aset = new ArrayList<>();
	this.status = status;
	this.posisi = new Tiles();
	this.kartuskors = kartuskors;
        diskors = false;
    }

    // getter & setter

    /**
     * getter ID Player
     * @return ID Player yang bertipe integer
     */
        public int getID(){
        return ID;
    }

    /**
     * getter nama Player
     * @return nama Player yang bertipe String
     */
    public String getnama(){
    	return nama;
    }

    /**
     * getter uang Player
     * @return jumlah uang yang dimiliki oleh Player, bertipe integer
     */
    public int getuang(){
    	return uang;
    }

    /**
     * getter symbol Player
     * @return symbol yang dimiliki oleh Player yang bertipe char
     */
    public char getSymbol(){
        return Symbol;
    }
    
    /**
     * getter status Player
     * @return status Player yang bertipe boolean
     */
    public boolean getstatus(){
	return status;
    }
    
    /**
     * getter posisi Player
     * @return posisi Player yang bertipe Tiles
     */
    public Tiles getposisi(){
        return posisi;
    }
    
    /**
     * memeriksa apakah Player sedang diskorsing atau tidak
     * @return boolean, true jika Player sedang diskorsing, false jika Player sedang tidak diskorsing
     */
    public boolean Isdiskors(){
        return diskors;
    }
    
    /**
     * setter nama Player
     * @param n String yang akan diset ke nama Player
     */
    public void setnama(String n){
	this.nama = n;
    }

    /**
     * setter uang Player
     * @param u integer yang akan di set ke uang Player
     */
    public void setuang(int u){
	this.uang = u;
    }

    /**
     * setter status Player
     * @param stat boolean yang akan di set ke status Player, true = Player dapat mengocok dadu, false = Player tidak dapat mengocok dadu
     */
    public void setstatus(boolean stat){
	this.status = stat;
    }
    
    /**
     * setter diskors Player
     * @param diskors boolean yang akan diset ke diskors Player, true = Player sedang diskorsing, false = Player tidak sedang diskorsing
     */
    public void setdiskors(boolean diskors){
        this.diskors = diskors;
    }

    /**
     * setter posisi Player
     * @param pos Tiles yang akan diset ke posisi Player
     */
    public void setposisi(Tiles pos){
	this.posisi = pos;	
    }
    
    /**
     * setter kartuskors Player
     * @param skors boolean yang akan di set ke kartuskors Player. true = Player memiliki kartu bebas skorsing. false = Player tidak memiliki kartu bebas skorsing
     */
    public void setkartuskors(boolean skors){
	this.kartuskors = skors;
    }

    /**
     * memeriksa apakah Player memiliki kartu bebas skors atau tidak
     * @return boolean yang menyatakan apakah Player memiliki kartu bebas skors atau tidak. true = Player memiliki kartu bebas skorsing. false = Player tidak memiliki kartu skorsing
     */
    public boolean havekartuskors(){
        return kartuskors;
    }

    /**
     * Menghitung jumlah TempatNonWifi tidak di-mortgage yang dimiliki oleh Player
     * @return integer yang menyatakan jumlah TempatNonWifi tidak di-mortgage yang dimiliki oleh Player
     */
    public int jumlahAsetTempatNonWifiNonMortgage(){
        int a = 0;
        for (Tiles A : aset){
            if((A instanceof TempatNonWifi)&&(!((TempatNonWifi)A).isMortgaged())){
                a++;
            }
        }
        return a;
    }
            
    /**
     * Mencetak aset-aset Tempat / TempatNonWifi yang dimiliki oleh Player
     */
    public void viewaset(){ // ngeprint aset yang dimiliki player
        if(aset.isEmpty()){
            System.out.println(nama + " tidak mempunyai aset");
        }
        else{
            System.out.println("Aset milik "+nama+". Tempat : ");
            for(Tiles A :aset){
                if(A instanceof Tempat){
                    System.out.println(((Tempat)A).getID()+" "+((Tempat)A).getNama());
                }
                else{
                    assert(A instanceof TempatNonWifi);
                    System.out.println(((TempatNonWifi)A).getID()+" "+((TempatNonWifi)A).getNama());
                }
            }
        }
        
    }

    /**
     * Menambah aset yang dimiliki oleh Player
     * @param A Tiles yang akan ditambah pada Player sebagai aset
     */
    public void tambahaset(Tiles A){
        aset.add(A);
    }

    /**
     * Menghapus semua aset yang dimiliki oleh Player
     */
    public void HapusAllAset(){
        for(Tiles A :aset){
            if(A instanceof Tempat){
                Tempat B = (Tempat) A;
                if(B.getJumlahWifi()!=0){
                    B.setJumlahWifi(0);
                }
                B.setMortgage(false);
                B.setPemilik("Unknown");
            }
            else{
                assert(A instanceof TempatNonWifi);
                TempatNonWifi B = (TempatNonWifi) A;
                B.setMortgage(false);
                B.setPemilik("Unknown");
            }
        }
    }

    /**
     * Menambah uang yang dimiliki oleh Player
     * @param tambah integer yang akan ditambahkan pada uang Player
     */
    public void tambahuang(int tambah){
	this.uang = this.uang + tambah;
    }

    /**
     * Mengurangi uang pemain yang dimiliki oleh Player
     * @param kurang integer yang akan dikurangkan pada uang Player
     */
    public void kuranguang(int kurang){
	this.uang = this.uang - kurang;
    }

    /**
     * Mencetak segala informasi tentang Player
     */
    public void print(){
	System.out.println("Nama pemain: " + this.nama);
        System.out.println("Simbol pemain: " + Symbol);
	System.out.println("Jumlah uang: " + this.uang);
	System.out.println("Jumlah aset: " + this.aset.size());
        System.out.println("Pemain berada di ID: "+posisi.getID());
        if(this.diskors){
            System.out.println("Pemain sedang diskors");
        }
        else{
            System.out.println("Pemain tidak sedang diskors");
        }
	if (this.kartuskors){
            System.out.println("Pemain memiliki kartu skorsing");
	}
	else {
            System.out.println("Pemain tidak memiliki kartu skorsing");
	}
    }
}
