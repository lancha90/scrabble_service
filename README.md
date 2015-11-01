Scrabble Helper Service
=======================


- Java
- Spark Framework
- Maven
- Gson library


Instrucciones
=============

Se debe importar el proyecto en el IDE deseado debido que se encuentra configurado con `Maven`, posteriormente se debe buscar la clase RunService y ejecutarla como una aplicación standalone.


Servicio
========

**URL:** http://127.0.0.1:4567/rest/scrabble?list=g,b,r,a,s,y,%20,p

**Response:**

```
{
	words: [
		{
			points: 6,
			word: "PASO"
		},
		{
			points: 11,
			word: "RUGBY"
		},
		{
			points: 6,
			word: "SAPO"
		},
		{
			points: 5,
			word: "YA"
		}
	],
	code: 200,
	message: "Woo, encontramos palabras validas!"
}
```


Puntuación
==========

- **0 puntos:** fichas en blanco
- **1 punto:** A , E , O , I , S , N , L , R , U , T 
- **2 puntos:** D , G 
- **3 puntos:** C , B , M , P 
- **4 puntos:** H , F , V , Y 
- **5 puntos:** Q 
- **8 puntos:** J , Ñ , X 
- **10 puntos:** Z ,


Consideraciones
===============

- La representación de la ficha en blaco, es un espacio (%20).
- El diccionario de palabras se encuentra en la clase `ScrabbleGenerator.java`, actualmente cuenta con un número reducido de palabras:
	- "ABRIGO"
	- "BOLIVAR"
	- "CAMPO"
	- "DIGO"
	- "ESTOY"
	- "FARO"
	- "GRANO"
	- "HIGADO"
	- "INFORME"
	- "JIRAFA"
	- "KILO"
	- "LIMON"
	- "MICO"
	- "NICOLAS"
	- "ORIGEN"
	- "PABLO"
	- "QUESO"
	- "RUGBY"
	- "SAPO"
	- "TIMBRE"
	- "UMBRAL"
	- "VICTOR"
	- "WALTER"
	- "XML"
	- "YA"
	- "ZETA"