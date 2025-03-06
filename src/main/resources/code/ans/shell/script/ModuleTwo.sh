#!/bin/bash

# Function to find the k-th largest element in an array
find_kth_largest() {
    input_array=($1)
    k=$2

    # Sort the array in descending order
    sorted_array=($(for num in "${input_array[@]}"; do echo $num; done | sort -nr))

    # Output the k-th largest element
    echo ${sorted_array[$((k-1))]}
}

# Test the function
find_kth_largest "3 2 1 5 6 4" 2  # Output: 5
find_kth_largest "3 2 3 1 2 4 5 5 6" 4  # Output: 4
