for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 mergeRandom.py $i > ./test/merge_Random_$i.txt
done
