package LowestCommonAncestor;

import java.io.*;
import java.util.*;

/**
 * Lowest Common Ancestor / Challenge 11 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/11/
 * 
 * @author Joe Stover
 * @version Mar 06, 2015
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{			
		// prebuild tree
		BST tree = new BST(30);
		tree.addNode(new BST(8));
		tree.addNode(new BST(52));
		tree.addNode(new BST(3));
		tree.addNode(new BST(20));
		tree.addNode(new BST(10));
		tree.addNode(new BST(29));
		// setup file I/O
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(" ");
				int one = Integer.parseInt(parts[0]);
				int two = Integer.parseInt(parts[1]);
				System.out.println(tree.getLCA(
								tree.search(one), tree.search(two)).value);
				
			}
			reader.close();
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Inner Class to represent a Binary Search Tree.
	 */
	public static class BST
	{
		BST parent;
		BST leftChild;
		BST rightChild;
		int value;
		
		/**
		 * Constructor that sets the value for this node in the tree.
		 * 
		 * @param value
		 */
		public BST(int value)
		{
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
			this.value = value;
		}
		/**
		 * Recursive method to add node based on BST rules.
		 * 
		 * @param node to be added to this tree
		 */
		public void addNode(BST node)
		{
			if(node.value < this.value)
			{
				if(this.leftChild == null)
				{
					this.leftChild = node;
					node.parent = this;
				}
				else
				{
					this.leftChild.addNode(node);
				}
			}
			else
			{
				if(this.rightChild == null)
				{
					this.rightChild = node;
					node.parent = this;
				}
				else
				{
					this.rightChild.addNode(node);
				}
			}
		}			
		/**
		 * Recursively find the node that contains the passed in value.
		 * 
		 * @param val that is being searched for
		 * @return the BST node that contains the passed in value
		 */
		public BST search(int val)
		{
			if(this.value == val)
			{
				return this;
			}
			else if(val < this.value)
			{
				return this.leftChild.search(val);
			}
			else
			{
				return this.rightChild.search(val);
			}
		}
		/**
		 * Gets the depth of the passed in node.
		 * 
		 * @param node for which we want to find a depth
		 * @return depth of the passed in node
		 */
		public int getNodeDepth(BST node)
		{
			if(node == this)
			{
				return 0;
			}
			return 1 + getNodeDepth(node.parent);
		}
		/**
		 * Finds the lowest common ancestor of 2 nodes in a tree.
		 * 
		 * @param nodeA node for which we want to find a common ancestor
		 * @param nodeB node for which we want to find a common ancestor
		 * @return      common ancestor BST node of nodeA and nodeB
		 */
		public BST getLCA(BST nodeA, BST nodeB)
		{
			BST lcaNode = null;
			// if either node parent is null, they are root
			if(nodeA.parent == null)
			{
				lcaNode = nodeA;
			}
			else if(nodeB.parent == null)
			{
				lcaNode = nodeB;
			}
			// if either node is the direct parent of the other
			else if(nodeB.parent == nodeA)
			{
				lcaNode = nodeA;
			}
			else if(nodeA.parent == nodeB)
			{
				lcaNode = nodeB;
			}
			// if nodes are same, they are their own LCA
			else if(nodeA == nodeB)
			{
				lcaNode = nodeB;
			}
			// use depth to determine shared parent
			else
			{
				int a = this.getNodeDepth(nodeA);
				int b = this.getNodeDepth(nodeB);
				
				if(b < a)
				{
					lcaNode = nodeA; 
					int counter = a - b + 1;
					int i = 0;
					while (i < counter && lcaNode != nodeB)
					{
						lcaNode = lcaNode.parent;
						i++;
					}			
				}
				else if(a < b)
				{
					lcaNode = nodeB;
					int counter = b - a + 1;
					int i = 0;
					while (i < counter && lcaNode != nodeA)
					{
						lcaNode = lcaNode.parent;
						i++;
					}
				}
				else if(a == b)
				{
					lcaNode = nodeA.parent;
				}
			}
			return lcaNode;
		}
	}
	/**
	 * Generates a BufferedReader for a file, either from passed in
	 * arguments or an input.txt file based on relation to this class.
	 * 
	 * @param args array of arguments passed to Main. If no args, finds
	 *             input.txt based on class location
	 * @return a BufferedReader based on input file
	 * @throws IOException if file is not found
	 */
	public static BufferedReader generateInputReader(String[] args) 
			throws IOException
	{
		if(args.length == 0)
		{
			InputStream stream = Main.class.getResourceAsStream("input.txt");
			return new BufferedReader(new InputStreamReader(stream));
		}
		else
		{
			return new BufferedReader(new FileReader(args[0]));
		}
	}
}

