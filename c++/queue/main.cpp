/*
 * Authors: Cody Robertson, Nisha Patel
 * File: main.cpp
 * Date: 11-30-15
 * Description:
 *   The driver of the Queue and Priority_Queue classes.
 */

#include "queue.h"
#include "priority_queue.h"
#include <iostream>
#include <fstream>

using namespace std;

int main(){
  Queue myQueue;
  Priority_Queue myPriority;
  ifstream input;
  int temp;
  
  //Retrieve user input
  int choice;
  cout << "Welcome to the Queue Tester!" << endl;
  cout << "What would you like to do? " << endl;
  cout << "   1. Test the Queue class." << endl;
  cout << "   2. Test the Priority_Queue class." << endl;
  cout << "   3. Generate Test File." << endl;
  cout << "   4. Exit the Program." << endl;
  cout << "Please enter your choice now: ";
  cin >> choice;

  //Run desired action, if applicable
  while (choice != 4){
    switch (choice){
    case 1:
      //test myQueue
      cout << endl;
      cout << "Testing the Queue class..." << endl;
      
      input.open("test.txt");
      temp = 0;

      //priming read
      input >> temp;
      
      //insert into queue
      while (input){
	cout << "Enqueueing " << temp << endl;
	myQueue.enqueue(temp);
	input >> temp;
      }

      //remove all from queue
      while (myQueue.size() > 0){
	cout << "Dequeueing " << myQueue.front() << endl;
	myQueue.dequeue();
      }

      cout << "Test Complete" << endl;

      input.close();
      break;

    case 2:
      //test myPriority
      cout << endl;
      cout << "Testing the Priority_Queue class..." << endl;
      
      input.open("test.txt");
      temp = 0;

      //priming read
      input >> temp;

      //insert all into queue
      while (input){
	cout << "Enqueueing " << temp << endl;
	myPriority.enqueue(temp);
	input >> temp;
      }
      
      //remove everything from the queue
      while (myPriority.size() > 0){
	cout << "Dequeueing " << myPriority.top() << endl;
	myPriority.dequeue();
      }
      
      cout << "Test Complete" << endl;
      
      input.close();
      break;

      //generate test file
    case 3:
      ofstream output;
      output.open("test.txt");
      
      //populate with 5000 numbers
      for (int i = 0; i < 5000; i++){
	output << i << endl;
	//should see two of each number enqueued and dequeued
	output << 4999-i << endl;
      }

      output.close();
      break;
    }
    
    
    //Retrieve user input
    cout << endl;
    cout << "Welcome to the Queue Tester!" << endl;
    cout << "What would you like to do? " << endl;
    cout << "   1. Test the Queue class." << endl;
    cout << "   2. Test the Priority_Queue class." << endl;
    cout << "   3. Generate Test File." << endl;
    cout << "   4. Exit the Program." << endl;
    cout << "Please enter your choice now: ";
    cin >> choice;
  }

  return 0;
}

