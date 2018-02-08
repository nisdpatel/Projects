#Name: Nisha Patel
#File : insertRandom.py
# Description : implementation of Cormen Insertion Sort Algorithm for random n numbers

import sys
from random import randint
n =sys.argv[1]
A = []
for item in range(0,int(n)):
    A.append(randint(1,1000))
print("Unsorted",A)

for j in range (2, len(A)):
    key = A[j]
    i = j -1
    while i >=0 and A[i] > key : # ascending order
    #while i >=0 and A[i] < key: # decending order
        A[i+1] = A[i]
        i = i -1
    A[i+1]= key
print("\n Sorted",A)
