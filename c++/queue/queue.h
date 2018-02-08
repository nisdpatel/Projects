/*
 * Authors: Cody Robertson, Nisha Patel
 * File: queue.h
 * Date: 11-30-15
 * Description:
 *   The definition of the queue class.
 */

#ifndef QUEUE_H
#define QUEUE_H

#include <deque>

class Queue{
 private:
  std::deque<int> buffer; //as ring buffer

 public:
  void enqueue(int num);
  /*
   * Description:
   *   Places num at back of the queue.
   * 
   * Parameters:
   *   num- the number being added
   *
   * Post-Conditions:
   *   num is at the back of the queue.
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
  
  int front();
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
   *   The number of elements currently sotred in the queue.
   */
};

#endif //QUEUE_H
