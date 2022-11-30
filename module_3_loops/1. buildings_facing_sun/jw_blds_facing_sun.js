/**1. Input array height [] representing heights of buildings, calc number of buildings facing the sunset
 * assuming the heights are distinct
 * e.g input [] = [7, 4, 8, 5, 8, 2, 9] output = 3
 * */
const numBuildings = (arr) =>{
    let count = 1;
    let max = arr[0];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] > max){
            max = arr[i];
            count++;
        }
    }
    return count;
}
console.log(numBuildings([7, 4, 8, 5, 8, 2, 9]))
