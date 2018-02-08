for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 bubbleReverse.py $i > ./test/bubble_Reverse_$i.txt
done
