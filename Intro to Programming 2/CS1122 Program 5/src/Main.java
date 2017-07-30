import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		 LinkedBinaryTreeNode< String > tree = null;
		 TreeDisplayPanel treeDisplay = null;
		 String filename = "tree.data";
		 tree = loadData( filename );
		 JFrame frame = new JFrame( );
		 frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 frame.setSize( 800, 600 );
		 frame.setLayout( new BorderLayout( ) );
		 treeDisplay = new TreeDisplayPanel( tree );
		 JScrollPane scrollPane = new JScrollPane( treeDisplay );
		 frame.add( scrollPane, BorderLayout.CENTER );
		 frame.setVisible( true );
		 
		 treeDisplay.setTree( tree );

	}
	
	private static LinkedBinaryTreeNode<String> loadData( String filename ) throws FileNotFoundException {
		File fin = new File(filename);
		Scanner scan = null;
		try {
			scan = new Scanner( fin );
			while( scan.hasNext() ) {
				
			}
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		return null;
	}
	

}
