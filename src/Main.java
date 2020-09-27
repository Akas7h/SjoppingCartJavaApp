import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @author kaanozbudak
 * createdDate -> 27.09.2020
 */


public class Main {
    // Main function for project run
    public static void main(String[] args) {
        // create 2 different campaign with their percentage
        Campaign campaignPercentFive = new Campaign().setDiscount(5);
        Campaign campaignPercentTen = new Campaign().setDiscount(10);

        // Category food does not have any parent so set null
        Category food = new Category().setTitle("food").setParentCategory(null);

        // Create 2 different category which belong to another
        Category fruit = new Category().setTitle("fruit").setParentCategory(food).setCampaign(campaignPercentFive);
        Category vegetable = new Category().setTitle("vegetable").setParentCategory(food).setCampaign(campaignPercentTen);

        // Create 1 fruit
        Product apple = new Product().setTitle("apple").setPrice(100).setCategory(fruit);
        System.out.println("Apple price: ");
        System.out.println(apple.getPrice());
        System.out.println("-----------------");

        // Create 1 vegetable
        Product carrot = new Product().setTitle("carrot").setPrice(50).setCategory(vegetable);
        System.out.println("Carrot price: ");
        System.out.println(carrot.getPrice());
        System.out.println("-----------------");

        // Create firset order builder and set 1 carrot and 1 apple
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
