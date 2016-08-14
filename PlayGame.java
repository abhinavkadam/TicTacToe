
public class PlayGame {

	public static void main(String[] args) {

		Player p1 = new Player("Abhinav",1);
		Player p2 = new Player("Omkar",2);
		TicTacToeBoard tb1 = new TicTacToeBoard();
		TicTacToe testGame = new TicTacToe(p1,p2,tb1);
		testGame.startGame();
	}

}
