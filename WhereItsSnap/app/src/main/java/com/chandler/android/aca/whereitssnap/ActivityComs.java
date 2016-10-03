package com.chandler.android.aca.whereitssnap;

public interface ActivityComs {

    void onTitlesListItemSelected(int pos);

    void onTagsListItemSelected(String tag);
}

    /*
    We know that TitlesFragment needs a way to communicate with ViewFragment,
    but also TagsFragment needs a way of telling TitlesFragment which tag it
    would like to use for the criteria to search for database entries with the
    matching tag.

    This same interface will handle all this work. MainActivity can then
    implement the interface and handle the inter-fragment communication.


    We now have two methods we can use for communicating between our Fragment
    classes and MainActivity.

    One (onTitlesListItemSelected) will pass in an int to represent the _id of
    the row in our database of the required Photo object.

    The other (onTagsListItemSelected) will pass a string that is the tag to
    be searched for and matched against rows in the wis_table_photos table.
    */