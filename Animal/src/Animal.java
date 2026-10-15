
public class Animal {
	
	private String picture;
	private String food;
	private String hunger;
	private String bounderies;
	private String location;
	
	public Animal(int hunger) {
		this.hunger = hunger;
	}
	
	public int getHunger() {
		return this.hunger;
	}
		
	public void makeNoise() {
		System.out.println("Som!");
		
	}
	
	public void eat() {
		System.out.println("O animal comeu e não está mais com fome.");
		this.hunger = 0;
		
	}
	
	public void sleep() {
		System.out.println("ZzZzZz!");
	}
	
	public void roam() throws AnimalException{
		if(this.hunger > 10) {
			//Lançando o objeto de erro
			throw new HungryAnimalException("O animal está muito faminto para andar!");
		}
		System.out.println("Andando!");
	}

}
