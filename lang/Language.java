/*
* Author: Wadson Pontes
* Date: 2019/05/17
* Version: 1.0
*/
package lang;

import tools.Word;

public class Language {
    protected String of;
    protected String clubs;
    protected String diamonds;
    protected String spades;
    protected String hearts;
    protected String language_menu;
    protected String name_menu;
    protected String main_menu;
    protected String options_menu;
    protected String difficulty_menu;
    protected String plays_menu;
    protected String start;
    protected String options;
    protected String exit;
    protected String language;
    protected String name;
    protected String back;
    protected String computer;
    protected String easy;
    protected String medium;
    protected String hard;
    protected String hit;
    protected String stand;
    protected String surrender;
    protected String hands;
    protected String defeat;
    protected String draw;
    protected String victory;
    protected String pulled;
    protected String stood;
    protected String surrendered;
    protected String game_over;
    
    public String tr(Word name) {
        switch (name) {
            case OF: return this.of;
            case CLUBS: return this.clubs;
            case DIAMONDS: return this.diamonds;
            case SPADES: return this.spades;
            case HEARTS: return this.hearts;
            case LANGUAGE_MENU: return this.language_menu;
            case NAME_MENU: return this.name_menu;
            case MAIN_MENU: return this.main_menu;
            case OPTIONS_MENU: return this.options_menu;
            case DIFFICULTY_MENU: return this.difficulty_menu;
            case PLAYS_MENU: return this.plays_menu;
            case START: return this.start;
            case OPTIONS: return this.options;
            case EXIT: return this.exit;
            case LANGUAGE: return this.language;
            case NAME: return this.name;
            case BACK: return this.back;
            case COMPUTER: return this.computer;
            case EASY: return this.easy;
            case MEDIUM: return this.medium;
            case HARD: return this.hard;
            case HIT: return this.hit;
            case STAND: return this.stand;
            case SURRENDER: return this.surrender;
            case HANDS: return this.hands;
            case DEFEAT: return this.defeat;
            case DRAW: return this.draw;
            case VICTORY: return this.victory;
            case PULLED: return this.pulled;
            case STOOD: return this.stood;
            case SURRENDERED: return this.surrendered;
            case GAME_OVER: return this.game_over;
            default: return "";
        }
    }
}
