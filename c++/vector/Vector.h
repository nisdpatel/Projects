/* Author: Nisha Patel
 * Last date modified: 09/18/15
 * File name: Vector.h
 * Description: This header declares whatever is being implemented in the class Vector.
 */


class Vector{
 private:
  int *vec_ptr;//Points to the vector's dynamic array
  int vec_size, vec_capacity; //Same as size and capacity for std::vector
 

 public:
  Vector();
  /* Description:
   *    Default constructor.  Initializes an empty vector.
   *
   * Post-conditions:
   *    vec_ptr is NULL, vec_size=0, and vec_capacity=0.
   */


  ~Vector();
  /* Description:
   *    Destructor.  Deallocates vec_ptr.
   *
   * Postconditions:
   *    vec_ptr has been deallocated, current_size=0, and capacity=0.
   */
   int size();
  /* Description:
   *    Returns the current number of elements in the vector.
   *
   * Return:
   *    Current size of vector.
   */


  int capacity();
  /* Description:
   *    Returns the currently allocated storage capacity of the vector.
   *
   * Return:
   *    Current capacity of vector.
   */



  void push_back(int element);
  /* Description:
   *    Similar to std::vector.push_back(int element), stores element at the end of the vector.
   *
   * Parameters:
   *    element - The item to be inserted at the back of the vector.
   *
   * Postconditions:
   *    Item element has is stored at the end of the vector.
   *
   * Notes:
   *    If necessary, calls reserve() before adding element to the end of the vector.
   *    This reserve doubles the current capacity of the vector.
   */


 void reserve(int n);
  /* Description:
   *    Requests that the vector capacity be resized at least enough to contain n elements.
   *
   *    If n is greater than the current capacity, the function causes the container to reallocate
   *    its storage increasing its capacity to n (or greater).
   *
   *    If n is less than or equal to the current capacity, the call does nothing (no reallocation
   *    or change in vector capacity).
   *
   *    This function has no effect on vector size and cannot alter its elements.
   *
   * Postconditions:
   *    Vector capacity is now n.  Vector size (and contents) remains the same.
   *
   */


  int& operator[](unsigned int index);
  /* Description:
   *    Returns the element at position index.
   */
 
}; // end header class
