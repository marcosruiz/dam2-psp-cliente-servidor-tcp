# dam2-psp-cliente-servidor-tcp
Ejemplo sencillo de cliente servidor usando Java.

A continuación se muestra un diagrama de secuencia que muestra la interacción entre cliente y servidor.

```
|---------|                           |----------|
| Cliente |                           | Servidor |
|---------|                           |----------|
     |              new Socket()            |
     |=====================================>|
     |                                      |
     |              accepted                |
     |<-------------------------------------|
     |                                      |
     |              write("patata")         |
     |=====================================>|
     |                                      |
     |                                      |
     |     write("tú si que eres patata")   |
     |<=====================================|
     |                                      |
     |                                      |

```