package com.example.stanley.hi_fivolunteeringprototype.dummy;

import android.graphics.drawable.Drawable;
import android.media.Image;

import com.example.stanley.hi_fivolunteeringprototype.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();

//    Array of strings
    public static final ArrayList<String> TITLES = new ArrayList<String>();
    public static final ArrayList<String> LOCATIONS = new ArrayList<String>();
    public static final ArrayList<String> DATES = new ArrayList<String>();
    public static final ArrayList<String> DESCRIPTIONS = new ArrayList<String>();

    public static final ArrayList<Integer> PICTURES = new ArrayList<Integer>();


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }

    static {
        addString("Football tournament");
        addString("Child education");
        addString("Toys collection");
        addString("Food festival");
        /**/addString("Helping the elderly");
        addString("Refugee clothing");
        addString("Kids race");

    }

    static {
        addLocation("Aluche");
        addLocation("La Latina");
        addLocation("Moncloa");
        addLocation("Barcelona");
        /**/addLocation("Lavapies");
        addLocation("Salamanca");
        addLocation("Valencia");


    }

    static {
        addDate("21.06.2019");
        addDate("15.06.2019");
        addDate("14.06.2019");
        addDate("01.07.2019");
      /**/  addDate("07.06.2019");
        addDate("30.06.2019");
        addDate("15.06.2019");

    }

    static {
        addPicture(R.drawable.football);
        addPicture(R.drawable.child_education);
        addPicture(R.drawable.toys_event);
        addPicture(R.drawable.food_festival);
       /**/ addPicture(R.drawable.event_7);
        addPicture(R.drawable.refugee_clothing);
        addPicture(R.drawable.trophy);

    }

    static {
        addDescription("Coaches needed for our youngest teams!");
        addDescription("Do you want to help out our children that need some extra explanations?");
        addDescription("Because every child deserves a present for his or her birthday we are collecting toys.");
        addDescription("We organize a food festival for the homeless people and are looking for people to help share the food fairly");
        /**/   addDescription("In this elderly house we could always use help and you do not need any experience.");
        addDescription("To collect refugee clothes we look for people that want to go and collect clothes at peoples houses.");addDescription("Coaches needed for our youngest teams!");
        addDescription("Do you want to help out our children that need some extra explanations?");

    }

    private static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static void addString(String string) {
        TITLES.add(string);
    }

    private static void addLocation(String string) {
        LOCATIONS.add(string);
    }

    private static void addDate(String string) {
        DATES.add(string);
    }

    private static void addDescription(String string) {
        DESCRIPTIONS.add(string);
    }

    private static void addPicture(Integer drawable) {
        PICTURES.add(drawable);
//        STRING_MAP.put(string, string);
    }

    private static Item createItem(int position) {
        return new Item(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Item {
        public final String id;
        public final String content;
        public final String details;


        public Item(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }

//    public static Image addImage() {
//
//    }
}
