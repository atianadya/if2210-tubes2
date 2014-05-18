package monopoliswing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.fusesource.jansi.Ansi.ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author Fahmi
 */
public class Monopoli {

    public static void Logo() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("Logo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Monopoli.class.getName()).log(Level.SEVERE, null, ex);
        }
            String line;
        try {
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Monopoli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int MainMenu(){
        int pilihan;
        Scanner read = new Scanner(System.in);
        do{
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1. Play Monopoli ");
        System.out.println("2. Help");
        System.out.println("3. Exit");
        System.out.println("Pilih menu : ");
        pilihan = read.nextInt();
        }while((pilihan<1) || (pilihan>3));
        return pilihan;
    }
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        AnsiConsole.out().println(ansi().eraseScreen().cursor(1, 1));
        int pilihan = 1;
        //Logo();
        //pilihan = MainMenu();
        while(pilihan !=3){
            if(pilihan == 1){
                GamePlay GP = new GamePlay();
                GP.Start();
                pilihan = MainMenu();
            }
            else if(pilihan == 2){
                System.out.println("ini adalah help");
                pilihan = MainMenu();
            }
        }
        System.out.println("Sampai jumpa :)");
    }
}
