package utills.PetPOJO;

public class Pet {

    private long id;
    private Cat category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Cat getCategory() { return category; }
    public void setCategory(Cat category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String[] getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(String[] photoUrls) { this.photoUrls = photoUrls; }
    public Tag[] getTags() { return tags; }
    public void setTags(Tag[] tags) { this.tags = tags; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
