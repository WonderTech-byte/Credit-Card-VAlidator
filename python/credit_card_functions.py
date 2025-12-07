def length_of(number):
    new_number = str(number)
    return len(new_number)

def convert_to_array(number):
    credit_num = [0] * length_of(number)
    index = length_of(number) - 1
    while number > 0:
        digits = number % 10
        number = number // 10
        credit_num[index] = digits
        index -= 1
    return credit_num

def check_credit_type(numbers):
    if numbers[0] == 4:
        return "Visa Card"
    if numbers[0] == 5:
        return "MasterCard"
    if numbers[0] == 6:
        return "Discover Card"
    if numbers[0] == 3 and numbers[1] == 7:
        return "American Express Cards"
    return "Invalid Card"

def validate_length(numbers):
    if len(numbers) >= 13 and len(numbers) <= 16:
        return True
    return False

def second_digit_double(numbers):
    length = (len(numbers) + 1) // 2 if len(numbers) % 2 == 1 else len(numbers) // 2
    second_digits = [0] * length
    count = 0
    for index in range(0, len(numbers), 2):
        second_digits[count] = numbers[index] * 2
        count += 1
    return second_digits

def odd_digit(numbers):
    length = (len(numbers) + 1) // 2 if len(numbers) % 2 == 1 else len(numbers) // 2
    second_digits = [0] * length
    count = 0
    for index in range(len(numbers) - 1, -1, -2):
        second_digits[count] = numbers[index]
        count += 1
    return second_digits

def sum_double_digit(numbers):
    sum_ = 0
    for elements in second_digit_double(numbers):
        if elements == 10: elements = 1
        elif elements == 12: elements = 3
        elif elements == 14: elements = 5
        elif elements == 16: elements = 7
        elif elements == 18: elements = 9
        sum_ += elements
    return sum_

def sum_of_second_digit_double(numbers):
    sum_ = 0
    for elements in second_digit_double(numbers):
        sum_ += elements
    return sum_

def sum_of_odd_digit(numbers):
    sum_ = 0
    for elements in odd_digit(numbers):
        sum_ += elements
    return sum_

def sum_of_both(numbers):
    return sum_of_odd_digit(numbers) + sum_double_digit(numbers)

def check_validity(numbers):
    if sum_of_both(numbers) % 10 == 0:
        return "valid"
    return "Invalid"
