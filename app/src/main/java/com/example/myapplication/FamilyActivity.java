package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Tạo mảng chứa các từ
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Bố", "Father", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mẹ", "Mother", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Con trai", "Son", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Con gái", "Daughter", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Anh trai", "Older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Em trai", "Younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Chị gái", "Older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Em gái", "Younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Bà", "Grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Ông", "Grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                //Phát file âm thanh
                mMediaPlayer.start();
            }
        });
    }
}
