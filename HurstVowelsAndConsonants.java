import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//main method
public class HurstVowelsAndConsonants {
	//main method that call upon other methods
	public static void main(String[] args) {
		createWindow();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------	
	//method for scanning for vowels
	public static Integer countVowels(String inString) {
		int vowelCount = 0;
		final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		final String vowelString = new String(vowels);
		
		//test print to check that the proper string has been entered
		System.out.println("the entered string is:\n" + inString);
		
		//loop that checks if each index is a vowel
		int length = inString.length();
		for (int i=0; i<length; ++i) {
			String indexCharString = Character.toString(Character.toLowerCase(inString.charAt(i)));
			if(vowelString.contains(indexCharString)) {
				++vowelCount;
			}
		}
		
		//test print to check the vowel count
		System.out.println("the entered string contains " + vowelCount + " vowels \n\n");
		
		//returns the amount of vowels in the entered text
		return vowelCount;
	}
	
	//method for scanning for consonants
	public static Integer countConsonants(String inString) {
		int consonantCount = 0;	
		final char[] consonants = 
			{'b', 'c', 'd', 'f', 'g', 'h', 'j', 
			'k', 'l', 'm', 'n', 'p', 'q', 'r', 
			's', 't', 'v', 'w', 'x', 'y', 'z'};
		final String consonantString = new String(consonants);
		
		//test print to check that the proper string has been entered
		System.out.println("the entered string is:\n" + inString);
		
		//loop that checks if each index is a consonant
		int length = inString.length();
		for (int i=0; i<length; ++i) {
			String indexCharString = Character.toString(Character.toLowerCase(inString.charAt(i)));
			if(consonantString.contains(indexCharString)) {
				++consonantCount;
			}
		}
		
		//test print to check the consonant count
		System.out.println("the entered string contains " + consonantCount + " consonants \n\n");
			
		//returns the amount of consonants in the entered text
		return consonantCount;	
	}

//--------------------------------------------------------------------------------------------------------------------------
	   private static void createWindow() {    
		      JFrame frame = new JFrame("Vowel and Consonant Counter");
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      createUI(frame);
		      frame.setSize(400, 250); 
		      frame.setResizable(false);
		      frame.setLocationRelativeTo(null);  
		      frame.setVisible(true);
		   }

	   private static void createUI(final JFrame frame){  
		      //creates different areas to group the buttons and text box
		      LayoutManager layout = new FlowLayout(); 
		      JPanel pane0 = new JPanel();
		      JPanel panel = new JPanel();
		      JPanel pane2 = new JPanel();    
		      pane0.setLayout(layout);   
		      panel.setLayout(layout); 
		      pane2.setLayout(layout);    
		      
		      //creates the buttons
		      String[] guiOptions = {"Count Consonants", "Count Vowels", "Count Characters (excludes whitespace)", "Close Program"};
		      JButton consonantsBtn = new JButton(guiOptions[0]);
		      JButton vowelBtn = new JButton(guiOptions[1]);
		      JButton bothBtn = new JButton(guiOptions[2]);
		      JButton quitBtn = new JButton(guiOptions[3]);
		      
		      //creates instruction text box
		      String instructions ="Welcome to the vowel and consonant counter machine!\n Enter some text into the box below and choose an option";
		      JTextArea instructionTB = new JTextArea(instructions);
		      instructionTB.setEditable(false);
		      instructionTB.setOpaque(false);

		      
		      //creates  input text box
		      JTextArea inputTB = new JTextArea();
		      int width = 250;
		      int height = 100;
		      inputTB.setPreferredSize(new Dimension(width, height));
		      inputTB.setLineWrap(true);
		      inputTB.setWrapStyleWord(true);

		      //adds the components to pane and organizes them
		      pane0.add(instructionTB);
		      pane0.add(inputTB);
		      panel.add(consonantsBtn);
		      panel.add(vowelBtn);
		      panel.add(bothBtn);
		      pane2.add(quitBtn);
		      frame.getContentPane().add(pane0, BorderLayout.NORTH); 
		      frame.getContentPane().add(panel, BorderLayout.CENTER); 
		      frame.getContentPane().add(pane2, BorderLayout.SOUTH); 
		      
		      //event that happens when the user selects the consonants button
		      consonantsBtn.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  System.out.println("user clicked consonants button \n\n");
		    		  
		    		  //gets the current text that is in the textbox and stores it as a varriable
				      String userText = inputTB.getText();
				      
				      //writes the message and displays it an another JOptionPane
		    		  String message = "The entered string contains " + countConsonants(userText) + " consonants";
				      JOptionPane.showMessageDialog(null, message);
		    	  }
		      });
		      
		      //event that happens when the user selects the both button
		      vowelBtn.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  System.out.println("user clicked vowels button \n\n");
		    		  
		    		  //gets the current text that is in the textbox and stores it as a varriable
				      String userText = inputTB.getText();
				      
				      //writes the message and displays it an another JOptionPane
		    		  String message = "The entered string contains " + countVowels(userText) + " vowels";
				      JOptionPane.showMessageDialog(null, message);
		    	  }
		      });
		      
		      //event that happens when the user selects the both button
		      bothBtn.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  System.out.println("user clicked both button \n\n");
		    		  
		    		  //gets the current text that is in the textbox and stores it as a varriable
				      String userText = inputTB.getText();
				      int characterCount = countVowels(userText) + countConsonants(userText);
				      
				      
				      //writes the message and displays it an another JOptionPane
		    		  String message = "The entered string contains " + characterCount + " characters (excluding whitespace)";
				      JOptionPane.showMessageDialog(null, message);
		    	  }
		      });
		      
		      //event that happens when the user selects the close program button
		      quitBtn.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  System.out.println("user clicked close button");
		    		  System.exit(0);
		    	  }
		      });
		      
		      System.out.println("the window has successfuly run \n\n");   
	   } 

}
