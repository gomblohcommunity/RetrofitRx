package id.web.dstwn.retrofitrx.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataModel implements Parcelable {
    @SerializedName("campus")
    private String campus;

    @SerializedName("name")
    private String name;

    @SerializedName("prodi")
    private String prodi;

    protected DataModel(Parcel in) {
        campus = in.readString();
        name = in.readString();
        prodi = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public void setCampus(String campus){
        this.campus = campus;
    }

    public String getCampus(){
        return campus;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setProdi(String prodi){
        this.prodi = prodi;
    }

    public String getProdi(){
        return prodi;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "campus = '" + campus + '\'' +
                        ",name = '" + name + '\'' +
                        ",prodi = '" + prodi + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(campus);
        dest.writeString(name);
        dest.writeString(prodi);
    }
}
