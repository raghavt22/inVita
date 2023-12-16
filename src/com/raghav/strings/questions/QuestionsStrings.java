package com.raghav.strings.questions;

import java.util.Arrays;
import java.util.List;

public class QuestionsStrings {

	/*
	 *  Q. Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
		
		Example 1:-
		Input:
		S = i.like.this.program.very.much
		Output: much.very.program.this.like.i
Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i
	 */

	//Solution :-
	
	public String reverseString(String S) {
		String[] split = S.split("[.]");
		StringBuilder sb = new StringBuilder();
		List<String> asList = Arrays.asList(split);
		for(int i=asList.size()-1; i >= 0; i--) {
			if(i != 0)
			sb.append(asList.get(i)).append('.');
			else
			sb.append(asList.get(i));
		}//end for
		return sb.toString();
	}//end method
}//end class
