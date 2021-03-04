package edu.wright.wsurecyclerviewjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/// This class exists to implement the "Adapter" design pattern and provide
/// View Holders to RecyclerView instances so that teh generic reusable
/// RecyclerView class may be adapted to display information about Employees.

///////////////////////////////// My Comments //////////////////////////////////
/// This is the same as the DepartmentAdapter except it has been modified to use an IEmployee list instead of a list of departments.
/// IEmployee is used because it is required when any object is used to store information about an employee.
/// I believe if you implemented a IDepartment Interface then departmentAdapter would have to make a similar change.

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<IEmployee> e_Employee;

    /// ViewHolder exists because creating View instances and/or using
    /// findViewById(R.id.nameText) are slow operations and
    /// fundamental design flaws in Android (in your Instructors opinion).
    /// ViewHolder exists to reduce the number of times a View instance needs
    /// to be created or loaded by reusing the same instances over and over.
    /// Note: iOS UITableView does something similar automatically...
    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameText;
        public TextView lastNameText;
        public TextView titleText;

        /// This is slightly different from departmentAdapter as instead of one text view we have 3, so create the appropriate ones for first, last name, title.
        public EmployeeViewHolder(View view) {
            super(view);
            firstNameText = (TextView) view.findViewById(R.id.firstNameText);
            lastNameText = (TextView) view.findViewById(R.id.lastNameText);
            titleText  = (TextView) view.findViewById(R.id.titleText);
        }
    }
    /// This is sorting the employees from A-z by last name.
    public EmployeeAdapter(List<IEmployee> employees) {
        e_Employee = employees;
        Collections.sort(e_Employee, new Comparator<IEmployee>() {
            @Override
            public int compare(IEmployee o1, IEmployee o2) {
                return (o1.getLastName().compareTo(o2.getLastName()));
            }
        });
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_row, parent, false);

        return new EmployeeAdapter.EmployeeViewHolder(itemView);
    }

    /// This is slightly different from departmentAdapter as well as we set the text for 3 view holders.
    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        IEmployee Employee = e_Employee.get(position);
        holder.firstNameText.setText(Employee.getFirstName());
        holder.lastNameText.setText(Employee.getLastName());
        holder.titleText.setText(Employee.getTitle());
    }


    @Override
    public int getItemCount() {
        return e_Employee.size();
    }
}
