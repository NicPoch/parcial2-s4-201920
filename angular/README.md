# parcial-s2-carros
ISIS 2603 Desarrollo de Sw en Equipos
Parcial Práctico No. 2. Sección 2. 

Parcial individual. Solo el navegador con stackblitz. No se puede abrir Visual Studio Code. 
Se puede utilizar:

•	https://github.com/Uniandes-isis2603/front-pregrado201920  la wiki y el código (son bajarlo)
•	https://getbootstrap.com/docs/4.3/getting-started/introduction/
•	https://angular.io/start
Instrucciones generales 
1.	Inicie sesión en stackblitz con su cuenta de github asociada a la organización Uniandes.
2.	Ingrese a este link de stackblitz https://stackblitz.com/edit/parcial-s2-carros
3.	Haga un fork al proyecto del link del paso 2.
4.	Cambie el nombre del proyecto (arriba a la izquierda). Reemplace la palabra “login” por su nombre de usuario uniandes (sin puntos). Asegúrese de salvar el nombre del proyecto en el icono del disco pequeño (por favor revise)

MUY IMPORTANTE: Durante el desarrollo del taller, no olvide ir salvando los cambios periódicamente, en particular no refresque la página sin antes asegurarse de que salvó los cambios

Recuerde que desde stackblitz se puede hacer uso de angular-cli para facilitar la creación de componentes, módulos, servicios y clases. 

Enunciado del parcial 

Se debe desarrollar una aplicación que permita: mostrar un card de carros antiguos de una colección y mostrar el detalle del carro que el usuario seleccione de la galería de cards.

https://getbootstrap.com/docs/4.3/components/card/

Ud. debe crear un módulo para las rutas y un módulo para agrupar los dos componentes: El de listar y el del detalle como se muestra en la siguiente imagen.

Están dados los archivos json que contienen la información: 

• assets/cars.json contiene la lista de carros 
• assets/car-i.json donde i corresponde al identificador del carro. 

Punto No. 1: Mostrar la Lista (6 puntos) 

1. El despliegue de la lista debe hacerse cuando el usuario hace clic sobre un botón o menú en la parte de arriba de la aplicación (1 Puntos) 

2. El componente de listar los carros debe desplegar, usando el componente card de bootstrap, la información de los carros, contenida en el archivo assets/carros.json. 

La información se debe obtener utilizando HttpClient de Angular. Cada card tiene un carro y se muestran los atributos: image y name.
 (3 Puntos) 

Al final de la lista se debe mostrar el total de carros que tienen caballos de fuerza mayor o igual a 150 (el atributo se llama  horsepower) (2 Puntos) 

La solución debe considerar un número arbitrarios de carros. En el archivo de datos ejemplo solo hay 5 pero podría ser un número distinto y con distintos valores.
Instrucciones para la entrega del primer punto

Asegúrese de que salvó el proyecto. 
•	Copie de la opción Share de stackblitz el enlace de la opción EDITOR URL .
•	Suba esa info a sicua:

 
Posterior al parcial NO puede modificar este proyecto en su stackblitz


Punto No. 2: Mostrar el detalle (4 puntos) 

Haga un fork a su proyecto dele punto 1 y agregue al final del nombre del proyecto punto2

A partir de la galería de cards de los carros, cuando el usuario hace clic en la imagen del carro, se debe mostrar, al lado de la lista de cards de los carros, la información del detalle del carro seleccionado. 
Primero el nombre (todo en mayúsculas), luego la imagen y la descripción (2 Puntos)
Segundo, en una tabla los detalles técnicos. (2 Puntos)

Los atributos básicos de un carro son:
     id:number;
  name: string;
  image: string;

y los del detalle son, los que hereda de los básicos más:
  miles_per_Gallon:number;
  cylinders: number;
  weight_in_lbs: number;
  acceleration:number;
  description:string
Instrucciones para la entrega del segundo punto

Asegúrese de que salvó el proyecto. 
•	Copie de la opción Share de stackblitz el enlace de la opción EDITOR URL .
•	Suba esa info a sicua:

 
Posterior al parcial NO puede modificar este proyecto en su stackblitz

