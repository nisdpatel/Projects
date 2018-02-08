/*
 * Authors: Cody Robertson, Nisha Patel
 * File: queue.cpp
 * Date: 11-30-15
 * Description:
 *   The implementation of the Queue class.
 */

#include "queue.h"
using namespace std;

void Queue::enqueue(int num){
  buffer.push_back(num);
}

void Queue::dequeue(){
  buffer.pop_front();
}

int Queue::front(){
  return buffer.front();
}

bool Queue::empty(){
  if (size() > 0){
    return false;
  }
  else {
    return true;
  }
}

int Queue::size(){
  return buffer.size();
}
