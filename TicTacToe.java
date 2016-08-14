import java.util.Random;

public class TicTacToe extends Game{
	String status;
	private Player winner = null;
	private Player p1;
	private Player p2;
	private TicTacToeBoard t1;
	int noOfMoves = 0;
	
	public TicTacToe(Player p1,Player p2,TicTacToeBoard t1){
		this.p1 = p1;
		this.p2 = p2;
		this.t1 = t1;
	}
	
	public void playAMove(Player player, String move){
		
		int row = move.charAt(0) - 'A';
		int column = move.charAt(1) - '1' + 1; 
		
		//if the position is already filled then return
		if(t1.positions[row][column]!=0){
			return;
		}
		System.out.println(move);
		System.out.println("   Player type : "+player.type);
		noOfMoves++;
		
		t1.positions[row][column] = player.type;
		
		if(checkWinner(player)){
			System.out.println("** Game Ended! **");
			printBoard();
			System.out.println("Winner is : "+ winner.name);
			System.exit(0);
		}
	}
	
	private void printBoard(){
		for(int i=0;i<3;i++){
			System.out.println("");
			for(int j=0;j<3;j++){
				System.out.print(""+t1.positions[i][j]+ " | ");
			}
		}
	}
	public boolean checkWinner(Player player){
		
		//base condition for 
		if(noOfMoves<5){
			return false;
		}
		
		//Horizontal check
		for(int i=0;i<3;i++){
			if(t1.positions[i][0]==player.type && t1.positions[i][1]==player.type && t1.positions[i][2]==player.type){
				this.winner = player;
				return true;
			}
		}
		
		//vertical check
		for(int i=0;i<3;i++){
			if(t1.positions[0][i]==player.type && t1.positions[1][i]==player.type && t1.positions[2][i]==player.type){
				this.winner = p1;
				return true;
			}
		}
		
		//diagonal check
		if(t1.positions[0][0]==player.type && t1.positions[1][1]==player.type && t1.positions[2][2]==player.type){
			this.winner = player;
			return true;
		}
		
		//diagonal check
		if(t1.positions[0][2]==player.type && t1.positions[1][1]==player.type && t1.positions[2][0]==player.type){
			this.winner = player;
			return true;
		}
		
		return false;
	}
	
	private String createRandomMove(){
		int min = 0;
		int max = 2;
		String column = String.valueOf(new Random().nextInt(max - min + 1) + min);
		String alphabet = "ABC";
		String row = String.valueOf(alphabet.charAt(new Random().nextInt(max - min + 1) + min));
		return row+column;
	}		
		
	public void startGame(){
		int count = 1;
	    while(winner==null){
	    	String move = createRandomMove();
	    //	System.out.println(move);
	    	if(count%2==1)
	    		playAMove(p1,move);
	    	
	    	else
	    		playAMove(p2,move);
	    	
	    	count++;
	    		
	    }
	}
	
	
}
