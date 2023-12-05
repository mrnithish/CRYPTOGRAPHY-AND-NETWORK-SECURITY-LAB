import java.util.Scanner; 
public class RowColumnTransformation { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 

System.out.print("Enter the number of rows: "); 
int rows = scanner.nextInt(); 
System.out.print("Enter the number of columns: "); 
int cols = scanner.nextInt(); 

int[][] matrix = new int[rows][cols]; 

System.out.println("Enter the elements of the matrix:"); 
 
for (int i = 0; i < rows; i++) { 
for (int j = 0; j < cols; j++) { 
matrix[i][j] = scanner.nextInt();}} 
System.out.println("Original Matrix:"); 
printMatrix(matrix); 
System.out.print("Enter the row numbers to swap (comma-separated): "); 
int row1 = scanner.nextInt() - 1;
int row2 = scanner.nextInt() - 1; 
swapRows(matrix, row1, row2); 
System.out.println("Matrix after row transformation:"); 
printMatrix(matrix); 
System.out.print("Enter the column numbers to swap (comma-separated): "); 
int col1 = scanner.nextInt() - 1;
int col2 = scanner.nextInt() - 1; 
swapColumns(matrix, col1, col2); 
System.out.println("Matrix after column transformation:"); 
printMatrix(matrix); 
scanner.close(); 
} 
 
public static void swapRows(int[][] matrix, int row1, int row2) { 
int[] temp = matrix[row1]; 
matrix[row1] = matrix[row2]; 
matrix[row2] = temp; 
} 
public static void swapColumns(int[][] matrix, int col1, int col2) { 
for (int i = 0; i < matrix.length; i++) { 
int temp = matrix[i][col1]; 
matrix[i][col1] = matrix[i][col2]; 
matrix[i][col2] = temp;}} 

public static void printMatrix(int[][] matrix) { 
for (int[] row : matrix) { 
for (int cell : row) { 
System.out.print(cell + " "); 
 
}
System.out.println();
}}}