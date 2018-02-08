/*
 * File: main.cpp
 * Authors: Cody Robertson and Nisha Patel
 * Date: 10-29-15
 * Description: A driver for the Collection class
 */

#include <iostream>
#include <string>
#include "cd.h"
#include "collection.h"

using namespace std;

int main(){
  int choice = 0;
  Collection utm;
  string filename, album, artist;
  cd newCD;

  //Present menu to user.
  cout << "Welcome to the UTM CD Collection!  You may select one of the following options:" << endl;
  cout << "1 Read a CD collection from a file." << endl;
  cout << "2 Write the CD collection to a file." << endl;
  cout << "3 Print the CD collection." << endl;
  cout << "4 Search for albums by artist." << endl;
  cout << "5 Search for an artist by album." << endl;
  cout << "6 Add a CD to the collection." << endl;
  cout << "7 Remove a CD from the collection." << endl;
  cout << "8 Exit this program." << endl;
  cout << endl;

  //Retrieve user input.
  cout << "Please enter your choice now: ";
  cin >> choice;

  //Loop program until user chooses 8 to quit.
  while (choice != 8){
    //Run selected task.
    switch (choice){

    case 1: //Read a CD collection from a file
      cout << "Please enter the name of the file: ";
      cin >> filename;

      utm.read_from_file(filename);
      cout << "Done." << endl;
      break;

    case 2: //Write the CD collection to a file.
      cout << "Please enter the name of the file: ";
      cin >> filename;
      
      utm.write_to_file(filename);
      cout << "Done." << endl;
      break;

    case 3: //Print the CD collection.
      cout << endl; //formatting
      utm.print();
      break;
      
    case 4: //Search for albums by artist.
      cout << "Please enter the CD's artist: ";
      cin.get(); //consume newline character in buffer
      getline(cin, artist);

     utm. find_artist(artist);
      break;

    case 5: //Search for an artist by album
      cout << "Please enter the name of the CD's album: ";
      cin.get();
      getline(cin, album);
      
      utm. find_album(album);
      break;

    case 6: //Add a CD to the collection.
      cout << "Please enter the CD's artist: ";
      cin.get(); //consume newline character in buffer
      getline(cin, newCD.artist);
      cout << "Please enter the CD's album: ";
      getline(cin, newCD.title);
      cout << "Please enter the number of tracks on the CD: ";
      cin >> newCD.total_tracks;
      cout << "Please enter the year of the CD: ";
      cin >> newCD.year;
      cout << "Please enter the price of the CD: ";
      cin >> newCD.price;
      cout << "Please enter the genre of the CD: ";
      cin.get(); //consume newline character in buffer
      getline(cin, newCD.genre);

      utm.insert_sorted(newCD);
      cout << "CD has been added to the collection." << endl;
      break;

    case 7: //Remove a CD from the collection
      cout << "Please enter the name of the artist to remove: ";
      cin.get();
      getline(cin, artist);
      cout << "Please enter the name of the album to remove: ";
      getline(cin, album);

      utm.remove(artist, album);
      break;

    default: //Do nothing if no match.
      break;
    }
    cout << endl;
    
    //Present menu again and receive input.
    cout << "Welcome to the UTM CD Collection!  You may select one of the following options:" << endl;
    cout << "1 Read a CD collection from a file." << endl;
    cout << "2 Write the CD collection to a file." << endl;
    cout << "3 Print the CD collection." << endl;
    cout << "4 Search for albums by artist." << endl;
    cout << "5 Search for an artist by album." << endl;
    cout << "6 Add a CD to the collection." << endl;
    cout << "7 Remove a CD to the collection." << endl;
    cout << "8 Exit this program." << endl;
    cout << endl;
    
    cout << "Please enter your choice now: ";
    cin >> choice;
  }

  return 0;
}
