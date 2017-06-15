package com.development.tylerwindham.liscensescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.development.tylerwindham.licenseObjects.Address;
import com.development.tylerwindham.licenseObjects.PersonalInfo;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayDataActivity extends AppCompatActivity {

    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "BarcodeMain";

    public final String Customer_Family_Name = "DCS", Customer_Given_Name = "DCT",
            Street_Address_1 = "DAG", City = "DAI", Jurisdction_Code = "DAJ", Postal_Code = "DAK",
            Customer_Id_Number = "DAQ", Date_Of_Birth = "DBB";

    private PersonalInfo personalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        Intent intent = getIntent();
        //String data = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Barcode barcode = (Barcode)intent.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
        //// TODO: Need to pass result. For now, pass success always.
        int requestCode = RC_BARCODE_CAPTURE;
        int resultCode = CommonStatusCodes.SUCCESS;
        onBarcodeParsing(requestCode, resultCode, intent);

        setValues();
    }

    public void setValues(){
        EditText etFistName = (EditText)findViewById(R.id.etFirstName);
        etFistName.setText(personalInfo.getFirstName());
        EditText etMiddleName = (EditText)findViewById(R.id.etMiddleName);
        etMiddleName.setText(personalInfo.getMiddleInitial());
        EditText etLastName = (EditText)findViewById(R.id.etLastName);
        etLastName.setText(personalInfo.getLastName());
        EditText etAddress = (EditText)findViewById(R.id.etAddress);
        etAddress.setText(personalInfo.getAddress().toString());
        EditText etDriverLicense = (EditText)findViewById(R.id.etDriverLicense);
        etDriverLicense.setText(personalInfo.getLicenseNumber());
        EditText etDateOfBirth = (EditText)findViewById(R.id.etDateOfBirth);
        etDateOfBirth.setText(personalInfo.getDateOfBirth());
    }

    public void onGoTakePicture(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onGoVehicle(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void onBarcodeParsing(int requestCode, int resultCode, Intent data) {
        ArrayList<String> allKeys = new ArrayList<String>();
        allKeys.add(Customer_Family_Name);
        allKeys.add(Customer_Given_Name);
        allKeys.add(Street_Address_1);
        allKeys.add(City);
        allKeys.add(Jurisdction_Code);
        allKeys.add(Postal_Code);
        allKeys.add(Customer_Id_Number);
        allKeys.add(Date_Of_Birth);
        HashMap<String, String> myData = new HashMap<String, String>();
        Address address = new Address();
        personalInfo = new PersonalInfo();

        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    String barcodeResult = barcode.rawValue;
                    String lines[] = barcodeResult.split("\\r?\\n");
                    for (int i = 0; i < lines.length; i++)
                    {
                        String str = lines[i];
                        if (str.contains("ANSI"))
                        {
                            str = str.substring(str.indexOf("DL"));
                            String str1[] = str.split("DL");
                            if (str1.length > 1)
                            {
                                str = str1[str1.length - 1];
                            }
                        }
                        if (str.length() > 3)
                        {
                            String key = str.substring(0, 3);
                            String value = str.substring(3);
                            if (allKeys.contains(key))
                            {
                                if (!value.equalsIgnoreCase("None"))
                                {
                                    myData.put(allKeys.get(allKeys.indexOf(key)), value);
                                }
                            }
                        }
                        Log.e("RESULT ", "<<>>" + lines[i]);
                    }
                    if (myData.containsKey(Customer_Family_Name))
                    {
                        Log.v("TAG", "users family name:" + myData.get(Customer_Family_Name));
                        String lname = myData.get(Customer_Family_Name).trim();
                        personalInfo.setLastName(lname);

                    }
                    if (myData.containsKey(Customer_Given_Name))
                    {
                        Log.v("TAG", "users Given name:" + myData.get(Customer_Given_Name));
                        try
                        {
                            String CustomerName[] = myData.get(Customer_Given_Name).split(" ");
                            String fname = CustomerName[0].trim();
                            String mname = CustomerName[1].substring(0, 1).trim();
                            personalInfo.setFirstName(fname);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (myData.containsKey(Street_Address_1))
                    {
                        Log.v("TAG", "Address line 1 :" + myData.get(Street_Address_1));
                        try
                        {
                            String addressLine = myData.get(Street_Address_1).trim();
                            address.setStreet(addressLine);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (myData.containsKey(City))
                    {
                        Log.v("TAG", "City:" + myData.get(City));
                        String city = myData.get(City).trim();
                        address.setCity(city);
                    }
                    if (myData.containsKey(Postal_Code))
                    {
                        Log.v("TAG", "Pin Code:" + myData.get(Postal_Code));
                        String zipcode = myData.get(Postal_Code).substring(0, 5).trim();
                        address.setZipCode(zipcode);
                    }
                    if (myData.containsKey(Jurisdction_Code))
                    {
                        Log.v("TAG", "State:" + myData.get(Jurisdction_Code));
                        String state = myData.get(Jurisdction_Code);
                        address.setState(state);
                    }
                    if (myData.containsKey(Date_Of_Birth))
                    {
                        Log.v("TAG", "Birth Date    :" + myData.get(Date_Of_Birth));
                        String birthday = myData.get(Date_Of_Birth).substring(0, 2) + "/" + myData.get(Date_Of_Birth).substring(2, 4)
                                + "/" + myData.get(Date_Of_Birth).substring(4);
                        personalInfo.setDateOfBirth(birthday);
                    }
                    if (myData.containsKey(Customer_Id_Number))
                    {
                        String licence_number = myData.get(Customer_Id_Number).trim();
                        Log.e("TAG", "Licence Number is :" + licence_number);
                        personalInfo.setLicenseNumber(licence_number);
                    }
                    personalInfo.setAddress(address);
                    Log.d(TAG, "Barcode read: " + barcode.displayValue);

                } else {
//                    statusMessage.setText(R.string.barcode_failure);
                    Log.d(TAG, "No barcode captured, intent data is null");
                }
            } else {
//                statusMessage.setText(String.format(getString(R.string.barcode_error),
//                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
