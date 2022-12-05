/**SQUARE ROOT PROBLEM
 * Find the largest integer that is less than or equal to the square root of n
 * Input n = 14, output = 3, input n = 9, output = 3*/
const squareRoot = (n: number, l=1, r=n): number =>{
    if (n<=1){
        return n;
    }
    let mid: number;
    if ((r-l)%2===0){
        mid = l+(r-l)/2
    }else{
        mid = l+((r-l)+1)/2
    }

    if ((mid*mid)<=n && ((mid+1)*(mid+1))>n){
        return mid;
    }else if((mid*mid)>n){
        return squareRoot(n,l,mid-1);
    }else {
        return squareRoot(n,mid+1, r);
    }
}
console.log("Square Root Solution")
console.log(squareRoot(5))