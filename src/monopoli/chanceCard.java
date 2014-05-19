package monopoli;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class chanceCard {
	private int ID;
	private int IDpop;
	private String deskripsi;
        private readxmlfile rd;
        private GamePlay GP;
	private Deque<Integer> stack = new ArrayDeque<Integer>();
	private LinkedList<Tiles> ListOfTiles;

	//to do:

	//constructor
	public chanceCard(GamePlay GP){
		ID = 0;
		deskripsi = "";
                rd = new readxmlfile();
                rd.readXML();
                this.GP = GP;
	}
	
	public void printCard(int ID1) {
		ID = rd.getID(ID1);
		deskripsi = rd.getEff(ID1);
		System.out.println("Effect: \"" + deskripsi+ "\"");
	}

	// STACK HANDLER-------------------------------------------------

	public void printStack() {
		System.out.println(stack);
		System.out.println("Top of stack: " + stack.peek());
	}
	
	//check if stack is empty
	public boolean isStackEmpty() {
            return stack.isEmpty();
	}

	//taking top card from stack
	public void popTop() {
		setIDpop(stack.pop());
		printCard(IDpop);
	}

	//inserting cards to a stack
	public void intoStack() {
		for ( int i=1; i <= rd.getSize(); i++ ) {
			boolean no = false;
			while (!no) {
				//random();
                                ID = 1 + (int)(Math.random() * ((rd.getSize() - 1) + 1));
				if (!stack.contains(ID)) {
					stack.push(ID);

					no = true;
					
				} else {
					//continue
				}
			}
		}
	}

	// --------------------------------------------------------------

	// getter
	public int getID() {
		return ID;
	}

	public String getDesc(){
		return deskripsi;
	}

	public void setID(int a){
		ID = a;
	}

	public void setDesc(String a){
		deskripsi = a;
	}

	public void setLinkedList(LinkedList<Tiles> a){
		ListOfTiles = a;
	}

	// setter

	//random function

	/*public void random() {
		ID = 1 + (int)(Math.random() * ((16 - 1) + 1));
	}*/

	public int getIDpop(){
		return IDpop;
	}

	public void setIDpop(int a){
		IDpop = a;
	}

	public void Effect(Player player){
		if (IDpop == 1) {
                    // Melanggar peraturan K3L, denda ITBR 1.500
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.kuranguang(1500);
                    assert jum_uanglama - player.getuang() == 1500 : "Uang pemain tidak berkurang sejumlah ITBR 1.500";
		}
		else if (IDpop == 2){
                    //Menceburkan teman ke kolam INTEL, denda ITBR 1.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.kuranguang(2000);
                    assert jum_uanglama - player.getuang() == 2000 : "Uang pemain tidak berkurang sejumlah ITBR 2.000";
		}
		else if (IDpop == 3){
                    //Mendapat nilai 100 di kuis OOP, mendapatkan uang sebesar ITBR 2.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.tambahuang(2000);
                    assert player.getuang() - jum_uanglama == 2000 : "Uang pemain tidak bertambah sejumlah ITBR 2.000";
		}
		else if (IDpop == 4){
                    // Mundur tiga petak
                    /* post condition */
                    //int pos_lama = player.getposisi().getID();
                    GP.Move(player, -3);
                    //assert pos_lama - player.getposisi().getID() == 3 : "Posisi pemain tidak mundur tiga petak";
		}
		else if (IDpop == 5){
                    // Maju sampai Gedung SR
                    int A = GP.Board.getTile("Gedung SR");
                    int move = A-player.getposisi().getID();
                    if(move<0){
                        move+=GP.Board.NumberOfTiles();
                    }
                    if((player.getposisi().getID()<11) || (player.getposisi().getID() > A)){
                        move--;
                    }
                    
                    GP.Move(player, move);
                    assert player.getposisi() instanceof Tempat : "Posisi pemain bukan Tempat";
                    if (player.getposisi() instanceof Tempat){
                        Tempat new_tempat = (Tempat) player.getposisi();
                        assert new_tempat.getNama().equals("Gedung SR") : "Posisi pemain tidak berada di gedung SR";
                    }
		}
		else if (IDpop == 6){
                    // Maju sampai Parkir Sepeda Selatan, Bila melalui START mendapatkan uang sebesar 20.000ITBR 
                    int A = GP.Board.getTile("Parkir Sepeda Selatan");
                    int move = A-player.getposisi().getID();
                    if(move<0){
                        move+=GP.Board.NumberOfTiles();
                        player.tambahuang(1500);
                        if(player.getposisi().getID()<11){
                            move--;
                        }
                    }
                    GP.Move(player, move);
                    assert player.getposisi() instanceof TempatNonWifi : "Posisi pemain bukan TempatNonWifi";
                    if (player.getposisi() instanceof TempatNonWifi){
                        TempatNonWifi new_tempat = (TempatNonWifi) player.getposisi();
                        assert new_tempat.getNama().equals("Parkir Sepeda Selatan") : "Posisi pemain tidak berada di Parkir Sepeda Selatan";
                    }
		}
		else if (IDpop == 7){
                    // Mundur ke Labtek V
                    int A = GP.Board.getTile("Labtek V");
                    int move = A-player.getposisi().getID();
                    if(move>0){
                        move-=GP.Board.NumberOfTiles();
                    }
                    GP.Move(player, move);
                    assert player.getposisi() instanceof Tempat : "Posisi pemain bukan Tempat";
                    if (player.getposisi() instanceof Tempat){
                        Tempat new_tempat = (Tempat) player.getposisi();
                        assert new_tempat.getNama().equals("Labtek V") : "Posisi pemain tidak berada di Labtek V";
                    }
		}
		else if (IDpop == 8){
                    //Karena kesalahan LK, Anda berhak menerima ITBR 3.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.tambahuang(3000);
                    assert player.getuang() - jum_uanglama == 3000 : "Uang pemain tidak bertambah sejumlah ITBR 3.000";
		}
		else if (IDpop == 9){
                    // Mendapat voucher makan sebesar ITBR 1.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.tambahuang(1000);
                    assert player.getuang() - jum_uanglama == 1000 : "Uang pemain tidak bertambah sejumlah ITBR 1.000";
		}
		else if (IDpop == 10){
                    // Membayar kerusakan alat laboratorium sebesar ITBR 3.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.kuranguang(3000);
                    assert jum_uanglama - player.getuang() == 3000 : "Uang pemain tidak berkurang sejumlah ITBR 3.000";
		}
		else if (IDpop == 11){
                    // Mendapat tunjangan sebesar ITBR 1.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.tambahuang(1000);
                    assert player.getuang() - jum_uanglama == 1000 : "Uang pemain tidak bertambah sejumlah ITBR 1.000";
		}
		else if (IDpop == 12){
                    // Menyerempet mobil dosen, bayar ITBR 2.000
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.kuranguang(2000);
                    assert jum_uanglama - player.getuang() == 2000 : "Uang pemain tidak berkurang sejumlah ITBR 2.000";
		}
		else if (IDpop == 13){
                    // Membayar pajak BPPS sebesar ITBR 500
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.kuranguang(500);
                    assert jum_uanglama - player.getuang() == 500 : "Uang pemain tidak berkurang sejumlah ITBR 500";
		}
		else if (IDpop == 14){
                    // Anda ulang tahun dan berhak mendapatkan uang sebesar ITBR 2.000 dari himpunan.
                    /* post condition */
                    int jum_uanglama = player.getuang();
                    player.tambahuang(2000);
                    assert player.getuang() - jum_uanglama == 2000 : "Uang pemain tidak bertambah sejumlah ITBR 2.000";
		}
		else if (IDpop == 15){
                    // Bebas dari skorsing
                    player.setkartuskors(true);	
                    assert player.havekartuskors() : "Pemain masih tidak memiliki kartu bebas skorsing";
		}
		else if (IDpop == 16){
                    //Maju lima petak
                    /* post condition */
                    //int pos_lama = player.getposisi().getID();
                    GP.Move(player, 5);
                    //assert player.getposisi().getID() - pos_lama == 5 : "Posisi pemain tidak maju lima petak";  
		}
	}
	/*public static void main(String[] args){
		chanceCard kesempatan = new chanceCard();
		kesempatan.random();
		//Tiles mulai = new StartTempat();
		Player pemain = new Player();
		for (int i = 1; i <= 15; i++){
			kesempatan.printCard(i);
		}
		kesempatan.intoStack();
		kesempatan.popTop();
		kesempatan.Effect(pemain);
		System.out.println(kesempatan.getIDpop());
		System.out.println(pemain.getuang());
	}*/
}
