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
		this.rows = data.length;
		this.cols = data[0].length;
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
	
	public void setValueAt(int r, int c, double val)
	{
		data[r][c] = val;
	}
	
	public void setValueAtCoord(Coordinate c, double val)
	{
		data[c.row][c.col] = val;
	}
	
	public double getValueAt(int r, int c)
	{
		return data[r][c];
	}
	
	public double getValueAt(Coordinate c)
	{
		return data[c.row][c.col];
	}
	
	public void ref()
	{
		Coordinate pivot = new Coordinate(0, 0);
		
		int submatrix = 0;
		for(int x = 0; x < data.length; x++)
		{
			pivot = new Coordinate(pivot.row, x);
			
			for(int i = x; i < data[0].length; i++)
			{
				if(!isColumnZeroes(pivot))
				{
					break;
				}
				else
				{
					pivot.col = i;
				}
			}
			
			pivot = findPivot(pivot);
			
			if(getValueAt(pivot) == 0)
			{
				pivot.row++;
				continue;
			}
			
			if(pivot.row != submatrix)
			{
				swapRows(submatrix, pivot.row);
			}
			
			if(getValueAt(pivot) != 1)
			{
				double scale = 1 / getValueAt(pivot);
				scaleRow(pivot.row, scale);
			}
			
			for(int i = pivot.row; i < data.length; i++)
			{
				if(i == pivot.row)
				{
					continue;
				}
				Coordinate belowPiv = new Coordinate(i, pivot.col);
				double complement = -getValueAt(belowPiv) / getValueAt(pivot);
				scaleRowAdd(complement, pivot.row, belowPiv.row);
			}
			submatrix++;
			pivot.row++;
		}
	}
	//currently being worked on
	public void rref()
	{
		ref();
		Coordinate pivot = new Coordinate(0,0);

		int submatrix = 0;
		for (int x = 0; x < data[0].length; x++) 
		{
			pivot = new Coordinate(pivot.row, x);
			for (int i = pivot.row; i >= 0; i--)
			{
				if (i == pivot.row) 
				{
					if (getValueAt(pivot) != 1.0) 
					{
						scaleRow(pivot.row, 1 / getValueAt(pivot));	
					}
					continue;
				}
				if (i == pivot.row) 
				{
					continue;
				}
		
				Coordinate abovePivot = new Coordinate(i, pivot.col);
				double complement = (-getValueAt(abovePivot) / getValueAt(pivot));
				scaleRowAdd(complement, pivot.row, abovePivot.row);
			}
	
			if ((pivot.row + 1) >= data.length || isRowZeroes(new Coordinate(pivot.row+1, pivot.col))) 
			{
				break;
			}
			submatrix++;
			pivot.row++;
		}	
	}
	
	public Coordinate findPivot(Coordinate a)
	{
		int firstRow = a.row;
		Coordinate pivot = new Coordinate(a.row, a.col);
		Coordinate current = new Coordinate(a.row, a.col);
		
		for (int i = a.row; i < (data.length - firstRow); i++) 
		{
			current.row = i;
			if (getValueAt(current) == 1.0) 
			{
				swapRows(current.row, a.row);
			}
		}

		current.row = a.row;
		for (int i = current.row; i < (data.length - firstRow); i++)
		{
			current.row = i;
			if (getValueAt(current) != 0) 
			{
				pivot.row = i;
				break;
			}
		}
		
		return pivot;
	}
	
	public void swapRows(int i, int j)
	{
		for(int col = 0; col < data[0].length; col++)
		{
			double temp = data[i][col];
			data[i][col] = data[j][col];
			data[j][col] = temp;
		}
	}
	
	public void scaleRow(int row, double scale)
	{
		for(int i = 0; i < data[0].length; i++)
		{
			data[row][i] *= scale;
		}
	}
	
	public void scaleRowAdd(double scalar, int row, int addRow)
	{
		for(int i = 0; i < data[0].length; i++)
		{
			data[addRow][i] += data[row][i] * scalar;
		}
	}
	
	public boolean isColumnZeroes(Coordinate c)
	{
		for(int i = 0; i < data.length; i++)
		{
			if(data[i][c.col] != 0.0)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean isRowZeroes(Coordinate c)
	{
		for(int i = 0; i < data[0].length; i++)
		{
			if(data[c.col][i] != 0.0)
			{
				return false;
			}
		}
		return true;
	}
	
	public Matrix setTo(double[][] a)
	{
		Matrix m = new Matrix(a.length, a[0].length);
		for(int i = 0; i < m.getNumRows(); i++)
		{
			for(int j = 0; j < m.getNumCols(); j++)
			{
				m.setValueAt(i, j, a[i][j]);
			}
		}
		return m;
	}
  
	static class Coordinate
	{
		int row;
		int col;
    
		public Coordinate(int r, int c)
		{
			row = r;
			col = c;
		}
	}
  
	public static void main(String[] args)
	{
		Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
		Coordinate c = new Coordinate(1, 0);
		m.ref();
		for(int i = 0; i < m.getNumRows(); i++)
		{
			for(int j = 0; j < m.getNumCols(); j++)
			{
				System.out.print(m.getValueAt(i, j) + " ");
			}
			System.out.println();
		}
	}
}
