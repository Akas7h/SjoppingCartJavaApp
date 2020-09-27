package main;

/**
 * @author kaanozbudak
 * createdDate -> 27.09.2020
 */


public class Main {
    // main.Main function for project run
    public static Campaign createCampaign(int discount){
        return new Campaign().setDiscount(discount);
    }

    public static Category createCategory(String title, Category parentCategory, Campaign campaign){
        return new Category().setTitle(title).setParentCategory(parentCategory).setCampaign(campaign);
    }

    public static Product createProduct(String title, Category category, float price){
        return new Product().setTitle(title).setCategory(category).setPrice(price);
    }
    public static void main(String[] args) {
        Campaign campaignPercentFive = createCampaign(5);
        Campaign campaignPercentTen = createCampaign(10);

        // main.Category food does not have any parent or campaign so set null
        Category food = createCategory("food", null, null);

        // Create 2 different category which belong to another
        Category fruit = createCategory("fruit", food, campaignPercentFive);
        Category vegetable = createCategory("vegetable", food, campaignPercentTen);

        // Create 1 fruit
        Product apple = createProduct("apple", fruit, 100);
        System.out.println("Apple price: ");
        System.out.println(apple.getPrice());
        System.out.println("-----------------");

        // Create 1 vegetable
        Product carrot = createProduct("carrot", vegetable, 50);
        System.out.println("Carrot price: ");
        System.out.println(carrot.getPrice());
        System.out.println("-----------------");

        // Create first order builder and set 1 carrot and 1 apple
        Order first_order = Order.newBuilder().address("Istanbul/Sisli").username("user1").addToCart(carrot, 1)
                .addToCart(apple, 1).checkout();

        // First Order details
        System.out.println("First Order Owner: " + first_order.username);
        System.out.println("First Order Address: " + first_order.address);
        System.out.println("First Order Cost + Delivery Cost: " + first_order.finalAmount);
        System.out.println("Any discount: " + first_order.is_discounted);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Create order builder and set 10 carrots
        Order second_order = Order.newBuilder().address("Istanbul/Sariyer").username("user2").addToCart(carrot, 10)
                .checkout();

        // Second Order details
        System.out.println("Second Order Owner: " + second_order.username);
        System.out.println("Second Order Address: " + second_order.address);
        System.out.println("Second Order Cost + Delivery Cost: " + second_order.finalAmount);
        System.out.println("Any discount: " + second_order.is_discounted);
    }
}
