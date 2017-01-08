package controller;

import model.GameSetting;
import view.StopView;
import view.GameView;
import view.ResultView;

public class GameController {
	static ResultView result = new ResultView();
	static StopView stop = new StopView();
	public static GameView Game;
	public GameSetting gamesetting;
	
	private int getres;
	
	public GameController(GameView Game){
		gamesetting = new GameSetting();
		this.Game = Game;
		Game.GS = gamesetting;
	}
	public GameController() {
		// TODO Auto-generated constructor stub
	}
	public void start(GameSetting gs){
		stop.setVisible(false);
		result.setVisible(false);
		gamesetting = gs;
		Game.GS.difficulty = gs.difficulty;
		Game.GamePrepare();
		Game.board.clearBoard();
    	Game.board.start();
    	Game.board.continu();
    	Game.Stop.setEnabled(true);
    	Game.setLocationRelativeTo(null);
    	Game.setVisible(true);
	}
	
    public void stop(){
    	result.setVisible(false);
    	Game.board.pause();
    	Game.Stop.setEnabled(false);
    	stop.setLocationRelativeTo(null);
    	stop.setVisible(true);
    }
    
    public void Game(){
    	stop.setVisible(false);
		result.setVisible(false);
    	Game.board.continu();
    	Game.Stop.setEnabled(true);
    	Game.setLocationRelativeTo(null);
    	Game.setVisible(true);
    	
    }
    
    public void Result(int res){
    	stop.setVisible(false);
    	result.setResult(res);
    	result.setLocationRelativeTo(null);
    	result.setVisible(true);
    	getres=res;
    }
    
    public int getresult(){
    	return getres;
    }
}
