
public class Question<E> extends LinkedBinaryTreeNode<E> {

	/**
	 * This class provides question nodes to program 5.
	 * 
	 * Date Last Modified: 04 /21 / 2017
	 * 
	 * @author Daniel Rutkowski
	 *
	 *         CS1122, Spring 2017
	 * 
	 */

	public Question() {
		this.setData(null);
	}

	public Question(E questionValue) {
		this.setData(questionValue);
	}

	public Question(E questionValue, Question<E> parent) {
		this.setData(questionValue);
		this.setParent(parent);
	}

	public Question(E questionValue, LinkedBinaryTreeNode<E> newParent, LinkedBinaryTreeNode<E> newLeftChild,
			LinkedBinaryTreeNode<E> newRightChild) {
		this.setData(questionValue);
		this.setLeft(newLeftChild);
		this.setRight(newRightChild);
		this.setParent(newParent);
	}

}