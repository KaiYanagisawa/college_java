import java.util.*;

public abstract class General_Item {

  int rank;
  String artist_names;
  String track_name;
  String source;
  int peak_rank;
  int previous_rank;
  int streams;

  General_Item() {
    this.rank = -1;
    this.artist_names = "noname";
    this.track_name = "noname";
    this.source = "nosource";
    this.peak_rank = -1;
    this.previous_rank = -1;
    this.streams = -1;
  }

  abstract void printData();

  abstract int getChart();
}

class Weekly_Item extends General_Item {

  int weeks_on_chart;

  void printData() {
    System.out.println(
      "ランキング:" +
      rank +
      " アーティスト名:" +
      artist_names +
      " 楽曲名:" +
      track_name +
      " チャートイン週数:" +
      weeks_on_chart +
      " ストリーミング回数:" +
      streams
    );
  }

  int getChart() {
    return weeks_on_chart;
  }
}

class Daily_Item extends General_Item {

  int days_on_chart;

  void printData() {
    System.out.println(
      "ランキング:" +
      rank +
      " アーティスト名:" +
      artist_names +
      " 楽曲名:" +
      track_name +
      " チャートイン週数:" +
      days_on_chart +
      " ストリーミング回数:" +
      streams
    );
  }

  int getChart() {
    return days_on_chart;
  }
}

class Artists {

  String artist;
  int streamsSum;

  Artists(String a, int s) {
    artist = a;
    streamsSum = s;
  }
}
