package monopoliswing;

import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.fusesource.jansi.Ansi.ansi;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riska
 */
public class BoardView {
    public static final int BOARD_WIDTH = 78;
    public static final int BOARD_HEIGHT = 56;
    private LinkedList<Tiles> ListOfTiles;
    // inisialisasi tempat di tiles
    public BoardView(){
        ListOfTiles = new LinkedList<>();
        Initialization();
    }
    private void Initialization(){
        Tempat tempat;
        TempatNonWifi tempatnonwifi;
        StartTempat starttempat;
        Kesempatan kesempatan;
        Kosan kosan;
        ParkirBebas parkirbebas;
        MasukPenjara masukpenjara;
        PajakLK pajaklk;
        PajakBPPS pajakbpps;
        String nama, deskripsi, pemilik;
        int ID, hargaBeli, hargaMortgage, jumlahWifi, harga1Wifi, hargabeli, hargapajak, hargaSewa;
        try {
            //getting xml file
            File fXmlFile = new File("tiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
         
            //inserting card IDs and Effects into arrays
            NodeList nList = doc.getElementsByTagName("tile");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String type = eElement.getAttribute("type");
                    switch(type){
                            case "Tempat" :
                                tempat = new Tempat();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                tempat.setID(ID);
                                nama = eElement.getElementsByTagName("nama").item(0).getTextContent();
                                tempat.setNama(nama);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                tempat.setDeskripsi(deskripsi);
                                hargaBeli = Integer.parseInt(eElement.getElementsByTagName("hargabeli").item(0).getTextContent());
                                tempat.setHargaBeli(hargaBeli);
                                hargaMortgage = Integer.parseInt(eElement.getElementsByTagName("hargamortgage").item(0).getTextContent());
                                tempat.setHargaMortgage(hargaMortgage);
                                pemilik = eElement.getElementsByTagName("pemilik").item(0).getTextContent();
                                tempat.setPemilik(pemilik);
                                jumlahWifi = Integer.parseInt(eElement.getElementsByTagName("jumlahwifi").item(0).getTextContent());
                                tempat.setJumlahWifi(jumlahWifi);
                                harga1Wifi = Integer.parseInt(eElement.getElementsByTagName("harga1wifi").item(0).getTextContent());
                                tempat.setHargaWifi(harga1Wifi);
                                hargaSewa = Integer.parseInt(eElement.getElementsByTagName("hargasewa").item(0).getTextContent());
                                tempat.setHargaSewa(hargaSewa);
                                ListOfTiles.add(tempat);
                                break;
                            
                            case "TempatNonWifi" :
                                tempatnonwifi = new TempatNonWifi();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                tempatnonwifi.setID(ID);
                                nama = eElement.getElementsByTagName("nama").item(0).getTextContent();
                                tempatnonwifi.setNama(nama);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                tempatnonwifi.setDeskripsi(deskripsi);
                                hargaBeli = Integer.parseInt(eElement.getElementsByTagName("hargabeli").item(0).getTextContent());
                                tempatnonwifi.setHargaBeli(hargaBeli);
                                hargaMortgage = Integer.parseInt(eElement.getElementsByTagName("hargamortgage").item(0).getTextContent());
                                tempatnonwifi.setHargaMortgage(hargaMortgage);
                                pemilik = eElement.getElementsByTagName("pemilik").item(0).getTextContent();
                                tempatnonwifi.setPemilik(pemilik);
                                hargaSewa = Integer.parseInt(eElement.getElementsByTagName("hargasewa").item(0).getTextContent());
                                tempatnonwifi.setHargaSewa(hargaSewa);
                                ListOfTiles.add(tempatnonwifi);
                                break;
                            
                            case "StartTempat" :
                                starttempat = StartTempat.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                starttempat.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                starttempat.setDesc(deskripsi);
                                ListOfTiles.add(starttempat);
                                break;
                            
                            case "Kesempatan" :
                                kesempatan = new Kesempatan();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                kesempatan.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                kesempatan.setDesc(deskripsi);
                                ListOfTiles.add(kesempatan);
                                break;
                            
                            case "Kosan" :
                                kosan = Kosan.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                kosan.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                kosan.setDesc(deskripsi);
                                ListOfTiles.add(kosan);
                                break;
                            
                            case "ParkirBebas" :
                                parkirbebas = ParkirBebas.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                parkirbebas.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                parkirbebas.setDesc(deskripsi);
                                ListOfTiles.add(parkirbebas);
                                break;
                            
                            case "MasukPenjara" :
                                masukpenjara = MasukPenjara.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                masukpenjara.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                masukpenjara.setDesc(deskripsi);
                                ListOfTiles.add(masukpenjara);
                                break;
                            
                            case "PajakLK" :
                                pajaklk = PajakLK.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                pajaklk.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                pajaklk.setDesc(deskripsi);
                                hargapajak = Integer.parseInt(eElement.getElementsByTagName("hargapajak").item(0).getTextContent());
                                pajaklk.setHargapajak(hargapajak);
                                hargabeli = Integer.parseInt(eElement.getElementsByTagName("hargabeli").item(0).getTextContent());
                                pajaklk.setHargabeli(hargabeli);
                                ListOfTiles.add(pajaklk);
                                break;
                            
                            case "PajakBPPS" :
                                pajakbpps = PajakBPPS.getSingleton();
                                ID = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                                pajakbpps.setID(ID);
                                deskripsi = eElement.getElementsByTagName("deskripsi").item(0).getTextContent();
                                pajakbpps.setDesc(deskripsi);
                                hargapajak = Integer.parseInt(eElement.getElementsByTagName("hargapajak").item(0).getTextContent());
                                pajakbpps.setHargapajak(hargapajak);
                                ListOfTiles.add(pajakbpps);
                                break;
                            
                            default:
                                break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SetPosition();
    }
    private void SetPosition(){
        //tile atas
        for(int i=0;i<10;i++){
            ListOfTiles.get(i).setKoordinat(1, 1+i*7);
        }
        //tile kanan
        for(int i=0;i<10;i++){
            ListOfTiles.get(i+10).setKoordinat(1+i*5,BOARD_WIDTH-7);
        }
        //tile bawah
        for(int i=1;i<=10;i++){
            ListOfTiles.get(i+19).setKoordinat(BOARD_HEIGHT-5,BOARD_WIDTH-i*7);
        }
        //tile kiri
        for(int i=1;i<=10;i++){
            ListOfTiles.get(i+29).setKoordinat(BOARD_HEIGHT-i*5,1);
        }
    }
    public void PutPlayerOnBoard(Tiles IDLokasi,int IDPlayer,char ASCIIchar){
        Tiles A = IDLokasi;
        System.out.print(ansi().bold());
        switch(IDPlayer){
            case 1 : 
                System.out.println(ansi().cursor(A.getX()+2,A.getY()+3).a(ASCIIchar));
                break;
            case 2 : 
                System.out.println(ansi().cursor(A.getX()+2,A.getY()+4).a(ASCIIchar));
                break;
            case 3 : 
                System.out.println(ansi().cursor(A.getX()+3,A.getY()+3).a(ASCIIchar));
                break;
            case 4 :
                System.out.println(ansi().cursor(A.getX()+3,A.getY()+4).a(ASCIIchar));
                break;
            default: break;
        }
        System.out.print(ansi().boldOff());
    }
    public void ErasePlayerOnBoard(Tiles IDLokasi,int IDPlayer){
        Tiles A = IDLokasi;
        System.out.print(ansi().bold());
        switch(IDPlayer){
            case 1 : 
                System.out.println(ansi().cursor(A.getX()+2,A.getY()+3).a(" "));
                break;
            case 2 : 
                System.out.println(ansi().cursor(A.getX()+2,A.getY()+4).a(" "));
                break;
            case 3 : 
                System.out.println(ansi().cursor(A.getX()+3,A.getY()+3).a(" "));
                break;
            case 4 :
                System.out.println(ansi().cursor(A.getX()+3,A.getY()+4).a(" "));
                break;
            default: break;
        }
        System.out.print(ansi().boldOff());
    }
    public void PrintBoard(){
        for(Tiles A : ListOfTiles){
            A.printTiles();
        }
        System.out.println(ansi().cursor(BOARD_HEIGHT, 0));
    }
    public Tiles getTile(int i){
        return ListOfTiles.get(i-1);
    }
    public int getTile(String nama){
        for(Tiles A : ListOfTiles){
            if(A instanceof Tempat){
                Tempat X = (Tempat)A;
                if (X.getNama().equals(nama)){
                    return X.getID();
                }
            }
            else if(A instanceof TempatNonWifi){
                TempatNonWifi X = (TempatNonWifi)A;
                if (X.getNama().equals(nama)){
                    return X.getID();
                }
            }
        }
        return 0;
    }
    public int NumberOfTiles(){
        return ListOfTiles.size();
    }
    /*public static void main(String[] args) {
        AnsiConsole.systemInstall();
        BoardView bv =new BoardView();
        AnsiConsole.out.println(ANSI_CLS);
        //bv.Initialization();
        bv.PrintBoard();
        String nama;
        int aidi;

        for (int i = 0; i < bv.getListOfTiles().size(); i++){
            if (bv.getListOfTiles().get(i) instanceof Tempat){
                Tempat a = (Tempat) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof TempatNonWifi){
                TempatNonWifi a = (TempatNonWifi) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof Kesempatan){
                Kesempatan a = (Kesempatan) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof Kosan){
                Kosan a = (Kosan) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof MasukPenjara){
                MasukPenjara a = (MasukPenjara) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof ParkirBebas){
                ParkirBebas a = (ParkirBebas) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof PajakLK){
                PajakLK a = (PajakLK) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof PajakBPPS){
                PajakBPPS a = (PajakBPPS) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
            else if (bv.getListOfTiles().get(i) instanceof StartTempat){
                StartTempat a = (StartTempat) bv.getListOfTiles().get(i);
                nama = a.getDesc();
                aidi = a.getID();
                System.out.print("ID: " + aidi + ". " + nama + "\n");
                System.out.print("==================\n");
            }
        }
        AnsiConsole.systemUninstall();  
    }*/
}