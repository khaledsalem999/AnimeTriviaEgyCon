-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2016 at 03:12 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anime`
--

-- --------------------------------------------------------

--
-- Table structure for table `anime`
--

CREATE TABLE `anime` (
  `ID` int(11) NOT NULL,
  `Aname` varchar(40) NOT NULL,
  `Pic` text NOT NULL,
  `GenreID` int(11) NOT NULL,
  `isMainstream` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `AID` int(11) NOT NULL,
  `RightAnswer` text NOT NULL,
  `SecondAnswer` text NOT NULL,
  `ThirdAnswer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`AID`, `RightAnswer`, `SecondAnswer`, `ThirdAnswer`) VALUES
(1, 'Tanaka', 'Tatsuhiro', 'Yamazaki'),
(2, 'Kou', 'Touma', 'Youichi'),
(3, 'Exclude her', 'Befriend her', 'Idolize her'),
(4, 'Kou', 'Futaba', 'Yuuri'),
(5, 'Brothers', 'Childhood friends', 'Classmates'),
(6, 'His parents divorce', 'His father''s job', 'Having no friends'),
(7, 'Kou', 'Futaba', 'Shuuko'),
(8, 'Yuuri', 'Chie', 'Asumi'),
(9, 'Youichi', 'Touma ', 'Aya'),
(10, 'Futaba', 'Yuuri', 'Shuuko'),
(11, 'Shuuko', 'Yuuri', 'Chie'),
(12, 'Kou', 'Futaba', 'Yuuri'),
(13, 'Aya', 'Touma', 'Kou'),
(14, '1-1', '1-2', '1-3'),
(15, '2-2', '2-1', '2-3'),
(16, 'Kou', 'Youichi', 'Touma'),
(17, 'Youichi', 'Kou', 'Aya'),
(18, 'Kou', 'Touma', 'Naito'),
(19, 'Futaba', 'Yuuri', 'Shuuko'),
(20, 'Yuuri', 'Futaba', 'Kominato'),
(21, 'Aya', 'Kou', 'Haru'),
(22, 'Shuuko', 'Futaba', 'Chie'),
(23, 'Nagasaki', 'Tokyo', 'Kyoto'),
(24, 'His mother''s illness', 'Failing midterms', 'Moving away'),
(25, 'Chie', 'Asumi', 'Asuna'),
(26, 'Asumi', 'Asuna', 'Azami'),
(27, 'Yumi', 'Yuuri', 'Chie'),
(28, 'Makita', 'Mabuchi', 'Futaba'),
(29, 'Science', 'English', 'Math'),
(30, 'Cats', 'Aya', 'Shuuko'),
(31, '*CC', 'Sisi', 'Gentie'),
(32, '*Absolute obedience', 'erasing memories', 'time stopping'),
(33, '*Zero', 'VV', 'Suzaku Kururugi'),
(34, '*District 11', 'America', 'England'),
(35, '*By Knightmares', 'By swords', 'By Nuclear bombs'),
(36, '*Charles vi Britannia', 'Suzaku Kururugi', 'Zero'),
(37, '*Pizza', 'Burger', 'pasta'),
(38, '*Suzaku Kururugi', 'Lelouch', 'Nanally'),
(39, '*Shirley Fenette', 'CC', 'Nina'),
(40, '*Rolo ', 'Lelouch', 'Suzaku'),
(41, '*Zero', 'Knight zero', 'Karen'),
(42, '*Karen Kozuki', 'Suzaku Kururugi', 'Lelouch'),
(43, '*Cornelia li Britannia', 'Euphemia ', 'Nina'),
(44, '*A knight', 'A king', 'A driver'),
(45, '*Suzaku Kururugi', 'Li Xingke', 'CC'),
(46, '*Lord Jeramiah', 'Lord Stark', 'Akito'),
(47, '*Lelouch', 'Knight zero', 'Rolo'),
(48, '*The Zero Requiem', 'The Ragnarok', 'Hatteen'),
(49, '*Valetta Neu', 'Kallen', 'Viola'),
(50, '*Rolo ', 'Rivel', 'Ohgi'),
(51, '*Shirley Fenette', 'nina', 'Madam President'),
(52, '*Genbu Kururugi', 'Josui Kusakabe', 'Sakuradite'),
(53, '*Taizo Kirihara', 'Nano taaizai', 'Orpheus Zevon'),
(54, '*Arthur', 'Ga''far', 'Cesear'),
(55, '*Clovis la Britannia', 'Euphemia li Britannia', 'Cornelia li Britannia'),
(56, '*Marianne', 'Suzan', 'Sally'),
(57, '*Schneizel el Britannia', 'Clovis la Britannia', 'Suzaku Kururugi'),
(58, '*Mao', 'Nihao', 'Dash'),
(59, '*Euphemia li Britannia', 'Shirley Fenette', 'Anna Clément'),
(60, '*Kimono', 'Uniform', 'Sport''s wear'),
(61, 'Ikebukuro', 'Akihabara', 'Shinjuku'),
(62, 'Kida Masaomi', 'Ryuugamine Mikado', 'Tanaka Taro'),
(63, 'Heiwajima Shizuo', 'Orihara Izaya', 'Yodogiri Jinnai'),
(64, 'Sushi', 'Ramen', 'Udon'),
(65, 'Orihara Izaya', 'Ryuugamine Mikado', 'Celty Sturluson'),
(66, 'Ryuugamine Mikado', 'Orihara Izaya', 'Sonohara Anri'),
(67, 'Yagiri Namie', 'Yagiri Jinnai', 'Yagiri Seiji'),
(68, 'Actor', 'Singer', 'Director'),
(69, 'Yellow Scarves', 'Yellow Turbans', 'Yellow Squares'),
(70, 'Russia', 'Romania', 'China'),
(71, 'Ryuugamine Mikado', 'Celty Sturluson', 'Yagiri Seiji'),
(72, 'Yellow', 'Black', 'Silver'),
(73, 'Saika', 'Murasame', 'Akuto'),
(74, 'To love them', 'To kill them', 'To poison them'),
(75, 'Raira Academy', 'Chiba Academy', 'Kaiki Academy'),
(76, 'Rokujou Chikage', 'Togusa Saburou', 'Kuronuma Aoba'),
(77, 'Vorona', 'Varona', 'Venora'),
(78, 'Left One', 'Right One', 'Neither'),
(79, 'Awakusu Group', 'Yodogiri Group', 'The Dollars'),
(80, 'Orihara Mairu', 'Orihara Izaya', 'Orihara Kururi'),
(81, 'Izumii Ran', 'Izumii Sei', 'Izumii Shida'),
(82, 'Since primary school', 'Since middle school', 'Since highschool'),
(83, 'Sharaku Mikage', 'Kotonami Nozomi', 'Kamichika Rio'),
(84, 'Toramaru', 'Tarimiru', 'Taroumaru'),
(85, 'Orihara Izaya', 'Yodigiri Jinnai', 'Kishitani Shinra'),
(86, 'Debt Collector', 'Movie Producer', 'Businessman'),
(87, 'Anri''s parents', 'Saki''s parents', 'Mairu''s parents'),
(88, '4 Years Old', '6 Years Old', '8 Years Old'),
(89, 'A', 'B', 'C'),
(90, 'Togusa Saburo', 'Kadota Kyohei', 'Yumasaki Walker'),
(91, 'Destruction ', 'Reconstruction', 'Analysation'),
(92, 'Reconstruction', 'Destruction ', 'Analysation'),
(93, 'King Bradley', 'Roy Mustang', 'Maes Hughes'),
(94, 'Because he killed people who were not on his government-approved kill list', 'Because he killed lots of Ishvalian', 'Because he killed innocent citizens'),
(95, 'Xing', 'Amestris', 'Ishval'),
(96, 'Maes Hughes', 'Van Hohenheim', 'Edward Elric'),
(97, 'Scar', 'Roy Mustang', 'Alphonse Elric'),
(98, 'Explosion Alchemy', 'Destruction Alchemy', 'Decombosition Alchemy'),
(99, 'Colonel', 'Major', 'Sergeant'),
(100, 'His sight', 'His eyes', 'His senses'),
(101, 'The Fastest Homunculus', 'The Strongest Homunculus', 'The Dumbest Homunculus'),
(102, 'Major', 'Sergeant', 'Colonel'),
(103, 'Crying', 'Smiling', 'Angry'),
(104, 'Right arm', 'Left arm', 'Right leg'),
(105, 'Selim Bradley', 'Roy Mustang', 'Edward Elric'),
(106, 'Sig Curtis', 'Tim Marcoh', 'Miles'),
(107, 'Shou Tucker', 'Tim Marcoh', 'Isaac McDougal'),
(108, '5', '6', '7'),
(109, '12', '9', '17'),
(110, 'Olivier Mira Armstrong', 'Alex Louis Armstrong', 'Catherine Elle Armstrong'),
(111, '23', '21', '27'),
(112, 'Lion', 'Gorilla', 'Boar'),
(113, 'Elicia', 'Gracia', 'Nina'),
(114, 'Izumi', 'Pinako', 'Mira'),
(115, 'Drachma', 'Xing', 'Ishval'),
(116, 'Buccaneer', 'Fu', 'Greed'),
(117, 'Absolute', 'Universe ', 'Truth'),
(118, 'Lan Fan', 'Han', 'Ling Yao'),
(119, 'Xiao-Mei', 'Fu', 'Mei Chang'),
(120, 'Water Alchemy', 'Combat Alchemy', 'Iron-weapons Alchemy'),
(121, 'Ikebukuro', 'Akihabara', 'Shinjuku'),
(122, 'Kida Masaomi', 'Ryuugamine Mikado', 'Tanaka Taro'),
(123, 'Heiwajima Shizuo', 'Orihara Izaya', 'Yodogiri Jinnai'),
(124, 'Sushi', 'Ramen', 'Udon'),
(125, 'Orihara Izaya', 'Ryuugamine Mikado', 'Celty Sturluson'),
(126, 'Ryuugamine Mikado', 'Orihara Izaya', 'Sonohara Anri'),
(127, 'Yagiri Namie', 'Yagiri Jinnai', 'Yagiri Seiji'),
(128, 'Actor', 'Singer', 'Director'),
(129, 'Yellow Scarves', 'Yellow Turbans', 'Yellow Squares'),
(130, 'Russia', 'Romania', 'China'),
(131, 'Ryuugamine Mikado', 'Celty Sturluson', 'Yagiri Seiji'),
(132, 'Yellow', 'Black', 'Silver'),
(133, 'Saika', 'Murasame', 'Akuto'),
(134, 'To love them', 'To kill them', 'To poison them'),
(135, 'Raira Academy', 'Chiba Academy', 'Kaiki Academy'),
(136, 'Rokujou Chikage', 'Togusa Saburou', 'Kuronuma Aoba'),
(137, 'Vorona', 'Varona', 'Venora'),
(138, 'Left One', 'Right One', 'Neither'),
(139, 'Awakusu Group', 'Yodogiri Group', 'The Dollars'),
(140, 'Orihara Mairu', 'Orihara Izaya', 'Orihara Kururi'),
(141, 'Izumii Ran', 'Izumii Sei', 'Izumii Shida'),
(142, 'Since primary school', 'Since middle school', 'Since highschool'),
(143, 'Sharaku Mikage', 'Kotonami Nozomi', 'Kamichika Rio'),
(144, 'Toramaru', 'Tarimiru', 'Taroumaru'),
(145, 'Orihara Izaya', 'Yodigiri Jinnai', 'Kishitani Shinra'),
(146, 'Debt Collector', 'Movie Producer', 'Businessman'),
(147, 'Anri''s parents', 'Saki''s parents', 'Mairu''s parents'),
(148, '4 Years Old', '6 Years Old', '8 Years Old'),
(149, 'A', 'B', 'C'),
(150, 'Togusa Saburo', 'Kadota Kyohei', 'Yumasaki Walker'),
(151, 'Grell', 'William', 'Alan'),
(152, 'Angelina', 'Ciel', 'Rommeo'),
(153, 'Pluto', 'Ash', 'Angela'),
(154, 'Houndsworth', 'Hound Town', 'Dog Wrath'),
(155, 'Countess Trancy', 'King Edward Mother', 'Elithabith Mother'),
(156, 'Drossel Keinz', 'Sdroles Nick', 'Ronalld Naiz'),
(157, 'Demon', 'Assassin', 'Angel'),
(158, 'Shinigami Library', 'Transy HouseHold', 'Louis Household'),
(159, 'Grell', 'Sebbastian', 'Ciel'),
(160, '2', '3', '4'),
(161, 'Cats', 'Dogs', 'Snakes'),
(162, '8', '7', '10'),
(163, 'Funtom''s candy', 'Funtom''s Wrokshop', 'Funtom''s Toys'),
(164, 'Ash Landers', 'Angela', 'Ciel'),
(165, '6', '8', '10'),
(166, '8', '7', '6'),
(167, 'Cats', 'Dogs', 'Birds'),
(168, 'The Queen victoria', 'Drocell Kienz', 'Charles Grey'),
(169, '3', '4', '2'),
(170, 'death scythe', 'Soul Grapper', 'Weapn Of Souls'),
(171, 'Tetragrammaton', 'Metraemmaton', 'Etammenraton'),
(172, 'Jim Macken', 'Mat Macken', 'Leo Macken'),
(173, 'Luke Macken', 'Andrew Macken', 'Matthew Macken'),
(174, 'vateinn', 'Ametran', 'Metreiam'),
(175, '4', '5', '2'),
(176, 'Charles Grey', 'Drocell Kienz', 'Angela'),
(177, 'Noble Beast Mark', 'Stain Mark', 'Slave Mark'),
(178, 'Soma Asman Kadar', 'Aradene Asman Kader', 'Soli Asman Kadar'),
(179, 'Agani', 'Aladene', 'Inaga'),
(180, 'Elithabith Maid', 'Fred''s Wife', 'Mathilda''s Maid'),
(181, 'Aladdin', 'Alibaba', 'Morjiana'),
(182, 'Finding Metal ships', 'Finding watermelon', 'Finding king solomon'),
(183, 'Hakuryuu Ren', 'Magi', 'Masrur'),
(184, 'Alibaba', 'Ekaterina', 'Sindbad'),
(185, 'Sindbad', 'Alibaba', 'Aladdin'),
(186, 'Myers', 'Matal Mogamett ', 'Irene Smirnoff '),
(187, 'Ugo', 'King solomon', 'Sinbad '),
(188, 'Super kick', 'Flying', 'Spell casting'),
(189, 'Fanalis', 'Uchiha', 'Masrur'),
(190, 'Masrur', 'Sharrkan ', 'Drakon '),
(191, 'Gamil', 'Goltas', 'Alibaba'),
(192, 'Matal Mogamett', 'Aladdin', 'Myers'),
(193, 'Judar', 'Ahmad', 'Zurmudd'),
(194, 'Baba', 'Toya', 'Morjiana'),
(195, 'Rashid Saluja', 'Sahbmad Saluja', 'Ahmad Saluja'),
(196, 'Master Myers', 'Master Mogamett', 'Morjiana'),
(197, 'Sphintus Carmen', 'Marga ', 'Doron '),
(198, 'Cassim', 'Aladdin', 'Zaynab '),
(199, 'Magi: The Labyrinth of Magic', 'Magi: The Kingdom of Magic', 'Magi: Sinbad no Bouken'),
(200, 'Markkio', 'Marco', 'Macro'),
(201, 'Mina', 'Tina', 'Rita'),
(202, 'Amon', 'Ugo', 'Zagan'),
(203, 'Budel', 'Mudel', 'Sinbad '),
(204, 'Paimon', 'Ugo', 'Leraje '),
(205, 'Lo''lo''', 'Toto ', 'Toro'),
(206, 'Sana', 'Kana', 'Hana'),
(207, 'Kougyoku Ren', 'Kaguya', 'Koumei'),
(208, 'Kouen Ren', 'Kourin Ren', 'Hakuryuu Ren '),
(209, 'Ithnan', 'Ethan', 'Engi'),
(210, 'Shunsui Kyoraku.', 'Mayuri Kurotsuchi', 'Rojuro Otoribashi'),
(211, 'Jushiro Ukitake', 'Byakuya Kuchiki', 'Toshiro Hitsugaya'),
(212, 'Sajin Komamura', 'Retsu Unohana', 'Shinji Hirako'),
(213, 'Senbonzakura Kageyoshi', 'Koko Gonryo Rikyu', 'Daiguren Hyorinmaru'),
(214, 'Tensa Zangetsu', 'Konjiki Ashisogi Jizo', 'Ry?mon Hozukimaru '),
(215, 'Soo Zabimaru', 'Kokujo Tengen Myoo', 'Kamishini no Yari '),
(216, 'Memory reading and altering', 'Turns his necklace into a sword that absorbs the powers of any fullbringer stabed with it', 'Creates separate dimension at will'),
(217, '3', '2', '4'),
(218, '2', '1', '3'),
(219, 'Grabed some of his bankai in his hand and released it', 'Used a new kido spell ', 'Used a new bankai technique'),
(220, '3', '2', '4'),
(221, '3', '1', '2'),
(222, '2', '1', '0'),
(223, 'Muguruma Kensei', 'Mashiro Kuna', 'Rangiku Matsumoto'),
(224, 'Kaien Shiba', 'Rukia Kuchiki', 'Toshiro Hitsugaya'),
(225, 'Snow type', 'Ice type', 'Water type'),
(226, '3', '4', '2'),
(227, '13', '12', '14'),
(228, 'Ichimaru Gin', 'Suì-F?ng', 'Isane Kotetsu'),
(229, 'Izuru Kira', 'Chojiro Sasakibe', 'Yachiru Kusajishi'),
(230, 'Yamamoto Genryusai Shigekuni', 'Love Aikawa', 'Momo Hinamori'),
(231, 'Rangiku Matsumoto', 'Shuhei Hisagi', 'Yumichika Ayasegawa'),
(232, 'Ikaku Madarame', 'Izuru Kira', 'Shuhei Hisagi'),
(233, 'Poison type', 'Melee type', 'Kid? type'),
(234, '4', '3', '2'),
(235, '8', '7', '6'),
(236, 'Shinji Hirako', 'Hiyori Sarugaki', 'Kisuke Urahara'),
(237, '7', '8', '6'),
(238, 'Kugo Ginjo', 'Shukuro Tsukishima', 'Giriko Kutsuzawa'),
(239, 'Gigai', 'Hogyoku', 'Tenkai Kecchu'),
(240, 'Dirty Boots', 'Dollhouse', 'Cross of Scaffold'),
(241, 'Jackpot Knuckle', 'Time Tells No Lies', 'Book of The End'),
(242, 'Pantera', 'Tiburón', 'Brujería'),
(243, 'Segunda Etapa', 'Murciélago', 'Arrogante'),
(244, 'Los Lobos', 'Fornicarás', 'Gamuza'),
(245, '7', '6', '8'),
(246, '8', '9', '10'),
(247, '9', '7', '8'),
(248, 'Black smoke that ages and rots anything it touches', 'Making dolls with enemy''s organs ', 'Taking control of anything (1 per eye)'),
(249, 'Nullifying Genryusai Shigekuni Yamamoto''s Zanpakut? abilities', 'Can change and use the powers of those absorbed by him', 'Summons a bush around him and his enemy cutting off their view from the world and masks their Reiatsu'),
(250, 'Byakuya Kuchiki', 'Renji Abarai', 'Mayuri Kurotsuchi'),
(251, 'Zaraki Kenpachi', 'Kurosaki Ichigo', 'Kuchiki Rukia'),
(252, 'Toshiro Hitsugaya', 'Shuhei Hisagi', 'Tetsuzaemon Iba'),
(253, 'Healing and support division', 'Soul Society security division', 'Reserch division'),
(254, 'Direct Combat division', 'Reserch division', 'Soul Society security division'),
(255, 'Soul Society security division', 'Direct Combat division', 'Assassination and intel division'),
(256, 'Assassination and intel division', 'Reserch division', 'Direct Combat division'),
(257, 'Reserch division', 'Healing and support division', 'Soul Society security division'),
(258, 'Mayuri Kurotsuchi', 'Byakuya Kuchiki', 'Kurosaki Ichigo'),
(259, 'Chojiro Sasakibe', 'Tetsuzaemon Iba', 'Ikaku Madarame'),
(260, 'Edrad Liones', 'Di Roy Rinker', 'Nakeem Grindina'),
(261, 'Brazo Izquierda del Diablo', 'Brazo Derecha de Gigante', 'La Muerte'),
(262, 'Orihime Inoue', 'Rangiku Matsumoto', 'Momo Hinamori'),
(263, 'Uryu Ishida', 'Ryuken Ishida', 'Soken Ishida'),
(264, '6th division ', '1st divison', '9th division'),
(265, 'Hanataro Yamada', 'Yumichika Ayasegawa', 'Rukia Kuchiki'),
(266, 'Nanao Ise', 'Miyako Shiba', 'Lisa Yad?maru'),
(267, '1st divison', '10th division', '11th division'),
(268, '3rd division', '13th division', '2nd division'),
(269, '5th division', '4th division', '7th division'),
(270, '40 Seconds', '60 Seconds', '6 Minutes'),
(271, 'Sidoh', 'Rem', 'Nu'),
(272, 'Jelus', 'Nu', 'Midora'),
(273, 'Lind L. Taylor', 'Liam L. Carter', 'Ryan L. Lee'),
(274, 'Raye Penber', 'Rayan Adolf', 'Raymond Wolf'),
(275, 'Chocolate', 'Pizza', 'Mango'),
(276, 'Apples', 'Pizza', 'He doesn''t eat'),
(277, 'FBI Agent', 'CIA Agent', 'JSAF Agent'),
(278, 'Accident', 'Illness', 'Suicide'),
(279, 'Yagami Souichirou', 'Yagami Shinichirou', 'Yagami Soushirou'),
(280, 'Tennis', 'Soccer', 'Baseball'),
(281, '2 Times', '3 Times', '1 Time'),
(282, 'Demegawa Hitoushi', 'Iwamatsu Ukita', 'Touta Matsuda'),
(283, 'Takada Kiyomi', 'Yagami Soushirou', 'Higuchi Kyousuke'),
(284, 'Takada Kiyomi', 'Yagami Light', 'Mikami Teru'),
(285, 'Yagami Light', 'Mikami Teru', 'Mello'),
(286, 'Mihael Keehl', '', ''),
(287, 'Higuchi Kyousuke', 'Namikawa Reiji', 'Takeshi Ooi'),
(288, 'Mello, the Death note', 'Near, Mello’s whereabouts', 'Near, the Death note'),
(289, 'Takada Kiyomi', '', ''),
(290, 'Reye Penber', 'Amane Misa', 'Near'),
(291, 'Aoyama', 'Tokyo Dome', 'Shinjuku'),
(292, 'Amane Misa', 'Takada Kiyomi', 'Light''s Sister'),
(293, 'half your remaining lifespan', 'half your total lifespan', '5 years of your life'),
(294, '6 Minutes and 40 Seconds', '40 Seconds', '6 Minutes'),
(295, 'Prosecutor', '', ''),
(296, 'Misora Naomi', '', ''),
(297, 'Tooh University', 'Tokyo University', 'Kyushu University'),
(298, 'Sayu', 'Saya', 'Seya'),
(299, 'Quillish Wammy', '', ''),
(300, 'Left', 'Right', 'Both'),
(301, 'Yuri', 'Inori', 'Eri'),
(302, '25 Years Old', '24 Years Old', '20 Years Old'),
(303, 'Hideki Ryuga', 'Hishida Ryuzaki', 'Hamada Ryusei'),
(304, '0.4', '0.2', '0.6'),
(305, 'L', 'Misa', 'Misa''s director'),
(306, 'Matsuda Touta', 'Aizawa Shuichi', 'Mogi Kanzo'),
(307, '39,800 Yen', '79,900 Yen', '129,750 Yen');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `ID` int(11) NOT NULL,
  `GType` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `QID` int(11) NOT NULL,
  `Question` text NOT NULL,
  `Difficulty` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`QID`, `Question`, `Difficulty`) VALUES
(1, 'Before changing his surname to "Mabuchi", "Kou"''s surname was .....', 'easy'),
(2, '"Futaba"''s first love was .....', 'easy'),
(3, '"Futaba"''s cute appearance in junior high made the other girls .....', 'easy'),
(4, 'What is his name?', 'easy'),
(5, '"Youichi" and "Kou" are .....', 'easy'),
(6, '"Kou" transfered to another school in junior high due to .....', 'easy'),
(7, '"Things aren''t like they were in those days. I''m different, you''re different. Which means that''s in the past." Who said this?', 'easy'),
(8, 'What''s her name?', 'easy'),
(9, 'What''s his name?', 'easy'),
(10, 'What''s her name?', 'easy'),
(11, 'Wha''s her name?', 'easy'),
(12, '"Stop searching for the old me" Who said this?', 'easy'),
(13, 'What''s his name?', 'easy'),
(14, 'Mabuchi''s Class in first year highschool was ...', 'easy'),
(15, 'Futaba & Kou were class representatives for which class?', 'easy'),
(16, '"Caring for things brings a lot of trouble." Who said this?', 'easy'),
(17, '"Shuuko" is in love with .....', 'easy'),
(18, '"Yuuri" starts to fall in love with .....', 'easy'),
(19, '"Kou" and .... became the class represntatives', 'easy'),
(20, 'Who saw "Kou"''s mother memorial room ?', 'easy'),
(21, 'Kominato''s 1st name is ...', 'easy'),
(22, '"Aya" likes ....', 'easy'),
(23, 'After his parents divorced, "Kou" moved with his mother to ....', 'easy'),
(24, '.... Caused "Kou" grief and trauma', 'easy'),
(25, 'What is her name?', 'easy'),
(26, 'What is her name?', 'easy'),
(27, '.... was Futaba''s best friend in middle school', 'easy'),
(28, 'One of them is not class representative.', 'easy'),
(29, 'Futaba''s strongest subject is ...', 'easy'),
(30, 'Mabuchi loves ...', 'easy'),
(31, 'Who is this ?', 'Easy'),
(32, 'Lelouch''s ability is ...', 'Easy'),
(33, 'Who is the leader of the Black Knights ?', 'Easy'),
(34, 'Where does Lelouch lives ?', 'Easy'),
(35, 'How did Britannia defeated japan ?', 'Easy'),
(36, 'How said "what''s the problem i''ve no time to waste it with a kid" ?', 'Easy'),
(37, 'What is cc beloved food ?', 'Easy'),
(38, 'Who''s Euphemia''s personal Knight ? ', 'Easy'),
(39, 'Who is this ?', 'Easy'),
(40, 'Who killed Shirley Fenette ?', 'Easy'),
(41, 'Who killed Lelouch ?', 'Easy'),
(42, 'Who is the right hand of Zeros'' black knights order ?', 'Easy'),
(43, 'Who is this ?', 'Easy'),
(44, 'What''s his job ?', 'Easy'),
(45, 'Who is the Lancelot  Knight?', 'Easy'),
(46, 'Who was it that had Anti Geass?', 'Hard'),
(47, 'Who did Shirley shoot when she found Zero''s gun?', 'Hard'),
(48, 'What was the name of the plan Lelouch completed?', 'Hard'),
(49, 'Who did Ohgi marry at the end of the series?', 'Hard'),
(50, 'Who replaced Nunnally as Lelouch''s sibling for a few episodes?', 'Hard'),
(51, 'Who had a crush on Lelouch?', 'Hard'),
(52, 'Who is this ?', 'Hard'),
(53, 'Who is this ?', 'Hard'),
(54, 'what is the animal always biting Suzaku ?', 'Hard'),
(55, 'Whose Lelouch''s first victim ?', 'Hard'),
(56, 'What is Lelouch''s mom''s name?', 'Hard'),
(57, 'Who Lelouch can''t defeat in chess ?', 'Hard'),
(58, 'Who told Shirley the truth about Lelouch ?', 'Hard'),
(59, 'who''s nina beloved girl ?', 'Hard'),
(60, 'What is Suzaku training dress ?', 'Hard'),
(61, 'In what city does the anime take place?', 'easy'),
(62, 'Who is this character?', 'easy'),
(63, 'Who threw this vending machine?', 'easy'),
(64, 'What does this restaurant serve?', 'easy'),
(65, 'Who uses the handle Kanra?', 'easy'),
(66, 'Who is the leader of the Dollars?', 'easy'),
(67, 'Who is this character?', 'easy'),
(68, 'What does Heiwajima Kasuka work as?', 'easy'),
(69, 'What is the name of this gang?', 'easy'),
(70, 'Where does Semyon come from?', 'easy'),
(71, 'Who uses the handle Tanaka Taro?', 'easy'),
(72, 'What color is Celty''s helmet?', 'easy'),
(73, 'What is the name of the sword that controls people?', 'easy'),
(74, 'Why does Saika cut people?', 'easy'),
(75, 'What is the name of the school?', 'easy'),
(76, 'Who is this character?', 'hard'),
(77, 'Who is this character?', 'hard'),
(78, 'Which of these is Orihara Kururi?', 'hard'),
(79, 'Who does this person work for?', 'hard'),
(80, 'Who uses the handle San?', 'hard'),
(81, 'Who is this character?', 'hard'),
(82, 'How long have they been friends?', 'hard'),
(83, 'Who is this character?', 'hard'),
(84, 'What is the name of this gang?', 'hard'),
(85, 'Who does she work for?', 'hard'),
(86, 'What does Tanaka Tom work as?', 'hard'),
(87, 'Who are the two wounded people?', 'hard'),
(88, 'How old was Shinra when he met Celty?', 'hard'),
(89, 'Which one is Chikage''s girlfriend?', 'hard'),
(90, 'Who of these is a big fan of Hijiribe Ruri?', 'hard'),
(91, 'What is the use of Scar''s right hand ?', 'Easy'),
(92, 'What is the use of Scar''s left hand ?', 'Easy'),
(93, 'Who named Edward Elric Full Metal Alchemist ?', 'Easy'),
(94, 'Why was Kimblee jailed ?', 'Easy'),
(95, 'What emrporer did Ling Yao come from ?', 'Easy'),
(96, 'Who was the first to discover King Bradely''s plan ?', 'Easy'),
(97, 'Which one of those were NOT able to use Alchemy without seals ?', 'Easy'),
(98, 'What is the power of Solf J. Kimblee ?', 'Easy'),
(99, 'What was Roy Mustang''s rank in the military ?', 'Easy'),
(100, 'What did Roy Mustang lose after being forced into the Gate of Truth ?', 'Easy'),
(101, 'What was Sloth known as ?', 'Easy'),
(102, 'What is the miltary rank gained when becoming a State Alchemist ?', 'Easy'),
(103, 'What was Van Hohenheim''s expression in the only photograph to contain the entire Elric family ?', 'Easy'),
(104, 'What price did Edward Elric pay to retrive his brother''s soul ?', 'Hard'),
(105, 'Who defeated Gluttony ?', 'Hard'),
(106, 'With whom did Alex Louis Armstrong made an instant friendship ?', 'Hard'),
(107, 'What is the name of the bio-alchemist who studied the field of chimeric research ?', 'Hard'),
(108, 'How old was Edward Elric when his mother died ?', 'Hard'),
(109, 'What was King Bradley''s candidate number before becoming Warth ?', 'Hard'),
(110, 'Who is the leader of Fort Briggs ?', 'Hard'),
(111, 'What was Van Hohenheim slave number ?', 'Hard'),
(112, 'What is Heinkel''s Chimera form ?', 'Hard'),
(113, 'What was the name of Maes Hughes''s daughter ?', 'Hard'),
(114, 'What was the name of Edward and Alphonse teacher ?', 'Hard'),
(115, 'Which country is located north of Amestris ?', 'Hard'),
(116, 'Who was the first one to injure King Bradley ?', 'Hard'),
(117, 'Which of these names is NOT his ?', 'pic(truth)'),
(118, 'Who is this ?', 'pic(lan fan'),
(119, 'What is his name ?', 'pic(panda)'),
(120, 'What is his power ? ', 'pic(Isaac M'),
(181, 'The one who motivated Hinata to play Volley ball was.........', 'Easy'),
(182, 'Hinata''s new highschool was......', 'Easy'),
(183, 'Oikawa was........... senior.', 'Easy'),
(184, 'Who was Karasuno''s libero ?', 'Easy'),
(185, 'Aoba Johsai official setter was ...........', 'Easy'),
(186, 'Karasuno''s Ace was', 'Easy'),
(187, 'Karasuno''s first practice match was aganist........', 'Easy'),
(188, 'Karasuno''s first match in the training camp was aganist........', 'Easy'),
(189, 'Karasuno''s coach is .......', 'Easy'),
(190, 'Karasuno''s setter was........', 'Easy'),
(191, 'Hinata''s shirt number was ', 'Easy'),
(192, 'Karasuno''s secind match in the inter high was aganist ......', 'Easy'),
(193, 'Dateko was known for their', 'Easy'),
(194, 'Karasunoo lost in the inter high to.........', 'Easy'),
(195, 'After losing in the inter high karasuno determined to enter the ........', 'Easy'),
(196, 'After losing in the inter high Karasuno was invited to.......', 'Hard'),
(197, 'Hinata & Kageyama got lost during the ........', 'Hard'),
(198, 'After inter high karasuno''s team was busy because they were.....', 'Hard'),
(199, 'Who was more helpful in teaching Hinata & Kageyama', 'Hard'),
(200, 'Yachi decided to join Karasuno''s team after their match with ........', 'Hard'),
(201, 'Who took Hinata & kageyama to join their team in Tokyo ?', 'Hard'),
(202, 'After arguing with Hinata Kageyama asked for help in practice from .......', 'Hard'),
(203, 'Who was the one who was able to touch Hinata''s quick ?', 'Hard'),
(204, 'Where was the training camp ?', 'Hard'),
(205, 'Tsukishima''s brother was in the same team as..........', 'Hard'),
(206, 'In Saitama they matched aganist ', 'Hard'),
(207, 'Karasuno''s first opponent in the Spring tourment was.......', 'Hard'),
(208, 'Daichi injured his leg in the match aganist ', 'Hard'),
(209, 'Before their match with Karasuno, Aoba Johsai was playing aganist.....', 'Hard'),
(210, 'Aoba Johsai double edged weapon was', 'Hard'),
(211, 'Whos Weapon Is That ?', 'PIC'),
(212, 'Whos Butler Was That ?', 'PIC'),
(213, 'Whos Is that Character?', 'PIC'),
(214, 'Where Did She First Appear?', 'PIC'),
(215, 'Who Is She ?', 'PIC'),
(216, 'What Is The Name Of this Charcter ?', 'PIC'),
(217, 'What Is She ?', 'PIC'),
(218, 'What Is This Place ?', 'PIC'),
(219, 'Who Killed Madam Red ?', 'Easy'),
(220, 'How Many Goust In The anime ?', 'Easy'),
(221, 'What Is Sebbastian Fav Animal ?', 'Easy'),
(222, 'how many butlers appeared in black butler ?', 'Easy'),
(223, 'What is the name of the company that Ciel owns ?', 'Easy'),
(224, 'Who killed the queen ?', 'Easy'),
(225, 'How many demons appeared in season 2 and?', 'Easy'),
(226, 'Who were the main members of the circus ?', 'Easy'),
(227, 'Which animal is Ciel allergic to ?', 'Easy'),
(228, 'who killed Ciel parents ?', 'Easy'),
(229, 'How many butlers do the queen have and who are they ?', 'Easy'),
(230, 'What is the name of the weapon that any shinigami have ?', 'Easy'),
(231, 'What are the letters of the contract on Sebastian''s hand ?', 'Hard'),
(232, 'What is Alois real name?', 'Hard'),
(233, 'What is Alois Brother Real Name?', 'Hard'),
(234, 'What Is The Weapon Name That Sebby Killed Claude With?', 'Hard'),
(235, 'how many contracts took place in black butler ?', 'Hard'),
(236, 'Who killed Georg von Siemens in book of murder ?', 'Hard'),
(237, 'What Is The Mark On Ciel Chest Called ?', 'Hard'),
(238, 'What is the FULL name of the indian prince?*', 'Hard'),
(239, 'What Is The Indian Prince Butler Name ?', 'Hard'),
(240, 'Who Is Paula?', 'Hard'),
(241, 'Who is the main Hero ?', 'Easy'),
(242, 'What''s Aladdin''s target ?', 'Easy'),
(243, 'Who is this ?', 'Easy'),
(244, 'Who''s always meet this woman ?', 'Easy'),
(245, 'Who is the king of sindria ?', 'Easy'),
(246, 'Who was Aladdin''s Master ?', 'Easy'),
(247, 'Who raised up Aladdin ?', 'Easy'),
(248, 'What is Morjiana''s Power ?', 'Easy'),
(249, 'What''s Morjiana''s clan ?', 'Easy'),
(250, 'Who is this ?', 'Easy'),
(251, 'Who was "Morjiana" Master ?', 'Easy'),
(252, 'Who is the headmaster for Magnostadt Academy ?', 'Easy'),
(253, 'Who is this ?', 'Easy'),
(254, 'Who is this woman ?', 'Easy'),
(255, 'Whoi s this man ?', 'Easy'),
(256, 'Who was "Aladdin" looking at ?', 'Hard'),
(257, 'Who is Aladdin''s roommate ?', 'Hard'),
(258, 'Who was Alibaba''s best friend?', 'Hard'),
(259, 'What is the first season name ?', 'Hard'),
(260, 'Who is this ?', 'Hard'),
(261, 'Who is this ?', 'Hard'),
(262, 'Which dungeon did Alibaba conquer?', 'Hard'),
(263, 'Who was Alibaba punching ?', 'Hard'),
(264, '', 'Hard'),
(265, 'Who is Hakuei''s Djinn?', 'Hard'),
(266, 'Who is this ?', 'Hard'),
(267, 'What''s matal Mogamett daughter name ?', 'Hard'),
(268, 'Who loves sinbad ?', 'Hard'),
(269, 'Who is ''Agares'' the djinn master ?', 'Hard'),
(270, 'Who is this?', 'Hard'),
(271, 'Who is the Captan of the 8th division ?', 'Easy'),
(272, 'Who is the Captain of the 13th division ?', 'Easy'),
(273, 'Who is the Captain of the 7th division ?', 'Easy'),
(274, 'What is the name of Byakuya Kuchiki bankai ?', 'Easy'),
(275, 'What is the name of Kurosaki Ichigo bankai ?', 'Easy'),
(276, 'What is the name of Renji Abarai bankai ?', 'Easy'),
(277, 'What is the powr of Tsukishima ?', 'Easy'),
(278, 'How many times did Ichigo fought Grimmjow ?', 'Easy'),
(279, 'How many realses does Ulquiorra have ?', 'Easy'),
(280, 'How did Byakuya defeat Tsukishima ? ', 'Easy'),
(281, 'How many Shinigami have dual swords shikai ?', 'Easy'),
(282, 'How many Shinigami have fire based Zanpakuto ?', 'Easy'),
(283, 'How many Shinigami have illusion based Zanpakuto ?', 'Easy'),
(284, 'Which Shinigami has a wind based Zanpakuto ?', 'Easy'),
(285, 'Which Shinigami has a water based Zanpakuto ?', 'Easy'),
(286, 'What is the element of Rukia''s Zanpakuto ?', 'Easy'),
(287, 'What was Nelliel Tu Odelschwanck rank in Espada before losing her memories ?', 'Easy'),
(288, 'How many Shinigami division are there in Soul Society ?', 'Easy'),
(289, 'Whose Zanpakuto has a release order "Shoot to kill (ikorose)" ?', 'Easy'),
(290, 'Whose Zanpakuto has a release order "Raise Your Head (omote o agero)" ?', 'Easy'),
(291, 'Whose Zanpakuto has a release order "Reduce All Creation to Ash (bansho issai kaijin to nase)" ?', 'Easy'),
(292, 'Which one of those was NOT from the team guarding the pillars in fake Karakura Town ?', 'Easy'),
(293, 'Which one of the Shinigami guarding the pillars in fake Karakura Town was defeated ?', 'Easy'),
(294, 'What is the type of Mayuri Kurotsuchi Zanpakuto ? ', 'Easy'),
(295, 'How many forms did Aizen transformed to after merging with the Hogyoku ?', 'Easy'),
(296, 'How many members were in Visored ?', 'Easy'),
(297, 'How is the leader of the Visored ?', 'Easy'),
(298, 'How many members were in Xcution (exluding Ichigo and Sado) ?', 'Easy'),
(299, 'How is the leader of the Xcution ?', 'Easy'),
(300, 'What is the name of the artificial body Urahara Kisuke invented ?', 'Easy'),
(301, 'What is the name of Jackie Tristan ability ? ', 'Hard'),
(302, 'What is the name of Moe Shishigawara ability ? ', 'Hard'),
(303, 'What is the name of Grimmjow Jaegerjaquez relaese ?', 'Hard'),
(304, 'What is the name of Ulquiorra Cifer 2nd relaese ?', 'Hard'),
(305, 'What is the name of Coyote Starrk relaese ?', 'Hard'),
(306, 'What is the rank of Zommari Rureaux in Espada ?', 'Hard'),
(307, 'What is the rank of Szayelaporro Granz in Espada ?', 'Hard'),
(308, 'What is the rank of Aaroniero Arruruerie in Espada ?', 'Hard'),
(309, 'What is the powr of Baraggan Louisenbairn ?', 'Hard'),
(310, 'What is the powr of Wonderweiss Margela ?', 'Hard'),
(311, 'Who defeated Zommari Rureaux ?', 'Hard'),
(312, 'Who defeated Nnoitra Gilga ?', 'Hard'),
(313, 'Who defeated Shawlong Koufang ?', 'Hard'),
(314, 'What is the speciality of the 4th division ?', 'Hard'),
(315, 'What is the speciality of the 11th division ?', 'Hard'),
(316, 'What is the speciality of the 9th division ?', 'Hard'),
(317, 'What is the speciality of the 2nd division ?', 'Hard'),
(318, 'What is the speciality of the 12th division ?', 'Hard'),
(319, 'Who was the first Shinigami to use his Bankai in the anime ?', 'Hard'),
(320, 'Who is the vice-captain who had a Bankai but NEVER used it ?', 'Hard'),
(321, 'Who was Ikaku Madarame fighitng when he first used his Bankai ?', 'Hard'),
(322, 'What is the name of Yasutora Sado left arm ?', 'Hard'),
(323, 'Who is the user of "Shun Shun Rikka (Six Flowers of the Hibiscus Shield) ?', 'Hard'),
(324, 'Who is the user of "Heilig Bogen (Holy Bow)" ?', 'Hard'),
(325, 'Which division is known as the model division for its strict adherence to rules ?', 'Hard'),
(326, 'Who is this ?', 'Hard pic'),
(327, 'Who is this ?', 'Hard pic'),
(328, 'Which division is this ?', 'Hard pic 1s'),
(329, 'Which division is this ?', 'Hard pic 3r'),
(330, 'Which division is this ?', 'Hard pic 5t'),
(331, 'How long does it take for the Death Note to kill if no cause of death is specified?', 'Easy'),
(332, 'What is the name of this shinigami?', 'Easy'),
(333, 'What was the name of the Shinigami that died in front of Rem?', 'Easy'),
(334, 'What was the name of L''s substitute that died on TV?', 'Easy'),
(335, 'What is the name of the FBI agent sent after Light?', 'Easy'),
(336, 'What is Mello''s favourite food?', 'Easy'),
(337, 'What is Ryuk''s favourite food?', 'Easy'),
(338, 'What did this woman work as in the past?', 'Easy'),
(339, 'What was the first cause of death Light used?', 'Easy'),
(340, 'What is the name of this character?', 'Easy'),
(341, 'What sport do Light and L play together?', 'Easy'),
(342, 'How many times does Misa make the eye of the Shinigami deal?', 'Easy'),
(343, 'What is the name of this character?', 'Easy'),
(344, 'Who of those does not make the eye of the Shinigami deal?', 'Easy'),
(345, 'Who kills Mello?', 'Easy'),
(346, 'Who kills Takada Kiyomi?', 'Easy'),
(347, 'What is the real name of Mello?', 'Easy'),
(348, 'What was the name of the third Kira?', 'Easy'),
(349, 'Who kidnapped Takimura Kanichi, and why?', 'Easy'),
(350, 'Who of those knew Light the longest?', 'Easy'),
(351, 'Who was the first person to figure out Kira''s identity?', 'Easy'),
(352, 'Where did Misa first see Light?', 'Easy'),
(353, 'Who is this character?', 'Easy'),
(354, 'What is the price of the eye of the Shinigami?', 'Easy'),
(355, 'How long does the deathnote allow you for writing the details of death ?', 'Easy'),
(356, 'What does Mikami Teru work as?', 'Hard'),
(357, 'What is the name of this character?', 'Hard'),
(358, 'What university does Light attend?', 'Hard'),
(359, 'What was the name of Light''s sister?', 'Hard'),
(360, 'What is the real name of Watari?', 'Hard'),
(361, 'Which ear does Ryuk have pierced by an earring?', 'Hard'),
(362, 'What is the name of the girl Light went on a date with when followed by the FBI?', 'Hard'),
(363, 'How old was L when he died?', 'Hard'),
(364, 'What name did L go by in university?', 'Hard'),
(365, 'L claims his concentration power drops by ___ if he sits normally.', 'Hard'),
(366, 'Who answers the first call Light makes from the phone Misa gave him?', 'Hard'),
(367, 'Who shot Yagami Light in the last episode?', 'Hard'),
(368, 'How much did the mini-TV Light hid in the potato chips pack cost? (107 Yen = 1 USD)', 'Hard');

-- --------------------------------------------------------

--
-- Table structure for table `questionquiz`
--

CREATE TABLE `questionquiz` (
  `QID` int(11) NOT NULL,
  `QuizID` int(11) NOT NULL,
  `UID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `ID` int(11) NOT NULL,
  `Score` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Fname` varchar(40) NOT NULL,
  `Lname` varchar(40) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `ResultID` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `isMale` tinyint(1) NOT NULL,
  `Facebook` varchar(100) NOT NULL,
  `Google+` varchar(40) NOT NULL,
  `QSolvedID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anime`
--
ALTER TABLE `anime`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`AID`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`QID`);

--
-- Indexes for table `questionquiz`
--
ALTER TABLE `questionquiz`
  ADD UNIQUE KEY `QID` (`QID`,`QuizID`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anime`
--
ALTER TABLE `anime`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=308;
--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `QID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=369;
--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
