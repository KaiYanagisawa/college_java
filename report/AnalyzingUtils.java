import java.io.*;
import java.nio.Buffer;
import java.util.*;

public interface AnalyzingUtils {
  public abstract void loadData(String filename);

  public abstract int getChartIn(String kyoku);
}

class GeneralDatabase {

  ArrayList<General_Item> DataList;

  void printDatabase() {
    for (int i = 0; i < DataList.size(); i++) {
      DataList.get(i).printData();
    }
  }

  int getTrackRanking(String kyoku) {
    return 0;
  }

  void getTop20Artists() {}
}

class WeeklyDatabase extends GeneralDatabase implements AnalyzingUtils {

  ArrayList<General_Item> DataList = new ArrayList<General_Item>();

  public void loadData(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int lineNumber = 0;
      while ((line = reader.readLine()) != null) {
        String[] s = line.split(",");
        Weekly_Item songData = new Weekly_Item();
        if (lineNumber != 0) {
          songData.rank = Integer.parseInt(s[0]);
          songData.artist_names = s[2];
          songData.track_name = s[3];
          songData.source = s[4];
          songData.peak_rank = Integer.parseInt(s[5]);
          songData.previous_rank = Integer.parseInt(s[6]);
          songData.weeks_on_chart = Integer.parseInt(s[7]);
          songData.streams =
            Integer.parseInt(s[8].substring(1, s[8].length() - 1));

          DataList.add(songData);
        }
        lineNumber++;
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public int getChartIn(String kyoku) {
    return 0;
  }

  void printDatabase() {
    for (int i = 0; i < DataList.size(); i++) {
      DataList.get(i).printData();
    }
  }

  int getTrackRanking(String kyoku) {
    return 0;
  }

  void getTop20Artists() {
    ArrayList<Artists> artists = new ArrayList<Artists>();
    for (int i = 0; i < DataList.size(); i++) {
      if (artists.size() == 0) {
        Artists a = new Artists(
          DataList.get(i).artist_names,
          DataList.get(i).streams
        );
        artists.add(a);
      } else {
        boolean equals = false;
        for (int j = 0; j < artists.size(); j++) {
          if (DataList.get(i).artist_names.equals(artists.get(j).artist)) {
            artists.get(j).streamsSum += DataList.get(i).streams;
            equals = true;
          }
        }
        if (!equals) {
          Artists tempArtist = new Artists(
            DataList.get(i).artist_names,
            DataList.get(i).streams
          );
          artists.add(tempArtist);
        }
      }
    }

    //sort
    ArrayList<Artists> sortArtists = artists;
    for (int i = 0; i < artists.size() - 1; i++) {
      Artists topArtists = new Artists(
        artists.get(i).artist,
        artists.get(i).streamsSum
      );
      int max = i;
      for (int j = i + 1; j < artists.size(); j++) {
        if (artists.get(j).streamsSum > artists.get(max).streamsSum) {
          max = j;
        }
      }
      Collections.swap(sortArtists, i, max);
    }

    //print_top20_artists
    for (int i = 0; i < 20; i++) {
      System.out.println(
        i +
        1 +
        ":" +
        sortArtists.get(i).artist +
        ":" +
        sortArtists.get(i).streamsSum
      );
    }
  }
}

class DailyDatabase extends GeneralDatabase implements AnalyzingUtils {

  ArrayList<General_Item> DataList = new ArrayList<General_Item>();

  public void loadData(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int lineNumber = 0;
      while ((line = reader.readLine()) != null) {
        String[] s = line.split(",");
        Daily_Item songData = new Daily_Item();
        if (lineNumber != 0) {
          songData.rank = Integer.parseInt(s[0]);
          songData.artist_names = s[2];
          songData.track_name = s[3];
          songData.source = s[4];
          songData.peak_rank = Integer.parseInt(s[5]);
          songData.previous_rank = Integer.parseInt(s[6]);
          songData.days_on_chart = Integer.parseInt(s[7]);
          songData.streams =
            Integer.parseInt(s[8].substring(1, s[8].length() - 1));

          DataList.add(songData);
        }

        lineNumber++;
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public int getChartIn(String kyoku) {
    return 0;
  }

  void printDatabase() {
    for (int i = 0; i < DataList.size(); i++) {
      DataList.get(i).printData();
    }
  }

  int getTrackRanking(String kyoku) {
    return 0;
  }

  void getTop20Artists() {
    ArrayList<Artists> artists = new ArrayList<Artists>();
    for (int i = 0; i < DataList.size(); i++) {
      if (artists.size() == 0) {
        Artists a = new Artists(
          DataList.get(i).artist_names,
          DataList.get(i).streams
        );
        artists.add(a);
      } else {
        boolean equals = false;
        for (int j = 0; j < artists.size(); j++) {
          if (DataList.get(i).artist_names.equals(artists.get(j).artist)) {
            artists.get(j).streamsSum += DataList.get(i).streams;
            equals = true;
          }
        }
        if (!equals) {
          Artists tempArtist = new Artists(
            DataList.get(i).artist_names,
            DataList.get(i).streams
          );
          artists.add(tempArtist);
        }
      }
    }

    //sort
    ArrayList<Artists> sortArtists = artists;
    for (int i = 0; i < artists.size() - 1; i++) {
      Artists topArtists = new Artists(
        artists.get(i).artist,
        artists.get(i).streamsSum
      );
      int max = i;
      for (int j = i + 1; j < artists.size(); j++) {
        if (artists.get(j).streamsSum > artists.get(max).streamsSum) {
          max = j;
        }
      }
      Collections.swap(sortArtists, i, max);
    }

    //print_top20_artists
    for (int i = 0; i < 20; i++) {
      System.out.println(
        i +
        1 +
        ":" +
        sortArtists.get(i).artist +
        ":" +
        sortArtists.get(i).streamsSum
      );
    }
  }
}
