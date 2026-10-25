# Sistema de gestión de reservas — Java

## Descripción

Proyecto intermodular realizado durante el primer curso del Ciclo Formativo de Grado Superior en Desarrollo de Aplicaciones Web (DAW).

Consiste en una aplicación de consola desarrollada en Java para gestionar recursos, horarios, disponibilidades y reservas, utilizando una base de datos MySQL.

## Funcionalidades

- **Recursos:** añadir, consultar, modificar y eliminar.
- **Horarios:** añadir, consultar, modificar y eliminar.
- **Disponibilidad:** añadir, consultar y eliminar.
- **Reservas:** añadir, consultar y eliminar.
- **Usuarios:** funcionalidad pendiente de desarrollo.

## Tecnologías utilizadas

- Java
- SQL y MySQL
- JDBC
- IntelliJ IDEA

## Estructura del proyecto

El código está organizado en diferentes paquetes:

- `app`: inicio de la aplicación.
- `controller`: gestión de las acciones y conexión entre componentes.
- `model`: clases que representan los datos.
- `dao`: operaciones de acceso a la base de datos.
- `view`: menús e interacción con el usuario mediante consola.

## Ejecución

La aplicación se inicia desde la clase `Main.java`, situada en `src/app`.

Para utilizar las funcionalidades que acceden a los datos, es necesario disponer de MySQL, configurar la conexión en `DBConnection.java` y preparar la base de datos correspondiente.

## Estado del proyecto

Proyecto académico de primer curso de DAW. Algunas funcionalidades, como la gestión de usuarios, quedaron pendientes de desarrollo.
