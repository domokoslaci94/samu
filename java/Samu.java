/**
 * @brief SAMU - the potential ancestor of developmental robotics chatter bots
 *
 * @file Main.java
 * @author  Norbert Bátfai <nbatfai@gmail.com>
 * @author  Dávid Veres
 * @version 0.0.1
 *
 * @section LICENSE
 *
 * Copyright (C) 2015 Norbert Bátfai, batfai.norbert@inf.unideb.hu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @section DESCRIPTION
 * SAMU
 * 
 * The main purpose of this project is to allow the evaluation and 
 * verification of the results of the paper entitled "A disembodied 
 * developmental robotic agent called Samu Bátfai". It is our hope 
 * that Samu will be the ancestor of developmental robotics chatter 
 * bots that will be able to chat in natural language like humans do.
 *
 * Java verzió elkészítése az eredeti cpp fájlok alapján.
 *
 */

//Samu java átírata
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class Samu
{

  public Samu ()
  {
    mutex_ = new ReentrantLock ();
    vi = new VisualImagery ();
    nlp = new NLP ();

    caregiver_name_ = new ArrayList < String > ();
    caregiver_name_.add ("Norbi");
    caregiver_name_.add ("Matyi");
    caregiver_name_.add ("Nandi");
    caregiver_name_.add ("Greta");
    caregiver_name_.add ("Laci");
  }

  public void destroy ()
  {
    run_ = false;
  }

  public boolean run ()
  {
    return run_;
  }

  public void FamilyCaregiverShell ()
  {
    String cmd_prefix = "___";

    System.out.print (Caregiver () + "@Caregiver> ");

    BufferedReader reader =
      new BufferedReader (new InputStreamReader (System.in));
    try
    {
      for (String line; (line = reader.readLine ()) != null;)
	{
	  if (line.substring (0, cmd_prefix.length ()).equals (cmd_prefix))
	    {
	      if (line == cmd_prefix)
		NextCaregiver ();
	    }
	  else
	    {
	      read (line);
	    }

	  System.out.print (Caregiver () + "@Caregiver> ");
	}
    }
    catch (IOException e)
    {
      e.printStackTrace ();
    }

    run_ = false;
  }

  public void terminal ()
  {
    mutex_.lock ();

    FamilyCaregiverShell ();
    mutex_.unlock ();
  }

  public void read (String sentence)
  {
    vi.working (nlp.sentence2triplets (sentence));
  }

  public String Caregiver ()
  {
    if (caregiver_name_.size () > 0)
      return caregiver_name_.get (caregiver_idx_);
    else
      return "Undefined";
  }

  public void NextCaregiver ()
  {
    caregiver_idx_ = (caregiver_idx_ + 1) % caregiver_name_.size ();
  }

  public double reward ()
  {
    return vi.reward ();
  }

  private boolean run_ = true;
  private Lock mutex_;

  private NLP nlp;
  private VisualImagery vi;

  private int caregiver_idx_ = 0;
  private List < String > caregiver_name_;

}
