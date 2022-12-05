/**Search in a sorted 2D Matrix
 * You are given a row-wise sorted 2D matrix and an integer k, write a program to find whether the
 * integer k is present in the matrix or not*/

/*
* 1. Apply binary search on rows to find out the row in which k must lie
* - first el is greater than/ equal to k and last el is less than/equal to k.
* 2. Apply binary search in that row to find out if k is present or not */
const searchIn2DMatrix = (
    mat: Array<Array<number>>, k: number, m: number, n: number, l = 0, r = m-1
): boolean =>{
    if (l > r) return false;

    let mid: number;
    if ((r-l)%2===0){
        mid = l+(r-l)/2
    }else{
        mid = l+((r-l)+1)/2
    }
    // mat[1][0], min[1][3]
    if (k >= mat[mid][0] && k<=mat[mid][n-1]){
        //search for value in row
        return searchRow(mat[mid], k)
    }
    if (k<mat[mid][0]){
        return searchIn2DMatrix(mat, k, m, n,l,mid-1)
    }
    if (k>mat[mid][n-1]){
        return searchIn2DMatrix(mat, k, m, n, mid+1, r)
    }
}
const searchRow = (arr: Array<number>, key: number, left = 0, right=arr.length-1): boolean=>{
    if (left > right) {
        return false
    }
    let mid: number;
    if ((right-left)%2===0){
        mid = left+(right-left)/2
    }else{
        mid = left+((right-left)+1)/2
    }
    if (key === arr[mid]) return true;
    if (key<arr[mid]){
        return searchRow(arr, key, left, mid-1);
    }else {
        return searchRow(arr, key, mid+1, right);
    }
}
console.log("Sorted 2D matrix sln")
console.log(searchIn2DMatrix([
    [1,2,6,7], [12,13,16,21], [23,35,36,48]
], 40, 3,4))