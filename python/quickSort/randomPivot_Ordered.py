#Name: Nisha Patel
#Description: Implementation of quickSort random pivot with ordered data
#File name: randomPivot_ordered.py
#Date: 11/09/17


import sys

import random

def partition(A,low,high):
    x = A[high]
    i = (low-1) 
    for j in range(low , high):
        if  A[j] <= x:
            i = i+1
            A[i],A[j] = A[j],A[i]
    A[i+1],A[high] = A[high],A[i+1]
    return (i+1)



def Randomized_Partition(A, low, high):
    i = (random.randint(low, high))
    #print("Pivot", i)
    A[high], A[i] = A[i], A[high]
    return partition(A,low,high)

def Randomized_quickSort(A, low, high):
    if low < high:
        q = Randomized_Partition(A, low, high)
        Randomized_quickSort(A, low, q-1)
        Randomized_quickSort(A, q+1, high)
        

n = sys.argv[1]
#n = int (input("Enter size of n "))    
A = []

for item in range(1,int(n)):
    A.append(item)
    
print("Unsorted", A)
Randomized_quickSort(A, 0,len(A)-1)
print("Sorted", A)
 
