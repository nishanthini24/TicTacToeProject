import java.util.Scanner;
import java.util.Random;
class TicTacToe {
  static char[][] board;
	public TicTacToe() {
		board=new char[3][3];
		initBoard();
		
	}
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}
	
	static void displayBoard() {
		System.out.println("----------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+"| ");
			}
			System.out.println();
			System.out.println("----------");
	}
	}

 static void placeMark(int row,int col,char mark){
	if(row>=0 && row<=2&&col>=0&&col<=2){
		board[row][col]=mark;
	}
	else{
		System.out.println("Invalid Position");
	
	}
}

 static boolean checkcol(){
	for(int j=0;j<=2;j++){
		if( board[0][j]!=' '&& board[0][j]==board[1][j] && board[1][j]==board[2][j]){
			return true;
		}
	}
	return false;
}

 static boolean checkrow(){
	for(int i=0;i<=2;i++){
		if(board[i][0]!=' '&& board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
			return true;
		}
	}
	return false;
}

 static boolean checkdioganol(){
	for(int i=0;i<=2;i++){
		if( board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] ||board[0][2]!=' ' &&
		board[0][2]==board[1][1]&& board[1][1]==board[2][0]){
			return true;
		}
		
	}
	return false;
}

static boolean checkDraw(){
	for(int i=0;i<=2;i++){
		for(int j=0;j<=2;j++){
			if(board[i][j]==' '){
				return false;
			}
		}
	}
	return true;
}
}

 abstract class Player{
	String name;
	Player(String name){
		this.name=name;
	}
	
	abstract void makeMove();
	
	boolean isValidMove(int row ,int col){
		if(row>=0&&row<=2&&col>=0&&col<=2){
			if(TicTacToe.board[row][col]==' '){
				return true;
			}
		}
		return false;
	}
}
class HumanPlayer extends Player{
	String name;
	char mark;
	HumanPlayer(String name,char mark){
		super(name);
		this.mark=mark;

	}
	void makeMove(){
		Scanner sc=new Scanner(System.in);
	int row;
	int col;	
		do
		{ 			
			System.out.println("Enter the row & col");
			 row =sc.nextInt();
			 col=sc.nextInt();
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row,col,mark);
	}
}
class AIPlayer extends Player{
	String name;
	char mark;
	AIPlayer(String name,char mark){
		super(name);
		this.mark=mark;
		
	}
	void makeMove(){
		Scanner sc=new Scanner(System.in);
	int row;
	int col;
		do
		{
			Random r=new Random();
			 row=r.nextInt(3);
			 col=r.nextInt(3);
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row,col,mark);

	}
	
}

public class LanchGame {

	
	public static void main(String[] args) {
		TicTacToe t= new  TicTacToe();
		System.out.println("Enter the player1 name");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Enter the Player2 name");
		String name1=sc.nextLine();
		HumanPlayer p1=new HumanPlayer(name, 'x');
		System.out.println("Enter the player Mode");
		System.out.println("1:Human");
		System.out.println("2:AI");
		int  choice=sc.nextInt();
		
		Player cp;
		if(choice==1){
			
		HumanPlayer	 p2=new HumanPlayer(name1,'o' );
		cp=p1;
		while(true){
			System.out.println(cp.name+" "+"Turn");
		cp.makeMove();
		 TicTacToe.displayBoard();
		if(TicTacToe.checkcol()||TicTacToe.checkrow()||TicTacToe.checkdioganol()){
			System.out.println(cp.name+" has won");
			break;
		}
		else if(TicTacToe.checkDraw()){
			System.out.println("Game is Draw");
			break;
		}
		 else{
			if(cp==p1){
				cp=p2;
			}
			else{
				cp=p1;
			}
		 }
	   }
		
		}
		else if(choice==2){
			AIPlayer p2=new AIPlayer(name1,'o' );
		
      
		
		cp=p1;
		while(true){
			System.out.println(cp.name+" "+"Turn");
		cp.makeMove();
		 TicTacToe.displayBoard();
		if(TicTacToe.checkcol()||TicTacToe.checkrow()||TicTacToe.checkdioganol()){
			System.out.println(cp.name+" has won");
			break;
		}
		else if(TicTacToe.checkDraw()){
			System.out.println("Game is Draw");
			break;
		}
		else{
			if(cp==p1){
				cp=p2;
			}
			else{
				cp=p1;
			}
		}
	}
		

	}
	
	
	}
}

    
