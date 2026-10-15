
public class Dog extends Canine {
	
	public Dog(int hunger, int energia) {
		super(hunger, energia);
	}
	
	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		//super.makeNoise();
		System.out.println("Au Au!");
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		//super.eat();
		System.out.println("Ração");
		super.eat();
	}
		
	@Override
	public void roam() throws AnimalException{
		if(getEnergia() < 5) {
			throw new TiredAnimalException("O Dog está cansado demais para andar!");
		}
		super.roam();
	}

}
