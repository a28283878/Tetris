package controller;

import view.GameView;
import view.MenuView;
import view.SettingView;
import view.tetris;

public class MainController {
	static MenuView Menu = new MenuView();
	static GameView Game = new GameView();
	static SettingView Setting = new SettingView();
	
    public static void main(String[] args) {
        MainController MC = new MainController();
    	MC.Menu();
    } 
    
    public MainController(){
    	
    }
    
    public void Menu(){
    	AllInvisible();
    	
    	Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);
    }
    
    public void Start(){
    	AllInvisible();
    	
    	Game.setLocationRelativeTo(null);
    	Game.setVisible(true);
    }
    
    public void Setting(){
    	AllInvisible();
    	
    	Setting.setLocationRelativeTo(null);
    	Setting.setVisible(true);
    }
    
    public void AllInvisible(){
    	Menu.setVisible(false);
    	Game.setVisible(false);
    	Setting.setVisible(false);
    }
}
