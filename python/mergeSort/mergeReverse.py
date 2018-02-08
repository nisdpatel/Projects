#Name: Nisha Patel
#File : mergeReverse.py
# Description : implementation of Cormen MergeSort Algorithm for reverse n numbers

#import numpy as np
from random import randint
import sys

# I was using INF, but numpy is not installed on cs1, so to be safe I thought to create a constant instead
MAX = 999999999

#merge fuction will merge divide A into 2 subarrays and sort them. 
def MERGE(A,pStart,qMid,rEnd):
   
    Left = A[pStart:qMid]
    #print("Testing Left",Left)
    #Left.append(np.inf)
    Left.append(MAX)

    Right = A[qMid:rEnd]
    #print("Testing Right", Right)
    #Right.append(np.inf)
    Right.append(MAX)
    i = 0
    j = 0
    for k in range(pStart,rEnd):
        if (j >= len(Right) or (i < len(Left) and Left[i] < Right[j])) :
            A[k] = Left[i]
            i = i + 1
        else:
            A[k] = Right[j]
            j = j + 1  
    
  #mergeSort will call merge to merge the sorted array      
def mergeSort(A,p,r):
    if r - p > 1:
        mid = int((p+r)/2)
        mergeSort(A,p,mid)
        mergeSort(A,mid,r)
        MERGE(A,p,mid,r)

#n = int (input("Enter size of n "))
n = sys.argv[1]
A = []
for item in range(int(n) ,0, -1):
    A.append(item)
print("Unsorted",A)
mergeSort(A, 0, len(A))
print("Sorted : ",A)




