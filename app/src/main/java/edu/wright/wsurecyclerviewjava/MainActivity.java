package edu.wright.wsurecyclerviewjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/// This is part of the Controller subsystem and exists to load or create
/// the Model subsystem, load or create the View subsystem, and transfer
/// information between the Model and View subsystems.

public class MainActivity extends AppCompatActivity {
    private List m_employees = new ArrayList<IEmployee>();
    private List m_departments = new ArrayList<Department>();
    private RecyclerView m_employeesRecyclerView;
    private RecyclerView m_departmentsRecyclerView;
    private DepartmentAdapter m_departmentAdapter;
    private EmployeeAdapter m_employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareEmployeesData();
        prepareDepartmentsData();


        m_employeesRecyclerView = (RecyclerView) findViewById(R.id.employeesRecyclerView);
        m_employeeAdapter = new EmployeeAdapter(m_employees);
       m_employeesRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        m_employeesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        m_employeesRecyclerView.setAdapter(m_employeeAdapter);

        m_departmentsRecyclerView = (RecyclerView) findViewById(R.id.departmentsRecyclerView);
        m_departmentAdapter = new DepartmentAdapter(m_departments);
        m_departmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        m_departmentsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        m_departmentsRecyclerView.setAdapter(m_departmentAdapter);
    }

    private void prepareEmployeesData() {

        m_employees.add(new Employee("Doe", "John", "Receptionist"));
        m_employees.add(new Employee("Ant", "Adam"));
        m_employees.add(new Employee("Bop", "Betty"));
        m_employees.add(new Employee("Cabbage", "Claude"));
        m_employees.add(new Employee("Doherty", "Debra"));
        m_employees.add(new Employee("Evermore", "Eva"));
        m_employees.add(new Employee("Furter", "Frank"));
        m_employees.add(new Employee("Gunderson", "George"));
        m_employees.add(new Employee("Hamilton", "Henry"));
        m_employees.add(new Employee("Issacson", "Igor"));
        m_employees.add(new Employee("Jewel", "Jacob"));
        m_employees.add(new Employee("Kemp", "Karen"));
        m_employees.add(new Employee("Lambert", "Adam"));
        m_employees.add(new Employee("Mummer", "Betty"));
        m_employees.add(new Employee("Nevis", "Claude"));
        m_employees.add(new Employee("Oliver", "Debra"));
        m_employees.add(new Employee("Patrick", "Eva"));
        m_employees.add(new Employee("Quant", "Frank"));
        m_employees.add(new Employee("Robberts", "George"));
        m_employees.add(new Employee("Smith", "Henry"));
        m_employees.add(new  Employee("Tyson", "Igor"));
        m_employees.add(new Employee("Unangst", "Jacob"));
        m_employees.add(new Employee("Volt", "Karen"));
        m_employees.add(new Employee("Ant", "Amy"));
        m_employees.add(new Employee("Bop", "Bertrand"));
        m_employees.add(new Employee("Cabbage", "Clara"));
        m_employees.add(new Employee("Doherty", "Donald"));
        m_employees.add(new Employee("Evermore", "Ester"));
        m_employees.add(new EmployeeProperties("Zeinith", "Zack"));
        m_employees.add(new EmployeeProperties("Aaron", "Hank", "Hall of Fame Dude"));
    }

    public void prepareDepartmentsData() {
        m_departments.add(new Department("Executive"));
        m_departments.add(new Department("Operations"));
        m_departments.add(new Department("Engineering"));
        m_departments.add(new Department("Sales"));
        m_departments.add(new Department("Admin"));
        m_departments.add(new Department("Quality Assurance"));
    }
}