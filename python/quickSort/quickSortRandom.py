
#Name: Nisha Patel
#Description: Implementation of quickSort with random data
#File name: quickSortRandom.py
#Date: 11/09/17

import sys
from random import randint
sys.setrecursionlimit(11000)
n = sys.argv[1]
#n = int (input("Enter size of n "))
A = []

for item in range(0,int(n)):
    A.append(randint(1,1000))


def partition(A,low,high):
          
    x = A[high]
    i = ( low-1 ) 
    for j in range(low , high):
        if  A[j] <= x:
            i = i+1
            A[i],A[j] = A[j],A[i]
 
    A[i+1],A[high] = A[high],A[i+1]
    return (i+1)

def quickSort(A,low,high):
    if low < high:
        p = partition(A,low,high)
        quickSort(A, low, p-1)
        quickSort(A, p+1, high)


print("Unsorted", A)
quickSort(A, 0 , len(A)-1)
print("Sorted", A)
 
