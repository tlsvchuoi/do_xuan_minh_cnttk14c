package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    //Quản lý việc phát các file âm thanh
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Tạo mảng chứa các từ
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Đỏ", "Red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Vàng", "Yellow", R.drawable.color_yellow, R.raw.color_yellow));
        words.add(new Word("Xanh lá cây", "Green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Nâu", "Brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Xám", "Gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Đen", "Black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Trắng", "White", R.drawable.color_white, R.raw.color_white));

        // Tạo {@link ArrayAdapter}, có nguồn dữ liệu là một danh sách các chuỗi. Các
        // adapter biết cách tạo bố cục cho mỗi mục trong danh sách, sử dụng
        // simple_list_item_1.xml được định nghĩa trong Android Framework.
        // Danh sách item layout này chứa một {@link TextView} duy nhất, mà adapter sẽ đặt thành
        // hiển thị một từ.
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                //Phát file âm thanh
                mMediaPlayer.start();
            }
        });
    }
}
