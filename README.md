# bibliotecaWebUrjc_DAD

**Nombre de la aplicación web:** Biblioteca Web URJC

**Descripción de la temática de la web:**
<p>La web consistirá en proporcionar servicio de una biblioteca tanto a usuarios que quieran hacer uso de la misma o tanto al bibliotecario para realizar todas las tareas de gestión que se necesitase. </p>

**Entidades principales:**
<ul>
<li> Libro: Conlleva unos atributos que lo caracterizan (nombre, escritor, descripción, categoría) </li>
<li>Usuario: Diferencia de tipos de usuarios(si es socio o administrador de la biblioteca) y las acciones que permite realizar.</li>
<li>Categoría:Tendrá varias temáticas en las diferentes áreas(informática, literatura, biología, deportes, historia, geografía...)</li>
<li>Préstamo: Todo lo referente al control y gestión de los pagos de los carnet</li>
<li>Alternativa: Otros tipos de recursos disponibles en la biblioteca (películas, revistas, fanzines,...) </li>
</ul>

**Funcionalidades del servicio interno:**
<ul>
<li>Enviar notificaciones de los préstamos a los socios o de la fecha de caducidad del carné.</li>
<li>Comprobar cada cierto tiempo que se están realizando los pagos.</li>
<li>Cobrar el dinero correspondiente al precio del carné de socio.</li>
</ul>  

**Parte privada:**
<p>Los socios de la biblioteca pueden alquilar libros, también pueden renovar su carnet de socio anual, hacer reservas de libros, publicar alguna reseña sobre el libro alquilado, cambiar sus datos, realizar el pago de una deuda pendiente, ... </p>
<p>El administrador (bibliotecario) podrá gestionar el pago de los socios de la biblioteca, podrá expulsar a un socio por su mal comportamiento en la biblioteca, podrá sancionar a un socio por no devolver el libro alquilado en su debido tiempo, podrá señalar los libros que no puedan ser alquilados, podrá repartir los libros de la biblioteca en categorías,... </p>

**Parte pública:**
<p>Los usuarios que no sean socios de la biblioteca podrán consultar el horario de la biblioteca, consultar los precios y beneficios de poseer el carné de socio, una opción de contactar con la biblioteca (cómo llegar), ver las distintas redes sociales que tiene la biblioteca, ver información adicional de la biblioteca, consultar las normas de uso interno en la biblioteca, ver la política de privacidad,...</p>

**Integrantes del equipo de desarrollo:**
<ul>
<li> Chengjian Li - c.li3.2016@alumnos.urjc.es - Oscarli1797</li>
<li> Fausto Daniel Luje Condor - fd.luje.2018@alumnos.urjc.es - Dani45</li>
</ul>

**Modelo UML:**

![UML](https://github.com/agustinlopezg/bibliotecaWebUrjc_DAD/blob/master/UML_FASE3.jpg?raw=true)    

**Diagrama de clases:**

![Diagrama_de_clases](https://github.com/agustinlopezg/bibliotecaWebUrjc_DAD/blob/master/diagramaClasesDAD_fase3.jpg?raw=true)
      
**Modelo Entidad-Relación:**

![Diagrama_de_clases](https://github.com/agustinlopezg/bibliotecaWebUrjc_DAD/blob/master/MODELO_E_R.png?raw=true)
     
**Descripción de las pantallas principales:** 

<li> Libro: Se puede buscar los libros que hay en la biblioteca por diferentes filtros: título y categoría </li>
<li>Usuario: Ingresas a la aplicación mediane un LogIn en el que se tiene que escribir los datos (nombre y contraseña) para acceder.</li>
<li>Categoría:Consulta todos los libros de la biblioteca repartidos en categorías para una mayor facilidad de uso</li>
<li>Préstamo: Accede a la posibilidad de entrar en el espacio personal del usuario premium para renovar el carné anual, cambiar los datos personales, etc.</li>
<li>Alternativa: Consulta los fanzines, revistas y películas que hay en la biblioteca. </li>

**Instrucciones precisas para desplegar la aplicación:**

**Compilación:**
<ul>
      <li>1. Botón derecho sobre el proyecto. </li>
      <li>2. Clickar sobre 'Run as' </li>
      <li>3. Clickar sobre Spring Boot Application</li>
</ul>

**Virtualizacion**

**Comandos necesarios para instalar *MySQL* y poner en marca**
 - Descargamos VirtualBox  e instalamos.
 - Ir a configuración en virtual box. En red se debe de cambiar a (**adaptador de puente**) y en permitir (**permita todo**).

 - Descargar Ubuntu-16.04.6-server-amd64.

**Extras para virtualBox**
		
	  - necesitamos instalar jdk y jre versión 8 	 
	  - sudo apt-get install -y openjdk-8-jdk
	  - sudo apt-get install -y openjdk-8-jre

 
  **Instalamos *MySQL* por terminal.**

	  - sudo apt-get update
	  - sudo apt-get install mysql-server (cuando instalamos mysql nos pide la contraseña)
	  - cambiamos la contraseña de MySQL
	  - mysql -u root (si lo hacemos por primera vez)
	  - UPDATE mysql.user SET authentication_string=PASSWORD(‘123456’) WHERE User='root';
	  - FLUSH PRIVILEGES;
	  - salimos de mysql y volvemos a iniciar con la contraseña creada.

**Creamos la base de datos en *MySQL***

	- create database bibliospringdb;
	- show databases; (para mirar las bases de datos existentes)
	- select user,host,authentication_string from mysql.user (para ver si se ha cambiado o no la contraseña por defecto)

**Crear carpeta local para compartir con *Windows*.**
	
	- sudo apt-get install virtualbox-guest-x11
	- mkdir /home/ubuntu/shared
	- sudo mount -t vboxsf shared /home/ubuntu/shared

***Para ejecutar las Aplicaciones***

	- sudo java -jar BiblioSpringUrjc-0.0.1-SNAPSHOT &
	- sudo java -jar Servicio_interno-0.0.1-SNAPSHOT &




