package com.suri.leetcode.medium;

import com.suri.common.QuadTreeNode;

/*
Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.

Return the root of the Quad-Tree representing grid.

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:

val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.
isLeaf: True if the node is a leaf node on the tree or False if the node has four children.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
We can construct a Quad-Tree from a two-dimensional area using the following steps:

If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
Recurse for each of the children with the proper sub-grid.

If you want to know more about the Quad-Tree, you can refer to the wiki.

Quad-Tree format:

You don't need to read this section for solving the problem. This is only if you want to understand the output format here. The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.

It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].

If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.



Example 1:


Input: grid = [[0,1],[1,0]]
Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
Explanation: The explanation of this example is shown below:
Notice that 0 represents False and 1 represents True in the photo representing the Quad-Tree.

Example 2:



Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
The topLeft, bottomLeft and bottomRight each has the same value.
The topRight have different values so we divide it into 4 sub-grids where each has the same value.
Explanation is shown in the photo below:

 https://leetcode.com/problems/construct-quad-tree/description

 Algorithm

Iterate over all the values in the current matrix, i.e., with the top-left coordinate at (x1, y1) and the length of the side as length. If all values are the same, then create and return a leaf node with the same value.

If all values are not the same, create a new node root, and then make recursive calls to the four sub-matrices:

a. Top-Left matrix with top-left coordinate as (x1, y1).

b. Top-Right matrix with top-left coordinate as (x1, y1 + length / 2).

c. Bottom-Left matrix with top-left coordinate as (x1 + length / 2, y1).

d. Bottom-Right matrix with top-left coordinate as (x1 + length / 2, y1 + length / 2).

Assign the nodes returned by these recursive calls as the respective child nodes of root.

Return root.

 */
public class Soln_427_Construct_Quad_Tree {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        System.out.println(construct(grid));
    }
    public static QuadTreeNode construct(int[][] grid) {

        return solve(grid, 0, 0, grid.length);

    }

    public static QuadTreeNode solve(int[][] grid, int x1, int y1, int length){

        if(sameValue(grid, x1, y1, length)){
            return new QuadTreeNode(grid[x1][y1]==1, true);
        }else{
            QuadTreeNode root = new QuadTreeNode(false, false);
            root.topLeft = solve(grid, x1, y1, length/2);
            root.topRight = solve(grid, x1, y1+length/2, length/2);
            root.bottomLeft= solve(grid, x1+length/2, y1, length/2);
            root.bottomRight = solve(grid, x1+length/2, y1+length/2, length/2);
            return root;
        }
    }

    public static boolean sameValue(int[][] grid, int x1, int y1, int length){

        for(int i=x1; i<x1+length; i++){
            for(int j=y1; j<y1+length; j++){
                if(grid[i][j]!= grid[x1][y1]){
                    return false;
                }
            }
        }
        return true;
    }

}
