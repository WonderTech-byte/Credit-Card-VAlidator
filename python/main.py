from credit_card_functions import*

credit_detail = int(input("-==| Hello, kindly Enter Card details to verify: "))
credit_number = convert_to_array(credit_detail)
card_type = check_credit_type(credit_number)
length = length_of(credit_detail)
validity = check_validity(credit_number)

if validate_length(credit_number):
    print("======= CREDIT CARD VALIDATOR ==========")
    print("----------------------------------------")
    print(f"----Credit Card Type:\t {card_type}")
    print(f"----Credit Card Number:\t {credit_detail}")
    print(f"----Credit Card Digit Length:\t {length}")
    print(f"----Credit Card validity:\t {validity}")
    print("=========================================")
else:
    print("Invalid Card Input\nCheck and try again!!")

