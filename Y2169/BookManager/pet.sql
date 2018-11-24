/*
SQLyog v10.2 
MySQL - 5.6.24 : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `books`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookid` INT(32) NOT NULL AUTO_INCREMENT,
  `bookname` VARCHAR(32) NOT NULL,
  `bookcategory` INT(11) NOT NULL,
  `bookprice` DOUBLE NOT NULL,
  `bookauthor` VARCHAR(32) NOT NULL,
  `bookabout` VARCHAR(200) NOT NULL,
  `bookdatetime` DATE NOT NULL,
  `bookpicture` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

INSERT  INTO `book`(`bookid`,`bookname`,`bookcategory`,`bookprice`,`bookauthor`,`bookabout`,`bookdatetime`,`bookpicture`) VALUES (1,'活着',2,15,'余华','《活着》讲述了人如何去承受巨大的苦难；讲述了眼泪的宽广和丰富；讲述了绝望的不存在；讲述了人是为了活着本身而活着的，而不是为了活着之外的任何事物而活着。','2012-08-01','huozhe.jpg'),(2,'白夜行',2,41.1,'东野圭吾','我一直走在白夜里，从来就没有太阳，所以不怕失去','2017-08-09','baiyexing.jpg'),(3,'茶馆',2,11.5,'老舍','在老北京大茶馆、大杂院中，体会社会的变迁，展现芸芸众生，人间百态。京味十足，京腔满堂。话剧大师曹禺先生曾评价《茶馆》说：一句台词一个人物，演绎可感可叹的悲喜人生；一爿茶馆一个社会','2017-03-24','chaguan.jpg'),(4,'史记',1,260,'司马迁','《史记》是我国首部通史，是“二十四史”中zui早的一部，也是zui重要的一部史书。全书共一百三十篇。《史记》叙事，始自黄帝，下迄西汉太初，采用了综合性的叙事模式，囊括记言、纪事、编年、国别等形式，开创纪传体史书“纪、传、表、志”的体例。就内容而言，《史记》是对前代史学的一次总结；就体例而言，《史记》也是集大成之作。','2014-09-04','shiji.jpg'),(5,'全球通史',1,132.7,'（英）威尔斯','《全球通史》由斯塔夫里阿诺斯著，吴象婴、梁赤民、董书慧、王昶译，作者在本书中采用全新的史学观点和方法，将整个世界看作一个不可分割的有机的统一体，从全球的角度而不是从某一国家或某一地区的角度来考察世界各地区人类文明的产生和发展，把研究重点放在对人类历史进程有重大影响的诸历史运动、诸历史事件和它们之间的相互关联和相互影响上，努力反映局部与整体的对抗以及它们之间的相互作用。','2012-02-02','quanqiutongshi.jpg'),(6,'北欧众神',4,33,'（英）尼尔·盖曼','雷神托尔的锤子来自何处？诸神之父奥丁为何失去一只眼睛？亦正亦邪的洛基究竟是什么身份？诞生两千年来，历经多次演绎，北欧神话的本源已越来越模糊。而今，幻想文学大师尼尔·盖曼厘清了北欧神话的脉络，以全新的笔法，再现了这一辉煌壮丽的神话体系。从世界之树到九大世界，从一切的诞生到诸神的黄昏，从青春的金苹果到巨狼芬尼尔……在盖曼笔下，故事重获新生，众神逐个复活。','2018-09-09','beiouzongshen.jpg'),(7,'西游记',3,23.6,'吴承恩','《西游记》以丰富瑰奇的想象描写了师徒四众在去往西方途上，和穷山恶水冒险斗争的历程，并将所经历的千难万险形象化为妖魔鬼怪所设置的八十一难，以动物幻化有情的精怪生动地表现了无情的山川的险阻。以降妖伏魔，歌赞了取经人排除艰难的战斗精神，鼓舞人积极斗争、永不灰心、为达到目标而百折不挠。 ','2005-11-11','xiyouji.jpg'),(8,'水浒传',3,25.6,'施耐庵','《水浒传》是一部是一部有审美价值和社会意义的中国优秀长篇小说。自问世以来倍受文人的称赞，也为广大人民群众所喜爱。有人说：“别一部书，看过一遍既休。独有《水浒传》只是看不厌。无非为他把一百八人性格都写出来。《水浒传》所叙，叙一百八人，人有其性情，人有其气质，人有其其形状，人有其声口。”《水浒传》突出地表现在英雄人物的塑造上。在书中至少出现了几十个个性鲜明的典型形象，这些形象有血有肉，栩栩如生，跃然纸','2016-07-06','shuihuzhuan.jpg'),(9,'我不',4,39.9,'大冰','善意能消戾，善意能得缘，善意能带业往生，善意能回头是岸。 善意能够帮人捕捉并建立起独特的幸福感。','2017-09-01','wobu.jpg'),(10,'人生三书',4,216,'毕淑敏、安德烈',' 跨三代共读的人生之书——龙应台“人生三书”《孩子你慢慢来》、《亲爱的安德烈》、《目送》，六一少儿十大推荐好书，世界读书日推荐好书。','2015-06-11','renshengsanshu.jpg');

/*Table structure for table `bookcategory` */

DROP TABLE IF EXISTS `bookcategory`;

CREATE TABLE `bookcategory` (
  `cateid` INT(10) NOT NULL AUTO_INCREMENT,
  `catename` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `bookcategory` */

INSERT  INTO `bookcategory`(`cateid`,`catename`) VALUES (1,'国家历史'),(2,'名家作品'),(3,'四大名著'),(4,'小说 ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


