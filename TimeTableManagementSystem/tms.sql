-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2021 at 02:10 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `cons_ss`
--

CREATE TABLE `cons_ss` (
  `GID` int(11) NOT NULL,
  `Subj` int(11) NOT NULL,
  `Sub_code` varchar(255) NOT NULL,
  `first_s` varchar(255) NOT NULL,
  `lec_1` varchar(255) NOT NULL,
  `second_s` varchar(255) NOT NULL,
  `lec_2` varchar(255) NOT NULL,
  `thrid_s` varchar(255) NOT NULL,
  `lec_3` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `editlocation_details`
--

CREATE TABLE `editlocation_details` (
  `ID` int(10) NOT NULL,
  `room` varchar(30) NOT NULL,
  `day` varchar(30) NOT NULL,
  `startTime` varchar(30) NOT NULL,
  `endTime` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `editlocation_details`
--

INSERT INTO `editlocation_details` (`ID`, `room`, `day`, `startTime`, `endTime`) VALUES
(14, 'A403', 'Monday', '1:00', '3:00');

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

CREATE TABLE `employee_details` (
  `Employee_ID` int(6) NOT NULL,
  `Full_Name` varchar(100) NOT NULL,
  `Faculty` varchar(50) NOT NULL,
  `Department` varchar(50) NOT NULL,
  `Center` varchar(50) NOT NULL,
  `Buiding` varchar(50) NOT NULL,
  `Rank` double(7,6) NOT NULL,
  `Level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_details`
--

INSERT INTO `employee_details` (`Employee_ID`, `Full_Name`, `Faculty`, `Department`, `Center`, `Buiding`, `Rank`, `Level`) VALUES
(100000, 'Prof. Koliya Pulasinghe', 'Faculty Of Computing', 'Academic Staff', 'Malabe Campus', 'Faculty of Computing Building', 1.100000, 'Professor'),
(100001, 'Prof. Mahesha Kapurubandara', 'Faculty Of Computing', 'Academic Staff', 'Malabe Campus', 'Faculty of Computing Building', 1.100001, 'Professor'),
(100002, 'Mr. Samantha Rajapaksha', 'Faculty Of Computing', 'Academic Staff', 'Malabe Campus', 'Faculty of Computing Building', 3.100002, 'Senior Lecturer(HG)'),
(100003, 'Ms. Anjalie Gamage', 'Faculty Of Computing', 'Academic Staff', 'Metropolitan campus', 'Faculty of Computing Building', 4.100003, 'Senior Lecturer'),
(100004, 'Ms. Gayathri Senaviratne', 'Faculty Of Business', 'Academic Staff', 'Kandy Center', 'Faculty of Engineering Building', 6.100004, 'Assistant Lecturer'),
(100005, 'Ms. Shalini Rupasinghe', 'Faculty Of Computing', 'Academic Staff', 'Metropolitan campus', 'Faculty of Computing Building', 6.100005, 'Assistant Lecturer'),
(100006, 'Ms. Chamanthi Rodrigo', 'Faculty Of Engineering', 'Academic Staff', 'Jaffna Center', 'Faculty of Computing Building', 5.100006, 'Lecturer'),
(100007, 'Ms. Ashani Peiris', 'Humanities $ Science', 'Academic Staff', 'Malabe Campus', 'Faculty of Computing Building', 0.100007, 'Lecturer'),
(100008, 'Prof. Colin N Peiris', 'Humanities $ Science', 'Academic Staff', 'Jaffna Center', 'Faculty of Humanities & Science Building', 1.100008, 'Professor'),
(100009, 'Prof. Sriyani Peiris', 'Humanities $ Science', 'Academic Staff', 'Jaffna Center', 'Faculty of Engineering Building', 1.100009, 'Professor'),
(100010, 'Prof. Niranga Amarasingha', 'Faculty Of Engineering', 'Academic Staff', 'Jaffna Center', 'Faculty of Engineering Building', 2.100010, 'Assistant Professor'),
(100011, 'Dr. Kalpani Manathunga', 'Faculty Of Engineering', 'Academic Staff', 'Kurunegala center', 'Faculty of Engineering Building', 3.100011, 'Senior Lecturer(HG)'),
(100013, 'Prof. Naganthan Selvakkumaran', 'School of Law', 'Academic Staff', 'Kurunegala center', 'Faculty of Humanities & Science Building', 1.100013, 'Professor'),
(100015, 'Dr. Ruwan Jayathilaka', 'Faculty Of Engineering', 'Administration Staff', 'Metropolitan campus', 'Faculty of Engineering Building', 2.100015, 'Assistant Professor'),
(100016, 'Mr. Amila Senarathne', 'Faculty Of Computing', 'Administration Staff', 'Kandy Center', 'Faculty of Business & Studies Building', 4.100016, 'Senior Lecturer'),
(200000, 'Ms. Lakmali Abeyrathna', 'Faculty Of Computing', 'Administration Staff', 'Malabe Campus', 'Faculty of Computing Building', 4.200000, 'Senior Lecturer'),
(200002, 'Ms. Sachi Ruwanthika', 'Faculty Of Computing', 'Administration Staff', 'Malabe Campus', 'Faculty of Computing Building', 5.200002, 'Lecturer'),
(200006, 'test', 'Faculty Of Engineering', 'Administration Staff', 'Kandy Center', 'Faculty of Computing Building', 3.200006, 'Senior Lecturer(HG)');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `BuildingName` varchar(20) NOT NULL,
  `RoomType` varchar(20) NOT NULL,
  `RoomName` varchar(15) NOT NULL,
  `Capacity` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`BuildingName`, `RoomType`, `RoomName`, `Capacity`) VALUES
('New Building', 'Laboraltory', 'A403', 60),
('Main Building', 'LectuerHall', 'E502', 120);

-- --------------------------------------------------------

--
-- Table structure for table `non_overlap`
--

CREATE TABLE `non_overlap` (
  `Cat_ID` int(11) NOT NULL,
  `Cat1` varchar(255) NOT NULL,
  `Cat2` varchar(255) NOT NULL,
  `Cat3` varchar(255) NOT NULL,
  `Cat4` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `notavailable_details`
--

CREATE TABLE `notavailable_details` (
  `ID` int(10) NOT NULL,
  `lecture` varchar(30) NOT NULL,
  `maingroup` varchar(30) NOT NULL,
  `subgroup` varchar(30) NOT NULL,
  `session_ID` int(10) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notavailable_details`
--

INSERT INTO `notavailable_details` (`ID`, `lecture`, `maingroup`, `subgroup`, `session_ID`, `time`) VALUES
(4, 'Prof. Koliya Pulasinghe', '13', '6', 6, '2:00'),
(5, 'Ms. Gayathri Senaviratne', '13', '1', 1, '1 :00'),
(7, 'Ms. Anjalie Gamage', '13', '13.2', 3, '1 :30'),
(8, 'Prof. Koliya Pulasinghe', 'Y1S1.13', '3', 3, '1 :30'),
(9, 'Prof. Mahesha Kapurubandara', 'Y1S1.13', '1', 1, '1 :00');

-- --------------------------------------------------------

--
-- Table structure for table `parl_ss`
--

CREATE TABLE `parl_ss` (
  `GID` varchar(255) NOT NULL,
  `mod_1` varchar(255) NOT NULL,
  `mod_2` varchar(255) NOT NULL,
  `mod_3` varchar(255) NOT NULL,
  `hrs` varchar(6) NOT NULL,
  `min` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `session_details`
--

CREATE TABLE `session_details` (
  `ID` int(4) NOT NULL,
  `First_Lecture` varchar(50) NOT NULL,
  `Second_Lecture` varchar(50) DEFAULT NULL,
  `Tag` varchar(50) NOT NULL,
  `room` varchar(50) NOT NULL,
  `Main_Group` varchar(50) NOT NULL,
  `Sub_Group` varchar(50) NOT NULL,
  `Subject` varchar(50) NOT NULL,
  `Subject_code` varchar(20) NOT NULL,
  `No_Of_Student` int(3) NOT NULL,
  `Day` varchar(20) NOT NULL,
  `Time_slot` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `session_details`
--

INSERT INTO `session_details` (`ID`, `First_Lecture`, `Second_Lecture`, `Tag`, `room`, `Main_Group`, `Sub_Group`, `Subject`, `Subject_code`, `No_Of_Student`, `Day`, `Time_slot`) VALUES
(1, 'Prof. Koliya Pulasinghe', 'Ms. Shalini Rupasinghe', 'lecture', 'A403', 'Y1S1.13', 'Y1S1.13.1', 'ip', 'IT3020', 60, 'select a Day', '1'),
(2, 'Prof. Mahesha Kapurubandara', 'Mr. Samantha Rajapaksha', 'lecture', 'E502', 'Y1S1.13', 'Y1S1.13.1', 'ip', 'IT3020', 60, 'select a Day', '2'),
(3, 'Prof. Mahesha Kapurubandara', 'Mr. Samantha Rajapaksha', 'select a type', 'E502', 'Y1S1.13', 'Y1S1.13.1', 'Introduction to Programming', 'IT1010', 60, 'select a Day', '1'),
(5, 'Prof. Mahesha Kapurubandara', NULL, 'Lecture', 'A403', '13', '13.2', 'Introduction to Programming', 'IT1010', 150, 'Tuesday', '8.30 - 9.30'),
(6, 'Mr. Samantha Rajapaksha', NULL, 'Lecture', 'A403', '13', '13.2', 'Introduction to Programming', 'IT1010', 200, 'Wensday', '8.30 - 9.30'),
(7, 'Prof. Mahesha Kapurubandara', 'Ms. Gayathri Senaviratne', 'Lecture', 'E502', '13', '13.2', 'Introduction to Programming', 'IT1010', 200, 'Tuesday', '8.30 - 9.30');

-- --------------------------------------------------------

--
-- Table structure for table `student_group`
--

CREATE TABLE `student_group` (
  `Academic_Year_And_Semester` varchar(50) NOT NULL,
  `Enrolled_Course` varchar(50) NOT NULL,
  `Group_No` varchar(50) NOT NULL,
  `Group_ID` varchar(50) NOT NULL,
  `Sub_Group_No` varchar(50) NOT NULL,
  `Sub_Group_Id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_group`
--

INSERT INTO `student_group` (`Academic_Year_And_Semester`, `Enrolled_Course`, `Group_No`, `Group_ID`, `Sub_Group_No`, `Sub_Group_Id`) VALUES
('Y1S1', 'english', '13', 'Y1S1.13', '1', 'Y1S1.13.1');

-- --------------------------------------------------------

--
-- Table structure for table `stu_grp`
--

CREATE TABLE `stu_grp` (
  `AcadY_sem` varchar(255) NOT NULL,
  `enroll_c` varchar(255) NOT NULL,
  `G_no` varchar(255) NOT NULL,
  `G_ID` varchar(255) NOT NULL,
  `sub_no` varchar(255) NOT NULL,
  `Sub_ID` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stu_grp`
--

INSERT INTO `stu_grp` (`AcadY_sem`, `enroll_c`, `G_no`, `G_ID`, `sub_no`, `Sub_ID`) VALUES
('Y1S1', 'Data Science', '13', '13', '2', '13.2');

-- --------------------------------------------------------

--
-- Table structure for table `subject_details`
--

CREATE TABLE `subject_details` (
  `Subject_Code` varchar(50) NOT NULL,
  `Subject_Name` varchar(50) NOT NULL,
  `Offered_Year` varchar(50) NOT NULL,
  `Offered_Semester` varchar(50) NOT NULL,
  `Lecture_Hours` varchar(10) NOT NULL,
  `Tute_Hours` varchar(10) NOT NULL,
  `Lab_Hours` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject_details`
--

INSERT INTO `subject_details` (`Subject_Code`, `Subject_Name`, `Offered_Year`, `Offered_Semester`, `Lecture_Hours`, `Tute_Hours`, `Lab_Hours`) VALUES
('IT1010', 'Introduction to Programming', '1 st year', '1 st Semester', '02:00', '02:00', '01:00');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `ID` int(4) NOT NULL,
  `Subject_Name` varchar(50) NOT NULL,
  `Subject_Code` varchar(50) NOT NULL,
  `Related_Tags` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`ID`, `Subject_Name`, `Subject_Code`, `Related_Tags`) VALUES
(1, 'english', 'IT1050', 'lecture');

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `sub_name` varchar(255) NOT NULL,
  `sub_code` varchar(255) NOT NULL,
  `rel_tags` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`sub_name`, `sub_code`, `rel_tags`) VALUES
('lec', '01', 'Lecture');

-- --------------------------------------------------------

--
-- Table structure for table `workingdays`
--

CREATE TABLE `workingdays` (
  `empID` varchar(6) NOT NULL,
  `workday` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workingdays`
--

INSERT INTO `workingdays` (`empID`, `workday`) VALUES
('123456', 'MonSecondHalf'),
('123456', 'TueSecondHalf'),
('123456', 'WedSecondHalf'),
('123456', 'ThurSecondHalf'),
('123456', 'FriSecondHalf'),
('456798', 'MonFirstHalf'),
('456798', 'TueFirstHalf'),
('456798', 'WedSecondHalf'),
('456798', 'ThurSecondHalf'),
('987654', 'MonSecondHalf'),
('987654', 'TueSecondHalf'),
('987654', 'WedFirstHalf'),
('987654', 'ThurFullDay'),
('987654', 'MonFullDay'),
('987654', 'TueFullDay'),
('987321', 'MonFullDay'),
('987321', 'TueFirstHalf'),
('987321', 'ThurFirstHalf'),
('987321', 'SatFirstHalf'),
('987321', 'SunFirstHalf'),
('741963', 'MonSecondHalf'),
('741963', 'WedSecondHalf'),
('741963', 'ThurFirstHalf'),
('741963', 'FriFirstHalf'),
('200006', 'MonFullDay'),
('200006', 'TueFirstHalf'),
('200006', 'FriFirstHalf'),
('200006', 'SatSecondHalf'),
('200003', 'MonFullDay'),
('200003', 'MonFullDay'),
('12', 'MonFullDay'),
('100000', 'MonFullDay'),
('100000', 'TueFullDay'),
('100000', 'WedFirstHalf'),
('100000', 'ThurSecondHalf'),
('100000', 'SunFirstHalf'),
('200000', 'MonFullDay'),
('200000', 'TueFullDay'),
('123456', 'MonFullDay'),
('123457', 'MonFullDay'),
('123458', 'TueFullDay'),
('123459', 'MonFullDay'),
('123459', 'TueFullDay'),
('123457', 'MonFullDay'),
('123457', 'TueFullDay'),
('123467', 'MonFullDay'),
('123467', 'TueFullDay'),
('', 'MonFullDay'),
('', 'TueFullDay');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `editlocation_details`
--
ALTER TABLE `editlocation_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `employee_details`
--
ALTER TABLE `employee_details`
  ADD PRIMARY KEY (`Employee_ID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`RoomName`);

--
-- Indexes for table `non_overlap`
--
ALTER TABLE `non_overlap`
  ADD PRIMARY KEY (`Cat_ID`);

--
-- Indexes for table `notavailable_details`
--
ALTER TABLE `notavailable_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `session_details`
--
ALTER TABLE `session_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `subject_details`
--
ALTER TABLE `subject_details`
  ADD PRIMARY KEY (`Subject_Code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `editlocation_details`
--
ALTER TABLE `editlocation_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `non_overlap`
--
ALTER TABLE `non_overlap`
  MODIFY `Cat_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notavailable_details`
--
ALTER TABLE `notavailable_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `session_details`
--
ALTER TABLE `session_details`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
