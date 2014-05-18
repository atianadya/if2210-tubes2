/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoliswing;
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
    public int getID(){
        return ID;
    }
    public String getnama(){
    	return nama;
    }
    public int getuang(){
    	return uang;
    }
    public char getSymbol(){
        return Symbol;
    }
    // public ArrayList<Tempat> getaset(){ return aset; }

    public boolean getstatus(){
	return status;
    }
    
    public Tiles getposisi(){
        return posisi;
    }
    
    public boolean Isdiskors(){
        return diskors;
    }
    
    public void setnama(String n){
	this.nama = n;
    }

    public void setuang(int u){
	this.uang = u;
    }

    public void setstatus(boolean stat){
	this.status = stat;
    }
    
    public void setdiskors(boolean diskors){
        this.diskors = diskors;
    }
    public void setposisi(Tiles pos){
	this.posisi = pos;
	// gabisa gini kan? belum tau atribut2 tilenya T_T
    }
    
    public void setkartuskors(boolean skors){
	this.kartuskors = skors;
    }
    public boolean havekartuskors(){
        return kartuskors;
    }
    public int jumlahAsetTempatNonWifiNonMortgage(){
        int a = 0;
        for (Tiles A : aset){
            if((A instanceof TempatNonWifi)&&(!((TempatNonWifi)A).isMortgaged())){
                a++;
            }
        }
        return a;
    }
            
    public void viewaset(){ // ngeprint aset yang dimiliki player
        if(aset.isEmpty()){
            System.out.println(nama + " tidak mempunyai aset");
        }
        else{
            System.out.println("Tempat : ");
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
    public void tambahaset(Tiles A){
        aset.add(A);
    }
    public void HapusAllAset(){
        for(Tiles A :aset){
            if(A instanceof Tempat){
                Tempat B = (Tempat) A;
                if(B.getJumlahWifi()!=0){
                    B.setJumlahWifi(0);
                }
                B.setMortgage(true);
                B.setPemilik("Unknown");
            }
            else{
                assert(A instanceof TempatNonWifi);
                TempatNonWifi B = (TempatNonWifi) A;
                B.setMortgage(true);
                B.setPemilik("Unknown");
            }
        }
    }
    public void tambahuang(int tambah){
	this.uang = this.uang + tambah;
    }

    public void kuranguang(int kurang){
	this.uang = this.uang - kurang;
    }

    public void print(){
	System.out.println("Nama pemain: " + this.nama);
	System.out.println("Jumlah uang: " + this.uang);
	if (this.status){
            System.out.println("Pemain dapat melanjutkan permainan");
	}
	else {
            System.out.println("Pemain tidak dapat melanjutkan permainan");
	}
	if (this.kartuskors){
            System.out.println("Pemain memiliki kartu skorsing");
	}
	else {
            System.out.println("Pemain tidak memiliki kartu skorsing");
	}
    }
}
