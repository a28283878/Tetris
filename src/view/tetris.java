package view;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class tetris extends JFrame{
    JLabel statusbar;


    public tetris() {

        statusbar = new JLabel("0");
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);
        board.start();

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }	
}
