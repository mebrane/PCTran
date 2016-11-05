
drop table pc_transporte;commit;

drop table pc_tipotransporte;commit;

drop table pc_marca;commit;

drop table pc_modelo;commit;

drop table pc_tipomodelo;commit;
drop table pc_usuario;


create table pc_tipomodelo( tmod_id int primary key not null, tmod_desc varchar2(50), tmod_freg date );commit;

insert into pc_tipomodelo values(1,'Tipo de Modelo 1',sysdate);commit;

insert into pc_tipomodelo values(2,'Tipo de Modelo 2',sysdate);commit;


 drop sequence pc_tipomodelo_seq;
  create sequence pc_tipomodelo_seq
  minvalue 3
  maxvalue 999999999999999999999999999
  start with 3
  increment by 1
  cache 20;
  commit;

create table pc_modelo( mode_id int primary key, tmod_id int, mode_desc varchar2(50), mode_freg date, foreign key (tmod_id) references  pc_tipomodelo(tmod_id) );commit;

insert into pc_modelo values(1,2,'Modelo 1',sysdate);commit;insert into pc_modelo values(2,1,'Modelo 2',sysdate);commit;

 drop sequence pc_modelo_seq;
  create sequence pc_modelo_seq
  minvalue 3
  maxvalue 999999999999999999999999999
  start with 3
  increment by 1
  cache 20;
  commit;

create table pc_marca( marc_id int primary key not null, marc_desc varchar2(50), marc_freg date );commit;

insert into pc_marca values(1,'Marca 1',sysdate);commit;

insert into pc_marca values(2,'Marca 2',sysdate);commit;

 drop sequence pc_marca_seq;
  create sequence pc_marca_seq
  minvalue 3
  maxvalue 999999999999999999999999999
  start with 3
  increment by 1
  cache 20;
  commit;
create table pc_tipotransporte( ttra_id int primary key not null, ttra_desc varchar2(50), ttra_freg date );commit;


insert into pc_tipotransporte values(1,'Tipo Transporte 1',sysdate);commit;

insert into pc_tipotransporte values(2,'Tipo Transporte 2',sysdate);commit;

 drop sequence pc_tipotransporte_seq;
  create sequence pc_tipotransporte_seq
  minvalue 3
  maxvalue 999999999999999999999999999
  start with 3
  increment by 1
  cache 20;
  commit;

create table pc_transporte( tran_id int primary key, ttra_id int, tran_desc varchar2(50), tran_cost decimal(10,2), tran_stoc int, mode_id int, marc_id int, tran_freg date, foreign key (ttra_id) references  pc_tipotransporte(ttra_id), foreign key (mode_id) references  pc_modelo(mode_id), foreign key (marc_id) references  pc_marca(marc_id) );commit;

insert into pc_transporte values (1,2,'Transporte 1',100.00,10,2,2,sysdate);commit;

 drop sequence pc_transporte_seq;
  create sequence pc_transporte_seq
  minvalue 2
  maxvalue 999999999999999999999999999
  start with 2
  increment by 1
  cache 20;
  commit;


create table pc_usuario
  (
    user_id   NUMBER not null ,
    user_user VARCHAR2 (30) not null ,
    user_pass VARCHAR2 (30) not null ,
    user_esta CHAR (1) not null
  );
alter table pc_usuario add constraint pc_usuario_pk primary key ( user_id ) ;
commit;

insert into pc_usuario values(1,'admin','admin','A');
commit;

 select * from pc_transporte;