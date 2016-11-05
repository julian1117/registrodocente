INSERT INTO T_FACULTAD (ID_FACULTAD, NOMBRE) VALUES ('1', 'Ingenieria');
INSERT INTO T_FACULTAD (ID_FACULTAD, NOMBRE) VALUES ('2', 'Administracion');
INSERT INTO T_ROL (ID_ROL, DESCRIPCION) VALUES (1, 'SUPERADMIN');
INSERT INTO T_ROL (ID_ROL, DESCRIPCION) VALUES (2, 'DOCENTE');
INSERT INTO T_ROL (ID_ROL, DESCRIPCION) VALUES (3,'ADMINISTRADOR');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (1,'Login','PAGINA','/login.html');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (2,'Menu','PAGINA','/menu.html');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (3,'Registro','PAGINA','#/aprobar-registro');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (4,'Asignar Acceso','PAGINA','#/AsignarAcceso');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (5,'Asignaturas','PAGINA','#/asignaturas');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (6,'Rol','PAGINA','#/CrearRol');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (7,'Programas','PAGINA','#/programasDocentes');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (8,'Registros','PAGINA','#/registros');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (9,'Registros Semestres Anteriores','PAGINA','#/RegSemAnteriores');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (10,'Reporte Registros','PAGINA','#/ReporteRegistros');
INSERT INTO T_ACCESO (ID_ACCESO,NOMBRE,TIPOACCESO,URL) VALUES (11,'Semestre','PAGINA','#/Semestre');
INSERT INTO T_USUARIO (ID_USUARIO,APELLIDO,NOMBRE,PASS,USUARIO) VALUES(1,'APELLIDO_UNO','NOMBRE_UNO','81dc9bdb52d04dc20036dbd8313ed055','ADMIN');
INSERT INTO T_USUARIO_ROL (ID_ROL,ID_USUARIO) VALUES (1,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (1,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (2,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (3,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (4,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (5,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (6,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (7,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (8,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (9,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (10,1);
INSERT INTO T_ACCESO_ROL (ID_ACCESO,ID_ROL) VALUES (11,1);
INSERT INTO T_PROGRAMA (ID_PROGRAMA,NOMBRE,ID_FACULTAD) VALUES ('1','Ing Software','1');
INSERT INTO T_PROGRAMA (ID_PROGRAMA,NOMBRE,ID_FACULTAD) VALUES ('2', 'Ing Mecatronica', '1');
INSERT INTO T_DOCENTE (ID_USUARIO, ID_PROGRAMA) VALUES ('1', '1');
INSERT INTO T_ASIGNATURA (ID_ASIGNATURA, Nombre, ID_PROGRAMA) VALUES ('1', 'Calculo', '1');
INSERT INTO T_ASIGNATURA (ID_ASIGNATURA, Nombre, ID_PROGRAMA) VALUES ('2', 'Programacion', '1');
INSERT INTO T_SEMESTRE (anho, periodo, fecha_inicio)VALUES ('2016', '2', '2016-01-01');
INSERT INTO T_SEMESTRE (anho, periodo, fecha_inicio)VALUES ('2015', '1', '2015-08-15');
INSERT INTO T_CURSO (ID_CURSO, GRUPO, asignatura, docente, semestre_anho, semestre_periodo) VALUES ('2', 'B', '1', '1', '2015','1');