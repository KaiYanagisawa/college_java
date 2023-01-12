import java.util.*;

public interface AnalyzingUtils {
  public abstract void loadData(String filename);

  public abstract int getChartIn(String kyoku);
}

class GeneralDatabase {
  ArrayList<General_Item> DataList;

  void printDatabase() {
  }

  int getTrackRanking(String s) {
  }
  
  void getTop20Artists() {
  }
}

class WeeklyDatabase extends GeneralDatabase implements AnalyzingUtils {
  ArrayList<GeneralDatabase> DataList;

  public void loadData(String filename) {
  }

  public int getChartIn(String kyoku) {
  }
  
  void printDatabase() {
  }

  int getTrackRanking(String kyoku) {
  }

  void getTop20Artists() {
  }
}

class DailyDatabase extends GeneralDatabase implements AnalyzingUtils {
  ArrayList<GeneralDatabase> DataList;

  public void loadData(String filename) {
  }

  public int getChartIn(String kyoku) {
  }
  
  void printDatabase() {
  }

  int getTrackRanking(String kyoku) {
  }

  void getTop20Artists() {
  }
}