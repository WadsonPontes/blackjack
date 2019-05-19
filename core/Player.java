/*
* Author: Wadson Pontes
* Date: 2019/05/17
* Version: 1.0
*/
package core;

import tools.PlayerState;
import java.util.ArrayList;
import tools.Lang;
import tools.Word;

public class Player {
    protected String name;
    protected ArrayList<Card> hand;
    protected PlayerState state;
    
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.state = PlayerState.PLAYING;
    }
    
    public void printHand() {
        System.out.print(">>>");
        System.out.print(this.name);
        System.out.print("\n");
        
        for (Card card : hand) {
            System.out.print(">");
            card.printCard();
            System.out.print("\n");
        }
    }
     
    public void hit(Deck deck) {
        this.hand.add(deck.draw());
        
        System.out.print(">" + this.name + " " + Lang.tr(Word.PULLED) + " ");
        this.hand.get(this.hand.size() - 1).printCard();
        
        if (this.getScore() == 21) {
            this.state = PlayerState.VICTORY;
        }
        else if (this.getScore() > 21) {
            this.state = PlayerState.DEFEAT;
        }
    }
    
    public void stand() {
        this.state = PlayerState.STOOD;
        
        System.out.print(">" + this.name + " " + Lang.tr(Word.STOOD));
    }
    
    public void surrender() {
        this.state = PlayerState.DEFEAT;
        
        System.out.print(">" + this.name + " " + Lang.tr(Word.SURRENDERED));
    }
    
    public int getScore() {
        int score = 0;
        int as = 0;
        
        for (Card card : this.hand) {
            if (card.getValue() == 1) as++;
            score += card.getValue();
        }
        while (score < 12 && as > 0) {
            score += 10;
            as--;
        }
        
        return score;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public PlayerState getState() {
        return this.state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }
}