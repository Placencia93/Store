
public class board {
	char [] board;
	int [] tracker;
	int count = 0;
	String X = "<a href='#' class='thumbnail'><img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>";
	String O = "<a href='#' class='thumbnail'><img src='http://placehold.it/150/78ddfa/ffffff?text=O' alt='O'></a>";
	String N = "<a href='TicTacToe.jsp?location=0' class='thumbnail'> <img src='http://placehold.it/150/cccccc?text=_' alt='Open Space'></a>";

	
	board(){
		this.board = new char[9];
		for(int x=0;x<9;x++){
			board[x] = 'x';
		}
		this.tracker = new int[9];
		for(int x=0;x<9;x++){
			tracker[x] = 0;
		}
	}
	
	
	public String squarePlacer(String A){
		if(A.equals("X"))
			return X;
		else if(A.equals("O"))
			return O;
		else
			return N;
	}
	public void playersTurn(){
		if(this.count%2==0){
			System.out.print("X");
		}else{
			System.out.print("O");
		}
	}
}
