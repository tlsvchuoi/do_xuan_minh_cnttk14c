package com.example.myapplication;

//Lớp Word {@link Word} đại diện cho từ vựng mà người dùng muốn học.
//Nó chứa một bản dịch tiếng Việt và bản dịch tiếng Anh cho từ đó.
public class Word {

    //Từ tiếng Việt
    private String mViTranslation;

    //Từ tiếng Anh
    private String mEnTranslation;

    //Âm thanh
    private int mAudioResourceId;

    //ID ảnh
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Giá trị hằng số không cung cấp ảnh cho từ vựng
    private static final int NO_IMAGE_PROVIDED = -1;


    /* Tạo mới một đối tượng của lớp Word
     * @thông số viTranslation là từ tiếng Việt
     * @thông số enTranslation là từ tiếng Anh
     */
    public Word(String viTranslation, String enTranslation, int audioResourceId){
        mViTranslation = viTranslation;
        mEnTranslation = enTranslation;
        mAudioResourceId = audioResourceId;
    }

    /* Tạo mới một đối tượng của lớp Word
    * @thông số viTranslation là từ tiếng Việt
    * @thông số enTranslation là từ tiếng Anh
    * @thông số imageResourceId là ảnh minh họa
    */
    public Word(String viTranslation, String enTranslation, int imageResourceId, int audioResourceId){
        mViTranslation = viTranslation;
        mEnTranslation = enTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //Lấy từ tiếng Việt
    public String getViTranslation(){
        return mViTranslation;
    }

    //Lấy từ tiếng Anh
    public String getEnTranslation(){
        return mEnTranslation;
    }

    //Trả về ID ảnh tương ứng với từ
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Cho biết từ vựng có ảnh hay không
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //Trả về ID của file âm thanh
    public int getAudioResourceId() { return mAudioResourceId; }

}
