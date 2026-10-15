
public class Main {
	public static void main(String[] args) {
		
		//Polimorfismo: Array do tipo superclasse guardando subclasses
		
		Animal[] animais = new Animal[3];
		animais[0] = new Animal(5); //Pouca fome
		animais[1] = new Animal(15); //Muita fome (Vai dar erro!)
		animais[2] = new Animal(12); //Muita fome (Vai dar erro!)
		
		for(Animal animal:  animais) {
			try {
				//Tentamos fazer o animal vagar
				animal.roam();
			}catch(AnimalException a) {
				//Polimorfismo em ação!
				//A referência 'a' é do tipo AnimalException, mas captura o objeto HungryAnimal Exception
				System.out.println("ERRO CAPTURADO: " + a.getMessage());
				//Tratando o problema
				System.out.println("Alimentando o animal...");
				animal.eat();
			}
		}
		
		
	}
}
