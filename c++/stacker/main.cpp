/*
 * Author: Cody Robertson and Nisha Patel
 * File: main.cpp
 * Purpose: 1. Test features of Stacker class.
 *          2. Stack noisy images of user's choice into clear final image.
 * Date: 10-1-15         
 */

#include <iostream>
#include <vector>
#include <fstream>
#include <sstream> //used to convert integer to string for Linux
#include "stacker.h"
using namespace std;

int main(){
  Stacker myStack;
  string input;
  int total_images;
  vector<string> image_names;

  //get user input
  cout << "Please enter the image you wish to stack: ";
  cin >> input;

  cout << "Please enter the number of images: ";
  cin >> total_images;

  cout << "Stacking Images:" << endl;
  
  //generate file names for input files
  for (int i = 0; i < total_images; i++){
    stringstream image_name; //stringstream to convert integer to string on Linux
    image_name << "./"; 
    image_name << input << "/"; 
    image_name << input << "_";

    //account for amount of zeroes changing as amount of digits in number changes
    if (i < 9){
      image_name << "00";
    }
    else if (i < 99){
      image_name << "0";
    }

    //Calculate number for file name
    image_name << (1+i) << ".ppm";
    image_names.push_back(image_name.str());

    //Print file names
    cout << '\t' << image_names[i] << endl;
  }
  cout << endl;

  //stack images from generated file names
  myStack.stack(image_names, total_images);
  cout << "Stacking succeeded." << endl;

  //write stacked image to output file
  myStack.write(input + ".ppm");
  cout << "Output written to: " << input + ".ppm"  << endl;
  
  return 0;
}
