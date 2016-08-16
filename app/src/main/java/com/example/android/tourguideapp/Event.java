package com.example.android.tourguideapp;

/**
 * {@link Event} represents an event that the user wants to view.
 * It contains  an event title and an image of the event.
 */

public class Event {

    /**
     * Title for the event
     */
    private String mEventTitle;

    /**
     * Image resource id for the word.
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * @param eventTitle The title of the event.
     */
    public Event(String eventTitle) {
        mEventTitle = eventTitle;
    }

    /**
     * @param eventTitle    The title of the event.
     * @param imageResource The drawable resource ID for the image associated with the word.
     */
    public Event(String eventTitle, int imageResource) {
        mEventTitle = eventTitle;
        mImageResourceId = imageResource;
    }

    /**
     * Get the default event title.
     */
    public String getEventTitle() {
        return mEventTitle;
    }


    /**
     * Return the image resource ID of the event.
     *
     * @return int. The image resource ID.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return Returns weather or not there is an image for this event.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
