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
    
    /**
     * Singleton ParkirBebas
     * @return kelas ParkirBebas
     */
    public static ParkirBebas getSingleton(){
        return parkir;
    }
    
    // konstruktor Tempat
    private ParkirBebas(){
        super();
        PajakTotal=0;
    }
    
    // set lokasi dari tempat

    /**
     * Setter lokasi ParkirBebas dari Tempat
     * @param a koordinat
     * @param b koordinat
     */
        public void setLokasi(int a, int b){
        setKoordinat(a,b);
    }
    
    // getter kordinat X

    /**
     * getter koordinat X
     * @return koordinat X
     */
        public int getKoorX(){
        return getX();
    }
    
    // getter koordinat Y

    /**
     * getter koordinat Y
     * @return koordinat Y
     */
        public int getKoorY(){
        return getY();
    }
    
    // set deskripsi

    /**
     * setter deskripsi ParkirBebas
     * @param a akan diset menjadi deskripsi ParkirBebas
     */
        public void setDesc(String a){
        deskripsi = a;
    }
    
    // get deskripsi

    /**
     * getter deskripsi ParkirBebas
     * @return deskripsi ParkirBebas
     */
        public String getDesc(){
        return deskripsi;
    }
    
    // set ID

    /**
     * setter ID ParkirBebas
     * @param a akan diset menjadi ID ParkirBebas
     */
        public void setID(int a){
        ID = a;
    }
    
    // get ID

    /**
     * getter ID ParkirBebas
     * @return ID ParkirBebas
     */
        public int getID(){
        return ID;
    }

    /**
     * Menambah PajakTotal pada ParkirBebas
     * @param PajakBaru akan ditambahkan pada PajakTotal pada ParkirBebas
     */
    public void tambahPajak(int PajakBaru){
        PajakTotal+=PajakBaru;
    }

    /**
     * Mengambil semua PajakTotal pada ParkirBebas
     * @return PajakTotal yang sudah diambil semua
     */
    public int ambilPajak(){
        int pajak = PajakTotal;
        PajakTotal = 0;
        return pajak;
    }

    /**
     * Mencetak Tiles ParkirBebas ke layar
     */
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.BLUE).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }

    /**
     * Mencetak info ParkirBebas ke layar
     */
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi = "+deskripsi);
        System.out.println("Total Pajak = "+PajakTotal);
    }
}
