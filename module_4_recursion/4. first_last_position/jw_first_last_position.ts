/**Find 1st and last position element in sorted array
 * Input A[]=[-1,1,2,2,2,5,612,12] target = 2 output = [2,4]
 * Input A[] = [21,32,51,70,71] target = 70 output = [3,3]*/
const firstAndLastInArr = (arr: Array<number>, target: number, l =0, r = arr.length-1) =>{
    if (l > r){
        return [-1,-1];
    }
    let mid: number;
    if ((r-l)%2===0){
        mid = l+(r-l)/2
    }else{
        mid = l+((r-l)+1)/2
    }
    if (arr[l] === arr[r] && arr[l] === target){
        return [l,r];
    }
    if (target > arr[mid]){
        return firstAndLastInArr(arr, target, mid+1, r);
    }
    if (target < arr[mid]){
        return firstAndLastInArr(arr, target, l, mid-1)
    }
    if (target === arr[mid] && target < arr[mid+1]){
        return firstAndLastInArr(arr, target, l, mid)
    }
    if (target === arr[mid] && target > arr[mid-1]){
        return firstAndLastInArr(arr, target, mid, r)
    }
}
console.log("First and Last sln")
console.log(firstAndLastInArr( [-1,1,2,2,2,5,612,12], 2))