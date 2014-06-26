-- Links
http://localhost:8080/controle-veterinario/index.jsp
http://localhost:8080/controle-veterinario/produtos/index.html
http://localhost:8080/controle-veterinario/produtos/form.html
http://localhost:8080/controle-veterinario/produtos/listar.html
http://localhost:8080/controle-veterinario/produtos/editar.html?id=1
http://localhost:8080/controle-veterinario/produtos/mostrar/1.html
=====================================================================================================================
-- Usuarios MySql
user: root
password: admin123
=====================================================================================================================
-- Script SQL
CREATE DATABASE `controle`;

CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(450) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `produtoIdFK_idx` (`produto_id`),
  CONSTRAINT `produtoIdFK` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

CREATE TABLE `grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `filial` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `usuario_grupo` (
  `Usuario_id` bigint(20) NOT NULL,
  `grupos_id` bigint(20) NOT NULL,
  UNIQUE KEY `grupos_id` (`grupos_id`),
  KEY `FK7A8B07D8724017BE` (`Usuario_id`),
  KEY `FK7A8B07D8A154727D` (`grupos_id`),
  CONSTRAINT `FK7A8B07D8A154727D` FOREIGN KEY (`grupos_id`) REFERENCES `grupo` (`id`),
  CONSTRAINT `FK7A8B07D8724017BE` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ;
=======================================================================================================================
insert into fj27.usuario (id, filial, login, senha) values (1,'1','camila','12');
insert into fj27.grupo (id, nome) values (1,'ROLE_USER');
insert into fj27.usuario_grupo (usuario_id, grupos_id) values (1,1);
=======================================================================================================================