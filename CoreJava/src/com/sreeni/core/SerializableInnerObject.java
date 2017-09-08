package com.sreeni.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableInnerObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pappy pappy = new Pappy("white",1);
		Cat catForSerilized = new Cat(pappy,1);
		try {
			FileOutputStream fos = new FileOutputStream("abc1.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(catForSerilized);
			
			FileInputStream fis = new FileInputStream("abc1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cat catDeserilized = (Cat) ois.readObject();
			Pappy pappyDeserilized = catDeserilized.getPappy();
			System.out.println("--deserilized pappy name--"+pappyDeserilized.getColor());
			System.out.println("--deserilized pappy age--"+pappyDeserilized.getAge());
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class Cat implements Serializable{
	private Pappy pappy;
	private int noPappies;
	public Cat(Pappy pappy,int noPappies){
		this.pappy = pappy;
		this.noPappies = noPappies;
	}
	public Pappy getPappy() {
		return pappy;
	}
	public void setPappy(Pappy pappy) {
		this.pappy = pappy;
	}
	public int getNoPappies() {
		return noPappies;
	}
	public void setNoPappies(int noPappies) {
		this.noPappies = noPappies;
	}
}