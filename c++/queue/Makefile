#File: Makefile
#Authors: Cody Robertson and Nisha Patel
#Purpose: Makefile for queue
#Date: 11-30-15

#Compiler Version
CC = g++

#Target
TARGET = queue

#Driver
DRIVER = main

#Compile with all errors and warnings
CFLAGS = -c -Wall


all: $(TARGET)

$(TARGET): $(DRIVER).o queue.o priority_queue.o
	$(CC) $(DRIVER).o queue.o priority_queue.o -o $(TARGET)

queue.o: queue.cpp queue.h
	$(CC) $(CFLAGS) queue.cpp

priority_queue.o: priority_queue.cpp priority_queue.h 
	$(CC) $(CFLAGS) priority_queue.cpp

$(DRIVER).o: $(DRIVER).cpp queue.h priority_queue.h
	$(CC) $(CFLAGS) $(DRIVER).cpp

clean:
	rm *.o $(TARGET) *~
