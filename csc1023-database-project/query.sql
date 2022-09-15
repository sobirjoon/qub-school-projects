
#1 a)

SELECT AVG(Amount)
AS 'Average'
FROM
	activity
INNER JOIN
	budget
USING(BuID)
WHERE Title='Coding Competition' OR Title='Welcome Party';

#2 b)
SELECT
    StaffID,
    FirstName,
    campus.Address,
    LeftD
FROM
    staff
INNER JOIN campus USING(CaID)
WHERE
    LeftD LIKE '2019%';


#3 c)
INSERT INTO Campus(
    Address,
    GmName,
    Country,
STATUS
)
VALUES(
    '122, Pineapple Avenue, New York',
    'Michael Carlos',
    'USA',
    'Open Soon'
);


#4 d)
SELECT
    Title,
    FirstName,
    LastName,
    department.DeptName
FROM
    staff
INNER JOIN department USING(DeptID)
WHERE
    DeptID = 10;
	

#5 e) 
SELECT
    *
FROM
    staff
ORDER BY
    FirstName ASC
LIMIT 0, 10;


#6 f)
SELECT 
	COUNT(AcID),
    FirstName,
    LastName,
	activity.Title
FROM
    allocation
INNER JOIN staff USING(StaffID)
INNER JOIN activity USING(AcID)
GROUP BY 
	staffID
ORDER BY 
	AcID;




#7 g)
SELECT 
    StudentName,
    Address,
    Score
FROM
    enrolment
INNER JOIN student USING(studentID)
WHERE
    ModuleID = 2
ORDER BY Score DESC;


#8 h)
SELECT SUM(Amount)
AS 'Lisa’s Spend'
FROM budget
WHERE Approver='Lisa Amy';


#9 i)
SELECT * FROM staff
INNER JOIN campus
USING(CaID)
WHERE LastName LIKE 'C%' AND CaID=1;



#10 j)
SELECT DISTINCT
    student.StudentName,
    Semester,
    ModuleName,
    Score
FROM
    enrolment
INNER JOIN student USING(StudentID)
INNER JOIN module USING(ModuleID)
WHERE
    YEAR = 2020
ORDER BY
    Score
DESC
LIMIT 1, 1;