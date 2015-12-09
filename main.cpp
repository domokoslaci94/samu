/**
 * @brief SAMU - the potential ancestor of developmental robotics chatter bots
 *
 * @file main.hpp
 * @author  Norbert Bátfai <nbatfai@gmail.com>
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
 */

#include <iostream>
#include <string>
#include <sstream>
#include "samu.hpp"

int main ( int argc, char **argv )
{

  // Do not remove this copyright notice!
  std::cout << "This program will try to provide a disembodied DevRob agent called Samu Bátfai."
            << std::endl
            << "Copyright (C) 2015 Norbert Bátfai"
            << std::endl
            << "License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>"
            << std::endl
            << "This is free software: you are free to change and redistribute it."
            << std::endl
            << "There is NO WARRANTY, to the extent permitted by law."
            << std::endl
            << std::endl;


  std::cout << "The prenatal development phase has started."
            << std::endl;
  //
  std::cout << "The prenatal development phase has finished."
            << std::endl;


  std::string test[] =
  {
    "This is a ball",
    "The ball is red",
    "I have a ball",
    "The sky is blue",
    "The grass is green",
    "I am Samu",
    "I love Samu"
  };

  int j {0};

  for ( Samu samu; samu.run(); )
    {
      double sum {0.0};
      for ( int i {0}; i<7; ++i )
        {
          samu << test[i];
          sum += samu.reward();
        }
      std::cout << "###### " << ++j << "-th iter " << sum << std::endl;
    }

  return 0;
}
