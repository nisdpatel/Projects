/*
 * File: collection.cpp
 * Authors: Cody Robertson and Nisha Patel
 * Date: 10-29-15
 * Description: The implementation of the Collection class.
 */

#include <iostream>
#include <string>
#include <fstream>
#include "collection.h"

using namespace std;

//Nothing to initialize
Collection::Collection(){
  
}

//List destructor deallocates all dynamic memory
Collection::~Collection(){
  
}

void Collection::insert_sorted(cd newCD){
  //insert newCD in alphabetical order by artist
  //Note: does not sort by last name
  list<cd>::iterator it;
  it = cd_collection.begin();
  while (it != cd_collection.end() && newCD.artist > it->artist){
    it++;
  }
  
  cd_collection.insert(it, newCD);
}

void Collection::read_from_file(string filename){
  cd newCD;
  ifstream input;
  input.open(filename.c_str() );

  //Priming Read
  getline(input, newCD.artist);
  getline(input, newCD.title);
  input >> newCD.total_tracks;
  input >> newCD.year;
  input >> newCD.price;
  input.get(); //consume newline character
  getline(input, newCD.genre);

  //Read in remaining
  while (input) {
    insert_sorted(newCD);

    getline(input, newCD.artist);
    getline(input, newCD.title);
    input >> newCD.total_tracks;
    input >> newCD.year;
    input >> newCD.price;
    input.get(); //consume newline character
    getline(input, newCD.genre);
  }

  input.close();
}

void Collection::write_to_file(string filename){
  
  ofstream output;
  output.open(filename.c_str());
  
  //Write each CD to the file in formatted style.
  list<cd>::iterator it;
  for (it = cd_collection.begin(); it != cd_collection.end(); ++it){
    output << it->artist <<endl;
    output << it->title <<endl;
    output << it->total_tracks << " ";
    output << it->year << " ";
    output << it->price <<endl;
    output << it->genre <<endl;
  }
  output.close();
}

void Collection::print(){
  list<cd>::iterator it;
  //Print each CD formatted for readability
  for (it = cd_collection.begin(); it != cd_collection.end(); ++it){
    cout << "Artist: " << it->artist <<endl;
    cout << "Album: " << it->title <<endl;
    cout << "Genre: " << it->genre <<endl;
    cout << "Tracks: " << it->total_tracks << endl;
    cout << "Year: " << it->year << endl;
    cout << "Price: $" << it->price <<endl;
    cout << endl;
  }
}

void Collection::find_artist(string artistToFind){
  bool found = false;
  list<cd>::iterator it;

  //find all albums by artist, if they exist
  for(it = cd_collection.begin(); it != cd_collection.end(); ++it){
    if(artistToFind == it->artist){
      //if first one found
      if (!found){
	cout<< it->title;
	found = true;
      }
      //if others have been found prior
      else{
	cout<< ", " << it->title;
      }
    }
  }

  if (!found){
    cout << "Artist was not found.";
  }
  cout << endl;
}

void Collection::find_album(string albumToFind){
  bool found = false;
  list<cd>::iterator it;

  //print artist of album, if it exists
  for(it = cd_collection.begin(); it != cd_collection.end(); ++it){
    if(albumToFind == it->title){
      //only needs to be printed once if there are duplicates
      if (!found){
	cout<< it->artist;
	found = true;
      }
    }
  }

  if (!found){
    cout << "Album was not found.";
  }
  cout << endl;
}

void Collection::remove(string artistToDelete, string albumToDelete){
  bool found = false;
  list<cd>::iterator it;

  //remove all matching artist/album combinations
  for(it = cd_collection.begin(); it != cd_collection.end(); ++it){
    if(artistToDelete == it->artist && albumToDelete == it->title){
      it = cd_collection.erase(it);
      found = true; 
    }
  }

  if(!found){
    cout<< "CD not found." << endl;
  }
  else if (found) {
    cout << "CD was found." << endl;
  }
}
