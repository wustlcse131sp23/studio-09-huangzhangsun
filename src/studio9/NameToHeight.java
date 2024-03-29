package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("A", 177);
		myMap.put("B", 167);
		myMap.put("C", 181);
		int flag = 1;
		while (flag == 1) {
			System.out.println("Enter a name: ");
			String name = in.nextLine();
			if (name.equals("quit")) {
				System.out.println("Quit!");
				flag = 0;

			} else {
				if (myMap.get(name) == null) {
					System.out.println("Please re-enter");
				} else {
					System.out.println(name + "'s height is: " + myMap.get(name));
				}
			}
		}
	}
}
