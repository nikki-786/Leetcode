# Write your MySQL query statement below
SELECT
    name AS Customers
FROM Customers
LEFT Join Orders
ON Customers.id = Orders.customerId
Where Orders.id IS NUll;