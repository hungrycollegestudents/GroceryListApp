public class Item
{
    private final int nS = 1;		//the number of stores currently supported
    private int ID;
    private float price[];	//array size determined by nS
    private int quantity;
    private String name;


    /// Constructors ///

    public Item(String n, int quant) //if they give the quantity + the name
    {
        quantity = quant;
        ID = getID();
        name = n;
        price = new float[nS];
    }
    public Item(String n)			//if they just give the name
    {
        ID = 0;
        float price[] = new float[nS];
        quantity = 1;                   //default quant of 1
        name = n;
    }

    /// Getters and Setters ///

    public int getID()
    {
        return ID;
    }
    public float[] getPrice()
    {
        return price;
    }
    public int getQuant()
    {
        return quantity;
    }
    public String getName()
    {
        return name;
    }
    public void setID(int i)
    {
        ID = i;
    }
    public void setPrice(float p[])
    {
        price = p;
    }
    public void setQuant(int q)
    {
        quantity = q;
    }
    public void setName(String n)
    {
        name = n;
    }

    /// Methods ///

    public int getIDAPI()		//interfaces w an API
    {
        int id = 0;
        //id = findItemWal(name);		//placeholder -  finds the ID number from an API
        return id;
    }
    public float[] getPriceAPI()	//interfaces w an API
    {
        float[] P = new float[nS];
        float p = 0;
        for(int x = 0; x < price.length; x++)
        {
            if(x == 0)				//currently does nothing but will be more useful later when there's more than 1 location
                //p = findPriceWal(ID); //placeholder, returns float value of the cost of the item
                P[x] = p;
        }
        return P;
    }
}
