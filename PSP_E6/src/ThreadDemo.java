class ThreadDemo implements Runnable  {
	//Se define el constructor de la clase, el cual no recibe ning�n par�metro de 	//entrada. 
	ThreadDemo()  {
		//Devuelve una referencia al objeto hilo se est� ejecutando 
		//actualmente. Si no hubi�se en ejecuci�n ning�n hilo el objeto
		//ct recoger�a un null.
		Thread ct = Thread.currentThread();
		//Se instancia un nuevo objeto Thread a partir de la propia clase 			//Runnable. 
		Thread t = new Thread(this);
		//Se hace uso del m�todo setName() de la clase Thread para cambiar el  			//nombre del thread. 
		t.setName("demo Thread"); 
		//Se imprime por consola el nombre del hilo en ejecuci�n que 
		//no fue creado por esta clase
		System.out.println("hilo actual: " + ct);

		//Se imprime por consola el nombre del hilo nuevo hilo creado
	 	//por esta misma clase.
		System.out.println("Hilo creado: " + t);
		//Se activa el nuevo hilo creado (t)
		t.start();

		try  {
			//Con el m�todo sleep() de la clase Thread se suspende 
			//la ejecuci�n del thread por el n�mero de milisegundos
			//especificado como par�metro del m�todo.
			Thread.sleep(3000);
		//En caso de producirse un error en la ejecuci�n del c�digo del
		//bloque try, se lanzar� una excepci�n de tipo  InterruptedException.
		}  catch (InterruptedException e)  {
		   	System.out.println("Interrumpido");
		}
		//Con un mensaje por consola se indica que se ha salido del main
		System.out.println("saliendo del hilo main");
    }

   //Se define el m�todo run() encargado de definir el c�digo que se ejecutar� al
   //instaciar un objeto de tipo Thread, el cual a su vez define un thread.
    public void run()  {
	try  {
		//Con un bucle for se implementan 10 iteraciones del thread creado (t).
		for (int i = 5; i > 0; i--)  { 
			//Se muestra por consola el nombre del thread ejecutado en cada	
			//iteraci�n. Para ello, dentro del constructor del println() se 
			//obtiene la referencia del objeto Thread que se est� ejecutando
			//y, desde ella se utiliza el m�todo getName() propio de la 	
			//clase Thread el cual devuelve el nombre del thread. Tambi�n
			//se imprime en consola el n�mero de iteraci�n actual.
			System.out.println(Thread.currentThread().getName()+" " + i);
			//Con el m�todo sleep() de la clase Thread se suspende 
			//la ejecuci�n del thread por el n�mero de milisegundos
			//especificado como par�metro del m�todo.
			Thread.sleep(1000);
	 	}
	}  catch (InterruptedException e)  {
		System.out.println("hijo interrumpido");
	}
	System.out.println("saliendo del hilo hijo");
    }
    	
    //Se crea el m�todo main encargado de lanzar la aplicaci�n Java.
    //Y, dentro de este m�todo primero se instancia un objeto de tipo
    //Runnable llamado hilo y, posteriormente, se instancia un objeto
    //de tipo Thread que recibe por par�metro el objeto ThreadDemo (Runnable) 
    //para conseguir as� crear un hilo de ejecuci�n o thread que se 
    //denominar� h.
    public static void main (String args [])  { 
    	ThreadDemo hilo = new ThreadDemo();
    	Thread h = new Thread(hilo);
    	
    }
}