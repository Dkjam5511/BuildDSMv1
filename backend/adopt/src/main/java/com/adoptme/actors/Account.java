package com.adoptme.actors;

public abstract class Account{
        
        private String name;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String country;
        private String password;

        public Account(String name, String email, String phone, String address, String city, String state, String zip, String country, String password){
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.country = country;
            this.password = password;
        }
        
        public String getName(){
            return name;
        }
        
        public String getEmail(){
            return email;
        }
        
        public String getPhone(){
            return phone;
        }
        
        public String getAddress(){
            return address;
        }
        
        public String getCity(){
            return city;
        }
        
        public String getState(){
            return state;
        }
        
        public String getZip(){
            return zip;
        }
        
        public String getCountry(){
            return country;
        }
        
        public String getPassword(){
            return password;
        }
        
        
        
        public void setName(String name){
            this.name = name;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public void setPhone(String phone){
            this.phone = phone;
        }
        
        public void setAddress(String address){
            this.address = address;
        }
        
        public void setCity(String city){
            this.city = city;
        }
        
        public void setState(String state){
            this.state = state;
        }
        
        public void setZip(String zip){
            this.zip = zip;
        }
        
        public void setCountry(String country){
            this.country = country;
        }
        
        public void setPassword(String password){
            this.password = password;
        }
}