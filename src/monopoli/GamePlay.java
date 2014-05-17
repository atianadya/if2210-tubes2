/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoli;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static monopoli.BoardView.BOARD_HEIGHT;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;

/**
 *
 * @author Fahmi
 */
public class GamePlay {
    private LinkedList<Player> Q;
    private Player CurrentPlayer;
    private int NPlayer;
    private int dadu1;
    private int dadu2;
    private int kesempatankocok;
    private chanceCard Kartu;
    private static boolean GameOver;
    public BoardView Board;
    public GamePlay(){
        Board = new BoardView();
        Q = new LinkedList<>();
        System.out.println("Berapa orang yang akan bermain (max 4) ? ");
        Scanner read = new Scanner(System.in);
        NPlayer = read.nextInt();
        while((NPlayer<2) || (NPlayer>4)){
            System.out.println("Jumlah pemain harus di antara 2 sampai 4");
            System.out.println("Berapa orang yang akan bermain (max 4) ? ");
            NPlayer = read.nextInt();
        }
        int i = 1;
        while(i<=NPlayer){
            System.out.println("Player "+ i +" : ");
            String playername = read.next();
            boolean sama = false;
            int j = 0;
            //validasi nama
            while((j<Q.size()) && !sama){
                if(Q.get(j).getnama().equalsIgnoreCase(playername)){
                    sama=true;
                }
                j++;
            }
            if(sama){
                System.out.println("Maaf, nama sudah dipakai. Silakan coba yang lain.");
            }
            else{
                Q.add(new Player(i,playername,(char)(231+i),Board.getTile(1)));
                i++;
            }
        }
        CurrentPlayer = Q.peek();
        Kartu = new chanceCard(this);
        GameOver =false;
    }
    public void Status(){
        System.out.println("Current Player : "+ ansi().bold().a(CurrentPlayer.getSymbol()+" "+CurrentPlayer.getnama()+" (Player ke-"+CurrentPlayer.getID()+")").boldOff());
        System.out.println("Current Money  : "+ ansi().bold().a("ITBR "+CurrentPlayer.getuang()).boldOff());
    }
    public void KocokDadu(){
        if(CurrentPlayer.getuang()>=0){
            if(CurrentPlayer.getstatus()){
                Random kocok = new Random();
                dadu1 = kocok.nextInt(6) + 1;
                dadu2 = kocok.nextInt(6) + 1;
                System.out.println("nilai dadu1 = " + dadu1);
                System.out.println("nilai dadu2 = " + dadu2);
                int dadu = dadu1+dadu2;
                //jika diskorsing
                if(CurrentPlayer.Isdiskors()){
                    if(dadu1==dadu2){
                        CurrentPlayer.setdiskors(false);
                        System.out.println(CurrentPlayer.getnama() + " bebas skorsing");
                    }
                    else if(CurrentPlayer.havekartuskors()){
                        CurrentPlayer.setdiskors(false);
                        System.out.println(CurrentPlayer.getnama() + " menggunakan kartu bebas skors");
                    }
                    else{
                        System.out.println("Bisa bebas skors dengan membayar ITBR 500.Anda mau(Y/N) ?");
                        Scanner read = new Scanner(System.in);
                        String pilihan = read.next();
                        if(pilihan.equalsIgnoreCase("y")){
                            CurrentPlayer.kuranguang(500);
                            CurrentPlayer.setdiskors(false);
                            System.out.println(CurrentPlayer.getnama() + " bebas skorsing");
                        }
                        else{
                            CurrentPlayer.setstatus(false);
                            System.out.println(CurrentPlayer.getnama() + " masih diskors");
                        }
                    }
                }
                if(!CurrentPlayer.Isdiskors()){
                    System.out.println(CurrentPlayer.getnama() + " maju "+dadu+" langkah");
                    Move(CurrentPlayer,dadu);
                    if(dadu1!=dadu2){
                        CurrentPlayer.setstatus(false);
                    }
                    kesempatankocok--;
                    //DISKORSING
                    if((kesempatankocok==0)&&(dadu1==dadu2)){
                        CurrentPlayer.setposisi(Board.getTile(11));
                        CurrentPlayer.setdiskors(true);
                        CurrentPlayer.setstatus(false);
                        System.out.println(CurrentPlayer.getnama() + " diskors");
                    }
                }
            }
            else{System.out.println(CurrentPlayer.getnama() + " tidak bisa mengocok dadu kembali");}
        }
        else{
            System.out.println(CurrentPlayer.getnama() + "mengalami masa pailit");
            System.out.println("Segera jual WIFI atau gadaikan ASET Anda");
            System.out.println("Jika tidak bisa, nyatakan bangkrut");
        }
    }
    public void Buy(){
        if(CurrentPlayer.getposisi() instanceof Tempat){
            if(((Tempat)CurrentPlayer.getposisi()).getPemilik().equals("Unknown")){
                if(CurrentPlayer.getuang()>=((Tempat)CurrentPlayer.getposisi()).getHargaBeli()){
                    CurrentPlayer.kuranguang(((Tempat)CurrentPlayer.getposisi()).getHargaBeli());
                    ((Tempat)CurrentPlayer.getposisi()).setPemilik(CurrentPlayer.getnama());
                    CurrentPlayer.tambahaset(CurrentPlayer.getposisi());
                    System.out.println(CurrentPlayer.getnama() + " membeli " + ((Tempat)CurrentPlayer.getposisi()).getNama());
                }
                else{System.out.println("Uang " + CurrentPlayer.getnama() + " tidak cukup");} 
            }
            else{System.out.println("Tempat sudah dibeli");}
        }
        else if(CurrentPlayer.getposisi() instanceof TempatNonWifi){
            if(((TempatNonWifi)CurrentPlayer.getposisi()).getPemilik().equals("Unknown")){
                if(CurrentPlayer.getuang()>=((TempatNonWifi)CurrentPlayer.getposisi()).getHargaBeli()){    
                    CurrentPlayer.kuranguang(((TempatNonWifi)CurrentPlayer.getposisi()).getHargaBeli());
                    ((TempatNonWifi)CurrentPlayer.getposisi()).setPemilik(CurrentPlayer.getnama());
                    CurrentPlayer.tambahaset(CurrentPlayer.getposisi());
                    System.out.println(CurrentPlayer.getnama() + " membeli " + ((TempatNonWifi)CurrentPlayer.getposisi()).getNama());
                }
                else{System.out.println("Uang " + CurrentPlayer.getnama() + " tidak cukup");} 
            }
            else{System.out.println("Tempat sudah dibeli");}
        }
        else{System.out.println("Tempat tidak bisa dibeli");}
    }
    public void Mortgage( int i){
        if(Board.getTile(i) instanceof Tempat){
            Tempat A = (Tempat)Board.getTile(i);
            if (A.getPemilik().equals(CurrentPlayer.getnama())){
                if(A.isMortgaged()){
                    System.out.println(A.getNama() + " sudah digadaikan");
                }
                else if(A.getJumlahWifi()!=0){
                    System.out.println("Tidak bisa digadaikan. Masih ada WIFI terpasang");
                }
                else{
                    CurrentPlayer.tambahuang(A.getHargaMortgage());
                    A.setMortgage(true);
                    System.out.println(CurrentPlayer.getnama() + " menggadaikan "+ A.getNama());
                }
            }
            else{System.out.println("Properti bukan milik " + CurrentPlayer.getnama());}
        }
        else if(Board.getTile(i) instanceof TempatNonWifi){
            TempatNonWifi B = (TempatNonWifi)Board.getTile(i);
            if (B.getPemilik().equals(CurrentPlayer.getnama())){
                if(B.isMortgaged()){
                    System.out.println(B.getNama() + " sudah digadaikan");
                }
                else{
                    CurrentPlayer.tambahuang(B.getHargaMortgage());
                    B.setMortgage(true);
                    System.out.println(CurrentPlayer.getnama() + " menggadaikan "+ B.getNama());
                }
            }
            else{System.out.println("Properti bukan milik " + CurrentPlayer.getnama());}
        }
        else{System.out.println("Tempat bukan properti");}
    }
    public void UnMortgage( int i){
        if(Board.getTile(i) instanceof Tempat){
            Tempat A = (Tempat)Board.getTile(i);
            if (A.getPemilik().equals(CurrentPlayer.getnama())){
                if(A.isMortgaged()){
                    if(CurrentPlayer.getuang()>=A.getHargaMortgage()){
                        CurrentPlayer.kuranguang(A.getHargaMortgage());
                        A.setMortgage(false);
                    }
                    else{System.out.println("Uang tidak mencukupi");}
                }
                else{System.out.println(A.getNama() + " tidak digadaikan");}
            }
            else{System.out.println("Properti bukan milik " + CurrentPlayer.getnama());}
        }
        else if(Board.getTile(i) instanceof TempatNonWifi){
            TempatNonWifi B = (TempatNonWifi)Board.getTile(i);
            if (B.getPemilik().equals(CurrentPlayer.getnama())){
                if(B.isMortgaged()){
                    if(CurrentPlayer.getuang()>=B.getHargaMortgage()){
                        CurrentPlayer.kuranguang(B.getHargaMortgage());
                        B.setMortgage(false);
                    }
                    else{System.out.println("Uang tidak mencukupi");}
                }
                else{System.out.println(B.getNama() + " tidak digadaikan");}
            }
            else{System.out.println("Properti bukan milik " + CurrentPlayer.getnama());}
        }
        else{System.out.println("Tempat bukan properti");}
    }
    public void BuyWifi( int i){
        if(Board.getTile(i) instanceof Tempat){
            Tempat A = (Tempat)Board.getTile(i);
            if(A.getPemilik().equals(CurrentPlayer.getnama())){
                if(A.isMortgaged()){
                    System.out.println(A.getNama() + " sedang digadaikan. Tidak bisa memasang wifi");
                }
                else{
                    if((CurrentPlayer.getuang()>=A.getHargaWifi())&&(A.getJumlahWifi()<4)){
                        CurrentPlayer.kuranguang(A.getHargaWifi());
                        A.tambahkanWifi();
                        System.out.println(CurrentPlayer.getnama() + " memasang 1 wifi di "+A.getNama());
                    }
                    else if(A.getJumlahWifi()==4){
                        System.out.println("Signal Wifi sudah bagus, tidak perlu ditambah");
                    }
                    else{
                        System.out.println("Uang " + CurrentPlayer.getnama() + " tidak cukup");
                    }
                }
            }
            else{System.out.println("Tempat bukan milik "+ CurrentPlayer.getnama());}
        }
        else{System.out.println("Bukan tempat yang ada WIFI");}
    }
    public void SellWifi( int i){
        if(Board.getTile(i) instanceof Tempat){
            Tempat A = (Tempat)Board.getTile(i);
            if(A.getPemilik().equals(CurrentPlayer.getnama())){
                if(A.getJumlahWifi()>0){
                    CurrentPlayer.tambahuang(A.getHargaWifi());
                    A.kurangiWifi();
                    System.out.println(CurrentPlayer.getnama() + " menjual 1 WIFI di "+A.getNama());
                }
                else{
                    //assert(A.getJumlahWifi==0);
                    System.out.println("Tidak ada WIFI terpasang");
                }
            }
            else{System.out.println("Tempat bukan milik "+ CurrentPlayer.getnama());}
        }
        else{System.out.println("Bukan tempat yang ada WIFI");}
    }
    public void DeclareBanckrupt(){
        CurrentPlayer.HapusAllAset();
        System.out.println(CurrentPlayer.getnama() + " menyatakan bangkrut");
        Q.poll();
        CurrentPlayer = Q.peek();
    }
    public void EndTurn(){
        if(CurrentPlayer.getuang()>=0){
            if(CurrentPlayer.getstatus()){
                System.out.println("Masih bisa mengocok dadu");
            }    
            else{
                System.out.println(CurrentPlayer.getnama() + " mengakhiri turn nya");
                CurrentPlayer.setstatus(true);
                Q.poll();
                Q.addLast(CurrentPlayer);
                CurrentPlayer = Q.peek();
                kesempatankocok = 3;
                System.out.println("Tekan ENTER");
                Scanner read = new Scanner(System.in);
                while(!read.nextLine().equals(""));
                System.out.println(ansi().cursor(BOARD_HEIGHT, 0).eraseScreen(Ansi.Erase.FORWARD));
            }
        }
        else{
            System.out.println(CurrentPlayer.getnama() + "mengalami masa pailit");
            System.out.println("Segera jual WIFI atau gadaikan ASET Anda");
            System.out.println("Jika tidak bisa, nyatakan bangkrut");
        }
    }
    public void Start(){
        String aksi;
        int lokasi,ID;
        kesempatankocok = 3;
        System.out.print(ansi().eraseScreen());
        Kartu.intoStack();
        PutBoard();
        Scanner read = new Scanner(System.in);
        do{
            System.out.print(ansi().cursor(BOARD_HEIGHT+3, 0));
            System.out.print(ansi().eraseScreen(Ansi.Erase.BACKWARD));
            PutBoard();
            System.out.println(ansi().cursor(BOARD_HEIGHT, 0));
            Status();
            System.out.print(ansi().eraseLine());
            aksi = read.next();
            System.out.print(ansi().eraseScreen(Ansi.Erase.FORWARD));
            System.out.println();
            switch (aksi) {
                case "kocok":
                    KocokDadu();
                    break;
                case "buy":
                    Buy();
                    break;
                case "mortgage":
                    lokasi = read.nextInt();
                    Mortgage(lokasi);
                    break;
                case "unmortgage":
                    lokasi = read.nextInt();
                    UnMortgage(lokasi);
                    break;
                case "buywifi":
                    lokasi = read.nextInt();
                    BuyWifi(lokasi);
                    break;
                case "sellwifi":
                    lokasi = read.nextInt();
                    SellWifi(lokasi);
                    break;
                case "viewaset":
                    ID = read.nextInt();
                    //harusnya assert
                    if((ID>0)&&(ID<=Q.size())){
                        ViewAset(ID);
                    }
                    else{System.out.println("Salah masukan nomor");}
                    break;
                case "infoplayer":
                    ID = read.nextInt();
                    //harusnya assert
                    if((ID>0)&&(ID<=Q.size())){
                        InfoPlayer(ID);
                    }
                    else{System.out.println("Salah masukan nomor");}
                    break;
                case "infotile":
                    lokasi = read.nextInt();
                    //harusnya assert
                    if((lokasi>0)&&(lokasi<=Board.NumberOfTiles())){
                        PrintInfoTile(lokasi);
                    }
                    else{System.out.println("Salah masukan nomor");}
                    break;
                case "bangkrut":
                    DeclareBanckrupt();
                    break;
                case "endturn":
                    EndTurn();
                    break;
                case "exit":
                    break;
                case "help":
                    Help();
                    break;
                default:
                    System.out.println("\nSalah aksi");
                    break;
            }
        }while((Q.size() != 1) && (!GameOver) &&(!aksi.equals("exit")));
        if(GameOver){
            System.out.println("Pemenangnya adalah " + CurrentPlayer.getnama());
            while(!read.nextLine().equals(""));
        }    
    }
    public void PutBoard(){
        Board.PrintBoard();
        for (Player A : Q) {
            Board.PutPlayerOnBoard(A.getposisi(), A.getID(), A.getSymbol());
        }
    }
    public void ViewAset(int ID) {
        for(Player A : Q){
            if(A.getID()==ID){
                A.viewaset();
            }
        }
    }
    public void InfoPlayer(int ID){
        for(Player A : Q){
            if(A.getID()==ID){
                A.print();
            }
        }
    }
    public void PrintInfoTile(int lokasi) {
        Board.getTile(lokasi).printInfo();
    }
    public void Help(){
        System.out.println(ansi().bold().a("\nkocok").boldOff()+ " -> Mengkocok dadu");
        System.out.println(ansi().bold().a("buy").boldOff()+" -> Membeli properti di tile player berada");
        System.out.println("X adalah angka");
        System.out.println(ansi().bold().a("mortgage X").boldOff()+" -> Menggadaikan aset player pada tile X");
        System.out.println(ansi().bold().a("unmortgage X").boldOff()+" -> Meng-unmortgage aset player pada tile X");
        System.out.println(ansi().bold().a("buywifi X").boldOff()+" -> Memasang 1 wifi di tile X");
        System.out.println(ansi().bold().a("sellwifi X").boldOff()+" -> Memasang 1 wifi di tile X");
        System.out.println(ansi().bold().a("viewaset X").boldOff()+" -> Melihat aset player ke-X");
        System.out.println(ansi().bold().a("infoplayer X").boldOff()+" -> Melihat info player ke-X");
        System.out.println(ansi().bold().a("infotile X").boldOff()+" -> Melihat info tile X");
        System.out.println(ansi().bold().a("bangkrut").boldOff()+" -> Menyatakan bangkrut");
        System.out.println(ansi().bold().a("endturn").boldOff()+" -> Mengakhiri giliran player");
        System.out.println(ansi().bold().a("exit").boldOff()+" -> Keluar dari permainan");
        System.out.println(ansi().bold().a("help").boldOff()+" -> Memunculkan tulisan ini" );
    }
    private void BayarSewa(Player A, Player B){
        if(A.getposisi() instanceof Tempat){
            Tempat X = (Tempat) A.getposisi();
            if(X.isMortgaged()){
                System.out.println(X.getNama() + " sedang digadaikan. Sewa GRATIS");
            }
            else{
                int UangSewa;
                UangSewa = (X.getHargaSewa()*(1+X.getJumlahWifi()));
                A.kuranguang(UangSewa);
                B.tambahuang(UangSewa);
                System.out.println(A.getnama()+" membayar uang sewa ke "+B.getnama()+" sebesar "+UangSewa);
            }
        }else{
            //assert(A.getposisi() instanceof TempatNonWifi();
            TempatNonWifi X = (TempatNonWifi) A.getposisi();
            if(X.isMortgaged()){
                System.out.println(X.getNama() + " sedang digadaikan. Sewa GRATIS");
            }
            else{
                int UangSewa;
                UangSewa = (int) (X.getHargaSewa()*(Math.pow(2,A.jumlahAsetTempatNonWifiNonMortgage()-1)));
                A.kuranguang(UangSewa);
                B.tambahuang(UangSewa);
                System.out.println(A.getnama()+" membayar uang sewa ke "+B.getnama()+" sebesar "+UangSewa);
            }
        }
    }
    public void Move(Player CurrentPlayer, int move) {
        int NewPosisi;
        boolean lewatstart = false;
        int absmove = Math.abs(move);
        for(int i=1;i<=absmove;i++){
            if(move>0){
                NewPosisi = CurrentPlayer.getposisi().getID()+1;
            }
            else{
                NewPosisi = CurrentPlayer.getposisi().getID()-1;
            }
            if(NewPosisi > Board.NumberOfTiles()){
                NewPosisi -=Board.NumberOfTiles();
                lewatstart = true;
            }else if(NewPosisi <=0){
                NewPosisi +=Board.NumberOfTiles();
            }
            //penjara hanya lewat
            if((NewPosisi == 11) && (CurrentPlayer.getposisi().getID()<11)){
                NewPosisi++;
            }
            if((NewPosisi == 11) && (CurrentPlayer.getposisi().getID()>11)){
                NewPosisi--;
            }
            Board.ErasePlayerOnBoard(CurrentPlayer.getposisi(), CurrentPlayer.getID());
            CurrentPlayer.setposisi(Board.getTile(NewPosisi));
            Board.PutPlayerOnBoard(CurrentPlayer.getposisi(), CurrentPlayer.getID(),CurrentPlayer.getSymbol());
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(ansi().cursor(BOARD_HEIGHT, 0).eraseScreen(Ansi.Erase.FORWARD));
        Status();
        System.out.println("\n");
        //kembali ke start
        if(lewatstart){
            CurrentPlayer.tambahuang(2000);
            System.out.println(CurrentPlayer.getnama() + " mendapat uang bulanan sebesar 2000");
        }    
        if(CurrentPlayer.getposisi() instanceof PajakBPPS){
            int HargaPajak =((PajakBPPS)CurrentPlayer.getposisi()).getHargapajak();
            CurrentPlayer.kuranguang(HargaPajak);
            ParkirBebas A = ((ParkirBebas)Board.getTile(21));
            A.tambahPajak(HargaPajak);
            System.out.println(CurrentPlayer.getnama() + " membayar BPPS sebesar "+HargaPajak);
        }
        else if(CurrentPlayer.getposisi() instanceof PajakLK){
            if(CurrentPlayer.getuang()>=((PajakLK)CurrentPlayer.getposisi()).getHargabeli()){
                System.out.println("Uang anda cukup untuk membeli LK. Tekan ENTER untuk membeli");
                Scanner read = new Scanner(System.in);
                while(!read.nextLine().equals(""));
                GameOver = true;
            }
            else{
                int HargaPajak =((PajakLK)CurrentPlayer.getposisi()).getHargapajak();
                CurrentPlayer.kuranguang(HargaPajak);
                ParkirBebas A = ((ParkirBebas)Board.getTile(21));
                A.tambahPajak(HargaPajak);
                System.out.println(CurrentPlayer.getnama() + " membayar pajak LK sebesar "+HargaPajak);
            }
        }
        else if(CurrentPlayer.getposisi() instanceof Kesempatan){
            AmbilKesempatan();
        }
        else if(CurrentPlayer.getposisi() instanceof ParkirBebas){
            int Pajak = ((ParkirBebas)CurrentPlayer.getposisi()).ambilPajak();
            CurrentPlayer.tambahuang(Pajak);
            System.out.println(CurrentPlayer.getnama() + " mendapat uang sebesar "+Pajak);
        }
        else if(CurrentPlayer.getposisi() instanceof MasukPenjara){
            CurrentPlayer.setposisi(Board.getTile(11));
            CurrentPlayer.setdiskors(true);
            CurrentPlayer.setstatus(false);
            System.out.println(CurrentPlayer.getnama() + " diskors");
        }
        else if(CurrentPlayer.getposisi() instanceof Tempat){
            if(((Tempat)CurrentPlayer.getposisi()).getPemilik().equals(CurrentPlayer.getnama())){
                System.out.println(CurrentPlayer.getnama()+ " menempati properti sendiri");
            }
            else if(((Tempat)CurrentPlayer.getposisi()).getPemilik().equals("Unknown")){
                System.out.println("Properti bukan milik siapapun. Bisa dibeli");
                System.out.println("Harga : " +((Tempat)CurrentPlayer.getposisi()).getHargaBeli());
            }
            else{
                Player X = null;
                for(Player A : Q){
                    if(A.getnama().equals(((Tempat)CurrentPlayer.getposisi()).getPemilik())){
                        X = A;
                    }
                }
                BayarSewa(CurrentPlayer,X);
            }
        }
        else if(CurrentPlayer.getposisi() instanceof TempatNonWifi){
            if(((TempatNonWifi)CurrentPlayer.getposisi()).getPemilik().equals(CurrentPlayer.getnama())){
                System.out.println(CurrentPlayer.getnama()+ " menempati propertinya");
            }
            else if(((TempatNonWifi)CurrentPlayer.getposisi()).getPemilik().equals("Unknown")){
                System.out.println("Properti bukan milik siapapun. Bisa dibeli");
                System.out.println("Harga : " +((TempatNonWifi)CurrentPlayer.getposisi()).getHargaBeli());
            }
            else{
                Player X = null;
                for(Player A : Q){
                    if(A.getnama().equals(((TempatNonWifi)CurrentPlayer.getposisi()).getPemilik())){
                        X = A;
                    }
                }
                BayarSewa(CurrentPlayer,X);
            }
        }
        else{
            assert((CurrentPlayer.getposisi() instanceof StartTempat/*instanceof Kosan*/));
        }
    }

    private void AmbilKesempatan() {
        System.out.println("Anda mengambil kartu kesempatan");
        Kartu.popTop();
        System.out.println("Tekan ENTER");
        Scanner read = new Scanner(System.in);
        while(!read.nextLine().equals(""));
        System.out.print(ansi().cursor(BOARD_HEIGHT+3, 0).eraseScreen(Ansi.Erase.FORWARD));
        Kartu.Effect(CurrentPlayer);
        if(Kartu.isStackEmpty()){
            Kartu.intoStack();
        }
    }
}
    
