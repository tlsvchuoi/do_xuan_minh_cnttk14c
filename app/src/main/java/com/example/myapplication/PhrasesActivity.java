package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Tạo mảng chứa các từ
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Xin chào!", "Hello!", R.raw.phrase_hello));
        words.add(new Word("Bạn tên là gì?", "What is your name?", R.raw.phrase_what_is_your_name));
        words.add(new Word("Tôi tên là...", "My name is...", R.raw.phrase_my_name_is));
        words.add(new Word("Bạn cảm thấy thế nào?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Rất tốt.", "Very good.", R.raw.phrase_very_good));
        words.add(new Word("Anh ta là...", "He is...", R.raw.phrase_he_is));
        words.add(new Word("Cô ấy là...", "Her name is...", R.raw.phrase_her_name_is));
        words.add(new Word("Tôi thích nghe nhạc.", "I like listening to music.", R.raw.phrase_i_like_listening_to_music));
        words.add(new Word("Bạn có rảnh không?", "Are you free?", R.raw.phrase_are_you_free));
        words.add(new Word("Chào mừng bạn đến Việt Nam!", "Welcome to Viet Nam!", R.raw.phrase_welcome_to_vietnam));

        // Tạo {@link ArrayAdapter}, có nguồn dữ liệu là một danh sách các chuỗi. Các
        // adapter biết cách tạo bố cục cho mỗi mục trong danh sách, sử dụng
        // simple_list_item_1.xml được định nghĩa trong Android Framework.
        // Danh sách item layout này chứa một {@link TextView} duy nhất, mà adapter sẽ đặt thành
        // hiển thị một từ.
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.primary_dark_color);

        // Tìm đối tượng {@link ListView} trong view hierarchy của {@link Activity}.
        // Cần có một {@link ListView} với ID là list, được khai báo trong
        // tệp bố cục word_list
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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                //Phát file âm thanh
                mMediaPlayer.start();
            }
        });
    }
}
