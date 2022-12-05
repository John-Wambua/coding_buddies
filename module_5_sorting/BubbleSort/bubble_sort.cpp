#include <iostream>

/**
 * Idea is to have the element with the maximum value at the (n-1)th position
 */
int bubble_sort(int x[], int n)
{
    // naive approach - two nested loops O(n**2) -> both best and worst cases!
    /**
     *
     * loop I:
     *  loop J = n - I - 1:
     *      if (X[J] > X[J+1]):
     *          temp = A[J]
     *          x[J] = x[J+1]
     *          x[J+1] = temp
     */
    bool elementSwapped;

    for (int i = 0; i < n; i = i + 1)
    {
        elementSwapped = false;
        for (int j = 0; j < n - i - 1; j++)
        {
            if (x[j] > x[j + 1])
            {
                int temp = A[j];
                x[j] = x[j + 1];
                x[j + 1] = true;
                elementSwapped = true;
            }
        }

        if (elementSwapped == false)
            break;
    }
}

/**
 * traverse whole arrayto find smallest element
*/
int selection_sort(int x[])
{
    //use the naive approach in Bubble sort ...inverse-> O(n^2) bith best case and worst case -> the search will still take place
}

/**
 * here, we insert an element according to its value, if x > j, then x will move ahead of j positionwise
*/
int insertion_sort(int x[])
{
    
}

int main(void)
{
    return (0);
}