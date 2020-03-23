import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass {
	public static final int n = 5;
	
	public static void mainFunc() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Как вы хотите прочитать массивы?\n1. С клавиатуры\n2. С файла\n3. Работа со строками\n: ");
		
		int choiceInput = scan.nextInt();
		
		if (choiceInput == 1) {
			inputFromClav(staticMethod.array);
			massX(staticMethod.X, staticMethod.array);
			
			System.out.println("\n\nЗапись в файл массива X...");
			
			writeInFileX(staticMethod.X);
			
			System.out.println("\n\nЧтение из файла массива X:");
			
			readFromFileX(staticMethod.X);
		} else if (choiceInput == 2){
			readFromFile();
		} else if (choiceInput == 3) {
			stringFunc();
		}
		
		scan.close();
	}
	
	public static void inputFromClav(int[][] array){		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.print("A[" + i + "][" + j +"]: ");
				array[i][j] = scan.nextInt();
			}
			System.out.println();
		}
		scan.close();
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void readFromFile() throws FileNotFoundException {
        File file = new File("text.txt");
		
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine()); 
		}
		
		scan.close();
	}
	
	public static void massX(int[] X, int[][] array) {		
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				sum += array[i][j];
				X[i] = sum;
			}
			System.out.println();
			System.out.print("X[" + i + "]: " + X[i] + " ");
		}
	}
	
	public static void writeInFileX(int[] X) throws FileNotFoundException {
		File file = new File("newText.txt");
		PrintWriter pw = new PrintWriter(file);
		
		pw.println(Arrays.toString(staticMethod.X));
		
		pw.close();
	}
	
	public static void readFromFileX(int[] X) throws FileNotFoundException {
        File file = new File("newText.txt");
		
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine()); 
		}
		
		scan.close();
	}
	
	public static void stringFunc() {
		int n = 0;
		
		String shortString = null;
		
		while(true) {
			System.out.print("Введите число строк: ");
			Scanner scan = new Scanner(System.in);
			
			try {
				n = scan.nextInt();
				break;
			} catch(InputMismatchException fg) {
				System.out.println("Вы ввели не число.");
			}
		}
		
		String[] str = new String[n];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < n; i++) {
			System.out.print("Введите строку №" + (i + 1) + ": ");
			str[i] = scan.nextLine();
			
			if(i == 0) {
				shortString = str[i];
			} else if(shortString.length() > str[i].length()) {
				shortString = str[i];
			}
		}
		System.out.println("\nСамая короткая строка: " + shortString);
		System.out.println("Длина самой короткой строки: " + shortString.length());
	}
}
