package demo.models;

import annotations.*;
import storages.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Model(tableName = "client", primaryKey = "id")
public class Client {
	
	@PrimaryKey
	private int id;

	@Column(fieldName = "surname")
	private String surname;
	
	@Column(fieldName = "name")
	private String name;
	
	@Column(fieldName = "isgirl")
	private boolean isGirl;
/*
	@Column(fieldName = "test_id")
	@ForeignKey(entity = "TestModel", column = "id", onDelete = Actions.CASCADE)
	private int testId;*/

	@ManyToMany(table = "worker")
	private List<Worker> workers = new ArrayList<>();

	public Client() {

	}
	
	public Client(String surname) {
		this.surname = surname;
	}
	
	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String surname, String name, boolean isGirl) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.isGirl = isGirl;
	}

	public Client(String surname, String name, boolean isGirl) {
		super();
		this.surname = surname;
		this.name = name;
		this.isGirl = isGirl;
	}
/*
	public Client(String surname, String name, boolean isGirl, int testId) {
		this.surname = surname;
		this.name = name;
		this.isGirl = isGirl;
		this.testId = testId;
	}*/

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                isGirl == client.isGirl &&
                surname.equals(client.surname) &&
                name.equals(client.name) &&
                workers.equals(client.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, isGirl, workers);
    }
}
