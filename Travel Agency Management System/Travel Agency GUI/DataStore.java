import java.util.Arrays;

public class DataStore {
    private static String selectedPackType;
    private static String selectedPlace;  // Store the selected place name as a String
    private static String selectedDefaultPack;  // Store the selected default pack name as a String
    public static String[] selectedData = new String[9];  // Array to store the selected data

    // Setter method to store selected pack type
    public static void setSelectedPackType(String packType) {
        selectedPackType = packType;
        selectedData[0] = packType;  // Store in the array
        System.out.println("Selected Pack Type: " + selectedData[0]);
    }

    // Getter method to retrieve selected pack type
    public static String getSelectedPackType() {
        return selectedData[0];  // Return value from the array
    }

    // Setter method to store selected place
    public static void setSelectedPlace(String place) {
        selectedPlace = place;
        selectedData[1] = place;  // Store in the array
        System.out.println("Selected Place: " + selectedData[1]);
        System.out.println("default" + Arrays.toString(selectedData));

    }

    // Getter method to retrieve selected place
    public static String getSelectedPlace() {
        return selectedData[1];  // Return value from the array
    }

    // Setter method to store selected default pack
    public static void setSelectedDefPack(String defPack) {
        selectedDefaultPack = defPack;
        selectedData[2] = defPack;  // Store in the array
        System.out.println("Selected Default Pack: " + selectedData[2]);
    }

    // Getter method to retrieve selected default pack
    public static String getSelectedDefPack() {
        System.out.println(Arrays.toString(selectedData));
        return selectedData[2];  // Return value from the array
    }

    public static void loadUserData() {
        String[] userData = Login.getUserData();
    
        if (userData != null && userData.length > 0) {
            System.out.println("User Data: " + Arrays.toString(userData));
            
            int j=3;
            for(int i=0;i<6;i++){
                selectedData[j]=userData[i];
                j++;
            }
            System.out.println(Arrays.toString(selectedData));
        } else {
            System.out.println("User data not available.");
        }
    }
    
    
}
