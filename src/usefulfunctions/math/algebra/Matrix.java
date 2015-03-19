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
}
