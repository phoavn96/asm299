package com.example.asmhoa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.asmhoa.expend.AppDatabase;
import com.example.asmhoa.expend.DBHelper;
import com.example.asmhoa.expend.Expend;


public class FAdd extends Fragment implements View.OnClickListener {
    AppDatabase db;
    private Context context;
    EditText edName,edDes,edInfo,edAmount,edDate,edCategory;
    Button add;

    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public FAdd() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FAdd.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static FAdd newInstance(String param1, String param2) {
//        FAdd fragment = new FAdd();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_f_add, container, false);
        db = AppDatabase.getAppDatabase(root.getContext());
        edName = root.findViewById(R.id.edName);
        edAmount = root.findViewById(R.id.edAmount);
        edCategory = root.findViewById(R.id.edCategory);
        edDate = root.findViewById(R.id.edDate);
        edDes = root.findViewById(R.id.edDes);
        edInfo = root.findViewById(R.id.edInfo);
        add = root.findViewById(R.id.btAdd);
        add.setOnClickListener(this);
        return root;
    }

    private void onRegister() {

        Expend expend = new Expend();
        expend.name = edName.getText().toString();
        expend.amount = edAmount.getText().toString();
        expend.detail = edInfo.getText().toString();
        expend.category = edCategory.getText().toString();
        expend.date = edDate.getText().toString();
        expend.des = edDes.getText().toString();


        long id = db.expendDao().insertExpend(expend);


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                onRegister();
                break;
            default:
                break;
        }
    }
}