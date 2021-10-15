package pedro.gouveia.cm_assignment1;
public class Animal {
    private String owner, name, fixedName;
    private int age;

    public Animal() {  }

    public Animal(String name, String owner, int age, String fixedName) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.fixedName = fixedName;
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

    public String getFixedName() { return this.fixedName; }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setFixedName(int identify) { this.fixedName = fixedName; }

    public String toString(){
        return this.fixedName.substring(0, 1).toUpperCase() + this.fixedName.substring(1);
    }
}
