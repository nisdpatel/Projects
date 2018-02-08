#Name: Nisha Patel
#File : bubbleRandom.py
# Description : implementation of Cormen Bubble Sort Algorithm for random n numbers



import sys
from random import randint
n =sys.argv[1]
A = []
for item in range(0,int(n)):
    A.append(randint(1,1000))
print("Unsorted",A)

for i in range(0, len(A)):
    for j in range(len(A)-1, i, -1):
        if A[j] < A[j-1]:
            A[j],A[j-1] = A[j-1],A[j]

print("\n Sorted",A)
