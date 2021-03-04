package edu.wright.wsurecyclerviewjava;

/// This class is part of the Model subsystem. Each instance encapsulates
/// information about an Department.
public class Department {
    public Department(String name) {
        m_name= name;
    }

    public String getName() {
        return m_name;
    }

    private String m_name;
}
