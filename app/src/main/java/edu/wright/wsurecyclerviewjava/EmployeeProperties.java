package edu.wright.wsurecyclerviewjava;

import java.util.Dictionary;
import java.util.Hashtable;

/// This class is part of the Model subsystem. Each instance encapsulates
/// information about an Employee in such a way that arbitrary "extra"
// information may be stored per employee.
public class EmployeeProperties implements IEmployee {
    private Dictionary<String, String> m_properties = new Hashtable<>();

    public EmployeeProperties(String lastName, String firstName, String title) {
        m_properties.put("lastName", lastName);
        m_properties.put("firstName", firstName);
        m_properties.put("title", title);
    }

    public EmployeeProperties(String lastName, String firstName) {
        m_properties.put("lastName", lastName);
        m_properties.put("firstName", firstName);
        m_properties.put("title", "No Title");
    }

    public String getLastName() {
        return m_properties.get("lastName");
    }

    public String getFirstName() {
        return m_properties.get("firstName");
    }

    public String getTitle() {
        return m_properties.get("title");
    }

}
