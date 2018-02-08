# File: Makefile
# Authors: Cody Robertson and Nisha Patel
# Purpose: Makefile for Collection
# Date: 10-29-15

#Compiler Version
CC = g++

#Target
TARGET = collection

#Compile with all errors and warnings
CFLAGS = -c -Wall

all: $(TARGET)

$(TARGET): main.o $(TARGET).o
	$(CC) main.o $(TARGET).o -o $(TARGET)

$(TARGET).o: $(TARGET).cpp $(TARGET).h
	$(CC) $(CFLAGS) $(TARGET).cpp

main.o: main.cpp $(TARGET).h
	$(CC) $(CFLAGS) main.cpp

clean: 
	rm *o $(TARGET) *~
