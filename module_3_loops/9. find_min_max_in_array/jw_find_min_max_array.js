/**Find Maximum and Minimum elements present using minimum number of comparisons
 * input [4,2,0,8,20,9,2] output: max = 20, min = 0
 * input [-8,-3,-10,-32,-1] output: max = -1, min = -32
 */

/*Solution 1: Brute force*/
const maxAndMin = arr => {
    let min = arr[0];
    let max = arr[0];

    for (let i =1; i<arr.length; i++){
        if (arr[i] > max){
            max = arr[i];
        }else if (arr[i] < min){
            min = arr[i];
        }
    }
    return [max, min];
}
/*solution 2: Incrementing by 2
*Pick elements in pairs and try to update the minimum
* If array is even we initialise first element as both max and min
* If array is odd, we compare the first 2 elements and initialise min and max accordingly
* */
const maxAndMin2 = arr =>{
    const n = arr.length;
    let min;
    let max;
    let init;
    if (n%2===0){
        //array is even; compare first 2 elements
        if (arr[0]<arr[1]){
            min = arr[0];
            max = arr[1];
        }else {
            min = arr[1];
            max = arr[0];
        }
        init = 2;
    }else {
        min = arr[0];
        max = arr[0];
        init = 1;
    }

    for (let i = init; i < n; i=i+2){
        if (arr[i] < arr[i+1]){
            if (arr[i]<min){
                min = arr[i]
            }
            if (arr[i+1] >max){
                max = arr[i+1]
            }
        }else {
            if (arr[i+1] < min){
                min = arr[i+1];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
    }
    return [max, min]
}
console.log("q9 solution ---------")
console.log(maxAndMin([4,2,0,8,20,9,2]))
console.log(maxAndMin2([4,2,0,8,20,9,2]))