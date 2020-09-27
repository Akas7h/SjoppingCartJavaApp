public class Category {
    private String title;
    private Category parentCategory;
    private Campaign campaign;


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public Category setTitle(String title) {
        this.title = title;
        return this;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public Category setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public Category setCampaign(Campaign campaign) {
        this.campaign = campaign;
        return this;
    }
}
