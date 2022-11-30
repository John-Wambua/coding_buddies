/**Find product of array except self
 * input = [2,1,3,4] output = [12,24,8,6]
 * */

/*
* Solution 1: Brute force*/
const arrProduct1 = arr =>{
    const products = [];
    for (let i =0; i<arr.length; i++){
        let productsTotal = 1;
        for (let j=0; j<arr.length; j++){
            if (arr[i] === arr[j]){
                continue;
            }
            productsTotal*=arr[j]
        }
        products.push(productsTotal)
    }
    return products;
}

/*Solution 2:
* Product of all elements except arr[i] = product of all elements before * product of all elements after*/
const arrProduct2 = arr =>{
    const productsLeft = [];
    const productsRight = [];
    const products = [];

    productsLeft.push(1);
    for (let i =1; i<arr.length; i++){
        const product = productsLeft[i-1] * arr[i-1];
        productsLeft[i] = product;
    }
    productsRight[arr.length-1] = 1;
    for (let i = arr.length-2; i>=0; i--){
        const product = productsRight[i+1]*arr[i+1];
        productsRight[i] = product;
    }
    for (let i =0; i<arr.length; i++){
        products[i] = productsLeft[i] * productsRight[i];
    }

    return products;
}

console.log("q6 solution ---------")
console.log(arrProduct2([1,0,4,3,5]))