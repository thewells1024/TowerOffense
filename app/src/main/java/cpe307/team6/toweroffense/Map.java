public class Map {
   private int width;
   private int height;
   private List<Location> path;
   private List<List<Tile>> map;

   public Tile getTile(int x, int y){}

   public void setWidth(int width) {
      this.width = width;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public void setPath(List<Location> path) {
      this.path = path;
   }

   public void setMap(List<List<Tile>> map) {
      this.map = map;
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

   public List<List<Tile>> getMap() {
      return map;
   }
}
