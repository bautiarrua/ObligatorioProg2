# Deacripcion de los procesos de carga:

La estructura general que utilizamos es un arbol binario que tiene como clave la fecha y como valor un hash.
Este hash tiene como clave un string que representa a los paises, y como valor tiene una clase top50, la cual tiene un atributo que es un heap con daily rank como clave y la cancion como valor

Al momento de cargar los datos se va a recorrer solo una vez el csv, y se van a ir agregando los datos linea por linea en la estructura previamente mencionada
Utilizamos el buffer reader para poder leer el csv, y separamos los datos por: ","

# Decisiones tomadas:

- Primero habiamos pensado en hacer un solo hash que la clave sea la suma de la fecha y el pais de la cancion. Pero decidimos separarlo con el fin de poder hacer busquedas separadas por fecha, y si lo deseamoos despues por pais.
- Los tops 50 de cada pais en una fecha dada estan cuardados en un heap con daily rank como clave y la cancion como valor. Esto debido a que de esta forma, obtener un top n, solo hay que eliminar el primer elemento del heap n veces e ir guardandolos en una lista.
- Los artistas tienen un atributo contador, el cual es util para hacer la funcion Top_7_artistas(), ya que cada vez que se hace una aparicion de este artista se le suma 1 al contador. y al final se agrega todos los artistas a un heap ordenado por el contador.
- La idea detras de hacer un arbol binario con fecha como clave, era que nos quede más facil obtener datos en un rango de fechas dado. Sin embargo, nos dimos cuenta que quizas la mejor opcion era utilizar un hash, pero ya no nos daba el tiempo a cambiarlo.
- Justificacion O(n)??????

# Consumo de memoria en cada reporte:

- carga de datos
Tiempo : 7,2s
Memoria: 244mb

- Top_10_canciones()
Tiempo : 6ms
Memoria: 0mb

- Top_5_canciones()
Tiempo : 42ms
Memoria: 1mb

- Top_7_artistas()
Tiempo : 5s
Memoria: 38mb

- cant_art()
Tiempo : 3ms
Memoria: 0mb

- cant_canc_tempo()
Tiempo : 480ms
Memoria: 25mb


