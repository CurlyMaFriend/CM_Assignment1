package pedro.gouveia.cm_assignment1;
public class Animal {
    private String owner, name;
    private int age;

    public Animal() {  }

    public Animal(String name, String owner, int age) {
        this.owner = owner;
        this.name = name;
        this.age = age;
    }

    public String getOwner(){
        return this.owner;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }
}
