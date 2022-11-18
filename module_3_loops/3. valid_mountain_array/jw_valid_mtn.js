const validMountain = (arr)=>{
    if (arr.length < 3){
        return false;
    }
    let maxRight = arr[0];
    let maxLeft = arr[arr.length-1];

    let maxRightIndex = 0;
    let maxLeftIndex = arr.length-1;

    let hasMaxRight = false;
    let hasMaxLeft = false;

    /*
    -calculate the maximum from the Left to the Right side
    -save as maxRight
    - if no value is  greater than the first value hasMaxRight remains false and
    hence the array cannot be a mountain
     */
    for (let i =1; i<arr.length -1; i++){
        if (arr[i]>maxRight){
            maxRight = arr[i];
            maxRightIndex = i;
            hasMaxRight = true;
        }else if (arr[i] === maxRight){
            return false;
        }
    }
    if (!hasMaxRight) return false;

    /*
    -calculate the maximum from the Right to the Left side
    -save as maxLeft
    - if no value is  greater than the first value hasMaxLeft remains false and
    hence the array cannot be a mountain
     */
    for (let i = arr.length-2; i>=0; i--){
        if (arr[i]>maxLeft){
            maxLeft = arr[i];
            maxLeftIndex = i;
            hasMaxLeft = true;
        }else if (arr[i] === maxRight){
            return false;
        }
    }
    //If maximum value from the right = maximum value from the left and they are on the same index then the
    // array is a valid mountain
    return hasMaxLeft && maxRight === maxLeft && maxRightIndex === maxLeftIndex;
}
console.log(validMountain([1,2,9,78,92,91,72,4]))
