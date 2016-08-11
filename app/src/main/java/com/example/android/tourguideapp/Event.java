package com.example.android.tourguideapp;

/**
 * {@link Event} represents a vocabulary word that the user wants to learn.
 * It contains  a default translation and a Miwok translation for that word.
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

//    /**
//     * Audio resource id for the word.
//     */
//    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * @param eventTitle       The title of the event.
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
     * Get the default translation of the word.
     */
    public String getEventTitle() {
        return mEventTitle;
    }


    /**
     * Return the image resource ID of the word.
     *
     * @return int. The image resource ID.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return Returns weather or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
