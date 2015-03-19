package usefulfunctions.math.algebra;
public class Matrix
{
  private double[][] data;
  private int rows;
  private int cols;
  
  public Matrix(int rows, int cols)
  {
    this.rows = rows;
    this.cols = cols;
    data = new double[rows][cols];
  }
  
  public Matrix(double[][] data)
  {
    this.data = data;
  }
  
  public int getNumCols()
  {
    return cols;
  }
  
  public int getNumRows()
  {
    return rows;
  }
  
  class Coordinate
  {
    private int row;
    private int col;
    
    public Coordinate(int row, int col)
    {
      this.row = row;
      this.col = col;
    }
    
    public double getValueAtCoord(Coordinate c)
    {
      return data[c.row][c.col];
    }
    
    public void setValueAtCoord(Coordinate c, double val)
    {
      data[c.row][c.col] = val;
    }
  }
}
