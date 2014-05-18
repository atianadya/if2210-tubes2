package monopoliswing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


class chanceCard {
	private int ID;
	private int IDpop;
	private String deskripsi;
        private GamePlay GP;
	private Deque<Integer> stack = new ArrayDeque<Integer>();
	private List<Integer> array = new ArrayList<Integer>();
	private LinkedList<Tiles> ListOfTiles;

	//to do:

	//constructor
	public chanceCard(GamePlay GP){
		ID = 0;
		deskripsi = "";
                this.GP = GP;
	}
	
	public void printCard(int ID1) {
		readxmlfile rd = new readxmlfile();
		rd.readXML();

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
		readxmlfile rd = new readxmlfile();
		rd.readXML();

		for ( int i=1; i <= rd.getSize(); i++ ) {
			boolean no = false;
			while (!no) {
				random();
				if (!array.contains(ID)) {
					stack.push(ID);

					//array storing used ID
					array.add(ID);
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

	public void random() {
		ID = 1 + (int)(Math.random() * ((16 - 1) + 1));
	}

	public int getIDpop(){
		return IDpop;
	}

	public void setIDpop(int a){
		IDpop = a;
	}

	public void Effect(Player player){
		if (IDpop == 1) {
					// Melanggar peraturan K3L, denda 1.500ITBR
                    player.kuranguang(1500);
		}
		else if (IDpop == 2){
					//Menceburkan teman ke kolam INTEL, denda 5.000ITBR
                    player.kuranguang(5000);
		}
		else if (IDpop == 3){
					//Mendapat nilai 100 di kuis OOP, mendapatkan uang sebesar 10.000ITBR
                    player.tambahuang(10000);
		}
		else if (IDpop == 4){
                    // Mundur tiga petak
                    GP.Move(player, -3);
		}
		else if (IDpop == 5){
                    // Maju sampai Gedung SR
                    int A = GP.Board.getTile("Gedung SR");
                    int move = A-player.getposisi().getID();
                    GP.Move(player, move);
		}
		else if (IDpop == 6){
                    // Maju sampai Parkir Sepeda Selatan, Bila melalui START mendapatkan uang sebesar 20.000ITBR 
                    int A = GP.Board.getTile("Parkir Sepeda Selatan");
                    int move = A-player.getposisi().getID();
                    GP.Move(player, move);
		}
		else if (IDpop == 7){
                    // Pindah ke Labtek V
                    int A = GP.Board.getTile("Labtek V");
                    int move = player.getposisi().getID()-A;
                    GP.Move(player, move);
		}
		else if (IDpop == 8){
					//Karena kesalahan LK, Anda berhak menerima 10.000ITBR
                    player.tambahuang(10000);
		}
		else if (IDpop == 9){
					// Mendapat voucher makan sebesar 5.000ITBR
                    player.tambahuang(5000);
		}
		else if (IDpop == 10){
					// Membayar kerusakan alat laboratorium sebesar 8.000ITBR
					player.kuranguang(8000);
		}
		else if (IDpop == 11){
					// Mendapat tunjangan sebesar 15.000ITBR
					player.tambahuang(15000);
		}
		else if (IDpop == 12){
					// Menyerempet mobil dosen, bayar 5.000ITBR
					player.kuranguang(5000);
		}
		else if (IDpop == 13){
					// Membayar pajak BPPS sebesar 5000ITBR
					player.kuranguang(5000);
		}
		else if (IDpop == 14){
					// Anda ulang tahun dan berhak mendapatkan uang sebesar 5.000ITBR dari himpunan.
					player.tambahuang(5000);
		}
		else if (IDpop == 15){
					// Bebas dari skorsing
					if (player.Isdiskors()){
							player.setdiskors(false);
					}
					else {
							player.setkartuskors(true);
					}			
		}
		else if (IDpop == 16){
					//Maju lima petak
					GP.Move(player, 5);		
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
