package çicekci1.DataBase;

import java.util.ArrayList;

public interface IDao<Type> {

    Type getItem(Type item);
    void insertItem(Type item);
    void deleteItem(Type item);
    Type updateItem(Type item);
    ArrayList<Type> getItems();
}
