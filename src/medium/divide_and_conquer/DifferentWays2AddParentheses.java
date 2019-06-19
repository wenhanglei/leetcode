package medium.divide_and_conquer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: wenhanglei
 * @date: 2019/6/18
 * @time: 17:24
 * @info:Given a string of numbers and operators, return all possible results from
 *              computing all the different possible ways to group numbers and operators.
 *              The valid operators are +, - and *.
 */
public class DifferentWays2AddParentheses {

    //用于保存对应结果列表，避免重复查找
    Map<String, List<Integer>> map = new HashMap<>();

    //思路
    //分治
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        //边界检查
        if(input == null){
            return result;
        }
        //去掉字符串可能的括号
        input = input.trim();
        if(input.length() == 0) {
            return result;
        }
        //检查map中是否已经缓存了当前字符串的结果集
        if(map.containsKey(input)) {
            //如果已经缓存了当前表达式的结果集则直接返回当前表达式的结果列表
            return map.get(input);
        }

        //先检查字符串是否是全数字
        boolean isNum = true;
        for(int i = 0; i < input.length(); i++){
            char opt = input.charAt(i);
            if(opt == '+'){
                if(isNum) {
                    isNum = false;
                }
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for(int j : list1){
                    for(int k : list2){
                        result.add(j+k);
                    }
                }
            }else if(opt == '-'){
                if(isNum) {
                    isNum = false;
                }
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for(int j : list1){
                    for(int k : list2){
                        result.add(j-k);
                    }
                }
            }else if(opt == '*'){
                if(isNum) {
                    isNum = false;
                }
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for(int j : list1){
                    for(int k : list2){
                        result.add(j*k);
                    }
                }
            }
        }

        if(isNum) {
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);

        return result;

    }

    //测试函数
    public static void main(String[] args){

        DifferentWays2AddParentheses sol = new DifferentWays2AddParentheses();
        List<Integer> rest = sol.diffWaysToCompute("2-1-1");
        System.out.println(rest);
    }

}
