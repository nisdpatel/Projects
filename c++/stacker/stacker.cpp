/* 
 * Author: Cody Robertson and Nisha Patel
 * File: stacker.cpp
 * Purpose: Implementation of the Stacker class.
 *
 * Requires: stacker.h and pixel.h
 * Date: 10-1-15
 */

#include "stacker.h"
#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include "pixel.h"

using namespace std;

Stacker::Stacker(){
  magic_number = "";
  width = 0;
  height = 0;
  max_color = 0;
  //used to keep track of initialization
  isEmpty = true;
}

Stacker::~Stacker(){
  //reset values to initial values
  magic_number = "";
  width = 0;
  height = 0;
  max_color = 0;
  isEmpty = true; //vector destructor should be called automatically to make this true
}

void Stacker::initialize(){
  //fill vector with empty pixels for size of image
  for (int i = 0; i < width * height; i++){
    pixel* pixel_ptr;
    pixel_ptr = new pixel;
    
    //set pixel's values to 0 to allow for addition
    pixel_ptr->red = 0;
    pixel_ptr->green = 0;
    pixel_ptr->blue = 0;
    
    //add to vector
    pixels.push_back(pixel_ptr);
  }
  //let object know it has already been initialized
  isEmpty = false;
}

void Stacker::add(string file_name){
  ifstream input;
  input.open(file_name.c_str());
  
  string header;
  int pic_width, pic_height, pic_color;
  
  if (input) {
    //retrieve header information
    input >> header;
    input >> pic_width;
    input >> pic_height;
    input >> pic_color;
    
    //vector must be initialized with pixel objects
    //if currently empty
    if (isEmpty){
      magic_number = header;
      width = pic_width;
      height = pic_height;
      max_color = pic_color;
      initialize();
    }
    
    
    
    //add color values for each pixel in picture to the vector
    for (int i = 0; i < width * height; i++) {
      pixel color;
      //read in values
      input >> color.red;
      input >> color.green;
      input >> color.blue;
      
      //add values to vector
      pixels[i]->red += color.red;
      pixels[i]->green += color.green;
      pixels[i]->blue += color.blue;
    }
  }
  input.close();
}

void Stacker::average(int total_files){
  //divide color values for each picture by number of pictures added
  for (int i = 0; i < width * height; i++){
    pixels[i]->red /= total_files;
    pixels[i]->green /= total_files;
    pixels[i]->blue /= total_files;
  }
}

void Stacker::stack(vector<string> file_names, int total_files){
  //add color values to the vector for each file
  for (int i = 0; i < total_files; i++){
    add(file_names[i]);
  }
  //take the average across the vector
  average(total_files);
}


void Stacker::write(string file_name){
  ofstream output;
  output.open(file_name.c_str());
  
  //write header to file
  output<<magic_number<<endl;
  output<<width<<" "<<height<<endl;
  output<<max_color<<endl;
  
  //write individual color values for each pixel
  //seperated by newlines
  for(int i=0; i<width*height;i++){
    output<<pixels[i]->red<<" ";
    output<<pixels[i]->green<<" ";
    output<<pixels[i]->blue<<endl;
  }
  output.close();
}

