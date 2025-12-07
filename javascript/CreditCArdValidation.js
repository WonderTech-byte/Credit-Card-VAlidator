const prompt = require("prompt-sync")();

console.log("-==| Hello, kindly Enter Card details to verify: ");

let creditDetail = Number(prompt());

let creditNumber = convertToArray(creditDetail);
let cardType = checkCreditType(creditNumber);
let length = lengthOf(creditDetail);
let validity = checkValidity(creditNumber);

if (validateLength(creditNumber)) {

    console.log("======= CREDIT CARD VALIDATOR ==========");
    console.log("----------------------------------------");
    console.log("----Credit Card Type:\t " + cardType);
    console.log("----Credit Card Number:\t " + creditDetail);
    console.log("----Credit Card Digit Length:\t " + length);
    console.log("----Credit Card validity:\t " + validity);
    console.log("=========================================");

} else {
    console.log("Invalid Card Input\nCheck and try again!!");







}

function lengthOf(number) {
    let newNumber = "" + number;
    return newNumber.length;
}

function convertToArray(number) {
    let creditNum = new Array(lengthOf(number));
    let index = lengthOf(number) - 1;

    while (number > 0) {
        let digits = number % 10;
        number = Math.floor(number / 10);
        creditNum[index--] = digits;
    }

    return creditNum;
}


function checkCreditType(numbers) {
    if (numbers[0] == 4) return "Visa Card";
    if (numbers[0] == 5) return "MasterCard";
    if (numbers[0] == 6) return "Discover Card";
    if (numbers[0] == 3 && numbers[1] == 7)
        return "American Express Cards";
    else return "Invalid Card";
}



function validateLength(numbers) {
    if (numbers.length >= 13) {
        if (numbers.length <= 16)
            return true;
    }
    return false;
}



function secondDigitDouble(numbers) {
    let length = 0;

    if (numbers.length % 2 == 0) length = numbers.length / 2;
    if (numbers.length % 2 == 1) length = (numbers.length + 1) / 2;

    let secondDigits = new Array(length);
    let count = 0;

    for (let index = 0; index < numbers.length; index += 2) {
        secondDigits[count++] = numbers[index] * 2;
    }

    return secondDigits;
}




function oddDigit(numbers) {
    let length = 0;

    if (numbers.length % 2 == 0) length = numbers.length / 2;
    if (numbers.length % 2 == 1) length = (numbers.length + 1) / 2;

    let secondDigits = new Array(length);
    let count = 0;

    for (let index = numbers.length - 1; index >= 0; index -= 2) {
        secondDigits[count++] = numbers[index];
    }

    return secondDigits;
}




function sumDoubleDigit(numbers) {
    let newArr = new Array(numbers.length);
    let sum = 0;

    for (let elements of secondDigitDouble(numbers)) {
        if (elements == 10) elements = 1;
        if (elements == 12) elements = 3;
        if (elements == 14) elements = 5;
        if (elements == 16) elements = 7;
        if (elements == 18) elements = 9;

        sum += elements;
    }
    return sum;
}


function sumOfSecondDigitDouble(numbers) {
    let sum = 0;
    for (let elements of secondDigitDouble(numbers))
        sum += elements;
    return sum;
}


function sumOfOddDigit(numbers) {
    let sum = 0;
    for (let elements of oddDigit(numbers))
        sum += elements;
    return sum;
}



function sumOfBoth(numbers) {
    let sum = sumOfOddDigit(numbers) + sumDoubleDigit(numbers);
    return sum;
}



function checkValidity(numbers) {
    if (sumOfBoth(numbers) % 10 == 0) return "valid";
    else return "Invalid";
}

