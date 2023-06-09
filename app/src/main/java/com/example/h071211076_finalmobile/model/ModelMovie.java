package com.example.h071211076_finalmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class ModelMovie implements Parcelable {
    private String titleMovie;
    private String posterMovie;
    private String releaseDateMovie;
    private String ratingMovie;
    private int idMovie;


    @SerializedName("overview")

    private String overviewMovie;

    public ModelMovie(String titleMovie, String posterMovie, String releaseDateMovie) {
        this.titleMovie = titleMovie;
        this.posterMovie = posterMovie;
        this.releaseDateMovie = releaseDateMovie;
    }

    public ModelMovie(String titleMovie, String posterMovie, String releaseDateMovie, String ratingMovie, int idMovie, String overviewMovie) {
        this.titleMovie = titleMovie;
        this.posterMovie = posterMovie;
        this.releaseDateMovie = releaseDateMovie;
        this.ratingMovie = ratingMovie;
        this.idMovie = idMovie;
        this.overviewMovie = overviewMovie;
    }

    protected ModelMovie(Parcel in) {
        titleMovie = in.readString();
        posterMovie = in.readString();
        releaseDateMovie = in.readString();
        ratingMovie = in.readString();
        idMovie = in.readInt();
        overviewMovie = in.readString();
    }

    public static final Creator<ModelMovie> CREATOR = new Creator<ModelMovie>() {
        @Override
        public ModelMovie createFromParcel(Parcel in) {
            return new ModelMovie(in);
        }

        @Override
        public ModelMovie[] newArray(int size) {
            return new ModelMovie[size];
        }
    };

    public String getTitleMovie() {
        return titleMovie;
    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public String getReleaseDateMovie() {
        return releaseDateMovie;
    }

    public String getRatingMovie() {
        return ratingMovie;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public String getOverviewMovie() {
        return overviewMovie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titleMovie);
        parcel.writeString(posterMovie);
        parcel.writeString(releaseDateMovie);
        parcel.writeString(ratingMovie);
        parcel.writeInt(idMovie);
        parcel.writeString(overviewMovie);
    }

    @Override
    public String toString() {
        return "ModelMovie{" +
                "titleMovie='" + titleMovie + '\'' +
                ", posterMovie='" + posterMovie + '\'' +
                ", releaseDateMovie='" + releaseDateMovie + '\'' +
                ", ratingMovie='" + ratingMovie + '\'' +
                ", idMovie=" + idMovie +
                ", overviewMovie='" + overviewMovie + '\'' +
                '}';
    }
}
