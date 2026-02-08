1# Write your MySQL query statement below
2SELECT user_id, email
3FROM Users
4WHERE email REGEXP '^[A-Za-z0-9_]+@[A-Za-z]+\\.com$'
5ORDER BY user_id ASC;
6