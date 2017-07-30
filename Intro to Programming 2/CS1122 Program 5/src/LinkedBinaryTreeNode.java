
public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

	/**
	 * This class provides linked binary tree nodes to program 5.
	 * 
	 * Date Last Modified: 04 /21 / 2017
	 * 
	 * @author Daniel Rutkowski
	 *
	 *         CS1122, Spring 2017
	 * 
	 */

	private E data = null; // value of the node
	private LinkedBinaryTreeNode<E> parent = null; // parent of the node
	private LinkedBinaryTreeNode<E> leftChild = null; // left child of the node
	private LinkedBinaryTreeNode<E> rightChild = null; // right child of the node

	@Override
	public E getData() {
		return data;
	}

	@Override
	public void setData(E data) {
		this.data = data;
	}

	@Override
	public BinaryTreeNode<E> getParent() {
		return parent;
	}

	/**
	 * This method sets a parent for the node.
	 * 
	 * @param newParent
	 *            : The parent to be set to the node.
	 */
	public void setParent(LinkedBinaryTreeNode<E> newParent) {
		this.parent = newParent;
	}

	@Override
	public BinaryTreeNode<E> getLeft() {
		return leftChild;
	}

	@Override
	public void setLeft(BinaryTreeNode<E> child) {
		for (LinkedBinaryTreeNode<E> node = this; node != null; node = (LinkedBinaryTreeNode<E>) node.getParent()) {
			if (node == child) {
				throw new IllegalArgumentException();
			}
		}

		LinkedBinaryTreeNode<E> currentChild = (LinkedBinaryTreeNode<E>) child;

		if (this.leftChild != null) {
			leftChild.parent = null;
		}
		if (currentChild != null) {
			currentChild.removeFromParent();
			currentChild.parent = this;
		}
		this.leftChild = currentChild;
	}

	@Override
	public BinaryTreeNode<E> getRight() {
		return rightChild;
	}

	@Override
	public void setRight(BinaryTreeNode<E> child) {
		for (LinkedBinaryTreeNode<E> node = this; node != null; node = (LinkedBinaryTreeNode<E>) node.getParent()) {
			if (node == child) {
				throw new IllegalArgumentException();
			}
		}

		LinkedBinaryTreeNode<E> currentChild = (LinkedBinaryTreeNode<E>) child;

		if (this.rightChild != null) {
			rightChild.parent = null;
		}
		if (currentChild != null) {
			currentChild.removeFromParent();
			currentChild.parent = this;

		}
		this.rightChild = currentChild;
	}

	@Override
	public void removeFromParent() {
		if (parent != null) {
			if (parent.leftChild == this) {
				parent.setLeft(null);
			} else if (parent.rightChild == this) {
				parent.setRight(null);
			}
			parent = null;
		}
	}

	@Override
	public void traversePreorder(BinaryTreeNode.Visitor visitor) {
		visitor.visit(this);
		if (leftChild != null) {
			leftChild.traversePreorder(visitor);
		}
		if (rightChild != null) {
			rightChild.traversePreorder(visitor);
		}
	}

	@Override
	public void traversePostorder(BinaryTreeNode.Visitor visitor) {
		if (leftChild != null) {
			leftChild.traversePostorder(visitor);
		}
		if (rightChild != null) {
			rightChild.traversePostorder(visitor);
		}
		visitor.visit(this);
	}

	@Override
	public void traverseInorder(BinaryTreeNode.Visitor visitor) {
		if (leftChild != null) {
			leftChild.traversePostorder(visitor);
		}
		visitor.visit(this);
		if (rightChild != null) {
			rightChild.traversePostorder(visitor);
		}
	}

	public LinkedBinaryTreeNode() {
		data = null;
	}

	public LinkedBinaryTreeNode(E data) {
		this.data = data;
	}

	public LinkedBinaryTreeNode(E data, LinkedBinaryTreeNode<E> parent) {
		this.data = data;
		this.parent = parent;
	}

	/**
	 * This method checks if the node has a left child.
	 */
	public boolean hasLeft() {
		return this.getLeft() != null;
	}

	/**
	 * This method checks if the node has a right child.
	 */
	public boolean hasRight() {
		return this.getRight() != null;
	}

	/**
	 * This method checks if the node has a parent.
	 */
	public boolean hasParent() {
		return this.getParent() != null;
	}

}
