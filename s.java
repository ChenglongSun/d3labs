public class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < code.length();){

            if(i>0 && stack.isEmpty()) return false;

            if(code.startsWith("<![CDATA[", i)){//cdate
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i < 0) return false;
                i += 3;

            }else if(code.startsWith("</", i)){ //tag close
                int j = i + 2;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if(stack.isEmpty() || !stack.pop().equals(s)) return false;//check stack

            }else if(code.startsWith("<", i)){//tag open
                int j = i + 1;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);//store the tag
            }else{
                i++;
            }
        }
        return stack.isEmpty();
    }
}