package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Edit_Distance {

	//
	static int compute_Levenshtein_distanceDP(String str1,
			String str2)
	{

	// A 2-D matrix to store previously calculated
	// answers of subproblems in order
	// to obtain the final

	int[][] dp = new int[str1.length() + 1][str2.length() + 1];

	for (int i = 0; i <= str1.length(); i++)
	{
	for (int j = 0; j <= str2.length(); j++) {

	// If str1 is empty, all characters of
	// str2 are inserted into str1, which is of
	// the only possible method of conversion
	// with minimum operations.
	if (i == 0) {
	dp[i][j] = j;
	}

	// If str2 is empty, all characters of str1
	// are removed, which is the only possible
	// method of conversion with minimum
	// operations.
	else if (j == 0) {
	dp[i][j] = i;
	}

	else {
	// find the minimum among three
	// operations below


	dp[i][j] = minm_edits(dp[i - 1][j - 1]
	+ NumOfReplacement(str1.charAt(i - 1),str2.charAt(j - 1)), // replace
	dp[i - 1][j] + 1, // delete
	dp[i][j - 1] + 1); // insert
	}
	}
	}

	return dp[str1.length()][str2.length()];
	}

	// check for distinct characters
	// in str1 and str2

	static int NumOfReplacement(char c1, char c2)
	{
	return c1 == c2 ? 0 : 1;
	}

	// receives the count of different
	// operations performed and returns the
	// minimum value among them.

	static int minm_edits(int... nums)
	{

	return Arrays.stream(nums).min().orElse(
	Integer.MAX_VALUE);
	}
	//
	




// Driver Code
public static void main(String args[])
{





//System.out.println(compute_Levenshtein_distanceDP(s1, s2));
String[] array = new String[5];
array[0]= "عفان";
array[1]="استاد";
array[2]="my";
array[3]="name";
array[4]=".";


List<String> list = new ArrayList<String>();
// Adding elements in the List

// Iterating the List element using for-each loop
for (String lang : array) {
list.add(lang);
}
for(String output:list) 
{
	System.out.println("printing list here"); 
	System.out.println(output); 
	}




//String input="apears";
//
Scanner myObj = new Scanner(System.in);  // Create a Scanner object
// System.out.println("Enter word");

// String input1 = myObj.nextLine();  // Read user input
//
String input1="عفانے";

List<String> suggestion = new ArrayList<String>();
int tol=2;

// for each loop 
for (String word: list) 
{
int dist=compute_Levenshtein_distanceDP(input1, word);
if(dist<=tol)
{
suggestion.add(word);
}
}
//print

// spell checker here


if(suggestion.size()>0)
{
for (String word1: suggestion) 
{

System.out.println("did you mean?");  
System.out.println(word1);  
}
}

//
//suggestions here

}


}