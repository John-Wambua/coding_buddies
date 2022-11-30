/**Given array x[] of size n, write a program to find all the leaders in the array x[]. An element is a leader if it's
 * strictly greater than all the elements to its right side.
 * input x[] = [16, 17, 4, 3, 5, 2], output [17, 5, 2]*/
/*
 *1. Assume last element is the greatest el hence a leader
 * 2. Loop from last element to the first, check if prev element is greater than the greatest el and
 * if so set the prev element as a leader
 */

const leaders = (arr) =>{
    let greatestElement = arr[arr.length - 1];
    const leaders = [];
    leaders.push(greatestElement);

    for (let i = arr.length-1; i>=0; i--){
        if (arr[i] > greatestElement){
            greatestElement = arr[i];
            leaders.push(greatestElement);
        }
    }

    return leaders;
}

console.log(leaders([16, 17, 4, 3, 5, 2]))