
drop table pc_Transporte; commit;

drop table pc_TipoTransporte; commit;

drop table pc_Marca; commit;

drop table pc_Modelo; commit;

drop table pc_TipoModelo; commit;
drop table pc_usuario;


create table pc_TipoModelo( tmod_id int primary key not null, tmod_desc varchar2(50), tmod_freg date ); commit;

insert into pc_TipoModelo values(1,'Tipo de Modelo 1',sysdate); commit;

insert into pc_TipoModelo values(2,'Tipo de Modelo 2',sysdate); commit;


 drop sequence pc_TipoModelo_seq;
  CREATE SEQUENCE pc_TipoModelo_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;

create table pc_Modelo( mode_id int primary key, tmod_id int, mode_desc varchar2(50), mode_freg date, foreign key (tmod_id) references  pc_TipoModelo(tmod_id) ); commit;

insert into pc_Modelo values(1,2,'Modelo 1',sysdate); commit; insert into pc_Modelo values(2,1,'Modelo 2',sysdate); commit;

 drop sequence pc_Modelo_seq;
  CREATE SEQUENCE pc_Modelo_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;

create table pc_Marca( marc_id int primary key not null, marc_desc varchar2(50), marc_freg date ); commit;

insert into pc_Marca values(1,'Marca 1',sysdate); commit;

insert into pc_Marca values(2,'Marca 2',sysdate); commit;

 drop sequence pc_Marca_seq;
  CREATE SEQUENCE pc_Marca_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
create table pc_TipoTransporte( ttra_id int primary key not null, ttra_desc varchar2(50), ttra_freg date ); commit;


insert into pc_TipoTransporte values(1,'Tipo Transporte 1',sysdate); commit;

insert into pc_TipoTransporte values(2,'Tipo Transporte 2',sysdate); commit;

 drop sequence pc_TipoTransporte_seq;
  CREATE SEQUENCE pc_TipoTransporte_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;

create table pc_Transporte( tran_id int primary key, ttra_id int, tran_desc varchar2(50), tran_cost decimal(5,2), tran_stoc int, mode_id int, marc_id int, tran_freg date, foreign key (ttra_id) references  pc_TipoTransporte(ttra_id), foreign key (mode_id) references  pc_Modelo(mode_id), foreign key (marc_id) references  pc_Marca(marc_id) ); commit;

insert into pc_Transporte values (1,2,'Transporte 1',100.00,10,2,2,sysdate); commit;

 drop sequence pc_Transporte_seq;
  CREATE SEQUENCE pc_Transporte_seq
  MINVALUE 2
  MAXVALUE 999999999999999999999999999
  START WITH 2
  INCREMENT BY 1
  CACHE 20;
  commit;


CREATE TABLE PC_USUARIO
  (
    user_id   NUMBER NOT NULL ,
    user_user VARCHAR2 (30) NOT NULL ,
    user_pass VARCHAR2 (30) NOT NULL ,
    user_esta CHAR (1) NOT NULL
  );
ALTER TABLE PC_USUARIO ADD CONSTRAINT PC_USUARIO_PK PRIMARY KEY ( user_id ) ;
commit;

insert into pc_usuario values(1,'admin','admin','A');
commit;

 select * from pc_transporte;