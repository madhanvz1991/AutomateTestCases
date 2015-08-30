package framework;

import java.util.Scanner;

public class BatchUnit
{
  public static void main(String[] args)
  {
    String filePath = "";
    String decision = "";

    Scanner scanner = new Scanner(System.in);

    System.out.println("\nEnter your project source path for generating ");
    filePath = scanner.nextLine();

    System.out.println("\nProject source path is " + filePath);

    System.out.println("\nProceed generating... Please enter y/n");
    decision = scanner.nextLine();

    if (decision.equalsIgnoreCase("y")) {
    	
    }
    else System.out.println("\nTest package generation cancelled");
  }
}
