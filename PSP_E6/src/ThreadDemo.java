class ThreadDemo implements Runnable  {
	//Se define el constructor de la clase, el cual no recibe ningún parámetro de 	//entrada. 
	ThreadDemo()  {
		//Devuelve una referencia al objeto hilo se está ejecutando 
		//actualmente. Si no hubiése en ejecución ningún hilo el objeto
		//ct recogería un null.
		Thread ct = Thread.currentThread();
		//Se instancia un nuevo objeto Thread a partir de la propia clase 			//Runnable. 
		Thread t = new Thread(this);
		//Se hace uso del método setName() de la clase Thread para cambiar el  			//nombre del thread. 
		t.setName("demo Thread"); 
		//Se imprime por consola el nombre del hilo en ejecución que 
		//no fue creado por esta clase
		System.out.println("hilo actual: " + ct);

		//Se imprime por consola el nombre del hilo nuevo hilo creado
	 	//por esta misma clase.
		System.out.println("Hilo creado: " + t);
		//Se activa el nuevo hilo creado (t)
		t.start();

		try  {
			//Con el método sleep() de la clase Thread se suspende 
			//la ejecución del thread por el número de milisegundos
			//especificado como parámetro del método.
			Thread.sleep(3000);
		//En caso de producirse un error en la ejecución del código del
		//bloque try, se lanzará una excepción de tipo  InterruptedException.
		}  catch (InterruptedException e)  {
		   	System.out.println("Interrumpido");
		}
		//Con un mensaje por consola se indica que se ha salido del main
		System.out.println("saliendo del hilo main");
    }

   //Se define el método run() encargado de definir el código que se ejecutará al
   //instaciar un objeto de tipo Thread, el cual a su vez define un thread.
    public void run()  {
	try  {
		//Con un bucle for se implementan 10 iteraciones del thread creado (t).
		for (int i = 5; i > 0; i--)  { 
			//Se muestra por consola el nombre del thread ejecutado en cada	
			//iteración. Para ello, dentro del constructor del println() se 
			//obtiene la referencia del objeto Thread que se está ejecutando
			//y, desde ella se utiliza el método getName() propio de la 	
			//clase Thread el cual devuelve el nombre del thread. También
			//se imprime en consola el número de iteración actual.
			System.out.println(Thread.currentThread().getName()+" " + i);
			//Con el método sleep() de la clase Thread se suspende 
			//la ejecución del thread por el número de milisegundos
			//especificado como parámetro del método.
			Thread.sleep(1000);
	 	}
	}  catch (InterruptedException e)  {
		System.out.println("hijo interrumpido");
	}
	System.out.println("saliendo del hilo hijo");
    }
    	
    //Se crea el método main encargado de lanzar la aplicación Java.
    //Y, dentro de este método primero se instancia un objeto de tipo
    //Runnable llamado hilo y, posteriormente, se instancia un objeto
    //de tipo Thread que recibe por parámetro el objeto ThreadDemo (Runnable) 
    //para conseguir así crear un hilo de ejecución o thread que se 
    //denominará h.
    public static void main (String args [])  { 
    	ThreadDemo hilo = new ThreadDemo();
    	Thread h = new Thread(hilo);
    	
    }
}