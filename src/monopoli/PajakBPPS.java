package monopoli;


import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class PajakBPPS extends Tiles {
    private String deskripsi;
    private int ID;
    private int hargapajak;
    
    private static PajakBPPS pajakBPPS = new PajakBPPS();
    
    /**
     * Singleton dari PajakBPPS
     * @return kelas PajakBPPS
     */
    public static PajakBPPS getSingleton(){
        return pajakBPPS;
    }
    
    // konstruktor Tempat
    private PajakBPPS(){
        super();
    }
    
    // set deskripsi

    /**
     * setter deskripsi PajakBPPS
     * @param a akan diset untuk deskripsi PajakBPPS
     */
        public void setDesc(String a){
        deskripsi = a;
    }
    
    // get deskripsi

    /**
     * getter deskripsi PajakBPPS
     * @return deskripsi PajakBPPS
     */
        public String getDesc(){
        return deskripsi;
    }
    
    // set ID

    /**
     * Setter ID PajakBPPS
     * @param a akan diset menjadi ID PajakBPPS 
     */
        public void setID(int a){
        ID = a;
    }
    
    // get ID

    /**
     * getter ID PajakBPPS
     * @return ID PajakBPPS
     */
        public int getID(){
        return ID;
    }

    // set harga pajak

    /**
     * setter Hargapajak PajakBPPS
     * @param a akan diset sebagai Hargapajak PajakBPPS
     */
        public void setHargapajak(int a){
        hargapajak = a;
    }

    // get harga pajak

    /**
     * getter Hargapajak PajakBPPS
     * @return Hargapajak PajakBPPS
     */
        public int getHargapajak(){
        return hargapajak;
    }

    /**
     * Mencetak Tiles PajakBPPS ke layar
     */
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.RED).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }

    /**
     * Mencetak informasi PajakBPPS ke layar
     */
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
        System.out.println("Harga Pajak = "+hargapajak);
    }
}
