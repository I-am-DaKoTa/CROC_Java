package ArturKuznetsov.lab8.task16;

import java.util.List;

public interface IClientDao {
    Client createClient(Client client);
    Client findClient(Integer id);
    Client updateClient(Client client);
    void deleteClient(Integer id);
}