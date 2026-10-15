
public class Main {
	public static void main(String[] args) {
		
		//Polimorfismo: Array do tipo superclasse guardando subclasses
		
		Animal[] animais = new Animal[3];
		animais[0] = new Animal(5, 10); //Pouca fome
		animais[1] = new Animal(15, 10); //Muita fome (Vai dar erro!)
		animais[2] = new Dog(3, 2); //Testando Dog
		
		for(int i = 0; i < animais.length; i++) {
			System.out.println("\n---- Testando Animal " + (i + 1) + "----");
			try {
				//Tentamos fazer o animal vagar
				animais[i].roam();
			}catch(AnimalException a) {
				//Polimorfismo em ação!
				//A referência 'a' é do tipo AnimalException, mas captura o objeto HungryAnimal Exception
				System.out.println("ERRO CAPTURADO: " + a.getMessage());
				//Tratando o problema
				//System.out.println("Alimentando o animal...");
				//animal.eat();
			}
		}		
	}
}
