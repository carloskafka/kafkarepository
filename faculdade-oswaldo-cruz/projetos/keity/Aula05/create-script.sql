use foc;

CREATE TABLE `aluno` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`nome` varchar(45) DEFAULT NULL,
`endereco` varchar(45) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1
DEFAULT CHARSET=latin1;

SELECT * FROM aluno;
