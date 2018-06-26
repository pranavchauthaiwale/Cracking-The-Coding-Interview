package Chapter01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    /*
	 Chapter 01 Question 01.
	 Implement an algorithm to determine if a string has all unique characters.
	 What if you cannot use additional data structures?
	*/

    public static void main(String[] args){
        String input = "Test String";
        boolean result = solution(input);
        System.out.println(String.format("For input: '%s' Result is: %s", input, result));
        boolean result2 = solution2(input);
        System.out.println(String.format("For input: '%s' Result is: %s", input, result2));
        boolean result3 = solution3(input);
        System.out.println(String.format("For input: '%s' Result is: %s", input, result3));
    }

    public static boolean solution(String input){
        Set<Character> occurrence = new HashSet<>();
        for(char ch : input.toCharArray()){
            if(occurrence.contains(ch)){
                return false;
            }
            occurrence.add(ch);
        }
        return true;
    }

    public static boolean solution2(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean solution3(String input){
        //Assuming that the individual characters in the input string are limited to extended-ASCII
        //With this assumption we can take an boolean array of size 256 to track occurrence of characters
        // CTCI approach

        if(input == null || input.length() == 0 || input.length() > 256){
            return false;
        }

        boolean[] occurrence = new boolean[256];
        for(char ch : input.toCharArray()){
            int val = (int) ch;
            if(occurrence[val]){
                return false;
            }
            occurrence[val] = true;
        }
        return true;
    }
}
