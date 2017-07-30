
public class Answer<E> extends LinkedBinaryTreeNode<E>{
	
	/**
	 * This class provides answer nodes to program 5.
	 * 
	 * Date Last Modified: 04 /21 / 2017
	 * 
	 * @author Daniel Rutkowski
	 *
	 *         CS1122, Spring 2017
	 * 
	 */
	
	public Answer (   ) {
		this.setData(null);
	}
	
	public Answer ( E answerValue  ) {
		this.setData(answerValue);
	}
	
	public Answer ( E answerValue, Question<E> parent  ) {
		this.setData(answerValue);
		this.setParent(parent);
	}
	
	public Answer ( E answerValue, LinkedBinaryTreeNode<E> newParent,  LinkedBinaryTreeNode<E> newLeftChild,  LinkedBinaryTreeNode<E> newRightChild ) {
		this.setData( answerValue );
		this.setLeft(newLeftChild);
		this.setRight(newRightChild);
		this.setParent(newParent);
	}
	
	

}