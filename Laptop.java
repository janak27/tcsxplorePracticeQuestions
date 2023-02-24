import java.util.*;

public class Solution{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Laptop[] l  = new Laptop[4];
    for( int i = 0 ; i < l.length; i++){
        
        int laptopId = sc.nextInt();
        sc.nextLine();
        String brand = sc.nextLine();
        String osType = sc.nextLine();
        double price = sc.nextDouble();
        int rating = sc.nextInt();
        sc.nextLine();
        l[i] = new Laptop(laptopId,brand,osType,price,rating);
    }
    
     String input = sc.nextLine();
    
    int result = countOfLaptopsByBrand(l,input);
    if(result==0){
        System.out.println("The given brand is not available");
    }
    else{
        System.out.println(result);
    }
    ///janak
    String input2 =  sc.nextLine();
    
    Laptop[] result2 = searchLaptopByOsType(l,input2);
    
    if(result2.length > 1){
        for(int i=result2.length - 1; i >= 0; i--){
            System.out.println(result2[i].getLaptopId());
            System.out.println(result2[i].getRating());
        }
    }
    
    else{
        System.out.println("no");
    }
    
    
    }
    
    
    public static int countOfLaptopsByBrand (Laptop[] l, String input){
        int  count  = 0;
        for(int i = 0; i < l.length; i++){
            
            if( l[i].getBrand().equalsIgnoreCase(input) && l[i].getRating() > 3){
                count++;
            }
        }
        
        if(count == 0){
            return 0;
        }
        return count;
    }
    
    
    public static Laptop[] searchLaptopByOsType(Laptop[] l, String input2){
        Laptop[] lp = new Laptop[0];
        
        for(int i = 0; i < l.length; i++){
            if(l[i].getOsType().equalsIgnoreCase(input2)){
                lp= Arrays.copyOf(lp,lp.length+1);
                lp[lp.length-1] = l[i];
            }
        }
        
        return lp;
    }
    
    
}


class Laptop{
    
    private int laptopId;
    private String brand;
    private String osType;
    private double price;
    private int rating;
    
    public Laptop(int laptopId, String brand, String osType, double price, int rating){
        this.laptopId = laptopId;
        this.brand = brand;
        this.osType = osType;
        this.price = price;
        this.rating = rating;
        
    }
    
    public int getLaptopId(){
        return laptopId;
    }
    
    public void setLaptopId(int laptopId){
        this.laptopId= laptopId;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
         this.brand = brand;
    }
    
    
    public String getOsType(){
        return osType;
    }
    
    public void setOsType(String osType){
         this.osType = osType;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getRating(){
        return rating;
    }
    
    public void setRating(int rating){
        this.rating = rating;
    }
}
