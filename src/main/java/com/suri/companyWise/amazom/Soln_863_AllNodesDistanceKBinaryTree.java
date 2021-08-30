package com.suri.companyWise.amazom;

import java.util.*;
/**
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.

 https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 https://www.youtube.com/watch?v=nPtARJ2cYrg
 */
public class Soln_863_AllNodesDistanceKBinaryTree {
  TreeNode root;

  public static void main(String[] args) {

    Soln_863_AllNodesDistanceKBinaryTree allNodesDistanceKBinaryTree = new Soln_863_AllNodesDistanceKBinaryTree();

    allNodesDistanceKBinaryTree.createTree();

  }

  public void createTree() {
    this.root = new TreeNode(3);

    TreeNode n1 = new TreeNode(5);
    TreeNode n2 = new TreeNode(1);

    TreeNode n4 = new TreeNode(6);
    TreeNode n5 = new TreeNode(2);

    TreeNode n6 = new TreeNode(0);
    TreeNode n7 = new TreeNode(8);


    TreeNode n10 = new TreeNode(7);
    TreeNode n11 = new TreeNode(4);


    root.left = n1;
    root.right = n2;

    n1.left = n4;
    n1.right = n5;

    n2.left = n6;
    n2.right = n7;

    n5.left = n10;
    n5.right = n11;


    System.out.println(distanceK(root, n1, 2));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode startNode, int K) {

    /*
    Create the node to parent map and populate it
  */
    Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
    populateParent(root, null, parentNodeMap);


     /*
    Create the queue that we will use for the breadth first search.
    Add the start node to the queue
  */
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(startNode);

    /*
    The is an undirected graph now that we can go to and from nodes.
    Before we could only go down the tree.
    Therefore, we need a hashtable to keep track of nodes we have
    visited so that we do not go back and revisit what has already
    been processed and cause an infinite cycle
  */
    Set<TreeNode> seen = new HashSet<>();
    seen.add(startNode);

    /*
    When our search starts, we are standing at layer 0
  */
    int currentLayer = 0;

    while (!queue.isEmpty()) {



      /*
      Is this the layer we want? If so, extract and return it
    */
      if (currentLayer == K) {
        return extractLayerFromQueue(queue);
      }

      /*
      How large is this layer? Let's process all node in the layer.
      This is Breadth First Search.
    */
      int size = queue.size();

      for (int i = 0; i < size; i++) {

        /*
        Pull a node from the search queue, we are going to basically
        use our current layer to populate the next layer of nodes
        that we need to search in the next while loop iteration
      */
        TreeNode currentNode = queue.remove();


      /*
        Has left been touched before?
        No?
          1.) Add it to the seen hashtable
          2.) Add it to the search queue
      */
        if (currentNode.left != null && !seen.contains(currentNode.left)) {
          queue.add(currentNode.left);
          seen.add(currentNode.left);
        }

        /*
        Has right been touched before?
        No?
          1.) Add it to the seen hashtable
          2.) Add it to the search queue
      */
        if (currentNode.right != null && !seen.contains(currentNode.right)) {
          queue.add(currentNode.right);
          seen.add(currentNode.right);
        }

        /*
        Has this node's parent been touched before?
        No?
          1.) Add it to the seen hashtable
          2.) Add it to the search queue
      */
        TreeNode parentNodeofCurrent = parentNodeMap.get(currentNode);

        if (parentNodeofCurrent != null && !seen.contains(parentNodeofCurrent)) {
          queue.add(parentNodeofCurrent);
          seen.add(parentNodeofCurrent);
        }


      }
      /*
      Advance the layer for the next iteration
    */
      currentLayer++;
    }
    return new ArrayList<Integer>();
  }


  public void populateParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentNodeMap) {

    if (root == null) {
      return;
    }

    /*
    Map the node to its parent
  */

    parentNodeMap.put(root, parent);

    /*
    Go left and after that go right. The call that we make next
    will have what we call 'root' now as the 'parent' value so
    we can do the mapping in THAT call stack frame...and so on
    and so on...
  */
    populateParent(root.left, root, parentNodeMap);

    populateParent(root.right, root, parentNodeMap);

  }

  private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
    List<Integer> extractedList = new ArrayList();
    for (TreeNode node : queue) {
      extractedList.add(node.val);
    }
    return extractedList;
  }
}