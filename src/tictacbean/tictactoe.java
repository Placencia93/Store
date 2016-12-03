package tictacbean;

public class tictactoe {

	private char player;
	private char winnerPlayer;
	private char currentPlayer;
	private char location;
	private char reset;
	private String nTile[];
	private String oTile;
	private String xTile;
	private char[] board;
	private boolean winner;


	public tictactoe(){
		super();
		player = 'X';
		currentPlayer = player;
		location = '0';
		winner = false;

		oTile = "<a href='#' class='thumbnail'><img src='http://placehold.it/150/78ddfa/ffffff?text=O' alt='O'></a>";
		xTile = "<a href='#' class='thumbnail'><img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>";

		board = new char[9];
		for(int x=0; x<9;x++){
			board[x] = '_';
		}

		nTile = new String[9];
		for(int x=0; x<9;x++){
			nTile[x] = "<a href='TicTacToeGameBean.jsp?Location"+x+"=${tictactoe.locationA["+x+"]}' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_' alt='Open Space'></a>";

		}
	}


	public char[] getBoard() {
		return board;
	}


	public void setBoard(char[] board) {
		this.board = board;
	}

	public char getPlayer(){
		return currentPlayer;
	}

	public void setPlayer(){
		if(currentPlayer == 'X'){
			currentPlayer = 'O';
		}else{
			currentPlayer = 'X';
		}
	}
	public void setLocation(int location){
		if(this.winner==false){
			setPostion(location);
			setPlayer();
		}else{
			System.out.println(this.winnerPlayer);
			
		}
		winner();
	}
	public void setPostion(int num){
		board[num] = currentPlayer;

	}
	public void setReset(int i){

		for(int x=0; x<9;x++){
			this.board[x] = '_';
		}

	}
	public String getWinner(){
		if(this.winner!=false){
		return "The Winner is "+this.winnerPlayer;
		}else{
			return "";
		}
	}

	public void winner(){
		// X IS WINNER
		if(board[0]=='X'&&board[1]=='X'&&board[2]=='X' || board[3]=='X'&&board[4]=='X'&&board[5]=='X' || board[6]=='X'&&board[7]=='X'&&board[8]=='X'){
			this.winner = true;
			this.winnerPlayer = 'X';
		}
		else if(board[0]=='X'&&board[3]=='X'&&board[6]=='X' || board[1]=='X'&&board[4]=='X'&&board[7]=='X' || board[2]=='X'&&board[5]=='X'&&board[8]=='X'){
			this.winner = true;
			this.winnerPlayer = 'X';
		}
		else if(board[0]=='X'&&board[4]=='X'&&board[8]=='X' || board[2]=='X'&&board[4]=='X'&&board[6]=='X'){
			this.winner = true;
			this.winnerPlayer = 'X';
		}
		// O IS WINNER
		else if(board[0]=='O'&&board[1]=='O'&&board[2]=='O' || board[3]=='O'&&board[4]=='O'&&board[5]=='O' || board[6]=='O'&&board[7]=='O'&&board[8]=='O'){
			this.winner = true;
			this.winnerPlayer = 'O';
		}
		else if(board[0]=='O'&&board[3]=='O'&&board[6]=='O' || board[1]=='O'&&board[4]=='O'&&board[7]=='O' || board[2]=='O'&&board[5]=='O'&&board[8]=='O'){
			this.winner = true;
			this.winnerPlayer = 'O';
		}
		else if(board[0]=='O'&&board[4]=='O'&&board[8]=='O' || board[2]=='O'&&board[4]=='O'&&board[6]=='O'){
			this.winner = true;
			this.winnerPlayer = 'O';
		}
	}

	public String getTile(char tilePostion,int num){
		if(tilePostion == 'X'){
			return xTile;
		}
		else if(tilePostion == 'O'){
			return oTile;
		}
		else{
			return nTile[num];
		}

	}

	public String getTile1(){
		return getTile(board[0],0);
	}
	public String getTile2(){

		return getTile(board[1],1);
	}
	public String getTile3(){
		return getTile(board[2],2);
	}
	public String getTile4(){
		return getTile(board[3],3);
	}
	public String getTile5(){

		return getTile(board[4],4);
	}
	public String getTile6(){
		return getTile(board[5],5);
	}
	public String getTile7(){
		return getTile(board[6],6);
	}
	public String getTile8(){
		return getTile(board[7],7);
	}
	public String getTile9(){
		return getTile(board[8],8);
	}


}
