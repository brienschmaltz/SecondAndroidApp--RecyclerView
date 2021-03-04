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
/// RecyclerView class may be adapted to display information about Departments.
public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder> {
    private List<Department> m_departments;

    /// ViewHolder exists because creating View instances and/or using
    /// findViewById(R.id.nameText) are slow operations and
    /// fundamental design flaws in Android (in your Instructors opinion).
    /// ViewHolder exists to reduce the number of times a View instance needs
    /// to be created or loaded by reusing the same instances over and over.
    /// Note: iOS UITableView does something similar automatically...
    public class DepartmentViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;

        public DepartmentViewHolder(View view) {
            super(view);
            nameText = (TextView) view.findViewById(R.id.nameText);
        }
    }
    /// This is sorting the department names from A-z by last name.
    public DepartmentAdapter(List<Department> departments) {
        m_departments = departments;
        Collections.sort(m_departments, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
    }


    @NonNull
    @Override
    public DepartmentAdapter.DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.department_row, parent, false);

        return new DepartmentAdapter.DepartmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.DepartmentViewHolder holder, int position) {
        Department department = m_departments.get(position);
        holder.nameText.setText(department.getName());
    }

    @Override
    public int getItemCount() {
        return m_departments.size();
    }
}
