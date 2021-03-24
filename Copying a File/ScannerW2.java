/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studikasus3;

import java.io.File;
import java.util.Scanner;
import java.util.*;
public class ScannerW2
{
  public static void main(String[] args) throws Exception
  {
    System.out.println("Your File Destination :");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    File file =
      new File(str);
    Scanner sc = new Scanner(file);
  
    while (sc.hasNextLine())
      System.out.println(sc.nextLine());
  }
}