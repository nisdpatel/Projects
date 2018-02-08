for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 bubbleRandom.py $i > ./test/bubble_Random_$i.txt
done
