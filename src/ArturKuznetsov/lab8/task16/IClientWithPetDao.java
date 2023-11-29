package ArturKuznetsov.lab8.task16;

import java.util.List;

public interface IClientWithPetDao {
    List<String> findClientPhoneNumbersBy(Pet pet);
    List<Pet> getAllPetsOf(Client client);
}
