# TP-SD

El siguiente trabajo práctico viene dedicado a la materia de **"Sistemas Distribuidos"**, el mismo, se trata sobre el montaje de un simulador de ambiente **"Cliente/Servidor"** a través de **Sockets TCP** en **JAVA**.

## Encargado e Integrantes del Trabajo de grupo

**Catedrático**:

[Ing. Fernando Mancía Zelaya](https://github.com/fmancia)

**Integrantes**:

-   [Sergio Nicolás Espínola Bogado](https://github.com/nicolasespinola)
-   [Valentina María Cano Lopez](https://github.com/valenticanol99)
-   [Emilio Ginzo Benítez](https://github.com/EmilioGinzo)
-   [Marco Aurelio Acosta Posadas](https://github.com/MarcoAurelioAcosta)
-   [Jorge González](https://github.com/jorgegonzab)

## Ejecución del Sistema Distribuido

**Modo de Ejecución:**

A través del IDE [Eclipse](https://www.eclipse.org/ide/) se compila/ejecuta el trabajo de la siguiente manera:

1. Importar el proyecto al IDE desde el directorio donde se clonó el repositorio.
2. Abrir el archivo **TCPMultiServer.java**, el mismo se encuentra en el siguiente directorio del proyecto:

```bash
../src/main/java/py/una/Server/TCP/TCPMultiServer.java
```

3. Presionar **_CTRL+11_** en Windows, para ejecutar el servidor.
    > Nota: El ícono: ▶ permite ejecutar sin necesidad de combinación de teclas, a través de otros sistemas operativos o en el mismo Windows.
4. Una vez iniciado el servidor, se procede a ejecutar el archivo **TCPClient.java**, el mismo se encuentra en el siguiente directorio del proyecto:

```bash
../src/main/java/py/una/Client/TCPClient.java
```

## Modo de Uso:

Se desplegará una interfaz gráfica, donde se muestran las operaciones que pueden realizarse a través del Sistema Distribuido.

1. **Agregar Cama**: Se escoge un hospital, y luego se introduce un código de cama, para la cama que será agregada. Ej.: Se selecciona **_Hospital de Clínicas_** y se agrega una cama con código: **_Cama_001_**
2. **Eliminar Cama**: Se escoge un hospital, y luego se introduce un código de cama, para la cama que será eliminada. Ej.: Se selecciona **_Hospital de Clínicas_** y se escoge una cama con código: **_Cama_001_** para ser borrada.
3. **Ocupar Cama**: Se escoge un hospital, y luego se introduce un código de cama, para la cama que será ocupada. Ej.: Se selecciona **_Hospital de Clínicas_** y se escoge una cama con código: **_Cama_001_** para ser ocupada.
4. **Desocupar Cama**: Se escoge un hospital, y luego se introduce un código de cama, para la cama que será desocupada. Ej.: Se selecciona **_Hospital de Clínicas_** y se escoge una cama con código: **_Cama_001_** para ser desocupada.
5. **Ver Estado**: Se escoge un hospital, luego se desplegará una ventana donde mostrará las camas, con **Ocupación 0**, si está **_libre_**, con **Ocupación 1**, si está **_ocupada_**.

Obs.: Una vez realizadas las operaciones se guardará un registro de las actividades que realizó a través del Cliente, en la Interfaz Gráfica. El siguiente registro se guarda en un archivo denominado **log.txt** en el siguiente directorio:

```bash
../src/main/java/py/una/Server/log.txt
```

## Documentación
**Clase Cama**

Nombre función: ***getCodeCama()***
Parametros:
Ninguno
Retorno:
String cod_cama
Acción:
Retorna el código o id del objeto cama

Nombre función: ***setCodeCama()***
Parametros:
String cod_cama
Retorno:
Ninguno
Acción:
Actualiza o setea el código o id del objeto Cama

Nombre función: ***getOcupacion()***
Parametros:
Ninguno
Retorno:
Int ocupacion 
Acción:
Retorna el valor del atributo ocupación del objeto Cama

Nombre función: ***setOcupacion()***
Parametros:
Int ocupacion 
Retorno:
Ninguno
Acción:
Actualiza o setea el atributo ocupación del objeto Cama

**Clase JSON**


Nombre función: ***getCodMensaje()***
Parametros:
Ninguno
Retorno:
String cod_mensaje
Acción:
Retorna el código del mensaje del objeto JSON

Nombre función: ***setCodMensaje()***
Parametros:
String cod_mensaje
Retorno:
Ninguno
Acción:
Actualiza o setea el código del mensaje del objeto JSON


Nombre función: ***getTipoOperacion()***
Parametros:
Ninguno
Retorno:
String tipo_operacion
Acción:
Retorna la operación que quedó registrada en el objeto JSON

Nombre función: ***setTipoOperacion()***
Parametros:
String tipo_operacion
Retorno:
Ninguno
Acción:
Actualiza o setea la operación correspondiente al objeto JSON

Nombre función: ***getHospital()***
Parametros:
Ninguno
Retorno:
String hospital o NULL
Acción:
Retorna el código del hospital en caso de que se requiera alguna acción especifica sobre un cierto hospital o nulo, en caso de que la acción sea genérica



Nombre función: ***setHospital()***
Parametros:
String hospital
Retorno:
Ninguno
Acción:
Actualiza o setea el código del hospital en caso de que se requiera alguna acción especifica sobre un cierto hospital

Nombre función: ***getCama()***
Parametros:
Ninguno
Retorno:
String cama o NULL
Acción:
Retorna el código de la cama en caso de que se requiera alguna acción especifica sobre una cierta cama o nulo, en caso de que la acción sea genérica

Nombre función: ***setCama()***
Parametros:
String Cama
Retorno:
Ninguno
Acción:
Actualiza o setea el código de la cama en caso de que se requiera alguna acción especifica sobre una cierta cama


Nombre función: ***getEstado()***
Parametros:
Ninguno
Retorno:
Int estado
Acción:
Retorna el estado del mensaje del objeto JSON

Nombre función: ***setEstado()***
Parametros:
Int estado
Retorno:
Ninguno
Acción:
Actualiza o setea el estado del mensaje del objeto JSON

Nombre función: ***getMensaje()***
Parametros:
Ninguno
Retorno:
String mensaje
Acción:
Retorna el mensaje relacionado al estado y el tipo de operación del objeto JSON

Nombre función: ***setMensaje()***
Parametros:
String Mensaje
Retorno:
Ninguno
Acción:
Actualiza o setea el mensaje relacionado al estado y el tipo de operación del objeto JSON

**Clase Hospital**


Nombre función: ***getCodHospital()***
Parametros:
Ninguno
Retorno:
String cod_hospital
Acción:
Retorna el código del hospital correspondiente al objeto Hospital

Nombre función: ***setCodHospital()***
Parametros:
String cod_hospital
Retorno:
Ninguno
Acción:
Actualiza o setea el código del hospital correspondiente al objeto Hospital





Nombre función: ***getCama()***
Parametros:
String cod_cama
Retorno:
Objeto Cama o NULL
Acción:
Retorna el objeto Cama buscado dentro del listado de Camas correspondiente al objeto Hospital en caso de que este exista exista, caso contrario retorna nulo.

Nombre función: ***findCama()***
Parametros:
String cod_cama
Retorno:
Boolean TRUE o FALSE
Acción:
Retorna TRUE en caso de que el Objeto cama buscado dentro del listado de Camas correspondiente al objeto Hospital exista, caso contrario retorna nulo

Nombre función: ***addNewCama()***
Parametros:
String cod_cama
Retorno:
Ninguno
Acción:
Crea un nuevo objeto Cama, en caso de que este no exista, dentro del listado de camas correspondiente al objeto Hospital


Nombre función: ***removeCama()***
Parametros:
String cod_cama
Retorno:
Ninguno
Acción:
Elimina el objeto Cama, en caso de que este exista y se encuentre desocupada, del listado de camas correspondiente al objeto Hospital

Nombre función: ***ocuparCama()***
Parametros:
Ninguno
Retorno:
Ninguno
Acción:
Coloca el atributo del objeto Cama en 1, en caso de que el objeto exista y el atributo sea distinto a 1.

Nombre función: ***desocuparCama()***
Parametros:
Ninguno
Retorno:
Ninguno
Acción:
Coloca el atributo del objeto Cama en 0, en caso de que el objeto exista y el atributo sea distinto a 0.


Nombre función: ***getListadoCamas()***
Parametros:
Ninguno
Retorno:
String lista
Acción:
Imprime en pantalla todos los objetos Camas con sus atributos correspondientes pertenecientes al objeto Hospital

**Clase HospitalJSON**


Nombre función: ***getHospital()***
Parametros:
String cod_hospital
Retorno:
Objeto Hospital o NULL
Acción:
Retorna el objeto Hospital buscado dentro del listado de hospitales correspondiente al objeto HospitalJSON en caso de que este exista exista, caso contrario retorna nulo.

Nombre función: ***getHospitalesYCamas()***
Parametros:
Ninguno
Retorno:
Ninguno
Acción:
Imprime en pantalla todos los objetos Camas con sus atributos correspondientes pertenecientes a todos los objetos Hospitales dentro del listado de hospitales.

Nombre función: ***getListadoMensajes()***
Parametros:
Ninguno
Retorno:
Ninguno
Acción:
Imprime en pantalla todos los objetos JSON con sus atributos correspondientes dentro del listado de mensajes.

Nombre función: ***findHospital()***
Parametros:
String cod_hospital
Retorno:
Boolean TRUE o FALSE
Acción:
Retorna TRUE en caso de que el Objeto hospital buscado dentro del listado de hospitales correspondiente al objeto HospitalJSON exista, caso contrario retorna nulo

Nombre función: ***realizarOperacion()***
Parametros:
Objeto HospitalJSON, objeto JSON
Retorno:
Ninguno
Acción:
Lee todos los atributos del mensaje JSON y realiza la operación correspondiente según los valores de los atributos. Luego de terminar la operación, guarda un nuevo objeto JSON en el listado de mensajes con los valores correspondientes a la acción realizada.

