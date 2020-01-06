package com.example.miwokapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdaptor extends ArrayAdapter<Words> {

    private int mColorId;

    /**
     * CustomAdaptor constructor call
     * takes in 2 parameters
     * @param context context of the call
     * @param words Words class object containing miwok and english word
     * @param colorId the resource id of colour we want to use
     *
     * no layout parameter taken because we create it in getview method
     */
    public CustomAdaptor(Activity context, ArrayList<Words> words,int colorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView(when using predefined layouts).
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorId = colorId;
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.(Existiing view we can reuse)
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        //view will be null if we are creating the list view for first time

        View listItemView = convertView;
        if (listItemView == null) {

            // layout inflater coverts xml layout file into actual view objects
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_file, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Words currentWord = getItem(position);

        // Find the TextView in the list_file.xml layout with the ID version_name
        TextView miwokTextView = listItemView.findViewById(R.id.miwokTextView);
        // Get the miwok word from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_file.xml layout with the ID version_number
        TextView defaultTextView = listItemView.findViewById(R.id.defaultTextView2);
        // Get the english translation from the current Word object and
        // set this text on the  TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the ImageView in the list_file.xml layout with the ID version_number
        ImageView imageView = listItemView.findViewById(R.id.imageView);

        //checking if call is coming from phrases activity or not
        if (currentWord.getResourceId() != -1){
            //if not,
            // Get the image resource id of the current Word object and
            // set this image on the imageView
            imageView.setImageResource(currentWord.getResourceId());

            // giving so that if we are re using a list item with visibility set as gone it is changed
            imageView.setVisibility(View.VISIBLE);
        }else {
            //if yes hide the image view
            imageView.setVisibility(View.GONE);
        }

        // to find the linear vertical layout with the two text views
        LinearLayout linearLayout = listItemView.findViewById(R.id.textViewLayout);
        //getting color from the color id
        int color = ContextCompat.getColor(getContext(),mColorId);
        //setting it as background of text views
        linearLayout.setBackgroundColor(color);




        return listItemView;
    }
}
