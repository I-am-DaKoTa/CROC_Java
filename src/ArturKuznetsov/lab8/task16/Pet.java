package ArturKuznetsov.lab8.task16;

public class Pet {
    private final int medicalCard;
    private String name;
    private int age;

    public Pet(int medicalCard, String name, int age) {
        this.medicalCard = medicalCard;
        this.name = name;
        this.age = age;
    }

    public int getMedicalCard() {
        return medicalCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Питомец: %s\nМедицинская книжка: %d\nВозраст: %s", name, medicalCard, age);
    }
}
