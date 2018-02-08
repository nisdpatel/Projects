#Name: Nisha Patel
#File : insertOrdered.py
# Description : implementation of Cormen Insertion Sort Algorithm for ordered n numbers

import sys
n = sys.argv[1]
A = []
for item in range(1,int(n)):
    A.append(item)
print("Unsorted",A)

for j in range (1, (len(A))):
    key = A[j]
    i = j -1
    while i >=0 and A[i] > key : # ascending order
    #while i >=0 and A[i] < key: # decending order
        A[i+1] = A[i]
        i = i -1
    A[i+1]= key
print("\n Sorted",A)
