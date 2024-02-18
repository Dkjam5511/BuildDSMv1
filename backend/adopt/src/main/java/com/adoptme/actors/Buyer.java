package src.main.java.com.adoptme.actors;
import java.util.List;


public class Buyer extends Account{
        
        private String role;
        private String reviews;
        private Dogs[] dogs;
        
        public Buyer(String name, String email, String phone, String address, String city, String state, String zip, String country, String password){
            super(name, email, phone, address, city, state, zip, country, password);
            role = "Buyer";
        }
    
    
}