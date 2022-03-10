package com.practice.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.practice.serialization.Subject.Trainee;

public class SerializableDemo {

	public static void main(String[] args) {
		Student s = new Student("Abc", "s1", new Subject("Maths"));

		try {
			FileOutputStream fos = new FileOutputStream("s3.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			System.out.println("Successfully serialized!");

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("s3.txt"));
			Student deserializedStudnet = (Student) ois.readObject();
			System.out.println(deserializedStudnet.getName());

			
			//Trainee
			Subject subject =  new Subject("Science");
			Trainee trainee = new Trainee("TRAINEE1", "TR1",subject);
			oos.writeObject(trainee);
			System.out.println("Serialized trainee!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

class Student implements Serializable {

	private static final long serialVersionUID = 703701121223243910L; // this is to identify version of the serialized
																		// object
	/**
	 * This id is compared when deserializing if doesn't match then the JVM will
	 * throw a Invalid Class Exception - local class incompatible: stream classdesc
	 * serialVersionUID = 7093701121223243910, local class serialVersionUID =
	 * 703701121223243910
	 */

	private String name;
	private String id;

	private Subject subject; // This object also has to implement Serializable interface

	public Student(String name, String id, Subject subject) {
		super();
		this.name = name;
		this.id = id;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public Subject(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Trainee extends Student { // no implements Serializable needed as it is inherited

	// However it has to add it own serialization id
	public Trainee(String name, String id, Subject subject) {
		super(name, id, subject);
	}

}
