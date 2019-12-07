# Parcial 1 sección 4

## Instrucciones

1. Clone este proyecto en su máquina virtual

2. Abra los proyectos en Netbeans

3. En Netbeans Vaya a Services > Databases > JavaDB y cree una base de datos que se 
llame cinemaDB (los demás campos déjelos en blanco)

4. Respire y sonria, no se le pedirá algo que no haya ya hecho

## Punto 1 (25%). Persistencia

Nuestra aplicación tiene el propósito de administrar un cine, para esta entrega nos concentraremos únicamente en agregar la funcionalidad que permita crear tiquetes en la aplicación.

1. (10%) Cree la entidad TiqueteEntity en la carpeta correspondiente. Un tiquete tiene el nombre de la película que se está comprando, la fecha de compra, el costo de la boleta, el código de compra del tiquete que indica silla y sala, un id de tipo Long que representa la llave primaria de la película. 

2. (15%) Cree la prueba unitaria en la clase correspondiente, la cual valida si está correcta la implementación de la persistencia de la entidad tiquete. 

Ejecute la prueba y valide que pasa correctamente. 

## Punto 2 (60%). Lógica

Usted debe crear la lógica de aplicación que cubra las reglas de negocio para la entidad Tiquete. Las reglas de negocio para crear un Tiquete son:

* No puede haber un tiquete con el código de compra repetido
* El nombre de la película debe ser válido (no vacío, ni nulo)
* El valor de la boleta debe ser mayor a cero, excepto cuando el código de la película inicie por FREE lo cual corresponde a boletas que se ofrecen de cortesía y el valor es cero.
* La fecha de compra no debe venir por parte del usuario y debe ser asignada en esta capa

Usted debe:

1. (10%) Crear el método en la persistencia que permita consultar un tiquete por su código de compra.
2. (20%) Crear el método en la capa de lógica que valide las reglas de negocio y solicita persistir en caso que todas pasen.
3. (30%) Crear al menos tres pruebas unitarias, una que valida el camino ideas en que todas las reglas de negocio se aprueban, y dos de reglas de negocio (las que desee) donde se valida la correcta implementación de dos reglas de negocio. Se tendrá en cuenta el correcto nombramiento de la prueba y el mensaje que presenta). 

Si las reglas de negocio se cumplen, se debe llamar la persistencia para que el objeto sea persistido, de lo contrario debe lanzar una excepción BusinessLogicException con un mensaje donde se especifique el problema.

## Punto 3 (10%). Pruebas Integrales

En la aplicación le hemos brindado la capa REST API para probar, usted debe completar esta clase y probar que correctamente funciona. Para ello usted debe:

1. (5%) Crear la clase TiqueteDTO con los campos correspondientes y un constructor vacío
2. (5%) Crear el método ToEntity en la clase TiqueteDTO que retorna un objeto TiqueteEntity con los datos del objeto TiqueteDTO. Además agregue el método constructor que recibe un TiqueteEntity y hace el mapeo correspondiente entre ambas clases.

Pruebe en **postman** de la siguiente forma y tome un pantallazo por cada prueba realizada:

1. Prueba 1: Creación correcta con código de silla correcto:

- Método: POST 
- URL: localhost:1527/api/tiquetes
- Body: 
```
{
	"pelicula": "El origen",
	"costo": 0,
	"codigo": "FREEA12"
}
```
- Response: 202

2. Prueba 2: Creación incorrecta por película incorrecta:

- Método: POST 
- URL: localhost:1527/api/tiquetes
- Body: 
```
{
	"pelicula": "",
	"costo": 0,
	"codigo": "FREEA12"
}
```
- Response: 412

2. Prueba 3: Creación incorrecta por costo incorrecto:

- Método: POST 
- URL: localhost:1527/api/tiquetes
- Body: 
```
{
	"pelicula": "El origen",
	"costo": 0,
	"codigo": "A12"
}
```
- Response: 412

## Entrega (5%)

* Suba sus cambios a github a la rama master de su repositorio
* Cree un release de su código, en el mensaje del release adjunte las imágenes de las tres pruebas que se ejecutaron correctamente en postman.

Éxitos