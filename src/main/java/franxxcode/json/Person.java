package franxxcode.json;

import java.util.List;

public class Person {

    private String id;

    private String name;

    private List<String> hobbies;

    private Address address;

    public Person() {
    }

    public Person(String id, String name, List<String> hobbies, Address address) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
