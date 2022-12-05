/***
 * Given a sorted and rotated array of size n, write a program to find the minimum element in this sorted array
 */
/*
* 1. First n-k elements are in increasing order
* 2. Last k values are in increasing order
* 3. Values from index 0 to n-k-1 will be greater than all values from (n-k) to (n-1)
* 4. Max and min values are adjacent i.e. n-k-1(max) and n-k(min)*/

/*
* - Value is greatest if it's greater than the 1st element and greater than it's next element*/

const minInSortedAndRotatedArr = (arr: Array<number>, l=0, r = arr.length-1): number=>{
    if (arr[l]<arr[r]){
        //no rotation
        return arr[l];
    }
    let mid: number;
    if ((r-l)%2===0){
        mid = l+(r-l)/2
    }else{
        mid = l+((r-l)+1)/2
    }

    if (arr[mid]>arr[l] && arr[mid]>arr[mid+1]){
        return arr[mid+1]
    }else if (arr[mid] > arr[l] && arr[mid]<arr[mid+1]){
        return minInSortedAndRotatedArr(arr, l, mid+1)
    }else {
        return minInSortedAndRotatedArr(arr, l, mid-1);
    }
}
console.log("Min in rotated and sorted arr")
console.log(minInSortedAndRotatedArr([5,6,7,8,9,1,2,3,4]))