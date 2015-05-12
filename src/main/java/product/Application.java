package product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);

        ProductDetail detail = new ProductDetail();
        detail.setProductId("ABCD1234");
        detail.setProductName("Dan's Book of Writing");
        detail.setShortDescription("A book about writing books.");
        detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
        detail.setInventoryId("009178461");

        ProductDetail detail2 = new ProductDetail();
        detail2.setProductId("ABCD1235");
        detail2.setProductName("Dan's Book of Writing 2");
        detail2.setShortDescription("A book about writing books 2.");
        detail2.setLongDescription("In this book about writing books, Dan will show you how to write a book 2.");
        detail2.setInventoryId("009178462");

        ProductDetailRepository repository = applicationContext.getBean(ProductDetailRepository.class);
        repository.save(detail);
        repository.save(detail2);

        for (ProductDetail productDetail : repository.findAll()) {
            System.out.println(productDetail.getProductId());
        }
    }
}