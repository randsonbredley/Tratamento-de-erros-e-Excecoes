
public class PetOwner {
	//public void start() {
		public static void main(String[] args) {

			Vet vet = new Vet();
			Dog dog = new Dog();
			Hippo hippo = new Hippo();
			
			vet.giveShot(dog);
			vet.giveShot(hippo);
		}
}
