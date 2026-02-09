1# Write your MySQL query statement below
2SELECT 
3    teacher_id,
4    COUNT(DISTINCT subject_id) AS cnt
5FROM 
6    Teacher
7GROUP BY 
8    teacher_id;
9