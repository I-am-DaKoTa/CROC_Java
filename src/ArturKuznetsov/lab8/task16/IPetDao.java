package ArturKuznetsov.lab8.task16;

import java.util.List;

public interface IPetDao {
    Pet createPet(String name, Integer age, List<Client> clients);
    Pet findPet(Integer medicalCardNumber);
    Pet updatePet(Pet pet);
    void deletePet(Integer medicalCardNumber);
}
