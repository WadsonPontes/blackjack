/*
* Author: Wadson Pontes
* Date: 2019/05/18
* Version: 1.0
*/
package tools;

import lang.*;

public class Lang {
    public static Language lang = new English();
    
    public static String tr(Word name) {
        return lang.tr(name);
    }
    
    public static void set(int index) {
        switch (index) {
            case 1:
                lang = new English();
                break;
            case 2:
                lang = new Portuguese();
                break;
            case 3:
                lang = new English();
                break;
            case 4:
                lang = new English();
                break;
            case 5:
                lang = new English();
                break;
            case 6:
                lang = new English();
                break;
            default:
                lang = new English();
        }
    }
}
