/**Move zeroes to end of array*/
/*
*Given an array x[] on integers, where some elements are zero and some elements are non-zero. Write a program to move all
* the zeroes to the end of the array
* input = [4,8,6,0,2,0,1,15,12,0] output = [4,8,6,2,1,15,12,0,0,0]
* */

// Sln 1. Bruteforce
const moveZeroesToEnd = (arr: Array<number>)=>{
    const newArr: Array<number> = [];
    let j=0
    for (let i=0; i<arr.length;i++){
        if (arr[i]!==0){
            newArr.push(arr[i]);
            j++;
        }
    }
    while (j<arr.length){
        newArr[j]=0
        j++;
    }
    return newArr;
}
console.log("Two pointer sln - Bruteforce:")
console.log(moveZeroesToEnd([4,8,6,0,2,0,1,15,12,0]))

// Sln 2. Two pointer - Two loops
const moveZeroesToEnd1 = (arr: Array<number>) =>{
    let j= 0;
    for (let i=0; i<arr.length; i++){
        if (arr[i]!==0){
            arr[j]=arr[i];
            j++;
        }
    }
    while (j<arr.length){
        arr[j]=0
        j++;
    }
    return arr;
}
console.log("Two pointer sln 1 - Two loops:")
console.log(moveZeroesToEnd1([4,8,6,0,2,0,1,15,12,0]))

// Sln 3. Two pointer - single loop
const moveZeroesToEnd2 = (arr: Array<number>) => {
    let j = 0;
    for (let i=0; i<arr.length; i++){
        if (arr[i]!==0){
            //swap arr[i] and arr[j]
            const temp = arr[i];
            arr[i] = arr[j]
            arr[j] = temp;
            j++;
        }
    }
    return arr;
}
console.log("Two pointer sln 2 - Single loop:")
console.log(moveZeroesToEnd2([4,8,6,0,2,0,1,15,12,0]))
