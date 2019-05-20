/*
* Author: Wadson Pontes
* Date: 2019/05/19
* Version: 4.0
*/
package core;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    
    public Deck() {
        this.cards = new ArrayList<Card>();
        
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                this.cards.add(new Card(i, j));
            }
        }
        this.shuffle();
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card draw() {
        return this.cards.remove(0);
    }
    
    public Card draw(int index) {
        return this.cards.remove(index);
    }
    
    public Card getCard(int index) {
        return cards.get(index);
    }
}