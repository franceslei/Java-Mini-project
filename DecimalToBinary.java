package interviewProgram;

public class DecimalToBinary {
	
	// decimal to binary format using numeric operation.
	public void printBinary(int num){
		int binary[] = new int[32];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;  //binary[index]=..., then index++;
            num = num/2;
           
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
	}

	public static void main(String[] args) {
		DecimalToBinary dtb= new DecimalToBinary();   //if don't want to create object, then the method should be static
		dtb.printBinary(25);

	}

}
