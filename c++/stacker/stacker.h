/*
 * Author: Cody Robertson and Nisha Patel
 * File: stacker.h
 * Purpose: The definition of the Stacker class.
 * This class is implemented in stacker.cpp
 */


#ifndef STACKER_H
#define STACKER_H

#include <vector>
#include <string>
#include "pixel.h"
using namespace std;

class Stacker {
 private:
  string magic_number; //holds the arbitrary number and letter at the top of a .ppm
  int width; //holds how many pixels wide the picture is
  int height; //holds how many pixels tall the picture is
  int max_color; //holds the maximum color value that can exist
  bool isEmpty; //keeps track if the array has been initialized with empty pixel structs
  vector<pixel*>  pixels; //holds the color values in pixel structs for the picture

  void initialize();
  /*
   * Initializes pixels vector to array of empty pixel structs
   *
   * Precondition: pixels is not initializes, i.e. isEmpty=true
   * Postcondition: pixels is initialized, i.e. isEmtpy=false
   */

 public:
  Stacker();
  /* 
   * Default Constructor
   *
   * Postcondition: magic_number is equal to an empty string
   *                width, height, and max_color are set to 0
   *                isEmtpy is set to true
   */

  ~Stacker();
  /* 
   * Default Destructor
   *
   * Postcondition: magic_number is equal to an empty string
   *                width, height, and max_color are set to 0
   *                isEmpty is set to true
   */

  void add(string file_name);
  /*
   * Adds color values for each pixel in the file to the pixels vector
   *
   * Postcondition: color values are added to the pixels vector
   */

  void average(int total_files);
  /*
   * Averages the color values in the vector by the number of files added
   *
   * Precondition: color values from files have been added to the pixels vector 
   * Postcondition: color values are averaged to those of a clear picture
   */

  void stack(vector<string> file_names, int total_files);
  /*
   * Calls the add function for each file in file_names
   * Averages the color values for the files by total_files read in
   * 
   * Postconditions: pixels vector contains color values for a clear image
   */

  void write(string file_name);
  /*
   * Writes the header read in from the files as well as color values in the pixels vector
   * to an output file_name
   *
   * Precondition: at least 1 file has been added to the pixels vector and pixels has been initialized
   * Postcondition: output file containing color values has been created or overwritten
   */
};

#endif

