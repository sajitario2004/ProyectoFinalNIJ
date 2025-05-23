DROP DATABASE IF EXISTS Inazuma;
CREATE DATABASE Inazuma;
use Inazuma;

create table Jugador(
id_jugador int primary key , 
nombre varchar(50),
equipo varchar(50),
posicion varchar(50),
genero varchar(50),
elemento varchar(50)
);

create table Historial(
id_historial int  primary key , 
nombre_usuario varchar(50) ,  
intentos int 
);

Insert into Jugador values
(1,"Mark Evans", "Raimon", "PT", "Masculino", "Tierra"),
(2,"Nathan Swift", "Raimon", "DF", "Masculino", "Aire"),
(3, "Jack Wallside", "Raimon", "DF", "Masculino", "Tierra"),
(4, "Jim Wraith", "Raimon", "DF", "Masculino", "Bosque"),
(5, "Tod Ironside", "Raimon", "DF", "Masculino", "Tierra"),
(6, "Steve Grim", "Raimon", "MD", "Masculino", "Fuego"),
(7, "Timmy Saunders", "Raimon", "MD", "Masculino", "Bosque"),
(8, "Sam Kincaid", "Raimon", "MD", "Masculino", "Neutro"),
(9, "Axel Blaze", "Raimon", "DL", "Masculino", "Fuego"),
(10, "Kevin Dragonfly", "Raimon", "DL", "Masculino", "Aire"),
(12, "William Glass", "Raimon", "DL", "Masculino", "Aire"),
(13, "Bobby Shearer", "Raimon", "DF", "Masculino", "Bosque"),
(14, "Jude Sharp", "Raimon", "MD", "Masculino", "Neutro"),
(15, "Erik Eagle", "Raimon", "MD", "Masculino", "Aire"),
(16, "Shawn Frost", "Raimon", "DL", "Masculino", "Aire"),
(17, "Austin Hobbes", "Raimon", "DL", "Masculino", "Fuego"),
(18, "Darren LaChance", "Raimon", "PT", "Masculino", "Fuego"),
(19, "Hurley Kane", "Raimon", "DF", "Masculino", "Aire"),
(20, "Scotty Banyan", "Raimon", "DF", "Masculino", "Bosque"),
(21, "Suzette Hartland", "Raimon", "DL", "Femenino", "Bosque"),
(22, "Tory Farrell", "Raimon", "DF", "Masculino", "Tierra"),
(23, "Shawn Frost", "Raimon", "DL", "Masculino", "Aire"),
(24, "Byron Love", "Zeus", "DL", "Masculino", "Aire"),
(25, "Joseph King", "Royal Academy", "PT", "Masculino", "Fuego"),
(26, "Peter Drent", "Royal Academy", "DF", "Masculino", "Tierra"),
(27, "Ben Simmons", "Royal Academy", "DF", "Masculino", "Aire"),
(28, "Alan Master", "Royal Academy", "DF", "Masculino", "Neutro"),
(29, "Gus Martin", "Royal Academy", "DF", "Masculino", "Bosque"),
(30, "Herman Waldon", "Royal Academy", "MD", "Masculino", "Tierra"),
(31, "John Bloom", "Royal Academy", "MD", "Masculino", "Bosque"),
(32, "Derek Swing", "Royal Academy", "MD", "Masculino", "Aire"),
(33, "Daniel Hatch", "Royal Academy", "DL", "Masculino", "Fuego"),
(34, "David Samford", "Royal Academy", "DL", "Masculino", "Neutro"),
(35, "Caleb", "Royal Academy", "MD", "Masculino", "Neutro"),
(36, "Nathan Jones", "Occult", "PT", "Masculino", "Bosque"),
(37, "Russell Walk", "Occult", "DF", "Masculino", "Tierra"),
(38, "Jason Jones", "Occult", "DF", "Masculino", "Bosque"),
(39, "Ken Furan", "Occult", "DF", "Masculino", "Tierra"),
(40, "Jerry Fulton", "Occult", "DF", "Masculino", "Bosque"),
(41, "Ray Mannings", "Occult", "MD", "Masculino", "Aire"),
(42, "Robert Mayer", "Occult", "MD", "Masculino", "Tierra"),
(43, "Alexander Brave", "Occult", "MD", "Masculino", "Bosque"),
(44, "Johan Tassman", "Occult", "DL", "Masculino", "Neutro"),
(45, "Troy Moon", "Occult", "MD", "Masculino", "Aire"),
(46, "Burt Wolf", "Occult", "MD", "Masculino", "Fuego"),
(47, "Charlie Boardfield", "Wild", "PT", "Masculino", "Tierra"),
(48, "Hugo Talgeese", "Wild", "MD", "Masculino", "Aire"),
(49, "Wilson Fishman", "Wild", "DF", "Masculino", "Bosque"),
(50, "Peter Jonhson", "Wild", "DF", "Masculino", "Bosque"),
(51, "Leonard O'Shea", "Wild", "DF", "Masculino", "Fuego"),
(52, "Cham Lion", "Wild", "MD", "Masculino", "Bosque"),
(53, "Steve Eagle", "Wild", "MD", "Masculino", "Aire"),
(54, "Bruce Monkey", "Wild", "MD", "Masculino", "Bosque"),
(55, "Gary Lancaster", "Wild", "DL", "Masculino", "Tierra"),
(56, "Harry Snake", "Wild", "DL", "Masculino", "Bosque"),
(57, "Adrian Speed", "Wild", "DL", "Masculino", "Aire"),
(58, "Thomas Feldt", "Brain", "PT", "Masculino", "Neutro"),
(59, "Harry Leading", "Brain", "DF", "Masculino", "Aire"),
(60, "Terry Stronger", "Brain", "DF", "Masculino", "Tierra"),
(61, "Philip Marvel", "Brain", "DF", "Masculino", "Neutro"),
(62, "Noel Good", "Brain", "DF", "Masculino", "Bosque"),
(63, "Tyron Rock", "Brain", "MD", "Masculino", "Tierra"),
(64, "Francis Tell", "Brain", "MD", "Masculino", "Aire"),
(65, "Samuel Buster", "Brain", "MD", "Masculino", "Fuego"),
(66, "Jonathan Seller", "Brain", "DL", "Masculino", "Neutro"),
(67, "Victor Kind", "Brain", "MD", "Masculino", "Bosque"),
(68, "Neil Turner", "Brain", "DL", "Masculino", "Aire"),
(69, "Sam Idol", "Otaku", "PT", "Masculino", "Aire"),
(70, "Marcus Train", "Otaku", "DF", "Masculino", "Tierra"),
(71, "Light Nobel", "Otaku", "MD", "Masculino", "Bosque"),
(72, "Walter Valiant", "Otaku", "MD", "Masculino", "Fuego"),
(73, "Spencer Gates", "Otaku", "DF", "Masculino", "Neutro"),
(74, "Isabelle Trick", "Génesis", "MD", "Femenino", "Aire"),
(75, "Gaby Farmer", "Otaku", "DL", "Masculino", "Tierra"),
(76, "Victoria Vanguard", "Raimon", "MD", "Femenino", "Aire"),
(77, "Gus Gamer", "Otaku", "DL", "Masculino", "Aire"),
(78, "Mark Gambling", "Otaku", "DL", "Masculino", "Bosque"),
(79, "Theodore Master", "Otaku", "DL", "Masculino", "Fuego"),
(80, "Albert Green", "Farm", "PT", "Masculino", "Tierra"),
(81, "Apollo Light", "Zeus", "DF", "Masculino", "Bosque"),
(82, "Artie Mishamn", "Zeus", "MD", "Masculino", "Aire"),
(83, "Wesley Knox", "Zeus", "MD", "Masculino", "Bosque"),
(84, "Harry Closs", "Zeus", "DF", "Masculino", "Fuego"),
(85, "Jonas Demetrius", "Zeus", "DL", "Masculino", "Fuego"),
(86, "Henry House", "Zeus", "MD", "Masculino", "Fuego"),
(87, "Lane War", "Zeus", "DF", "Masculino", "Montaña"),
(88, "Ned Yousef", "Zeus", "MD", "Masculino", "Montaña"),
(89, "Jeff Iron", "Zeus", "DF", "Masculino", "Fuego"),
(90, "Gus Heeley", "Zeus", "DL", "Masculino", "Montaña"),
(91, "Morgan Sanders", "Ninja", "PT", "Masculino", "Bosque"),
(92, "Newton Flust", "Ninja", "DF", "Masculino", "Aire"),
(93, "Jim Hillfort", "Ninja", "DF", "Masculino", "Tierra"),
(94, "Galen Thunderbird", "Ninja", "DF", "Masculino", "Aire"),
(95, "Finn Stoned", "Ninja", "DF", "Masculino", "Fuego"),
(96, "Phil Wingate", "Ninja", "MD", "Masculino", "Neutro"),
(97, "Jez Shell", "Ninja", "MD", "Masculino", "Aire"),
(98, "Jupiter Jumper", "Ninja", "MD", "Masculino", "Tierra"),
(99, "Sam Samurai", "Ninja", "DL", "Masculino", "Bosque"),
(100, "Hank Sullivan", "Ninja", "MD", "Masculino", "Bosque");