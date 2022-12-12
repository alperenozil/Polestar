package alperenozil.polestar.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    private String input="<{([{{}}[<[[[<>{}]]]>[]]";
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
            System.out.println("incomplete");
            ArrayList<Character> list=new ArrayList();
            while(!characterStack.isEmpty()){
                list.add(findPair(characterStack.pop()));
            }
            for (Character c:list){
                System.out.print(c);
            }
            return "incomplete";
        }
        return "complete";
    }

    private Character findPair(Character c) {
        if(c.equals('[')) return ']';
        else if(c.equals('{')) return '}';
        else if(c.equals('(')) return ')';
        else if(c.equals('<')) return '>';
        return ' ';
    }
    private int getPointOfIllegalCharacter(String illegalCharacter) {
        if(illegalCharacter.equals("}")){
            return 1197;
        } else if(illegalCharacter.equals(")")){
            return 3;
        } else if(illegalCharacter.equals("]")){
            return 57;
        } else if(illegalCharacter.equals(">")){
            return 25137;
        }
        return 0;
    }
    public void calculateTotalPoints() {
        int result=0;
        for(String line : input.split("\n")){
            result+=getPointOfIllegalCharacter(findFirstIllegalCharacter(line));
        }
        System.out.println(result);
    }
}
