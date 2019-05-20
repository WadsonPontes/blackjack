/*
* Author: Wadson Pontes
* Date: 2019/05/19
* Version: 4.0
*/
package core;

import tools.Difficulty;
import tools.Lang;
import tools.PlayerState;
import tools.Word;

public class Computer extends Player {
    private Difficulty level;
    private Player player;

    public Computer(String name, int level, Player player) {
        super(name);
        this.player = player;
        
        switch (level) {
            case 1:
                this.level = Difficulty.EASY;
                break;
            case 2:
                this.level = Difficulty.MEDIUM;
                break;
            case 3:
                this.level = Difficulty.HARD;
                break;
            default:
                this.level = Difficulty.EASY;
        }
    }
    
    public void hit(Deck deck, int index) {
        this.hand.add(deck.draw(index));
        
        System.out.print(">" + this.name + " " + Lang.tr(Word.PULLED) + " ");
        this.hand.get(this.hand.size() - 1).printCard();
        
        if (this.getScore() == 21) {
            this.state = PlayerState.VICTORY;
        }
        else if (this.getScore() > 21) {
            this.state = PlayerState.DEFEAT;
        }
    }
    
    public void ai(Deck deck) {
        switch (this.level) {
            case EASY:
                if (this.getScore() + deck.getCard(0).getValue() > 21) {
                    this.hit(deck);
                }
                else if (this.getScore() + deck.getCard(1).getValue() > 21 || this.getScore() < this.player.getScore()) {
                    this.hit(deck, 1);
                }
                else {
                    this.stand();
                }
                break;
            case MEDIUM:
                if (this.getScore() < 15 || this.getScore() < this.player.getScore()) {
                    this.hit(deck);
                }
                else {
                    this.stand();
                }
                break;
            case HARD:
                if (this.getScore() + deck.getCard(0).getValue() <= 21) {
                    this.hit(deck);
                }
                else if (this.getScore() + deck.getCard(1).getValue() <= 21 || this.getScore() < this.player.getScore()) {
                    this.hit(deck, 1);
                }
                else {
                    this.stand();
                }
        }
    }
    
    public Difficulty getLevel() {
        return this.level;
    }

    public void setLevel(Difficulty level) {
        this.level = level;
    }
}