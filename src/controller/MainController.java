package controller;

import view.Board;
import view.GameView;
import view.MenuView;
import view.ResultView;
import view.SettingView;
//import view.tetris;
import view.StopView;
import model.GameSetting;
import controller.GameController;

public class MainController {
	public static GameSetting gamesetting = new GameSetting();
	public static MenuView Menu = new MenuView();
	static GameView Game = new GameView();
	static SettingView Setting = new SettingView();
	static GameController GameController;

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
    	GameController  = new GameController(Game);
    	GameController.start(gamesetting);  	
    }

    public void Setting(){
    	AllInvisible();
    	Setting.GS = gamesetting;
    	Setting.setLocationRelativeTo(null);
    	Setting.setVisible(true);
    }
    
    public void AllInvisible(){
    	Menu.setVisible(false);
    	Game.setVisible(false);
    	Setting.setVisible(false);
    }
}
