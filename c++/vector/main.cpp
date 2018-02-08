/* Author: Nisha Patel
 * Last modified: 09/18/15
 * File name: main.cpp
 * Description: Main() will demonstrates push_back()-by entering the elements for the vector, size()-will t  ell the size of the vector and capacity()- will return the storage capacity of the vector. Basically, it    will implement a vector class and its function as needed.
*/


#include<iostream> // STDIN, STDOUT
#include "Vector.h" // Vector header class

using namespace std;
const int MAX_SIZE = 1500;

int main(){
  // begin main
  Vector vec; // an object of class Vector


  // displaying the default size and capacity of the vector
  cout<<"Size is: "<<vec.size()<<endl;
  cout<<"Capacity" <<vec.capacity()<<endl;
  
  // demonstration of the push_back by using a for loop to add vector
  for(int i=0; i < MAX_SIZE; i++){
    vec.push_back(i);
    cout << "i is: " << i << endl;
    cout<<"The address of i is :"<<&vec[i]<<endl; // calling operator[]
  }
  cout<<endl;
  // displaying the size and capacity after adding elements in the vector
  cout<<"Now the capacity of vector is :"<<vec.capacity()<<endl; // calling capacity()
  cout<<"Now the size of Vector is : "<<vec.size()<<endl; // calling size()
 

  return 0;
} // end main()
