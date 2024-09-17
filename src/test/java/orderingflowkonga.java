import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class orderingflowkonga {
    private WebDriver driver;

    @BeforeTest
    public <JavascriptExecutor> void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open your chrome browser
        driver = new ChromeDriver();
        //input your konga url(https://www.konga.com)
        driver.get("https://www.konga.com");
        //Test 1: verify that the user input right url and is on the right webpage
        if (driver.getCurrentUrl().contains("konga.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(2000);
    }


    @Test(priority = 1)
    public void positivesignup() throws InterruptedException {
        //maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //click on login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        // input the email address on the email address field
        driver.findElement(By.name("username")).sendKeys("oluwabukunmiwonder@gmail.com");
        //input the password on the password field
        driver.findElement(By.name("password")).sendKeys("Won159");
        //click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        //Test 2: verify that when user clicks on the Login button the user is directed to the Login page
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void Search() throws InterruptedException {
        //Test 3: verify that an item is added successfully when user click on add to cart button
        //locate and click categories
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div/div[2]/div/a[1]")).click();
        //click on the Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(30000);
        //locate and click on the Laptop Subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(10000);
        //click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(10000);
        //click on an item
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/a[1]/picture/img")).click();
        Thread.sleep(20000);
        //add the item to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(10000);
        //clear pop-up
        driver.findElement(By.xpath("/html/div/div/div[1]/button/img")).click();
        Thread.sleep(10000);
        //locate checkout box
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]"));
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void checkout() throws InterruptedException {
        //Test 4: verify that an item is been checkout when user click on checkout button
        //click continue to checkout button
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[3]/div[3]/div/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        Thread.sleep(15000);
        //locate and click on Pay Now option
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(20000);
    }


    @Test(priority = 4)
    public void NegativePayment() throws InterruptedException {
        //Test 5: verify that an error message is displayed when user input invalid card details
        //locate and click on Continue with payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(20000);
        //select payment method by clicking on card
        driver.findElement(By.cssSelector("#channel-template > div.data-card__content > div > div:nth-child(3) > button")).click();
        // input invalid card number
        driver.findElement(By.id("card-number")).sendKeys("5643541865925490");
        // input expiry date
        driver.findElement(By.id("expiry")).sendKeys("0125");
        //input CVV
        driver.findElement(By.id("cvv")).sendKeys("900");
        //input card pin
        driver.findElement(By.id("card-pin-new")).sendKeys("0821");
        //click on Pay Now button
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(1000);
        //print out the error message
        System.out.println("card-number_unhappy");
        //close the iframe that displays the input card modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
    }

    @Test(priority = 5)
    public void negativesignup() throws InterruptedException {
        //maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //click on login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        // input the email address on the email address field
        driver.findElement(By.name("username")).sendKeys("");
        //input the password on the password field
        driver.findElement(By.name("password")).sendKeys("");
        //click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}


