#!/bin/bash

# Function to find the first unique character index
find_unique_char_index() {
    input_string=$1
    length=${#input_string}

    # Iterate through each character in the string
    for ((i=0; i<$length; i++)); do
        char=${input_string:i:1}
        count=0
        
        # Count occurrences of the current character in the string
        for ((j=0; j<$length; j++)); do
            if [[ "${input_string:j:1}" == "$char" ]]; then
                ((count++))
            fi
        done

        # If character appears only once, return its index
        if [[ $count -eq 1 ]]; then
            echo $i
            return
        fi
    done

    # If no unique character, return -1
    echo -1
}

# Test the function
find_unique_char_index "leetcode"  # Output: 0
find_unique_char_index "loveleetcode"  # Output: 2
find_unique_char_index "aabb"  # Output: -1