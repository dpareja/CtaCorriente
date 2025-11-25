# language: es
Característica: Búsqueda de empleos en IPLACEX

  Escenario: Buscar empleo de Ingeniero en Informática
    Dado que el usuario está en la página "www.iplacex.cl"
    Cuando selecciona la pestaña "ALUMNOS"
    Y selecciona la opción "Empleos"
    Y selecciona una región
    Y introduce "Ingeniero en Informática" en el campo de búsqueda
    Entonces debe mostrar los resultados de empleos disponibles
