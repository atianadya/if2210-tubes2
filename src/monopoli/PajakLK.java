package monopoli;


import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class PajakLK extends Tiles {
    private String deskripsi;
    private int ID;
    private int hargapajak;
    private int hargabeli;
    
    private static PajakLK pajakLK = new PajakLK();
    
    /**
     * singleton pajakLK
     * @return pajakLK
     */
    public static PajakLK getSingleton(){
        return pajakLK;
    }
    
    // konstruktor Tempat
    private PajakLK(){
        super();
    }
    
    /**
     * setter deskripsi
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
     * setter hargapajak
     * @param a integer yang akan diset ke hargapajak
     */
        public void setHargapajak(int a){
        hargapajak = a;
     }

    /**
     * getter hargapajak
     * @return hargapajak
     */
        public int getHargapajak(){
        return hargapajak;
    }

    /**
     * setter hargabeli
     * @param a integer yang akan diset ke harga beli
     */
    public void setHargabeli(int a){
        hargabeli = a;
    }

    /**
     * getter hargabeli
     * @return hargabeli
     */
    public int getHargabeli(){
        return hargabeli;
    }

    /**
     * mencetak Tiles pajakLK ke layar
     */
    @Override
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.RED).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }

    /**
     * mencetak semua informasi Tile pajakLK
     */
    @Override
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
        System.out.println("Harga Pajak = "+hargapajak);
        System.out.println("Harga Beli ="+hargabeli);
    }
}
