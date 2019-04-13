package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Tạo mảng chứa các từ
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Một","One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Hai","Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Ba","Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Bốn","Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Năm","Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Sáu","Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Bảy","Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Tám","Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Chín","Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Mười","Ten", R.drawable.number_ten, R.raw.number_ten));

        // Tạo {@link ArrayAdapter}, có nguồn dữ liệu là một danh sách các chuỗi. Các
        // adapter biết cách tạo bố cục cho mỗi mục trong danh sách, sử dụng
        // simple_list_item_1.xml được định nghĩa trong Android Framework.
        // Danh sách item layout này chứa một {@link TextView} duy nhất, mà adapter sẽ đặt thành
        // hiển thị một từ.
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.primary_dark_color);

        // Tìm đối tượng {@link ListView} trong view hierarchy của {@link Activity}.
        // Cần có một {@link ListView} với ID là list, được khai báo trong
        // tệp bố cục word_list.xml
        ListView listView = (ListView) findViewById(R.id.list);

        // Thực hiện {@link ListView} sử dụng {@link ArrayAdapter} đã tạo ra ở trên để
        // {@link ListView} sẽ hiển thị danh sách item cho mỗi từ trong danh sách.
        // Thực hiện việc này bằng cách gọi phương thức setAdapter trên đối tượng {@link ListView} và chuyển qua
        // 1 đối số, đó là {@link ArrayAdapter} với tên biến là itemAdapter.
        listView.setAdapter(adapter);

        //Tạo click listener để phát âm thanh khi bấm vào item trong list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Nhận biết từ nào đang được bấm vào bằng cách xác định vị trí bấm
                Word word = words.get(position);

                //Tạo và cài đặt file âm thanh gắn với từ đang được chọn
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                //Phát file âm thanh
                mMediaPlayer.start();
            }
        });
    }
}
