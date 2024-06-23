Deacripcion de los procesos de carga:

La estructura general que utilizamos es un arbol binario que tiene como clave la fecha y como valor un hash.
Este hash tiene como clave un string que representa a los paises, y como valor tiene una clase top50, la cual tiene un atributo que es un heap con daily rank como clave y la cancion como valor

Al momento de cargar los datos se va a recorrer solo una vez el csv, y se van a ir agregando los datos linea por linea en la estructura previamente mencionada

Decisiones tomadas:

- Primero habiamos pensado en hacer un solo hash que la clave sea la suma de la fecha y el pais de la cancion. Pero decidimos separarlo con el fin de poder hacerbusquedas separadas por fecha, y si lo deseamoos despues por pais.

Consumo de memoria en cada reporte:
