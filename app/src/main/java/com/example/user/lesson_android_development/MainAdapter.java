package com.example.user.lesson_android_development;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Item;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;


    private LayoutInflater mInflater;
    public ArrayList<Item> itemList = new ArrayList<Item>();

    //constructor
    public MainAdapter(Context context, ArrayList<Item> list) {

        mInflater = LayoutInflater.from(context);
        itemList = list;

    }

    // determine which layout to use for the row, all logik what you need
    @Override
    public int getItemViewType(int position) {
        Item item = itemList.get(position);
        if (item.getType() == Item.ItemType.ONE_ITEM) {
            return TYPE_ONE;
        } else if (item.getType() == Item.ItemType.TWO_ITEM) {
            return TYPE_TWO;
        } else if (item.getType() == Item.ItemType.THREE_ITEM) {
            return TYPE_THREE;
        } else {
            return -1;
        }
    }

    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //use int from viewType and comparison with getItemViewType
        if (viewType == TYPE_ONE) {
            return new ViewHolderOne(mInflater.inflate(R.layout.list_item_one, parent, false));
        } else if (viewType == TYPE_TWO) {
            return new ViewHolderTwo(mInflater.inflate(R.layout.list_item_two, parent, false));
        } else if (viewType == TYPE_THREE) {
            return new ViewHolderThree(mInflater.inflate(R.layout.list_item_three, parent, false));
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        switch (holder.getItemViewType()) {
            // use what case is and throw out data
            case TYPE_ONE:
                ((ViewHolderOne) holder).setupOne(itemList.get(i));
                break;
            case TYPE_TWO:
                ((ViewHolderTwo) holder).setupTwo(itemList.get(i));
                break;
            case TYPE_THREE:
                ((ViewHolderThree) holder).setupThree(itemList.get(i));
                break;
            default:
                break;
        }
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }
}
