/**GCD of 2 non-negative integers
 * input m = 40 n = 32, output: 8
 * input m = 60, n = 40, output: 20*/
/*
* GCD(m,n) = GCD(m-n, n)*/
const gcd = (m: number, n: number):number =>{
    if (m===0 && n===0) return undefined;
    if (m===0){
        return n;
    }
    if (n===0){
        return m;
    }
    if (m===n) return m;
    if (m>n){
        return gcd(m-n,n);
    }else {
        return gcd(n-m, m);
    }
}
/*If smaller number divides larger number gcd is smaller number
* GCD(m,n) if m>n = GCD(n, m%n) =>if pair is (x, 0) then x is GCD */

const gcd2 = (m: number,n: number): number => {
    if (n>m) return gcd2(n,m);
    if (m===0 && n===0)
        return undefined;
    if (m===0)
        return n;
    if (n===0)
        return m;

    return gcd2(n, m%n);
}
console.log("GCD sln:")
console.log(gcd2(40,32));