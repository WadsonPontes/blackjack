/*
* Author: Wadson Pontes
* Date: 2019/05/17
* Version: 1.0
*/
package core;

import java.util.Scanner;
import tools.GameState;
import tools.Lang;
import tools.PlayerState;
import tools.Word;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Deck deck;
    public static Player player;
    public static Computer computer;
    public static GameState state;
    
    public static void main(String[] args) {
        languageMenu();
        nameMenu();
        state = GameState.MAIN_MENU;
        
        while (state != GameState.EXIT) {
            switch (state) {
                case LANGUAGE_MENU:
                    languageMenu();
                    break;
                case NAME_MENU:
                    nameMenu();
                    break;
                case MAIN_MENU:
                    mainMenu();
                    break;
                case OPTIONS_MENU:
                    optionsMenu();
                    break;
                case DIFFICULTY_MENU:
                    difficultyMenu();
                    break;
                case START:
                    start();
                    break;
                case PLAYING:
                    playing();
                    break;
                case GAME_OVER:
                    gameOver();
            }
        }
    }
    
    public static void difficultyMenu() {
        printHeader(Lang.tr(Word.DIFFICULTY_MENU));
        
        System.out.println("(1) " + Lang.tr(Word.EASY));
        System.out.println("(2) " + Lang.tr(Word.MEDIUM));
        System.out.println("(3) " + Lang.tr(Word.HARD));
        System.out.print(">");
        
        computer = new Computer(Lang.tr(Word.COMPUTER), scan.nextInt(), player);
        state = GameState.START;
    }
    
    public static void gameOver() {
        printHeader(Lang.tr(Word.GAME_OVER));
        
        if (player.getState() == PlayerState.DEFEAT || (computer.getState() != PlayerState.DEFEAT && player.getScore() < computer.getScore())) {
            System.out.println(">>>" + Lang.tr(Word.DEFEAT) + "!");
        }
        else if (player.getScore() == computer.getScore()) {
            System.out.println(">>>" + Lang.tr(Word.DRAW) + "!");
        }
        else {
            System.out.println(">>>" + Lang.tr(Word.VICTORY) + "!");
        }
        scan.nextLine();
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        state = GameState.MAIN_MENU;
    }
    
    public static void languageMenu() {
        printHeader(Lang.tr(Word.LANGUAGE_MENU));
        
        System.out.println("(1) English");
        System.out.println("(2) Português");
        // System.out.println("(3) Español");
        // System.out.println("(4) Français");
        // System.out.println("(5) Italiano");
        // System.out.println("(6) Deutsch");
        System.out.print(">");
        
        Lang.set(scan.nextInt());
        state = GameState.OPTIONS_MENU;
    }
    
    public static void mainMenu() {
        printHeader(Lang.tr(Word.MAIN_MENU));
        
        System.out.println("(1) " + Lang.tr(Word.START));
        System.out.println("(2) " + Lang.tr(Word.OPTIONS));
        System.out.println("(3) " + Lang.tr(Word.EXIT));
        System.out.print(">");
        
        switch (scan.nextInt()) {
            case 1:
                state = GameState.DIFFICULTY_MENU;
                break;
            case 2:
                state = GameState.OPTIONS_MENU;
                break;
            case 3:
                state = GameState.EXIT;
        }
    }
    
    public static void nameMenu() {
        printHeader(Lang.tr(Word.NAME_MENU));
        
        System.out.print(">");
        
        scan.nextLine();
        player = new Player(scan.nextLine());
        state = GameState.OPTIONS_MENU;
    }
    
    public static void optionsMenu() {
        printHeader(Lang.tr(Word.OPTIONS_MENU));
        
        System.out.println("(1) " + Lang.tr(Word.LANGUAGE));
        System.out.println("(2) " + Lang.tr(Word.NAME));
        System.out.println("(3) " + Lang.tr(Word.BACK));
        System.out.print(">");
        
        switch (scan.nextInt()) {
            case 1:
                state = GameState.LANGUAGE_MENU;
                break;
            case 2:
                state = GameState.NAME_MENU;
                break;
            case 3:
                state = GameState.MAIN_MENU;
        }
    }
    
    public static void playing() {
        if (player.getState() == PlayerState.PLAYING) {
            playsMenu();
        }
        scan.nextLine();
        scan.nextLine();
        
        if (computer.getState() == PlayerState.PLAYING && player.getState() != PlayerState.DEFEAT && player.getState() != PlayerState.VICTORY) {
            computer.ai(deck);
        }
        scan.nextLine();
        printHands();
        
        if (player.getState() == PlayerState.VICTORY || computer.getState() == PlayerState.VICTORY || player.getState() == PlayerState.DEFEAT || computer.getState() == PlayerState.DEFEAT || (player.getState() == PlayerState.STOOD && computer.getState() == PlayerState.STOOD) ) {
            state = GameState.GAME_OVER;
        }
    }
    
    public static void playsMenu() {
        printHeader(Lang.tr(Word.PLAYS_MENU));
        
        System.out.println("(1) " + Lang.tr(Word.HIT));
        System.out.println("(2) " + Lang.tr(Word.STAND));
        System.out.println("(3) " + Lang.tr(Word.SURRENDER));
        System.out.print(">");
        
        switch (scan.nextInt()) {
            case 1:
                player.hit(deck);
                break;
            case 2:
                player.stand();
                break;
            case 3:
                player.surrender();
                break;
            default:
                player.hit(deck);
        }
    }
    
    public static void printHands() {
        printHeader(Lang.tr(Word.HANDS));
        
        player.printHand();
        computer.printHand();
        
        scan.nextLine();
    }
    
    public static void printHeader(String name) {
        System.out.print("\n=====|>");
        System.out.print(name);
        System.out.print("<|=====\n");
    }
    
    public static void start() {
        state = GameState.PLAYING;
        player = new Player(player.getName());
        computer = new Computer(Lang.tr(Word.COMPUTER), computer.getLevel().get(), player);
        deck = new Deck();
    }
}
