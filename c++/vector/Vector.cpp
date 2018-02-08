/* Author: Nisha Patel
 * Last date modified: 09/18/15
 * File name: Vector.cpp
 * Description: This file contain the defination of the functions on how it will perform those feature.
 */

#include <iostream> // STDIN, STDOUT
#include "Vector.h" 

using namespace std;

Vector::Vector(){
  // Default constructor. Initializes an empty array. Initializes the default value of vector size and capacity.
  vec_size = 0;
  vec_capacity = 0;
  vec_ptr= new int[vec_capacity];
  vec_ptr = NULL;
} // end defalut constructor

Vector::~Vector(){
  //Destructor. Deallocates vec_ptr. 
  delete []vec_ptr;
  vec_ptr = NULL;
  vec_size= 0; 
  vec_capacity = 0;
}// end destructor


int Vector::size(){
  //  Returns the current number of elements in the vector.
  return vec_size;
}

 int Vector::capacity(){
   /*  Returns the currently allocated storage capacity of the vector.
    Return:
    Current capacity of vector */
    return vec_capacity;   

  } // end capacity()

void Vector:: push_back(int element){
 
/* Description:
 *    Similar to std::vector.push_back(int element), stores element at the end of the vector
 * Parameters:
 *    element - The item to be inserted at the back of the vector.
 *
 * Postconditions:
 *    Item element has is stored at the end of the vector.
 */
  
  if((vec_size + 1) >= vec_capacity){
    if(vec_capacity == 0){
      //cap = 1
      reserve(1); 
    }
    else{
    reserve(2 * vec_capacity); // calling reserve to double the capacity if needed
    } 
  }
  element = vec_ptr[vec_size];
    vec_size++;
  
} // end push_back()


void Vector:: reserve(int n){
/* Description:
 *    Requests that the vector capacity be resized at least enough to contain n elements.
 *
 *    If n is greate than the current capacity, the function causes the container to reallocate
 *    its storage increasing its capacity to n (or greater).
 *
 *    If n is less than or equal to the current capacity, the call does nothing (no reallocation
 *    or change in vector capacity).
 *
 *    This function has no effect on vector size and cannot alter its elements.
 *
 * Postconditions:
 *    Vector capacity is now n.  Vector size (and contents) remains the same.
 */
// testing the size of n
  if(n>vec_capacity){
   
    int *tmp = new int [n];// declaring a new tmp array
    for(int i=0; i<vec_size;i++)
      tmp[i]= vec_ptr[i]; 
    delete [] vec_ptr; // deallocates the vec_ptr
    vec_ptr = tmp;
    vec_capacity = n; // setting capacity = n
  }
} // end reserve()
   
 int& Vector::operator[](unsigned int index){
/* Description
 * Returns the element at position index.
 */
  return vec_ptr[index];
 } 
