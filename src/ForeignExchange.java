// Jonathan Bender
//
// https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1704
// Problem 10763 - Foreign Exchange

import java.util.*;
class Main
{
	public static void main(String[] args)
	{
		HashMap<Integer, Integer> mapOfLocations = new HashMap<>();
		Scanner input = new Scanner(System.in);
		int numberOfInputs;
		int enteringOrLeaving = -1;   // Starts off as 1 in loop, will be rotated for -1 and then for +1 whenever an input is read within the loop below
		int studentLocation;          // Holds the input's desired destination or source
		
		while (( numberOfInputs = input.nextInt() ) != 0)
		{
			for (int i = 0; i < (2 * numberOfInputs); i++)
			{
				enteringOrLeaving *= -1;                         // +1 is entering, -1 is leaving.
				studentLocation = input.nextInt();    
				if (mapOfLocations.get(studentLocation) == null)            // If nobody has wanted to enter/leave this place,
				{                                                           //
					mapOfLocations.put(studentLocation, enteringOrLeaving);  // Mark that someone wants to enter/leave.
				}                                                           //
				else                                                        // Otherwise,
				{                                                           // Mark that a student is entering (or leaving) the location
					mapOfLocations.put(studentLocation, mapOfLocations.get(studentLocation) + enteringOrLeaving);
				}
					
				if (mapOfLocations.get(studentLocation) == 0)      // If, for the given location, nobody has been matched
				{                                                  //  with a partner,
					mapOfLocations.remove(studentLocation);         // remove the location from the map.
				}                                                    //
			}                                                        //  If there are no locations, then everyone's been matched.
			                                                           // 
			System.out.println(mapOfLocations.isEmpty() ? "YES" : "NO"); //  If everyone's been matched, then it's a valid setup.
			mapOfLocations.clear();                                      //  In case the map isn't empty, remove all entries.
		}
		input.close();
	}
	
}
