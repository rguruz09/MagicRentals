package project.team.cmpe277.com.magicrentals.landlord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import project.team.cmpe277.com.magicrentals.R;

/**
 * Created by savani on 5/5/16.
 */
public class EditPropertiesActivity extends AppCompatActivity {

    ArrayList<PropertyModel> mPropertyList;
    PropertiesResultLab mPropertyResultLab;
    PropertyModel mPropertyModel;
    ArrayList<String> listPropertyTypes;
    //  ArrayList<String> bathroomArr;
    ArrayList<String> roomArr;
    EditText area, street, city, state, zip, rent, email, mobile, description;
    Spinner SpinPropertyType, bath, rooms;
    Button btnSubmit;
    String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_upload_data);
         userid = getIntent().getExtras().getString("USERID");
        int selectedLine = getIntent().getExtras().getInt("selectedLine");
        listPropertyTypes = new ArrayList<>();
        System.out.println("Array .property..... "+R.array.property_type);
//        roomArr = new ArrayList<>(R.array.rooms);
       mPropertyResultLab = PropertiesResultLab.getPropertiesResultLab(getApplicationContext());
        mPropertyList = mPropertyResultLab.getPropertyList();
        //mpropertyModel = mPropertyList.get()
        mPropertyModel = mPropertyList.get(selectedLine);
        System.out.println("Modelll........  +++ "+mPropertyModel.getNickname()+"djdjd  .. "+userid);
        Spinner spinProprtyType = (Spinner)findViewById(R.id.property_type);


        spinProprtyType.setSelection(listPropertyTypes.indexOf(mPropertyModel.getProperty_type()));

        area = (EditText)findViewById(R.id.area);
        area.setText(mPropertyModel.getArea());
        street = (EditText)findViewById(R.id.street);
        street.setText(mPropertyModel.getStreet());
        city = (EditText)findViewById(R.id.city);
        city.setText(mPropertyModel.getCity());
        state = ((EditText)findViewById(R.id.state));
        state.setText(mPropertyModel.getState());
        zip = (EditText)findViewById(R.id.zipcode);
        zip.setText(mPropertyModel.getZip());
        rent = (EditText)findViewById(R.id.rent);
        rent.setText(mPropertyModel.getRent());
        email = (EditText)findViewById(R.id.email);
        email.setText(mPropertyModel.getEmail());
        mobile = (EditText)findViewById(R.id.phone);
        mobile.setText(mPropertyModel.getMobile());
        description = (EditText)findViewById(R.id.description);
        description.setText(mPropertyModel.getDescription());

         rooms = (Spinner)findViewById(R.id.roomscount);
        spinProprtyType.setSelection(5);//roomArr.indexOf(mPropertyModel.getRoom()));
         bath = (Spinner)findViewById(R.id.bathroomcount);
        spinProprtyType.setSelection(3);//roomArr.indexOf(mPropertyModel.getBath()));
        //System.out.println("Hello    ......................."+property);
        btnSubmit = (Button) findViewById(R.id.submit1);
        btnSubmit.setText("Save");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Read the data from the form and pass it to the backend service
                // Button btnSubmit = (Button) (v);
                System.out.println("in Savkwjjetwe........................."+v.getId());
                //  Spinner spinProprtyType = (Spinner)v.findViewById(R.id.property_type);
                // property.setProperty_type(spinProprtyType.getSelectedItem().toString());


                mPropertyModel.setArea(area.getText().toString());

                mPropertyModel.setStreet(street.getText().toString());

                mPropertyModel.setCity(city.getText().toString());

                mPropertyModel.setState(state.getText().toString());

                mPropertyModel.setZip(zip.getText().toString());

                mPropertyModel.setRent(rent.getText().toString());

                mPropertyModel.setEmail(email.getText().toString());

                mPropertyModel.setMobile(mobile.getText().toString());

                mPropertyModel.setDescription(description.getText().toString());

                mPropertyModel.setRoom(rooms.getSelectedItem().toString());

                mPropertyModel.setBath(bath.getSelectedItem().toString());
                System.out.println("Hello    ......................."+mPropertyModel + mPropertyModel.getBath());
                //  convert into json and call service..
                PropertiesResultLab.getPropertiesResultLabNew(getApplicationContext());
                Intent i = new Intent(getApplicationContext(), PropertiesListLandlordActivity.class);
                i.putExtra("USERID", userid);
                startActivity(i);



                //user_id , Street , City, State  , Zip    , property_type ,
                // bath , room , area , rent  , email , Mobile , description ,
                // Images (need to decide this yet..), other_details ,  Status , view_count


            }
        } );




    }
}