package com.example.fragment2studentworked;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calcul extends Fragment {
    View view;
    Button draw1B, btnAdd,btnSub,btnMult,btnDiv, calculate;
    EditText etNum1, etNum2;
    TextView    tvResult;
    float num1 = 0; float num2 = 0;
    float result = 0; String oper = "";
    @Override
    public View onCreateView(LayoutInflater  inflater, ViewGroup container,
                             Bundle  savedInstanceState) {
        // Inflate the layout for this        fragment
        view = inflater.inflate(R.layout.calc_main, container, false);
        // get the reference of Button
        etNum1 =
                (EditText)view.findViewById(R.id.etNum1);
        etNum2 = (EditText)
                view.findViewById(R.id.etNum2);
        btnAdd = (Button)
                view.findViewById(R.id.btnAdd);
        btnSub = (Button)
                view.findViewById(R.id.btnSub);
        btnMult = (Button)
                view.findViewById(R.id.btnMult);
        btnDiv = (Button)
                view.findViewById(R.id.btnDiv);
        tvResult = (TextView)
                view.findViewById(R.id.tvResult);
        num1 = 0; num2 = 0; result = 0;
        oper = "";
        View.OnClickListener onClickListener = new
                View.OnClickListener()
                {
                    // @Override
                    public void onClick(View v) {
                        if
                        (TextUtils.isEmpty(etNum1.getText().toString(
                        ))
                                ||
                                TextUtils.isEmpty(etNum2.getText().toString()
                                )) { return ; }
                        num1 =
                                Float.parseFloat(etNum1.getText().toString())
                        ;
                        num2 =
                                Float.parseFloat(etNum2.getText().toString())
                        ;
                        switch (v.getId()) {
                            case R.id.btnAdd:
                                oper = "+";
                                result = num1 + num2;
                                break;
                            case R.id.btnSub:
                                oper = "-";
                                result = num1 - num2;
                                break;
                            case R.id.btnMult:
                                oper = "*";
                                result = num1 * num2;
                                break;
                            case R.id.btnDiv:
                                oper = "/";
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                        tvResult.setText(num1 + " " +
                                oper + " " + num2 + " = " + result);
                        Toast.makeText(getActivity(),
                                "Calc activated: "+ result,
                                Toast.LENGTH_LONG).show();
                    }
                };

        btnAdd.setOnClickListener(onClickListener);

        btnSub.setOnClickListener(onClickListener);

        btnMult.setOnClickListener(onClickListener);
        btnDiv.setOnClickListener(onClickListener);
        return view;
    }
}
