/**
 * if n is odd, then the median is the middle element
 * if n is even, then the median is the avaerage of the two middle elemenyts
 *
 * approach:
 * merge the two arrays
 * sort the arrays
 *
 * get the size
 *  if the size % 2 == 0
 *      then median = avg(x,y)
 *  else
 *      median = size/2
 */

// brute force approach
/**
double median(int A[], int B[], int n)
{
    int size = 2 * n;
    int mergedArray[2 * n];

    int i, j, k = 0;
    while (i < n && j < n)
    {
        if (A[i] <= B[j])
        {
            mergedArray[k] = A[i];
            i += 1;
            j += 1;
        }
        else
        {
            mergedArray[k] = B[j];
        }
    }
    // A[i] will always start as the first element
    while (i < n)
    {
        mergedArray[k] = A[i];
        i += 1;
        k += 1;
    }
    while (j < n)
    {
        mergedArray[k] = B[j];
        j +=1;
        k +=1;
    }

    return (mergedArray[n -1] + mergedArray[n])/2;
}
*/
int main(void)
{
}
