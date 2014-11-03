import java.util.*; // decimal format if needed
import javax.swing.*; //GUI dialog
import java.util.Scanner; // Scanner Class
import java.io.*; // need for file


public class vectorPasswordSetup {
public static void main (String [] args) throws IOException {


	JOptionPane.showMessageDialog (null, "this is a test");
	String usernamePassword = makeUNandPW();
	System.out.println(usernamePassword);
	int [] charNumeric = getTheCharNumeric(usernamePassword);
	String binaryString = makeToBinary(charNumeric); 
} // closes out main


//public static int checkForPreviousSetup() {
	/*
	*/

// } // closes checkForPreviousSetup
// ***********************************************************************************************

// ***********************************************************************************************
public static String makeUNandPW() throws IOException {
	/*  this is the prompt to make the 
	*/
	Scanner keyboard = new Scanner (System.in);
	PrintWriter outputFile = new PrintWriter("data_lab4.txt");

	String userPassword;
	String userName;
	int i = 0;

	//JOptionPane.showMessageDialog(null, "Please choose a sytem user name:");
	userName = JOptionPane.showInputDialog("Please Choose a new FILE user name");
	// outputFile.println("UN: " + userName);
	userPassword = JOptionPane.showInputDialog("Please choose your FILE password to be?:");
	// outputFile.println("PW: " + userPassword);
	outputFile.close();


	String userNamePassword = (userName + " " + userPassword);
	return userNamePassword;
} //this closes makeUNandPW
// ************************************************************************************************

// ************************************************************************************************
public static int [] getTheCharNumeric(String usernamePassword) {
/*
*/
	Random random  = new Random ();
	
	int i = 0;
	int temp ;

	int randomAmountOfLetters1 = (random.nextInt(200)+300);
	int randomAmountOfLetters2 = (random.nextInt(200)+300);
//System.out.println("*************************************************************" + randomAmountOfLetters1);
//System.out.println("*************************************************************" + randomAmountOfLetters2);
	int j = (randomAmountOfLetters1 + randomAmountOfLetters2 + usernamePassword.length());
	int [] charNumeric = new int [j];

	int [] firstPart = new int [randomAmountOfLetters1];
	for (i = 0; i < randomAmountOfLetters1; i ++) {
		int randomCharGenerator = random.nextInt(127 - 33);
		charNumeric [i] = ((char)randomCharGenerator);
		//System.out.println(firstPart [i]);
	} // closes for

	for (i = 0; i < usernamePassword.length(); i++) {
		temp = (int)usernamePassword.charAt(i); 
		charNumeric [(((randomAmountOfLetters1) - 1) + i)] = temp;
		//System.out.println(charNumeric[i]); // this prints out
	} // closes for loop
	
	int [] secondPart = new int [randomAmountOfLetters2];
	for (i = 0; i < randomAmountOfLetters2; i ++) {
		int randomCharGenerator = random.nextInt(127 - 33);
		charNumeric [(((randomAmountOfLetters1 + usernamePassword.length()) - 2) + i)] = ((char)randomCharGenerator);
		//System.out.println(secondPart [i]);
	} // closes for

	for (i = 0; i < j; i++){
		System.out.println(charNumeric[i]);
	}


	return charNumeric;
} // closes getTheCharNumeric
// ************************************************************************************************

// ************************************************************************************************
public static String makeToBinary (int [] charNumeric) {
/*
*/
	int i = 0;
	String binaryString = "";

	System.out.println("this is the length " + charNumeric.length);
	for (i = 0; i<charNumeric.length; i ++) {
		String temp = Integer.toBinaryString(charNumeric[i]);
		binaryString += (temp);
	}

	System.out.println(binaryString);
	return binaryString;	

} // closes makeToBinary
// ************************************************************************************************






} //this closes class





