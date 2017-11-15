import java.util.List;
public class Map {
   private final int width;
   private final int height;
   private final List<Location> path;
   private List<List<Tile>> map;

   public Map( int width, int height, List<Location> path) {
      this.width = width;
      this.height = height;
      this.path = path;
      this.map = map;
   }
   
   public Tile getTile(int x, int y){
      return map.get(x).get(y);
   }
   
   public int getWidth() {
      return width;
   }
   
   public int getHeight() {
      return height;
   }
   
   public List<Location> getPath() {
      return path;
   }
}
