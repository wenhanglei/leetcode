package medium.binary_search;

import medium.array.Search2DMatrix;

/**
 * @author: wenhanglei
 * @date: 2019/6/13
 * @time: 9:52
 * @info: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *        Integers in each row are sorted in ascending from left to right.
 *        Integers in each column are sorted in ascending from top to bottom.
 */
public class Search2DMatrixII {

    //思路：与第一个版本类似，从对角线开始比对
    //
    public boolean searchMatrix(int[][] matrix, int target) {

        //边界检查
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int x = 0, y = matrix[0].length-1;

        while(x < matrix.length && y >= 0) {

            if (target < matrix[x][y]) {
                y--;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

    //测试函数
    public static void main(String[] args){
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix = {};
        Search2DMatrixII search2DMatrixII = new Search2DMatrixII();
        boolean result = search2DMatrixII.searchMatrix(matrix, 31);
        System.out.println(result);
    }

}
