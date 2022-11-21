/***
 * Spiral traversal of a matrix, Given a 2D matrix, print all the elements in a spiral order.
 * Input [[1,2,3,4], [5,6,7,8], [9,10,11,12], [13,14,15,16]] output = 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */
/*
* Divide tha matrix into segments, each segment has 4 boundaries => rowStart, colStart, rowEnd, colEnd
* initial values =>rowStart=0, colStart=0, rowEnd=m-1, colEnd=n-1
* Next iteration rowStart +=1, colStart +=1, colEnd -=1, rowEnd -=1
* */
const spiralTraversal = (arr, m, n)=>{
    let rowStart = 0;
    let colStart = 0;
    let rowEnd = m-1;
    let colEnd = n-1;

    while (rowStart<rowEnd && colStart<colEnd){
        for (let i = colStart; i <= colEnd; i++){
            console.log(arr[rowStart][i]);
        }
        rowStart++;
        for (let i = rowStart; i<= rowEnd; i++){
            console.log(arr[i][colEnd]);
        }
        colEnd--;
        if (rowStart < rowEnd){
            for (let i = colEnd; i>=colStart; i--){
                console.log(arr[rowEnd][i])
            }
            rowEnd--;
        }
        if (colStart < colEnd){
            for (let i = rowEnd; i>=rowStart; i--){
                console.log(arr[i][colStart])
            }
            colStart++;
        }
    }
}
spiralTraversal([[1,2,3,4,5,6,7,8], [9,10,11,12,13,14,15,16], [17,18,19,20,21,22,23,24],
    [25,26,27,28,29,30,31,32],[33,34,35,36,37,38,39,40]], 5,8)