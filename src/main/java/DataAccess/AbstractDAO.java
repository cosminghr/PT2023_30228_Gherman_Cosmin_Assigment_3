package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * In ineriorul acestei clase sunt implementate interogarile si opertiile care vor fi aplicate pe tabele: insert, findAll, findById, update, delete
 * In plus, se creaza o metoda pentru crearea unui tabel
 * @param <T> T=> Clients, Product, Order
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * creaza interogarea pentru a o putea folosi in operatiile cu tabele
     * @param field folosit in clauza where pe post de argument
     * @return un string cu interogarea
     */
    private String createSelectQuery(String field) {
        String query = new String(" SELECT * FROM ordermanagement." + type.getSimpleName().toLowerCase() + " WHERE " + field + " =?");
        return query;
    }

    /**
     * cauta un obiectul t cu id-ul id trimis ca parametru
     * @param id id-ul cautat
     * @return obiectul cautat
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * cauta in baza de date toate obiectele respectivului tabel
     * @return o lista cu obiecte
     */

    public List<T> findAll() {
        String query = new String("SELECT * FROM ordermanagement." + type.getSimpleName().toLowerCase());
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * crearea unei liste plina cu obiecte
     * @param resultSet este rezultatul returnat de interogare
     * @return lista de obiecte
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;

        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * se creaza interogarea pentru insert pentru a o folosi la operatiile cu tabelul
     * @param t obiectul
     * @return string -> interogarea
     */
    public String insertQuery(T t) {
        String query = new String("INSERT INTO ordermanagement." + type.getSimpleName().toLowerCase() + "(");

        String prefix = "";
        for (Field field : type.getDeclaredFields()) {
            String fieldName = field.getName();
            query = query + prefix;
            prefix = ",";
            query = query + fieldName;
        }
        query = query + ") \nVALUES (";
        prefix = "";
        for (Field field : type.getDeclaredFields()) {
            Object value;
            field.setAccessible(true);
            try {
                value = field.get(t);
                query = query + prefix;
                prefix = ",";
                if (value instanceof String)
                    query = query + "'";
                query = query + value.toString();
                if (value instanceof String)
                    query = query + "'";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        query = query + ");";

        return query;
    }

    /**
     * se realizeaza inserarea obiectului t in tabelul dat in interogare
     * @param t obiectul
     * @return t obiectul
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = insertQuery(t);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * se genereaza interogarea delete pentru a o folosi la operatiile cu tabelul
     * @param t obiectul
     * @return string -> interogarea
     */
    public String deleteQuery(T t) {

        String query = new String("DELETE FROM ordermanagement." + type.getSimpleName() + " WHERE id = ");

        Field idField = type.getDeclaredFields()[0];
        idField.setAccessible(true);
        Object value;

        try {
            value = idField.get(t);
            query = query + value;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * sterge obiectul t din tabel
     * @param t obiectul care va fi sters
     * @return t obiectul sters
     */
    public T delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = deleteQuery(t);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * se genereaza interogarea pentru update pentru a o utiliza la operatiile cu tabele
     * @param t obiectul
     * @return string -> interogarea
     */
    public String updateQuery(T t) {
        String query = new String("UPDATE ordermanagement." + type.getSimpleName().toLowerCase() + " SET ");

        String prefix = "";
        Object value;
        try {
            for (Field field : type.getDeclaredFields()) {
                String fieldName = field.getName();
                field.setAccessible(true);
                query = query + prefix + fieldName + " = ";
                prefix = ",";
                value = field.get(t);
                if (value instanceof String) {
                    query = query + "'";
                }
                query = query + value.toString();
                if (value instanceof String)
                    query = query + "'";
            }
            query = query + " WHERE id = ";
            Field idField = type.getDeclaredFields()[0];
            idField.setAccessible(true);
            value = idField.get(t);
            query = query + value;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * se updateaza valorile obiectului t din tabelul respectiv al acestuia
     * @param t obiectul updatat
     * @return t obiectul
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = updateQuery(t);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * se creaza tabelul care va fi acelasi cu cel din baza de date
     * @param list -> lista de obiecte cu care se va popula tabelul
     * @return JTable -> tabelul cu valorile din baza de date
     */
    public JTable createTable(List<T> list) {
        ArrayList<String> columns = new ArrayList<>();

        for (Field f : type.getDeclaredFields()) {
            f.setAccessible(true);
            columns.add(f.getName());
        }
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns.toArray());
        for (Object o : list) {
            ArrayList<Object> objects = new ArrayList<>();
            try {
                for (Field f : type.getDeclaredFields()) {
                    f.setAccessible(true);
                    objects.add(f.get(o));
                }
            } catch (IllegalAccessException exception) {
                exception.printStackTrace();
            }
            tableModel.addRow(objects.toArray());
        }
        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);

        return table;
    }
}
