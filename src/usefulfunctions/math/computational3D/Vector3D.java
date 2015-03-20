package usefulfunctions.math.computational3D;

public class Vector3D 
{
	private float x, y, z;
	
	public Vector3D()
	{
		setTo(0, 0, 0);
	}
	
	public Vector3D(Vector3D v)
	{
		setTo(v.x, v.y, v.z);
	}
	
	public Vector3D(float x, float y, float z)
	{
		setTo(x, y, z);
	}
	
	public void setTo(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean equals(Vector3D v)
	{
		return(v.x == x && v.y == y && v.z == z);
	}
	
	public boolean equals(float x, float y, float z)
	{
		return (this.x == x && this.y == y && this.z == z);
	}
	
	public void add(float x, float y, float z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void add(Vector3D v)
	{
		add(v.x, v.y, v.z);
	}
	
	public void subtract(float x, float y, float z)
	{
		add(-x, -y, -z);
	}
	
	public void subtract(Vector3D v)
	{
		add(-v.x, -v.y, -v.z);
	}
	
	public void multiply(float s)
	{
		this.x *= s;
		this.y *= s;
		this.z *= s;
	}
	
	public void divide(float s)
	{
		this.x /= s;
		this.y /= s;
		this.z /= s;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x* x + y * y + z * z);
	}
	
	public void normalize()
	{
		divide(length());
	}
}
