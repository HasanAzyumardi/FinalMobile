package com.example.h071211076_finalmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class ModelTv implements Parcelable {
    @SerializedName("id")
    private String id;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("name")
    private String originalTitle;

    @SerializedName("first_air_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private Double voteAverage;

    protected ModelTv(Parcel in) {
        id = in.readString();
        backdropPath = in.readString();
        posterPath = in.readString();
        overview = in.readString();
        originalTitle = in.readString();
        releaseDate = in.readString();
        if (in.readByte() == 0) {
            voteAverage = null;
        } else {
            voteAverage = in.readDouble();
        }
    }

    public static final Creator<ModelTv> CREATOR = new Creator<ModelTv>() {
        @Override
        public ModelTv createFromParcel(Parcel in) {
            return new ModelTv(in);
        }

        @Override
        public ModelTv[] newArray(int size) {
            return new ModelTv[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @NonNull
    @Override
    public String toString() {
        return "ModelTv{" +
                "id='" + id + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", voteAverage=" + voteAverage +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(backdropPath);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeString(originalTitle);
        dest.writeString(releaseDate);
        if (voteAverage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(voteAverage);
        }
    }
}
