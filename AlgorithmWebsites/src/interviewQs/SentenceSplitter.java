/*
Author: Aman Ur Rahman
Program: SentenceSplitter
Description:
Take a string and an word/group or letters. Split the string according to that word/group or letters.
But the split should not omit the spaces. Fill in equal number of spaces in the replaced area.
*/
package interviewQs;

public class SentenceSplitter {

	public static void main(String[] args) {
		
		String test = "moon,       am at the moon, and manning my moonlander";
		String splitter = "moon";
		String[] splitString = test.split(splitter);
		StringBuilder newString = new StringBuilder();
		for(String s : splitString) {
			newString.append(s);
			for(int i=0; i<splitter.length(); i++)
				newString.append(" ");
		}
		String newTest = new String(newString);
		System.out.println(newTest);

	}

}