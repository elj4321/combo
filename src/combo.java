/*
ID: elj_4321
LANG: JAVA
TASK: combo
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.PrintStream;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.FileReader;

public class combo {

  private static boolean debug = false;
  private static final String task = "combo";
  private static PrintStream outs = System.out;

  /**
   * @param args
   */
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    final String infile = task + ".in";
    final String outfile = task + ".out";
//    URL location = test.class.getProtectionDomain().getCodeSource().getLocation();
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
//    o(location.getFile());
    Scanner scanr = new Scanner(new File(infile));

    // Read in stuff
    int N = scanr.nextInt();
    // If only 1 possible adjust limits, otherwise wrapping does not work
    int M = 2;
    if (N == 1) M = 1;
    outd("N,M = " + N + " " + M);
    int f1 = scanr.nextInt();
    int f2 = scanr.nextInt();
    int f3 = scanr.nextInt();
    int m1 = scanr.nextInt();
    int m2 = scanr.nextInt();
    int m3 = scanr.nextInt();
    outd("farm: " + f1 + " " + f2 + " " + f3);
    outd("master: " + m1 + " " + m2 + " " + m3);

    // Build up all possible combinations
    Set<String> allSet = new HashSet<String>();
    for (int i = -M; i <= M; i++)
    {
    for (int j = -M; j <= M; j++)
    {
    for (int k = -M; k <= M; k++)
    {
      int fi = (f1 + i); if (fi < 1) fi = fi + N; else if (fi > N) fi = fi - N;
      int fj = (f2 + j); if (fj < 1) fj = fj + N; else if (fj > N) fj = fj - N;
      int fk = (f3 + k); if (fk < 1) fk = fk + N; else if (fk > N) fk = fk - N;
      String newCombo = "" + fi + " " + fj + " " + fk;
      allSet.add(newCombo);
      int mi = (m1 + i); if (mi < 1) mi = mi + N; else if (mi > N) mi = mi - N;
      int mj = (m2 + j); if (mj < 1) mj = mj + N; else if (mj > N) mj = mj - N;
      int mk = (m3 + k); if (mk < 1) mk = mk + N; else if (mk > N) mk = mk - N;
      newCombo = "" + mi + " " + mj + " " + mk;
      allSet.add(newCombo);
    }
    }
    }

    // Output results
    outd("Total = " + allSet.size());
    out.println(allSet.size());
    scanr.close();
    out.close();
    System.exit(0);
  }
 
  static void outd(String msg)
  {
    if (debug) outs.println(msg);
  }
}
