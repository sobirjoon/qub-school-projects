-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 28, 2022 at 06:54 PM
-- Server version: 8.0.28
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `into_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `AcID` bigint NOT NULL,
  `Title` varchar(255) NOT NULL,
  `CaID` int DEFAULT NULL,
  `BuID` bigint DEFAULT NULL,
  `Status` varchar(255) NOT NULL,
  `Started` date NOT NULL,
  `Ended` date DEFAULT NULL,
  `Internal` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `allocation`
--

CREATE TABLE `allocation` (
  `StaffID` bigint NOT NULL,
  `AcID` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE `budget` (
  `BuID` bigint NOT NULL,
  `Amount` bigint DEFAULT NULL,
  `Approver` varchar(255) DEFAULT NULL,
  `Payee` varchar(255) DEFAULT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `campus`
--

CREATE TABLE `campus` (
  `CaID` int NOT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `GmName` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `classroom`
--

CREATE TABLE `classroom` (
  `RmID` bigint NOT NULL,
  `Capacity` bigint DEFAULT NULL,
  `CaID` int DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Type` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DeptID` bigint NOT NULL,
  `DeptName` varchar(255) NOT NULL,
  `Faculty` varchar(255) NOT NULL,
  `HODName` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `enrolment`
--

CREATE TABLE `enrolment` (
  `EID` bigint NOT NULL,
  `StudentID` bigint NOT NULL,
  `ModuleID` bigint NOT NULL,
  `Score` int NOT NULL DEFAULT '1',
  `Semester` varchar(255) NOT NULL,
  `Year` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `ModuleID` bigint NOT NULL,
  `ModuleName` varchar(255) NOT NULL,
  `DeptID` bigint NOT NULL,
  `Programme` varchar(255) DEFAULT NULL,
  `Tmode` varchar(255) DEFAULT NULL,
  `Date_of_Firstoffer` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `spaceassign`
--

CREATE TABLE `spaceassign` (
  `SpaID` bigint NOT NULL,
  `RmID` bigint NOT NULL,
  `TID` bigint NOT NULL,
  `Manager` varchar(255) NOT NULL,
  `Approved` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` bigint NOT NULL,
  `Title` varchar(32) DEFAULT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `DeptID` bigint NOT NULL,
  `CaID` int NOT NULL,
  `Joined` date DEFAULT NULL,
  `LeftD` date DEFAULT NULL,
  `Current` tinyint(1) NOT NULL DEFAULT '1',
  `Salary` bigint NOT NULL,
  `ContractType` varchar(32) NOT NULL,
  `SupervisorID` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` bigint NOT NULL,
  `StudentName` varchar(255) NOT NULL,
  `DoB` date NOT NULL,
  `Address` varchar(255) NOT NULL,
  `StudyType` varchar(255) NOT NULL,
  `Date_of_Start` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `teach`
--

CREATE TABLE `teach` (
  `TID` bigint NOT NULL,
  `ModuleID` bigint NOT NULL,
  `StaffID` bigint NOT NULL,
  `SpaID` bigint NOT NULL,
  `Semester` varchar(255) NOT NULL,
  `Year` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`AcID`),
  ADD UNIQUE KEY `AcID_2` (`AcID`),
  ADD KEY `AcID` (`AcID`,`Title`),
  ADD KEY `FK_CaID2` (`CaID`),
  ADD KEY `FK_BuID` (`BuID`);

--
-- Indexes for table `allocation`
--
ALTER TABLE `allocation`
  ADD UNIQUE KEY `StaffID_2` (`StaffID`,`AcID`),
  ADD KEY `StaffID` (`StaffID`,`AcID`),
  ADD KEY `FK_AcID` (`AcID`);

--
-- Indexes for table `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`BuID`),
  ADD UNIQUE KEY `BuID_2` (`BuID`),
  ADD KEY `BuID` (`BuID`);

--
-- Indexes for table `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`CaID`),
  ADD UNIQUE KEY `CaID_2` (`CaID`),
  ADD KEY `CaID` (`CaID`);

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`RmID`),
  ADD UNIQUE KEY `RmID_2` (`RmID`),
  ADD KEY `RmID` (`RmID`),
  ADD KEY `FK_CaID1` (`CaID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DeptID`),
  ADD UNIQUE KEY `DeptID_2` (`DeptID`,`HODName`,`Address`),
  ADD KEY `DeptID` (`DeptID`);

--
-- Indexes for table `enrolment`
--
ALTER TABLE `enrolment`
  ADD PRIMARY KEY (`EID`),
  ADD UNIQUE KEY `EID_2` (`EID`),
  ADD KEY `EID` (`EID`,`StudentID`,`ModuleID`,`Semester`,`Year`),
  ADD KEY `FK_StudentID` (`StudentID`),
  ADD KEY `FK_ModuleID` (`ModuleID`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`ModuleID`),
  ADD UNIQUE KEY `ModuleID_2` (`ModuleID`),
  ADD KEY `ModuleID` (`ModuleID`,`ModuleName`,`DeptID`),
  ADD KEY `FK_DeptID1` (`DeptID`);

--
-- Indexes for table `spaceassign`
--
ALTER TABLE `spaceassign`
  ADD PRIMARY KEY (`SpaID`),
  ADD UNIQUE KEY `SpaID` (`SpaID`),
  ADD KEY `RmID` (`RmID`,`TID`),
  ADD KEY `FK_TID` (`TID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`),
  ADD UNIQUE KEY `StaffID_2` (`StaffID`),
  ADD KEY `StaffID` (`StaffID`,`FirstName`,`LastName`,`DeptID`,`Current`,`SupervisorID`),
  ADD KEY `FK_DeptID` (`DeptID`),
  ADD KEY `FK_CaID` (`CaID`),
  ADD KEY `FK_SupervisorID` (`SupervisorID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD UNIQUE KEY `StudentID_2` (`StudentID`),
  ADD KEY `StudentID` (`StudentID`);

--
-- Indexes for table `teach`
--
ALTER TABLE `teach`
  ADD PRIMARY KEY (`TID`),
  ADD UNIQUE KEY `TID_2` (`TID`),
  ADD KEY `TID` (`TID`,`ModuleID`,`StaffID`,`Semester`,`Year`),
  ADD KEY `FK_ModuleID1` (`ModuleID`),
  ADD KEY `FK_StaffID` (`StaffID`),
  ADD KEY `FK_SpaID` (`SpaID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `AcID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `allocation`
--
ALTER TABLE `allocation`
  MODIFY `StaffID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `budget`
--
ALTER TABLE `budget`
  MODIFY `BuID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `campus`
--
ALTER TABLE `campus`
  MODIFY `CaID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `classroom`
--
ALTER TABLE `classroom`
  MODIFY `RmID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DeptID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `enrolment`
--
ALTER TABLE `enrolment`
  MODIFY `EID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `ModuleID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `spaceassign`
--
ALTER TABLE `spaceassign`
  MODIFY `SpaID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `StaffID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teach`
--
ALTER TABLE `teach`
  MODIFY `TID` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `FK_BuID` FOREIGN KEY (`BuID`) REFERENCES `budget` (`BuID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CaID2` FOREIGN KEY (`CaID`) REFERENCES `campus` (`CaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `allocation`
--
ALTER TABLE `allocation`
  ADD CONSTRAINT `FK_AcID` FOREIGN KEY (`AcID`) REFERENCES `activity` (`AcID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_StaffID1` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `classroom`
--
ALTER TABLE `classroom`
  ADD CONSTRAINT `FK_CaID1` FOREIGN KEY (`CaID`) REFERENCES `campus` (`CaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `enrolment`
--
ALTER TABLE `enrolment`
  ADD CONSTRAINT `FK_ModuleID` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ModuleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_StudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FK_DeptID1` FOREIGN KEY (`DeptID`) REFERENCES `department` (`DeptID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `spaceassign`
--
ALTER TABLE `spaceassign`
  ADD CONSTRAINT `FK_RmID` FOREIGN KEY (`RmID`) REFERENCES `classroom` (`RmID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TID` FOREIGN KEY (`TID`) REFERENCES `teach` (`TID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FK_CaID` FOREIGN KEY (`CaID`) REFERENCES `campus` (`CaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DeptID` FOREIGN KEY (`DeptID`) REFERENCES `department` (`DeptID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SupervisorID` FOREIGN KEY (`SupervisorID`) REFERENCES `staff` (`StaffID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teach`
--
ALTER TABLE `teach`
  ADD CONSTRAINT `FK_ModuleID1` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ModuleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SpaID` FOREIGN KEY (`SpaID`) REFERENCES `spaceassign` (`SpaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_StaffID` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
