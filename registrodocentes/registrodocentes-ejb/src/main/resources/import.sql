INSERT INTO T_FACULTAD (ID_FACULTAD, NOMBRE) VALUES ('1', 'Ingenieria');
INSERT INTO T_FACULTAD (ID_FACULTAD, NOMBRE) VALUES ('2', 'Administracion');
INSERT INTO T_FACULTAD (ID_FACULTAD, NOMBRE) VALUES ('3', Diseño y comm);
INSERT INTO t_rol (ID_ROL, DESCRIPCION) VALUES ('1', 'SUPERADMIN');
INSERT INTO t_rol (ID_ROL, DESCRIPCION) VALUES ('2', 'DOCENTE');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (1,'Login','PAGINA','/login.html');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (2,'Menu','PAGINA','/menu.html');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (3,'Registro','PAGINA','#/aprobar-registro');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (4,'Asignar Acceso','PAGINA','#/AsignarAcceso');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (5,'Asignaturas','PAGINA','#/Asignaturas');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (6,'Rol','PAGINA','#/crearRol');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (7,'Programas','PAGINA','#/programasDocentes');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (8,'Registros','PAGINA','#/registros');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (9,'Registros Semestres Anteriores','PAGINA','#/RegSemAnteriores');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (10,'Reporte Registros','PAGINA','#/ReporteRegistros');
INSERT INTO t_acceso (ID_ACCESO,NOMBRE,tipoacceso,URL) VALUES (11,'Semestre','PAGINA','#/Semestre');
INSERT INTO t_rol (ID_ROL,DESCRIPCION) VALUES (1,'ADMINISTRADOR');
INSERT INTO t_usuario (ID_USUARIO,APELLIDO,NOMBRE,PASS,USUARIO) VALUES(1,'APELLIDO_UNO','NOMBRE_UNO','81dc9bdb52d04dc20036dbd8313ed055','ADMIN');
INSERT INTO t_usuario_rol (ID_ROL,ID_USUARIO) VALUES (1,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (1,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (2,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (3,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (4,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (5,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (6,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (7,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (8,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (9,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (10,1);
INSERT INTO t_acceso_rol (ID_ACCESO,ID_ROL) VALUES (11,1);