package com.frn.contactivity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class FragmentOne extends Fragment {
	EditText EmailR, EmailT;
	Button EmailP;
	TimePicker timePicker1;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
		View rootView = inflater.inflate(R.layout.fragment_one, container, false);
		EmailR = (EditText) rootView.findViewById(R.id.EmailR);
		EmailT = (EditText) rootView.findViewById(R.id.EmailT);
		EmailP = (Button) rootView.findViewById(R.id.EmailP);
		timePicker1 = (TimePicker) rootView.findViewById(R.id.timePicker1);
		return rootView;
		
		
		
	}

}
