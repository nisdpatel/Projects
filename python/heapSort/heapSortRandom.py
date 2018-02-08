#Name: Nisha Patel
#Description: Implementation of heapSort with random data
#File name: heapSortRandom.py
#Date: 11/09/17
import sys
import math
import random

def Max_Heapify(A, i,size):
    l = 2 * i
    r =  2 * i+ 1
 
    if l <= size and A[l] > A[i]:
        largest = l
    else:
        largest = i
    if r <= size and A[r] > A[largest]:
        largest = r
    if not largest == i:
        A[i], A[largest] = A[largest],A[i]
        Max_Heapify(A,largest, size)
        

def Build_Max_Heap(A, size):
   n = len(A)
   for i in range ((size)//2,0,-1):
       Max_Heapify(A,i, size)


def HeapSort(A):
    size = len(A) - 1
    Build_Max_Heap(A, size)
    for i in range ((len(A) - 1),1,-1):
        A[1], A[i] = A[i], A[1]
        size = size - 1
        Max_Heapify(A,1,size)
        


n= sys.argv[1]
#n = int (input("Enter size of n "))
A = []

A.append('') # for the 0th index
for item in range(0,int(n)):
    A.append(random.randint(1,1000))
    

print("Unsorted",A)
HeapSort(A)
print("Sorted", A)

        
