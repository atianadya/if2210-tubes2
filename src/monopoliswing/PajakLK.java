package monopoliswing;


import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class PajakLK extends Tiles {
    private String deskripsi;
    private int ID;
    private int hargapajak;
    private int hargabeli;
    
    private static PajakLK pajakLK = new PajakLK();
    
    public static PajakLK getSingleton(){
        return pajakLK;
    }
    
    // konstruktor Tempat
    private PajakLK(){
        super();
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

    // set harga pajak
    public void setHargapajak(int a){
        hargapajak = a;
    }

    // get harga pajak
    public int getHargapajak(){
        return hargapajak;
    }

    public void setHargabeli(int a){
        hargabeli = a;
    }

    public int getHargabeli(){
        return hargabeli;
    }
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.RED).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
        System.out.println("Harga Pajak = "+hargapajak);
        System.out.println("Harga Beli ="+hargabeli);
    }
}
