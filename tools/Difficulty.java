/*
* Author: Wadson Pontes
* Date: 2019/05/18
* Version: 1.0
*/
package tools;

public enum Difficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3);
    
    private int value;
    
    private Difficulty(int value) {
        this.value = value;
    }
    
    public int get() {
        return this.value;
    }
}
