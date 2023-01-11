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
}
