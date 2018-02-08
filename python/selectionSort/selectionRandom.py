#Name: Nisha Patel
#File : selectionRandom.py
# Description : implementation of Cormen Selection Sort Algorithm for random n numbers

import sys
from random import randint
n =sys.argv[1]
A = []
for item in range(0,int(n)):
    A.append(randint(1,1000))
print("Unsorted",A)
for i in range(0,len(A)-1):
    min = i
    for j in range(i+1,len(A)):
        if A[j] < A[min]:
            min = j
    A[min],A[i] = A[i],A[min]

print("\n Sorted",A)
