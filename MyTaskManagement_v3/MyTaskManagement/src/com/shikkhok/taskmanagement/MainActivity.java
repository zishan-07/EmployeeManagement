package com.shikkhok.taskmanagement;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etName, etEmail, etPhone, etDesignation, etKeyword, etEID,
			etNewName;
	DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etDesignation = (EditText) findViewById(R.id.etDesignation);
		etKeyword = (EditText) findViewById(R.id.etKeyword);
		etEID = (EditText) findViewById(R.id.etEID);
		etNewName = (EditText) findViewById(R.id.etNewName);
		dbHelper=DatabaseHelper.getInstance(getApplicationContext());
	}

	public void save(View v) {
		String name = etName.getText().toString();
		String email = etEmail.getText().toString();
		String phone = etPhone.getText().toString();
		String designation = etDesignation.getText().toString();

		Employee employee = new Employee(name, email, phone, designation);
		Toast.makeText(getApplicationContext(), employee.toString(),
				Toast.LENGTH_LONG).show();

		long inserted = dbHelper.insertEmployee(employee);
		if (inserted >= 0) {
			Toast.makeText(getApplicationContext(), "Data inserted",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "Data insertion failed...",
					Toast.LENGTH_LONG).show();
		}

	}

	public void view(View v) {
		ArrayList<Employee> employees = dbHelper.getAllEmployees();
		if (employees != null && employees.size() > 0) {
			for (Employee employee : employees) {
				Toast.makeText(getApplicationContext(), employee.toString(),
						Toast.LENGTH_SHORT).show();
			}
		} else if (employees.size() == 0) {
			Toast.makeText(getApplicationContext(), "No data found",
					Toast.LENGTH_SHORT).show();
		}

	}

	public void search(View v) {
		String keyword = etKeyword.getText().toString();
		ArrayList<Employee> employees = dbHelper.searchEmployee(keyword);
		if (employees != null && employees.size() > 0) {
			for (Employee employee : employees) {
				Toast.makeText(getApplicationContext(), employee.toString(),
						Toast.LENGTH_SHORT).show();
			}
		} else if (employees.size() == 0) {
			Toast.makeText(getApplicationContext(), "No data found",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void update(View v) {
		int eid = Integer.parseInt(etEID.getText().toString());
		String newName = etNewName.getText().toString();
		int updated = dbHelper.updateEmployeeName(eid, newName);

		if (updated > 0) {
			Toast.makeText(getApplicationContext(),
					updated + " row(s) updated", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), updated + "No updates",
					Toast.LENGTH_LONG).show();
		}

	}

}
