package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a numbers: ");
		ArrayList<Integer> list = new ArrayList<>();
		while(sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		int tempDiv=0;
		int bestDiv=0;
		int temp=0;
		
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(temp)<list.get(i+1)) {
				if(list.get(i)<list.get(i+1)) {
					tempDiv=list.get(i+1)-list.get(temp);
					if(tempDiv>bestDiv) {
						bestDiv=tempDiv;
					}
				}
			}
			else {
				temp=i+1;
			}
		}
		sc.close();
		System.out.println(bestDiv);
	}

}
