import java.util.Scanner;

public class Main {
	
	static String[][] deck_init = {
			{"[ ]","[ ]","[ ]"}, // 
			{"[ ]","[ ]","[ ]"}, //
			{"[ ]","[ ]","[ ]"}, //
			};
	
	static int number = 0;
	
	
	static void printDeck() { // I = row (Y) J = collumn (X)
		for (int i = 0; i < deck_init.length; i++) {
			System.out.println();
			for (int j = 0; j < deck_init[i].length; j++) {
				System.out.print(deck_init[i][j]);
			}
		}
		System.out.println();
	}
	
	
	static void player_O () {
		System.out.println(" \n-- Player O --");
		
		Scanner get_x = new Scanner(System.in);
		System.out.print("Enter position X [1-3]: ");
		int x_pos = Integer.parseInt(get_x.nextLine())-1;
		
		Scanner get_y = new Scanner(System.in);
		System.out.print("Enter position Y [1-3]: ");
		int y_pos = Integer.parseInt(get_y.nextLine())-1;
		
		try {			
			do_round(x_pos, y_pos, "O");
		}
		catch (Exception e) {
			System.out.println("Error: e");
			player_O();
		}
		

		checkStatus();
		
	}
	
	static void player_X () {
		System.out.println(" \n-- Player X --");
		
		Scanner get_x = new Scanner(System.in);
		System.out.print("Enter position X [1-3]: ");
		int x_pos = Integer.parseInt(get_x.nextLine())-1;
		
		Scanner get_y = new Scanner(System.in);
		System.out.print("Enter position Y [1-3]: ");
		int y_pos = Integer.parseInt(get_y.nextLine())-1;
		
		try {			
			do_round(x_pos, y_pos, "X");
		}
		catch (Exception e) {
			System.out.println("Error: e");
			player_X();
		}
		

		checkStatus();
		
	}
	
	
	static void do_round(int x, int y, String s) {
		
		if (deck_init[y][x].equals("[ ]")) {
			deck_init[y][x] = "["+s+"]";
			System.out.println();
		}
		else {
			System.out.println("No, this one is already taken...");
		}
		
	}
	
	static void checkStatus() {
		String a = deck_init[0][0];
		String b = deck_init[0][1];
		String c = deck_init[0][2];
		String d = deck_init[1][0];
		String e = deck_init[1][1];
		String f = deck_init[1][2];
		String g = deck_init[2][0];
		String h = deck_init[2][1];
		String i = deck_init[2][2];
			
		if (
				( a.equals(b) && b.equals(c) && c.equals(a) && a.compareTo("[ ]") > 0 ) || // LINEAR 
				( d.equals(e) && e.equals(f) && f.equals(d) && d.compareTo("[ ]") > 0 ) ||
				( g.equals(h) && h.equals(i) && i.equals(g) && g.compareTo("[ ]") > 0 ) ||
				
				( a.equals(d) && d.equals(g) && g.equals(a) && a.compareTo("[ ]") > 0 ) || // VERTICAL
				( b.equals(e) && e.equals(h) && h.equals(b) && b.compareTo("[ ]") > 0 ) ||
				( c.equals(f) && h.equals(i) && i.equals(c) && c.compareTo("[ ]") > 0 ) ||
				
				( a.equals(c) && c.equals(i) && i.equals(a) && a.compareTo("[ ]") > 0 ) || // DIAGONAL
				( g.equals(e) && e.equals(c) && c.equals(g) && g.compareTo("[ ]") > 0 )
				
			) 
		{
			victory();
		}
	}
	
	static void victory() {
		System.out.println("*** GAME OVER ***");
		System.out.print("...");
		number = 1;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(" \n-- TIC-TAC-TOE --");
		number = 0;
		
		while (number == 0) { 
			
			player_O(); // O - round
			printDeck();
			
			player_X(); // X - round
			printDeck();
			
		}
		
	}
	

}
