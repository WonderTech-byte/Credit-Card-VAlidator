class CreditCardValidator{
    
    public int lengthOf(long number){
        String newNumber = "" + number;
        return newNumber.length(); 
    } 

    public long[] convertToArray(long number){
        long[] creditNum = new long[lengthOf(number)];
        int index = lengthOf(number)-1;
        while(number > 0){
             long digits = number % 10;
             number = number / 10;
             creditNum[index--] = digits;
        }
        return creditNum;
    }

    public String checkCreditType(long[] numbers){
        if (numbers[0] == 4) return "Visa Card";
        if (numbers[0] == 5) return "MasterCard";    
        if (numbers[0] == 6) return "Discover Card";
        if (numbers[0]== 3 && numbers[1]== 7)
             return "American Express Cards";
        else return "Invalid Card";
    }

    public boolean validateLength(long[] numbers){
        if ( numbers.length >= 13){
            if(numbers.length <= 16)
             return true;
        } 
            return false;
    }


    public long[] secondDigitDouble(long[] numbers){
        int length = 0;
     if(numbers.length % 2 == 0)length = numbers.length / 2;
     if(numbers.length % 2 == 1) length = (numbers.length +1)/2;
        long[] secondDigits = new long[length];
            int count = 0;
            int counter = numbers.length /2;
        for(int index= 0; index < numbers.length; index+=2){
              secondDigits[count++] = numbers[index] * 2;
         }

        return secondDigits;
    }

    public long[] oddDigit(long[] numbers){
        int length = 0;
     if(numbers.length % 2 == 0)length = numbers.length / 2;
     if(numbers.length % 2 == 1) length = (numbers.length +1)/2;
        long[] secondDigits = new long[length];
            int count = 0;
            int counter = numbers.length /2;
        for(int index= numbers.length-1; index >= 0; index-=2){
              secondDigits[count++] = numbers[index];
         }

        return secondDigits;
    }

    public long sumDoubleDigit(long[] numbers){
            long[] newArr = new long[numbers.length];
            long sum = 0;

        for(long elements: secondDigitDouble(numbers)){
            if(elements == 10) elements = 1;
            if(elements == 12) elements = 3;
            if(elements == 14) elements = 5;
            if(elements == 16) elements = 7;
            if(elements == 18) elements = 9;
            
            sum += elements;
        } return sum;
    }


    public long sumOfSecondDigitDouble(long[] numbers){
         long sum = 0;
        for(long elements: secondDigitDouble(numbers))
            sum+= elements;
        return sum;
    }


    public long sumOfOddDigit(long[] numbers){
         long sum = 0;
        for(long elements: oddDigit(numbers))
            sum+= elements;
        return sum;
    }


    public long sumOfBoth(long[] numbers){
        long sum = sumOfOddDigit(numbers) + sumDoubleDigit(numbers);
        return sum;
    }

    
    public String checkValidity(long[] numbers){
        if(sumOfBoth(numbers)% 10 == 0)return "valid";
        else return "Invalid";
    }
    
//
//    
//
//
//




















}
