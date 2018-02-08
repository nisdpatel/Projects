/*
 * Authors: Cody Robertson, Nisha Patel
 * File: priority_queue.cpp
 * Date: 11-30-15
 * Description:
 *   The definition of the Priority_Queue class.
 */

#include "priority_queue.h"
using namespace std;

void Priority_Queue::enqueue(int num){
  //queue is populated and needs a sorted insert
  if (size() > 0){
    deque<int>::iterator it;
    it = buffer.begin();
    
    //find sorted spot for insert
    while (it != buffer.end()){
      if (*it <= num){
	//insert at position and exit function
	buffer.insert(it, num);
	return;
      } 
      //continue searching
      it++;
    }
  }
  
  //else, assign at end
  buffer.push_back(num);
}

void Priority_Queue::dequeue(){
  buffer.pop_front();
}

int Priority_Queue::top(){
  return buffer.front();
}

bool Priority_Queue::empty(){
  if (size() > 0){
    return false;
  }
  else{
    return true;
  }
}

int Priority_Queue::size(){
  return buffer.size();
}
