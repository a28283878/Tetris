package controller;

import view.Board;
import view.GameView;
import view.MenuView;
import view.ResultView;
import view.SettingView;
//import view.tetris;
import view.StopView;

public class MainController {
	static MenuView Menu = new MenuView();
	static GameView Game = new GameView();
	static SettingView Setting = new SettingView();
	static ResultView result = new ResultView();
	static StopView stop = new StopView();
    public static void main(String[] args) {
        MainController MC = new MainController();
    	MC.Menu();
    }

	private int getres;

    
    public MainController(){
    	
    }
    
    public void Menu(){
    	AllInvisible();
    	
    	Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);
    }
    
    public void Start(){
    	AllInvisible();
    	Game.board.clearBoard();
    	Game.board.start();
    	Game.board.continu();
    	Game.Stop.setEnabled(true);
    	Game.setLocationRelativeTo(null);
    	Game.setVisible(true);
    }
    public void stop(){
    	Game.board.pause();
    	Game.Stop.setEnabled(false);
    	stop.setLocationRelativeTo(null);
    	stop.setVisible(true);
    }
    public void Setting(){
    	AllInvisible();
    	
    	Setting.setLocationRelativeTo(null);
    	Setting.setVisible(true);
    }
    public void Result(int res){
    	AllInvisible();
    	
    	result.setResult(res);
    	result.setLocationRelativeTo(null);
    	result.setVisible(true);
    	getres=res;
    }
    public int getresult(){
    	return getres;
    }
    public void Game(){
    	AllInvisible();
    	Game.board.continu();
    	Game.Stop.setEnabled(true);
    	Game.setLocationRelativeTo(null);
    	Game.setVisible(true);
    	
    }
    
    public void AllInvisible(){
    	Menu.setVisible(false);
    	Game.setVisible(false);
    	Setting.setVisible(false);
    }
}
