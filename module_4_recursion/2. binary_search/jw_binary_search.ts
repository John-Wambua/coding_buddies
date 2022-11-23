/**Binary Search
 * Given sorted array X[] of n elements, search a given element key in X[]. If key exists return its index,
 * otherwise return -1*/

const binarySearch = ( arr: Array<number>, key: number, l=0, r=arr.length-1): number=>{
    if (l>r){
        return -1;
    }
    let mid: number;
    if ((r-l)%2===0){
        mid = l+(r-l)/2
    }else{
        mid = l+((r-l)+1)/2
    }
    if (arr[mid]===key) return mid;
    if (key<arr[mid]){
        return binarySearch(arr, key, l,mid-1);
    }else {
        return binarySearch(arr, key, mid+1, r);
    }
}
console.log("Binary Search sln")
console.log(binarySearch([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,], 10))
