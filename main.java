import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		Random R = new Random();
		
		vaquero jugador = new vaquero();
		vaquero enemigo = new vaquero();
		
		int opcion, rand, round = 1	;
		boolean persona = true, CPU = true;

//Daño y Recarga y booleans del enemigo y del jugador
		enemigo.setDaño(1);
		jugador.setDaño(1);
		enemigo.setRecarga(0);
		jugador.setRecarga(0);
		enemigo.setDisparo(true);
		enemigo.setDefensa(true);
		enemigo.setNada(true);
		jugador.setDisparo(true);
		jugador.setDefensa(true);
		jugador.setNada(true);
		
		
		
//Nombre del jugador		
		System.out.println("Cual es tu nombre?");
		System.out.println();
		jugador.setNombre(S.nextLine());
		
//Nombre del enemigo		
		rand = R.nextInt(5);
		
		switch(rand){
			case 0:
				enemigo.setNombre("Pau Gasol");
				break;
			case 1:
				enemigo.setNombre("Mariano Rajoy");
				break;
			case 2:
				enemigo.setNombre("Donald Trump");
				break;
			case 3:
				enemigo.setNombre("Rafael Nadal");
				break;	
			case 4:
				enemigo.setNombre("Papa Noel");
				break;
		}
		
		
//Dificultad		
		do{
			System.out.println();
			System.out.println("En que dificultad quieres jugar?");
			System.out.println();
			System.out.println("1. Facíl");
			System.out.println("2. Normal");
			System.out.println("3. Dificil");
			System.out.println();
			opcion = S.nextInt();
		}while(opcion <= 0 || opcion >= 4);
		
		switch(opcion){
			case 1:
				jugador.setSalud(2);
				enemigo.setSalud(1);
				break;
			case 2:
				jugador.setSalud(1);
				enemigo.setSalud(1);
				break;
			case 3:
				jugador.setSalud(1);
				enemigo.setSalud(2);
				break;
		}

//juego
		for(int i = 0;persona && CPU;i++){
		
			System.out.println("          ROUND "+round);
			round++;
			
			
			System.out.println();
		System.out.println(enemigo.getNombre()+":");
		System.out.println("Salud: "+enemigo.getSalud());
		System.out.println("Balas: "+enemigo.getRecarga()+"/6");
		System.out.println();
		System.out.println();
		System.out.println(jugador.getNombre()+":");
		System.out.println("Salud: "+jugador.getSalud());
		System.out.println("Balas: "+jugador.getRecarga()+"/6");
		System.out.println();
		System.out.println();
		System.out.println("Pulsa enter para continuar");
		try{
			System.in.read();
		}catch(Exception e){}
		
  //Accion del jugador
		do{
		System.out.println();
		System.out.println("Que quieres hacer?:");
		System.out.println();
		System.out.println("1. Disparar");
		System.out.println("2. Recargar");
		System.out.println("3. Esquivar");
		System.out.println();
		opcion = S.nextInt();
		}while(opcion <= 0 || opcion >= 4);
		
		System.out.println();
		
		switch(opcion){
		 case 1:
			 if(jugador.getRecarga() == 0){
				 System.out.println(jugador.getNombre()+" no ha podido disparar ya que no tiene balas");
				 jugador.setDisparo(false);
				 jugador.setDefensa(false);
				 jugador.setNada(true);
			 }
			 else{
				 jugador.setRecarga(jugador.getRecarga()-1);
				 System.out.println(jugador.getNombre()+" ha disparado");
				 jugador.setDisparo(true);
				 jugador.setDefensa(false);
				 jugador.setNada(false);
			 }
			 break;
		 case 2:
			 if(jugador.getRecarga() == 6){
				 System.out.println(jugador.getNombre()+" no ha podido recargar ya que tiene el cargador lleno");
				 jugador.setDisparo(false);
				 jugador.setDefensa(false);
				 jugador.setNada(true);
			 }
			 else{
				 jugador.setRecarga(jugador.getRecarga()+1);
				 System.out.println(jugador.getNombre()+" ha recargado");
				 jugador.setDisparo(false);
				 jugador.setDefensa(false);
				 jugador.setNada(true);
			 }
			 break;
		 case 3:
			 System.out.print(jugador.getNombre()+" ha esquivado");
			 jugador.setDisparo(false);
			 jugador.setDefensa(true);
			 jugador.setNada(false);
		}
		
//accion del enemigo
		
		System.out.println();
		
		if(i == 0){
			
			
			enemigo.setRecarga(enemigo.getRecarga()+1);
			 System.out.println(enemigo.getNombre()+" ha recargado");
			 enemigo.setDisparo(false);
			 enemigo.setDefensa(false);
			 enemigo.setNada(true);
		}
		else{
		do{
		rand = R.nextInt(4);
		}while(rand == 0);
			
		switch(rand){
			case 1:
				 if(enemigo.getRecarga() == 0){
					 System.out.println(enemigo.getNombre()+" no ha podido disparar ya que no tiene balas");
					 enemigo.setDisparo(false);
					 enemigo.setDefensa(false);
					 enemigo.setNada(true);
				 }
				 else{
					 enemigo.setRecarga(enemigo.getRecarga()-1);
					 System.out.println(enemigo.getNombre()+" ha disparado");
					 enemigo.setDisparo(true);
					 enemigo.setDefensa(false);
					 enemigo.setNada(false);
				 }
				 break;
			 case 2:
				 if(enemigo.getRecarga() == 6){
					 System.out.println(enemigo.getNombre()+" no ha podido recargar ya que tiene el cargador lleno");
					 enemigo.setDisparo(false);
					 enemigo.setDefensa(false);
					 enemigo.setNada(true);
				 }
				 else{
					 enemigo.setRecarga(enemigo.getRecarga()+1);
					 System.out.println(enemigo.getNombre()+" ha recargado");
					 enemigo.setDisparo(false);
					 enemigo.setDefensa(false);
					 enemigo.setNada(true);
				 }
				 break;
			 case 3:
				 System.out.println(enemigo.getNombre()+" se ha defendido");
				 enemigo.setDisparo(false);
				 enemigo.setDefensa(true);
				 enemigo.setNada(false);
			}		
		}

		System.out.println();
		System.out.println("Pulsa enter para continuar");
		System.out.println();
		try{
			System.in.read();
		}catch(Exception e){}
		
//Consecuencias
		if(jugador.isDisparo() && enemigo.isDisparo()){
			System.out.println(jugador.getNombre()+" y "+enemigo.getNombre()+" han disparado a la vez y las dos balas se han chocado en el aire");
			
		}
		if(jugador.isDisparo() && enemigo.isDefensa()){
			System.out.println(jugador.getNombre()+" ha disparado pero "+enemigo.getNombre()+" ha esquivado la bala justo a tiempo");
		}
		if(jugador.isDisparo() && enemigo.isNada()){
			System.out.println(jugador.getNombre()+" ha disparado a "+enemigo.getNombre()+" y le ha quitado 1 pt de vida");
			enemigo.setSalud(enemigo.getSalud()-1);
		}
		if(jugador.isDefensa() && enemigo.isDisparo()){
			System.out.println(enemigo.getNombre()+" ha disparado a "+jugador.getNombre()+" y leha quitado 1 pt de vida");
			jugador.setSalud(jugador.getSalud()-1);
		}
		if(jugador.isDefensa() && enemigo.isDefensa()){
			System.out.println("no ha pasado nada");
		}
		if(jugador.isDefensa() && enemigo.isNada()){
			System.out.println("no ha pasado nada");
		}
		if(jugador.isNada() && enemigo.isDisparo()){
			System.out.println(enemigo.getNombre()+" ha disparado a "+jugador.getNombre()+" y leha quitado 1 pt de vida");
			jugador.setSalud(jugador.getSalud()-1);
		}
		if(jugador.isNada() && enemigo.isDefensa()){
			System.out.println("no ha pasado nada");
		}
		if(jugador.isNada() && enemigo.isNada()){
			System.out.println("no ha pasado nada");
		}
		System.out.println();
		System.out.println("Pulsa enter para continuar");
		try{
			System.in.read();
		}catch(Exception e){}
		
//verificacion de la vida
		if(jugador.getSalud()==0){
			persona = false;
		}
		if(enemigo.getSalud()==0){
			CPU = false;
		}
		
		
		
		
		
		}
		
//ganador
		if(persona){
			System.out.println(jugador.getNombre()+" ha ganado a "+enemigo.getNombre());
		}
		else{
			System.out.println(enemigo.getNombre()+" ha ganado a "+jugador.getNombre());
		}
	}

}
