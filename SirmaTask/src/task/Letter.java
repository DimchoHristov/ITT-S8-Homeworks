package task;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Letter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter some text: ");
		String text = sc.nextLine();
		System.out.println();
		String letters = text.replaceAll("[^a-zA-Z]", "").toUpperCase();
		
		if(letters != null && !letters.isEmpty()) {
			String[] array = letters.split("");
			TreeMap<String, Integer> unsortedLetter = new TreeMap<>();
			for (String string : array) {
				if(unsortedLetter.containsKey(string)) {
					int value = unsortedLetter.get(string);
					unsortedLetter.put(string, ++value);
				}
				else {
					unsortedLetter.put(string, 1);
				}
			}
					
			List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortedLetter.entrySet());
			
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	                return (o2.getValue()).compareTo(o1.getValue());
	            }
	        });
			
			Map<String, Integer> sortedLetter = new LinkedHashMap<String, Integer>();
	        for (Map.Entry<String, Integer> entry : list) {
	            sortedLetter.put(entry.getKey(), entry.getValue());
	        }
			
	        Map.Entry<String,Integer> ent = sortedLetter.entrySet().iterator().next();
	        int most = ent.getValue();
	        int limit = 20;
			System.out.println("Most common letters: \n");
		
			for (Entry<String, Integer> entry : sortedLetter.entrySet()) {
				if(limit==0) {
					break;
				}
				System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
				int count = (int) (Math.round((double)entry.getValue()/most*20));
				for(int i=0; i<count; i++) {
					System.out.print("#");
				}
				System.out.println();
				limit--;
			}
		}
		sc.close();
	}

}
