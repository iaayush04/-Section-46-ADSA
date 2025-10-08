// Given a text file file.txt, transpose its content.

// You may assume that each row has the same number of columns, and each field is separated by the ' ' character.

// Example:

// If file.txt has the following content:

// name age
// alice 21
// ryan 30

// Output the following:

// name alice ryan
// age 21 30

awk '
{
    for (i=1; i<=NF; i++) {
        a[i, NR] = $i
    }
    if (NF>p) p = NF
    r=NR
}
END {
    for (i=1; i<=p; i++) {
        for (j=1; j<=r; j++) {
            printf "%s%s", a[i,j], (j==r ? "\n" : " ")
        }
    }
}' file.txt


