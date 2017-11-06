#!/bin/bash
cd tests/output/expected
for i in *.txt
do
	echo "checking outputs of test $i"
	diff ../produced/$i $i
	#diff ../output/produced/$i.log ../output/expected/$i.log
done