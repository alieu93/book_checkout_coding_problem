# Book Checkout Coding Problem
Java solution for a coding problem for the purchase and checkout of a bookshop

# Assumptions:

- I am assuming that the class (CheckoutService) takes in a list of books
- The discount prices are stored elsewhere (Database, external services, etc) as to replicate this type of architecture. As a result, I have created DiscountService for this purpose. This allows it to be extendable for future types of discounts to be added to the code rather than hardcoding the values.
- In a realistic scenario, DiscountService would also handle the calculation but for the purpose of this exercise, I have opted to have the calculations be part of CheckoutService. This of course has redundancies in the classes involved.
- The result will only be the total amount calculated from both discounts and nothing else.
- Date of publication will always be known.
