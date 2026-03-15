// Write an API that generates fancy sequences using the append, addAll, and multAll operations.

// Implement the Fancy class:

//     Fancy() Initializes the object with an empty sequence.
//     void append(val) Appends an integer val to the end of the sequence.
//     void addAll(inc) Increments all existing values in the sequence by an integer inc.
//     void multAll(m) Multiplies all existing values in the sequence by an integer m.
//     int getIndex(idx) Gets the current value at index idx (0-indexed) of the sequence modulo 109 + 7. If the index is greater or equal than the length of the sequence, return -1.

 

// Example 1:

// Input
// ["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
// [[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
// Output
// [null, null, null, null, null, 10, null, null, null, 26, 34, 20]


import java.util.*;

class Fancy {

    private static final int MOD = 1000000007;
    private List<Long> list;
    private long mul;
    private long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long x = (val - add + MOD) % MOD;
        x = (x * modPow(mul, MOD - 2)) % MOD;
        list.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        long val = list.get(idx);
        return (int)((val * mul + add) % MOD);
    }

    private long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}
