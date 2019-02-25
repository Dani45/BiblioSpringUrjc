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
<li> Agustín López Gil - a.lopezgi.2016@alumnos.urjc.es - agustinlopezg</li>
<li> Chengjian Li - c.li3.2016@alumnos.urjc.es - Oscarli1797</li>
<li> Fausto Daniel Luje Condor - fd.luje.2018@alumnos.urjc.es - Dani45</li>
</ul>

**Diagrama de clases:**

![Preview](https://raw.githubusercontent.com/agustinlopezg/bibliotecaWebUrjc_DAD/UML FASE2 BIBLIOSPRING.png) 

      

**Modelo Entidad-Relación:**


**Descripción de las pantallas principales:** (a falta de mejorar)

<li> Libro: Se puede buscar los libros que hay en la biblioteca por diferentes filtros: título y categoría </li>
<li>Usuario: Ingresas a la aplicación mediane un LogIn en el que se tiene que escribir los datos (nombre y contraseña) para acceder.</li>
<li>Categoría:Consulta todos los libros de la biblioteca repartidos en categorías para una mayor facilidad de uso</li>
<li>Préstamo: Accede a la posibilidad de entrar en el espacio personal del usuario premium para renovar el carné anual, cambiar los datos personales, etc.</li>
<li>Alternativa: Consulta los fanzines, revistas y películas que hay en la biblioteca. </li>
