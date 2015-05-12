package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
    private final ProductDetailRepository repository;
    private final ProductDetailValidator validator;

    @Autowired
    public ProductDetailController(ProductDetailRepository repository, ProductDetailValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDetail create(@RequestBody @Valid ProductDetail detail) {
        return repository.save(detail);
    }
}