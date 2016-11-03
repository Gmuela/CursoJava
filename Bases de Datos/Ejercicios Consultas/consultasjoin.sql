SELECT I.DNI,I.NOMBRE,F.NOMBRE FROM INVESTIGADORES I LEFT JOIN FACULTAD F ON I.FACULTAD=F.CODIGO;

SELECT I.NOMBRE,E.NUMSERIE,E.NOMBRE,F.NOMBRE 
FROM RESERVA R 
LEFT JOIN INVESTIGADORES I ON I.DNI=R.DNI 
LEFT JOIN EQUIPOS E ON R.DNI=I.DNI AND R.NUMSERIE=E.NUMSERIE 
LEFT JOIN FACULTAD F ON F.CODIGO=E.FACULTAD 
WHERE I.NOMBRE='MARIA';


SELECT I.DNI AS DNI_INVESTIGADOR,I.NOMBRE AS NOMBRE_INVESTIGADOR,F.NOMBRE AS NOMBRE_FACULTAD,E.NUMSERIE,E.NOMBRE AS NOMBRE_EQUIPO,F.NOMBRE AS NOMBRE_FACULTAD_EQUIPO,R.COMIENZO,R.FIN 
FROM RESERVA R 
LEFT JOIN INVESTIGADORES I ON I.DNI=R.DNI 
LEFT JOIN EQUIPOS E ON E.NUMSERIE=R.NUMSERIE, 
FACULTAD F WHERE F.CODIGO=I.FACULTAD AND F.CODIGO=E.FACULTAD;