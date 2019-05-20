/*
* Author: Wadson Pontes
* Date: 2019/05/19
* Version: 4.0
*/
package core;

import tools.Word;
import tools.Lang;

public class Card {
    private String number;
    private String suit;
    private int value;

    public Card(int number, int suit) {
        switch (number) {
            case 1:
                this.number = "A";
                this.value = 1;
                break;
            case 11:
                this.number = "J";
                this.value = 10;
                break;
            case 12:
                this.number = "Q";
                this.value = 10;
                break;
            case 13:
                this.number = "K";
                this.value = 10;
                break;
            default:
                this.number = String.valueOf(number);
                this.value = number;
        }
        
        switch (suit) {
            case 1:
                this.suit = Lang.tr(Word.CLUBS);
                break;
            case 2:
                this.suit = Lang.tr(Word.DIAMONDS);
                break;
            case 3:
                this.suit = Lang.tr(Word.SPADES);
                break;
            case 4:
                this.suit = Lang.tr(Word.HEARTS);
        }
    }
    
    public void printCard() {
        System.out.print(this.number + " " + Lang.tr(Word.OF) + " " + this.suit);
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}