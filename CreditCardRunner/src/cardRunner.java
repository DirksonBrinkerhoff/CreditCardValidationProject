import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cardRunner
	{
		static long [] tempCardNumber = new long [16];
		static long ccNumber, ccNumber2;
		static int counter = 0;
		
		public static void main(String[] args) throws IOException
		{
				// new comment
				// import the text file
				Scanner myFile = new Scanner(new File("newCardNumbers.txt"));
				// while loop to run system
				while(myFile.hasNext())
				{
					ccNumber = myFile.nextLong();
					ccNumber2 = ccNumber;
					luhnAlgorithm();
				}
			System.out.println("There are " + counter + " possibly valid numbers.");
		}		
		public static void luhnAlgorithm()
		{
			// index variable
			int index = 15;
			// while loop for the index
			while(ccNumber > 0)
				{
					tempCardNumber[index] = ccNumber % 10;
					ccNumber = ccNumber / 10;
					index--;
				}
			
			// for loop to multiple every other number by 2
			for(int i = 0; i < tempCardNumber.length; i = i + 2)
				{					
					// if statement to not allow two digit numbers from multiplication
					if(tempCardNumber[i] * 2 >= 10)
						{
							tempCardNumber[i] = (tempCardNumber[i] * 2 / 10) + (tempCardNumber[i] * 2 % 10);
						}
					else 
						{
							tempCardNumber[i] = tempCardNumber[i] * 2;
						}
					
				}
			// sum variable
			int sum = 0;
			// for loop to just print every odd number (not multiply)
			for(int r = 0; r < tempCardNumber.length; r++)
				{
					sum += tempCardNumber[r];
				}
			//if statement to check for validity 
			if(sum % 10 == 0)
				{
					counter++;
					System.out.println("This credit card number: " + ccNumber2 + " is valid");
				}
			else
				{
					System.out.println("This credit card number: " + ccNumber2 + " is not possibly valid");
				}
		}
		
		// new comment
		
}