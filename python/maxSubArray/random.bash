for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 maxSubArray.py $i > ./test/max_SubArray_$i.txt
done
