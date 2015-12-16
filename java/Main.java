//Main java átírata
public class Main
{

  public static void main (String[]args)
  {
    System.out.
      println
      ("This program will try to provide a disembodied DevRob agent called Samu Bátfai.");
    System.out.println ("Copyright (C) 2015 Norbert Bátfai");
    System.out.
      println
      ("License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>");
    System.out.
      println
      ("This is free software: you are free to change and redistribute it.");
    System.out.
      println ("There is NO WARRANTY, to the extent permitted by law.");
    System.out.println ();

    System.out.println ("The prenatal development phase has started.");

    System.out.println ("The prenatal development phase has finished.");

    String test[] = {
    "This is a ball",
    "The ball is red",
    "I have a ball",
    "The sky is blue",
    "The grass is green",
    "I am Samu",
    "I love Samu"
    };

    int j = 0;

    for (Samu samu = new Samu (); samu.run ();)
      {

	double sum = 0.0;

	for (int i = 0; i < 7; ++i)
	  {
	    samu.read (test[i]);
	    sum += samu.reward ();
	  }

	System.out.println ("###### " + ++j + "-th iter " + sum);

      }

  }

}
