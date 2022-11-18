/**Write a program to find the equilibrium index of an array
 * Sum of elements at lower indexes is equal to sum of elements at higher indexes*/
const equilibriumIndex =  (arr) =>{
    /* Calculate sum of the entire array
    * Start from the last element to the first,
    * Sum left is sum of elements to the left of element i,
    * Sum right is the sum of elements to the right if i
    * If sumLeft = sumRight return the index i
    *  */
    const n = arr.length;
    let sumArray = 0;
    for (let i = 0; i<=n -1; i++){
        sumArray+=arr[i];
    }
    let sumLeft = sumArray-arr[n-1];
    let sumRight = 0;
    for (let i = n-2; i>=0; i--){
        sumLeft-= arr[i];
        sumRight+=arr[i+1];
        if (sumLeft === sumRight){
            return i;
        }
    }
    return -1;
}

console.log(equilibriumIndex([-7, 1, 5, 2, -4, 3, 0]))