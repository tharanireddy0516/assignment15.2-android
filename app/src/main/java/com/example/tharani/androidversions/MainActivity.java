package com.example.tharani.androidversions;
//Package objects contain version information about the implementation and specification of a Java package
//import is libraries imported for writing the code
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //public keyword is used in the declaration of a class,method or field;public classes,method and fields can be accessed by the members of any class.
//extends is for extending a class. implements is for implementing an interface
//AppCompatActivity is a class from e v7 appcompat library. This is a compatibility library that back ports some features of recent versions of
// Android to older devices.
    private Toolbar toolbar;
    private Palette mPalette;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    int defaultColor;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//findViewById:A user interface element that displays text to the user.
        if (toolbar != null) {
//if tool bar is not equal to null then we will support the action bar to work
            setSupportActionBar(toolbar);

        }

        getSupportActionBar().setTitle("Android Versions");
        //here we set the title

        //this.getSupportActionBar().hide();

        defaultColor = ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_dark);
//we need to set the color to the every bar
        //Returns a color associated with a particular resource ID
        fab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        getPhoto();
//get the photo
        ////Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //Make a Snackbar to display a message
                //Snackbar will try and find a parent view to hold Snackbar's view from the value given to view. Snackbar will
                // walk up the view tree trying to find a suitable parent, which is defined as a CoordinatorLayout or the window
                // decor's content view, whichever comes first.
                //view	View: The view to find a parent from.
                // text	CharSequence: The text to show. Can be formatted text.
                //duration	int: How long to display the message. Either LENGTH_SHORT or LENGTH_LONG
//Set the action to be displayed in this BaseTransientBottomBar.
                //Parameters
                //resId	int: String resource to display for the action
                //listener	View.OnClickListener: callback to be invoked when the action is clicked

            }
        });

        final String[] myDataset = { "Alpha", "Beta", "CupCake", "Donut",
                "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop","MarshMallow" };
//Set of string values



        //  this setting is used to improve performance if we  know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // using the linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//In contrast to other adapter-backed views such as ListView or GridView, RecyclerView
// allows client code to provide custom layout arrangements for child views
        //layout	RecyclerView.LayoutManager: LayoutManager to use
        // specify an adapter
        //we will send the data from our dataset with help og card view
        mAdapter = new DataAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
//set the adapter
        // Implementation of onItemClick on RecycleView

//An OnItemTouchListener allows the application to intercept touch events in progress at the view hierarchy level of the RecyclerView
// before those touch events are considered for RecyclerView's own scrolling behavior.
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(getApplicationContext(), "Data : " + myDataset[position], Toast.LENGTH_SHORT).show();
// toast:A toast provides simple feedback about an operation in a small popup
                //Make a standard toast that just contains a text view with the text from a resource.

                // Parameters
                //context	Context: The context to use. Usually your Application or Activity object.
                //resId	int: The resource id of the string resource to use. Can be formatted text.
                //duration	int: How long to display the message. Either LENGTH_SHORT or LENGTH_LONG
//show(): it show the toast
            }
        }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //here we get the id of the options
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Add Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "Delete Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
        //returns the item
    }

    private void getPhoto() {
        // a bitmap is a mapping from some domain to bits. It is also called a bit array or bitmap index
        Bitmap photo = BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_delete);
        /**Synonym for opening the given resource and calling decodeResourceStream(Resources, TypedValue, InputStream, Rect, BitmapFactory.Options).
         Parameters
         res	Resources: The resources object containing the image data
         id	int: The resource id of the image data
         opts	BitmapFactory.Options: null-ok; Options that control downsampling and whether the image should be completely decoded, or just is size returned.
         Returns
         Bitmap	The decoded bitmap, or null if the image data could not be decoded, or, if opts is non-null, if opts requested only the size be returned (in opts.outWidth and opts.outHeight)
         Throws
         IllegalArgumentException	if inPreferredConfig is HARDWARE and inMutable is set, if the specified color space is not RGB, or if the specified color space's transfer function is not an ICC parametric curve
         decodeResourceStream**/

        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        mPalette = Palette.generate(photo);
        //A helper class to extract prominent colors from an image.
        applyPalette();
        //applying the palette
    }

    private void applyPalette() {
        //here we are adding the background color
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        mRecyclerView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        toolbar.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        fab.setBackgroundTintList(ColorStateList.valueOf(mPalette.getLightVibrantColor(defaultColor)));

    }
}
