package com.example.user.lesson_android_development.data;

public class Item {
    public enum ItemType {
        ONE_ITEM, TWO_ITEM, THREE_ITEM;
    }

    private int mImage;
    private String mFirstText;
    private String mSecondText;
    private ItemType type;

    public Item(int image, String firstText, String secondText, ItemType type) {
        mImage = image;
        mFirstText = firstText;
        mSecondText = secondText;
        this.type = type;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getFirstText() {
        return mFirstText;
    }

    public void setFirstText(String firstText) {
        mFirstText = firstText;
    }

    public String getSecondText() {
        return mSecondText;
    }

    public void setSecondText(String secondText) {
        mSecondText = secondText;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}

