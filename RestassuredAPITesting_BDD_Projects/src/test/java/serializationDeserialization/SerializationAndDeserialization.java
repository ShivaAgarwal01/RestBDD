package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{

	int a = 10, b = 30;
}


public class SerializationAndDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Test t1 = new Test();

		//Serialization
		FileOutputStream fos = new FileOutputStream("test.txt"); // FileOutputStream class allows us to read the file
		ObjectOutputStream oos = new ObjectOutputStream(fos); // ObjectOutputStream allows to convert the file into object format

		oos.writeObject(t1);
		
		//DeSerialization
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Test t2 = (Test) ois.readObject();
		System.out.println(t2.a+" "+t2.b);
	}

}
