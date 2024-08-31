package productcrudapp.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(Model model){

        List<Product> products = productDao.getProducts();
        System.out.println("fectched : "+products);
        model.addAttribute("products", products);
        return "index";

    }

    @RequestMapping("/addProduct")
    public  String addProduct(){
        return "add_product";
    }

    @RequestMapping(value = "/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request){
        System.out.println("Product:  " + product);
        productDao.createProduct(product);
        RedirectView redirectView =  new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return  redirectView;
    }

    @RequestMapping(value = "/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request){
        productDao.deleteProduct(productId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return  redirectView;
    }

    @RequestMapping(value = "/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, Model model){
        Product product = productDao.getProduct(productId);
        model.addAttribute("product",product);
        return "UpdateScreen";
    }


}
