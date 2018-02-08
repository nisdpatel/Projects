#Name: Nisha Patel
#Description: Implementation of quickSort with ordered data
#File name: quickSortOrdered.py
#Date: 11/09/17

import sys
sys.setrecursionlimit(11000)
n = sys.argv[1]
#n = int (input("Enter size of n "))
A = []
for item in range(1,int(n)):
#for item in range(int(n) ,0, -1):
    A.append(item)



def partition(A,low,high):
          
    x = A[high]
    #print("pivot",x)
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
 
