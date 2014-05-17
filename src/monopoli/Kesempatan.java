package monopoli;


import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

public class Kesempatan extends Tiles {
    private String deskripsi;
    private int ID;
    
    // konstruktor Tempat
    public Kesempatan(){
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
    @Override
    public void setID(int a){
        ID = a;
    }
    
    // get ID
    @Override
    public int getID(){
        return ID;
    }
    @Override
    public void printTiles(){
        System.out.println(ansi().fg(Ansi.Color.MAGENTA).cursor(getX(),getY()).a(" _____"));
        for(int i=1;i<=3;i++){
            System.out.println(ansi().cursor(getX()+i,getY()).a("|     |"));
        }
        System.out.println(ansi().cursor(getX()+4,getY()).a("|_____|").fg(Ansi.Color.WHITE));
        System.out.println(ansi().cursor(getX()+1,getY()+1).a(ID));
    }
    @Override
    public void printInfo(){
        System.out.println("ID = "+ID);
        System.out.println("Deskripsi ="+deskripsi);
    }
}
