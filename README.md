# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

* Tarea 1:
    * Se crearon 5 clases que representan a cada tipo de Scrabble requerido(__scrabbleString,scrabbleBoolean,
      scrabbleInt,scrabbleFloat y scrabbleBinary__) y 3 interfaces para poder realizar las operaciones, todas estas se encuentran en el paquete Scrabbles:
        * __ScrType__ para englobar a todos tipos de Scrabble, dentro de ella estan todos los metodos comunes 
          entre todas las clases(ToString y toScrString).
        * __Slogical__ para englobar a los tipos que ocupan logica(Booleanos y Binarios) y realizar las operaciones logicas(neg,or y and, usando double dispatch).
        * __SNumbers__ para englobar a los tipos que representan numeros(Enteros, Decimales y Binarios) y realizar algunas operaciones matematicas
          (suma,resta,multiplicacion y division de numeros, usando double dispatch), 
          no logre solucionar que no se puedan operar binarios con floats,
        estas operaciones retornan null.
        * Por ahora no hay Interfaz grafica, la unica forma de ver como funciona el programa es ver los test que tiene cada
        clase que representa a un tipo de Scrabble, en estos test se prueban todas los metodos que puede usar cada uno de los tipos y
          se demuestra su correcto funcionamiento.
          
* Tarea 2:
    * Se creo un nuevo paquete llamado operaciones para crear el arbol AST, para esto se aplico el patron de 
      diseño _COMPOSITE_, para esto se crearon 2 interfaces:
        * __Hojas__ para todos los metodos comunes entre las hojas, que en este caso eran todas las operaciones(
          logicas, matematicas y concatenacion) descritas en la tarea anterior, se les dio un valor nulo por defecto,
          para que en caso de que un AST se arme de forma incorrecta, este devuelva un _null_, estas operaciones son sobreescritas
          por todas las interfaces de tipos en las que estas operaciones son validas, para que esto funcionara se debio cambiar el input
          de todas las operaciones, para que estas pudieran recibir cualquier tipo que implementara Hojas(cualquier tipo de Scrabble),
          tambien a esta interfaz las operaciones usadas en double dispatch para que funcionara bien, aunque estas nunca son usadas de forma directa.
        * __Operaciones__ que representa a todos los nodos compuestos del composite, y solo contiene al metodo __eval__ que recorre los nodos hijos para
        devolver el tipo correspondiente al nodo actual.
        * Ademas de las interfaces se crearon 13 clases para representar los posibles nodos del arbol:
            * __Add, And, Div, Mult, Neg, Or, Sub, ToBin, ToBool, ToFloat, ToInt, ToStr__ clases que representan a las operaciones pedidas en la tarea 1.
            * __Constant__ como clase que representa a las hojas del arbol y dentro contiene a un tipo de Scrabble.
    * Tambien se creo el paquete Factory que dentro contiene 5 clases y cada una representa una fabrica para cada tipo usando el patron
    de diseño _FLYWEIGHT_ para la parte de tener memoria y que un tipo no se cree si ya se creo con antelacion, para esto cada factory
      tiene una tabla de hash donde guarda los tipos ya creados, para entregarlos en caso de que estos  se pidan mas de una vez. Para
      aplicar esto de manera correcta se cambio el return de todos los metodos de clases creadas en la t1 que retornaban un tipo de Scrabble
      usan "new scrabble..." por el uso de la fabrica de la forma "S...Fac.make(....)" para que verdaderamente cada tipo se cree una sola vez.
    * Todavia no hay interfaz grafica, pero para probar la tarea se pueden correr los test de la carpeta test, para esta tarea se 
    creo la clase astTest en test/java/cl.uchile.dcc.scrabble.gui/operaciones en donde se crean varios arboles de forma correcta y 
      se usan las fabricas para guardar los tipos cada vez que se crean.