package alperenozil.polestar.test;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    private String input="<([]){()}[{}])";
    private String findFirstIllegalCharacter(String input) {
        Stack<Character> characterStack = new Stack();
        for(int i=0; i<input.length(); i++){
            char currentCharacter = input.charAt(i);
            HashSet<Character> openingCharacterSet=new HashSet();
            openingCharacterSet.add('{');
            openingCharacterSet.add('[');
            openingCharacterSet.add('(');
            openingCharacterSet.add('<');
            if(openingCharacterSet.contains(currentCharacter)) {
                characterStack.push(currentCharacter);
            }
            else if(currentCharacter == '}') {
                if(characterStack.size() == 0 || characterStack.peek() != '{') {
                    return "}";
                } else {
                    characterStack.pop();
                }
            } else if(currentCharacter == ')') {
                if(characterStack.size() == 0 || characterStack.peek() != '(') {
                    return ")";
                } else {
                    characterStack.pop();
                }
            } else if(currentCharacter == ']') {
                if(characterStack.size() == 0 || characterStack.peek() != '[') {
                    return "]";
                } else {
                    characterStack.pop();
                }
            } else if(currentCharacter == '>') {
                if(characterStack.size() == 0 || characterStack.peek() != '<') {
                    return ">";
                } else {
                    characterStack.pop();
                }
            }
        }
        if(characterStack.size() > 0) {
            return "incomplete";
        }
        return "complete";
    }
    public String getFirstIllegalCharacter() {
        return findFirstIllegalCharacter(input);
    }
}
