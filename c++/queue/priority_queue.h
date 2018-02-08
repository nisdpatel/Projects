/*
 * Authors: Cody Robertson, Nisha Patel
 * File: priority_queue.h
 * Date: 11-30-15
 * Description:
 *   The definition of the Priority_Queue class.
 */

#ifndef PRIORITY_QUEUE_H
#define PRIORITY_QUEUE_H

#include <deque>

class Priority_Queue{
 private:
  std::deque<int> buffer; //as heap

 public:
  void enqueue(int num);
  /*
   * Description:
   *   Places num sorted into the queue.
   * 
   * Parameters:
   *   num- the number being added
   *
   * Post-Conditions:
   *   Num is sorted in the queue.
   */

  void dequeue();
  /*
   * Description:
   *   Removes the number at the front of the queue.
   *
   * Post-conditions:
   *   The front number is removed from the queue.
   *
   */
  
  int top();
  /*
   * Description:
   *   Gives the next element in the queue.
   *
   * Return:
   *   The first element in the queue.
   */

  bool empty();
  /*
   * Description:
   *   Gives a true/false value for the queue being empty.
   *
   * Return:
   *   True if queue is empty; False if not empty.
   */

  int size();
  /*
   * Description:
   *   Gives the number of elements currently in the queue.
   *
   * Return:
   *   The number of elements currently sorted in the queue.
   */
};

#endif //PRIORITY_QUEUE_H
