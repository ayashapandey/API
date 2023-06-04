

package Gametimerpackage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GameTimerClass {
   static WebDriver driver;


   public static void setdriver() {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver = new ChromeDriver(options);
       driver.manage().window().maximize();
   }


   @SuppressWarnings("deprecation")
   public static void login(String username, String password) throws InterruptedException {
       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       driver.get("https://jwradmin:kwSTD59rYM0SONQYzesS@rum8-config.jungleerummyqa.com/admin");
       driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
       // Navigating to Server Config Web Page
       driver.findElement(By.xpath("//*[@id=\"gwt-uid-3\"]")).sendKeys("ayasha");
       driver.findElement(By.xpath("//*[@id=\"gwt-uid-5\"]")).sendKeys("123456");
       driver.findElement(By.xpath("(//div[@role='button'])[2]")).click(); // Login Button
       driver.findElement(By.xpath("(//span[@class='v-menubar-menuitem'])[4]")).click(); // Product config
       driver.findElement(By.xpath("(//span[@class='v-menubar-menuitem'])[30]")).click(); // Game timer Config
   }


   private static void userValue() {
       //String ConfigGrp = "game.result.reduced.composition";
       //Object value = "myNewValue";
	   GametimerClass("Point","points.2s.TableJoinFreeze","6000");
   }


   public static void main(String[] args) throws InterruptedException {
       setdriver();
       login("ayasha", "123456");
       userValue();
   }
   private static void GametimerClass(String GameType, String key, Object Value) {

       List<WebElement> GameVariant = driver.findElements(By.xpath("//table[@class='v-table-table']")); // control of all tables
       System.out.println("Number of game variants : " + GameVariant.size());
       for (WebElement ele : GameVariant) {

           String gameTypeName = ele.findElement(By.xpath("//span[contains(text(),'Point')]")).getText(); //Point,, Deal,, Pool,
           //if(gameTypeName.equalsIgnoreCase(GameType)) {
           if(gameTypeName.equalsIgnoreCase(GameType))
           {
               List<WebElement> keyNames = ele.findElements(By.xpath("//div[3]/div/div/div[1]/div/div[2]")); //list of all the keys available
               System.out.println("Number of elements : " + keyNames.size());
               
               for (WebElement keyNameElement : keyNames) 
               {
//                   System.out.println("Key name" +keyNameElement.getText());
//                   System.out.println("Key name1" +keyNameElement.getText().equalsIgnoreCase(key));
                // if(keyNameElement.getText().equalsIgnoreCase(key)) 
                  {
                   if(keyNameElement.getText().indexOf(key)!=0) 
                   {
                       if(Value instanceof Boolean) 
                       {

                           WebElement REDUCETIMERENABLED = driver.findElement(By.xpath("input[type='checkbox']+label"));
                           String Status = REDUCETIMERENABLED.getText().trim();
                           if (!Status.equalsIgnoreCase("Enabled")) 
                           {

                               click(REDUCETIMERENABLED, "cash free checkbox");
                           }
                       } 
                       else if (Value instanceof String) 
                       {
                               WebElement Valuepoints2s = driver.findElement(By.xpath("//div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/input"));
                              // WebElement Valuepoints6s = driver.findElement(By.xpath("//div[contains(text(),'points.6s.TableJoinFreeze')]"));
                               enterText(Valuepoints2s, (String) Value);
                               //enterText(Valuepoints6s, "Value Ponits.6s");
                           }
                           WebElement SAVE_BUTTON = driver.findElement(By.xpath("//tr[1]/td[3]/div/div"));
                           click(SAVE_BUTTON , "Save Button");
                           break;


                       //driver.findElement(By.xpath("//td[3]/div/div")).click();
                   } else { 
                	   System.out.println("key does not exists");
                	   break;
                	   }
                  }
               }
           }
       }
   }


   private static void enterText(WebElement Element,String EnterText) {
       Element.clear();
       Element.sendKeys(EnterText);
       System.out.println("Successfully Enterned Text on "+EnterText);
   }


   private static void click(WebElement Element,String ElementName) {
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
       Element.click();
       System.out.println("Successfully Clicked on "+ElementName);
   }
}




/*WebElement Table = driver.findElement(By.xpath("//table[@class='v-table-table']"));
     @SuppressWarnings("unused")
     List<WebElement> rows = Table.findElements(By.xpath("//tr[contains(@class,'v-table-row')]"));
     //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Table);
     @SuppressWarnings("unused")
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
     driver.findElement(By.xpath("//table[@class='v-table-table']/tbody/tr[1]"));
     driver.findElement(By.xpath("//input[@id ='gwt-uid-3']/following-sibling::label")).click();
     driver.findElement(By.xpath("//tr[1]/td[3]/div/div")).click();
     WebElement Text = driver.findElement(By.xpath("//tr[2]/td[2]/div/input"));
     Text.clear();
     Text.sendKeys("50");
     driver.findElement(By.xpath("//tr[2]/td[3]/div/div")).click();*/
































/*//driver.findElement(By.xpath("//input[@id ='gwt-uid-4']")).clear();
     //driver.findElement(By.xpath("//input[@id ='gwt-uid-4']")).sendKeys(ConfigGrp); // Search Config


      * try { Thread.sleep(1000); } catch (InterruptedException e1) {
      * e1.printStackTrace(); }


     WebElement firstRow = driver.findElement(By.xpath("//table[@class='v-table-table']/tbody/tr[1]"));


        WebElement cells1 = driver.findElement(By.xpath("//input[@id ='gwt-uid-3']"));
        cells1.getSize();
         System.out.println(cells1 +"Test1");
     //WebElement valueCell = firstRow.findElement(By.xpath("//input[@id ='gwt-uid-3']"));


     //List<WebElement> cells = firstRow.findElements(By.tagName("td"));


      * while (firstRow != null) { cells = firstRow.findElements(By.tagName("td"));
      * WebElement saveButton = cells.get(1); if
      * ((cells.get(1).getText().equals(ConfigGrp))) { WebElement valueCell;
      * System.out.println(cells.get(1).getText()); if (value instanceof String) {
      * System.out.println("It's a string!");


     // Check if the calender button is present or not


      * boolean isExisitng = false; try { WebElement button =
      * driver.findElement(By.xpath(".//td[3]/div/div/input")); isExisitng =
      * button.isDisplayed(); System.out.println("Button is present."); } catch
      * (Exception e) { } if (isExisitng) { valueCell =
      * firstRow.findElement(By.xpath(".//td[3]/div/div/input")); DateTime(value,
      * valueCell); // 11/10/2021, 21:28 } else {
      * System.out.println("Button is not present."); valueCell =
      * firstRow.findElement(By.xpath(".//td[3]/div/input")); TextValue(value,
      * valueCell); } // wait = new WebDriverWait(driver,Duration.ofSeconds(600)); //
      * wait.until(ExpectedConditions.elementToBeClickable(saveButton)); try {
      * Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }


     //saveButton.click();}


      * if (value instanceof Boolean) {
      *
      * CheckboxValue((Boolean) value, valueCell); wait = new WebDriverWait(driver,
      * Duration.ofSeconds(6000)); By saveButton = null;
      * wait.until(ExpectedConditions.elementToBeClickable(saveButton)); }


     //By saveButton = null;
     //wait.until(ExpectedConditions.elementToBeClickable(saveButton));
     // try {
     // Thread.sleep(1000);
     // } catch (InterruptedException e) {
     // e.printStackTrace();
     // }
     //((WebElement) saveButton).click();
     //break;
     }
     }


      * WebElement Table =
      * driver.findElement(By.xpath("//table[@class='v-table-table']"));
      * List<WebElement> rows =
      * Table.findElements(By.xpath("//tr[contains(@class,'v-table-row')]"));
      * rows.size(); WebDriverWait wait = new WebDriverWait(driver,
      * Duration.ofSeconds(10000)); WebElement firstRow =
      * driver.findElement(By.xpath("//table[@class='v-table-table']/tbody/tr[1]"));
      * List<WebElement> cells = firstRow.findElements(By.tagName("tr"));
      * //System.out.println("test"+cells.listIterator()); //while (firstRow != null)
      * { //WebElement cells1 = driver.findElement(By.xpath(
      * "//*[@id=\"admin-92668751\"]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/span/label"
      * )); WebElement saveButton = cells.get(1);
      * //System.out.println(cells.get(1).getText()+"Test");
      * //wait.until(ExpectedConditions.elementToBeClickable(saveButton));
      * ((WebElement) cells).click(); Boolean test= ((WebElement) cells).isEnabled();
      * System.out.println(test+"Test1");


        //WebElement valueCell = firstRow.findElement(By.xpath(".//td[2]/div/span/label"));
        if (value instanceof Boolean) {
           WebElement valueCell = firstRow.findElement(By.xpath(".//td[2]/div/span/label"));
           CheckboxValue((Boolean) value, valueCell);
           wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
           wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        }
        //System.out.println(cells.get(1).getText() + "Test");


        // System.out.println(cells.get(1).getText());
        //if ((cells.get(1).getText().equals(ConfigGrp))) {
        //WebElement valueCell;
        //if (value instanceof String) {
        //System.out.println("It's a string!");
        //valueCell = firstRow.findElement(By.xpath(".//td[2]/div/span/label"));
        //TextValue(value, valueCell);


        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        //saveButton.click();


*/


//Ayasha


//KumariAyashaPandey




