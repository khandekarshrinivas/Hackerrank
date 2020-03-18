import java.util.HashSet;
import java.util.Set;

public class ValidateSudoku {

	public static boolean check_for_duplicates(char[] board) {
		Set<Character> set = new HashSet<>();
		for (char name : board) {
			if (name != '.' && set.add(name) == false) {
				return true;
			}
		}
		return false;
	}

	public static char[] getColumn(char[][] board, int col) {
		char[] column = new char[9];

		for (int j = 0; j < 9; j++) {
			column[j] = board[j][col];
		}
		return column;
	}

	public static char[] getbox(char[][] board, int row, int col) {
		char[] box = new char[9];
		int k = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				box[k++] = board[3 * row + i][3 * col + j];
			}
		}
		return box;
	}

	public static boolean isValidSudoku(char[][] board) {
		boolean flag = true;

		for (int i = 0; i < 9; i++) {
			if (check_for_duplicates(board[i]) || check_for_duplicates(getColumn(board, i))) {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			outer: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char[] c = getbox(board, i, j);
					if (check_for_duplicates(c)) {
						flag = false;
						break outer;
					}
				}
			}
		}
		System.out.println(flag);
		return flag;
	}

	public static void main(String[] args) {
		char[][] board = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		isValidSudoku(board);

		char[][] board2 = { 
				{ '.', '.', '4', '.', '.', '.', '6', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' },
				{ '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		isValidSudoku(board2);

		char[][] board3 = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		isValidSudoku(board3);
	}
}
