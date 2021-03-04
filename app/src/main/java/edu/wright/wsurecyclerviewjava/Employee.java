package edu.wright.wsurecyclerviewjava;

/// This class is part of the Model subsystem. Each instance encapsulates
/// information about an Employee.
public class Employee implements IEmployee {
    public Employee(String lastName, String firstName, String title) {
        m_lastName = lastName;
        m_firstName = firstName;
        m_title = title;
    }

    public Employee(String lastName, String firstName) {
        m_lastName = lastName;
        m_firstName = firstName;
        m_title = "No Title";
    }

    public String getLastName() {
        return m_lastName;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public String getTitle() {
        return m_title;
    }

    private String m_lastName;
    private String m_firstName;
    private String m_title;
}
