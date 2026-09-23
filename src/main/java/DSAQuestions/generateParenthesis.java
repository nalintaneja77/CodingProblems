package DSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

//    Example 1:
//          Input: n = 3
//          Output: ["((()))","(()())","(())()","()(())","()()()"]
//    Example 2:
//          Input: n = 1
//          Output: ["()"]

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n)
    {

        backTrack("",0,0,n);

        return result;
    }

    private void backTrack(String current,int open,int close,int n)
    {
        if(current.length() == 2*n)
        {
            result.add(current);
        }
        if(open<n)
        {
            backTrack(current+"(",open+1,close,n);
        }
        if(close<open)
        {
            backTrack(current+")",open,close+1,n);
        }

    }

    public static void main(String[] args) {

        generateParenthesis vv= new generateParenthesis();
        vv.generateParenthesis(2);

    }
}
