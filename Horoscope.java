import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;

/**
 * Write a description of class Horoscope here.
 *
 * @author Sergio Gomez Morado
 * @version 1/3/2026
 */
public class Horoscope
{
    // instance variables 
    public TreeMap <String , TreeSet<Integer>> signs = new TreeMap<>();
    public TreeMap <String , ArrayList<String>> matches = new TreeMap<>();

    /**
     * Constructor for objects of class Horoscope
     */
    public Horoscope()
    {
        // initialise instance variables
        signs = new TreeMap<>();
        matches = new TreeMap<>();
        populateSigns();
        populateMatches();
    }

    /**
     * This function generates the TreeMap signs. Each sign is created as a key,
     * and each key is associated with a TreeSet containing the corresponding birth years, 
     * with years occurring in 6-year cycles.
     */
    public void populateSigns()
    {
    TreeSet<Integer> sign1 = new TreeSet<>();  //The set is created in which we will store the same sign every 6 years.
    for(int year =1960 ; year < 2020 ; year += 6){ //We used the for loop illustrated in chapter 7, starting in 1960, every 6 years and ending in 2019.
        sign1.add(year); //We store it each year in the set declared as sign 1 above.
    }
    signs.put("Man United",sign1); //This TreeSet, in turn, is inside a TreeMap. The same key will always use the year of the same TreeSet
    
    //The same process is repeated for the 6 signs. A TreeSet is created for each one, and a different sign is assigned to it within the TreeMap.
    
    TreeSet<Integer> sign2 = new TreeSet<>();
    for(int year = 1961 ; year < 2020 ; year += 6){//In each for loop, the starting year must be changed so that each sign has its own year in order.
        sign2.add(year);
        }
    signs.put("PSG",sign2);
    
    TreeSet<Integer> sign3 = new TreeSet<>();
    for(int year = 1962 ; year < 2020 ; year += 6){
        sign3.add(year);
        }
    signs.put("Celta de Vigo",sign3);
    
    TreeSet<Integer> sign4 = new TreeSet<>();
    for(int year = 1963 ; year < 2020 ; year += 6){
        sign4.add(year);
        }
    signs.put("Barcelona",sign4);
    
    TreeSet<Integer> sign5 = new TreeSet<>();
    for(int year = 1964 ; year < 2020 ; year += 6){
        sign5.add(year);
        }
    signs.put("Real Madrid",sign5);
    
    TreeSet<Integer> sign6 = new TreeSet<>();
    for(int year = 1965 ; year < 2020 ; year += 6){
        sign6.add(year);
        }
    signs.put("Man City",sign6);
        
    }
    /**
     * Create a TreeMap that stores each signs as a key, and an ArrayList with its compatible symbols as a value.
     * All signs must be reciprocal.
     */
    
    public void populateMatches()
    {
        ArrayList <String> UnitedMatch = new ArrayList<>(); //An Arraylist is created with the compatible signs of each sign.
        UnitedMatch.add("Real Madrid");
        UnitedMatch.add("PSG");
        matches.put("Man United", UnitedMatch); //The List is associated with its corresponding sign within the Treemap
        
        ArrayList <String> PSGMatch = new ArrayList<>(); //The process is repeated, so that the compatibilities of each sign are reciprocal.
        PSGMatch.add("Real Madrid");
        PSGMatch.add("Man United");
        matches.put("PSG", PSGMatch);
        
         ArrayList <String> CltMatch = new ArrayList<>();
        CltMatch.add("Barcelona");
        CltMatch.add("Man City");
        matches.put("Celta de Vigo", CltMatch);
        
          ArrayList <String> BcnMatch = new ArrayList<>();
        BcnMatch.add("Man City");
        BcnMatch.add("Celta de Vigo");
        matches.put("Barcelona", BcnMatch);
        
          ArrayList <String> RealMatch = new ArrayList<>();
        RealMatch.add("Man United");
        RealMatch.add("PSG");
        matches.put("Real Madrid", RealMatch);
        
          ArrayList <String> CityMatch = new ArrayList<>();
        CityMatch.add("Barcelona");
        CityMatch.add("Celta de Vigo");
        matches.put("Man City", CityMatch);
    }
    /**
     * Returns the name of the sign associated with a specific birth year by searching the signs map
     * @param year The birth year to search for.
     * @return The name of the sign if found, or null if the year is incorrect.
     */
    public String findSign(int year) //We use a for-each loop to iterate through the keys (different signs)
    {
    for (String SignName : signs.keySet()){ //Each key from the TreeMap signs is copied into a temporary String variable SignName
        TreeSet<Integer> CheckYear = signs.get(SignName);// We use this temporary variable to iterate through the different TreeSets associated with each one
        if (CheckYear.contains(year)){ //We check if this TreeSet contains the entered year
            return SignName; //If is True Return the name of the sign, otherwise, move on to the next key an repeat the process
        }
    }
    return null; //If incorrect year, return null
    }
    /**
     * Returns True if the signs associated with two given birth years are compatible,
     * otherwise returns false.
     * @param year1 The first birth year.
     * @param year2 The second birth year.
     * @return True if the signs are compatible, false otherwise.
     */
    
    public boolean areMatches(int year1 , int year2) 
    {
        String Team1 = findSign(year1); //We call the findSign function to find the sign for each year.
        String Team2 = findSign(year2);
        ArrayList <String> CheckMatch = matches.get(Team1); //We access the Sign matches from the first year
            if(CheckMatch.contains(Team2)){ //Check if the second year's sign matches the first year's matches
                return true;
            }
        return false;
    }
    /**
     * Returns a collection of all years compatible with a chosen year
     * @param year The year to find compatible years for.
     * @return A TreeSet containing all compatible years.
     */
    
    public TreeSet<Integer> allYearMatches(int year)
    {
    String Team = findSign(year); //We call the findSign function to find the sign of the year
    ArrayList <String> MatchSigns = matches.get(Team); //We access the Sign matches
    TreeSet <Integer> allYears = new TreeSet<>(); //We created the TreeSet where we will store all the years of those two signs.
    for (String Match : MatchSigns){ 
        TreeSet<Integer> years = signs.get(Match);
        allYears.addAll(years); // Adds all of the elements in the specified collection to this set.
    }
    return allYears;
    }
    /**
     * This method generates a new TreeMap, where the Keys are the years,
     * and the values are TreeSets that contains Strings with the sign matches of those years.
     * @return A TreeMap mapping each year to its compatible signs.
     */
    public TreeMap<Integer , TreeSet<String>> matchesByYear() //This method generates a new TreeMap, where the Keys are the years, and the values ​​are TreeSets
    //that contains Strings with the sign matches of those years.
    {
     TreeMap<Integer, TreeSet<String>> list = new TreeMap<>(); // First we create the TreeMap that we will return
        for (String Names : signs.keySet()){  // We go through each sign on the map signs
        TreeSet <String> MatchSigns = new TreeSet<>(matches.get(Names)); //We access the Sign matches of each sign and create a new TreeSet with them
           for (Integer year : signs.get(Names)){ // We access each year in which the sign appears
               list.put(year , MatchSigns); //In the TreeMap generated at the beginning, we put this year as the key, and the new TreeSet with the year matches as the value
           }
        }
        return list; // Return the TreeMap
    }
    /**
     * Prints the compatible signs for a chosen year on separate lines.
     * @param year, The year to print compatible signs for.
     */
    public void printCompatibleSignsFor(int year)
    {
    TreeMap<Integer, TreeSet<String>> list = matchesByYear(); //Generate a TreeMap to identify matches for a given year, using the matchesByYear function
    System.out.println("Compatible signs for " +year+ " are:"); 
    for (String Match : list.get(year)){
    System.out.println(Match); //Browse through the TreeSet of the chosen year to print each match separately on different lines.
    }
    }
    
}