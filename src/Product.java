public class Product {
    private String title;
    private float price;
    private Category category;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Product setPrice(float price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }


    // calculate how much discount will set on the cart if the cost more than minumum cart price
    public float calculateDiscount(){
        Category tempCategory = category;
        // check product's category if there is discount set it if not check if there is parent category
        // do until return
        do {
            if (tempCategory.getCampaign() != null){
                return ( this.price * tempCategory.getCampaign().getDiscount() / 100 );
            }else {
                if (tempCategory.getParentCategory() != null){
                    tempCategory = tempCategory.getParentCategory();
                }else {
                    return this.price;
                }
            }
        }while(true);
    }


}
