# Binary

int: 32 bits
long: 64 bits

## Positive number
4 bits means in terms of binary ,it can present
2^4 number of number
range from 0 - 2^4 - 1. ie 0-15


## Negative number 
4 bits can represent
2^4 number of number

there are 2^3 number of positive
there are 2^3 number of negative number

range from -2^3 - 2^3 -1 ie -8 ~ 7

For positive number

0: 0 0 0 0
1: 0 0 0 1
2: 0 0 1 0
3: 0 0 1 1
...
7: 0 1 1 1

For negative number, the left most digit is 1

to convert a value to negative, 
- its positive value
- -1
- ~

For example, -1

- positive value = 0 0 0 1
- -1 = 0 0 0 0
- ~ = 1 1 1 1

For example, -2

- positive value = 0 0 1 0
- -1 = 0 0 0 1
- ~ = 1 1 1 0

For example -7

- positive value = 0 1 1 1
- -1 = 0 1 1 0
- ~ = 1 0 0 1

For example -8

- positive value = 1 0 0 0
- -1 = 0 1 1 1
- ~ = 1 0 0 0

## Convert a binary to its negative

First, if it starts with 1, then it is a negative

- ~ 
- +1

For example, 1 1 1 1

- ~ = 0 0 0 0
- +1 = 0 0 0 1

So this is -1


For example, 1 0 0 0

- ~ = 0 1 1 1
- +1 = 1 0 0 0

So this is -8

## hex

0110 0111 8 bits

The first 4 bits can present 0 ~ 15
The last 4 bits can present 0 ~ 15

0000 -> hex 0
0001 -> hex 1
0010 -> hex 2
0011 -> hex 3
0100 -> hex 4
0101 -> hex 5
0110 -> hex 6
0111 -> hex 7
1000 -> hex 8
1001 -> hex 9
1010 -> a
1011 -> b
1100 -> c
1101 -> d
1110 -> e
1111 -> f

0b01100111 = 0x67

0b01101111 = 0x6f

## Bitwise operation

int g = 0b0001010;
int h = 0b0001100;
printBinary(g | h); // 0001110
printBinary(g & h); // 0001000
printBinary(g ^ h); // 0000110

## Shift

int i = 0b0011010;
i << 1 = 0b0110100; // all digits shift one position to right

For non-negetive number, a non-nagativ, move left means  * 2, move 2 spot 4* position