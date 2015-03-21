package usefulfunctions.math.algebra;

public class Complex 
{
	private double real, imag;
	
	public Complex(double imag, double real)
	{
		this.real = real;
		this.imag = imag;
	}
	
	public String toString()
	{
		if(imag != 0)
		{
			if(real >= 0)
			{
				return imag + "i + " + real;
			}
			else
			{
				return imag + "i - " + -real;
			}
		}
		return real + " ";
	}

	public double getReal() 
	{
		return real;
	}

	public void setReal(double real) 
	{
		this.real = real;
	}

	public double getImag() 
	{
		return imag;
	}

	public void setImag(double imag) 
	{
		this.imag = imag;
	}
	
}
