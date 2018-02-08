for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 insertReverse.py $i > ./test/insertion_Reverse_$i.txt
done
