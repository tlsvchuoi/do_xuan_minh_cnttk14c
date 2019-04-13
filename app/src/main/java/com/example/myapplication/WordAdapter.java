package com.example.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 12/04/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //ID màu nền cho danh sách từ vựng
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> pWords, int colorResourceId) {
        super(context,0, pWords);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Kiểm tra xem View có được tái sử dụng không, nếu không thì inflate view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Lấy đối tượng {@link Word} ở vị trí hiện tại trong danh sách
        Word current_word = getItem(position);

        //Tìm TextView trong layout list_item.xml với ID en_text_view
        TextView enTextView = (TextView) listItemView.findViewById(R.id.en_text_view);
        //Lấy bản dịch tiếng Anh từ đối tượng currentWord và đặt văn bản này lên enTextView
        enTextView.setText(current_word.getEnTranslation());

        //Tìm TextView trong layout list_item.xml với ID vi_text_view
        TextView viTextView = (TextView) listItemView.findViewById(R.id.vi_text_view);
        //Lấy bản dịch tiếng Việt từ đối tượng currentWord và đặt văn bản này lên viTextView
        viTextView.setText(current_word.getViTranslation());

        //Tìm ImageView trong layout list_item.xml với ID ảnh
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Kiểm tra từ này có ảnh hay không
        if (current_word.hasImage()) {
            //Nếu có, hiển thị ảnh theo ID
            imageView.setImageResource(current_word.getImageResourceId());
            //Hiển thị view ảnh
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Nếu không thì ẩn ImageView (set giá trị thành GONE)
            imageView.setVisibility(View.GONE);
        }

        //Set màu cho danh sách item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Tìm màu từ ID
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Đặt màu nền cho View text container
        textContainer.setBackgroundColor(color);

        //Trả về layout danh sách item chứa 2 TextView để hiển thị trên ListView
        return listItemView;
    }

}
