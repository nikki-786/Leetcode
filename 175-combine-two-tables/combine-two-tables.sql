# Write your MySQL query statement below
Select firstName , lastName , city , state
from Person
Left Join address
On Person.personId = Address.personId;
