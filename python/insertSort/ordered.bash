for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 insertOrdered.py $i > ./test/insertion_Ordered_$i.txt
done
