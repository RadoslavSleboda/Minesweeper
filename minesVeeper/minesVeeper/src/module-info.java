import java.lang.Math;
import java.util.Scanner;
class minesVeper {
	
	
	
	static String[][] visibleField = {{" X ", " 1 " ," 2 "," 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 "}, 
								{" 1 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 2 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 3 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 4 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 5 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 6 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 7 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 8 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{" 9 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
								{"10 ", " . ", " . "," . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "}
	};
	
	static String[][] hidenField =  {{" X  ", " 1." ," 2."," 3.", " 4.", " 5.", " 6.", " 7.", " 8.", " 9.", " 10.", " "}, 
									 {" 1. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 2. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 3. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 4. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 5. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 6. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 7. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 8. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {" 9. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {"10. ", " o ", " o "," o ", " o ", " o ", " o ", " o ", " o ", " o ", " o ", " "},
									 {"    ", "   ", "   ","   ", "   ", "   ", "   ", " ", "   ", "   ", "   ", "   "}
};
	
	 public static void main(String[] args) {
		 
		 Scanner key = new Scanner(System.in);
		 System.out.println("Choose number of mines between 10 and 80: ");
		
		 int mines = key.nextInt();
		 if (mines < 10) {
			 mines = 10;
		 	} else if (mines > 80) {
		 		mines = 80;
		 	}

		 placeMines(mines);
		 
		 createBoard();
		 for(int turns = 1; turns <= 100 - mines; turns++) {
			 move();
			 createBoard();
		 } 
		 System.out.println("You won!");
			 System.exit(0);
			 
		 }
		
		public static void createBoard() {
		
			 for(int i = 0; i < visibleField.length; i++) {
				 System.out.println(" ");
				 for(int j = 0; j < visibleField[0].length; j++) {
					 System.out.print(visibleField[i][j]);
		}
		
	 }
			 System.out.println(" ");	 
		}
		
		public static void placeMines(int mines) {
			for(int i = 1; i <= mines; i++) {
				int r = randomInt();
				int c = randomInt();
				if (!hidenField[r][c].equals(" M ")) {
				hidenField[r][c] = " M ";
				for(int a = -1; a <= 1; a++) {
					for(int b = -1; b <= 1; b++) {
						if(hidenField[r + a][c + b].equals(" M ")) {
							hidenField[r + a][c + b] = " M ";
						} else if (hidenField[r + a][c + b].equals(" o ")) {
							hidenField[r + a][c + b] = " 1 ";
						} else if (hidenField[r + a][c + b].equals(" 1 ")) {
							hidenField[r + a][c + b] = (" 2 ");
						} else if (hidenField[r + a][c + b].equals(" 2 ")) {
							hidenField[r + a][c + b] = (" 3 ");
						} else if (hidenField[r + a][c + b].equals(" 3 ")) {
							hidenField[r + a][c + b] = (" 4 ");
						} else if (hidenField[r + a][c + b].equals(" 4 ")) {
							hidenField[r + a][c + b] = (" 5 ");
						} else if (hidenField[r + a][c + b].equals(" 5 ")) {
							hidenField[r + a][c + b] = (" 6 ");
						} else if (hidenField[r + a][c + b].equals(" 6 ")) {
							hidenField[r + a][c + b] = (" 7 ");
						} else if (hidenField[r + a][c + b].equals(" 7 ")) {
							hidenField[r + a][c + b] = (" 8 ");
						} 
					}
						
					}
				} else {
					i--;
				}
			
			}
		}
		
		public static void move() {
			
			Scanner key = new Scanner(System.in);
			int i = key.nextInt();
			int j = key.nextInt();
			if (i == 112) {
				cheat();
				move();
			}
			
			if (i > 10 || j > 10) {
				move();
			}
			if (hidenField[i][j].equals(" M ")) {
				System.out.println("You have stepped on the mine!");
				System.exit(0);
			} else {
				visibleField[i][j] = hidenField[i][j];
			}
		}
		
		public static void cheat() {
			 for(int x = 0; x < hidenField.length; x++) {
				 System.out.println(" ");
				 for(int y = 0; y < hidenField[0].length; y++) {
					 System.out.print(hidenField[x][y]);
		}
			 }
		}
		
		
		public static int randomInt() {
			return (int) (Math.random() * 10 + 1);
		}
		
		}
	
	
