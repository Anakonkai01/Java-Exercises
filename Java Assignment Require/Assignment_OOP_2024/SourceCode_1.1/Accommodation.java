abstract class Accommodation {
    protected int ID_Accommodation;
    protected String name_Accommodation;
    protected String address_Accommodation;
    protected String city_Accommodation;

    public Accommodation(int iD_Accommodation, String name_Accommodation, String address_Accommodation,
            String city_Accommodation) {
        this.ID_Accommodation = iD_Accommodation;
        this.name_Accommodation = name_Accommodation;
        this.address_Accommodation = address_Accommodation;
        this.city_Accommodation = city_Accommodation;
    }

    public int getID_Accommodation() {
        return ID_Accommodation;
    }

    public void setID_Accommodation(int iD_Accommodation) {
        ID_Accommodation = iD_Accommodation;
    }

    public String getName_Accommodation() {
        return name_Accommodation;
    }

    public void setName_Accommodation(String name_Accommodation) {
        this.name_Accommodation = name_Accommodation;
    }

    public String getAddress_Accommodation() {
        return address_Accommodation;
    }

    public void setAddress_Accommodation(String address_Accommodation) {
        this.address_Accommodation = address_Accommodation;
    }

    public String getCity_Accommodation() {
        return city_Accommodation;
    }

    public void setCity_Accommodation(String city_Accommodation) {
        this.city_Accommodation = city_Accommodation;
    }

    
}
