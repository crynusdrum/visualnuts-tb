package com.visual.nuts.exercise1;

public class Exercise1 {

	public static void main(String[] args) {		
		
		int number = 100;
		
		printNumbers(number);

	}

	private static void printNumbers(int number) {
		for (int num = 1; num <=number; num++) {  
			
			if (num % 3 == 0 && num % 5 == 0) {
				System.out.println("Visual Nuts");
			} else	if (num % 3 == 0) {
				System.out.println("Visual");
			} else 	if (num % 5 == 0) {
				System.out.println("Nuts");
			}else {
				System.out.println(num);
			}
				
		}
	}

}
