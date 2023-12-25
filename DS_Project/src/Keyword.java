public class Keyword {
	
	public String name;
	public int count;
	public double weight;
	
	public Keyword(String name, int count, double weight) {
		this.name = name;
		this.count = count;
		this.weight = weight; 
		
	}
	
	public Keyword(String name, int count){
		this.name = name;
		this.count = count;
    }
	
    public int getCount() {
    	return count;
    }
    
    public String getName() {
    	return name;
    }
    
    public double getWeight() {
    	return weight;
    }
    
    public String toString() {
		return "";   //not yet confirmed
    }
    
}